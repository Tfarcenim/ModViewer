package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 328L,
   size64 = 440L
)
public class bNodeTree extends CFacade {
   public static final int __DNA__SDNA_INDEX = 397;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__typeinfo = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__idname = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__interface_type = new long[]{172L, 200L};
   public static final long[] __DNA__FIELD__gpd = new long[]{176L, 208L};
   public static final long[] __DNA__FIELD__view_center = new long[]{180L, 216L};
   public static final long[] __DNA__FIELD__nodes = new long[]{188L, 224L};
   public static final long[] __DNA__FIELD__links = new long[]{196L, 240L};
   public static final long[] __DNA__FIELD__type = new long[]{204L, 256L};
   public static final long[] __DNA__FIELD__init = new long[]{208L, 260L};
   public static final long[] __DNA__FIELD__cur_index = new long[]{212L, 264L};
   public static final long[] __DNA__FIELD__flag = new long[]{216L, 268L};
   public static final long[] __DNA__FIELD__update = new long[]{220L, 272L};
   public static final long[] __DNA__FIELD__is_updating = new long[]{224L, 276L};
   public static final long[] __DNA__FIELD__done = new long[]{226L, 278L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{228L, 280L};
   public static final long[] __DNA__FIELD__nodetype = new long[]{232L, 284L};
   public static final long[] __DNA__FIELD__edit_quality = new long[]{236L, 288L};
   public static final long[] __DNA__FIELD__render_quality = new long[]{238L, 290L};
   public static final long[] __DNA__FIELD__chunksize = new long[]{240L, 292L};
   public static final long[] __DNA__FIELD__viewer_border = new long[]{244L, 296L};
   public static final long[] __DNA__FIELD__inputs = new long[]{260L, 312L};
   public static final long[] __DNA__FIELD__outputs = new long[]{268L, 328L};
   public static final long[] __DNA__FIELD__previews = new long[]{276L, 344L};
   public static final long[] __DNA__FIELD__active_viewer_key = new long[]{280L, 352L};
   public static final long[] __DNA__FIELD__pad = new long[]{284L, 356L};
   public static final long[] __DNA__FIELD__execdata = new long[]{288L, 360L};
   public static final long[] __DNA__FIELD__tbh = new long[]{308L, 400L};
   public static final long[] __DNA__FIELD__prh = new long[]{312L, 408L};
   public static final long[] __DNA__FIELD__sdh = new long[]{316L, 416L};
   public static final long[] __DNA__FIELD__udh = new long[]{320L, 424L};
   public static final long[] __DNA__FIELD__duplilock = new long[]{324L, 432L};

   public bNodeTree(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected bNodeTree(bNodeTree that) {
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

   public CPointer<Object> getTypeinfo() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setTypeinfo(CPointer<Object> typeinfo) throws IOException {
      long __address = typeinfo == null ? 0L : typeinfo.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public CArrayFacade<Byte> getIdname() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{64};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 136L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 108L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setIdname(CArrayFacade<Byte> idname) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 136L;
      } else {
         __dna__offset = 108L;
      }

      if (!this.__io__equals(idname, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, idname)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, idname);
         } else {
            __io__generic__copy(this.getIdname(), idname);
         }

      }
   }

