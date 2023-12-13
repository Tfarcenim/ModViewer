package com.replaymod.lib.org.cakelab.blender.io;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockCodes;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockHeader;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockList;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.io.block.OverlappingBlocksException;
import com.replaymod.lib.org.cakelab.blender.io.dna.DNAModel;
import com.replaymod.lib.org.cakelab.blender.io.dna.DNAStruct;
import com.replaymod.lib.org.cakelab.blender.io.dna.internal.StructDNA;
import com.replaymod.lib.org.cakelab.blender.io.util.CDataReadWriteAccess;
import com.replaymod.lib.org.cakelab.blender.io.util.Identifier;
import com.replaymod.lib.org.cakelab.blender.metac.CMetaModel;
import com.replaymod.lib.org.cakelab.blender.metac.CStruct;
import com.replaymod.lib.org.cakelab.blender.versions.OffheapAreas;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BlenderFile implements Closeable {
   protected FileHeader header;
   protected CDataReadWriteAccess io;
   protected long firstBlockOffset;
   private StructDNA sdna;
   private DNAModel model;
   private BlockTable blockTable;
   private BlockList blocks;
   private File file;

   public BlenderFile(File file) throws IOException {
      this.readFileHeader(CDataReadWriteAccess.create(new RandomAccessFile(file, "r"), Encoding.JAVA_NATIVE));
      this.file = file;
      this.io = CDataReadWriteAccess.create(new RandomAccessFile(file, "rw"), this.getEncoding());
      this.readStructDNA();
      String[] offheapAreas = OffheapAreas.get(this.header.version.getCode());
      this.initBlockTable(this.getEncoding(), this.readBlocks(), this.getSdnaIndices(offheapAreas));
   }

   protected BlenderFile(File file, StructDNA sdna, int blenderVersion, String[] offheapAreas) throws IOException {
      this(file, sdna, blenderVersion, Encoding.nativeEncoding(), offheapAreas);
   }

   protected BlenderFile(File file, StructDNA sdna, int blenderVersion, Encoding encoding, String[] offheapAreas) throws IOException {
      this.sdna = sdna;
      this.io = CDataReadWriteAccess.create(new RandomAccessFile(file, "rw"), encoding);
      this.header = new FileHeader();
      this.header.endianess = FileHeader.Endianess.from(this.io.getByteOrder());
      this.header.pointerSize = FileHeader.PointerSize.from(this.io.getPointerSize());
      this.header.version = new FileHeader.Version(blenderVersion);
      this.header.write(this.io);
      this.firstBlockOffset = this.io.offset();
      this.blocks = new BlockList();
      this.initBlockTable(this.getEncoding(), this.blocks, this.getSdnaIndices(offheapAreas));
   }

   private void initBlockTable(Encoding encoding, BlockList blocks, int[] sdnaIndices) throws IOException {
      try {
         this.blockTable = new BlockTable(encoding, blocks, sdnaIndices);
      } catch (OverlappingBlocksException var5) {
         var5.addDetailedInfo(this.model);
         throw new IOException(var5);
      }
   }

   protected BlenderFile() {
   }

   protected void readFileHeader(CDataReadWriteAccess in) throws IOException {
      this.header = new FileHeader();

      try {
         this.header.read(in);
         this.firstBlockOffset = in.offset();
         in.close();
      } catch (IOException var10) {
         throw new IOException("file is either corrupted or uses the compressed format (not yet supported).\nIn the latter case, please uncompress it first (i.e. gunzip <file>.");
      } finally {
         try {
            in.close();
         } catch (Throwable var9) {
         }

      }

   }

   protected int[] getSdnaIndices(String[] structNames) throws IOException {
      if (structNames == null) {
         return null;
      } else {
         this.model = this.getBlenderModel();
         int[] indexes = new int[structNames.length];
         int length = 0;
         String[] var4 = structNames;
         int var5 = structNames.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            String structName = var4[var6];
            DNAStruct struct = this.model.getStruct(structName);
            if (struct == null) {
               System.err.println("warning: The list of offheap areas (see Java .Blend documentation) contains a struct name '" + structName + "' which does not exist in the blender version of the given file. This entry will be ignored.");
            } else {
               indexes[length++] = struct.getIndex();
            }
         }

         return Arrays.copyOf(indexes, length);
      }
   }

   public void write() throws IOException {
      this.write(this.blocks);
   }

   public void write(List<Block> blocks) throws IOException {
      this.io.offset(this.firstBlockOffset);
      boolean sdnaWritten = false;
      Block endBlock = null;
      this.io.offset(this.firstBlockOffset);
      Iterator var4 = blocks.iterator();

      while(var4.hasNext()) {
         Block block = (Block)var4.next();
         System.out.println("writing " + block.header.getCode().toString());
         if (block.header.getCode().equals(BlockCodes.ID_ENDB)) {
            endBlock = block;
         } else {
            block.flush(this.io);
            if (block.header.getCode().equals(BlockCodes.ID_DNA1)) {
               sdnaWritten = true;
            }
         }
      }

      if (!sdnaWritten) {
         this.writeSdnaBlock();
      }

      if (endBlock != null) {
         endBlock.flush(this.io);
      } else {
         this.writeEndBlock();
      }

   }

   protected void writeEndBlock() throws IOException {
      BlockHeader endb = new BlockHeader(BlockCodes.ID_ENDB, 0, 0L, 0, 0);
      endb.write(this.io);
   }

   protected void writeSdnaBlock() throws IOException {
      long headerOffset = this.io.offset();
      BlockHeader header = new BlockHeader();
      header.write(this.io);
      long dataOffset = this.io.offset();
      this.sdna.write(this.io);
      long end = this.io.offset();
      int size = (int)(end - dataOffset);
      long address = this.blockTable.getAllocator().alloc((long)size);
      int sdnaIndex = 0;
      int count = 1;
      header = new BlockHeader(BlockCodes.ID_DNA1, size, address, sdnaIndex, count);
      this.io.offset(headerOffset);
      header.write(this.io);
      this.io.offset(end);
   }

   public DNAModel getBlenderModel() throws IOException {
      if (this.model == null) {
         this.model = new DNAModel(this.sdna);
      }

      return this.model;
   }

   public FileVersionInfo readFileGlobal() throws IOException {
      CMetaModel meta = this.getMetaModel();
      FileVersionInfo versionInfo = null;
      BlockHeader blockHeader = this.seekFirstBlock(BlockCodes.ID_GLOB);
      if (blockHeader != null) {
         CStruct struct = (CStruct)meta.getType("FileGlobal");
         versionInfo = new FileVersionInfo();
         versionInfo.read(struct, this.io);
         versionInfo.version = this.header.version;
         return versionInfo;
      } else {
         throw new IOException("Can't find block GLOB (file global version info)");
      }
   }

   protected void readStructDNA() throws IOException {
      this.sdna = null;
      BlockHeader blockHeader = this.seekFirstBlock(BlockCodes.ID_DNA1);
      if (blockHeader != null) {
         this.sdna = new StructDNA();
         this.sdna.read(this.io);
      } else {
         throw new IOException("corrupted file. Can't find block DNA1");
      }
   }

   public BlockHeader seekFirstBlock(Identifier code) throws IOException {
      BlockHeader result = null;
      this.io.offset(this.firstBlockOffset);
      BlockHeader blockHeader = new BlockHeader();
      blockHeader.read(this.io);

      while(!blockHeader.getCode().equals(BlockCodes.ID_ENDB)) {
         if (blockHeader.getCode().equals(code)) {
            result = blockHeader;
            break;
         }

         this.io.skip((long)blockHeader.getSize());
         blockHeader.read(this.io);
      }

      return result;
   }

   public BlockTable getBlockTable() throws IOException {
      return this.blockTable;
   }

   private BlockList readBlocks() throws IOException {
      this.blocks = new BlockList();
      this.io.offset(this.firstBlockOffset);
      BlockHeader blockHeader = new BlockHeader();
      blockHeader.read(this.io);

      while(!blockHeader.getCode().equals(BlockCodes.ID_ENDB)) {
         CDataReadWriteAccess data = this.readBlockData(blockHeader);
         Block block = new Block(blockHeader, data);
         this.blocks.add(block);
         blockHeader = new BlockHeader();
         blockHeader.read(this.io);
      }

      return this.blocks;
   }

   private CDataReadWriteAccess readBlockData(BlockHeader blockHeader) throws IOException {
      byte[] data = new byte[blockHeader.getSize()];
      this.io.readFully(data);
      return CDataReadWriteAccess.create(data, blockHeader.getAddress(), this.getEncoding());
   }

   public void close() throws IOException {
      this.io.close();
      this.io = null;
   }

   public Encoding getEncoding() {
      return Encoding.get(this.header.getByteOrder(), this.header.getPointerSize());
   }

   public CMetaModel getMetaModel() throws IOException {
      return new CMetaModel(this.getBlenderModel());
   }

   public FileHeader.Version getVersion() {
      return this.header.version;
   }

   public StructDNA getStructDNA() {
      return this.sdna;
   }

   public BlockList getBlocks() {
      return this.blocks;
   }

   public void add(Block block) {
      this.blocks.add(block);
   }

   public File getFile() {
      return this.file;
   }
}
