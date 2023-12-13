package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 136L,
   size64 = 168L
)
public class Mask extends CFacade {
   public static final int __DNA__SDNA_INDEX = 565;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__masklayers = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__masklay_act = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__masklay_tot = new long[]{116L, 148L};
   public static final long[] __DNA__FIELD__sfra = new long[]{120L, 152L};
   public static final long[] __DNA__FIELD__efra = new long[]{124L, 156L};
   public static final long[] __DNA__FIELD__flag = new long[]{128L, 160L};
   public static final long[] __DNA__FIELD__pad = new long[]{132L, 164L};

   public Mask(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Mask(Mask that) {
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

   public ListBase getMasklayers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 128L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 104L, this.__io__block, this.__io__blockTable);
   }

   public void setMasklayers(ListBase masklayers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 128L;
      } else {
         __dna__offset = 104L;
      }

      if (!this.__io__equals(masklayers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, masklayers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, masklayers);
         } else {
            __io__generic__copy(this.getMasklayers(), masklayers);
         }

      }
   }

   public int getMasklay_act() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 144L) : this.__io__block.readInt(this.__io__address + 112L);
   }

   public void setMasklay_act(int masklay_act) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 144L, masklay_act);
      } else {
         this.__io__block.writeInt(this.__io__address + 112L, masklay_act);
      }

   }

   public int getMasklay_tot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 148L) : this.__io__block.readInt(this.__io__address + 116L);
   }

   public void setMasklay_tot(int masklay_tot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 148L, masklay_tot);
      } else {
         this.__io__block.writeInt(this.__io__address + 116L, masklay_tot);
      }

   }

   public int getSfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 152L) : this.__io__block.readInt(this.__io__address + 120L);
   }

   public void setSfra(int sfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 152L, sfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 120L, sfra);
      }

   }

   public int getEfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 156L) : this.__io__block.readInt(this.__io__address + 124L);
   }

   public void setEfra(int efra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 156L, efra);
      } else {
         this.__io__block.writeInt(this.__io__address + 124L, efra);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 160L) : this.__io__block.readInt(this.__io__address + 128L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 160L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 128L, flag);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 164L) : this.__io__block.readInt(this.__io__address + 132L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 164L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 132L, pad);
      }

   }

   public CPointer<Mask> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Mask.class}, this.__io__block, this.__io__blockTable);
   }
}
