package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 432L,
   size64 = 528L
)
public class Curve extends CFacade {
   public static final int __DNA__SDNA_INDEX = 56;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__bb = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__nurb = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__editnurb = new long[]{116L, 152L};
   public static final long[] __DNA__FIELD__bevobj = new long[]{120L, 160L};
   public static final long[] __DNA__FIELD__taperobj = new long[]{124L, 168L};
   public static final long[] __DNA__FIELD__textoncurve = new long[]{128L, 176L};
   public static final long[] __DNA__FIELD__ipo = new long[]{132L, 184L};
   public static final long[] __DNA__FIELD__key = new long[]{136L, 192L};
   public static final long[] __DNA__FIELD__mat = new long[]{140L, 200L};
   public static final long[] __DNA__FIELD__loc = new long[]{144L, 208L};
   public static final long[] __DNA__FIELD__size = new long[]{156L, 220L};
   public static final long[] __DNA__FIELD__rot = new long[]{168L, 232L};
   public static final long[] __DNA__FIELD__type = new long[]{180L, 244L};
   public static final long[] __DNA__FIELD__texflag = new long[]{182L, 246L};
   public static final long[] __DNA__FIELD__drawflag = new long[]{184L, 248L};
   public static final long[] __DNA__FIELD__twist_mode = new long[]{186L, 250L};
   public static final long[] __DNA__FIELD__twist_smooth = new long[]{188L, 252L};
   public static final long[] __DNA__FIELD__smallcaps_scale = new long[]{192L, 256L};
   public static final long[] __DNA__FIELD__pathlen = new long[]{196L, 260L};
   public static final long[] __DNA__FIELD__bevresol = new long[]{200L, 264L};
   public static final long[] __DNA__FIELD__totcol = new long[]{202L, 266L};
   public static final long[] __DNA__FIELD__flag = new long[]{204L, 268L};
   public static final long[] __DNA__FIELD__width = new long[]{208L, 272L};
   public static final long[] __DNA__FIELD__ext1 = new long[]{212L, 276L};
   public static final long[] __DNA__FIELD__ext2 = new long[]{216L, 280L};
   public static final long[] __DNA__FIELD__resolu = new long[]{220L, 284L};
   public static final long[] __DNA__FIELD__resolv = new long[]{222L, 286L};
   public static final long[] __DNA__FIELD__resolu_ren = new long[]{224L, 288L};
   public static final long[] __DNA__FIELD__resolv_ren = new long[]{226L, 290L};
   public static final long[] __DNA__FIELD__actnu = new long[]{228L, 292L};
   public static final long[] __DNA__FIELD__actvert = new long[]{232L, 296L};
   public static final long[] __DNA__FIELD__pad = new long[]{236L, 300L};
   public static final long[] __DNA__FIELD__lines = new long[]{240L, 304L};
   public static final long[] __DNA__FIELD__spacemode = new long[]{242L, 306L};
   public static final long[] __DNA__FIELD__align_y = new long[]{243L, 307L};
   public static final long[] __DNA__FIELD__spacing = new long[]{244L, 308L};
   public static final long[] __DNA__FIELD__linedist = new long[]{248L, 312L};
   public static final long[] __DNA__FIELD__shear = new long[]{252L, 316L};
   public static final long[] __DNA__FIELD__fsize = new long[]{256L, 320L};
   public static final long[] __DNA__FIELD__wordspace = new long[]{260L, 324L};
   public static final long[] __DNA__FIELD__ulpos = new long[]{264L, 328L};
   public static final long[] __DNA__FIELD__ulheight = new long[]{268L, 332L};
   public static final long[] __DNA__FIELD__xof = new long[]{272L, 336L};
   public static final long[] __DNA__FIELD__yof = new long[]{276L, 340L};
   public static final long[] __DNA__FIELD__linewidth = new long[]{280L, 344L};
   public static final long[] __DNA__FIELD__pos = new long[]{284L, 348L};
   public static final long[] __DNA__FIELD__selstart = new long[]{288L, 352L};
   public static final long[] __DNA__FIELD__selend = new long[]{292L, 356L};
   public static final long[] __DNA__FIELD__len_wchar = new long[]{296L, 360L};
   public static final long[] __DNA__FIELD__len = new long[]{300L, 364L};
   public static final long[] __DNA__FIELD__str = new long[]{304L, 368L};
   public static final long[] __DNA__FIELD__editfont = new long[]{308L, 376L};
   public static final long[] __DNA__FIELD__family = new long[]{312L, 384L};
   public static final long[] __DNA__FIELD__vfont = new long[]{376L, 448L};
   public static final long[] __DNA__FIELD__vfontb = new long[]{380L, 456L};
   public static final long[] __DNA__FIELD__vfonti = new long[]{384L, 464L};
   public static final long[] __DNA__FIELD__vfontbi = new long[]{388L, 472L};
   public static final long[] __DNA__FIELD__tb = new long[]{392L, 480L};
   public static final long[] __DNA__FIELD__totbox = new long[]{396L, 488L};
   public static final long[] __DNA__FIELD__actbox = new long[]{400L, 492L};
   public static final long[] __DNA__FIELD__strinfo = new long[]{404L, 496L};
   public static final long[] __DNA__FIELD__curinfo = new long[]{408L, 504L};
   public static final long[] __DNA__FIELD__ctime = new long[]{416L, 512L};
   public static final long[] __DNA__FIELD__bevfac1 = new long[]{420L, 516L};
   public static final long[] __DNA__FIELD__bevfac2 = new long[]{424L, 520L};
   public static final long[] __DNA__FIELD__bevfac1_mapping = new long[]{428L, 524L};
   public static final long[] __DNA__FIELD__bevfac2_mapping = new long[]{429L, 525L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{430L, 526L};

   public Curve(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Curve(Curve that) {
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

   public CPointer<BoundBox> getBb() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BoundBox.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 151), this.__io__blockTable);
   }

