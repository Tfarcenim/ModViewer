package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 1252L,
   size64 = 1416L
)
public class Mesh extends CFacade {
   public static final int __DNA__SDNA_INDEX = 57;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__bb = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__ipo = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__key = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__mat = new long[]{116L, 152L};
   public static final long[] __DNA__FIELD__mselect = new long[]{120L, 160L};
   public static final long[] __DNA__FIELD__mpoly = new long[]{124L, 168L};
   public static final long[] __DNA__FIELD__mtpoly = new long[]{128L, 176L};
   public static final long[] __DNA__FIELD__mloop = new long[]{132L, 184L};
   public static final long[] __DNA__FIELD__mloopuv = new long[]{136L, 192L};
   public static final long[] __DNA__FIELD__mloopcol = new long[]{140L, 200L};
   public static final long[] __DNA__FIELD__mface = new long[]{144L, 208L};
   public static final long[] __DNA__FIELD__mtface = new long[]{148L, 216L};
   public static final long[] __DNA__FIELD__tface = new long[]{152L, 224L};
   public static final long[] __DNA__FIELD__mvert = new long[]{156L, 232L};
   public static final long[] __DNA__FIELD__medge = new long[]{160L, 240L};
   public static final long[] __DNA__FIELD__dvert = new long[]{164L, 248L};
   public static final long[] __DNA__FIELD__mcol = new long[]{168L, 256L};
   public static final long[] __DNA__FIELD__texcomesh = new long[]{172L, 264L};
   public static final long[] __DNA__FIELD__edit_btmesh = new long[]{176L, 272L};
   public static final long[] __DNA__FIELD__vdata = new long[]{180L, 280L};
   public static final long[] __DNA__FIELD__edata = new long[]{376L, 488L};
   public static final long[] __DNA__FIELD__fdata = new long[]{572L, 696L};
   public static final long[] __DNA__FIELD__pdata = new long[]{768L, 904L};
   public static final long[] __DNA__FIELD__ldata = new long[]{964L, 1112L};
   public static final long[] __DNA__FIELD__totvert = new long[]{1160L, 1320L};
   public static final long[] __DNA__FIELD__totedge = new long[]{1164L, 1324L};
   public static final long[] __DNA__FIELD__totface = new long[]{1168L, 1328L};
   public static final long[] __DNA__FIELD__totselect = new long[]{1172L, 1332L};
   public static final long[] __DNA__FIELD__totpoly = new long[]{1176L, 1336L};
   public static final long[] __DNA__FIELD__totloop = new long[]{1180L, 1340L};
   public static final long[] __DNA__FIELD__act_face = new long[]{1184L, 1344L};
   public static final long[] __DNA__FIELD__loc = new long[]{1188L, 1348L};
   public static final long[] __DNA__FIELD__size = new long[]{1200L, 1360L};
   public static final long[] __DNA__FIELD__rot = new long[]{1212L, 1372L};
   public static final long[] __DNA__FIELD__drawflag = new long[]{1224L, 1384L};
   public static final long[] __DNA__FIELD__texflag = new long[]{1228L, 1388L};
   public static final long[] __DNA__FIELD__flag = new long[]{1230L, 1390L};
   public static final long[] __DNA__FIELD__smoothresh = new long[]{1232L, 1392L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{1236L, 1396L};
   public static final long[] __DNA__FIELD__cd_flag = new long[]{1240L, 1400L};
   public static final long[] __DNA__FIELD__pad = new long[]{1241L, 1401L};
   public static final long[] __DNA__FIELD__subdiv = new long[]{1242L, 1402L};
   public static final long[] __DNA__FIELD__subdivr = new long[]{1243L, 1403L};
   public static final long[] __DNA__FIELD__subsurftype = new long[]{1244L, 1404L};
   public static final long[] __DNA__FIELD__editflag = new long[]{1245L, 1405L};
   public static final long[] __DNA__FIELD__totcol = new long[]{1246L, 1406L};
   public static final long[] __DNA__FIELD__mr = new long[]{1248L, 1408L};

   public Mesh(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Mesh(Mesh that) {
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

   public CPointer<Ipo> getIpo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 108L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Ipo.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 15), this.__io__blockTable);
   }

