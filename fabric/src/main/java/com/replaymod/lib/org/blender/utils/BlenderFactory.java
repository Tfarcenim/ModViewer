package com.replaymod.lib.org.blender.utils;

import com.replaymod.lib.org.blender.dna.FileGlobal;
import com.replaymod.lib.org.cakelab.blender.io.BlenderFile;
import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockCodes;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.io.dna.internal.StructDNA;
import com.replaymod.lib.org.cakelab.blender.utils.BlenderFactoryBase;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BlenderFactory extends BlenderFactoryBase {
   protected static StructDNA sdna;

   public BlenderFactory(BlenderFile blend) throws IOException {
      super(blend);
   }

   public static FileGlobal getFileGlobal(BlenderFile blend) throws IOException {
      BlockTable blockTable = blend.getBlockTable();
      List<Block> globalBlock = blockTable.getBlocks(BlockCodes.ID_GLOB);
      FileGlobal fileGlobal = null;
      if (globalBlock.size() == 1) {
         Block b = (Block)globalBlock.get(0);
         fileGlobal = new FileGlobal(b.header.getAddress(), b, blockTable);
      }

      return fileGlobal;
   }

   public FileGlobal getFileGlobal() throws IOException {
      return getFileGlobal(this.blend);
   }

   public static BlenderFile newBlenderFile(File file) throws IOException {
      StructDNA sdna = getStructDNA();
      BlenderFactory.BlenderFileImpl blend = new BlenderFactory.BlenderFileImpl(file, sdna, 279);
      return blend;
   }

   public static StructDNA getStructDNA() throws IOException {
      if (sdna == null) {
         sdna = createStructDNA("com/replaymod/lib/org/blender/utils/resources/sdna.blend");
      }

      return sdna;
   }

   static class BlenderFileImpl extends BlenderFactoryBase.BlenderFileImplBase {
      private FileGlobal global;

      protected BlenderFileImpl(File file, StructDNA sdna, int blenderVersion) throws IOException {
         super(file, sdna, blenderVersion);
         BlockTable blockTable = this.getBlockTable();
         Block block = blockTable.allocate(BlockCodes.ID_GLOB, FileGlobal.__io__sizeof(FileGlobal.class, this.getEncoding().getAddressWidth()), 264, 1);
         this.global = new FileGlobal(block.header.getAddress(), block, blockTable);
         String filename = file.getCanonicalPath();
         this.global.getFilename().fromString(filename);
         this.global.setMinsubversion((short)6);
         this.global.setMinversion((short)270);
         this.global.setSubversion((short)0);
         this.add(block);
      }
   }
}
