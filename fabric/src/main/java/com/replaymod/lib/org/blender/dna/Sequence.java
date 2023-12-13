package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 280L,
   size64 = 376L
)
public class Sequence extends CFacade {
   public static final int __DNA__SDNA_INDEX = 272;
   public static final long[] __DNA__FIELD__next = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__prev = new long[]{4L, 8L};
   public static final long[] __DNA__FIELD__tmp = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__lib = new long[]{12L, 24L};
   public static final long[] __DNA__FIELD__name = new long[]{16L, 32L};
   public static final long[] __DNA__FIELD__flag = new long[]{80L, 96L};
   public static final long[] __DNA__FIELD__type = new long[]{84L, 100L};
   public static final long[] __DNA__FIELD__len = new long[]{88L, 104L};
   public static final long[] __DNA__FIELD__start = new long[]{92L, 108L};
   public static final long[] __DNA__FIELD__startofs = new long[]{96L, 112L};
   public static final long[] __DNA__FIELD__endofs = new long[]{100L, 116L};
   public static final long[] __DNA__FIELD__startstill = new long[]{104L, 120L};
   public static final long[] __DNA__FIELD__endstill = new long[]{108L, 124L};
   public static final long[] __DNA__FIELD__machine = new long[]{112L, 128L};
   public static final long[] __DNA__FIELD__depth = new long[]{116L, 132L};
   public static final long[] __DNA__FIELD__startdisp = new long[]{120L, 136L};
   public static final long[] __DNA__FIELD__enddisp = new long[]{124L, 140L};
   public static final long[] __DNA__FIELD__sat = new long[]{128L, 144L};
   public static final long[] __DNA__FIELD__mul = new long[]{132L, 148L};
   public static final long[] __DNA__FIELD__handsize = new long[]{136L, 152L};
   public static final long[] __DNA__FIELD__anim_preseek = new long[]{140L, 156L};
   public static final long[] __DNA__FIELD__streamindex = new long[]{142L, 158L};
   public static final long[] __DNA__FIELD__multicam_source = new long[]{144L, 160L};
   public static final long[] __DNA__FIELD__clip_flag = new long[]{148L, 164L};
   public static final long[] __DNA__FIELD__strip = new long[]{152L, 168L};
   public static final long[] __DNA__FIELD__ipo = new long[]{156L, 176L};
   public static final long[] __DNA__FIELD__scene = new long[]{160L, 184L};
   public static final long[] __DNA__FIELD__scene_camera = new long[]{164L, 192L};
   public static final long[] __DNA__FIELD__clip = new long[]{168L, 200L};
   public static final long[] __DNA__FIELD__mask = new long[]{172L, 208L};
   public static final long[] __DNA__FIELD__anims = new long[]{176L, 216L};
   public static final long[] __DNA__FIELD__effect_fader = new long[]{184L, 232L};
   public static final long[] __DNA__FIELD__speed_fader = new long[]{188L, 236L};
   public static final long[] __DNA__FIELD__seq1 = new long[]{192L, 240L};
   public static final long[] __DNA__FIELD__seq2 = new long[]{196L, 248L};
   public static final long[] __DNA__FIELD__seq3 = new long[]{200L, 256L};
   public static final long[] __DNA__FIELD__seqbase = new long[]{204L, 264L};
   public static final long[] __DNA__FIELD__sound = new long[]{212L, 280L};
   public static final long[] __DNA__FIELD__scene_sound = new long[]{216L, 288L};
   public static final long[] __DNA__FIELD__volume = new long[]{220L, 296L};
   public static final long[] __DNA__FIELD__pitch = new long[]{224L, 300L};
   public static final long[] __DNA__FIELD__pan = new long[]{228L, 304L};
   public static final long[] __DNA__FIELD__strobe = new long[]{232L, 308L};
   public static final long[] __DNA__FIELD__effectdata = new long[]{236L, 312L};
   public static final long[] __DNA__FIELD__anim_startofs = new long[]{240L, 320L};
   public static final long[] __DNA__FIELD__anim_endofs = new long[]{244L, 324L};
   public static final long[] __DNA__FIELD__blend_mode = new long[]{248L, 328L};
   public static final long[] __DNA__FIELD__blend_opacity = new long[]{252L, 332L};
   public static final long[] __DNA__FIELD__sfra = new long[]{256L, 336L};
   public static final long[] __DNA__FIELD__alpha_mode = new long[]{260L, 340L};
   public static final long[] __DNA__FIELD__pad = new long[]{261L, 341L};
   public static final long[] __DNA__FIELD__views_format = new long[]{263L, 343L};
   public static final long[] __DNA__FIELD__stereo3d_format = new long[]{264L, 344L};
   public static final long[] __DNA__FIELD__prop = new long[]{268L, 352L};
   public static final long[] __DNA__FIELD__modifiers = new long[]{272L, 360L};

