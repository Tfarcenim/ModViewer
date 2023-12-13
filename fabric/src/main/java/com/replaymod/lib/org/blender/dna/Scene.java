package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 5224L,
   size64 = 5472L
)
public class Scene extends CFacade {
   public static final int __DNA__SDNA_INDEX = 204;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__camera = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__world = new long[]{108L, 136L};
   public static final long[] __DNA__FIELD__set = new long[]{112L, 144L};
   public static final long[] __DNA__FIELD__base = new long[]{116L, 152L};
   public static final long[] __DNA__FIELD__basact = new long[]{124L, 168L};
   public static final long[] __DNA__FIELD__obedit = new long[]{128L, 176L};
   public static final long[] __DNA__FIELD__cursor = new long[]{132L, 184L};
   public static final long[] __DNA__FIELD__twcent = new long[]{144L, 196L};
   public static final long[] __DNA__FIELD__twmin = new long[]{156L, 208L};
   public static final long[] __DNA__FIELD__twmax = new long[]{168L, 220L};
   public static final long[] __DNA__FIELD__lay = new long[]{180L, 232L};
   public static final long[] __DNA__FIELD__layact = new long[]{184L, 236L};
   public static final long[] __DNA__FIELD__lay_updated = new long[]{188L, 240L};
   public static final long[] __DNA__FIELD__flag = new long[]{192L, 244L};
   public static final long[] __DNA__FIELD__use_nodes = new long[]{194L, 246L};
   public static final long[] __DNA__FIELD__pad = new long[]{195L, 247L};
   public static final long[] __DNA__FIELD__nodetree = new long[]{196L, 248L};
   public static final long[] __DNA__FIELD__ed = new long[]{200L, 256L};
   public static final long[] __DNA__FIELD__toolsettings = new long[]{204L, 264L};
   public static final long[] __DNA__FIELD__stats = new long[]{208L, 272L};
   public static final long[] __DNA__FIELD__safe_areas = new long[]{212L, 280L};
   public static final long[] __DNA__FIELD__r = new long[]{244L, 312L};
   public static final long[] __DNA__FIELD__audio = new long[]{4580L, 4744L};
   public static final long[] __DNA__FIELD__markers = new long[]{4612L, 4776L};
   public static final long[] __DNA__FIELD__transform_spaces = new long[]{4620L, 4792L};
   public static final long[] __DNA__FIELD__sound_scene = new long[]{4628L, 4808L};
   public static final long[] __DNA__FIELD__playback_handle = new long[]{4632L, 4816L};
   public static final long[] __DNA__FIELD__sound_scrub_handle = new long[]{4636L, 4824L};
   public static final long[] __DNA__FIELD__speaker_handles = new long[]{4640L, 4832L};
   public static final long[] __DNA__FIELD__fps_info = new long[]{4644L, 4840L};
   public static final long[] __DNA__FIELD__depsgraph = new long[]{4648L, 4848L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{4652L, 4856L};
   public static final long[] __DNA__FIELD__theDag = new long[]{4656L, 4864L};
   public static final long[] __DNA__FIELD__dagflags = new long[]{4660L, 4872L};
   public static final long[] __DNA__FIELD__pad3 = new long[]{4662L, 4874L};
   public static final long[] __DNA__FIELD__active_keyingset = new long[]{4664L, 4876L};
   public static final long[] __DNA__FIELD__keyingsets = new long[]{4668L, 4880L};
   public static final long[] __DNA__FIELD__framing = new long[]{4676L, 4896L};
   public static final long[] __DNA__FIELD__gm = new long[]{4692L, 4912L};
   public static final long[] __DNA__FIELD__unit = new long[]{4880L, 5104L};
   public static final long[] __DNA__FIELD__gpd = new long[]{4888L, 5112L};
   public static final long[] __DNA__FIELD__physics_settings = new long[]{4892L, 5120L};
   public static final long[] __DNA__FIELD__clip = new long[]{4916L, 5144L};
   public static final long[] __DNA__FIELD__customdata_mask = new long[]{4920L, 5152L};
   public static final long[] __DNA__FIELD__customdata_mask_modal = new long[]{4928L, 5160L};
   public static final long[] __DNA__FIELD__view_settings = new long[]{4936L, 5168L};
   public static final long[] __DNA__FIELD__display_settings = new long[]{5088L, 5328L};
   public static final long[] __DNA__FIELD__sequencer_colorspace_settings = new long[]{5152L, 5392L};
   public static final long[] __DNA__FIELD__rigidbody_world = new long[]{5216L, 5456L};
   public static final long[] __DNA__FIELD__preview = new long[]{5220L, 5464L};

   public Scene(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected Scene(Scene that) {
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

   public CPointer<BlenderObject> getCamera() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 104L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setCamera(CPointer<BlenderObject> camera) throws IOException {
      long __address = camera == null ? 0L : camera.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 104L, __address);
      }

   }

   public CPointer<World> getWorld() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 136L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 108L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{World.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 166), this.__io__blockTable);
   }

   public void setWorld(CPointer<World> world) throws IOException {
      long __address = world == null ? 0L : world.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 136L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 108L, __address);
      }

   }

   public CPointer<Scene> getSet() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 112L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Scene.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 204), this.__io__blockTable);
   }

   public void setSet(CPointer<Scene> set) throws IOException {
      long __address = set == null ? 0L : set.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 112L, __address);
      }

   }

   public ListBase getBase() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 152L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 116L, this.__io__block, this.__io__blockTable);
   }

   public void setBase(ListBase base) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 152L;
      } else {
         __dna__offset = 116L;
      }

      if (!this.__io__equals(base, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, base)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, base);
         } else {
            __io__generic__copy(this.getBase(), base);
         }

      }
   }

   public CPointer<Base> getBasact() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 168L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 124L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Base.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 167), this.__io__blockTable);
   }

   public void setBasact(CPointer<Base> basact) throws IOException {
      long __address = basact == null ? 0L : basact.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 168L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 124L, __address);
      }

   }

   public CPointer<BlenderObject> getObedit() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 176L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 128L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{BlenderObject.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 153), this.__io__blockTable);
   }

   public void setObedit(CPointer<BlenderObject> obedit) throws IOException {
      long __address = obedit == null ? 0L : obedit.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 176L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 128L, __address);
      }

   }

   public CArrayFacade<Float> getCursor() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 184L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 132L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setCursor(CArrayFacade<Float> cursor) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 184L;
      } else {
         __dna__offset = 132L;
      }

      if (!this.__io__equals(cursor, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, cursor)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, cursor);
         } else {
            __io__generic__copy(this.getCursor(), cursor);
         }

      }
   }

   public CArrayFacade<Float> getTwcent() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 196L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 144L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTwcent(CArrayFacade<Float> twcent) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 196L;
      } else {
         __dna__offset = 144L;
      }

      if (!this.__io__equals(twcent, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, twcent)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, twcent);
         } else {
            __io__generic__copy(this.getTwcent(), twcent);
         }

      }
   }

   public CArrayFacade<Float> getTwmin() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 208L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 156L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTwmin(CArrayFacade<Float> twmin) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 208L;
      } else {
         __dna__offset = 156L;
      }

      if (!this.__io__equals(twmin, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, twmin)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, twmin);
         } else {
            __io__generic__copy(this.getTwmin(), twmin);
         }

      }
   }

   public CArrayFacade<Float> getTwmax() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Float.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 220L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 168L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setTwmax(CArrayFacade<Float> twmax) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 220L;
      } else {
         __dna__offset = 168L;
      }

      if (!this.__io__equals(twmax, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, twmax)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, twmax);
         } else {
            __io__generic__copy(this.getTwmax(), twmax);
         }

      }
   }

   public int getLay() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 232L) : this.__io__block.readInt(this.__io__address + 180L);
   }

   public void setLay(int lay) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 232L, lay);
      } else {
         this.__io__block.writeInt(this.__io__address + 180L, lay);
      }

   }

   public int getLayact() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 236L) : this.__io__block.readInt(this.__io__address + 184L);
   }

   public void setLayact(int layact) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 236L, layact);
      } else {
         this.__io__block.writeInt(this.__io__address + 184L, layact);
      }

   }

   public int getLay_updated() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 240L) : this.__io__block.readInt(this.__io__address + 188L);
   }

   public void setLay_updated(int lay_updated) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 240L, lay_updated);
      } else {
         this.__io__block.writeInt(this.__io__address + 188L, lay_updated);
      }

   }

   public short getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 244L) : this.__io__block.readShort(this.__io__address + 192L);
   }

   public void setFlag(short flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 244L, flag);
      } else {
         this.__io__block.writeShort(this.__io__address + 192L, flag);
      }

   }

   public byte getUse_nodes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 246L) : this.__io__block.readByte(this.__io__address + 194L);
   }

   public void setUse_nodes(byte use_nodes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 246L, use_nodes);
      } else {
         this.__io__block.writeByte(this.__io__address + 194L, use_nodes);
      }

   }

   public CArrayFacade<Byte> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{1};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 247L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 195L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Byte> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 247L;
      } else {
         __dna__offset = 195L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public CPointer<bNodeTree> getNodetree() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 248L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 196L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bNodeTree.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 397), this.__io__blockTable);
   }

   public void setNodetree(CPointer<bNodeTree> nodetree) throws IOException {
      long __address = nodetree == null ? 0L : nodetree.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 248L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 196L, __address);
      }

   }

   public CPointer<Editing> getEd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 256L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 200L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Editing.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 274), this.__io__blockTable);
   }

   public void setEd(CPointer<Editing> ed) throws IOException {
      long __address = ed == null ? 0L : ed.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 256L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 200L, __address);
      }

   }

   public CPointer<ToolSettings> getToolsettings() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 264L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 204L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{ToolSettings.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 199), this.__io__blockTable);
   }

   public void setToolsettings(CPointer<ToolSettings> toolsettings) throws IOException {
      long __address = toolsettings == null ? 0L : toolsettings.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 264L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 204L, __address);
      }

   }

   public CPointer<Object> getStats() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 272L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 208L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setStats(CPointer<Object> stats) throws IOException {
      long __address = stats == null ? 0L : stats.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 272L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 208L, __address);
      }

   }

   public DisplaySafeAreas getSafe_areas() throws IOException {
      return this.__io__pointersize == 8 ? new DisplaySafeAreas(this.__io__address + 280L, this.__io__block, this.__io__blockTable) : new DisplaySafeAreas(this.__io__address + 212L, this.__io__block, this.__io__blockTable);
   }

   public void setSafe_areas(DisplaySafeAreas safe_areas) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 280L;
      } else {
         __dna__offset = 212L;
      }

      if (!this.__io__equals(safe_areas, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, safe_areas)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, safe_areas);
         } else {
            __io__generic__copy(this.getSafe_areas(), safe_areas);
         }

      }
   }

   public RenderData getR() throws IOException {
      return this.__io__pointersize == 8 ? new RenderData(this.__io__address + 312L, this.__io__block, this.__io__blockTable) : new RenderData(this.__io__address + 244L, this.__io__block, this.__io__blockTable);
   }

   public void setR(RenderData r) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 312L;
      } else {
         __dna__offset = 244L;
      }

      if (!this.__io__equals(r, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, r)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, r);
         } else {
            __io__generic__copy(this.getR(), r);
         }

      }
   }

   public AudioData getAudio() throws IOException {
      return this.__io__pointersize == 8 ? new AudioData(this.__io__address + 4744L, this.__io__block, this.__io__blockTable) : new AudioData(this.__io__address + 4580L, this.__io__block, this.__io__blockTable);
   }

   public void setAudio(AudioData audio) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4744L;
      } else {
         __dna__offset = 4580L;
      }

      if (!this.__io__equals(audio, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, audio)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, audio);
         } else {
            __io__generic__copy(this.getAudio(), audio);
         }

      }
   }

   public ListBase getMarkers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 4776L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 4612L, this.__io__block, this.__io__blockTable);
   }

   public void setMarkers(ListBase markers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4776L;
      } else {
         __dna__offset = 4612L;
      }

      if (!this.__io__equals(markers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, markers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, markers);
         } else {
            __io__generic__copy(this.getMarkers(), markers);
         }

      }
   }

   public ListBase getTransform_spaces() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 4792L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 4620L, this.__io__block, this.__io__blockTable);
   }

   public void setTransform_spaces(ListBase transform_spaces) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4792L;
      } else {
         __dna__offset = 4620L;
      }

      if (!this.__io__equals(transform_spaces, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, transform_spaces)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, transform_spaces);
         } else {
            __io__generic__copy(this.getTransform_spaces(), transform_spaces);
         }

      }
   }

   public CPointer<Object> getSound_scene() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4808L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4628L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSound_scene(CPointer<Object> sound_scene) throws IOException {
      long __address = sound_scene == null ? 0L : sound_scene.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 4808L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4628L, __address);
      }

   }

   public CPointer<Object> getPlayback_handle() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4816L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4632L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPlayback_handle(CPointer<Object> playback_handle) throws IOException {
      long __address = playback_handle == null ? 0L : playback_handle.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 4816L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4632L, __address);
      }

   }

   public CPointer<Object> getSound_scrub_handle() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4824L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4636L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSound_scrub_handle(CPointer<Object> sound_scrub_handle) throws IOException {
      long __address = sound_scrub_handle == null ? 0L : sound_scrub_handle.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 4824L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4636L, __address);
      }

   }

   public CPointer<Object> getSpeaker_handles() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4832L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4640L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setSpeaker_handles(CPointer<Object> speaker_handles) throws IOException {
      long __address = speaker_handles == null ? 0L : speaker_handles.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 4832L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4640L, __address);
      }

   }

   public CPointer<Object> getFps_info() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4840L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4644L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setFps_info(CPointer<Object> fps_info) throws IOException {
      long __address = fps_info == null ? 0L : fps_info.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 4840L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4644L, __address);
      }

   }

   public CPointer<Object> getDepsgraph() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4848L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4648L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setDepsgraph(CPointer<Object> depsgraph) throws IOException {
      long __address = depsgraph == null ? 0L : depsgraph.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 4848L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4648L, __address);
      }

   }

   public CPointer<Object> getPad1() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4856L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4652L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setPad1(CPointer<Object> pad1) throws IOException {
      long __address = pad1 == null ? 0L : pad1.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 4856L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4652L, __address);
      }

   }

   public CPointer<Object> getTheDag() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4864L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4656L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setTheDag(CPointer<Object> theDag) throws IOException {
      long __address = theDag == null ? 0L : theDag.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 4864L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4656L, __address);
      }

   }

   public short getDagflags() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4872L) : this.__io__block.readShort(this.__io__address + 4660L);
   }

   public void setDagflags(short dagflags) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4872L, dagflags);
      } else {
         this.__io__block.writeShort(this.__io__address + 4660L, dagflags);
      }

   }

   public short getPad3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 4874L) : this.__io__block.readShort(this.__io__address + 4662L);
   }

   public void setPad3(short pad3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 4874L, pad3);
      } else {
         this.__io__block.writeShort(this.__io__address + 4662L, pad3);
      }

   }

   public int getActive_keyingset() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 4876L) : this.__io__block.readInt(this.__io__address + 4664L);
   }

   public void setActive_keyingset(int active_keyingset) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 4876L, active_keyingset);
      } else {
         this.__io__block.writeInt(this.__io__address + 4664L, active_keyingset);
      }

   }

   public ListBase getKeyingsets() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 4880L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 4668L, this.__io__block, this.__io__blockTable);
   }

   public void setKeyingsets(ListBase keyingsets) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4880L;
      } else {
         __dna__offset = 4668L;
      }

      if (!this.__io__equals(keyingsets, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, keyingsets)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, keyingsets);
         } else {
            __io__generic__copy(this.getKeyingsets(), keyingsets);
         }

      }
   }

   public GameFraming getFraming() throws IOException {
      return this.__io__pointersize == 8 ? new GameFraming(this.__io__address + 4896L, this.__io__block, this.__io__blockTable) : new GameFraming(this.__io__address + 4676L, this.__io__block, this.__io__blockTable);
   }

   public void setFraming(GameFraming framing) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4896L;
      } else {
         __dna__offset = 4676L;
      }

      if (!this.__io__equals(framing, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, framing)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, framing);
         } else {
            __io__generic__copy(this.getFraming(), framing);
         }

      }
   }

   public GameData getGm() throws IOException {
      return this.__io__pointersize == 8 ? new GameData(this.__io__address + 4912L, this.__io__block, this.__io__blockTable) : new GameData(this.__io__address + 4692L, this.__io__block, this.__io__blockTable);
   }

   public void setGm(GameData gm) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 4912L;
      } else {
         __dna__offset = 4692L;
      }

      if (!this.__io__equals(gm, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, gm)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, gm);
         } else {
            __io__generic__copy(this.getGm(), gm);
         }

      }
   }

   public UnitSettings getUnit() throws IOException {
      return this.__io__pointersize == 8 ? new UnitSettings(this.__io__address + 5104L, this.__io__block, this.__io__blockTable) : new UnitSettings(this.__io__address + 4880L, this.__io__block, this.__io__blockTable);
   }

   public void setUnit(UnitSettings unit) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 5104L;
      } else {
         __dna__offset = 4880L;
      }

      if (!this.__io__equals(unit, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, unit)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, unit);
         } else {
            __io__generic__copy(this.getUnit(), unit);
         }

      }
   }

   public CPointer<bGPdata> getGpd() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 5112L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4888L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bGPdata.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 497), this.__io__blockTable);
   }

   public void setGpd(CPointer<bGPdata> gpd) throws IOException {
      long __address = gpd == null ? 0L : gpd.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 5112L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4888L, __address);
      }

   }

   public PhysicsSettings getPhysics_settings() throws IOException {
      return this.__io__pointersize == 8 ? new PhysicsSettings(this.__io__address + 5120L, this.__io__block, this.__io__blockTable) : new PhysicsSettings(this.__io__address + 4892L, this.__io__block, this.__io__blockTable);
   }

   public void setPhysics_settings(PhysicsSettings physics_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 5120L;
      } else {
         __dna__offset = 4892L;
      }

      if (!this.__io__equals(physics_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, physics_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, physics_settings);
         } else {
            __io__generic__copy(this.getPhysics_settings(), physics_settings);
         }

      }
   }

   public CPointer<MovieClip> getClip() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 5144L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 4916L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{MovieClip.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 545), this.__io__blockTable);
   }

   public void setClip(CPointer<MovieClip> clip) throws IOException {
      long __address = clip == null ? 0L : clip.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 5144L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 4916L, __address);
      }

   }

   public long getCustomdata_mask() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt64(this.__io__address + 5152L) : this.__io__block.readInt64(this.__io__address + 4920L);
   }

   public void setCustomdata_mask(long customdata_mask) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt64(this.__io__address + 5152L, customdata_mask);
      } else {
         this.__io__block.writeInt64(this.__io__address + 4920L, customdata_mask);
      }

   }

   public long getCustomdata_mask_modal() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt64(this.__io__address + 5160L) : this.__io__block.readInt64(this.__io__address + 4928L);
   }

   public void setCustomdata_mask_modal(long customdata_mask_modal) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt64(this.__io__address + 5160L, customdata_mask_modal);
      } else {
         this.__io__block.writeInt64(this.__io__address + 4928L, customdata_mask_modal);
      }

   }

   public ColorManagedViewSettings getView_settings() throws IOException {
      return this.__io__pointersize == 8 ? new ColorManagedViewSettings(this.__io__address + 5168L, this.__io__block, this.__io__blockTable) : new ColorManagedViewSettings(this.__io__address + 4936L, this.__io__block, this.__io__blockTable);
   }

   public void setView_settings(ColorManagedViewSettings view_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 5168L;
      } else {
         __dna__offset = 4936L;
      }

      if (!this.__io__equals(view_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, view_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, view_settings);
         } else {
            __io__generic__copy(this.getView_settings(), view_settings);
         }

      }
   }

   public ColorManagedDisplaySettings getDisplay_settings() throws IOException {
      return this.__io__pointersize == 8 ? new ColorManagedDisplaySettings(this.__io__address + 5328L, this.__io__block, this.__io__blockTable) : new ColorManagedDisplaySettings(this.__io__address + 5088L, this.__io__block, this.__io__blockTable);
   }

   public void setDisplay_settings(ColorManagedDisplaySettings display_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 5328L;
      } else {
         __dna__offset = 5088L;
      }

      if (!this.__io__equals(display_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, display_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, display_settings);
         } else {
            __io__generic__copy(this.getDisplay_settings(), display_settings);
         }

      }
   }

   public ColorManagedColorspaceSettings getSequencer_colorspace_settings() throws IOException {
      return this.__io__pointersize == 8 ? new ColorManagedColorspaceSettings(this.__io__address + 5392L, this.__io__block, this.__io__blockTable) : new ColorManagedColorspaceSettings(this.__io__address + 5152L, this.__io__block, this.__io__blockTable);
   }

   public void setSequencer_colorspace_settings(ColorManagedColorspaceSettings sequencer_colorspace_settings) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 5392L;
      } else {
         __dna__offset = 5152L;
      }

      if (!this.__io__equals(sequencer_colorspace_settings, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, sequencer_colorspace_settings)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, sequencer_colorspace_settings);
         } else {
            __io__generic__copy(this.getSequencer_colorspace_settings(), sequencer_colorspace_settings);
         }

      }
   }

   public CPointer<RigidBodyWorld> getRigidbody_world() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 5456L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 5216L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{RigidBodyWorld.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 572), this.__io__blockTable);
   }

   public void setRigidbody_world(CPointer<RigidBodyWorld> rigidbody_world) throws IOException {
      long __address = rigidbody_world == null ? 0L : rigidbody_world.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 5456L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 5216L, __address);
      }

   }

   public CPointer<PreviewImage> getPreview() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 5464L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 5220L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{PreviewImage.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 12), this.__io__blockTable);
   }

   public void setPreview(CPointer<PreviewImage> preview) throws IOException {
      long __address = preview == null ? 0L : preview.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 5464L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 5220L, __address);
      }

   }

   public CPointer<Scene> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{Scene.class}, this.__io__block, this.__io__blockTable);
   }
}