   public CPointer<Object> getInterface_type() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 172L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setInterface_type(CPointer<Object> interface_type) throws IOException {
      long __address = interface_type == null ? 0L : interface_type.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 172L, __address);
      }

   }

   public CPointer<bGPdata> getGpd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 208L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bGPdata.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 497), this.__io__blockTable);
   }

   public void setGpd(CPointer<bGPdata> gpd) throws IOException {
      long __address = gpd == null ? 0L : gpd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 208L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      }

   }

   public CArrayFacade<Float> getView_center() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{2};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 216L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 180L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setView_center(CArrayFacade<Float> view_center) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 216L;
      } else {
         __dna__offset = 180L;
      }

      if (!this.__io__equals(view_center, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, view_center)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, view_center);
         } else {
            __io__generic__copy(this.getView_center(), view_center);
         }

      }
   }

   public ListBase getNodes() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 224L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 188L, this.__io__block, this.__io__blockTable);
   }

   public void setNodes(ListBase nodes) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 224L;
      } else {
         __dna__offset = 188L;
      }

      if (!this.__io__equals(nodes, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, nodes)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, nodes);
         } else {
            __io__generic__copy(this.getNodes(), nodes);
         }

      }
   }

   public ListBase getLinks() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 240L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 196L, this.__io__block, this.__io__blockTable);
   }

   public void setLinks(ListBase links) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 240L;
      } else {
         __dna__offset = 196L;
      }

      if (!this.__io__equals(links, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, links)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, links);
         } else {
            __io__generic__copy(this.getLinks(), links);
         }

      }
   }

   public int getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 256L) : this.__io__block.readInt(this.__io__address + 204L);
   }

   public void setType(int type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 256L, type);
      } else {
         this.__io__block.writeInt(this.__io__address + 204L, type);
      }

   }

   public int getInit() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 260L) : this.__io__block.readInt(this.__io__address + 208L);
   }

   public void setInit(int init) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 260L, init);
      } else {
         this.__io__block.writeInt(this.__io__address + 208L, init);
      }

   }

   public int getCur_index() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 264L) : this.__io__block.readInt(this.__io__address + 212L);
   }

   public void setCur_index(int cur_index) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 264L, cur_index);
      } else {
         this.__io__block.writeInt(this.__io__address + 212L, cur_index);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 268L) : this.__io__block.readInt(this.__io__address + 216L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 268L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 216L, flag);
      }

   }

   public int getUpdate() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 272L) : this.__io__block.readInt(this.__io__address + 220L);
   }

   public void setUpdate(int update) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 272L, update);
      } else {
         this.__io__block.writeInt(this.__io__address + 220L, update);
      }

   }

   public short getIs_updating() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 276L) : this.__io__block.readShort(this.__io__address + 224L);
   }

   public void setIs_updating(short is_updating) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 276L, is_updating);
      } else {
         this.__io__block.writeShort(this.__io__address + 224L, is_updating);
      }

   }

   public short getDone() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 278L) : this.__io__block.readShort(this.__io__address + 226L);
   }

   public void setDone(short done) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 278L, done);
      } else {
         this.__io__block.writeShort(this.__io__address + 226L, done);
      }

   }

   public int getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 280L) : this.__io__block.readInt(this.__io__address + 228L);
   }

   public void setPad2(int pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 280L, pad2);
      } else {
         this.__io__block.writeInt(this.__io__address + 228L, pad2);
      }

   }

   public int getNodetype() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 284L) : this.__io__block.readInt(this.__io__address + 232L);
   }

   public void setNodetype(int nodetype) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 284L, nodetype);
      } else {
         this.__io__block.writeInt(this.__io__address + 232L, nodetype);
      }

   }

   public short getEdit_quality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 288L) : this.__io__block.readShort(this.__io__address + 236L);
   }

   public void setEdit_quality(short edit_quality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 288L, edit_quality);
      } else {
         this.__io__block.writeShort(this.__io__address + 236L, edit_quality);
      }

   }

   public short getRender_quality() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 290L) : this.__io__block.readShort(this.__io__address + 238L);
   }

   public void setRender_quality(short render_quality) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 290L, render_quality);
      } else {
         this.__io__block.writeShort(this.__io__address + 238L, render_quality);
      }

   }

   public int getChunksize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 292L) : this.__io__block.readInt(this.__io__address + 240L);
   }

   public void setChunksize(int chunksize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 292L, chunksize);
      } else {
         this.__io__block.writeInt(this.__io__address + 240L, chunksize);
      }

   }

   public rctf getViewer_border() throws IOException {
      return this.__io__pointersize == 8 ? new rctf(this.__io__address + 296L, this.__io__block, this.__io__blockTable) : new rctf(this.__io__address + 244L, this.__io__block, this.__io__blockTable);
   }

   public void setViewer_border(rctf viewer_border) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 296L;
      } else {
         __dna__offset = 244L;
      }

      if (!this.__io__equals(viewer_border, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, viewer_border)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, viewer_border);
         } else {
            __io__generic__copy(this.getViewer_border(), viewer_border);
         }

      }
   }

   public ListBase getInputs() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 312L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 260L, this.__io__block, this.__io__blockTable);
   }

   public void setInputs(ListBase inputs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 312L;
      } else {
         __dna__offset = 260L;
      }

      if (!this.__io__equals(inputs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, inputs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, inputs);
         } else {
            __io__generic__copy(this.getInputs(), inputs);
         }

      }
   }

   public ListBase getOutputs() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 328L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 268L, this.__io__block, this.__io__blockTable);
   }

   public void setOutputs(ListBase outputs) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 328L;
      } else {
         __dna__offset = 268L;
      }

      if (!this.__io__equals(outputs, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, outputs)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, outputs);
         } else {
            __io__generic__copy(this.getOutputs(), outputs);
         }

      }
   }

   public CPointer<Object> getPreviews() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 344L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 276L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPreviews(CPointer<Object> previews) throws IOException {
      long __address = previews == null ? 0L : previews.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 344L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 276L, __address);
      }

   }

   public bNodeInstanceKey getActive_viewer_key() throws IOException {
      return this.__io__pointersize == 8 ? new bNodeInstanceKey(this.__io__address + 352L, this.__io__block, this.__io__blockTable) : new bNodeInstanceKey(this.__io__address + 280L, this.__io__block, this.__io__blockTable);
   }

   public void setActive_viewer_key(bNodeInstanceKey active_viewer_key) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 352L;
      } else {
         __dna__offset = 280L;
      }

      if (!this.__io__equals(active_viewer_key, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, active_viewer_key)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, active_viewer_key);
         } else {
            __io__generic__copy(this.getActive_viewer_key(), active_viewer_key);
         }

      }
   }

   public int getPad() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 356L) : this.__io__block.readInt(this.__io__address + 284L);
   }

   public void setPad(int pad) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 356L, pad);
      } else {
         this.__io__block.writeInt(this.__io__address + 284L, pad);
      }

   }

   public CPointer<Object> getExecdata() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 360L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 288L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setExecdata(CPointer<Object> execdata) throws IOException {
      long __address = execdata == null ? 0L : execdata.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 360L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 288L, __address);
      }

   }

   public CPointer<Object> getTbh() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 400L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 308L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setTbh(CPointer<Object> tbh) throws IOException {
      long __address = tbh == null ? 0L : tbh.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 400L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 308L, __address);
      }

   }

   public CPointer<Object> getPrh() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 408L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 312L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPrh(CPointer<Object> prh) throws IOException {
      long __address = prh == null ? 0L : prh.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 408L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 312L, __address);
      }

   }

   public CPointer<Object> getSdh() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 416L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 316L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSdh(CPointer<Object> sdh) throws IOException {
      long __address = sdh == null ? 0L : sdh.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 416L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 316L, __address);
      }

   }

   public CPointer<Object> getUdh() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 424L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 320L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setUdh(CPointer<Object> udh) throws IOException {
      long __address = udh == null ? 0L : udh.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 424L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 320L, __address);
      }

   }

   public CPointer<Object> getDuplilock() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 432L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 324L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setDuplilock(CPointer<Object> duplilock) throws IOException {
      long __address = duplilock == null ? 0L : duplilock.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 432L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 324L, __address);
      }

   }

   public CPointer<bNodeTree> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{bNodeTree.class}, this.__io__block, this.__io__blockTable);
   }
}