   public Sequence(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Sequence(Sequence that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public CPointer<Sequence> getNext() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 0L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Sequence.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 272), this.__io__blockTable);
   }

   public void setNext(CPointer<Sequence> next) throws IOException {
      long __address = next == null ? 0L : next.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 0L, __address);
      }

   }

   public CPointer<Sequence> getPrev() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Sequence.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 272), this.__io__blockTable);
   }

   public void setPrev(CPointer<Sequence> prev) throws IOException {
      long __address = prev == null ? 0L : prev.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4L, __address);
      }

   }

   public CPointer<Object> getTmp() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 16L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 8L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setTmp(CPointer<Object> tmp) throws IOException {
      long __address = tmp == null ? 0L : tmp.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 16L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 8L, __address);
      }

   }

   public CPointer<Object> getLib() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 24L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 12L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setLib(CPointer<Object> lib) throws IOException {
      long __address = lib == null ? 0L : lib.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 24L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 12L, __address);
      }

   }

   public CArrayFacade<Byte> getName() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 32L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setName(CArrayFacade<Byte> name) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 32L;
      } else {
         __dna__offset = 16L;
      }

      if (!this.__io__equals(name, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, name)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, name);
         } else {
            __io__generic__copy(this.getName(), name);
         }

      }
   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 96L) : this.__io__block.readInt(this.__io__address + 80L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 96L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 80L, flag);
      }

   }

   public int getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 100L) : this.__io__block.readInt(this.__io__address + 84L);
   }

   public void setType(int type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 100L, type);
      } else {
         this.__io__block.writeInt(this.__io__address + 84L, type);
      }

   }

   public int getLen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 104L) : this.__io__block.readInt(this.__io__address + 88L);
   }

   public void setLen(int len) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 104L, len);
      } else {
         this.__io__block.writeInt(this.__io__address + 88L, len);
      }

   }

   public int getStart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 108L) : this.__io__block.readInt(this.__io__address + 92L);
   }

   public void setStart(int start) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 108L, start);
      } else {
         this.__io__block.writeInt(this.__io__address + 92L, start);
      }

   }

   public int getStartofs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 112L) : this.__io__block.readInt(this.__io__address + 96L);
   }

   public void setStartofs(int startofs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 112L, startofs);
      } else {
         this.__io__block.writeInt(this.__io__address + 96L, startofs);
      }

   }

   public int getEndofs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 116L) : this.__io__block.readInt(this.__io__address + 100L);
   }

   public void setEndofs(int endofs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 116L, endofs);
      } else {
         this.__io__block.writeInt(this.__io__address + 100L, endofs);
      }

   }

   public int getStartstill() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 120L) : this.__io__block.readInt(this.__io__address + 104L);
   }

   public void setStartstill(int startstill) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 120L, startstill);
      } else {
         this.__io__block.writeInt(this.__io__address + 104L, startstill);
      }

   }

   public int getEndstill() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 124L) : this.__io__block.readInt(this.__io__address + 108L);
   }

   public void setEndstill(int endstill) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 124L, endstill);
      } else {
         this.__io__block.writeInt(this.__io__address + 108L, endstill);
      }

   }

   public int getMachine() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 128L) : this.__io__block.readInt(this.__io__address + 112L);
   }

   public void setMachine(int machine) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 128L, machine);
      } else {
         this.__io__block.writeInt(this.__io__address + 112L, machine);
      }

   }

   public int getDepth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 132L) : this.__io__block.readInt(this.__io__address + 116L);
   }

   public void setDepth(int depth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 132L, depth);
      } else {
         this.__io__block.writeInt(this.__io__address + 116L, depth);
      }

   }

   public int getStartdisp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 136L) : this.__io__block.readInt(this.__io__address + 120L);
   }

   public void setStartdisp(int startdisp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 136L, startdisp);
      } else {
         this.__io__block.writeInt(this.__io__address + 120L, startdisp);
      }

   }

   public int getEnddisp() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 140L) : this.__io__block.readInt(this.__io__address + 124L);
   }

   public void setEnddisp(int enddisp) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 140L, enddisp);
      } else {
         this.__io__block.writeInt(this.__io__address + 124L, enddisp);
      }

   }

   public float getSat() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setSat(float sat) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, sat);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, sat);
      }

   }

   public float getMul() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 148L) : this.__io__block.readFloat(this.__io__address + 132L);
   }

   public void setMul(float mul) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 148L, mul);
      } else {
         this.__io__block.writeFloat(this.__io__address + 132L, mul);
      }

   }

   public float getHandsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 136L);
   }

   public void setHandsize(float handsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, handsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 136L, handsize);
      }

   }

   public short getAnim_preseek() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 156L) : this.__io__block.readShort(this.__io__address + 140L);
   }

   public void setAnim_preseek(short anim_preseek) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 156L, anim_preseek);
      } else {
         this.__io__block.writeShort(this.__io__address + 140L, anim_preseek);
      }

   }

   public short getStreamindex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 158L) : this.__io__block.readShort(this.__io__address + 142L);
   }

   public void setStreamindex(short streamindex) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 158L, streamindex);
      } else {
         this.__io__block.writeShort(this.__io__address + 142L, streamindex);
      }

   }

   public int getMulticam_source() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 160L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setMulticam_source(int multicam_source) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 160L, multicam_source);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, multicam_source);
      }

   }

   public int getClip_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 164L) : this.__io__block.readInt(this.__io__address + 148L);
   }

   public void setClip_flag(int clip_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 164L, clip_flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 148L, clip_flag);
      }

   }

   public CPointer<Strip> getStrip() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Strip.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 271), this.__io__blockTable);
   }

   public void setStrip(CPointer<Strip> strip) throws IOException {
      long __address = strip == null ? 0L : strip.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 156L, __address);
      }

   }

   public CPointer<Scene> getScene() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Scene.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 204), this.__io__blockTable);
   }

   public void setScene(CPointer<Scene> scene) throws IOException {
      long __address = scene == null ? 0L : scene.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      }

   }

   public CPointer<BlenderObject> getScene_camera() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 164L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setScene_camera(CPointer<BlenderObject> scene_camera) throws IOException {
      long __address = scene_camera == null ? 0L : scene_camera.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 164L, __address);
      }

   }

   public CPointer<MovieClip> getClip() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieClip.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 545), this.__io__blockTable);
   }

   public void setClip(CPointer<MovieClip> clip) throws IOException {
      long __address = clip == null ? 0L : clip.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      }

   }

   public CPointer<Mask> getMask() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 208L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 172L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Mask.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 565), this.__io__blockTable);
   }

   public void setMask(CPointer<Mask> mask) throws IOException {
      long __address = mask == null ? 0L : mask.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 208L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 172L, __address);
      }

   }

   public ListBase getAnims() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 216L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 176L, this.__io__block, this.__io__blockTable);
   }

   public void setAnims(ListBase anims) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 216L;
      } else {
         __dna__offset = 176L;
      }

      if (!this.__io__equals(anims, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, anims)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, anims);
         } else {
            __io__generic__copy(this.getAnims(), anims);
         }

      }
   }

   public float getEffect_fader() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 232L) : this.__io__block.readFloat(this.__io__address + 184L);
   }

   public void setEffect_fader(float effect_fader) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 232L, effect_fader);
      } else {
         this.__io__block.writeFloat(this.__io__address + 184L, effect_fader);
      }

   }

   public float getSpeed_fader() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 236L) : this.__io__block.readFloat(this.__io__address + 188L);
   }

   public void setSpeed_fader(float speed_fader) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 236L, speed_fader);
      } else {
         this.__io__block.writeFloat(this.__io__address + 188L, speed_fader);
      }

   }

   public CPointer<Sequence> getSeq1() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 240L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Sequence.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 272), this.__io__blockTable);
   }

   public void setSeq1(CPointer<Sequence> seq1) throws IOException {
      long __address = seq1 == null ? 0L : seq1.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 240L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      }

   }

   public CPointer<Sequence> getSeq2() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 248L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 196L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Sequence.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 272), this.__io__blockTable);
   }

   public void setSeq2(CPointer<Sequence> seq2) throws IOException {
      long __address = seq2 == null ? 0L : seq2.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 248L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 196L, __address);
      }

   }

   public CPointer<Sequence> getSeq3() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 256L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Sequence.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 272), this.__io__blockTable);
   }

   public void setSeq3(CPointer<Sequence> seq3) throws IOException {
      long __address = seq3 == null ? 0L : seq3.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 256L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      }

   }

   public ListBase getSeqbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 264L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 204L, this.__io__block, this.__io__blockTable);
   }

   public void setSeqbase(ListBase seqbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 264L;
      } else {
         __dna__offset = 204L;
      }

      if (!this.__io__equals(seqbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, seqbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, seqbase);
         } else {
            __io__generic__copy(this.getSeqbase(), seqbase);
         }

      }
   }

   public CPointer<bSound> getSound() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 280L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 212L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bSound.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 339), this.__io__blockTable);
   }

   public void setSound(CPointer<bSound> sound) throws IOException {
      long __address = sound == null ? 0L : sound.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 280L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 212L, __address);
      }

   }

   public CPointer<Object> getScene_sound() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 288L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 216L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setScene_sound(CPointer<Object> scene_sound) throws IOException {
      long __address = scene_sound == null ? 0L : scene_sound.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 288L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 216L, __address);
      }

   }

   public float getVolume() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 296L) : this.__io__block.readFloat(this.__io__address + 220L);
   }

   public void setVolume(float volume) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 296L, volume);
      } else {
         this.__io__block.writeFloat(this.__io__address + 220L, volume);
      }

   }

   public float getPitch() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 300L) : this.__io__block.readFloat(this.__io__address + 224L);
   }

   public void setPitch(float pitch) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 300L, pitch);
      } else {
         this.__io__block.writeFloat(this.__io__address + 224L, pitch);
      }

   }

   public float getPan() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 304L) : this.__io__block.readFloat(this.__io__address + 228L);
   }

   public void setPan(float pan) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 304L, pan);
      } else {
         this.__io__block.writeFloat(this.__io__address + 228L, pan);
      }

   }

   public float getStrobe() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 308L) : this.__io__block.readFloat(this.__io__address + 232L);
   }

   public void setStrobe(float strobe) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 308L, strobe);
      } else {
         this.__io__block.writeFloat(this.__io__address + 232L, strobe);
      }

   }

   public CPointer<Object> getEffectdata() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 312L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 236L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setEffectdata(CPointer<Object> effectdata) throws IOException {
      long __address = effectdata == null ? 0L : effectdata.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 312L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 236L, __address);
      }

   }

   public int getAnim_startofs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 320L) : this.__io__block.readInt(this.__io__address + 240L);
   }

   public void setAnim_startofs(int anim_startofs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 320L, anim_startofs);
      } else {
         this.__io__block.writeInt(this.__io__address + 240L, anim_startofs);
      }

   }

   public int getAnim_endofs() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 324L) : this.__io__block.readInt(this.__io__address + 244L);
   }

   public void setAnim_endofs(int anim_endofs) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 324L, anim_endofs);
      } else {
         this.__io__block.writeInt(this.__io__address + 244L, anim_endofs);
      }

   }

   public int getBlend_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 328L) : this.__io__block.readInt(this.__io__address + 248L);
   }

   public void setBlend_mode(int blend_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 328L, blend_mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 248L, blend_mode);
      }

   }

   public float getBlend_opacity() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 332L) : this.__io__block.readFloat(this.__io__address + 252L);
   }

   public void setBlend_opacity(float blend_opacity) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 332L, blend_opacity);
      } else {
         this.__io__block.writeFloat(this.__io__address + 252L, blend_opacity);
      }

   }

   public int getSfra() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 336L) : this.__io__block.readInt(this.__io__address + 256L);
   }

   public void setSfra(int sfra) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 336L, sfra);
      } else {
         this.__io__block.writeInt(this.__io__address + 256L, sfra);
      }

   }

   public byte getAlpha_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 340L) : this.__io__block.readByte(this.__io__address + 260L);
   }

   public void setAlpha_mode(byte alpha_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 340L, alpha_mode);
      } else {
         this.__io__block.writeByte(this.__io__address + 260L, alpha_mode);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 341L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 261L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 341L;
      } else {
         __dna__offset = 261L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public byte getViews_format() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 343L) : this.__io__block.readByte(this.__io__address + 263L);
   }

   public void setViews_format(byte views_format) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 343L, views_format);
      } else {
         this.__io__block.writeByte(this.__io__address + 263L, views_format);
      }

   }

   public CPointer<Stereo3dFormat> getStereo3d_format() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 344L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 264L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Stereo3dFormat.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 175), this.__io__blockTable);
   }

   public void setStereo3d_format(CPointer<Stereo3dFormat> stereo3d_format) throws IOException {
      long __address = stereo3d_format == null ? 0L : stereo3d_format.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 344L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 264L, __address);
      }

   }

   public CPointer<IDProperty> getProp() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 352L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 268L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{IDProperty.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 9), this.__io__blockTable);
   }

   public void setProp(CPointer<IDProperty> prop) throws IOException {
      long __address = prop == null ? 0L : prop.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 352L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 268L, __address);
      }

   }

   public ListBase getModifiers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 360L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 272L, this.__io__block, this.__io__blockTable);
   }

   public void setModifiers(ListBase modifiers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 360L;
      } else {
         __dna__offset = 272L;
      }

      if (!this.__io__equals(modifiers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, modifiers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, modifiers);
         } else {
            __io__generic__copy(this.getModifiers(), modifiers);
         }

      }
   }

   public CPointer<Sequence> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Sequence.class}, this.__io__block, this.__io__blockTable);
   }
}
