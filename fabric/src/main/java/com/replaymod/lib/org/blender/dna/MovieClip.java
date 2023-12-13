package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 2312L,
   size64 = 2416L
)
public class MovieClip extends CFacade {
   public static final int __DNA__SDNA_INDEX = 545;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__name = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__source = new long[]{1128L, 1152L};
   public static final long[] __DNA__FIELD__lastframe = new long[]{1132L, 1156L};
   public static final long[] __DNA__FIELD__lastsize = new long[]{1136L, 1160L};
   public static final long[] __DNA__FIELD__aspx = new long[]{1144L, 1168L};
   public static final long[] __DNA__FIELD__aspy = new long[]{1148L, 1172L};
   public static final long[] __DNA__FIELD__anim = new long[]{1152L, 1176L};
   public static final long[] __DNA__FIELD__cache = new long[]{1156L, 1184L};
   public static final long[] __DNA__FIELD__gpd = new long[]{1160L, 1192L};
   public static final long[] __DNA__FIELD__tracking = new long[]{1164L, 1200L};
   public static final long[] __DNA__FIELD__tracking_context = new long[]{1452L, 1552L};
   public static final long[] __DNA__FIELD__proxy = new long[]{1456L, 1560L};
   public static final long[] __DNA__FIELD__flag = new long[]{2232L, 2336L};
   public static final long[] __DNA__FIELD__len = new long[]{2236L, 2340L};
   public static final long[] __DNA__FIELD__start_frame = new long[]{2240L, 2344L};
   public static final long[] __DNA__FIELD__frame_offset = new long[]{2244L, 2348L};
   public static final long[] __DNA__FIELD__colorspace_settings = new long[]{2248L, 2352L};

   public MovieClip(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MovieClip(MovieClip that) {
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

   public CPointer<AnimData> getAdt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimData.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 528), this.__io__blockTable);
   }

   public void setAdt(CPointer<AnimData> adt) throws IOException {
      long __address = adt == null ? 0L : adt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 104L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 104L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public int getSource() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1152L) : this.__io__block.readInt(this.__io__address + 1128L);
   }

   public void setSource(int source) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1152L, source);
      } else {
         this.__io__block.writeInt(this.__io__address + 1128L, source);
      }

   }

   public int getLastframe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1156L) : this.__io__block.readInt(this.__io__address + 1132L);
   }

   public void setLastframe(int lastframe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1156L, lastframe);
      } else {
         this.__io__block.writeInt(this.__io__address + 1132L, lastframe);
      }

   }

   public CArrayFacade<Integer> getLastsize() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Integer.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1160L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1136L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLastsize(CArrayFacade<Integer> lastsize) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1160L;
      } else {
         __dna__offset = 1136L;
      }

      if (!this.__io__equals(lastsize, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, lastsize)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, lastsize);
         } else {
            __io__generic__copy(this.getLastsize(), lastsize);
         }

      }
   }

   public float getAspx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1168L) : this.__io__block.readFloat(this.__io__address + 1144L);
   }

   public void setAspx(float aspx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1168L, aspx);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1144L, aspx);
      }

   }

   public float getAspy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1172L) : this.__io__block.readFloat(this.__io__address + 1148L);
   }

   public void setAspy(float aspy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1172L, aspy);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1148L, aspy);
      }

   }

   public CPointer<Object> getAnim() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1152L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setAnim(CPointer<Object> anim) throws IOException {
      long __address = anim == null ? 0L : anim.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1152L, __address);
      }

   }

   public CPointer<Object> getCache() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setCache(CPointer<Object> cache) throws IOException {
      long __address = cache == null ? 0L : cache.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1156L, __address);
      }

   }

   public CPointer<bGPdata> getGpd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1160L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bGPdata.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 497), this.__io__blockTable);
   }

   public void setGpd(CPointer<bGPdata> gpd) throws IOException {
      long __address = gpd == null ? 0L : gpd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1160L, __address);
      }

   }

   public MovieTracking getTracking() throws IOException {
      return this.__io__pointersize == 8 ? new MovieTracking(this.__io__address + 1200L, this.__io__block, this.__io__blockTable) : new MovieTracking(this.__io__address + 1164L, this.__io__block, this.__io__blockTable);
   }

   public void setTracking(MovieTracking tracking) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1200L;
      } else {
         __dna__offset = 1164L;
      }

      if (!this.__io__equals(tracking, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, tracking)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, tracking);
         } else {
            __io__generic__copy(this.getTracking(), tracking);
         }

      }
   }

   public CPointer<Object> getTracking_context() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1552L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1452L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setTracking_context(CPointer<Object> tracking_context) throws IOException {
      long __address = tracking_context == null ? 0L : tracking_context.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1552L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1452L, __address);
      }

   }

   public MovieClipProxy getProxy() throws IOException {
      return this.__io__pointersize == 8 ? new MovieClipProxy(this.__io__address + 1560L, this.__io__block, this.__io__blockTable) : new MovieClipProxy(this.__io__address + 1456L, this.__io__block, this.__io__blockTable);
   }

   public void setProxy(MovieClipProxy proxy) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1560L;
      } else {
         __dna__offset = 1456L;
      }

      if (!this.__io__equals(proxy, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, proxy)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, proxy);
         } else {
            __io__generic__copy(this.getProxy(), proxy);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2336L) : this.__io__block.readInt(this.__io__address + 2232L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2336L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 2232L, flag);
      }

   }

   public int getLen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2340L) : this.__io__block.readInt(this.__io__address + 2236L);
   }

   public void setLen(int len) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2340L, len);
      } else {
         this.__io__block.writeInt(this.__io__address + 2236L, len);
      }

   }

   public int getStart_frame() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2344L) : this.__io__block.readInt(this.__io__address + 2240L);
   }

   public void setStart_frame(int start_frame) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2344L, start_frame);
      } else {
         this.__io__block.writeInt(this.__io__address + 2240L, start_frame);
      }

   }

   public int getFrame_offset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 2348L) : this.__io__block.readInt(this.__io__address + 2244L);
   }

   public void setFrame_offset(int frame_offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 2348L, frame_offset);
      } else {
         this.__io__block.writeInt(this.__io__address + 2244L, frame_offset);
      }

   }

   public ColorManagedColorspaceSettings getColorspace_settings() throws IOException {
      return this.__io__pointersize == 8 ? new ColorManagedColorspaceSettings(this.__io__address + 2352L, this.__io__block, this.__io__blockTable) : new ColorManagedColorspaceSettings(this.__io__address + 2248L, this.__io__block, this.__io__blockTable);
   }

   public void setColorspace_settings(ColorManagedColorspaceSettings colorspace_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 2352L;
      } else {
         __dna__offset = 2248L;
      }

      if (!this.__io__equals(colorspace_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, colorspace_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, colorspace_settings);
         } else {
            __io__generic__copy(this.getColorspace_settings(), colorspace_settings);
         }

      }
   }

   public CPointer<MovieClip> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MovieClip.class}, this.__io__block, this.__io__blockTable);
   }
}
