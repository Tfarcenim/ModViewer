package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 216L,
   size64 = 248L
)
public class Camera extends CFacade {
   public static final int __DNA__SDNA_INDEX = 25;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__type = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__dtx = new long[]{105L, 129L};
   public static final long[] __DNA__FIELD__flag = new long[]{106L, 130L};
   public static final long[] __DNA__FIELD__passepartalpha = new long[]{108L, 132L};
   public static final long[] __DNA__FIELD__clipsta = new long[]{112L, 136L};
   public static final long[] __DNA__FIELD__clipend = new long[]{116L, 140L};
   public static final long[] __DNA__FIELD__lens = new long[]{120L, 144L};
   public static final long[] __DNA__FIELD__ortho_scale = new long[]{124L, 148L};
   public static final long[] __DNA__FIELD__drawsize = new long[]{128L, 152L};
   public static final long[] __DNA__FIELD__sensor_x = new long[]{132L, 156L};
   public static final long[] __DNA__FIELD__sensor_y = new long[]{136L, 160L};
   public static final long[] __DNA__FIELD__shiftx = new long[]{140L, 164L};
   public static final long[] __DNA__FIELD__shifty = new long[]{144L, 168L};
   public static final long[] __DNA__FIELD__YF_dofdist = new long[]{148L, 172L};
   public static final long[] __DNA__FIELD__ipo = new long[]{152L, 176L};
   public static final long[] __DNA__FIELD__dof_ob = new long[]{156L, 184L};
   public static final long[] __DNA__FIELD__gpu_dof = new long[]{160L, 192L};
   public static final long[] __DNA__FIELD__sensor_fit = new long[]{184L, 216L};
   public static final long[] __DNA__FIELD__pad = new long[]{185L, 217L};
   public static final long[] __DNA__FIELD__stereo = new long[]{192L, 224L};

   public Camera(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Camera(Camera that) {
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

   public byte getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 128L) : this.__io__block.readByte(this.__io__address + 104L);
   }

   public void setType(byte type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 128L, type);
      } else {
         this.__io__block.writeByte(this.__io__address + 104L, type);
      }

   }

   public byte getDtx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 129L) : this.__io__block.readByte(this.__io__address + 105L);
   }

   public void setDtx(byte dtx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 129L, dtx);
      } else {
         this.__io__block.writeByte(this.__io__address + 105L, dtx);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 130L) : this.__io__block.readShort(this.__io__address + 106L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 130L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 106L, flag);
      }

   }

   public float getPassepartalpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 132L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setPassepartalpha(float passepartalpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 132L, passepartalpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, passepartalpha);
      }

   }

   public float getClipsta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setClipsta(float clipsta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, clipsta);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, clipsta);
      }

   }

   public float getClipend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setClipend(float clipend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, clipend);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, clipend);
      }

   }

   public float getLens() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setLens(float lens) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, lens);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, lens);
      }

   }

   public float getOrtho_scale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setOrtho_scale(float ortho_scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, ortho_scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, ortho_scale);
      }

   }

   public float getDrawsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setDrawsize(float drawsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, drawsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, drawsize);
      }

   }

   public float getSensor_x() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setSensor_x(float sensor_x) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, sensor_x);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, sensor_x);
      }

   }

   public float getSensor_y() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setSensor_y(float sensor_y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, sensor_y);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, sensor_y);
      }

   }

   public float getShiftx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setShiftx(float shiftx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, shiftx);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, shiftx);
      }

   }

   public float getShifty() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setShifty(float shifty) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, shifty);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, shifty);
      }

   }

   public float getYF_dofdist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 148L);
   }

   public void setYF_dofdist(float YF_dofdist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, YF_dofdist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 148L, YF_dofdist);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      }

   }

   public CPointer<BlenderObject> getDof_ob() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setDof_ob(CPointer<BlenderObject> dof_ob) throws IOException {
      long __address = dof_ob == null ? 0L : dof_ob.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 156L, __address);
      }

   }

   public GPUDOFSettings getGpu_dof() throws IOException {
      return this.__io__pointersize == 8 ? new GPUDOFSettings(this.__io__address + 192L, this.__io__block, this.__io__blockTable) : new GPUDOFSettings(this.__io__address + 160L, this.__io__block, this.__io__blockTable);
   }

   public void setGpu_dof(GPUDOFSettings gpu_dof) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 192L;
      } else {
         __dna__offset = 160L;
      }

      if (!this.__io__equals(gpu_dof, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gpu_dof)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gpu_dof);
         } else {
            __io__generic__copy(this.getGpu_dof(), gpu_dof);
         }

      }
   }

   public byte getSensor_fit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 216L) : this.__io__block.readByte(this.__io__address + 184L);
   }

   public void setSensor_fit(byte sensor_fit) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 216L, sensor_fit);
      } else {
         this.__io__block.writeByte(this.__io__address + 184L, sensor_fit);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{7};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 217L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 185L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 217L;
      } else {
         __dna__offset = 185L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CameraStereoSettings getStereo() throws IOException {
      return this.__io__pointersize == 8 ? new CameraStereoSettings(this.__io__address + 224L, this.__io__block, this.__io__blockTable) : new CameraStereoSettings(this.__io__address + 192L, this.__io__block, this.__io__blockTable);
   }

   public void setStereo(CameraStereoSettings stereo) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 224L;
      } else {
         __dna__offset = 192L;
      }

      if (!this.__io__equals(stereo, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, stereo)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, stereo);
         } else {
            __io__generic__copy(this.getStereo(), stereo);
         }

      }
   }

   public CPointer<Camera> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Camera.class}, this.__io__block, this.__io__blockTable);
   }
}
