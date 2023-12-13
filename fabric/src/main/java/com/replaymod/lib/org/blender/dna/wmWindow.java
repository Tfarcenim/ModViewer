package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 200L,
   size64 = 288L
)
public class wmWindow extends CFacade {
   public static final int __DNA__SDNA_INDEX = 500;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__ghostwin = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__screen = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__newscreen = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__screenname = new long[]{20L, 40L};
   public static final long[] __DNA__FIELD__posx = new long[]{84L, 104L};
   public static final long[] __DNA__FIELD__posy = new long[]{86L, 106L};
   public static final long[] __DNA__FIELD__sizex = new long[]{88L, 108L};
   public static final long[] __DNA__FIELD__sizey = new long[]{90L, 110L};
   public static final long[] __DNA__FIELD__windowstate = new long[]{92L, 112L};
   public static final long[] __DNA__FIELD__monitor = new long[]{94L, 114L};
   public static final long[] __DNA__FIELD__active = new long[]{96L, 116L};
   public static final long[] __DNA__FIELD__cursor = new long[]{98L, 118L};
   public static final long[] __DNA__FIELD__lastcursor = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__modalcursor = new long[]{102L, 122L};
   public static final long[] __DNA__FIELD__grabcursor = new long[]{104L, 124L};
   public static final long[] __DNA__FIELD__addmousemove = new long[]{106L, 126L};
   public static final long[] __DNA__FIELD__multisamples = new long[]{108L, 128L};
   public static final long[] __DNA__FIELD__pad = new long[]{110L, 130L};
   public static final long[] __DNA__FIELD__winid = new long[]{116L, 136L};
   public static final long[] __DNA__FIELD__lock_pie_event = new long[]{120L, 140L};
   public static final long[] __DNA__FIELD__last_pie_event = new long[]{122L, 142L};
   public static final long[] __DNA__FIELD__eventstate = new long[]{124L, 144L};
   public static final long[] __DNA__FIELD__curswin = new long[]{128L, 152L};
   public static final long[] __DNA__FIELD__tweak = new long[]{132L, 160L};
   public static final long[] __DNA__FIELD__ime_data = new long[]{136L, 168L};
   public static final long[] __DNA__FIELD__drawmethod = new long[]{140L, 176L};
   public static final long[] __DNA__FIELD__drawfail = new long[]{144L, 180L};
   public static final long[] __DNA__FIELD__drawdata = new long[]{148L, 184L};
   public static final long[] __DNA__FIELD__queue = new long[]{156L, 200L};
   public static final long[] __DNA__FIELD__handlers = new long[]{164L, 216L};
   public static final long[] __DNA__FIELD__modalhandlers = new long[]{172L, 232L};
   public static final long[] __DNA__FIELD__subwindows = new long[]{180L, 248L};
   public static final long[] __DNA__FIELD__gesture = new long[]{188L, 264L};
   public static final long[] __DNA__FIELD__stereo3d_format = new long[]{196L, 280L};

