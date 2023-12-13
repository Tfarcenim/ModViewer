package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1176L,
   size64 = 1440L
)
public class BlenderObject extends CFacade {
   public static final int __DNA__SDNA_INDEX = 153;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__sculpt = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__type = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__partype = new long[]{110L, 138L};
   public static final long[] __DNA__FIELD__par1 = new long[]{112L, 140L};
   public static final long[] __DNA__FIELD__par2 = new long[]{116L, 144L};
   public static final long[] __DNA__FIELD__par3 = new long[]{120L, 148L};
   public static final long[] __DNA__FIELD__parsubstr = new long[]{124L, 152L};
   public static final long[] __DNA__FIELD__parent = new long[]{188L, 216L};
   public static final long[] __DNA__FIELD__track = new long[]{192L, 224L};
   public static final long[] __DNA__FIELD__proxy = new long[]{196L, 232L};
   public static final long[] __DNA__FIELD__proxy_group = new long[]{200L, 240L};
   public static final long[] __DNA__FIELD__proxy_from = new long[]{204L, 248L};
   public static final long[] __DNA__FIELD__ipo = new long[]{208L, 256L};
   public static final long[] __DNA__FIELD__bb = new long[]{212L, 264L};
   public static final long[] __DNA__FIELD__action = new long[]{216L, 272L};
   public static final long[] __DNA__FIELD__poselib = new long[]{220L, 280L};
   public static final long[] __DNA__FIELD__pose = new long[]{224L, 288L};
   public static final long[] __DNA__FIELD__data = new long[]{228L, 296L};
   public static final long[] __DNA__FIELD__gpd = new long[]{232L, 304L};
   public static final long[] __DNA__FIELD__avs = new long[]{236L, 312L};
   public static final long[] __DNA__FIELD__mpath = new long[]{284L, 360L};
   public static final long[] __DNA__FIELD__constraintChannels = new long[]{288L, 368L};
   public static final long[] __DNA__FIELD__effect = new long[]{296L, 384L};
   public static final long[] __DNA__FIELD__defbase = new long[]{304L, 400L};
   public static final long[] __DNA__FIELD__modifiers = new long[]{312L, 416L};
   public static final long[] __DNA__FIELD__mode = new long[]{320L, 432L};
   public static final long[] __DNA__FIELD__restore_mode = new long[]{324L, 436L};
   public static final long[] __DNA__FIELD__mat = new long[]{328L, 440L};
   public static final long[] __DNA__FIELD__matbits = new long[]{332L, 448L};
   public static final long[] __DNA__FIELD__totcol = new long[]{336L, 456L};
   public static final long[] __DNA__FIELD__actcol = new long[]{340L, 460L};
   public static final long[] __DNA__FIELD__loc = new long[]{344L, 464L};
   public static final long[] __DNA__FIELD__dloc = new long[]{356L, 476L};
   public static final long[] __DNA__FIELD__orig = new long[]{368L, 488L};
   public static final long[] __DNA__FIELD__size = new long[]{380L, 500L};
   public static final long[] __DNA__FIELD__dsize = new long[]{392L, 512L};
   public static final long[] __DNA__FIELD__dscale = new long[]{404L, 524L};
   public static final long[] __DNA__FIELD__rot = new long[]{416L, 536L};
   public static final long[] __DNA__FIELD__drot = new long[]{428L, 548L};
   public static final long[] __DNA__FIELD__quat = new long[]{440L, 560L};
   public static final long[] __DNA__FIELD__dquat = new long[]{456L, 576L};
   public static final long[] __DNA__FIELD__rotAxis = new long[]{472L, 592L};
   public static final long[] __DNA__FIELD__drotAxis = new long[]{484L, 604L};
   public static final long[] __DNA__FIELD__rotAngle = new long[]{496L, 616L};
   public static final long[] __DNA__FIELD__drotAngle = new long[]{500L, 620L};
   public static final long[] __DNA__FIELD__obmat = new long[]{504L, 624L};
   public static final long[] __DNA__FIELD__parentinv = new long[]{568L, 688L};
   public static final long[] __DNA__FIELD__constinv = new long[]{632L, 752L};
   public static final long[] __DNA__FIELD__imat = new long[]{696L, 816L};
   public static final long[] __DNA__FIELD__imat_ren = new long[]{760L, 880L};
   public static final long[] __DNA__FIELD__lay = new long[]{824L, 944L};
   public static final long[] __DNA__FIELD__flag = new long[]{828L, 948L};
   public static final long[] __DNA__FIELD__colbits = new long[]{830L, 950L};
   public static final long[] __DNA__FIELD__transflag = new long[]{832L, 952L};
   public static final long[] __DNA__FIELD__protectflag = new long[]{834L, 954L};
   public static final long[] __DNA__FIELD__trackflag = new long[]{836L, 956L};
   public static final long[] __DNA__FIELD__upflag = new long[]{838L, 958L};
   public static final long[] __DNA__FIELD__nlaflag = new long[]{840L, 960L};
   public static final long[] __DNA__FIELD__scaflag = new long[]{842L, 962L};
   public static final long[] __DNA__FIELD__scavisflag = new long[]{844L, 964L};
   public static final long[] __DNA__FIELD__depsflag = new long[]{845L, 965L};
   public static final long[] __DNA__FIELD__lastNeedMapping = new long[]{846L, 966L};
   public static final long[] __DNA__FIELD__pad = new long[]{847L, 967L};
   public static final long[] __DNA__FIELD__dupon = new long[]{848L, 968L};
   public static final long[] __DNA__FIELD__dupoff = new long[]{852L, 972L};
   public static final long[] __DNA__FIELD__dupsta = new long[]{856L, 976L};
   public static final long[] __DNA__FIELD__dupend = new long[]{860L, 980L};
   public static final long[] __DNA__FIELD__mass = new long[]{864L, 984L};
   public static final long[] __DNA__FIELD__damping = new long[]{868L, 988L};
   public static final long[] __DNA__FIELD__inertia = new long[]{872L, 992L};
   public static final long[] __DNA__FIELD__formfactor = new long[]{876L, 996L};
   public static final long[] __DNA__FIELD__rdamping = new long[]{880L, 1000L};
   public static final long[] __DNA__FIELD__margin = new long[]{884L, 1004L};
   public static final long[] __DNA__FIELD__max_vel = new long[]{888L, 1008L};
   public static final long[] __DNA__FIELD__min_vel = new long[]{892L, 1012L};
   public static final long[] __DNA__FIELD__max_angvel = new long[]{896L, 1016L};
   public static final long[] __DNA__FIELD__min_angvel = new long[]{900L, 1020L};
   public static final long[] __DNA__FIELD__obstacleRad = new long[]{904L, 1024L};
   public static final long[] __DNA__FIELD__step_height = new long[]{908L, 1028L};
   public static final long[] __DNA__FIELD__jump_speed = new long[]{912L, 1032L};
   public static final long[] __DNA__FIELD__fall_speed = new long[]{916L, 1036L};
   public static final long[] __DNA__FIELD__max_jumps = new long[]{920L, 1040L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{921L, 1041L};
   public static final long[] __DNA__FIELD__col_group = new long[]{924L, 1044L};
   public static final long[] __DNA__FIELD__col_mask = new long[]{926L, 1046L};
   public static final long[] __DNA__FIELD__rotmode = new long[]{928L, 1048L};
   public static final long[] __DNA__FIELD__boundtype = new long[]{930L, 1050L};
   public static final long[] __DNA__FIELD__collision_boundtype = new long[]{931L, 1051L};
   public static final long[] __DNA__FIELD__dtx = new long[]{932L, 1052L};
   public static final long[] __DNA__FIELD__dt = new long[]{934L, 1054L};
   public static final long[] __DNA__FIELD__empty_drawtype = new long[]{935L, 1055L};
   public static final long[] __DNA__FIELD__empty_drawsize = new long[]{936L, 1056L};
   public static final long[] __DNA__FIELD__dupfacesca = new long[]{940L, 1060L};
   public static final long[] __DNA__FIELD__prop = new long[]{944L, 1064L};
   public static final long[] __DNA__FIELD__sensors = new long[]{952L, 1080L};
   public static final long[] __DNA__FIELD__controllers = new long[]{960L, 1096L};
   public static final long[] __DNA__FIELD__actuators = new long[]{968L, 1112L};
   public static final long[] __DNA__FIELD__sf = new long[]{976L, 1128L};
   public static final long[] __DNA__FIELD__index = new long[]{980L, 1132L};
   public static final long[] __DNA__FIELD__actdef = new long[]{982L, 1134L};
   public static final long[] __DNA__FIELD__col = new long[]{984L, 1136L};
   public static final long[] __DNA__FIELD__gameflag = new long[]{1000L, 1152L};
   public static final long[] __DNA__FIELD__gameflag2 = new long[]{1004L, 1156L};
   public static final long[] __DNA__FIELD__bsoft = new long[]{1008L, 1160L};
   public static final long[] __DNA__FIELD__restrictflag = new long[]{1012L, 1168L};
   public static final long[] __DNA__FIELD__recalc = new long[]{1013L, 1169L};
   public static final long[] __DNA__FIELD__softflag = new long[]{1014L, 1170L};
   public static final long[] __DNA__FIELD__anisotropicFriction = new long[]{1016L, 1172L};
   public static final long[] __DNA__FIELD__constraints = new long[]{1028L, 1184L};
   public static final long[] __DNA__FIELD__nlastrips = new long[]{1036L, 1200L};
   public static final long[] __DNA__FIELD__hooks = new long[]{1044L, 1216L};
   public static final long[] __DNA__FIELD__particlesystem = new long[]{1052L, 1232L};
   public static final long[] __DNA__FIELD__pd = new long[]{1060L, 1248L};
   public static final long[] __DNA__FIELD__soft = new long[]{1064L, 1256L};
   public static final long[] __DNA__FIELD__dup_group = new long[]{1068L, 1264L};
   public static final long[] __DNA__FIELD__body_type = new long[]{1072L, 1272L};
   public static final long[] __DNA__FIELD__shapeflag = new long[]{1073L, 1273L};
   public static final long[] __DNA__FIELD__shapenr = new long[]{1074L, 1274L};
   public static final long[] __DNA__FIELD__smoothresh = new long[]{1076L, 1276L};
   public static final long[] __DNA__FIELD__fluidsimSettings = new long[]{1080L, 1280L};
   public static final long[] __DNA__FIELD__curve_cache = new long[]{1084L, 1288L};
   public static final long[] __DNA__FIELD__derivedDeform = new long[]{1088L, 1296L};
   public static final long[] __DNA__FIELD__derivedFinal = new long[]{1092L, 1304L};
   public static final long[] __DNA__FIELD__lastDataMask = new long[]{1096L, 1312L};
   public static final long[] __DNA__FIELD__customdata_mask = new long[]{1104L, 1320L};
   public static final long[] __DNA__FIELD__state = new long[]{1112L, 1328L};
   public static final long[] __DNA__FIELD__init_state = new long[]{1116L, 1332L};
   public static final long[] __DNA__FIELD__gpulamp = new long[]{1120L, 1336L};
   public static final long[] __DNA__FIELD__pc_ids = new long[]{1128L, 1352L};
   public static final long[] __DNA__FIELD__duplilist = new long[]{1136L, 1368L};
   public static final long[] __DNA__FIELD__rigidbody_object = new long[]{1140L, 1376L};
   public static final long[] __DNA__FIELD__rigidbody_constraint = new long[]{1144L, 1384L};
   public static final long[] __DNA__FIELD__ima_ofs = new long[]{1148L, 1392L};
   public static final long[] __DNA__FIELD__iuser = new long[]{1156L, 1400L};
   public static final long[] __DNA__FIELD__lodlevels = new long[]{1160L, 1408L};
   public static final long[] __DNA__FIELD__currentlod = new long[]{1168L, 1424L};
   public static final long[] __DNA__FIELD__preview = new long[]{1172L, 1432L};

   public BlenderObject(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected BlenderObject(BlenderObject that) {
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

   public CPointer<Object> getSculpt() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSculpt(CPointer<Object> sculpt) throws IOException {
      long __address = sculpt == null ? 0L : sculpt.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public short getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 136L) : this.__io__block.readShort(this.__io__address + 108L);
   }

   public void setType(short type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 136L, type);
      } else {
         this.__io__block.writeShort(this.__io__address + 108L, type);
      }

   }

