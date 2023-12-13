package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 56L,
   size64 = 56L
)
public class RecastData extends CFacade {
   public static final int __DNA__SDNA_INDEX = 182;
   public static final long[] __DNA__FIELD__cellsize = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__cellheight = new long[]{4L, 4L};
   public static final long[] __DNA__FIELD__agentmaxslope = new long[]{8L, 8L};
   public static final long[] __DNA__FIELD__agentmaxclimb = new long[]{12L, 12L};
   public static final long[] __DNA__FIELD__agentheight = new long[]{16L, 16L};
   public static final long[] __DNA__FIELD__agentradius = new long[]{20L, 20L};
   public static final long[] __DNA__FIELD__edgemaxlen = new long[]{24L, 24L};
   public static final long[] __DNA__FIELD__edgemaxerror = new long[]{28L, 28L};
   public static final long[] __DNA__FIELD__regionminsize = new long[]{32L, 32L};
   public static final long[] __DNA__FIELD__regionmergesize = new long[]{36L, 36L};
   public static final long[] __DNA__FIELD__vertsperpoly = new long[]{40L, 40L};
   public static final long[] __DNA__FIELD__detailsampledist = new long[]{44L, 44L};
   public static final long[] __DNA__FIELD__detailsamplemaxerror = new long[]{48L, 48L};
   public static final long[] __DNA__FIELD__partitioning = new long[]{52L, 52L};
   public static final long[] __DNA__FIELD__pad1 = new long[]{53L, 53L};
   public static final long[] __DNA__FIELD__pad2 = new long[]{54L, 54L};

   public RecastData(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected RecastData(RecastData that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public float getCellsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 0L) : this.__io__block.readFloat(this.__io__address + 0L);
   }

   public void setCellsize(float cellsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 0L, cellsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 0L, cellsize);
      }

   }

   public float getCellheight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 4L) : this.__io__block.readFloat(this.__io__address + 4L);
   }

   public void setCellheight(float cellheight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 4L, cellheight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 4L, cellheight);
      }

   }

   public float getAgentmaxslope() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 8L) : this.__io__block.readFloat(this.__io__address + 8L);
   }

   public void setAgentmaxslope(float agentmaxslope) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 8L, agentmaxslope);
      } else {
         this.__io__block.writeFloat(this.__io__address + 8L, agentmaxslope);
      }

   }

   public float getAgentmaxclimb() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 12L) : this.__io__block.readFloat(this.__io__address + 12L);
   }

   public void setAgentmaxclimb(float agentmaxclimb) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 12L, agentmaxclimb);
      } else {
         this.__io__block.writeFloat(this.__io__address + 12L, agentmaxclimb);
      }

   }

   public float getAgentheight() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 16L) : this.__io__block.readFloat(this.__io__address + 16L);
   }

   public void setAgentheight(float agentheight) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 16L, agentheight);
      } else {
         this.__io__block.writeFloat(this.__io__address + 16L, agentheight);
      }

   }

   public float getAgentradius() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 20L) : this.__io__block.readFloat(this.__io__address + 20L);
   }

   public void setAgentradius(float agentradius) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 20L, agentradius);
      } else {
         this.__io__block.writeFloat(this.__io__address + 20L, agentradius);
      }

   }

   public float getEdgemaxlen() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 24L) : this.__io__block.readFloat(this.__io__address + 24L);
   }

   public void setEdgemaxlen(float edgemaxlen) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 24L, edgemaxlen);
      } else {
         this.__io__block.writeFloat(this.__io__address + 24L, edgemaxlen);
      }

   }

   public float getEdgemaxerror() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 28L) : this.__io__block.readFloat(this.__io__address + 28L);
   }

   public void setEdgemaxerror(float edgemaxerror) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 28L, edgemaxerror);
      } else {
         this.__io__block.writeFloat(this.__io__address + 28L, edgemaxerror);
      }

   }

   public float getRegionminsize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 32L) : this.__io__block.readFloat(this.__io__address + 32L);
   }

   public void setRegionminsize(float regionminsize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 32L, regionminsize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 32L, regionminsize);
      }

   }

   public float getRegionmergesize() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 36L) : this.__io__block.readFloat(this.__io__address + 36L);
   }

   public void setRegionmergesize(float regionmergesize) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 36L, regionmergesize);
      } else {
         this.__io__block.writeFloat(this.__io__address + 36L, regionmergesize);
      }

   }

   public int getVertsperpoly() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 40L) : this.__io__block.readInt(this.__io__address + 40L);
   }

   public void setVertsperpoly(int vertsperpoly) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 40L, vertsperpoly);
      } else {
         this.__io__block.writeInt(this.__io__address + 40L, vertsperpoly);
      }

   }

   public float getDetailsampledist() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 44L) : this.__io__block.readFloat(this.__io__address + 44L);
   }

   public void setDetailsampledist(float detailsampledist) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 44L, detailsampledist);
      } else {
         this.__io__block.writeFloat(this.__io__address + 44L, detailsampledist);
      }

   }

   public float getDetailsamplemaxerror() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 48L) : this.__io__block.readFloat(this.__io__address + 48L);
   }

   public void setDetailsamplemaxerror(float detailsamplemaxerror) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 48L, detailsamplemaxerror);
      } else {
         this.__io__block.writeFloat(this.__io__address + 48L, detailsamplemaxerror);
      }

   }

   public byte getPartitioning() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 52L) : this.__io__block.readByte(this.__io__address + 52L);
   }

   public void setPartitioning(byte partitioning) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 52L, partitioning);
      } else {
         this.__io__block.writeByte(this.__io__address + 52L, partitioning);
      }

   }

   public byte getPad1() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readByte(this.__io__address + 53L) : this.__io__block.readByte(this.__io__address + 53L);
   }

   public void setPad1(byte pad1) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeByte(this.__io__address + 53L, pad1);
      } else {
         this.__io__block.writeByte(this.__io__address + 53L, pad1);
      }

   }

   public short getPad2() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readShort(this.__io__address + 54L) : this.__io__block.readShort(this.__io__address + 54L);
   }

   public void setPad2(short pad2) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeShort(this.__io__address + 54L, pad2);
      } else {
         this.__io__block.writeShort(this.__io__address + 54L, pad2);
      }

   }

   public CPointer<RecastData> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{RecastData.class}, this.__io__block, this.__io__blockTable);
   }
}
