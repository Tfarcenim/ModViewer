package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 232L,
   size64 = 352L
)
public class wmWindowManager extends CFacade {
   public static final int __DNA__SDNA_INDEX = 499;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__windrawable = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__winactive = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__windows = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__initialized = new long[]{116L, 152L};
   public static final long[] __DNA__FIELD__file_saved = new long[]{120L, 156L};
   public static final long[] __DNA__FIELD__op_undo_depth = new long[]{122L, 158L};
   public static final long[] __DNA__FIELD__operators = new long[]{124L, 160L};
   public static final long[] __DNA__FIELD__queue = new long[]{132L, 176L};
   public static final long[] __DNA__FIELD__reports = new long[]{140L, 192L};
   public static final long[] __DNA__FIELD__jobs = new long[]{168L, 232L};
   public static final long[] __DNA__FIELD__paintcursors = new long[]{176L, 248L};
   public static final long[] __DNA__FIELD__drags = new long[]{184L, 264L};
   public static final long[] __DNA__FIELD__keyconfigs = new long[]{192L, 280L};
   public static final long[] __DNA__FIELD__defaultconf = new long[]{200L, 296L};
   public static final long[] __DNA__FIELD__addonconf = new long[]{204L, 304L};
   public static final long[] __DNA__FIELD__userconf = new long[]{208L, 312L};
   public static final long[] __DNA__FIELD__timers = new long[]{212L, 320L};
   public static final long[] __DNA__FIELD__autosavetimer = new long[]{220L, 336L};
   public static final long[] __DNA__FIELD__is_interface_locked = new long[]{224L, 344L};
   public static final long[] __DNA__FIELD__par = new long[]{225L, 345L};

