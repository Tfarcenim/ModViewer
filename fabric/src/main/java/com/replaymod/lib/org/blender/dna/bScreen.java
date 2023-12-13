package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 172L,
   size64 = 240L
)
public class bScreen extends CFacade {
   public static final int __DNA__SDNA_INDEX = 255;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__vertbase = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__edgebase = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__areabase = new long[]{116L, 152L};
   public static final long[] __DNA__FIELD__regionbase = new long[]{124L, 168L};
   public static final long[] __DNA__FIELD__scene = new long[]{132L, 184L};
   public static final long[] __DNA__FIELD__newscene = new long[]{136L, 192L};
   public static final long[] __DNA__FIELD__winid = new long[]{140L, 200L};
   public static final long[] __DNA__FIELD__redraws_flag = new long[]{142L, 202L};
   public static final long[] __DNA__FIELD__temp = new long[]{144L, 204L};
   public static final long[] __DNA__FIELD__state = new long[]{145L, 205L};
   public static final long[] __DNA__FIELD__do_draw = new long[]{146L, 206L};
   public static final long[] __DNA__FIELD__do_refresh = new long[]{147L, 207L};
   public static final long[] __DNA__FIELD__do_draw_gesture = new long[]{148L, 208L};
   public static final long[] __DNA__FIELD__do_draw_paintcursor = new long[]{149L, 209L};
   public static final long[] __DNA__FIELD__do_draw_drag = new long[]{150L, 210L};
   public static final long[] __DNA__FIELD__swap = new long[]{151L, 211L};
   public static final long[] __DNA__FIELD__skip_handling = new long[]{152L, 212L};
   public static final long[] __DNA__FIELD__scrubbing = new long[]{153L, 213L};
   public static final long[] __DNA__FIELD__pad = new long[]{154L, 214L};
   public static final long[] __DNA__FIELD__mainwin = new long[]{160L, 220L};
   public static final long[] __DNA__FIELD__subwinactive = new long[]{162L, 222L};
   public static final long[] __DNA__FIELD__animtimer = new long[]{164L, 224L};
   public static final long[] __DNA__FIELD__context = new long[]{168L, 232L};

   public bScreen(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bScreen(bScreen that) {
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

   public ListBase getVertbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 120L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 100L, this.__io__block, this.__io__blockTable);
   }

   public void setVertbase(ListBase vertbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 120L;
      } else {
         __dna__offset = 100L;
      }

