package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1408L,
   size64 = 1448L
)
public class Script extends CFacade {
   public static final int __DNA__SDNA_INDEX = 230;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__py_draw = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__py_event = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__py_button = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__py_browsercallback = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__py_globaldict = new long[]{116L, 152L};
   public static final long[] __DNA__FIELD__flags = new long[]{120L, 160L};
   public static final long[] __DNA__FIELD__lastspace = new long[]{124L, 164L};
   public static final long[] __DNA__FIELD__scriptname = new long[]{128L, 168L};
   public static final long[] __DNA__FIELD__scriptarg = new long[]{1152L, 1192L};

   public Script(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Script(Script that) {
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

   public CPointer<Object> getPy_draw() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPy_draw(CPointer<Object> py_draw) throws IOException {
      long __address = py_draw == null ? 0L : py_draw.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CPointer<Object> getPy_event() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPy_event(CPointer<Object> py_event) throws IOException {
      long __address = py_event == null ? 0L : py_event.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public CPointer<Object> getPy_button() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 108L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPy_button(CPointer<Object> py_button) throws IOException {
      long __address = py_button == null ? 0L : py_button.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 108L, __address);
      }

   }

   public CPointer<Object> getPy_browsercallback() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 112L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPy_browsercallback(CPointer<Object> py_browsercallback) throws IOException {
      long __address = py_browsercallback == null ? 0L : py_browsercallback.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 112L, __address);
      }

   }

   public CPointer<Object> getPy_globaldict() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 116L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPy_globaldict(CPointer<Object> py_globaldict) throws IOException {
      long __address = py_globaldict == null ? 0L : py_globaldict.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 116L, __address);
      }

   }

   public int getFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 160L) : this.__io__block.readInt(this.__io__address + 120L);
   }

   public void setFlags(int flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 160L, flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 120L, flags);
      }

   }

   public int getLastspace() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 164L) : this.__io__block.readInt(this.__io__address + 124L);
   }

   public void setLastspace(int lastspace) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 164L, lastspace);
      } else {
         this.__io__block.writeInt(this.__io__address + 124L, lastspace);
      }

   }

   public CArrayFacade<Byte> getScriptname() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1024};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 168L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 128L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setScriptname(CArrayFacade<Byte> scriptname) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 168L;
      } else {
         __dna__offset = 128L;
      }

      if (!this.__io__equals(scriptname, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, scriptname)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, scriptname);
         } else {
            __io__generic__copy(this.getScriptname(), scriptname);
         }

      }
   }

   public CArrayFacade<Byte> getScriptarg() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{256};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1192L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1152L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setScriptarg(CArrayFacade<Byte> scriptarg) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1192L;
      } else {
         __dna__offset = 1152L;
      }

      if (!this.__io__equals(scriptarg, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, scriptarg)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, scriptarg);
         } else {
            __io__generic__copy(this.getScriptarg(), scriptarg);
         }

      }
   }

   public CPointer<Script> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Script.class}, this.__io__block, this.__io__blockTable);
   }
}
