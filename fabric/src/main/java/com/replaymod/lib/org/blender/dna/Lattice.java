package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 236L,
   size64 = 280L
)
public class Lattice extends CFacade {
   public static final int __DNA__SDNA_INDEX = 149;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__pntsu = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__pntsv = new long[]{106L, 130L};
   public static final long[] __DNA__FIELD__pntsw = new long[]{108L, 132L};
   public static final long[] __DNA__FIELD__flag = new long[]{110L, 134L};
   public static final long[] __DNA__FIELD__opntsu = new long[]{112L, 136L};
   public static final long[] __DNA__FIELD__opntsv = new long[]{114L, 138L};
   public static final long[] __DNA__FIELD__opntsw = new long[]{116L, 140L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{118L, 142L};
   public static final long[] __DNA__FIELD__typeu = new long[]{120L, 144L};
   public static final long[] __DNA__FIELD__typev = new long[]{121L, 145L};
   public static final long[] __DNA__FIELD__typew = new long[]{122L, 146L};
   public static final long[] __DNA__FIELD__pad3 = new long[]{123L, 147L};
   public static final long[] __DNA__FIELD__actbp = new long[]{124L, 148L};
   public static final long[] __DNA__FIELD__fu = new long[]{128L, 152L};
   public static final long[] __DNA__FIELD__fv = new long[]{132L, 156L};
   public static final long[] __DNA__FIELD__fw = new long[]{136L, 160L};
   public static final long[] __DNA__FIELD__du = new long[]{140L, 164L};
   public static final long[] __DNA__FIELD__dv = new long[]{144L, 168L};
   public static final long[] __DNA__FIELD__dw = new long[]{148L, 172L};
   public static final long[] __DNA__FIELD__def = new long[]{152L, 176L};
   public static final long[] __DNA__FIELD__ipo = new long[]{156L, 184L};
   public static final long[] __DNA__FIELD__key = new long[]{160L, 192L};
   public static final long[] __DNA__FIELD__dvert = new long[]{164L, 200L};
   public static final long[] __DNA__FIELD__vgroup = new long[]{168L, 208L};
   public static final long[] __DNA__FIELD__editlatt = new long[]{232L, 272L};

   public Lattice(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Lattice(Lattice that) {
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

   public short getPntsu() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 128L) : this.__io__block.readShort(this.__io__address + 104L);
   }

   public void setPntsu(short pntsu) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 128L, pntsu);
      } else {
         this.__io__block.writeShort(this.__io__address + 104L, pntsu);
      }

   }

   public short getPntsv() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 130L) : this.__io__block.readShort(this.__io__address + 106L);
   }

   public void setPntsv(short pntsv) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 130L, pntsv);
      } else {
         this.__io__block.writeShort(this.__io__address + 106L, pntsv);
      }

   }

   public short getPntsw() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 132L) : this.__io__block.readShort(this.__io__address + 108L);
   }

   public void setPntsw(short pntsw) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 132L, pntsw);
      } else {
         this.__io__block.writeShort(this.__io__address + 108L, pntsw);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 134L) : this.__io__block.readShort(this.__io__address + 110L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 134L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 110L, flag);
      }

   }

   public short getOpntsu() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 136L) : this.__io__block.readShort(this.__io__address + 112L);
   }

   public void setOpntsu(short opntsu) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 136L, opntsu);
      } else {
         this.__io__block.writeShort(this.__io__address + 112L, opntsu);
      }

   }

   public short getOpntsv() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 138L) : this.__io__block.readShort(this.__io__address + 114L);
   }

   public void setOpntsv(short opntsv) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 138L, opntsv);
      } else {
         this.__io__block.writeShort(this.__io__address + 114L, opntsv);
      }

   }

   public short getOpntsw() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 140L) : this.__io__block.readShort(this.__io__address + 116L);
   }

   public void setOpntsw(short opntsw) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 140L, opntsw);
      } else {
         this.__io__block.writeShort(this.__io__address + 116L, opntsw);
      }

   }

   public short getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 142L) : this.__io__block.readShort(this.__io__address + 118L);
   }

   public void setPad2(short pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 142L, pad2);
      } else {
         this.__io__block.writeShort(this.__io__address + 118L, pad2);
      }

   }

   public byte getTypeu() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 144L) : this.__io__block.readByte(this.__io__address + 120L);
   }

   public void setTypeu(byte typeu) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 144L, typeu);
      } else {
         this.__io__block.writeByte(this.__io__address + 120L, typeu);
      }

   }

   public byte getTypev() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 145L) : this.__io__block.readByte(this.__io__address + 121L);
   }

   public void setTypev(byte typev) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 145L, typev);
      } else {
         this.__io__block.writeByte(this.__io__address + 121L, typev);
      }

   }

   public byte getTypew() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 146L) : this.__io__block.readByte(this.__io__address + 122L);
   }

   public void setTypew(byte typew) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 146L, typew);
      } else {
         this.__io__block.writeByte(this.__io__address + 122L, typew);
      }

   }

   public byte getPad3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 147L) : this.__io__block.readByte(this.__io__address + 123L);
   }

   public void setPad3(byte pad3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 147L, pad3);
      } else {
         this.__io__block.writeByte(this.__io__address + 123L, pad3);
      }

   }

   public int getActbp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 148L) : this.__io__block.readInt(this.__io__address + 124L);
   }

   public void setActbp(int actbp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 148L, actbp);
      } else {
         this.__io__block.writeInt(this.__io__address + 124L, actbp);
      }

   }

   public float getFu() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setFu(float fu) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, fu);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, fu);
      }

   }

   public float getFv() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 156L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setFv(float fv) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 156L, fv);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, fv);
      }

   }

   public float getFw() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 160L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setFw(float fw) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 160L, fw);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, fw);
      }

   }

   public float getDu() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 164L) : this.__io__block.readFloat(this.__io__address + 140L);
   }

   public void setDu(float du) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 164L, du);
      } else {
         this.__io__block.writeFloat(this.__io__address + 140L, du);
      }

   }

   public float getDv() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 168L) : this.__io__block.readFloat(this.__io__address + 144L);
   }

   public void setDv(float dv) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 168L, dv);
      } else {
         this.__io__block.writeFloat(this.__io__address + 144L, dv);
      }

   }

   public float getDw() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 148L);
   }

   public void setDw(float dw) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, dw);
      } else {
         this.__io__block.writeFloat(this.__io__address + 148L, dw);
      }

   }

   public CPointer<BPoint> getDef() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BPoint.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 51), this.__io__blockTable);
   }

   public void setDef(CPointer<BPoint> def) throws IOException {
      long __address = def == null ? 0L : def.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 156L, __address);
      }

   }

   public CPointer<Key> getKey() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Key.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 17), this.__io__blockTable);
   }

   public void setKey(CPointer<Key> key) throws IOException {
      long __address = key == null ? 0L : key.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      }

   }

   public CPointer<MDeformVert> getDvert() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 164L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MDeformVert.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 62), this.__io__blockTable);
   }

   public void setDvert(CPointer<MDeformVert> dvert) throws IOException {
      long __address = dvert == null ? 0L : dvert.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 164L, __address);
      }

   }

   public CArrayFacade<Byte> getVgroup() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 208L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 168L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setVgroup(CArrayFacade<Byte> vgroup) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 208L;
      } else {
         __dna__offset = 168L;
      }

      if (!this.__io__equals(vgroup, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vgroup)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vgroup);
         } else {
            __io__generic__copy(this.getVgroup(), vgroup);
         }

      }
   }

   public CPointer<EditLatt> getEditlatt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 272L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 232L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{EditLatt.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 148), this.__io__blockTable);
   }

   public void setEditlatt(CPointer<EditLatt> editlatt) throws IOException {
      long __address = editlatt == null ? 0L : editlatt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 272L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 232L, __address);
      }

   }

   public CPointer<Lattice> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Lattice.class}, this.__io__block, this.__io__blockTable);
   }
}