      if (!this.__io__equals(vertbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vertbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vertbase);
         } else {
            __io__generic__copy(this.getVertbase(), vertbase);
         }

      }
   }

   public ListBase getEdgebase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 136L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 108L, this.__io__block, this.__io__blockTable);
   }

   public void setEdgebase(ListBase edgebase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 108L;
      }

      if (!this.__io__equals(edgebase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, edgebase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, edgebase);
         } else {
            __io__generic__copy(this.getEdgebase(), edgebase);
         }

      }
   }

   public ListBase getAreabase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 152L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 116L, this.__io__block, this.__io__blockTable);
   }

   public void setAreabase(ListBase areabase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 152L;
      } else {
         __dna__offset = 116L;
      }

      if (!this.__io__equals(areabase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, areabase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, areabase);
         } else {
            __io__generic__copy(this.getAreabase(), areabase);
         }

      }
   }

   public ListBase getRegionbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 168L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 124L, this.__io__block, this.__io__blockTable);
   }

   public void setRegionbase(ListBase regionbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 168L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(regionbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, regionbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, regionbase);
         } else {
            __io__generic__copy(this.getRegionbase(), regionbase);
         }

      }
   }

   public CPointer<Scene> getScene() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 132L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Scene.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 204), this.__io__blockTable);
   }

   public void setScene(CPointer<Scene> scene) throws IOException {
      long __address = scene == null ? 0L : scene.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 132L, __address);
      }

   }

   public CPointer<Scene> getNewscene() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Scene.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 204), this.__io__blockTable);
   }

   public void setNewscene(CPointer<Scene> newscene) throws IOException {
      long __address = newscene == null ? 0L : newscene.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      }

   }

   public short getWinid() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 200L) : this.__io__block.readShort(this.__io__address + 140L);
   }

   public void setWinid(short winid) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 200L, winid);
      } else {
         this.__io__block.writeShort(this.__io__address + 140L, winid);
      }

   }

   public short getRedraws_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 202L) : this.__io__block.readShort(this.__io__address + 142L);
   }

   public void setRedraws_flag(short redraws_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 202L, redraws_flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 142L, redraws_flag);
      }

   }

   public byte getTemp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 204L) : this.__io__block.readByte(this.__io__address + 144L);
   }

   public void setTemp(byte temp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 204L, temp);
      } else {
         this.__io__block.writeByte(this.__io__address + 144L, temp);
      }

   }

   public byte getState() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 205L) : this.__io__block.readByte(this.__io__address + 145L);
   }

   public void setState(byte state) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 205L, state);
      } else {
         this.__io__block.writeByte(this.__io__address + 145L, state);
      }

   }

   public byte getDo_draw() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 206L) : this.__io__block.readByte(this.__io__address + 146L);
   }

   public void setDo_draw(byte do_draw) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 206L, do_draw);
      } else {
         this.__io__block.writeByte(this.__io__address + 146L, do_draw);
      }

   }

   public byte getDo_refresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 207L) : this.__io__block.readByte(this.__io__address + 147L);
   }

   public void setDo_refresh(byte do_refresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 207L, do_refresh);
      } else {
         this.__io__block.writeByte(this.__io__address + 147L, do_refresh);
      }

   }

   public byte getDo_draw_gesture() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 208L) : this.__io__block.readByte(this.__io__address + 148L);
   }

   public void setDo_draw_gesture(byte do_draw_gesture) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 208L, do_draw_gesture);
      } else {
         this.__io__block.writeByte(this.__io__address + 148L, do_draw_gesture);
      }

   }

   public byte getDo_draw_paintcursor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 209L) : this.__io__block.readByte(this.__io__address + 149L);
   }

   public void setDo_draw_paintcursor(byte do_draw_paintcursor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 209L, do_draw_paintcursor);
      } else {
         this.__io__block.writeByte(this.__io__address + 149L, do_draw_paintcursor);
      }

   }

   public byte getDo_draw_drag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 210L) : this.__io__block.readByte(this.__io__address + 150L);
   }

   public void setDo_draw_drag(byte do_draw_drag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 210L, do_draw_drag);
      } else {
         this.__io__block.writeByte(this.__io__address + 150L, do_draw_drag);
      }

   }

   public byte getSwap() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 211L) : this.__io__block.readByte(this.__io__address + 151L);
   }

   public void setSwap(byte swap) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 211L, swap);
      } else {
         this.__io__block.writeByte(this.__io__address + 151L, swap);
      }

   }

   public byte getSkip_handling() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 212L) : this.__io__block.readByte(this.__io__address + 152L);
   }

   public void setSkip_handling(byte skip_handling) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 212L, skip_handling);
      } else {
         this.__io__block.writeByte(this.__io__address + 152L, skip_handling);
      }

   }

   public byte getScrubbing() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 213L) : this.__io__block.readByte(this.__io__address + 153L);
   }

   public void setScrubbing(byte scrubbing) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 213L, scrubbing);
      } else {
         this.__io__block.writeByte(this.__io__address + 153L, scrubbing);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{6};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 214L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 154L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 214L;
      } else {
         __dna__offset = 154L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public short getMainwin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 220L) : this.__io__block.readShort(this.__io__address + 160L);
   }

   public void setMainwin(short mainwin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 220L, mainwin);
      } else {
         this.__io__block.writeShort(this.__io__address + 160L, mainwin);
      }

   }

   public short getSubwinactive() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 222L) : this.__io__block.readShort(this.__io__address + 162L);
   }

   public void setSubwinactive(short subwinactive) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 222L, subwinactive);
      } else {
         this.__io__block.writeShort(this.__io__address + 162L, subwinactive);
      }

   }

   public CPointer<Object> getAnimtimer() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 224L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 164L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setAnimtimer(CPointer<Object> animtimer) throws IOException {
      long __address = animtimer == null ? 0L : animtimer.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 224L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 164L, __address);
      }

   }

   public CPointer<Object> getContext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 232L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setContext(CPointer<Object> context) throws IOException {
      long __address = context == null ? 0L : context.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 232L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      }

   }

   public CPointer<bScreen> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bScreen.class}, this.__io__block, this.__io__blockTable);
   }
}
