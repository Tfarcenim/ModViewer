package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 160L,
   size64 = 208L
)
public class Text extends CFacade {
   public static final int __DNA__SDNA_INDEX = 19;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__name = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__flags = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__nlines = new long[]{108L, 132L};
   public static final long[] __DNA__FIELD__lines = new long[]{112L, 136L};
   public static final long[] __DNA__FIELD__curl = new long[]{120L, 152L};
   public static final long[] __DNA__FIELD__sell = new long[]{124L, 160L};
   public static final long[] __DNA__FIELD__curc = new long[]{128L, 168L};
   public static final long[] __DNA__FIELD__selc = new long[]{132L, 172L};
   public static final long[] __DNA__FIELD__undo_buf = new long[]{136L, 176L};
   public static final long[] __DNA__FIELD__undo_pos = new long[]{140L, 184L};
   public static final long[] __DNA__FIELD__undo_len = new long[]{144L, 188L};
   public static final long[] __DNA__FIELD__compiled = new long[]{148L, 192L};
   public static final long[] __DNA__FIELD__mtime = new long[]{152L, 200L};

   public Text(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Text(Text that) {
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

   public CPointer<Byte> getName() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setName(CPointer<Byte> name) throws IOException {
      long __address = name == null ? 0L : name.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public int getFlags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 128L) : this.__io__block.readInt(this.__io__address + 104L);
   }

   public void setFlags(int flags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 128L, flags);
      } else {
         this.__io__block.writeInt(this.__io__address + 104L, flags);
      }

   }

   public int getNlines() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 132L) : this.__io__block.readInt(this.__io__address + 108L);
   }

   public void setNlines(int nlines) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 132L, nlines);
      } else {
         this.__io__block.writeInt(this.__io__address + 108L, nlines);
      }

   }

   public ListBase getLines() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 136L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 112L, this.__io__block, this.__io__blockTable);
   }

   public void setLines(ListBase lines) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 112L;
      }

      if (!this.__io__equals(lines, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, lines)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, lines);
         } else {
            __io__generic__copy(this.getLines(), lines);
         }

      }
   }

   public CPointer<TextLine> getCurl() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{TextLine.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 18), this.__io__blockTable);
   }

   public void setCurl(CPointer<TextLine> curl) throws IOException {
      long __address = curl == null ? 0L : curl.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public CPointer<TextLine> getSell() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{TextLine.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 18), this.__io__blockTable);
   }

   public void setSell(CPointer<TextLine> sell) throws IOException {
      long __address = sell == null ? 0L : sell.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 124L, __address);
      }

   }

   public int getCurc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 168L) : this.__io__block.readInt(this.__io__address + 128L);
   }

   public void setCurc(int curc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 168L, curc);
      } else {
         this.__io__block.writeInt(this.__io__address + 128L, curc);
      }

   }

   public int getSelc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 172L) : this.__io__block.readInt(this.__io__address + 132L);
   }

   public void setSelc(int selc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 172L, selc);
      } else {
         this.__io__block.writeInt(this.__io__address + 132L, selc);
      }

   }

   public CPointer<Byte> getUndo_buf() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setUndo_buf(CPointer<Byte> undo_buf) throws IOException {
      long __address = undo_buf == null ? 0L : undo_buf.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      }

   }

   public int getUndo_pos() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 184L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setUndo_pos(int undo_pos) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 184L, undo_pos);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, undo_pos);
      }

   }

   public int getUndo_len() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 188L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setUndo_len(int undo_len) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 188L, undo_len);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, undo_len);
      }

   }

   public CPointer<Object> getCompiled() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 148L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setCompiled(CPointer<Object> compiled) throws IOException {
      long __address = compiled == null ? 0L : compiled.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 148L, __address);
      }

   }

   public double getMtime() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readDouble(this.__io__address + 200L) : this.__io__block.readDouble(this.__io__address + 152L);
   }

   public void setMtime(double mtime) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeDouble(this.__io__address + 200L, mtime);
      } else {
         this.__io__block.writeDouble(this.__io__address + 152L, mtime);
      }

   }

   public CPointer<Text> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Text.class}, this.__io__block, this.__io__blockTable);
   }
}
