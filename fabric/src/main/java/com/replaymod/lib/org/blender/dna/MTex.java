package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 312L,
   size64 = 320L
)
public class MTex extends CFacade {
   public static final int __DNA__SDNA_INDEX = 32;
   public static final long[] __DNA__FIELD__texco = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__mapto = new long[]{2L, 2L};
   public static final long[] __DNA__FIELD__maptoneg = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__blendtype = new long[]{6L, 6L};
   public static final long[] __DNA__FIELD__object = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__tex = new long[]{12L, 16L};
   public static final long[] __DNA__FIELD__uvname = new long[]{16L, 24L};
   public static final long[] __DNA__FIELD__projx = new long[]{80L, 88L};
   public static final long[] __DNA__FIELD__projy = new long[]{81L, 89L};
   public static final long[] __DNA__FIELD__projz = new long[]{82L, 90L};
   public static final long[] __DNA__FIELD__mapping = new long[]{83L, 91L};
   public static final long[] __DNA__FIELD__brush_map_mode = new long[]{84L, 92L};
   public static final long[] __DNA__FIELD__brush_angle_mode = new long[]{85L, 93L};
   public static final long[] __DNA__FIELD__pad = new long[]{86L, 94L};
   public static final long[] __DNA__FIELD__ofs = new long[]{88L, 96L};
   public static final long[] __DNA__FIELD__size = new long[]{100L, 108L};
   public static final long[] __DNA__FIELD__rot = new long[]{112L, 120L};
   public static final long[] __DNA__FIELD__random_angle = new long[]{116L, 124L};
   public static final long[] __DNA__FIELD__texflag = new long[]{120L, 128L};
   public static final long[] __DNA__FIELD__colormodel = new long[]{122L, 130L};
   public static final long[] __DNA__FIELD__pmapto = new long[]{124L, 132L};
   public static final long[] __DNA__FIELD__pmaptoneg = new long[]{126L, 134L};
   public static final long[] __DNA__FIELD__normapspace = new long[]{128L, 136L};
   public static final long[] __DNA__FIELD__which_output = new long[]{130L, 138L};
   public static final long[] __DNA__FIELD__r = new long[]{132L, 140L};
   public static final long[] __DNA__FIELD__g = new long[]{136L, 144L};
   public static final long[] __DNA__FIELD__b = new long[]{140L, 148L};
   public static final long[] __DNA__FIELD__k = new long[]{144L, 152L};
   public static final long[] __DNA__FIELD__def_var = new long[]{148L, 156L};
   public static final long[] __DNA__FIELD__rt = new long[]{152L, 160L};
   public static final long[] __DNA__FIELD__colfac = new long[]{156L, 164L};
   public static final long[] __DNA__FIELD__varfac = new long[]{160L, 168L};
   public static final long[] __DNA__FIELD__norfac = new long[]{164L, 172L};
   public static final long[] __DNA__FIELD__dispfac = new long[]{168L, 176L};
   public static final long[] __DNA__FIELD__warpfac = new long[]{172L, 180L};
   public static final long[] __DNA__FIELD__colspecfac = new long[]{176L, 184L};
   public static final long[] __DNA__FIELD__mirrfac = new long[]{180L, 188L};
   public static final long[] __DNA__FIELD__alphafac = new long[]{184L, 192L};
   public static final long[] __DNA__FIELD__difffac = new long[]{188L, 196L};
   public static final long[] __DNA__FIELD__specfac = new long[]{192L, 200L};
   public static final long[] __DNA__FIELD__emitfac = new long[]{196L, 204L};
   public static final long[] __DNA__FIELD__hardfac = new long[]{200L, 208L};
   public static final long[] __DNA__FIELD__raymirrfac = new long[]{204L, 212L};
   public static final long[] __DNA__FIELD__translfac = new long[]{208L, 216L};
   public static final long[] __DNA__FIELD__ambfac = new long[]{212L, 220L};
   public static final long[] __DNA__FIELD__colemitfac = new long[]{216L, 224L};
   public static final long[] __DNA__FIELD__colreflfac = new long[]{220L, 228L};
   public static final long[] __DNA__FIELD__coltransfac = new long[]{224L, 232L};
   public static final long[] __DNA__FIELD__densfac = new long[]{228L, 236L};
   public static final long[] __DNA__FIELD__scatterfac = new long[]{232L, 240L};
   public static final long[] __DNA__FIELD__reflfac = new long[]{236L, 244L};
   public static final long[] __DNA__FIELD__timefac = new long[]{240L, 248L};
   public static final long[] __DNA__FIELD__lengthfac = new long[]{244L, 252L};
   public static final long[] __DNA__FIELD__clumpfac = new long[]{248L, 256L};
   public static final long[] __DNA__FIELD__dampfac = new long[]{252L, 260L};
   public static final long[] __DNA__FIELD__kinkfac = new long[]{256L, 264L};
   public static final long[] __DNA__FIELD__kinkampfac = new long[]{260L, 268L};
   public static final long[] __DNA__FIELD__roughfac = new long[]{264L, 272L};
   public static final long[] __DNA__FIELD__padensfac = new long[]{268L, 276L};
   public static final long[] __DNA__FIELD__gravityfac = new long[]{272L, 280L};
   public static final long[] __DNA__FIELD__lifefac = new long[]{276L, 284L};
   public static final long[] __DNA__FIELD__sizefac = new long[]{280L, 288L};
   public static final long[] __DNA__FIELD__ivelfac = new long[]{284L, 292L};
   public static final long[] __DNA__FIELD__fieldfac = new long[]{288L, 296L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{292L, 300L};
   public static final long[] __DNA__FIELD__shadowfac = new long[]{296L, 304L};
   public static final long[] __DNA__FIELD__zenupfac = new long[]{300L, 308L};
   public static final long[] __DNA__FIELD__zendownfac = new long[]{304L, 312L};
   public static final long[] __DNA__FIELD__blendfac = new long[]{308L, 316L};

   public MTex(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MTex(MTex that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public short getTexco() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 0L) : this.__io__block.readShort(this.__io__address + 0L);
   }

   public void setTexco(short texco) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 0L, texco);
      } else {
         this.__io__block.writeShort(this.__io__address + 0L, texco);
      }

   }

   public short getMapto() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 2L) : this.__io__block.readShort(this.__io__address + 2L);
   }

   public void setMapto(short mapto) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 2L, mapto);
      } else {
         this.__io__block.writeShort(this.__io__address + 2L, mapto);
      }

   }

   public short getMaptoneg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4L) : this.__io__block.readShort(this.__io__address + 4L);
   }

   public void setMaptoneg(short maptoneg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4L, maptoneg);
      } else {
         this.__io__block.writeShort(this.__io__address + 4L, maptoneg);
      }

   }

   public short getBlendtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 6L) : this.__io__block.readShort(this.__io__address + 6L);
   }

   public void setBlendtype(short blendtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 6L, blendtype);
      } else {
         this.__io__block.writeShort(this.__io__address + 6L, blendtype);
      }

   }

   public CPointer<BlenderObject> getObject() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setObject(CPointer<BlenderObject> object) throws IOException {
      long __address = object == null ? 0L : object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<Tex> getTex() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Tex.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 39), this.__io__blockTable);
   }

   public void setTex(CPointer<Tex> tex) throws IOException {
      long __address = tex == null ? 0L : tex.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public CArrayFacade<Byte> getUvname() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 24L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setUvname(CArrayFacade<Byte> uvname) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 24L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(uvname, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, uvname)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, uvname);
         } else {
            __io__generic__copy(this.getUvname(), uvname);
         }

      }
   }

   public byte getProjx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 88L) : this.__io__block.readByte(this.__io__address + 80L);
   }

   public void setProjx(byte projx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 88L, projx);
      } else {
         this.__io__block.writeByte(this.__io__address + 80L, projx);
      }

   }

   public byte getProjy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 89L) : this.__io__block.readByte(this.__io__address + 81L);
   }

   public void setProjy(byte projy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 89L, projy);
      } else {
         this.__io__block.writeByte(this.__io__address + 81L, projy);
      }

   }

   public byte getProjz() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 90L) : this.__io__block.readByte(this.__io__address + 82L);
   }

   public void setProjz(byte projz) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 90L, projz);
      } else {
         this.__io__block.writeByte(this.__io__address + 82L, projz);
      }

   }

   public byte getMapping() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 91L) : this.__io__block.readByte(this.__io__address + 83L);
   }

   public void setMapping(byte mapping) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 91L, mapping);
      } else {
         this.__io__block.writeByte(this.__io__address + 83L, mapping);
      }

   }

   public byte getBrush_map_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 92L) : this.__io__block.readByte(this.__io__address + 84L);
   }

   public void setBrush_map_mode(byte brush_map_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 92L, brush_map_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 84L, brush_map_mode);
      }

   }

   public byte getBrush_angle_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 93L) : this.__io__block.readByte(this.__io__address + 85L);
   }

   public void setBrush_angle_mode(byte brush_angle_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 93L, brush_angle_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 85L, brush_angle_mode);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 94L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 86L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 94L;
      } else {
         __dna__offset = 86L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CArrayFacade<Float> getOfs() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 96L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 88L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setOfs(CArrayFacade<Float> ofs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 96L;
      } else {
         __dna__offset = 88L;
      }

      if (!this.__io__equals(ofs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ofs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ofs);
         } else {
            __io__generic__copy(this.getOfs(), ofs);
         }

      }
   }

   public CArrayFacade<Float> getSize() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 108L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 100L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSize(CArrayFacade<Float> size) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 108L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(size, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, size)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, size);
         } else {
            __io__generic__copy(this.getSize(), size);
         }

      }
   }

   public float getRot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 120L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setRot(float rot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 120L, rot);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, rot);
      }

   }

   public float getRandom_angle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 124L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setRandom_angle(float random_angle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 124L, random_angle);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, random_angle);
      }

   }

   public short getTexflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 128L) : this.__io__block.readShort(this.__io__address + 120L);
   }

   public void setTexflag(short texflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 128L, texflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 120L, texflag);
      }

   }

   public short getColormodel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 130L) : this.__io__block.readShort(this.__io__address + 122L);
   }

   public void setColormodel(short colormodel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 130L, colormodel);
      } else {
         this.__io__block.writeShort(this.__io__address + 122L, colormodel);
      }

   }

   public short getPmapto() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 132L) : this.__io__block.readShort(this.__io__address + 124L);
   }

   public void setPmapto(short pmapto) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 132L, pmapto);
      } else {
         this.__io__block.writeShort(this.__io__address + 124L, pmapto);
      }

   }

   public short getPmaptoneg() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 134L) : this.__io__block.readShort(this.__io__address + 126L);
   }

   public void setPmaptoneg(short pmaptoneg) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 134L, pmaptoneg);
      } else {
         this.__io__block.writeShort(this.__io__address + 126L, pmaptoneg);
      }

   }

   public short getNormapspace() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 136L) : this.__io__block.readShort(this.__io__address + 128L);
   }

   public void setNormapspace(short normapspace) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 136L, normapspace);
      } else {
         this.__io__block.writeShort(this.__io__address + 128L, normapspace);
      }

   }

   public short getWhich_output() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 138L) : this.__io__block.readShort(this.__io__address + 130L);
   }

   public void setWhich_output(short which_output) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 138L, which_output);
      } else {
         this.__io__block.writeShort(this.__io__address + 130L, which_output);
      }

   }

   public float getR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setR(float r) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, r);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, r);
      }

   }

   public float getG() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setG(float g) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, g);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, g);
      }

   }

   public float getB() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setB(float b) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, b);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, b);
      }

   }

   public float getK() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setK(float k) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, k);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, k);
      }

   }

   public float getDef_var() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 148L);
   }

   public void setDef_var(float def_var) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, def_var);
      } else {
         this.__io__block.writeFloat(this.__io__address + 148L, def_var);
      }

   }

   public float getRt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 152L);
   }

   public void setRt(float rt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, rt);
      } else {
         this.__io__block.writeFloat(this.__io__address + 152L, rt);
      }

   }

   public float getColfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 156L);
   }

   public void setColfac(float colfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, colfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 156L, colfac);
      }

   }

   public float getVarfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 160L);
   }

   public void setVarfac(float varfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, varfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 160L, varfac);
      }

   }

   public float getNorfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 164L);
   }

   public void setNorfac(float norfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, norfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 164L, norfac);
      }

   }

   public float getDispfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 168L);
   }

   public void setDispfac(float dispfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, dispfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 168L, dispfac);
      }

   }

   public float getWarpfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 180L) : this.__io__block.readFloat(this.__io__address + 172L);
   }

   public void setWarpfac(float warpfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 180L, warpfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 172L, warpfac);
      }

   }

   public float getColspecfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 184L) : this.__io__block.readFloat(this.__io__address + 176L);
   }

   public void setColspecfac(float colspecfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 184L, colspecfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 176L, colspecfac);
      }

   }

   public float getMirrfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 188L) : this.__io__block.readFloat(this.__io__address + 180L);
   }

   public void setMirrfac(float mirrfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 188L, mirrfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 180L, mirrfac);
      }

   }

   public float getAlphafac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 192L) : this.__io__block.readFloat(this.__io__address + 184L);
   }

   public void setAlphafac(float alphafac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 192L, alphafac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 184L, alphafac);
      }

   }

   public float getDifffac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 196L) : this.__io__block.readFloat(this.__io__address + 188L);
   }

   public void setDifffac(float difffac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 196L, difffac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 188L, difffac);
      }

   }

   public float getSpecfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 200L) : this.__io__block.readFloat(this.__io__address + 192L);
   }

   public void setSpecfac(float specfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 200L, specfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 192L, specfac);
      }

   }

   public float getEmitfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 204L) : this.__io__block.readFloat(this.__io__address + 196L);
   }

   public void setEmitfac(float emitfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 204L, emitfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 196L, emitfac);
      }

   }

   public float getHardfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 208L) : this.__io__block.readFloat(this.__io__address + 200L);
   }

   public void setHardfac(float hardfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 208L, hardfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 200L, hardfac);
      }

   }

   public float getRaymirrfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 212L) : this.__io__block.readFloat(this.__io__address + 204L);
   }

   public void setRaymirrfac(float raymirrfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 212L, raymirrfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 204L, raymirrfac);
      }

   }

   public float getTranslfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 216L) : this.__io__block.readFloat(this.__io__address + 208L);
   }

   public void setTranslfac(float translfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 216L, translfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 208L, translfac);
      }

   }

   public float getAmbfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 220L) : this.__io__block.readFloat(this.__io__address + 212L);
   }

   public void setAmbfac(float ambfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 220L, ambfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 212L, ambfac);
      }

   }

   public float getColemitfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 224L) : this.__io__block.readFloat(this.__io__address + 216L);
   }

   public void setColemitfac(float colemitfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 224L, colemitfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 216L, colemitfac);
      }

   }

   public float getColreflfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 228L) : this.__io__block.readFloat(this.__io__address + 220L);
   }

   public void setColreflfac(float colreflfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 228L, colreflfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 220L, colreflfac);
      }

   }

   public float getColtransfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 232L) : this.__io__block.readFloat(this.__io__address + 224L);
   }

   public void setColtransfac(float coltransfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 232L, coltransfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 224L, coltransfac);
      }

   }

   public float getDensfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 236L) : this.__io__block.readFloat(this.__io__address + 228L);
   }

   public void setDensfac(float densfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 236L, densfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 228L, densfac);
      }

   }

   public float getScatterfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 240L) : this.__io__block.readFloat(this.__io__address + 232L);
   }

   public void setScatterfac(float scatterfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 240L, scatterfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 232L, scatterfac);
      }

   }

   public float getReflfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 244L) : this.__io__block.readFloat(this.__io__address + 236L);
   }

   public void setReflfac(float reflfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 244L, reflfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 236L, reflfac);
      }

   }

   public float getTimefac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 248L) : this.__io__block.readFloat(this.__io__address + 240L);
   }

   public void setTimefac(float timefac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 248L, timefac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 240L, timefac);
      }

   }

   public float getLengthfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 252L) : this.__io__block.readFloat(this.__io__address + 244L);
   }

   public void setLengthfac(float lengthfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 252L, lengthfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 244L, lengthfac);
      }

   }

   public float getClumpfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 256L) : this.__io__block.readFloat(this.__io__address + 248L);
   }

   public void setClumpfac(float clumpfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 256L, clumpfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 248L, clumpfac);
      }

   }

   public float getDampfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 260L) : this.__io__block.readFloat(this.__io__address + 252L);
   }

   public void setDampfac(float dampfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 260L, dampfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 252L, dampfac);
      }

   }

   public float getKinkfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 264L) : this.__io__block.readFloat(this.__io__address + 256L);
   }

   public void setKinkfac(float kinkfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 264L, kinkfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 256L, kinkfac);
      }

   }

   public float getKinkampfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 268L) : this.__io__block.readFloat(this.__io__address + 260L);
   }

   public void setKinkampfac(float kinkampfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 268L, kinkampfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 260L, kinkampfac);
      }

   }

   public float getRoughfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 272L) : this.__io__block.readFloat(this.__io__address + 264L);
   }

   public void setRoughfac(float roughfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 272L, roughfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 264L, roughfac);
      }

   }

   public float getPadensfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 276L) : this.__io__block.readFloat(this.__io__address + 268L);
   }

   public void setPadensfac(float padensfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 276L, padensfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 268L, padensfac);
      }

   }

   public float getGravityfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 280L) : this.__io__block.readFloat(this.__io__address + 272L);
   }

   public void setGravityfac(float gravityfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 280L, gravityfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 272L, gravityfac);
      }

   }

   public float getLifefac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 284L) : this.__io__block.readFloat(this.__io__address + 276L);
   }

   public void setLifefac(float lifefac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 284L, lifefac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 276L, lifefac);
      }

   }

   public float getSizefac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 288L) : this.__io__block.readFloat(this.__io__address + 280L);
   }

   public void setSizefac(float sizefac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 288L, sizefac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 280L, sizefac);
      }

   }

   public float getIvelfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 292L) : this.__io__block.readFloat(this.__io__address + 284L);
   }

   public void setIvelfac(float ivelfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 292L, ivelfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 284L, ivelfac);
      }

   }

   public float getFieldfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 296L) : this.__io__block.readFloat(this.__io__address + 288L);
   }

   public void setFieldfac(float fieldfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 296L, fieldfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 288L, fieldfac);
      }

   }

   public int getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 300L) : this.__io__block.readInt(this.__io__address + 292L);
   }

   public void setPad2(int pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 300L, pad2);
      } else {
         this.__io__block.writeInt(this.__io__address + 292L, pad2);
      }

   }

   public float getShadowfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 304L) : this.__io__block.readFloat(this.__io__address + 296L);
   }

   public void setShadowfac(float shadowfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 304L, shadowfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 296L, shadowfac);
      }

   }

   public float getZenupfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 308L) : this.__io__block.readFloat(this.__io__address + 300L);
   }

   public void setZenupfac(float zenupfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 308L, zenupfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 300L, zenupfac);
      }

   }

   public float getZendownfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 312L) : this.__io__block.readFloat(this.__io__address + 304L);
   }

   public void setZendownfac(float zendownfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 312L, zendownfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 304L, zendownfac);
      }

   }

   public float getBlendfac() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 316L) : this.__io__block.readFloat(this.__io__address + 308L);
   }

   public void setBlendfac(float blendfac) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 316L, blendfac);
      } else {
         this.__io__block.writeFloat(this.__io__address + 308L, blendfac);
      }

   }

   public CPointer<MTex> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MTex.class}, this.__io__block, this.__io__blockTable);
   }
}
