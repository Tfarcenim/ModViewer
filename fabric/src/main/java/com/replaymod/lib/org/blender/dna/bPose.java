package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 188L,
   size64 = 216L
)
public class bPose extends CFacade {
   public static final int __DNA__SDNA_INDEX = 348;
   public static final long[] __DNA__FIELD__chanbase = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__chanhash = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__flag = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__pad = new long[]{14L, 26L};
   public static final long[] __DNA__FIELD__proxy_layer = new long[]{16L, 28L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{20L, 32L};
   public static final long[] __DNA__FIELD__ctime = new long[]{24L, 36L};
   public static final long[] __DNA__FIELD__stride_offset = new long[]{28L, 40L};
   public static final long[] __DNA__FIELD__cyclic_offset = new long[]{40L, 52L};
   public static final long[] __DNA__FIELD__agroups = new long[]{52L, 64L};
   public static final long[] __DNA__FIELD__active_group = new long[]{60L, 80L};
   public static final long[] __DNA__FIELD__iksolver = new long[]{64L, 84L};
   public static final long[] __DNA__FIELD__ikdata = new long[]{68L, 88L};
   public static final long[] __DNA__FIELD__ikparam = new long[]{72L, 96L};
   public static final long[] __DNA__FIELD__avs = new long[]{76L, 104L};
   public static final long[] __DNA__FIELD__proxy_act_bone = new long[]{124L, 152L};

   public bPose(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bPose(bPose that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ListBase getChanbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setChanbase(ListBase chanbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(chanbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, chanbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, chanbase);
         } else {
            __io__generic__copy(this.getChanbase(), chanbase);
         }

      }
   }

   public CPointer<Object> getChanhash() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setChanhash(CPointer<Object> chanhash) throws IOException {
      long __address = chanhash == null ? 0L : chanhash.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 24L) : this.__io__block.readShort(this.__io__address + 12L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 24L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 12L, flag);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 26L) : this.__io__block.readShort(this.__io__address + 14L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 26L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 14L, pad);
      }

   }

   public int getProxy_layer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 28L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setProxy_layer(int proxy_layer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 28L, proxy_layer);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, proxy_layer);
      }

   }

   public int getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 32L) : this.__io__block.readInt(this.__io__address + 20L);
   }

   public void setPad1(int pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 32L, pad1);
      } else {
         this.__io__block.writeInt(this.__io__address + 20L, pad1);
      }

   }

   public float getCtime() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setCtime(float ctime) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, ctime);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, ctime);
      }

   }

   public CArrayFacade<Float> getStride_offset() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 28L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setStride_offset(CArrayFacade<Float> stride_offset) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 28L;
      }

      if (!this.__io__equals(stride_offset, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, stride_offset)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, stride_offset);
         } else {
            __io__generic__copy(this.getStride_offset(), stride_offset);
         }

      }
   }

   public CArrayFacade<Float> getCyclic_offset() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 52L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCyclic_offset(CArrayFacade<Float> cyclic_offset) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 52L;
      } else {
         __dna__offset = 40L;
      }

      if (!this.__io__equals(cyclic_offset, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, cyclic_offset)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, cyclic_offset);
         } else {
            __io__generic__copy(this.getCyclic_offset(), cyclic_offset);
         }

      }
   }

   public ListBase getAgroups() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 64L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 52L, this.__io__block, this.__io__blockTable);
   }

   public void setAgroups(ListBase agroups) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 64L;
      } else {
         __dna__offset = 52L;
      }

      if (!this.__io__equals(agroups, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, agroups)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, agroups);
         } else {
            __io__generic__copy(this.getAgroups(), agroups);
         }

      }
   }

   public int getActive_group() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 80L) : this.__io__block.readInt(this.__io__address + 60L);
   }

   public void setActive_group(int active_group) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 80L, active_group);
      } else {
         this.__io__block.writeInt(this.__io__address + 60L, active_group);
      }

   }

   public int getIksolver() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 84L) : this.__io__block.readInt(this.__io__address + 64L);
   }

   public void setIksolver(int iksolver) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 84L, iksolver);
      } else {
         this.__io__block.writeInt(this.__io__address + 64L, iksolver);
      }

   }

   public CPointer<Object> getIkdata() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 88L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 68L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setIkdata(CPointer<Object> ikdata) throws IOException {
      long __address = ikdata == null ? 0L : ikdata.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 88L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 68L, __address);
      }

   }

   public CPointer<Object> getIkparam() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 96L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 72L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setIkparam(CPointer<Object> ikparam) throws IOException {
      long __address = ikparam == null ? 0L : ikparam.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 96L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 72L, __address);
      }

   }

   public bAnimVizSettings getAvs() throws IOException {
      return this.__io__pointersize == 8 ? new bAnimVizSettings(this.__io__address + 104L, this.__io__block, this.__io__blockTable) : new bAnimVizSettings(this.__io__address + 76L, this.__io__block, this.__io__blockTable);
   }

   public void setAvs(bAnimVizSettings avs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 104L;
      } else {
         __dna__offset = 76L;
      }

      if (!this.__io__equals(avs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, avs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, avs);
         } else {
            __io__generic__copy(this.getAvs(), avs);
         }

      }
   }

   public CArrayFacade<Byte> getProxy_act_bone() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 152L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 124L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setProxy_act_bone(CArrayFacade<Byte> proxy_act_bone) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 152L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(proxy_act_bone, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, proxy_act_bone)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, proxy_act_bone);
         } else {
            __io__generic__copy(this.getProxy_act_bone(), proxy_act_bone);
         }

      }
   }

   public CPointer<bPose> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bPose.class}, this.__io__block, this.__io__blockTable);
   }
}
