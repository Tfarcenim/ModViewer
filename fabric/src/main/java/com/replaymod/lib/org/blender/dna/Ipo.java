package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 132L,
   size64 = 160L
)
public class Ipo extends CFacade {
   public static final int __DNA__SDNA_INDEX = 15;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__curve = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__cur = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__blocktype = new long[]{124L, 152L};
   public static final long[] __DNA__FIELD__showkey = new long[]{126L, 154L};
   public static final long[] __DNA__FIELD__muteipo = new long[]{128L, 156L};
   public static final long[] __DNA__FIELD__pad = new long[]{130L, 158L};

   public Ipo(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Ipo(Ipo that) {
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

   public ListBase getCurve() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 120L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 100L, this.__io__block, this.__io__blockTable);
   }

   public void setCurve(ListBase curve) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(curve, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, curve)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, curve);
         } else {
            __io__generic__copy(this.getCurve(), curve);
         }

      }
   }

   public rctf getCur() throws IOException {
      return this.__io__pointersize == 8 ? new rctf(this.__io__address + 136L, this.__io__block, this.__io__blockTable) : new rctf(this.__io__address + 108L, this.__io__block, this.__io__blockTable);
   }

   public void setCur(rctf cur) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 108L;
      }

      if (!this.__io__equals(cur, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, cur)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, cur);
         } else {
            __io__generic__copy(this.getCur(), cur);
         }

      }
   }

   public short getBlocktype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 152L) : this.__io__block.readShort(this.__io__address + 124L);
   }

   public void setBlocktype(short blocktype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 152L, blocktype);
      } else {
         this.__io__block.writeShort(this.__io__address + 124L, blocktype);
      }

   }

   public short getShowkey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 154L) : this.__io__block.readShort(this.__io__address + 126L);
   }

   public void setShowkey(short showkey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 154L, showkey);
      } else {
         this.__io__block.writeShort(this.__io__address + 126L, showkey);
      }

   }

   public short getMuteipo() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 156L) : this.__io__block.readShort(this.__io__address + 128L);
   }

   public void setMuteipo(short muteipo) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 156L, muteipo);
      } else {
         this.__io__block.writeShort(this.__io__address + 128L, muteipo);
      }

   }

   public short getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 158L) : this.__io__block.readShort(this.__io__address + 130L);
   }

   public void setPad(short pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 158L, pad);
      } else {
         this.__io__block.writeShort(this.__io__address + 130L, pad);
      }

   }

   public CPointer<Ipo> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Ipo.class}, this.__io__block, this.__io__blockTable);
   }
}
