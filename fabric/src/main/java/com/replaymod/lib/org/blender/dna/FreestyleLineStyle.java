package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 332L,
   size64 = 464L
)
public class FreestyleLineStyle extends CFacade {
   public static final int __DNA__SDNA_INDEX = 618;
   public static final long[] __DNA__FIELD__id = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__adt = new long[]{100L, 120L};
   public static final long[] __DNA__FIELD__r = new long[]{104L, 128L};
   public static final long[] __DNA__FIELD__g = new long[]{108L, 132L};
   public static final long[] __DNA__FIELD__b = new long[]{112L, 136L};
   public static final long[] __DNA__FIELD__alpha = new long[]{116L, 140L};
   public static final long[] __DNA__FIELD__thickness = new long[]{120L, 144L};
   public static final long[] __DNA__FIELD__thickness_position = new long[]{124L, 148L};
   public static final long[] __DNA__FIELD__thickness_ratio = new long[]{128L, 152L};
   public static final long[] __DNA__FIELD__flag = new long[]{132L, 156L};
   public static final long[] __DNA__FIELD__caps = new long[]{136L, 160L};
   public static final long[] __DNA__FIELD__chaining = new long[]{140L, 164L};
   public static final long[] __DNA__FIELD__rounds = new long[]{144L, 168L};
   public static final long[] __DNA__FIELD__split_length = new long[]{148L, 172L};
   public static final long[] __DNA__FIELD__min_angle = new long[]{152L, 176L};
   public static final long[] __DNA__FIELD__max_angle = new long[]{156L, 180L};
   public static final long[] __DNA__FIELD__min_length = new long[]{160L, 184L};
   public static final long[] __DNA__FIELD__max_length = new long[]{164L, 188L};
   public static final long[] __DNA__FIELD__chain_count = new long[]{168L, 192L};
   public static final long[] __DNA__FIELD__split_dash1 = new long[]{172L, 196L};
   public static final long[] __DNA__FIELD__split_gap1 = new long[]{174L, 198L};
   public static final long[] __DNA__FIELD__split_dash2 = new long[]{176L, 200L};
   public static final long[] __DNA__FIELD__split_gap2 = new long[]{178L, 202L};
   public static final long[] __DNA__FIELD__split_dash3 = new long[]{180L, 204L};
   public static final long[] __DNA__FIELD__split_gap3 = new long[]{182L, 206L};
   public static final long[] __DNA__FIELD__sort_key = new long[]{184L, 208L};
   public static final long[] __DNA__FIELD__integration_type = new long[]{188L, 212L};
   public static final long[] __DNA__FIELD__texstep = new long[]{192L, 216L};
   public static final long[] __DNA__FIELD__texact = new long[]{196L, 220L};
   public static final long[] __DNA__FIELD__pr_texture = new long[]{198L, 222L};
   public static final long[] __DNA__FIELD__use_nodes = new long[]{200L, 224L};
   public static final long[] __DNA__FIELD__pad = new long[]{202L, 226L};
   public static final long[] __DNA__FIELD__dash1 = new long[]{208L, 232L};
   public static final long[] __DNA__FIELD__gap1 = new long[]{210L, 234L};
   public static final long[] __DNA__FIELD__dash2 = new long[]{212L, 236L};
   public static final long[] __DNA__FIELD__gap2 = new long[]{214L, 238L};
   public static final long[] __DNA__FIELD__dash3 = new long[]{216L, 240L};
   public static final long[] __DNA__FIELD__gap3 = new long[]{218L, 242L};
   public static final long[] __DNA__FIELD__panel = new long[]{220L, 244L};
   public static final long[] __DNA__FIELD__mtex = new long[]{224L, 248L};
   public static final long[] __DNA__FIELD__nodetree = new long[]{296L, 392L};
   public static final long[] __DNA__FIELD__color_modifiers = new long[]{300L, 400L};
   public static final long[] __DNA__FIELD__alpha_modifiers = new long[]{308L, 416L};
   public static final long[] __DNA__FIELD__thickness_modifiers = new long[]{316L, 432L};
   public static final long[] __DNA__FIELD__geometry_modifiers = new long[]{324L, 448L};