   public void setBb(CPointer<BoundBox> bb) throws IOException {
      long __address = bb == null ? 0L : bb.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public ListBase getNurb() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 136L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 108L, this.__io__block, this.__io__blockTable);
   }

   public void setNurb(ListBase nurb) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 108L;
      }

      if (!this.__io__equals(nurb, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, nurb)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, nurb);
         } else {
            __io__generic__copy(this.getNurb(), nurb);
         }

      }
   }

   public CPointer<EditNurb> getEditnurb() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 116L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{EditNurb.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 55), this.__io__blockTable);
   }

   public void setEditnurb(CPointer<EditNurb> editnurb) throws IOException {
      long __address = editnurb == null ? 0L : editnurb.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 116L, __address);
      }

   }

   public CPointer<BlenderObject> getBevobj() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setBevobj(CPointer<BlenderObject> bevobj) throws IOException {
      long __address = bevobj == null ? 0L : bevobj.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public CPointer<BlenderObject> getTaperobj() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setTaperobj(CPointer<BlenderObject> taperobj) throws IOException {
      long __address = taperobj == null ? 0L : taperobj.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 124L, __address);
      }

   }

   public CPointer<BlenderObject> getTextoncurve() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setTextoncurve(CPointer<BlenderObject> textoncurve) throws IOException {
      long __address = textoncurve == null ? 0L : textoncurve.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 132L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 132L, __address);
      }

   }

   public CPointer<Key> getKey() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Key.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 17), this.__io__blockTable);
   }

   public void setKey(CPointer<Key> key) throws IOException {
      long __address = key == null ? 0L : key.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      }

   }

   public CPointer<CPointer<Material>> getMat() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 140L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Material.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setMat(CPointer<CPointer<Material>> mat) throws IOException {
      long __address = mat == null ? 0L : mat.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 140L, __address);
      }

   }

   public CArrayFacade<Float> getLoc() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 208L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 144L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLoc(CArrayFacade<Float> loc) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 208L;
      } else {
         __dna__offset = 144L;
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
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 220L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 156L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSize(CArrayFacade<Float> size) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 220L;
      } else {
         __dna__offset = 156L;
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
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 232L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 168L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRot(CArrayFacade<Float> rot) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 232L;
      } else {
         __dna__offset = 168L;
      }

      if (!this.__io__equals(rot, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rot)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rot);
         } else {
            __io__generic__copy(this.getRot(), rot);
         }

      }
   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 244L) : this.__io__block.readShort(this.__io__address + 180L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 244L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 180L, type);
      }

   }

   public short getTexflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 246L) : this.__io__block.readShort(this.__io__address + 182L);
   }

   public void setTexflag(short texflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 246L, texflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 182L, texflag);
      }

   }

   public short getDrawflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 248L) : this.__io__block.readShort(this.__io__address + 184L);
   }

   public void setDrawflag(short drawflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 248L, drawflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 184L, drawflag);
      }

   }

   public short getTwist_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 250L) : this.__io__block.readShort(this.__io__address + 186L);
   }

   public void setTwist_mode(short twist_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 250L, twist_mode);
      } else {
         this.__io__block.writeShort(this.__io__address + 186L, twist_mode);
      }

   }

   public float getTwist_smooth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 252L) : this.__io__block.readFloat(this.__io__address + 188L);
   }

   public void setTwist_smooth(float twist_smooth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 252L, twist_smooth);
      } else {
         this.__io__block.writeFloat(this.__io__address + 188L, twist_smooth);
      }

   }

   public float getSmallcaps_scale() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 256L) : this.__io__block.readFloat(this.__io__address + 192L);
   }

   public void setSmallcaps_scale(float smallcaps_scale) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 256L, smallcaps_scale);
      } else {
         this.__io__block.writeFloat(this.__io__address + 192L, smallcaps_scale);
      }

   }

   public int getPathlen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 260L) : this.__io__block.readInt(this.__io__address + 196L);
   }

   public void setPathlen(int pathlen) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 260L, pathlen);
      } else {
         this.__io__block.writeInt(this.__io__address + 196L, pathlen);
      }

   }

   public short getBevresol() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 264L) : this.__io__block.readShort(this.__io__address + 200L);
   }

   public void setBevresol(short bevresol) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 264L, bevresol);
      } else {
         this.__io__block.writeShort(this.__io__address + 200L, bevresol);
      }

   }

   public short getTotcol() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 266L) : this.__io__block.readShort(this.__io__address + 202L);
   }

   public void setTotcol(short totcol) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 266L, totcol);
      } else {
         this.__io__block.writeShort(this.__io__address + 202L, totcol);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 268L) : this.__io__block.readInt(this.__io__address + 204L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 268L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 204L, flag);
      }

   }

   public float getWidth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 272L) : this.__io__block.readFloat(this.__io__address + 208L);
   }

   public void setWidth(float width) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 272L, width);
      } else {
         this.__io__block.writeFloat(this.__io__address + 208L, width);
      }

   }

   public float getExt1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 276L) : this.__io__block.readFloat(this.__io__address + 212L);
   }

   public void setExt1(float ext1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 276L, ext1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 212L, ext1);
      }

   }

   public float getExt2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 280L) : this.__io__block.readFloat(this.__io__address + 216L);
   }

   public void setExt2(float ext2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 280L, ext2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 216L, ext2);
      }

   }

   public short getResolu() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 284L) : this.__io__block.readShort(this.__io__address + 220L);
   }

   public void setResolu(short resolu) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 284L, resolu);
      } else {
         this.__io__block.writeShort(this.__io__address + 220L, resolu);
      }

   }

   public short getResolv() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 286L) : this.__io__block.readShort(this.__io__address + 222L);
   }

   public void setResolv(short resolv) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 286L, resolv);
      } else {
         this.__io__block.writeShort(this.__io__address + 222L, resolv);
      }

   }

   public short getResolu_ren() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 288L) : this.__io__block.readShort(this.__io__address + 224L);
   }

   public void setResolu_ren(short resolu_ren) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 288L, resolu_ren);
      } else {
         this.__io__block.writeShort(this.__io__address + 224L, resolu_ren);
      }

   }

   public short getResolv_ren() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 290L) : this.__io__block.readShort(this.__io__address + 226L);
   }

   public void setResolv_ren(short resolv_ren) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 290L, resolv_ren);
      } else {
         this.__io__block.writeShort(this.__io__address + 226L, resolv_ren);
      }

   }

   public int getActnu() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 292L) : this.__io__block.readInt(this.__io__address + 228L);
   }

   public void setActnu(int actnu) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 292L, actnu);
      } else {
         this.__io__block.writeInt(this.__io__address + 228L, actnu);
      }

   }

   public int getActvert() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 296L) : this.__io__block.readInt(this.__io__address + 232L);
   }

   public void setActvert(int actvert) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 296L, actvert);
      } else {
         this.__io__block.writeInt(this.__io__address + 232L, actvert);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 300L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 236L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 300L;
      } else {
         __dna__offset = 236L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public short getLines() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 304L) : this.__io__block.readShort(this.__io__address + 240L);
   }

   public void setLines(short lines) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 304L, lines);
      } else {
         this.__io__block.writeShort(this.__io__address + 240L, lines);
      }

   }

   public byte getSpacemode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 306L) : this.__io__block.readByte(this.__io__address + 242L);
   }

   public void setSpacemode(byte spacemode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 306L, spacemode);
      } else {
         this.__io__block.writeByte(this.__io__address + 242L, spacemode);
      }

   }

   public byte getAlign_y() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 307L) : this.__io__block.readByte(this.__io__address + 243L);
   }

   public void setAlign_y(byte align_y) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 307L, align_y);
      } else {
         this.__io__block.writeByte(this.__io__address + 243L, align_y);
      }

   }

   public float getSpacing() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 308L) : this.__io__block.readFloat(this.__io__address + 244L);
   }

   public void setSpacing(float spacing) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 308L, spacing);
      } else {
         this.__io__block.writeFloat(this.__io__address + 244L, spacing);
      }

   }

   public float getLinedist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 312L) : this.__io__block.readFloat(this.__io__address + 248L);
   }

   public void setLinedist(float linedist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 312L, linedist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 248L, linedist);
      }

   }

   public float getShear() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 316L) : this.__io__block.readFloat(this.__io__address + 252L);
   }

   public void setShear(float shear) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 316L, shear);
      } else {
         this.__io__block.writeFloat(this.__io__address + 252L, shear);
      }

   }

   public float getFsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 320L) : this.__io__block.readFloat(this.__io__address + 256L);
   }

   public void setFsize(float fsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 320L, fsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 256L, fsize);
      }

   }

   public float getWordspace() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 324L) : this.__io__block.readFloat(this.__io__address + 260L);
   }

   public void setWordspace(float wordspace) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 324L, wordspace);
      } else {
         this.__io__block.writeFloat(this.__io__address + 260L, wordspace);
      }

   }

   public float getUlpos() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 328L) : this.__io__block.readFloat(this.__io__address + 264L);
   }

   public void setUlpos(float ulpos) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 328L, ulpos);
      } else {
         this.__io__block.writeFloat(this.__io__address + 264L, ulpos);
      }

   }

   public float getUlheight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 332L) : this.__io__block.readFloat(this.__io__address + 268L);
   }

   public void setUlheight(float ulheight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 332L, ulheight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 268L, ulheight);
      }

   }

   public float getXof() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 336L) : this.__io__block.readFloat(this.__io__address + 272L);
   }

   public void setXof(float xof) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 336L, xof);
      } else {
         this.__io__block.writeFloat(this.__io__address + 272L, xof);
      }

   }

   public float getYof() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 340L) : this.__io__block.readFloat(this.__io__address + 276L);
   }

   public void setYof(float yof) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 340L, yof);
      } else {
         this.__io__block.writeFloat(this.__io__address + 276L, yof);
      }

   }

   public float getLinewidth() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 344L) : this.__io__block.readFloat(this.__io__address + 280L);
   }

   public void setLinewidth(float linewidth) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 344L, linewidth);
      } else {
         this.__io__block.writeFloat(this.__io__address + 280L, linewidth);
      }

   }

   public int getPos() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 348L) : this.__io__block.readInt(this.__io__address + 284L);
   }

   public void setPos(int pos) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 348L, pos);
      } else {
         this.__io__block.writeInt(this.__io__address + 284L, pos);
      }

   }

   public int getSelstart() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 352L) : this.__io__block.readInt(this.__io__address + 288L);
   }

   public void setSelstart(int selstart) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 352L, selstart);
      } else {
         this.__io__block.writeInt(this.__io__address + 288L, selstart);
      }

   }

   public int getSelend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 356L) : this.__io__block.readInt(this.__io__address + 292L);
   }

   public void setSelend(int selend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 356L, selend);
      } else {
         this.__io__block.writeInt(this.__io__address + 292L, selend);
      }

   }

   public int getLen_wchar() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 360L) : this.__io__block.readInt(this.__io__address + 296L);
   }

   public void setLen_wchar(int len_wchar) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 360L, len_wchar);
      } else {
         this.__io__block.writeInt(this.__io__address + 296L, len_wchar);
      }

   }

   public int getLen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 364L) : this.__io__block.readInt(this.__io__address + 300L);
   }

   public void setLen(int len) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 364L, len);
      } else {
         this.__io__block.writeInt(this.__io__address + 300L, len);
      }

   }

   public CPointer<Byte> getStr() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 368L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 304L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setStr(CPointer<Byte> str) throws IOException {
      long __address = str == null ? 0L : str.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 368L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 304L, __address);
      }

   }

   public CPointer<Object> getEditfont() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 376L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 308L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setEditfont(CPointer<Object> editfont) throws IOException {
      long __address = editfont == null ? 0L : editfont.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 376L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 308L, __address);
      }

   }

   public CArrayFacade<Byte> getFamily() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 384L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 312L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setFamily(CArrayFacade<Byte> family) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 384L;
      } else {
         __dna__offset = 312L;
      }

      if (!this.__io__equals(family, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, family)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, family);
         } else {
            __io__generic__copy(this.getFamily(), family);
         }

      }
   }

   public CPointer<VFont> getVfont() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 448L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 376L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{VFont.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 47), this.__io__blockTable);
   }

   public void setVfont(CPointer<VFont> vfont) throws IOException {
      long __address = vfont == null ? 0L : vfont.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 448L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 376L, __address);
      }

   }

   public CPointer<VFont> getVfontb() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 456L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 380L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{VFont.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 47), this.__io__blockTable);
   }

   public void setVfontb(CPointer<VFont> vfontb) throws IOException {
      long __address = vfontb == null ? 0L : vfontb.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 456L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 380L, __address);
      }

   }

   public CPointer<VFont> getVfonti() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 464L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 384L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{VFont.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 47), this.__io__blockTable);
   }

   public void setVfonti(CPointer<VFont> vfonti) throws IOException {
      long __address = vfonti == null ? 0L : vfonti.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 464L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 384L, __address);
      }

   }

   public CPointer<VFont> getVfontbi() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 472L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 388L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{VFont.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 47), this.__io__blockTable);
   }

   public void setVfontbi(CPointer<VFont> vfontbi) throws IOException {
      long __address = vfontbi == null ? 0L : vfontbi.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 472L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 388L, __address);
      }

   }

   public CPointer<TextBox> getTb() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 480L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 392L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{TextBox.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 54), this.__io__blockTable);
   }

   public void setTb(CPointer<TextBox> tb) throws IOException {
      long __address = tb == null ? 0L : tb.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 480L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 392L, __address);
      }

   }

   public int getTotbox() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 488L) : this.__io__block.readInt(this.__io__address + 396L);
   }

   public void setTotbox(int totbox) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 488L, totbox);
      } else {
         this.__io__block.writeInt(this.__io__address + 396L, totbox);
      }

   }

   public int getActbox() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 492L) : this.__io__block.readInt(this.__io__address + 400L);
   }

   public void setActbox(int actbox) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 492L, actbox);
      } else {
         this.__io__block.writeInt(this.__io__address + 400L, actbox);
      }

   }

   public CPointer<CharInfo> getStrinfo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 496L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 404L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CharInfo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 53), this.__io__blockTable);
   }

   public void setStrinfo(CPointer<CharInfo> strinfo) throws IOException {
      long __address = strinfo == null ? 0L : strinfo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 496L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 404L, __address);
      }

   }

   public CharInfo getCurinfo() throws IOException {
      return this.__io__pointersize == 8 ? new CharInfo(this.__io__address + 504L, this.__io__block, this.__io__blockTable) : new CharInfo(this.__io__address + 408L, this.__io__block, this.__io__blockTable);
   }

   public void setCurinfo(CharInfo curinfo) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 504L;
      } else {
         __dna__offset = 408L;
      }

      if (!this.__io__equals(curinfo, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, curinfo)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, curinfo);
         } else {
            __io__generic__copy(this.getCurinfo(), curinfo);
         }

      }
   }

   public float getCtime() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 512L) : this.__io__block.readFloat(this.__io__address + 416L);
   }

   public void setCtime(float ctime) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 512L, ctime);
      } else {
         this.__io__block.writeFloat(this.__io__address + 416L, ctime);
      }

   }

   public float getBevfac1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 516L) : this.__io__block.readFloat(this.__io__address + 420L);
   }

   public void setBevfac1(float bevfac1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 516L, bevfac1);
      } else {
         this.__io__block.writeFloat(this.__io__address + 420L, bevfac1);
      }

   }

   public float getBevfac2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 520L) : this.__io__block.readFloat(this.__io__address + 424L);
   }

   public void setBevfac2(float bevfac2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 520L, bevfac2);
      } else {
         this.__io__block.writeFloat(this.__io__address + 424L, bevfac2);
      }

   }

   public byte getBevfac1_mapping() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 524L) : this.__io__block.readByte(this.__io__address + 428L);
   }

   public void setBevfac1_mapping(byte bevfac1_mapping) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 524L, bevfac1_mapping);
      } else {
         this.__io__block.writeByte(this.__io__address + 428L, bevfac1_mapping);
      }

   }

   public byte getBevfac2_mapping() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 525L) : this.__io__block.readByte(this.__io__address + 429L);
   }

   public void setBevfac2_mapping(byte bevfac2_mapping) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 525L, bevfac2_mapping);
      } else {
         this.__io__block.writeByte(this.__io__address + 429L, bevfac2_mapping);
      }

   }

   public CArrayFacade<Byte> getPad2() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 526L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 430L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad2(CArrayFacade<Byte> pad2) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 526L;
      } else {
         __dna__offset = 430L;
      }

      if (!this.__io__equals(pad2, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad2)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad2);
         } else {
            __io__generic__copy(this.getPad2(), pad2);
         }

      }
   }

   public CPointer<Curve> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Curve.class}, this.__io__block, this.__io__blockTable);
   }
}
