package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 148L,
   size64 = 200L
)
public class bAction extends CFacade {
   public static final int __DNA__SDNA_INDEX = 352;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__curves = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__chanbase = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__groups = new long[]{116L, 152L};
   public static final long[] __DNA__FIELD__markers = new long[]{124L, 168L};
   public static final long[] __DNA__FIELD__flag = new long[]{132L, 184L};
   public static final long[] __DNA__FIELD__active_marker = new long[]{136L, 188L};
   public static final long[] __DNA__FIELD__idroot = new long[]{140L, 192L};
   public static final long[] __DNA__FIELD__pad = new long[]{144L, 196L};

   public bAction(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bAction(bAction that) {
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

   public ListBase getCurves() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 120L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 100L, this.__io__block, this.__io__blockTable);
   }

   public void setCurves(ListBase curves) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(curves, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, curves)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, curves);
         } else {
            __io__generic__copy(this.getCurves(), curves);
         }

      }
   }

   public ListBase getChanbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 136L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 108L, this.__io__block, this.__io__blockTable);
   }

   public void setChanbase(ListBase chanbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 108L;
      }

      if (!this.__io__equals(chanbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, chanbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, chanbase);
         } else {
            __io__generic__copy(this.getChanbase(), chanbase);
         }

      }
   }

   public ListBase getGroups() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 152L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 116L, this.__io__block, this.__io__blockTable);
   }

   public void setGroups(ListBase groups) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 152L;
      } else {
         __dna__offset = 116L;
      }

      if (!this.__io__equals(groups, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, groups)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, groups);
         } else {
            __io__generic__copy(this.getGroups(), groups);
         }

      }
   }

   public ListBase getMarkers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 168L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 124L, this.__io__block, this.__io__blockTable);
   }

   public void setMarkers(ListBase markers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 168L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(markers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, markers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, markers);
         } else {
            __io__generic__copy(this.getMarkers(), markers);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 184L) : this.__io__block.readInt(this.__io__address + 132L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 184L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 132L, flag);
      }

   }

   public int getActive_marker() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 188L) : this.__io__block.readInt(this.__io__address + 136L);
   }

   public void setActive_marker(int active_marker) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 188L, active_marker);
      } else {
         this.__io__block.writeInt(this.__io__address + 136L, active_marker);
      }

   }

   public int getIdroot() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 192L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setIdroot(int idroot) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 192L, idroot);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, idroot);
      }

   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 196L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 196L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, pad);
      }

   }

   public CPointer<bAction> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bAction.class}, this.__io__block, this.__io__blockTable);
   }
}
