package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1884L,
   size64 = 1992L
)
public class Image extends CFacade {
   public static final int __DNA__SDNA_INDEX = 31;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__name = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__cache = new long[]{1124L, 1144L};
   public static final long[] __DNA__FIELD__gputexture = new long[]{1128L, 1152L};
   public static final long[] __DNA__FIELD__anims = new long[]{1136L, 1168L};
   public static final long[] __DNA__FIELD__rr = new long[]{1144L, 1184L};
   public static final long[] __DNA__FIELD__renders = new long[]{1148L, 1192L};
   public static final long[] __DNA__FIELD__render_slot = new long[]{1180L, 1256L};
   public static final long[] __DNA__FIELD__last_render_slot = new long[]{1182L, 1258L};
   public static final long[] __DNA__FIELD__flag = new long[]{1184L, 1260L};
   public static final long[] __DNA__FIELD__source = new long[]{1188L, 1264L};
   public static final long[] __DNA__FIELD__type = new long[]{1190L, 1266L};
   public static final long[] __DNA__FIELD__lastframe = new long[]{1192L, 1268L};
   public static final long[] __DNA__FIELD__tpageflag = new long[]{1196L, 1272L};
   public static final long[] __DNA__FIELD__totbind = new long[]{1198L, 1274L};
   public static final long[] __DNA__FIELD__xrep = new long[]{1200L, 1276L};
   public static final long[] __DNA__FIELD__yrep = new long[]{1202L, 1278L};
   public static final long[] __DNA__FIELD__twsta = new long[]{1204L, 1280L};
   public static final long[] __DNA__FIELD__twend = new long[]{1206L, 1282L};
   public static final long[] __DNA__FIELD__bindcode = new long[]{1208L, 1284L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{1216L, 1292L};
   public static final long[] __DNA__FIELD__repbind = new long[]{1220L, 1296L};
   public static final long[] __DNA__FIELD__packedfile = new long[]{1224L, 1304L};
   public static final long[] __DNA__FIELD__packedfiles = new long[]{1228L, 1312L};
   public static final long[] __DNA__FIELD__preview = new long[]{1236L, 1328L};
   public static final long[] __DNA__FIELD__lastupdate = new long[]{1240L, 1336L};
   public static final long[] __DNA__FIELD__lastused = new long[]{1244L, 1340L};
   public static final long[] __DNA__FIELD__animspeed = new long[]{1248L, 1344L};
   public static final long[] __DNA__FIELD__ok = new long[]{1250L, 1346L};
   public static final long[] __DNA__FIELD__gen_x = new long[]{1252L, 1348L};
   public static final long[] __DNA__FIELD__gen_y = new long[]{1256L, 1352L};
   public static final long[] __DNA__FIELD__gen_type = new long[]{1260L, 1356L};
   public static final long[] __DNA__FIELD__gen_flag = new long[]{1261L, 1357L};
   public static final long[] __DNA__FIELD__gen_depth = new long[]{1262L, 1358L};
   public static final long[] __DNA__FIELD__gen_color = new long[]{1264L, 1360L};
   public static final long[] __DNA__FIELD__aspx = new long[]{1280L, 1376L};
   public static final long[] __DNA__FIELD__aspy = new long[]{1284L, 1380L};
   public static final long[] __DNA__FIELD__colorspace_settings = new long[]{1288L, 1384L};
   public static final long[] __DNA__FIELD__alpha_mode = new long[]{1352L, 1448L};
   public static final long[] __DNA__FIELD__pad = new long[]{1353L, 1449L};
   public static final long[] __DNA__FIELD__eye = new long[]{1358L, 1454L};
   public static final long[] __DNA__FIELD__views_format = new long[]{1359L, 1455L};
   public static final long[] __DNA__FIELD__views = new long[]{1360L, 1456L};
   public static final long[] __DNA__FIELD__stereo3d_format = new long[]{1368L, 1472L};
   public static final long[] __DNA__FIELD__render_slots = new long[]{1372L, 1480L};

   public Image(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Image(Image that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ID getId() throws IOException {
      return this.__io__pointersize == 8 ? new ID(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ID(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setId(ID id) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(id, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, id)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, id);
         } else {
            __io__generic__copy(this.getId(), id);
         }

      }
   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 120L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 100L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public CPointer<Object> getCache() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setCache(CPointer<Object> cache) throws IOException {
      long __address = cache == null ? 0L : cache.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1124L, __address);
      }

   }

   public CArrayFacade<CPointer<Object>> getGputexture() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Object.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1152L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setGputexture(CArrayFacade<CPointer<Object>> gputexture) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1152L;
      } else {
         __dna__offset = 1128L;
      }