   public wmWindow(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected wmWindow(wmWindow that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<wmWindow> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmWindow.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 500), this.__io__blockTable);
   }

   public void setNext(CPointer<wmWindow> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<wmWindow> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{wmWindow.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 500), this.__io__blockTable);
   }

   public void setPrev(CPointer<wmWindow> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<Object> getGhostwin() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setGhostwin(CPointer<Object> ghostwin) throws IOException {
      long __address = ghostwin == null ? 0L : ghostwin.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<bScreen> getScreen() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bScreen.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 255), this.__io__blockTable);
   }

   public void setScreen(CPointer<bScreen> screen) throws IOException {
      long __address = screen == null ? 0L : screen.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public CPointer<bScreen> getNewscreen() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 32L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bScreen.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 255), this.__io__blockTable);
   }

   public void setNewscreen(CPointer<bScreen> newscreen) throws IOException {
      long __address = newscreen == null ? 0L : newscreen.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 32L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      }

   }

   public CArrayFacade<Byte> getScreenname() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 40L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 20L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setScreenname(CArrayFacade<Byte> screenname) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 40L;
      } else {
         __dna__offset = 20L;
      }

      if (!this.__io__equals(screenname, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, screenname)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, screenname);
         } else {
            __io__generic__copy(this.getScreenname(), screenname);
         }

      }
   }

   public short getPosx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 104L) : this.__io__block.readShort(this.__io__address + 84L);
   }

   public void setPosx(short posx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 104L, posx);
      } else {
         this.__io__block.writeShort(this.__io__address + 84L, posx);
      }

   }

   public short getPosy() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 106L) : this.__io__block.readShort(this.__io__address + 86L);
   }

   public void setPosy(short posy) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 106L, posy);
      } else {
         this.__io__block.writeShort(this.__io__address + 86L, posy);
      }

   }

   public short getSizex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 108L) : this.__io__block.readShort(this.__io__address + 88L);
   }

   public void setSizex(short sizex) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 108L, sizex);
      } else {
         this.__io__block.writeShort(this.__io__address + 88L, sizex);
      }

   }

   public short getSizey() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 110L) : this.__io__block.readShort(this.__io__address + 90L);
   }

   public void setSizey(short sizey) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 110L, sizey);
      } else {
         this.__io__block.writeShort(this.__io__address + 90L, sizey);
      }

   }

   public short getWindowstate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 112L) : this.__io__block.readShort(this.__io__address + 92L);
   }

   public void setWindowstate(short windowstate) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 112L, windowstate);
      } else {
         this.__io__block.writeShort(this.__io__address + 92L, windowstate);
      }

   }

   public short getMonitor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 114L) : this.__io__block.readShort(this.__io__address + 94L);
   }

   public void setMonitor(short monitor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 114L, monitor);
      } else {
         this.__io__block.writeShort(this.__io__address + 94L, monitor);
      }

   }

   public short getActive() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 116L) : this.__io__block.readShort(this.__io__address + 96L);
   }

   public void setActive(short active) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 116L, active);
      } else {
         this.__io__block.writeShort(this.__io__address + 96L, active);
      }

   }

   public short getCursor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 118L) : this.__io__block.readShort(this.__io__address + 98L);
   }

   public void setCursor(short cursor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 118L, cursor);
      } else {
         this.__io__block.writeShort(this.__io__address + 98L, cursor);
      }

   }

   public short getLastcursor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 120L) : this.__io__block.readShort(this.__io__address + 100L);
   }

   public void setLastcursor(short lastcursor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 120L, lastcursor);
      } else {
         this.__io__block.writeShort(this.__io__address + 100L, lastcursor);
      }

   }

   public short getModalcursor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 122L) : this.__io__block.readShort(this.__io__address + 102L);
   }

   public void setModalcursor(short modalcursor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 122L, modalcursor);
      } else {
         this.__io__block.writeShort(this.__io__address + 102L, modalcursor);
      }

   }

   public short getGrabcursor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 124L) : this.__io__block.readShort(this.__io__address + 104L);
   }

   public void setGrabcursor(short grabcursor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 124L, grabcursor);
      } else {
         this.__io__block.writeShort(this.__io__address + 104L, grabcursor);
      }

   }

   public short getAddmousemove() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 126L) : this.__io__block.readShort(this.__io__address + 106L);
   }

   public void setAddmousemove(short addmousemove) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 126L, addmousemove);
      } else {
         this.__io__block.writeShort(this.__io__address + 106L, addmousemove);
      }

   }

   public short getMultisamples() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 128L) : this.__io__block.readShort(this.__io__address + 108L);
   }

   public void setMultisamples(short multisamples) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 128L, multisamples);
      } else {
         this.__io__block.writeShort(this.__io__address + 108L, multisamples);
      }

   }

   public CArrayFacade<Short> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 130L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 110L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Short> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 130L;
      } else {
         __dna__offset = 110L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public int getWinid() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 136L) : this.__io__block.readInt(this.__io__address + 116L);
   }

   public void setWinid(int winid) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 136L, winid);
      } else {
         this.__io__block.writeInt(this.__io__address + 116L, winid);
      }

   }

   public short getLock_pie_event() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 140L) : this.__io__block.readShort(this.__io__address + 120L);
   }

   public void setLock_pie_event(short lock_pie_event) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 140L, lock_pie_event);
      } else {
         this.__io__block.writeShort(this.__io__address + 120L, lock_pie_event);
      }

   }

   public short getLast_pie_event() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 142L) : this.__io__block.readShort(this.__io__address + 122L);
   }

   public void setLast_pie_event(short last_pie_event) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 142L, last_pie_event);
      } else {
         this.__io__block.writeShort(this.__io__address + 122L, last_pie_event);
      }

   }

   public CPointer<Object> getEventstate() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setEventstate(CPointer<Object> eventstate) throws IOException {
      long __address = eventstate == null ? 0L : eventstate.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 124L, __address);
      }

   }

   public CPointer<Object> getCurswin() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setCurswin(CPointer<Object> curswin) throws IOException {
      long __address = curswin == null ? 0L : curswin.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      }

   }

   public CPointer<Object> getTweak() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 132L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setTweak(CPointer<Object> tweak) throws IOException {
      long __address = tweak == null ? 0L : tweak.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 132L, __address);
      }

   }

   public CPointer<Object> getIme_data() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setIme_data(CPointer<Object> ime_data) throws IOException {
      long __address = ime_data == null ? 0L : ime_data.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      }

   }

   public int getDrawmethod() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 176L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setDrawmethod(int drawmethod) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 176L, drawmethod);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, drawmethod);
      }

   }

   public int getDrawfail() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 180L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setDrawfail(int drawfail) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 180L, drawfail);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, drawfail);
      }

   }

   public ListBase getDrawdata() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 184L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 148L, this.__io__block, this.__io__blockTable);
   }

   public void setDrawdata(ListBase drawdata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 184L;
      } else {
         __dna__offset = 148L;
      }

      if (!this.__io__equals(drawdata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, drawdata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, drawdata);
         } else {
            __io__generic__copy(this.getDrawdata(), drawdata);
         }

      }
   }

   public ListBase getQueue() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 200L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 156L, this.__io__block, this.__io__blockTable);
   }

   public void setQueue(ListBase queue) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 200L;
      } else {
         __dna__offset = 156L;
      }

      if (!this.__io__equals(queue, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, queue)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, queue);
         } else {
            __io__generic__copy(this.getQueue(), queue);
         }

      }
   }

   public ListBase getHandlers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 216L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 164L, this.__io__block, this.__io__blockTable);
   }

   public void setHandlers(ListBase handlers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 216L;
      } else {
         __dna__offset = 164L;
      }

      if (!this.__io__equals(handlers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, handlers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, handlers);
         } else {
            __io__generic__copy(this.getHandlers(), handlers);
         }

      }
   }

   public ListBase getModalhandlers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 232L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 172L, this.__io__block, this.__io__blockTable);
   }

   public void setModalhandlers(ListBase modalhandlers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 232L;
      } else {
         __dna__offset = 172L;
      }

      if (!this.__io__equals(modalhandlers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, modalhandlers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, modalhandlers);
         } else {
            __io__generic__copy(this.getModalhandlers(), modalhandlers);
         }

      }
   }

   public ListBase getSubwindows() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 248L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 180L, this.__io__block, this.__io__blockTable);
   }

   public void setSubwindows(ListBase subwindows) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 248L;
      } else {
         __dna__offset = 180L;
      }

      if (!this.__io__equals(subwindows, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, subwindows)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, subwindows);
         } else {
            __io__generic__copy(this.getSubwindows(), subwindows);
         }

      }
   }

   public ListBase getGesture() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 264L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 188L, this.__io__block, this.__io__blockTable);
   }

   public void setGesture(ListBase gesture) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 264L;
      } else {
         __dna__offset = 188L;
      }

      if (!this.__io__equals(gesture, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gesture)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gesture);
         } else {
            __io__generic__copy(this.getGesture(), gesture);
         }

      }
   }

   public CPointer<Stereo3dFormat> getStereo3d_format() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 280L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 196L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Stereo3dFormat.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 175), this.__io__blockTable);
   }

   public void setStereo3d_format(CPointer<Stereo3dFormat> stereo3d_format) throws IOException {
      long __address = stereo3d_format == null ? 0L : stereo3d_format.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 280L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 196L, __address);
      }

   }

   public CPointer<wmWindow> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{wmWindow.class}, this.__io__block, this.__io__blockTable);
   }
}
