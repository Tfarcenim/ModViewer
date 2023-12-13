package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 36L,
   size64 = 40L
)
public class ImageUser extends CFacade {
   public static final int __DNA__SDNA_INDEX = 26;
   public static final long[] __DNA__FIELD__scene = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__framenr = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__frames = new long[]{8L, 12L};
   public static final long[] __DNA__FIELD__offset = new long[]{12L, 16L};
   public static final long[] __DNA__FIELD__sfra = new long[]{16L, 20L};
   public static final long[] __DNA__FIELD__fie_ima = new long[]{20L, 24L};
   public static final long[] __DNA__FIELD__cycl = new long[]{21L, 25L};
   public static final long[] __DNA__FIELD__ok = new long[]{22L, 26L};
   public static final long[] __DNA__FIELD__multiview_eye = new long[]{23L, 27L};
   public static final long[] __DNA__FIELD__pass = new long[]{24L, 28L};
   public static final long[] __DNA__FIELD__pad = new long[]{26L, 30L};
   public static final long[] __DNA__FIELD__multi_index = new long[]{28L, 32L};
   public static final long[] __DNA__FIELD__view = new long[]{30L, 34L};
   public static final long[] __DNA__FIELD__layer = new long[]{32L, 36L};
   public static final long[] __DNA__FIELD__flag = new long[]{34L, 38L};

   public ImageUser(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ImageUser(ImageUser that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Scene> getScene() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Scene.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 204), this.__io__blockTable);
   }

   public void setScene(CPointer<Scene> scene) throws IOException {
      long __address = scene == null ? 0L : scene.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public int getFramenr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 8L) : this.__io__block.readInt(this.__io__address + 4L);
   }

   public void setFramenr(int framenr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 8L, framenr);
      } else {
         this.__io__block.writeInt(this.__io__address + 4L, framenr);
      }

   }

   public int getFrames() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 12L) : this.__io__block.readInt(this.__io__address + 8L);
   }

   public void setFrames(int frames) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 12L, frames);
      } else {
         this.__io__block.writeInt(this.__io__address + 8L, frames);
      }

   }

   public int getOffset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 16L) : this.__io__block.readInt(this.__io__address + 12L);
   }

   public void setOffset(int offset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 16L, offset);
      } else {
         this.__io__block.writeInt(this.__io__address + 12L, offset);
      }

   }

   public int getSfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 20L) : this.__io__block.readInt(this.__io__address + 16L);
   }

   public void setSfra(int sfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 20L, sfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 16L, sfra);
      }

   }

   public byte getFie_ima() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 24L) : this.__io__block.readByte(this.__io__address + 20L);
   }

   public void setFie_ima(byte fie_ima) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 24L, fie_ima);
      } else {
         this.__io__block.writeByte(this.__io__address + 20L, fie_ima);
      }

   }

   public byte getCycl() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 25L) : this.__io__block.readByte(this.__io__address + 21L);
   }

   public void setCycl(byte cycl) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 25L, cycl);
      } else {
         this.__io__block.writeByte(this.__io__address + 21L, cycl);
      }

   }

   public byte getOk() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 26L) : this.__io__block.readByte(this.__io__address + 22L);
   }

   public void setOk(byte ok) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 26L, ok);
      } else {
         this.__io__block.writeByte(this.__io__address + 22L, ok);
      }

   }

   public byte getMultiview_eye() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 27L) : this.__io__block.readByte(this.__io__address + 23L);
   }

   public void setMultiview_eye(byte multiview_eye) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 27L, multiview_eye);
      } else {
         this.__io__block.writeByte(this.__io__address + 23L, multiview_eye);
      }

   }

   public short getPass() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 28L) : this.__io__block.readShort(this.__io__address + 24L);
   }

   public void setPass(short pass) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 28L, pass);
      } else {
         this.__io__block.writeShort(this.__io__address + 24L, pass);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 30L) : this.__io__block.readShort(this.__io__address + 26L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 30L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 26L, pad);
      }

   }

   public short getMulti_index() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 32L) : this.__io__block.readShort(this.__io__address + 28L);
   }

   public void setMulti_index(short multi_index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 32L, multi_index);
      } else {
         this.__io__block.writeShort(this.__io__address + 28L, multi_index);
      }

   }

   public short getView() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 34L) : this.__io__block.readShort(this.__io__address + 30L);
   }

   public void setView(short view) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 34L, view);
      } else {
         this.__io__block.writeShort(this.__io__address + 30L, view);
      }

   }

   public short getLayer() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 36L) : this.__io__block.readShort(this.__io__address + 32L);
   }

   public void setLayer(short layer) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 36L, layer);
      } else {
         this.__io__block.writeShort(this.__io__address + 32L, layer);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 38L) : this.__io__block.readShort(this.__io__address + 34L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 38L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 34L, flag);
      }

   }

   public CPointer<ImageUser> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ImageUser.class}, this.__io__block, this.__io__blockTable);
   }
}