   public void setIpo(CPointer<Ipo> ipo) throws IOException {
      long __address = ipo == null ? 0L : ipo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 108L, __address);
      }

   }

   public CPointer<Key> getKey() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 112L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Key.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 17), this.__io__blockTable);
   }

   public void setKey(CPointer<Key> key) throws IOException {
      long __address = key == null ? 0L : key.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 112L, __address);
      }

   }

   public CPointer<CPointer<Material>> getMat() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 116L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, Material.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, __dna__targetTypes), this.__io__blockTable);
   }

   public void setMat(CPointer<CPointer<Material>> mat) throws IOException {
      long __address = mat == null ? 0L : mat.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 116L, __address);
      }

   }

   public CPointer<MSelect> getMselect() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 120L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MSelect.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 70), this.__io__blockTable);
   }

   public void setMselect(CPointer<MSelect> mselect) throws IOException {
      long __address = mselect == null ? 0L : mselect.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 120L, __address);
      }

   }

   public CPointer<MPoly> getMpoly() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MPoly.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 65), this.__io__blockTable);
   }

   public void setMpoly(CPointer<MPoly> mpoly) throws IOException {
      long __address = mpoly == null ? 0L : mpoly.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 124L, __address);
      }

   }

   public CPointer<MTexPoly> getMtpoly() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MTexPoly.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 67), this.__io__blockTable);
   }

   public void setMtpoly(CPointer<MTexPoly> mtpoly) throws IOException {
      long __address = mtpoly == null ? 0L : mtpoly.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      }

   }

   public CPointer<MLoop> getMloop() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 184L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 132L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MLoop.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 66), this.__io__blockTable);
   }

   public void setMloop(CPointer<MLoop> mloop) throws IOException {
      long __address = mloop == null ? 0L : mloop.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 184L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 132L, __address);
      }

   }

   public CPointer<MLoopUV> getMloopuv() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 192L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MLoopUV.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 68), this.__io__blockTable);
   }

   public void setMloopuv(CPointer<MLoopUV> mloopuv) throws IOException {
      long __address = mloopuv == null ? 0L : mloopuv.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 192L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      }

   }

   public CPointer<MLoopCol> getMloopcol() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 140L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MLoopCol.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 69), this.__io__blockTable);
   }

   public void setMloopcol(CPointer<MLoopCol> mloopcol) throws IOException {
      long __address = mloopcol == null ? 0L : mloopcol.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 140L, __address);
      }

   }

   public CPointer<MFace> getMface() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 208L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MFace.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 59), this.__io__blockTable);
   }

   public void setMface(CPointer<MFace> mface) throws IOException {
      long __address = mface == null ? 0L : mface.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 208L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      }

   }

   public CPointer<MTFace> getMtface() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 216L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 148L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MTFace.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 71), this.__io__blockTable);
   }

   public void setMtface(CPointer<MTFace> mtface) throws IOException {
      long __address = mtface == null ? 0L : mtface.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 216L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 148L, __address);
      }

   }

   public CPointer<TFace> getTface() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 224L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 152L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{TFace.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 58), this.__io__blockTable);
   }

   public void setTface(CPointer<TFace> tface) throws IOException {
      long __address = tface == null ? 0L : tface.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 224L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 152L, __address);
      }

   }

   public CPointer<MVert> getMvert() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 232L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 156L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MVert.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 63), this.__io__blockTable);
   }

   public void setMvert(CPointer<MVert> mvert) throws IOException {
      long __address = mvert == null ? 0L : mvert.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 232L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 156L, __address);
      }

   }

   public CPointer<MEdge> getMedge() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 240L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 160L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MEdge.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 60), this.__io__blockTable);
   }

   public void setMedge(CPointer<MEdge> medge) throws IOException {
      long __address = medge == null ? 0L : medge.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 240L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 160L, __address);
      }

   }

   public CPointer<MDeformVert> getDvert() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 248L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 164L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MDeformVert.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 62), this.__io__blockTable);
   }

   public void setDvert(CPointer<MDeformVert> dvert) throws IOException {
      long __address = dvert == null ? 0L : dvert.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 248L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 164L, __address);
      }

   }

   public CPointer<MCol> getMcol() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 256L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MCol.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 64), this.__io__blockTable);
   }

   public void setMcol(CPointer<MCol> mcol) throws IOException {
      long __address = mcol == null ? 0L : mcol.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 256L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      }

   }

   public CPointer<Mesh> getTexcomesh() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 264L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 172L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Mesh.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 57), this.__io__blockTable);
   }

   public void setTexcomesh(CPointer<Mesh> texcomesh) throws IOException {
      long __address = texcomesh == null ? 0L : texcomesh.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 264L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 172L, __address);
      }

   }

   public CPointer<Object> getEdit_btmesh() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 272L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setEdit_btmesh(CPointer<Object> edit_btmesh) throws IOException {
      long __address = edit_btmesh == null ? 0L : edit_btmesh.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 272L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      }

   }

   public CustomData getVdata() throws IOException {
      return this.__io__pointersize == 8 ? new CustomData(this.__io__address + 280L, this.__io__block, this.__io__blockTable) : new CustomData(this.__io__address + 180L, this.__io__block, this.__io__blockTable);
   }

   public void setVdata(CustomData vdata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 280L;
      } else {
         __dna__offset = 180L;
      }

      if (!this.__io__equals(vdata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, vdata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, vdata);
         } else {
            __io__generic__copy(this.getVdata(), vdata);
         }

      }
   }

   public CustomData getEdata() throws IOException {
      return this.__io__pointersize == 8 ? new CustomData(this.__io__address + 488L, this.__io__block, this.__io__blockTable) : new CustomData(this.__io__address + 376L, this.__io__block, this.__io__blockTable);
   }

   public void setEdata(CustomData edata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 488L;
      } else {
         __dna__offset = 376L;
      }

      if (!this.__io__equals(edata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, edata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, edata);
         } else {
            __io__generic__copy(this.getEdata(), edata);
         }

      }
   }

   public CustomData getFdata() throws IOException {
      return this.__io__pointersize == 8 ? new CustomData(this.__io__address + 696L, this.__io__block, this.__io__blockTable) : new CustomData(this.__io__address + 572L, this.__io__block, this.__io__blockTable);
   }

   public void setFdata(CustomData fdata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 696L;
      } else {
         __dna__offset = 572L;
      }

      if (!this.__io__equals(fdata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, fdata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, fdata);
         } else {
            __io__generic__copy(this.getFdata(), fdata);
         }

      }
   }

   public CustomData getPdata() throws IOException {
      return this.__io__pointersize == 8 ? new CustomData(this.__io__address + 904L, this.__io__block, this.__io__blockTable) : new CustomData(this.__io__address + 768L, this.__io__block, this.__io__blockTable);
   }

   public void setPdata(CustomData pdata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 904L;
      } else {
         __dna__offset = 768L;
      }

      if (!this.__io__equals(pdata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pdata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pdata);
         } else {
            __io__generic__copy(this.getPdata(), pdata);
         }

      }
   }

   public CustomData getLdata() throws IOException {
      return this.__io__pointersize == 8 ? new CustomData(this.__io__address + 1112L, this.__io__block, this.__io__blockTable) : new CustomData(this.__io__address + 964L, this.__io__block, this.__io__blockTable);
   }

   public void setLdata(CustomData ldata) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1112L;
      } else {
         __dna__offset = 964L;
      }

      if (!this.__io__equals(ldata, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, ldata)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, ldata);
         } else {
            __io__generic__copy(this.getLdata(), ldata);
         }

      }
   }

   public int getTotvert() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1320L) : this.__io__block.readInt(this.__io__address + 1160L);
   }

   public void setTotvert(int totvert) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1320L, totvert);
      } else {
         this.__io__block.writeInt(this.__io__address + 1160L, totvert);
      }

   }

   public int getTotedge() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1324L) : this.__io__block.readInt(this.__io__address + 1164L);
   }

   public void setTotedge(int totedge) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1324L, totedge);
      } else {
         this.__io__block.writeInt(this.__io__address + 1164L, totedge);
      }

   }

   public int getTotface() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1328L) : this.__io__block.readInt(this.__io__address + 1168L);
   }

   public void setTotface(int totface) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1328L, totface);
      } else {
         this.__io__block.writeInt(this.__io__address + 1168L, totface);
      }

   }

   public int getTotselect() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1332L) : this.__io__block.readInt(this.__io__address + 1172L);
   }

   public void setTotselect(int totselect) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1332L, totselect);
      } else {
         this.__io__block.writeInt(this.__io__address + 1172L, totselect);
      }

   }

   public int getTotpoly() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1336L) : this.__io__block.readInt(this.__io__address + 1176L);
   }

   public void setTotpoly(int totpoly) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1336L, totpoly);
      } else {
         this.__io__block.writeInt(this.__io__address + 1176L, totpoly);
      }

   }

   public int getTotloop() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1340L) : this.__io__block.readInt(this.__io__address + 1180L);
   }

   public void setTotloop(int totloop) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1340L, totloop);
      } else {
         this.__io__block.writeInt(this.__io__address + 1180L, totloop);
      }

   }

   public int getAct_face() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1344L) : this.__io__block.readInt(this.__io__address + 1184L);
   }

   public void setAct_face(int act_face) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1344L, act_face);
      } else {
         this.__io__block.writeInt(this.__io__address + 1184L, act_face);
      }

   }

   public CArrayFacade<Float> getLoc() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1348L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1188L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setLoc(CArrayFacade<Float> loc) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1348L;
      } else {
         __dna__offset = 1188L;
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
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1360L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1200L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setSize(CArrayFacade<Float> size) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1360L;
      } else {
         __dna__offset = 1200L;
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
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 1372L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 1212L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setRot(CArrayFacade<Float> rot) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 1372L;
      } else {
         __dna__offset = 1212L;
      }

      if (!this.__io__equals(rot, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, rot)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, rot);
         } else {
            __io__generic__copy(this.getRot(), rot);
         }

      }
   }

   public int getDrawflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1384L) : this.__io__block.readInt(this.__io__address + 1224L);
   }

   public void setDrawflag(int drawflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1384L, drawflag);
      } else {
         this.__io__block.writeInt(this.__io__address + 1224L, drawflag);
      }

   }

   public short getTexflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1388L) : this.__io__block.readShort(this.__io__address + 1228L);
   }

   public void setTexflag(short texflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1388L, texflag);
      } else {
         this.__io__block.writeShort(this.__io__address + 1228L, texflag);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1390L) : this.__io__block.readShort(this.__io__address + 1230L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1390L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 1230L, flag);
      }

   }

   public float getSmoothresh() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 1392L) : this.__io__block.readFloat(this.__io__address + 1232L);
   }

   public void setSmoothresh(float smoothresh) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 1392L, smoothresh);
      } else {
         this.__io__block.writeFloat(this.__io__address + 1232L, smoothresh);
      }

   }

   public int getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 1396L) : this.__io__block.readInt(this.__io__address + 1236L);
   }

   public void setPad2(int pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 1396L, pad2);
      } else {
         this.__io__block.writeInt(this.__io__address + 1236L, pad2);
      }

   }

   public byte getCd_flag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1400L) : this.__io__block.readByte(this.__io__address + 1240L);
   }

   public void setCd_flag(byte cd_flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1400L, cd_flag);
      } else {
         this.__io__block.writeByte(this.__io__address + 1240L, cd_flag);
      }

   }

   public byte getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1401L) : this.__io__block.readByte(this.__io__address + 1241L);
   }

   public void setPad(byte pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1401L, pad);
      } else {
         this.__io__block.writeByte(this.__io__address + 1241L, pad);
      }

   }

   public byte getSubdiv() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1402L) : this.__io__block.readByte(this.__io__address + 1242L);
   }

   public void setSubdiv(byte subdiv) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1402L, subdiv);
      } else {
         this.__io__block.writeByte(this.__io__address + 1242L, subdiv);
      }

   }

   public byte getSubdivr() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1403L) : this.__io__block.readByte(this.__io__address + 1243L);
   }

   public void setSubdivr(byte subdivr) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1403L, subdivr);
      } else {
         this.__io__block.writeByte(this.__io__address + 1243L, subdivr);
      }

   }

   public byte getSubsurftype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1404L) : this.__io__block.readByte(this.__io__address + 1244L);
   }

   public void setSubsurftype(byte subsurftype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1404L, subsurftype);
      } else {
         this.__io__block.writeByte(this.__io__address + 1244L, subsurftype);
      }

   }

   public byte getEditflag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 1405L) : this.__io__block.readByte(this.__io__address + 1245L);
   }

   public void setEditflag(byte editflag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 1405L, editflag);
      } else {
         this.__io__block.writeByte(this.__io__address + 1245L, editflag);
      }

   }

   public short getTotcol() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 1406L) : this.__io__block.readShort(this.__io__address + 1246L);
   }

   public void setTotcol(short totcol) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 1406L, totcol);
      } else {
         this.__io__block.writeShort(this.__io__address + 1246L, totcol);
      }

   }

   public CPointer<Multires> getMr() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1408L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 1248L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Multires.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 83), this.__io__blockTable);
   }

   public void setMr(CPointer<Multires> mr) throws IOException {
      long __address = mr == null ? 0L : mr.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 1408L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 1248L, __address);
      }

   }

   public CPointer<Mesh> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Mesh.class}, this.__io__block, this.__io__blockTable);
   }
}