   public short getPartype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 138L) : this.__io__block.readShort(this.__io__address + 110L);
   }

   public void setPartype(short partype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 138L, partype);
      } else {
         this.__io__block.writeShort(this.__io__address + 110L, partype);
      }

   }

   public int getPar1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 140L) : this.__io__block.readInt(this.__io__address + 112L);
   }

   public void setPar1(int par1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 140L, par1);
      } else {
         this.__io__block.writeInt(this.__io__address + 112L, par1);
      }

   }

   public int getPar2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 144L) : this.__io__block.readInt(this.__io__address + 116L);
   }

   public void setPar2(int par2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 144L, par2);
      } else {
         this.__io__block.writeInt(this.__io__address + 116L, par2);
      }

   }

   public int getPar3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 148L) : this.__io__block.readInt(this.__io__address + 120L);
   }

   public void setPar3(int par3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 148L, par3);
      } else {
         this.__io__block.writeInt(this.__io__address + 120L, par3);
      }

   }

   public CArrayFacade<Byte> getParsubstr() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 152L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 124L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setParsubstr(CArrayFacade<Byte> parsubstr) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 152L;
      } else {
         __dna__offset = 124L;
      }

      if (!this.__io__equals(parsubstr, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, parsubstr)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, parsubstr);
         } else {
            __io__generic__copy(this.getParsubstr(), parsubstr);
         }

      }
   }

   public CPointer<BlenderObject> getParent() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 216L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 188L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setParent(CPointer<BlenderObject> parent) throws IOException {
      long __address = parent == null ? 0L : parent.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 216L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 188L, __address);
      }

   }

   public CPointer<BlenderObject> getTrack() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 224L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setTrack(CPointer<BlenderObject> track) throws IOException {
      long __address = track == null ? 0L : track.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 224L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      }

   }

   public CPointer<BlenderObject> getProxy() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 232L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 196L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setProxy(CPointer<BlenderObject> proxy) throws IOException {
      long __address = proxy == null ? 0L : proxy.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 232L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 196L, __address);
      }

   }

   public CPointer<BlenderObject> getProxy_group() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 240L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setProxy_group(CPointer<BlenderObject> proxy_group) throws IOException {
      long __address = proxy_group == null ? 0L : proxy_group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 240L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      }

   }

   public CPointer<BlenderObject> getProxy_from() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 248L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 204L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setProxy_from(CPointer<BlenderObject> proxy_from) throws IOException {
      long __address = proxy_from == null ? 0L : proxy_from.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 248L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 204L, __address);
      }

   }

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 256L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 208L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 256L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 208L, __address);
      }

   }

   public CPointer<BoundBox> getBb() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 264L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 212L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BoundBox.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 151), this.__io__blockTable);
   }

   public void setBb(CPointer<BoundBox> bb) throws IOException {
      long __address = bb == null ? 0L : bb.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 264L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 212L, __address);
      }

   }

   public CPointer<bAction> getAction() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 272L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 216L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bAction.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 352), this.__io__blockTable);
   }

   public void setAction(CPointer<bAction> action) throws IOException {
      long __address = action == null ? 0L : action.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 272L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 216L, __address);
      }

   }

   public CPointer<bAction> getPoselib() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 280L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 220L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bAction.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 352), this.__io__blockTable);
   }

   public void setPoselib(CPointer<bAction> poselib) throws IOException {
      long __address = poselib == null ? 0L : poselib.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 280L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 220L, __address);
      }

   }

   public CPointer<bPose> getPose() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 288L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 224L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bPose.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 348), this.__io__blockTable);
   }

   public void setPose(CPointer<bPose> pose) throws IOException {
      long __address = pose == null ? 0L : pose.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 288L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 224L, __address);
      }

   }

   public CPointer<Object> getData() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 296L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 228L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setData(CPointer<Object> data) throws IOException {
      long __address = data == null ? 0L : data.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 296L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 228L, __address);
      }

   }

   public CPointer<bGPdata> getGpd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 304L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 232L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bGPdata.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 497), this.__io__blockTable);
   }

   public void setGpd(CPointer<bGPdata> gpd) throws IOException {
      long __address = gpd == null ? 0L : gpd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 304L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 232L, __address);
      }

   }

   public bAnimVizSettings getAvs() throws IOException {
      return this.__io__pointersize == 8 ? new bAnimVizSettings(this.__io__address + 312L, this.__io__block, this.__io__blockTable) : new bAnimVizSettings(this.__io__address + 236L, this.__io__block, this.__io__blockTable);
   }

   public void setAvs(bAnimVizSettings avs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 312L;
      } else {
         __dna__offset = 236L;
      }

      if (!this.__io__equals(avs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, avs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, avs);
         } else {
            __io__generic__copy(this.getAvs(), avs);
         }

      }
   }

   public CPointer<bMotionPath> getMpath() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 360L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 284L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bMotionPath.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 345), this.__io__blockTable);
   }

   public void setMpath(CPointer<bMotionPath> mpath) throws IOException {
      long __address = mpath == null ? 0L : mpath.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 360L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 284L, __address);
      }

   }

   public ListBase getConstraintChannels() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 368L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 288L, this.__io__block, this.__io__blockTable);
   }

   public void setConstraintChannels(ListBase constraintChannels) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 368L;
      } else {
         __dna__offset = 288L;
      }

      if (!this.__io__equals(constraintChannels, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, constraintChannels)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, constraintChannels);
         } else {
            __io__generic__copy(this.getConstraintChannels(), constraintChannels);
         }

      }
   }

   public ListBase getEffect() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 384L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 296L, this.__io__block, this.__io__blockTable);
   }

   public void setEffect(ListBase effect) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 384L;
      } else {
         __dna__offset = 296L;
      }

      if (!this.__io__equals(effect, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, effect)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, effect);
         } else {
            __io__generic__copy(this.getEffect(), effect);
         }

      }
   }

   public ListBase getDefbase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 400L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 304L, this.__io__block, this.__io__blockTable);
   }

   public void setDefbase(ListBase defbase) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 400L;
      } else {
         __dna__offset = 304L;
      }

      if (!this.__io__equals(defbase, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, defbase)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, defbase);
         } else {
            __io__generic__copy(this.getDefbase(), defbase);
         }

      }
   }

   public ListBase getModifiers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 416L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 312L, this.__io__block, this.__io__blockTable);
   }

   public void setModifiers(ListBase modifiers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 416L;
      } else {
         __dna__offset = 312L;
      }

      if (!this.__io__equals(modifiers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, modifiers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, modifiers);
         } else {
            __io__generic__copy(this.getModifiers(), modifiers);
         }

      }
   }

   public int getMode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 432L) : this.__io__block.readInt(this.__io__address + 320L);
   }

   public void setMode(int mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 432L, mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 320L, mode);
      }

   }

   public int getRestore_mode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 436L) : this.__io__block.readInt(this.__io__address + 324L);
   }

   public void setRestore_mode(int restore_mode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 436L, restore_mode);
      } else {
         this.__io__block.writeInt(this.__io__address + 324L, restore_mode);
      }

   }

   public CPointer<CPointer<Material>> getMat() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 440L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 328L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Material.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setMat(CPointer<CPointer<Material>> mat) throws IOException {
      long __address = mat == null ? 0L : mat.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 440L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 328L, __address);
      }

   }

   public CPointer<Byte> getMatbits() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 448L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 332L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setMatbits(CPointer<Byte> matbits) throws IOException {
      long __address = matbits == null ? 0L : matbits.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 448L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 332L, __address);
      }

   }

   public int getTotcol() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 456L) : this.__io__block.readInt(this.__io__address + 336L);
   }

   public void setTotcol(int totcol) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 456L, totcol);
      } else {
         this.__io__block.writeInt(this.__io__address + 336L, totcol);
      }

   }

   public int getActcol() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 460L) : this.__io__block.readInt(this.__io__address + 340L);
   }

   public void setActcol(int actcol) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 460L, actcol);
      } else {
         this.__io__block.writeInt(this.__io__address + 340L, actcol);
      }

   }

   public CArrayFacade<Float> getLoc() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 464L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 344L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLoc(CArrayFacade<Float> loc) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 464L;
      } else {
         __dna__offset = 344L;
      }

      if (!this.__io__equals(loc, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, loc)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, loc);
         } else {
            __io__generic__copy(this.getLoc(), loc);
         }

      }
   }

   public CArrayFacade<Float> getDloc() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 476L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 356L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDloc(CArrayFacade<Float> dloc) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 476L;
      } else {
         __dna__offset = 356L;
      }

      if (!this.__io__equals(dloc, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dloc)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dloc);
         } else {
            __io__generic__copy(this.getDloc(), dloc);
         }

      }
   }

   public CArrayFacade<Float> getOrig() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 488L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 368L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setOrig(CArrayFacade<Float> orig) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 488L;
      } else {
         __dna__offset = 368L;
      }

      if (!this.__io__equals(orig, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, orig)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, orig);
         } else {
            __io__generic__copy(this.getOrig(), orig);
         }

      }
   }

   public CArrayFacade<Float> getSize() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 500L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 380L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSize(CArrayFacade<Float> size) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 500L;
      } else {
         __dna__offset = 380L;
      }

      if (!this.__io__equals(size, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, size)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, size);
         } else {
            __io__generic__copy(this.getSize(), size);
         }

      }
   }

   public CArrayFacade<Float> getDsize() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 512L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 392L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDsize(CArrayFacade<Float> dsize) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 512L;
      } else {
         __dna__offset = 392L;
      }

      if (!this.__io__equals(dsize, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dsize)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dsize);
         } else {
            __io__generic__copy(this.getDsize(), dsize);
         }

      }
   }

   public CArrayFacade<Float> getDscale() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 524L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 404L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDscale(CArrayFacade<Float> dscale) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 524L;
      } else {
         __dna__offset = 404L;
      }

      if (!this.__io__equals(dscale, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dscale)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dscale);
         } else {
            __io__generic__copy(this.getDscale(), dscale);
         }

      }
   }

   public CArrayFacade<Float> getRot() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 536L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 416L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRot(CArrayFacade<Float> rot) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 536L;
      } else {
         __dna__offset = 416L;
      }

      if (!this.__io__equals(rot, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rot)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rot);
         } else {
            __io__generic__copy(this.getRot(), rot);
         }

      }
   }

   public CArrayFacade<Float> getDrot() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 548L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 428L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDrot(CArrayFacade<Float> drot) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 548L;
      } else {
         __dna__offset = 428L;
      }

      if (!this.__io__equals(drot, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, drot)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, drot);
         } else {
            __io__generic__copy(this.getDrot(), drot);
         }

      }
   }

   public CArrayFacade<Float> getQuat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 560L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 440L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setQuat(CArrayFacade<Float> quat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 560L;
      } else {
         __dna__offset = 440L;
      }

      if (!this.__io__equals(quat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, quat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, quat);
         } else {
            __io__generic__copy(this.getQuat(), quat);
         }

      }
   }

   public CArrayFacade<Float> getDquat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 576L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 456L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDquat(CArrayFacade<Float> dquat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 576L;
      } else {
         __dna__offset = 456L;
      }

      if (!this.__io__equals(dquat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, dquat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, dquat);
         } else {
            __io__generic__copy(this.getDquat(), dquat);
         }

      }
   }

   public CArrayFacade<Float> getRotAxis() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 592L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 472L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRotAxis(CArrayFacade<Float> rotAxis) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 592L;
      } else {
         __dna__offset = 472L;
      }

      if (!this.__io__equals(rotAxis, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rotAxis)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rotAxis);
         } else {
            __io__generic__copy(this.getRotAxis(), rotAxis);
         }

      }
   }

   public CArrayFacade<Float> getDrotAxis() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 604L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 484L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setDrotAxis(CArrayFacade<Float> drotAxis) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 604L;
      } else {
         __dna__offset = 484L;
      }

      if (!this.__io__equals(drotAxis, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, drotAxis)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, drotAxis);
         } else {
            __io__generic__copy(this.getDrotAxis(), drotAxis);
         }

      }
   }

   public float getRotAngle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 616L) : this.__io__block.readFloat(this.__io__address + 496L);
   }

   public void setRotAngle(float rotAngle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 616L, rotAngle);
      } else {
         this.__io__block.writeFloat(this.__io__address + 496L, rotAngle);
      }

   }

   public float getDrotAngle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 620L) : this.__io__block.readFloat(this.__io__address + 500L);
   }

   public void setDrotAngle(float drotAngle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 620L, drotAngle);
      } else {
         this.__io__block.writeFloat(this.__io__address + 500L, drotAngle);
      }

   }

   public CArrayFacade<CArrayFacade<Float>> getObmat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 624L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 504L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setObmat(CArrayFacade<CArrayFacade<Float>> obmat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 624L;
      } else {
         __dna__offset = 504L;
      }

      if (!this.__io__equals(obmat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, obmat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, obmat);
         } else {
            __io__generic__copy(this.getObmat(), obmat);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getParentinv() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 688L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 568L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setParentinv(CArrayFacade<CArrayFacade<Float>> parentinv) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 688L;
      } else {
         __dna__offset = 568L;
      }

      if (!this.__io__equals(parentinv, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, parentinv)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, parentinv);
         } else {
            __io__generic__copy(this.getParentinv(), parentinv);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getConstinv() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 752L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 632L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setConstinv(CArrayFacade<CArrayFacade<Float>> constinv) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 752L;
      } else {
         __dna__offset = 632L;
      }

      if (!this.__io__equals(constinv, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, constinv)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, constinv);
         } else {
            __io__generic__copy(this.getConstinv(), constinv);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getImat() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 816L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 696L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setImat(CArrayFacade<CArrayFacade<Float>> imat) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 816L;
      } else {
         __dna__offset = 696L;
      }

      if (!this.__io__equals(imat, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, imat)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, imat);
         } else {
            __io__generic__copy(this.getImat(), imat);
         }

      }
   }

   public CArrayFacade<CArrayFacade<Float>> getImat_ren() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CArrayFacade.class, Float.class};
      int[] __dna__dimensions = new int[]{4, 4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 880L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 760L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setImat_ren(CArrayFacade<CArrayFacade<Float>> imat_ren) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 880L;
      } else {
         __dna__offset = 760L;
      }

      if (!this.__io__equals(imat_ren, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, imat_ren)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, imat_ren);
         } else {
            __io__generic__copy(this.getImat_ren(), imat_ren);
         }

      }
   }

   public int getLay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 944L) : this.__io__block.readInt(this.__io__address + 824L);
   }

   public void setLay(int lay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 944L, lay);
      } else {
         this.__io__block.writeInt(this.__io__address + 824L, lay);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 948L) : this.__io__block.readShort(this.__io__address + 828L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 948L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 828L, flag);
      }

   }

   public short getColbits() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 950L) : this.__io__block.readShort(this.__io__address + 830L);
   }

   public void setColbits(short colbits) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 950L, colbits);
      } else {
         this.__io__block.writeShort(this.__io__address + 830L, colbits);
      }

   }

   public short getTransflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 952L) : this.__io__block.readShort(this.__io__address + 832L);
   }

   public void setTransflag(short transflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 952L, transflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 832L, transflag);
      }

   }

   public short getProtectflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 954L) : this.__io__block.readShort(this.__io__address + 834L);
   }

   public void setProtectflag(short protectflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 954L, protectflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 834L, protectflag);
      }

   }

   public short getTrackflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 956L) : this.__io__block.readShort(this.__io__address + 836L);
   }

   public void setTrackflag(short trackflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 956L, trackflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 836L, trackflag);
      }

   }

   public short getUpflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 958L) : this.__io__block.readShort(this.__io__address + 838L);
   }

   public void setUpflag(short upflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 958L, upflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 838L, upflag);
      }

   }

   public short getNlaflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 960L) : this.__io__block.readShort(this.__io__address + 840L);
   }

   public void setNlaflag(short nlaflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 960L, nlaflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 840L, nlaflag);
      }

   }

   public short getScaflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 962L) : this.__io__block.readShort(this.__io__address + 842L);
   }

   public void setScaflag(short scaflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 962L, scaflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 842L, scaflag);
      }

   }

   public byte getScavisflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 964L) : this.__io__block.readByte(this.__io__address + 844L);
   }

   public void setScavisflag(byte scavisflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 964L, scavisflag);
      } else {
         this.__io__block.writeByte(this.__io__address + 844L, scavisflag);
      }

   }

   public byte getDepsflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 965L) : this.__io__block.readByte(this.__io__address + 845L);
   }

   public void setDepsflag(byte depsflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 965L, depsflag);
      } else {
         this.__io__block.writeByte(this.__io__address + 845L, depsflag);
      }

   }

   public byte getLastNeedMapping() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 966L) : this.__io__block.readByte(this.__io__address + 846L);
   }

   public void setLastNeedMapping(byte lastNeedMapping) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 966L, lastNeedMapping);
      } else {
         this.__io__block.writeByte(this.__io__address + 846L, lastNeedMapping);
      }

   }

   public byte getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 967L) : this.__io__block.readByte(this.__io__address + 847L);
   }

   public void setPad(byte pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 967L, pad);
      } else {
         this.__io__block.writeByte(this.__io__address + 847L, pad);
      }

   }

   public int getDupon() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 968L) : this.__io__block.readInt(this.__io__address + 848L);
   }

   public void setDupon(int dupon) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 968L, dupon);
      } else {
         this.__io__block.writeInt(this.__io__address + 848L, dupon);
      }

   }

   public int getDupoff() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 972L) : this.__io__block.readInt(this.__io__address + 852L);
   }

   public void setDupoff(int dupoff) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 972L, dupoff);
      } else {
         this.__io__block.writeInt(this.__io__address + 852L, dupoff);
      }

   }

   public int getDupsta() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 976L) : this.__io__block.readInt(this.__io__address + 856L);
   }

   public void setDupsta(int dupsta) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 976L, dupsta);
      } else {
         this.__io__block.writeInt(this.__io__address + 856L, dupsta);
      }

   }

   public int getDupend() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 980L) : this.__io__block.readInt(this.__io__address + 860L);
   }

   public void setDupend(int dupend) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 980L, dupend);
      } else {
         this.__io__block.writeInt(this.__io__address + 860L, dupend);
      }

   }

   public float getMass() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 984L) : this.__io__block.readFloat(this.__io__address + 864L);
   }

   public void setMass(float mass) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 984L, mass);
      } else {
         this.__io__block.writeFloat(this.__io__address + 864L, mass);
      }

   }

   public float getDamping() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 988L) : this.__io__block.readFloat(this.__io__address + 868L);
   }

   public void setDamping(float damping) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 988L, damping);
      } else {
         this.__io__block.writeFloat(this.__io__address + 868L, damping);
      }

   }

   public float getInertia() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 992L) : this.__io__block.readFloat(this.__io__address + 872L);
   }

   public void setInertia(float inertia) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 992L, inertia);
      } else {
         this.__io__block.writeFloat(this.__io__address + 872L, inertia);
      }

   }

   public float getFormfactor() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 996L) : this.__io__block.readFloat(this.__io__address + 876L);
   }

   public void setFormfactor(float formfactor) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 996L, formfactor);
      } else {
         this.__io__block.writeFloat(this.__io__address + 876L, formfactor);
      }

   }

   public float getRdamping() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1000L) : this.__io__block.readFloat(this.__io__address + 880L);
   }

   public void setRdamping(float rdamping) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1000L, rdamping);
      } else {
         this.__io__block.writeFloat(this.__io__address + 880L, rdamping);
      }

   }

   public float getMargin() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1004L) : this.__io__block.readFloat(this.__io__address + 884L);
   }

   public void setMargin(float margin) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1004L, margin);
      } else {
         this.__io__block.writeFloat(this.__io__address + 884L, margin);
      }

   }

   public float getMax_vel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1008L) : this.__io__block.readFloat(this.__io__address + 888L);
   }

   public void setMax_vel(float max_vel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1008L, max_vel);
      } else {
         this.__io__block.writeFloat(this.__io__address + 888L, max_vel);
      }

   }

   public float getMin_vel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1012L) : this.__io__block.readFloat(this.__io__address + 892L);
   }

   public void setMin_vel(float min_vel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1012L, min_vel);
      } else {
         this.__io__block.writeFloat(this.__io__address + 892L, min_vel);
      }

   }

   public float getMax_angvel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1016L) : this.__io__block.readFloat(this.__io__address + 896L);
   }

   public void setMax_angvel(float max_angvel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1016L, max_angvel);
      } else {
         this.__io__block.writeFloat(this.__io__address + 896L, max_angvel);
      }

   }

   public float getMin_angvel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1020L) : this.__io__block.readFloat(this.__io__address + 900L);
   }

   public void setMin_angvel(float min_angvel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1020L, min_angvel);
      } else {
         this.__io__block.writeFloat(this.__io__address + 900L, min_angvel);
      }

   }

   public float getObstacleRad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1024L) : this.__io__block.readFloat(this.__io__address + 904L);
   }

   public void setObstacleRad(float obstacleRad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1024L, obstacleRad);
      } else {
         this.__io__block.writeFloat(this.__io__address + 904L, obstacleRad);
      }

   }

   public float getStep_height() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1028L) : this.__io__block.readFloat(this.__io__address + 908L);
   }

   public void setStep_height(float step_height) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1028L, step_height);
      } else {
         this.__io__block.writeFloat(this.__io__address + 908L, step_height);
      }

   }

   public float getJump_speed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1032L) : this.__io__block.readFloat(this.__io__address + 912L);
   }

   public void setJump_speed(float jump_speed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1032L, jump_speed);
      } else {
         this.__io__block.writeFloat(this.__io__address + 912L, jump_speed);
      }

   }

   public float getFall_speed() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1036L) : this.__io__block.readFloat(this.__io__address + 916L);
   }

   public void setFall_speed(float fall_speed) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1036L, fall_speed);
      } else {
         this.__io__block.writeFloat(this.__io__address + 916L, fall_speed);
      }

   }

   public byte getMax_jumps() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1040L) : this.__io__block.readByte(this.__io__address + 920L);
   }

   public void setMax_jumps(byte max_jumps) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1040L, max_jumps);
      } else {
         this.__io__block.writeByte(this.__io__address + 920L, max_jumps);
      }

   }

   public CArrayFacade<Byte> getPad2() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1041L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 921L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad2(CArrayFacade<Byte> pad2) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1041L;
      } else {
         __dna__offset = 921L;
      }

      if (!this.__io__equals(pad2, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad2)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad2);
         } else {
            __io__generic__copy(this.getPad2(), pad2);
         }

      }
   }

   public short getCol_group() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1044L) : this.__io__block.readShort(this.__io__address + 924L);
   }

   public void setCol_group(short col_group) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1044L, col_group);
      } else {
         this.__io__block.writeShort(this.__io__address + 924L, col_group);
      }

   }

   public short getCol_mask() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1046L) : this.__io__block.readShort(this.__io__address + 926L);
   }

   public void setCol_mask(short col_mask) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1046L, col_mask);
      } else {
         this.__io__block.writeShort(this.__io__address + 926L, col_mask);
      }

   }

   public short getRotmode() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1048L) : this.__io__block.readShort(this.__io__address + 928L);
   }

   public void setRotmode(short rotmode) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1048L, rotmode);
      } else {
         this.__io__block.writeShort(this.__io__address + 928L, rotmode);
      }

   }

   public byte getBoundtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1050L) : this.__io__block.readByte(this.__io__address + 930L);
   }

   public void setBoundtype(byte boundtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1050L, boundtype);
      } else {
         this.__io__block.writeByte(this.__io__address + 930L, boundtype);
      }

   }

   public byte getCollision_boundtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1051L) : this.__io__block.readByte(this.__io__address + 931L);
   }

   public void setCollision_boundtype(byte collision_boundtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1051L, collision_boundtype);
      } else {
         this.__io__block.writeByte(this.__io__address + 931L, collision_boundtype);
      }

   }

   public short getDtx() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1052L) : this.__io__block.readShort(this.__io__address + 932L);
   }

   public void setDtx(short dtx) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1052L, dtx);
      } else {
         this.__io__block.writeShort(this.__io__address + 932L, dtx);
      }

   }

   public byte getDt() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1054L) : this.__io__block.readByte(this.__io__address + 934L);
   }

   public void setDt(byte dt) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1054L, dt);
      } else {
         this.__io__block.writeByte(this.__io__address + 934L, dt);
      }

   }

   public byte getEmpty_drawtype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1055L) : this.__io__block.readByte(this.__io__address + 935L);
   }

   public void setEmpty_drawtype(byte empty_drawtype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1055L, empty_drawtype);
      } else {
         this.__io__block.writeByte(this.__io__address + 935L, empty_drawtype);
      }

   }

   public float getEmpty_drawsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1056L) : this.__io__block.readFloat(this.__io__address + 936L);
   }

   public void setEmpty_drawsize(float empty_drawsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1056L, empty_drawsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 936L, empty_drawsize);
      }

   }

   public float getDupfacesca() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1060L) : this.__io__block.readFloat(this.__io__address + 940L);
   }

   public void setDupfacesca(float dupfacesca) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1060L, dupfacesca);
      } else {
         this.__io__block.writeFloat(this.__io__address + 940L, dupfacesca);
      }

   }

   public ListBase getProp() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1064L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 944L, this.__io__block, this.__io__blockTable);
   }

   public void setProp(ListBase prop) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1064L;
      } else {
         __dna__offset = 944L;
      }

      if (!this.__io__equals(prop, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, prop)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, prop);
         } else {
            __io__generic__copy(this.getProp(), prop);
         }

      }
   }

   public ListBase getSensors() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1080L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 952L, this.__io__block, this.__io__blockTable);
   }

   public void setSensors(ListBase sensors) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1080L;
      } else {
         __dna__offset = 952L;
      }

      if (!this.__io__equals(sensors, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, sensors)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, sensors);
         } else {
            __io__generic__copy(this.getSensors(), sensors);
         }

      }
   }

   public ListBase getControllers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1096L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 960L, this.__io__block, this.__io__blockTable);
   }

   public void setControllers(ListBase controllers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1096L;
      } else {
         __dna__offset = 960L;
      }

      if (!this.__io__equals(controllers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, controllers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, controllers);
         } else {
            __io__generic__copy(this.getControllers(), controllers);
         }

      }
   }

   public ListBase getActuators() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1112L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 968L, this.__io__block, this.__io__blockTable);
   }

   public void setActuators(ListBase actuators) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1112L;
      } else {
         __dna__offset = 968L;
      }

      if (!this.__io__equals(actuators, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, actuators)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, actuators);
         } else {
            __io__generic__copy(this.getActuators(), actuators);
         }

      }
   }

   public float getSf() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1128L) : this.__io__block.readFloat(this.__io__address + 976L);
   }

   public void setSf(float sf) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1128L, sf);
      } else {
         this.__io__block.writeFloat(this.__io__address + 976L, sf);
      }

   }

   public short getIndex() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1132L) : this.__io__block.readShort(this.__io__address + 980L);
   }

   public void setIndex(short index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1132L, index);
      } else {
         this.__io__block.writeShort(this.__io__address + 980L, index);
      }

   }

   public short getActdef() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1134L) : this.__io__block.readShort(this.__io__address + 982L);
   }

   public void setActdef(short actdef) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1134L, actdef);
      } else {
         this.__io__block.writeShort(this.__io__address + 982L, actdef);
      }

   }

   public CArrayFacade<Float> getCol() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{4};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1136L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 984L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCol(CArrayFacade<Float> col) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1136L;
      } else {
         __dna__offset = 984L;
      }

      if (!this.__io__equals(col, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, col)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, col);
         } else {
            __io__generic__copy(this.getCol(), col);
         }

      }
   }

   public int getGameflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1152L) : this.__io__block.readInt(this.__io__address + 1000L);
   }

   public void setGameflag(int gameflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1152L, gameflag);
      } else {
         this.__io__block.writeInt(this.__io__address + 1000L, gameflag);
      }

   }

   public int getGameflag2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1156L) : this.__io__block.readInt(this.__io__address + 1004L);
   }

   public void setGameflag2(int gameflag2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1156L, gameflag2);
      } else {
         this.__io__block.writeInt(this.__io__address + 1004L, gameflag2);
      }

   }

   public CPointer<BulletSoftBody> getBsoft() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1008L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BulletSoftBody.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 162), this.__io__blockTable);
   }

   public void setBsoft(CPointer<BulletSoftBody> bsoft) throws IOException {
      long __address = bsoft == null ? 0L : bsoft.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1008L, __address);
      }

   }

   public byte getRestrictflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1168L) : this.__io__block.readByte(this.__io__address + 1012L);
   }

   public void setRestrictflag(byte restrictflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1168L, restrictflag);
      } else {
         this.__io__block.writeByte(this.__io__address + 1012L, restrictflag);
      }

   }

   public byte getRecalc() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1169L) : this.__io__block.readByte(this.__io__address + 1013L);
   }

   public void setRecalc(byte recalc) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1169L, recalc);
      } else {
         this.__io__block.writeByte(this.__io__address + 1013L, recalc);
      }

   }

   public short getSoftflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1170L) : this.__io__block.readShort(this.__io__address + 1014L);
   }

   public void setSoftflag(short softflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1170L, softflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 1014L, softflag);
      }

   }

   public CArrayFacade<Float> getAnisotropicFriction() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1172L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1016L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setAnisotropicFriction(CArrayFacade<Float> anisotropicFriction) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1172L;
      } else {
         __dna__offset = 1016L;
      }

      if (!this.__io__equals(anisotropicFriction, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, anisotropicFriction)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, anisotropicFriction);
         } else {
            __io__generic__copy(this.getAnisotropicFriction(), anisotropicFriction);
         }

      }
   }

   public ListBase getConstraints() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1184L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1028L, this.__io__block, this.__io__blockTable);
   }

   public void setConstraints(ListBase constraints) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1184L;
      } else {
         __dna__offset = 1028L;
      }

      if (!this.__io__equals(constraints, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, constraints)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, constraints);
         } else {
            __io__generic__copy(this.getConstraints(), constraints);
         }

      }
   }

   public ListBase getNlastrips() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1200L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1036L, this.__io__block, this.__io__blockTable);
   }

   public void setNlastrips(ListBase nlastrips) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1200L;
      } else {
         __dna__offset = 1036L;
      }

      if (!this.__io__equals(nlastrips, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, nlastrips)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, nlastrips);
         } else {
            __io__generic__copy(this.getNlastrips(), nlastrips);
         }

      }
   }

   public ListBase getHooks() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1216L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1044L, this.__io__block, this.__io__blockTable);
   }

   public void setHooks(ListBase hooks) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1216L;
      } else {
         __dna__offset = 1044L;
      }

      if (!this.__io__equals(hooks, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, hooks)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, hooks);
         } else {
            __io__generic__copy(this.getHooks(), hooks);
         }

      }
   }

   public ListBase getParticlesystem() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1232L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1052L, this.__io__block, this.__io__blockTable);
   }

   public void setParticlesystem(ListBase particlesystem) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1232L;
      } else {
         __dna__offset = 1052L;
      }

      if (!this.__io__equals(particlesystem, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, particlesystem)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, particlesystem);
         } else {
            __io__generic__copy(this.getParticlesystem(), particlesystem);
         }

      }
   }

   public CPointer<PartDeflect> getPd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1248L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1060L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PartDeflect.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 156), this.__io__blockTable);
   }

   public void setPd(CPointer<PartDeflect> pd) throws IOException {
      long __address = pd == null ? 0L : pd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1248L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1060L, __address);
      }

   }

   public CPointer<SoftBody> getSoft() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1256L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1064L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{SoftBody.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 163), this.__io__blockTable);
   }

   public void setSoft(CPointer<SoftBody> soft) throws IOException {
      long __address = soft == null ? 0L : soft.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1256L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1064L, __address);
      }

   }

   public CPointer<Group> getDup_group() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1264L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1068L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Group.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 341), this.__io__blockTable);
   }

   public void setDup_group(CPointer<Group> dup_group) throws IOException {
      long __address = dup_group == null ? 0L : dup_group.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1264L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1068L, __address);
      }

   }

   public byte getBody_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1272L) : this.__io__block.readByte(this.__io__address + 1072L);
   }

   public void setBody_type(byte body_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1272L, body_type);
      } else {
         this.__io__block.writeByte(this.__io__address + 1072L, body_type);
      }

   }

   public byte getShapeflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1273L) : this.__io__block.readByte(this.__io__address + 1073L);
   }

   public void setShapeflag(byte shapeflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1273L, shapeflag);
      } else {
         this.__io__block.writeByte(this.__io__address + 1073L, shapeflag);
      }

   }

   public short getShapenr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1274L) : this.__io__block.readShort(this.__io__address + 1074L);
   }

   public void setShapenr(short shapenr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1274L, shapenr);
      } else {
         this.__io__block.writeShort(this.__io__address + 1074L, shapenr);
      }

   }

   public float getSmoothresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1276L) : this.__io__block.readFloat(this.__io__address + 1076L);
   }

   public void setSmoothresh(float smoothresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1276L, smoothresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1076L, smoothresh);
      }

   }

   public CPointer<FluidsimSettings> getFluidsimSettings() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1280L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1080L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{FluidsimSettings.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 165), this.__io__blockTable);
   }

   public void setFluidsimSettings(CPointer<FluidsimSettings> fluidsimSettings) throws IOException {
      long __address = fluidsimSettings == null ? 0L : fluidsimSettings.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1280L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1080L, __address);
      }

   }

   public CPointer<Object> getCurve_cache() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1288L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1084L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setCurve_cache(CPointer<Object> curve_cache) throws IOException {
      long __address = curve_cache == null ? 0L : curve_cache.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1288L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1084L, __address);
      }

   }

   public CPointer<Object> getDerivedDeform() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1296L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1088L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setDerivedDeform(CPointer<Object> derivedDeform) throws IOException {
      long __address = derivedDeform == null ? 0L : derivedDeform.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1296L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1088L, __address);
      }

   }

   public CPointer<Object> getDerivedFinal() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1304L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1092L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setDerivedFinal(CPointer<Object> derivedFinal) throws IOException {
      long __address = derivedFinal == null ? 0L : derivedFinal.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1304L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1092L, __address);
      }

   }

   public long getLastDataMask() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt64(this.__io__address + 1312L) : this.__io__block.readInt64(this.__io__address + 1096L);
   }

   public void setLastDataMask(long lastDataMask) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt64(this.__io__address + 1312L, lastDataMask);
      } else {
         this.__io__block.writeInt64(this.__io__address + 1096L, lastDataMask);
      }

   }

   public long getCustomdata_mask() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt64(this.__io__address + 1320L) : this.__io__block.readInt64(this.__io__address + 1104L);
   }

   public void setCustomdata_mask(long customdata_mask) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt64(this.__io__address + 1320L, customdata_mask);
      } else {
         this.__io__block.writeInt64(this.__io__address + 1104L, customdata_mask);
      }

   }

   public int getState() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1328L) : this.__io__block.readInt(this.__io__address + 1112L);
   }

   public void setState(int state) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1328L, state);
      } else {
         this.__io__block.writeInt(this.__io__address + 1112L, state);
      }

   }

   public int getInit_state() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1332L) : this.__io__block.readInt(this.__io__address + 1116L);
   }

   public void setInit_state(int init_state) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1332L, init_state);
      } else {
         this.__io__block.writeInt(this.__io__address + 1116L, init_state);
      }

   }

   public ListBase getGpulamp() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1336L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1120L, this.__io__block, this.__io__blockTable);
   }

   public void setGpulamp(ListBase gpulamp) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1336L;
      } else {
         __dna__offset = 1120L;
      }

      if (!this.__io__equals(gpulamp, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gpulamp)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gpulamp);
         } else {
            __io__generic__copy(this.getGpulamp(), gpulamp);
         }

      }
   }

   public ListBase getPc_ids() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1352L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1128L, this.__io__block, this.__io__blockTable);
   }

   public void setPc_ids(ListBase pc_ids) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1352L;
      } else {
         __dna__offset = 1128L;
      }

      if (!this.__io__equals(pc_ids, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pc_ids)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pc_ids);
         } else {
            __io__generic__copy(this.getPc_ids(), pc_ids);
         }

      }
   }

   public CPointer<ListBase> getDuplilist() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1368L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1136L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ListBase.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 2), this.__io__blockTable);
   }

   public void setDuplilist(CPointer<ListBase> duplilist) throws IOException {
      long __address = duplilist == null ? 0L : duplilist.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1368L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1136L, __address);
      }

   }

   public CPointer<RigidBodyOb> getRigidbody_object() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1376L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1140L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{RigidBodyOb.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 573), this.__io__blockTable);
   }

   public void setRigidbody_object(CPointer<RigidBodyOb> rigidbody_object) throws IOException {
      long __address = rigidbody_object == null ? 0L : rigidbody_object.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1376L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1140L, __address);
      }

   }

   public CPointer<RigidBodyCon> getRigidbody_constraint() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1384L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1144L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{RigidBodyCon.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 574), this.__io__blockTable);
   }

   public void setRigidbody_constraint(CPointer<RigidBodyCon> rigidbody_constraint) throws IOException {
      long __address = rigidbody_constraint == null ? 0L : rigidbody_constraint.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1384L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1144L, __address);
      }

   }

   public CArrayFacade<Float> getIma_ofs() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1392L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1148L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setIma_ofs(CArrayFacade<Float> ima_ofs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1392L;
      } else {
         __dna__offset = 1148L;
      }

      if (!this.__io__equals(ima_ofs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ima_ofs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ima_ofs);
         } else {
            __io__generic__copy(this.getIma_ofs(), ima_ofs);
         }

      }
   }

   public CPointer<ImageUser> getIuser() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1400L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ImageUser.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 26), this.__io__blockTable);
   }

   public void setIuser(CPointer<ImageUser> iuser) throws IOException {
      long __address = iuser == null ? 0L : iuser.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1400L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1156L, __address);
      }

   }

   public ListBase getLodlevels() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 1408L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 1160L, this.__io__block, this.__io__blockTable);
   }

   public void setLodlevels(ListBase lodlevels) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1408L;
      } else {
         __dna__offset = 1160L;
      }

      if (!this.__io__equals(lodlevels, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, lodlevels)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, lodlevels);
         } else {
            __io__generic__copy(this.getLodlevels(), lodlevels);
         }

      }
   }

   public CPointer<LodLevel> getCurrentlod() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1424L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1168L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{LodLevel.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 152), this.__io__blockTable);
   }

   public void setCurrentlod(CPointer<LodLevel> currentlod) throws IOException {
      long __address = currentlod == null ? 0L : currentlod.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1424L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1168L, __address);
      }

   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1432L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1172L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1432L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1172L, __address);
      }

   }

   public CPointer<BlenderObject> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{BlenderObject.class}, this.__io__block, this.__io__blockTable);
   }
}
