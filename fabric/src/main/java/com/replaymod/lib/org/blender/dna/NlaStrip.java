package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 164L,
   size64 = 208L
)
public class NlaStrip extends CFacade {
   public static final int __DNA__SDNA_INDEX = 523;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__strips = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__act = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__remap = new long[]{20L, 40L};
   public static final long[] __DNA__FIELD__fcurves = new long[]{24L, 48L};
   public static final long[] __DNA__FIELD__modifiers = new long[]{32L, 64L};
   public static final long[] __DNA__FIELD__name = new long[]{40L, 80L};
   public static final long[] __DNA__FIELD__influence = new long[]{104L, 144L};
   public static final long[] __DNA__FIELD__strip_time = new long[]{108L, 148L};
   public static final long[] __DNA__FIELD__start = new long[]{112L, 152L};
   public static final long[] __DNA__FIELD__end = new long[]{116L, 156L};
   public static final long[] __DNA__FIELD__actstart = new long[]{120L, 160L};
   public static final long[] __DNA__FIELD__actend = new long[]{124L, 164L};
   public static final long[] __DNA__FIELD__repeat = new long[]{128L, 168L};
   public static final long[] __DNA__FIELD__scale = new long[]{132L, 172L};
   public static final long[] __DNA__FIELD__blendin = new long[]{136L, 176L};
   public static final long[] __DNA__FIELD__blendout = new long[]{140L, 180L};
   public static final long[] __DNA__FIELD__blendmode = new long[]{144L, 184L};
   public static final long[] __DNA__FIELD__extendmode = new long[]{146L, 186L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{148L, 188L};
   public static final long[] __DNA__FIELD__type = new long[]{150L, 190L};
   public static final long[] __DNA__FIELD__speaker_handle = new long[]{152L, 192L};
   public static final long[] __DNA__FIELD__flag = new long[]{156L, 200L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{160L, 204L};

   public NlaStrip(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected NlaStrip(NlaStrip that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<NlaStrip> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{NlaStrip.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 523), this.__io__blockTable);
   }

   public void setNext(CPointer<NlaStrip> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<NlaStrip> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{NlaStrip.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 523), this.__io__blockTable);
   }

   public void setPrev(CPointer<NlaStrip> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public ListBase getStrips() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 16L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 8L, this.__io__block, this.__io__blockTable);
   }

   public void setStrips(ListBase strips) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(strips, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, strips)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, strips);
         } else {
            __io__generic__copy(this.getStrips(), strips);
         }

      }
   }

   public CPointer<bAction> getAct() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bAction.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 352), this.__io__blockTable);
   }

   public void setAct(CPointer<bAction> act) throws IOException {
      long __address = act == null ? 0L : act.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      }

   }

   public CPointer<AnimMapper> getRemap() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 40L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 20L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{AnimMapper.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 522), this.__io__blockTable);
   }

   public void setRemap(CPointer<AnimMapper> remap) throws IOException {
      long __address = remap == null ? 0L : remap.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 40L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 20L, __address);
      }

   }

   public ListBase getFcurves() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 48L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 24L, this.__io__block, this.__io__blockTable);
   }

   public void setFcurves(ListBase fcurves) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 48L;
      } else {
         __dna__offset = 24L;
      }

      if (!this.__io__equals(fcurves, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, fcurves)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, fcurves);
         } else {
            __io__generic__copy(this.getFcurves(), fcurves);
         }

      }
   }

   public ListBase getModifiers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 64L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 32L, this.__io__block, this.__io__blockTable);
   }

   public void setModifiers(ListBase modifiers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 64L;
      } else {
         __dna__offset = 32L;
      }

      if (!this.__io__equals(modifiers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, modifiers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, modifiers);
         } else {
            __io__generic__copy(this.getModifiers(), modifiers);
         }

      }
   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 80L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 80L;
      } else {
         __dna__offset = 40L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public float getInfluence() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 104L);
   }

   public void setInfluence(float influence) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, influence);
      } else {
         this.__io__block.writeFloat(this.__io__address + 104L, influence);
      }

   }

   public float getStrip_time() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setStrip_time(float strip_time) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, strip_time);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, strip_time);
      }

   }

   public float getStart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setStart(float start) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, start);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, start);
      }

   }

   public float getEnd() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setEnd(float end) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, end);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, end);
      }

   }

   public float getActstart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setActstart(float actstart) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, actstart);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, actstart);
      }

   }

   public float getActend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setActend(float actend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, actend);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, actend);
      }

   }

   public float getRepeat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setRepeat(float repeat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, repeat);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, repeat);
      }

   }

   public float getScale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setScale(float scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, scale);
      }

   }

   public float getBlendin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setBlendin(float blendin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, blendin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, blendin);
      }

   }

   public float getBlendout() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 180L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setBlendout(float blendout) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 180L, blendout);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, blendout);
      }

   }

   public short getBlendmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 184L) : this.__io__block.readShort(this.__io__address + 144L);
   }

   public void setBlendmode(short blendmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 184L, blendmode);
      } else {
         this.__io__block.writeShort(this.__io__address + 144L, blendmode);
      }

   }

   public short getExtendmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 186L) : this.__io__block.readShort(this.__io__address + 146L);
   }

   public void setExtendmode(short extendmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 186L, extendmode);
      } else {
         this.__io__block.writeShort(this.__io__address + 146L, extendmode);
      }

   }

   public short getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 188L) : this.__io__block.readShort(this.__io__address + 148L);
   }

   public void setPad1(short pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 188L, pad1);
      } else {
         this.__io__block.writeShort(this.__io__address + 148L, pad1);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 190L) : this.__io__block.readShort(this.__io__address + 150L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 190L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 150L, type);
      }

   }

   public CPointer<Object> getSpeaker_handle() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSpeaker_handle(CPointer<Object> speaker_handle) throws IOException {
      long __address = speaker_handle == null ? 0L : speaker_handle.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 200L) : this.__io__block.readInt(this.__io__address + 156L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 200L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 156L, flag);
      }

   }

   public int getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 204L) : this.__io__block.readInt(this.__io__address + 160L);
   }

   public void setPad2(int pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 204L, pad2);
      } else {
         this.__io__block.writeInt(this.__io__address + 160L, pad2);
      }

   }

   public CPointer<NlaStrip> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{NlaStrip.class}, this.__io__block, this.__io__blockTable);
   }
}
