package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 192L,
   size64 = 248L
)
public class MetaBall extends CFacade {
   public static final int __DNA__SDNA_INDEX = 49;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__elems = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__disp = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__editelems = new long[]{120L, 160L};
   public static final long[] __DNA__FIELD__ipo = new long[]{124L, 168L};
   public static final long[] __DNA__FIELD__mat = new long[]{128L, 176L};
   public static final long[] __DNA__FIELD__flag = new long[]{132L, 184L};
   public static final long[] __DNA__FIELD__flag2 = new long[]{133L, 185L};
   public static final long[] __DNA__FIELD__totcol = new long[]{134L, 186L};
   public static final long[] __DNA__FIELD__texflag = new long[]{136L, 188L};
   public static final long[] __DNA__FIELD__pad = new long[]{138L, 190L};
   public static final long[] __DNA__FIELD__loc = new long[]{140L, 192L};
   public static final long[] __DNA__FIELD__size = new long[]{152L, 204L};
   public static final long[] __DNA__FIELD__rot = new long[]{164L, 216L};
   public static final long[] __DNA__FIELD__wiresize = new long[]{176L, 228L};
   public static final long[] __DNA__FIELD__rendersize = new long[]{180L, 232L};
   public static final long[] __DNA__FIELD__thresh = new long[]{184L, 236L};
   public static final long[] __DNA__FIELD__lastelem = new long[]{188L, 240L};

   public MetaBall(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected MetaBall(MetaBall that) {
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

   public ListBase getElems() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 128L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 104L, this.__io__block, this.__io__blockTable);
   }

   public void setElems(ListBase elems) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 104L;
      }

      if (!this.__io__equals(elems, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, elems)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, elems);
         } else {
            __io__generic__copy(this.getElems(), elems);
         }

      }
   }

   public ListBase getDisp() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 144L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 112L, this.__io__block, this.__io__blockTable);
   }

   public void setDisp(ListBase disp) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 144L;
      } else {
         __dna__offset = 112L;
      }

      if (!this.__io__equals(disp, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, disp)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, disp);
         } else {
            __io__generic__copy(this.getDisp(), disp);
         }

      }
   }

   public CPointer<ListBase> getEditelems() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ListBase.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 2), this.__io__blockTable);
   }

   public void setEditelems(CPointer<ListBase> editelems) throws IOException {
      long __address = editelems == null ? 0L : editelems.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 124L, __address);
      }

   }

   public CPointer<CPointer<Material>> getMat() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Material.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setMat(CPointer<CPointer<Material>> mat) throws IOException {
      long __address = mat == null ? 0L : mat.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      }

   }

   public byte getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 184L) : this.__io__block.readByte(this.__io__address + 132L);
   }

   public void setFlag(byte flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 184L, flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 132L, flag);
      }

   }

   public byte getFlag2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 185L) : this.__io__block.readByte(this.__io__address + 133L);
   }

   public void setFlag2(byte flag2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 185L, flag2);
      } else {
         this.__io__block.writeByte(this.__io__address + 133L, flag2);
      }

   }

   public short getTotcol() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 186L) : this.__io__block.readShort(this.__io__address + 134L);
   }

   public void setTotcol(short totcol) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 186L, totcol);
      } else {
         this.__io__block.writeShort(this.__io__address + 134L, totcol);
      }

   }

   public short getTexflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 188L) : this.__io__block.readShort(this.__io__address + 136L);
   }

   public void setTexflag(short texflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 188L, texflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 136L, texflag);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 190L) : this.__io__block.readShort(this.__io__address + 138L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 190L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 138L, pad);
      }

   }

   public CArrayFacade<Float> getLoc() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 192L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 140L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLoc(CArrayFacade<Float> loc) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 192L;
      } else {
         __dna__offset = 140L;
      }

      if (!this.__io__equals(loc, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, loc)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, loc);
         } else {
            __io__generic__copy(this.getLoc(), loc);
         }

      }
   }

   public CArrayFacade<Float> getSize() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 204L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 152L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSize(CArrayFacade<Float> size) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 204L;
      } else {
         __dna__offset = 152L;
      }

      if (!this.__io__equals(size, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, size)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, size);
         } else {
            __io__generic__copy(this.getSize(), size);
         }

      }
   }

   public CArrayFacade<Float> getRot() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 216L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 164L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRot(CArrayFacade<Float> rot) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 216L;
      } else {
         __dna__offset = 164L;
      }

      if (!this.__io__equals(rot, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rot)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rot);
         } else {
            __io__generic__copy(this.getRot(), rot);
         }

      }
   }

   public float getWiresize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 228L) : this.__io__block.readFloat(this.__io__address + 176L);
   }

   public void setWiresize(float wiresize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 228L, wiresize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 176L, wiresize);
      }

   }

   public float getRendersize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 232L) : this.__io__block.readFloat(this.__io__address + 180L);
   }

   public void setRendersize(float rendersize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 232L, rendersize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 180L, rendersize);
      }

   }

   public float getThresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 236L) : this.__io__block.readFloat(this.__io__address + 184L);
   }

   public void setThresh(float thresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 236L, thresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 184L, thresh);
      }

   }

   public CPointer<MetaElem> getLastelem() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 240L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 188L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MetaElem.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 48), this.__io__blockTable);
   }

   public void setLastelem(CPointer<MetaElem> lastelem) throws IOException {
      long __address = lastelem == null ? 0L : lastelem.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 240L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 188L, __address);
      }

   }

   public CPointer<MetaBall> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{MetaBall.class}, this.__io__block, this.__io__blockTable);
   }
}
