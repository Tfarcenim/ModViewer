package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 160L,
   size64 = 176L
)
public class ParticleEditSettings extends CFacade {
   public static final int __DNA__SDNA_INDEX = 188;
   public static final long[] __DNA__FIELD__flag = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__totrekey = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__totaddkey = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__brushtype = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__brush = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__paintcursor = new long[]{120L, 120L};
   public static final long[] __DNA__FIELD__emitterdist = new long[]{124L, 128L};
   public static final long[] __DNA__FIELD__rt = new long[]{128L, 132L};
   public static final long[] __DNA__FIELD__selectmode = new long[]{132L, 136L};
   public static final long[] __DNA__FIELD__edittype = new long[]{136L, 140L};
   public static final long[] __DNA__FIELD__draw_step = new long[]{140L, 144L};
   public static final long[] __DNA__FIELD__fade_frames = new long[]{144L, 148L};
   public static final long[] __DNA__FIELD__scene = new long[]{148L, 152L};
   public static final long[] __DNA__FIELD__object = new long[]{152L, 160L};
   public static final long[] __DNA__FIELD__shape_object = new long[]{156L, 168L};

   public ParticleEditSettings(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ParticleEditSettings(ParticleEditSettings that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, flag);
      }

   }

   public short getTotrekey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setTotrekey(short totrekey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, totrekey);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, totrekey);
      }

   }

   public short getTotaddkey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setTotaddkey(short totaddkey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4L, totaddkey);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, totaddkey);
      }

   }

   public short getBrushtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setBrushtype(short brushtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, brushtype);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, brushtype);
      }

   }

   public CArrayFacade<ParticleBrushData> getBrush() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{ParticleBrushData.class};
      int[] __dna__dimensions = new int[]{7};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setBrush(CArrayFacade<ParticleBrushData> brush) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 8L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(brush, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, brush)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, brush);
         } else {
            __io__generic__copy(this.getBrush(), brush);
         }

      }
   }

   public CPointer<Object> getPaintcursor() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPaintcursor(CPointer<Object> paintcursor) throws IOException {
      long __address = paintcursor == null ? 0L : paintcursor.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public float getEmitterdist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 128L) : this.__io__block.readFloat(this.__io__address + 124L);
   }

   public void setEmitterdist(float emitterdist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 128L, emitterdist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 124L, emitterdist);
      }

   }

   public float getRt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 132L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setRt(float rt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 132L, rt);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, rt);
      }

   }

   public int getSelectmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 136L) : this.__io__block.readInt(this.__io__address + 132L);
   }

   public void setSelectmode(int selectmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 136L, selectmode);
      } else {
         this.__io__block.writeInt(this.__io__address + 132L, selectmode);
      }

   }

   public int getEdittype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 140L) : this.__io__block.readInt(this.__io__address + 136L);
   }

   public void setEdittype(int edittype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 140L, edittype);
      } else {
         this.__io__block.writeInt(this.__io__address + 136L, edittype);
      }

   }

   public int getDraw_step() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 144L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setDraw_step(int draw_step) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 144L, draw_step);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, draw_step);
      }

   }

   public int getFade_frames() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 148L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setFade_frames(int fade_frames) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 148L, fade_frames);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, fade_frames);
      }

   }

   public CPointer<Scene> getScene() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 148L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Scene.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 204), this.__io__blockTable);
   }

   public void setScene(CPointer<Scene> scene) throws IOException {
      long __address = scene == null ? 0L : scene.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 148L, __address);
      }

   }

   public CPointer<BlenderObject> getObject() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setObject(CPointer<BlenderObject> object) throws IOException {
      long __address = object == null ? 0L : object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      }

   }

   public CPointer<BlenderObject> getShape_object() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setShape_object(CPointer<BlenderObject> shape_object) throws IOException {
      long __address = shape_object == null ? 0L : shape_object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 156L, __address);
      }

   }

   public CPointer<ParticleEditSettings> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ParticleEditSettings.class}, this.__io__block, this.__io__blockTable);
   }
}