   public wmWindowManager(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected wmWindowManager(wmWindowManager that) {
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

   public CPointer<wmWindow> getWindrawable() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 100L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmWindow.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 500), this.__io__blockTable);
   }

   public void setWindrawable(CPointer<wmWindow> windrawable) throws IOException {
      long __address = windrawable == null ? 0L : windrawable.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 100L, __address);
      }

   }

   public CPointer<wmWindow> getWinactive() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmWindow.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 500), this.__io__blockTable);
   }

   public void setWinactive(CPointer<wmWindow> winactive) throws IOException {
      long __address = winactive == null ? 0L : winactive.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public ListBase getWindows() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 136L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 108L, this.__io__block, this.__io__blockTable);
   }

   public void setWindows(ListBase windows) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 108L;
      }

      if (!this.__io__equals(windows, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, windows)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, windows);
         } else {
            __io__generic__copy(this.getWindows(), windows);
         }

      }
   }

   public int getInitialized() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 152L) : this.__io__block.readInt(this.__io__address + 116L);
   }

   public void setInitialized(int initialized) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 152L, initialized);
      } else {
         this.__io__block.writeInt(this.__io__address + 116L, initialized);
      }

   }

   public short getFile_saved() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 156L) : this.__io__block.readShort(this.__io__address + 120L);
   }

   public void setFile_saved(short file_saved) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 156L, file_saved);
      } else {
         this.__io__block.writeShort(this.__io__address + 120L, file_saved);
      }

   }

   public short getOp_undo_depth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 158L) : this.__io__block.readShort(this.__io__address + 122L);
   }

   public void setOp_undo_depth(short op_undo_depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 158L, op_undo_depth);
      } else {
         this.__io__block.writeShort(this.__io__address + 122L, op_undo_depth);
      }

   }

   public ListBase getOperators() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 160L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 124L, this.__io__block, this.__io__blockTable);
   }

   public void setOperators(ListBase operators) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 160L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(operators, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, operators)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, operators);
         } else {
            __io__generic__copy(this.getOperators(), operators);
         }

      }
   }

   public ListBase getQueue() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 176L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 132L, this.__io__block, this.__io__blockTable);
   }

   public void setQueue(ListBase queue) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 176L;
      } else {
         __dna__offset = 132L;
      }

      if (!this.__io__equals(queue, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, queue)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, queue);
         } else {
            __io__generic__copy(this.getQueue(), queue);
         }

      }
   }

   public ReportList getReports() throws IOException {
      return this.__io__pointersize == 8 ? new ReportList(this.__io__address + 192L, this.__io__block, this.__io__blockTable) : new ReportList(this.__io__address + 140L, this.__io__block, this.__io__blockTable);
   }

   public void setReports(ReportList reports) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 192L;
      } else {
         __dna__offset = 140L;
      }

      if (!this.__io__equals(reports, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, reports)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, reports);
         } else {
            __io__generic__copy(this.getReports(), reports);
         }

      }
   }

   public ListBase getJobs() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 232L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 168L, this.__io__block, this.__io__blockTable);
   }

   public void setJobs(ListBase jobs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 232L;
      } else {
         __dna__offset = 168L;
      }

      if (!this.__io__equals(jobs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, jobs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, jobs);
         } else {
            __io__generic__copy(this.getJobs(), jobs);
         }

      }
   }

   public ListBase getPaintcursors() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 248L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 176L, this.__io__block, this.__io__blockTable);
   }

   public void setPaintcursors(ListBase paintcursors) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 248L;
      } else {
         __dna__offset = 176L;
      }

      if (!this.__io__equals(paintcursors, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, paintcursors)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, paintcursors);
         } else {
            __io__generic__copy(this.getPaintcursors(), paintcursors);
         }

      }
   }

   public ListBase getDrags() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 264L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 184L, this.__io__block, this.__io__blockTable);
   }

   public void setDrags(ListBase drags) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 264L;
      } else {
         __dna__offset = 184L;
      }

      if (!this.__io__equals(drags, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, drags)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, drags);
         } else {
            __io__generic__copy(this.getDrags(), drags);
         }

      }
   }

   public ListBase getKeyconfigs() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 280L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 192L, this.__io__block, this.__io__blockTable);
   }

   public void setKeyconfigs(ListBase keyconfigs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 280L;
      } else {
         __dna__offset = 192L;
      }

      if (!this.__io__equals(keyconfigs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, keyconfigs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, keyconfigs);
         } else {
            __io__generic__copy(this.getKeyconfigs(), keyconfigs);
         }

      }
   }

   public CPointer<wmKeyConfig> getDefaultconf() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 296L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmKeyConfig.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 504), this.__io__blockTable);
   }

   public void setDefaultconf(CPointer<wmKeyConfig> defaultconf) throws IOException {
      long __address = defaultconf == null ? 0L : defaultconf.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 296L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      }

   }

   public CPointer<wmKeyConfig> getAddonconf() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 304L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 204L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmKeyConfig.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 504), this.__io__blockTable);
   }

   public void setAddonconf(CPointer<wmKeyConfig> addonconf) throws IOException {
      long __address = addonconf == null ? 0L : addonconf.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 304L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 204L, __address);
      }

   }

   public CPointer<wmKeyConfig> getUserconf() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 312L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 208L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmKeyConfig.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 504), this.__io__blockTable);
   }

   public void setUserconf(CPointer<wmKeyConfig> userconf) throws IOException {
      long __address = userconf == null ? 0L : userconf.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 312L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 208L, __address);
      }

   }

   public ListBase getTimers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 320L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 212L, this.__io__block, this.__io__blockTable);
   }

   public void setTimers(ListBase timers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 320L;
      } else {
         __dna__offset = 212L;
      }

      if (!this.__io__equals(timers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, timers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, timers);
         } else {
            __io__generic__copy(this.getTimers(), timers);
         }

      }
   }

   public CPointer<Object> getAutosavetimer() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 336L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 220L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setAutosavetimer(CPointer<Object> autosavetimer) throws IOException {
      long __address = autosavetimer == null ? 0L : autosavetimer.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 336L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 220L, __address);
      }

   }

   public byte getIs_interface_locked() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 344L) : this.__io__block.readByte(this.__io__address + 224L);
   }

   public void setIs_interface_locked(byte is_interface_locked) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 344L, is_interface_locked);
      } else {
         this.__io__block.writeByte(this.__io__address + 224L, is_interface_locked);
      }

   }

   public CArrayFacade<Byte> getPar() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{7};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 345L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 225L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPar(CArrayFacade<Byte> par) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 345L;
      } else {
         __dna__offset = 225L;
      }

      if (!this.__io__equals(par, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, par)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, par);
         } else {
            __io__generic__copy(this.getPar(), par);
         }

      }
   }

   public CPointer<wmWindowManager> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{wmWindowManager.class}, this.__io__block, this.__io__blockTable);
   }
}