   public FreestyleLineStyle(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected FreestyleLineStyle(FreestyleLineStyle that) {
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

   public float getR() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 128L) : this.__io__block.readFloat(this.__io__address + 104L);
   }

   public void setR(float r) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 128L, r);
      } else {
         this.__io__block.writeFloat(this.__io__address + 104L, r);
      }

   }

   public float getG() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 132L) : this.__io__block.readFloat(this.__io__address + 108L);
   }

   public void setG(float g) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 132L, g);
      } else {
         this.__io__block.writeFloat(this.__io__address + 108L, g);
      }

   }

   public float getB() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 136L) : this.__io__block.readFloat(this.__io__address + 112L);
   }

   public void setB(float b) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 136L, b);
      } else {
         this.__io__block.writeFloat(this.__io__address + 112L, b);
      }

   }

   public float getAlpha() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 140L) : this.__io__block.readFloat(this.__io__address + 116L);
   }

   public void setAlpha(float alpha) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 140L, alpha);
      } else {
         this.__io__block.writeFloat(this.__io__address + 116L, alpha);
      }

   }

   public float getThickness() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 144L) : this.__io__block.readFloat(this.__io__address + 120L);
   }

   public void setThickness(float thickness) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 144L, thickness);
      } else {
         this.__io__block.writeFloat(this.__io__address + 120L, thickness);
      }

   }

   public int getThickness_position() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 148L) : this.__io__block.readInt(this.__io__address + 124L);
   }

   public void setThickness_position(int thickness_position) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 148L, thickness_position);
      } else {
         this.__io__block.writeInt(this.__io__address + 124L, thickness_position);
      }

   }

   public float getThickness_ratio() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 152L) : this.__io__block.readFloat(this.__io__address + 128L);
   }

   public void setThickness_ratio(float thickness_ratio) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 152L, thickness_ratio);
      } else {
         this.__io__block.writeFloat(this.__io__address + 128L, thickness_ratio);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 156L) : this.__io__block.readInt(this.__io__address + 132L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 156L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 132L, flag);
      }

   }

   public int getCaps() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 160L) : this.__io__block.readInt(this.__io__address + 136L);
   }

   public void setCaps(int caps) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 160L, caps);
      } else {
         this.__io__block.writeInt(this.__io__address + 136L, caps);
      }

   }

   public int getChaining() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 164L) : this.__io__block.readInt(this.__io__address + 140L);
   }

   public void setChaining(int chaining) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 164L, chaining);
      } else {
         this.__io__block.writeInt(this.__io__address + 140L, chaining);
      }

   }

   public int getRounds() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 168L) : this.__io__block.readInt(this.__io__address + 144L);
   }

   public void setRounds(int rounds) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 168L, rounds);
      } else {
         this.__io__block.writeInt(this.__io__address + 144L, rounds);
      }

   }

   public float getSplit_length() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 172L) : this.__io__block.readFloat(this.__io__address + 148L);
   }

   public void setSplit_length(float split_length) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 172L, split_length);
      } else {
         this.__io__block.writeFloat(this.__io__address + 148L, split_length);
      }

   }

   public float getMin_angle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 176L) : this.__io__block.readFloat(this.__io__address + 152L);
   }

   public void setMin_angle(float min_angle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 176L, min_angle);
      } else {
         this.__io__block.writeFloat(this.__io__address + 152L, min_angle);
      }

   }

   public float getMax_angle() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 180L) : this.__io__block.readFloat(this.__io__address + 156L);
   }

   public void setMax_angle(float max_angle) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 180L, max_angle);
      } else {
         this.__io__block.writeFloat(this.__io__address + 156L, max_angle);
      }

   }

   public float getMin_length() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 184L) : this.__io__block.readFloat(this.__io__address + 160L);
   }

   public void setMin_length(float min_length) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 184L, min_length);
      } else {
         this.__io__block.writeFloat(this.__io__address + 160L, min_length);
      }

   }

   public float getMax_length() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 188L) : this.__io__block.readFloat(this.__io__address + 164L);
   }

   public void setMax_length(float max_length) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 188L, max_length);
      } else {
         this.__io__block.writeFloat(this.__io__address + 164L, max_length);
      }

   }

   public int getChain_count() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 192L) : this.__io__block.readInt(this.__io__address + 168L);
   }

   public void setChain_count(int chain_count) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 192L, chain_count);
      } else {
         this.__io__block.writeInt(this.__io__address + 168L, chain_count);
      }

   }

   public short getSplit_dash1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 196L) : this.__io__block.readShort(this.__io__address + 172L);
   }

   public void setSplit_dash1(short split_dash1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 196L, split_dash1);
      } else {
         this.__io__block.writeShort(this.__io__address + 172L, split_dash1);
      }

   }

   public short getSplit_gap1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 198L) : this.__io__block.readShort(this.__io__address + 174L);
   }

   public void setSplit_gap1(short split_gap1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 198L, split_gap1);
      } else {
         this.__io__block.writeShort(this.__io__address + 174L, split_gap1);
      }

   }

   public short getSplit_dash2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 200L) : this.__io__block.readShort(this.__io__address + 176L);
   }

   public void setSplit_dash2(short split_dash2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 200L, split_dash2);
      } else {
         this.__io__block.writeShort(this.__io__address + 176L, split_dash2);
      }

   }

   public short getSplit_gap2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 202L) : this.__io__block.readShort(this.__io__address + 178L);
   }

   public void setSplit_gap2(short split_gap2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 202L, split_gap2);
      } else {
         this.__io__block.writeShort(this.__io__address + 178L, split_gap2);
      }

   }

   public short getSplit_dash3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 204L) : this.__io__block.readShort(this.__io__address + 180L);
   }

   public void setSplit_dash3(short split_dash3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 204L, split_dash3);
      } else {
         this.__io__block.writeShort(this.__io__address + 180L, split_dash3);
      }

   }

   public short getSplit_gap3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 206L) : this.__io__block.readShort(this.__io__address + 182L);
   }

   public void setSplit_gap3(short split_gap3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 206L, split_gap3);
      } else {
         this.__io__block.writeShort(this.__io__address + 182L, split_gap3);
      }

   }

   public int getSort_key() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 208L) : this.__io__block.readInt(this.__io__address + 184L);
   }

   public void setSort_key(int sort_key) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 208L, sort_key);
      } else {
         this.__io__block.writeInt(this.__io__address + 184L, sort_key);
      }

   }

   public int getIntegration_type() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 212L) : this.__io__block.readInt(this.__io__address + 188L);
   }

   public void setIntegration_type(int integration_type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 212L, integration_type);
      } else {
         this.__io__block.writeInt(this.__io__address + 188L, integration_type);
      }

   }

   public float getTexstep() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 216L) : this.__io__block.readFloat(this.__io__address + 192L);
   }

   public void setTexstep(float texstep) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 216L, texstep);
      } else {
         this.__io__block.writeFloat(this.__io__address + 192L, texstep);
      }

   }

   public short getTexact() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 220L) : this.__io__block.readShort(this.__io__address + 196L);
   }

   public void setTexact(short texact) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 220L, texact);
      } else {
         this.__io__block.writeShort(this.__io__address + 196L, texact);
      }

   }

   public short getPr_texture() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 222L) : this.__io__block.readShort(this.__io__address + 198L);
   }

   public void setPr_texture(short pr_texture) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 222L, pr_texture);
      } else {
         this.__io__block.writeShort(this.__io__address + 198L, pr_texture);
      }

   }

   public short getUse_nodes() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 224L) : this.__io__block.readShort(this.__io__address + 200L);
   }

   public void setUse_nodes(short use_nodes) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 224L, use_nodes);
      } else {
         this.__io__block.writeShort(this.__io__address + 200L, use_nodes);
      }

   }

   public CArrayFacade<Short> getPad() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Short.class};
      int[] __dna__dimensions = new int[]{3};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 226L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 202L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setPad(CArrayFacade<Short> pad) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 226L;
      } else {
         __dna__offset = 202L;
      }

      if (!this.__io__equals(pad, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, pad)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, pad);
         } else {
            __io__generic__copy(this.getPad(), pad);
         }

      }
   }

   public short getDash1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 232L) : this.__io__block.readShort(this.__io__address + 208L);
   }

   public void setDash1(short dash1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 232L, dash1);
      } else {
         this.__io__block.writeShort(this.__io__address + 208L, dash1);
      }

   }

   public short getGap1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 234L) : this.__io__block.readShort(this.__io__address + 210L);
   }

   public void setGap1(short gap1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 234L, gap1);
      } else {
         this.__io__block.writeShort(this.__io__address + 210L, gap1);
      }

   }

   public short getDash2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 236L) : this.__io__block.readShort(this.__io__address + 212L);
   }

   public void setDash2(short dash2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 236L, dash2);
      } else {
         this.__io__block.writeShort(this.__io__address + 212L, dash2);
      }

   }

   public short getGap2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 238L) : this.__io__block.readShort(this.__io__address + 214L);
   }

   public void setGap2(short gap2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 238L, gap2);
      } else {
         this.__io__block.writeShort(this.__io__address + 214L, gap2);
      }

   }

   public short getDash3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 240L) : this.__io__block.readShort(this.__io__address + 216L);
   }

   public void setDash3(short dash3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 240L, dash3);
      } else {
         this.__io__block.writeShort(this.__io__address + 216L, dash3);
      }

   }

   public short getGap3() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 242L) : this.__io__block.readShort(this.__io__address + 218L);
   }

   public void setGap3(short gap3) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 242L, gap3);
      } else {
         this.__io__block.writeShort(this.__io__address + 218L, gap3);
      }

   }

   public int getPanel() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 244L) : this.__io__block.readInt(this.__io__address + 220L);
   }

   public void setPanel(int panel) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 244L, panel);
      } else {
         this.__io__block.writeInt(this.__io__address + 220L, panel);
      }

   }

   public CArrayFacade<CPointer<MTex>> getMtex() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{CPointer.class, MTex.class};
      int[] __dna__dimensions = new int[]{18};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 248L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 224L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setMtex(CArrayFacade<CPointer<MTex>> mtex) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 248L;
      } else {
         __dna__offset = 224L;
      }

      if (!this.__io__equals(mtex, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, mtex)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, mtex);
         } else {
            __io__generic__copy(this.getMtex(), mtex);
         }

      }
   }

   public CPointer<bNodeTree> getNodetree() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 392L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 296L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{bNodeTree.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, 397), this.__io__blockTable);
   }

   public void setNodetree(CPointer<bNodeTree> nodetree) throws IOException {
      long __address = nodetree == null ? 0L : nodetree.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 392L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 296L, __address);
      }

   }

   public ListBase getColor_modifiers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 400L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 300L, this.__io__block, this.__io__blockTable);
   }

   public void setColor_modifiers(ListBase color_modifiers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 400L;
      } else {
         __dna__offset = 300L;
      }

      if (!this.__io__equals(color_modifiers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, color_modifiers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, color_modifiers);
         } else {
            __io__generic__copy(this.getColor_modifiers(), color_modifiers);
         }

      }
   }

   public ListBase getAlpha_modifiers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 416L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 308L, this.__io__block, this.__io__blockTable);
   }

   public void setAlpha_modifiers(ListBase alpha_modifiers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 416L;
      } else {
         __dna__offset = 308L;
      }

      if (!this.__io__equals(alpha_modifiers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, alpha_modifiers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, alpha_modifiers);
         } else {
            __io__generic__copy(this.getAlpha_modifiers(), alpha_modifiers);
         }

      }
   }

   public ListBase getThickness_modifiers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 432L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 316L, this.__io__block, this.__io__blockTable);
   }

   public void setThickness_modifiers(ListBase thickness_modifiers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 432L;
      } else {
         __dna__offset = 316L;
      }

      if (!this.__io__equals(thickness_modifiers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, thickness_modifiers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, thickness_modifiers);
         } else {
            __io__generic__copy(this.getThickness_modifiers(), thickness_modifiers);
         }

      }
   }

   public ListBase getGeometry_modifiers() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 448L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 324L, this.__io__block, this.__io__blockTable);
   }

   public void setGeometry_modifiers(ListBase geometry_modifiers) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 448L;
      } else {
         __dna__offset = 324L;
      }

      if (!this.__io__equals(geometry_modifiers, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, geometry_modifiers)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, geometry_modifiers);
         } else {
            __io__generic__copy(this.getGeometry_modifiers(), geometry_modifiers);
         }

      }
   }

   public CPointer<FreestyleLineStyle> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{FreestyleLineStyle.class}, this.__io__block, this.__io__blockTable);
   }
}