      if (!this.__io__equals(gputexture, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gputexture)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gputexture);
         } else {
            __io__generic__copy(this.getGputexture(), gputexture);
         }

      }
   }

   public ListBase getAnims() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1168L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1136L, this.__io__block, this.__io__blockTable);
   }

   public void setAnims(ListBase anims) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1168L;
      } else {
         __dna__offset = 1136L;
      }

      if (!this.__io__equals(anims, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, anims)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, anims);
         } else {
            __io__generic__copy(this.getAnims(), anims);
         }

      }
   }

   public CPointer<Object> getRr() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1144L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setRr(CPointer<Object> rr) throws IOException {
      long __address = rr == null ? 0L : rr.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1144L, __address);
      }

   }

   public CArrayFacade<CPointer<Object>> getRenders() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Object.class};
      int[] __dna__dimensions = new int[]{8};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1192L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1148L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRenders(CArrayFacade<CPointer<Object>> renders) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1192L;
      } else {
         __dna__offset = 1148L;
      }

      if (!this.__io__equals(renders, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, renders)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, renders);
         } else {
            __io__generic__copy(this.getRenders(), renders);
         }

      }
   }

   public short getRender_slot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1256L) : this.__io__block.readShort(this.__io__address + 1180L);
   }

   public void setRender_slot(short render_slot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1256L, render_slot);
      } else {
         this.__io__block.writeShort(this.__io__address + 1180L, render_slot);
      }

   }

   public short getLast_render_slot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1258L) : this.__io__block.readShort(this.__io__address + 1182L);
   }

   public void setLast_render_slot(short last_render_slot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1258L, last_render_slot);
      } else {
         this.__io__block.writeShort(this.__io__address + 1182L, last_render_slot);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1260L) : this.__io__block.readInt(this.__io__address + 1184L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1260L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 1184L, flag);
      }

   }

   public short getSource() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1264L) : this.__io__block.readShort(this.__io__address + 1188L);
   }

   public void setSource(short source) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1264L, source);
      } else {
         this.__io__block.writeShort(this.__io__address + 1188L, source);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1266L) : this.__io__block.readShort(this.__io__address + 1190L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1266L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 1190L, type);
      }

   }

   public int getLastframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1268L) : this.__io__block.readInt(this.__io__address + 1192L);
   }

   public void setLastframe(int lastframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1268L, lastframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 1192L, lastframe);
      }

   }

   public short getTpageflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1272L) : this.__io__block.readShort(this.__io__address + 1196L);
   }

   public void setTpageflag(short tpageflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1272L, tpageflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 1196L, tpageflag);
      }

   }

   public short getTotbind() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1274L) : this.__io__block.readShort(this.__io__address + 1198L);
   }

   public void setTotbind(short totbind) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1274L, totbind);
      } else {
         this.__io__block.writeShort(this.__io__address + 1198L, totbind);
      }

   }

   public short getXrep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1276L) : this.__io__block.readShort(this.__io__address + 1200L);
   }

   public void setXrep(short xrep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1276L, xrep);
      } else {
         this.__io__block.writeShort(this.__io__address + 1200L, xrep);
      }

   }

   public short getYrep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1278L) : this.__io__block.readShort(this.__io__address + 1202L);
   }

   public void setYrep(short yrep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1278L, yrep);
      } else {
         this.__io__block.writeShort(this.__io__address + 1202L, yrep);
      }

   }

   public short getTwsta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1280L) : this.__io__block.readShort(this.__io__address + 1204L);
   }

   public void setTwsta(short twsta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1280L, twsta);
      } else {
         this.__io__block.writeShort(this.__io__address + 1204L, twsta);
      }

   }

   public short getTwend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1282L) : this.__io__block.readShort(this.__io__address + 1206L);
   }

   public void setTwend(short twend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1282L, twend);
      } else {
         this.__io__block.writeShort(this.__io__address + 1206L, twend);
      }

   }

   public CArrayFacade<Integer> getBindcode() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1284L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1208L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBindcode(CArrayFacade<Integer> bindcode) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1284L;
      } else {
         __dna__offset = 1208L;
      }

      if (!this.__io__equals(bindcode, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, bindcode)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, bindcode);
         } else {
            __io__generic__copy(this.getBindcode(), bindcode);
         }

      }
   }

   public CArrayFacade<Byte> getPad1() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1292L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1216L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad1(CArrayFacade<Byte> pad1) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1292L;
      } else {
         __dna__offset = 1216L;
      }

      if (!this.__io__equals(pad1, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad1)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad1);
         } else {
            __io__generic__copy(this.getPad1(), pad1);
         }

      }
   }

   public CPointer<Integer> getRepbind() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1296L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1220L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setRepbind(CPointer<Integer> repbind) throws IOException {
      long __address = repbind == null ? 0L : repbind.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1296L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1220L, __address);
      }

   }

   public CPointer<PackedFile> getPackedfile() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1304L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1224L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PackedFile.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 20), this.__io__blockTable);
   }

   public void setPackedfile(CPointer<PackedFile> packedfile) throws IOException {
      long __address = packedfile == null ? 0L : packedfile.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1304L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1224L, __address);
      }

   }

   public ListBase getPackedfiles() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1312L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1228L, this.__io__block, this.__io__blockTable);
   }

   public void setPackedfiles(ListBase packedfiles) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1312L;
      } else {
         __dna__offset = 1228L;
      }

      if (!this.__io__equals(packedfiles, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, packedfiles)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, packedfiles);
         } else {
            __io__generic__copy(this.getPackedfiles(), packedfiles);
         }

      }
   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1328L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1236L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1328L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1236L, __address);
      }

   }

   public float getLastupdate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1336L) : this.__io__block.readFloat(this.__io__address + 1240L);
   }

   public void setLastupdate(float lastupdate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1336L, lastupdate);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1240L, lastupdate);
      }

   }

   public int getLastused() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1340L) : this.__io__block.readInt(this.__io__address + 1244L);
   }

   public void setLastused(int lastused) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1340L, lastused);
      } else {
         this.__io__block.writeInt(this.__io__address + 1244L, lastused);
      }

   }

   public short getAnimspeed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1344L) : this.__io__block.readShort(this.__io__address + 1248L);
   }

   public void setAnimspeed(short animspeed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1344L, animspeed);
      } else {
         this.__io__block.writeShort(this.__io__address + 1248L, animspeed);
      }

   }

   public short getOk() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1346L) : this.__io__block.readShort(this.__io__address + 1250L);
   }

   public void setOk(short ok) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1346L, ok);
      } else {
         this.__io__block.writeShort(this.__io__address + 1250L, ok);
      }

   }

   public int getGen_x() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1348L) : this.__io__block.readInt(this.__io__address + 1252L);
   }

   public void setGen_x(int gen_x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1348L, gen_x);
      } else {
         this.__io__block.writeInt(this.__io__address + 1252L, gen_x);
      }

   }

   public int getGen_y() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1352L) : this.__io__block.readInt(this.__io__address + 1256L);
   }

   public void setGen_y(int gen_y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1352L, gen_y);
      } else {
         this.__io__block.writeInt(this.__io__address + 1256L, gen_y);
      }

   }

   public byte getGen_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1356L) : this.__io__block.readByte(this.__io__address + 1260L);
   }

   public void setGen_type(byte gen_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1356L, gen_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 1260L, gen_type);
      }

   }

   public byte getGen_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1357L) : this.__io__block.readByte(this.__io__address + 1261L);
   }

   public void setGen_flag(byte gen_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1357L, gen_flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 1261L, gen_flag);
      }

   }

   public short getGen_depth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1358L) : this.__io__block.readShort(this.__io__address + 1262L);
   }

   public void setGen_depth(short gen_depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1358L, gen_depth);
      } else {
         this.__io__block.writeShort(this.__io__address + 1262L, gen_depth);
      }

   }

   public CArrayFacade<Float> getGen_color() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1360L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1264L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setGen_color(CArrayFacade<Float> gen_color) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1360L;
      } else {
         __dna__offset = 1264L;
      }

      if (!this.__io__equals(gen_color, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gen_color)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gen_color);
         } else {
            __io__generic__copy(this.getGen_color(), gen_color);
         }

      }
   }

   public float getAspx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1376L) : this.__io__block.readFloat(this.__io__address + 1280L);
   }

   public void setAspx(float aspx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1376L, aspx);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1280L, aspx);
      }

   }

   public float getAspy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1380L) : this.__io__block.readFloat(this.__io__address + 1284L);
   }

   public void setAspy(float aspy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1380L, aspy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1284L, aspy);
      }

   }

   public ColorManagedColorspaceSettings getColorspace_settings() throws IOException {
      return this.__io__pointersize == 8 ? new ColorManagedColorspaceSettings(this.__io__address + 1384L, this.__io__block, this.__io__blockTable) : new ColorManagedColorspaceSettings(this.__io__address + 1288L, this.__io__block, this.__io__blockTable);
   }

   public void setColorspace_settings(ColorManagedColorspaceSettings colorspace_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1384L;
      } else {
         __dna__offset = 1288L;
      }

      if (!this.__io__equals(colorspace_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, colorspace_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, colorspace_settings);
         } else {
            __io__generic__copy(this.getColorspace_settings(), colorspace_settings);
         }

      }
   }

   public byte getAlpha_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1448L) : this.__io__block.readByte(this.__io__address + 1352L);
   }

   public void setAlpha_mode(byte alpha_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1448L, alpha_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 1352L, alpha_mode);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{5};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1449L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1353L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1449L;
      } else {
         __dna__offset = 1353L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public byte getEye() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1454L) : this.__io__block.readByte(this.__io__address + 1358L);
   }

   public void setEye(byte eye) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1454L, eye);
      } else {
         this.__io__block.writeByte(this.__io__address + 1358L, eye);
      }

   }

   public byte getViews_format() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1455L) : this.__io__block.readByte(this.__io__address + 1359L);
   }

   public void setViews_format(byte views_format) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1455L, views_format);
      } else {
         this.__io__block.writeByte(this.__io__address + 1359L, views_format);
      }

   }

   public ListBase getViews() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1456L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1360L, this.__io__block, this.__io__blockTable);
   }

   public void setViews(ListBase views) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1456L;
      } else {
         __dna__offset = 1360L;
      }

      if (!this.__io__equals(views, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, views)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, views);
         } else {
            __io__generic__copy(this.getViews(), views);
         }

      }
   }

   public CPointer<Stereo3dFormat> getStereo3d_format() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1472L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1368L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Stereo3dFormat.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 175), this.__io__blockTable);
   }

   public void setStereo3d_format(CPointer<Stereo3dFormat> stereo3d_format) throws IOException {
      long __address = stereo3d_format == null ? 0L : stereo3d_format.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1472L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1368L, __address);
      }

   }

   public CArrayFacade<RenderSlot> getRender_slots() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{RenderSlot.class};
      int[] __dna__dimensions = new int[]{8};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1480L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1372L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRender_slots(CArrayFacade<RenderSlot> render_slots) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1480L;
      } else {
         __dna__offset = 1372L;
      }

      if (!this.__io__equals(render_slots, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, render_slots)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, render_slots);
         } else {
            __io__generic__copy(this.getRender_slots(), render_slots);
         }

      }
   }

   public CPointer<Image> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Image.class}, this.__io__block, this.__io__blockTable);
   }
}
