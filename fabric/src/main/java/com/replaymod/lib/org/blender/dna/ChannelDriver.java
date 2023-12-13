package com.replaymod.lib.org.blender.dna;

import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CMetaData;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.IOException;

@CMetaData(
   size32 = 284L,
   size64 = 296L
)
public class ChannelDriver extends CFacade {
   public static final int __DNA__SDNA_INDEX = 518;
   public static final long[] __DNA__FIELD__variables = new long[]{0L, 0L};
   public static final long[] __DNA__FIELD__expression = new long[]{8L, 16L};
   public static final long[] __DNA__FIELD__expr_comp = new long[]{264L, 272L};
   public static final long[] __DNA__FIELD__curval = new long[]{268L, 280L};
   public static final long[] __DNA__FIELD__influence = new long[]{272L, 284L};
   public static final long[] __DNA__FIELD__type = new long[]{276L, 288L};
   public static final long[] __DNA__FIELD__flag = new long[]{280L, 292L};

   public ChannelDriver(long __address, Block __block, BlockTable __blockTable) {
      super(__address, __block, __blockTable);
   }

   protected ChannelDriver(ChannelDriver that) {
      super(that.__io__address, that.__io__block, that.__io__blockTable);
   }

   public ListBase getVariables() throws IOException {
      return this.__io__pointersize == 8 ? new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable) : new ListBase(this.__io__address + 0L, this.__io__block, this.__io__blockTable);
   }

   public void setVariables(ListBase variables) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 0L;
      } else {
         __dna__offset = 0L;
      }

      if (!this.__io__equals(variables, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, variables)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, variables);
         } else {
            __io__generic__copy(this.getVariables(), variables);
         }

      }
   }

   public CArrayFacade<Byte> getExpression() throws IOException {
      Class<?>[] __dna__targetTypes = new Class[]{Byte.class};
      int[] __dna__dimensions = new int[]{256};
      return this.__io__pointersize == 8 ? new CArrayFacade(this.__io__address + 16L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable) : new CArrayFacade(this.__io__address + 8L, __dna__targetTypes, __dna__dimensions, this.__io__block, this.__io__blockTable);
   }

   public void setExpression(CArrayFacade<Byte> expression) throws IOException {
      long __dna__offset;
      if (this.__io__pointersize == 8) {
         __dna__offset = 16L;
      } else {
         __dna__offset = 8L;
      }

      if (!this.__io__equals(expression, this.__io__address + __dna__offset)) {
         if (this.__io__same__encoding(this, expression)) {
            __io__native__copy(this.__io__block, this.__io__address + __dna__offset, expression);
         } else {
            __io__generic__copy(this.getExpression(), expression);
         }

      }
   }

   public CPointer<Object> getExpr_comp() throws IOException {
      long __dna__targetAddress;
      if (this.__io__pointersize == 8) {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 272L);
      } else {
         __dna__targetAddress = this.__io__block.readLong(this.__io__address + 264L);
      }

      Class<?>[] __dna__targetTypes = new Class[]{Object.class};
      return new CPointer(__dna__targetAddress, __dna__targetTypes, this.__io__blockTable.getBlock(__dna__targetAddress, -1), this.__io__blockTable);
   }

   public void setExpr_comp(CPointer<Object> expr_comp) throws IOException {
      long __address = expr_comp == null ? 0L : expr_comp.getAddress();
      if (this.__io__pointersize == 8) {
         this.__io__block.writeLong(this.__io__address + 272L, __address);
      } else {
         this.__io__block.writeLong(this.__io__address + 264L, __address);
      }

   }

   public float getCurval() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 280L) : this.__io__block.readFloat(this.__io__address + 268L);
   }

   public void setCurval(float curval) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 280L, curval);
      } else {
         this.__io__block.writeFloat(this.__io__address + 268L, curval);
      }

   }

   public float getInfluence() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readFloat(this.__io__address + 284L) : this.__io__block.readFloat(this.__io__address + 272L);
   }

   public void setInfluence(float influence) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeFloat(this.__io__address + 284L, influence);
      } else {
         this.__io__block.writeFloat(this.__io__address + 272L, influence);
      }

   }

   public int getType() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 288L) : this.__io__block.readInt(this.__io__address + 276L);
   }

   public void setType(int type) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 288L, type);
      } else {
         this.__io__block.writeInt(this.__io__address + 276L, type);
      }

   }

   public int getFlag() throws IOException {
      return this.__io__pointersize == 8 ? this.__io__block.readInt(this.__io__address + 292L) : this.__io__block.readInt(this.__io__address + 280L);
   }

   public void setFlag(int flag) throws IOException {
      if (this.__io__pointersize == 8) {
         this.__io__block.writeInt(this.__io__address + 292L, flag);
      } else {
         this.__io__block.writeInt(this.__io__address + 280L, flag);
      }

   }

   public CPointer<ChannelDriver> __io__addressof() {
      return new CPointer(this.__io__address, new Class[]{ChannelDriver.class}, this.__io__block, this.__io__blockTable);
   }
}
