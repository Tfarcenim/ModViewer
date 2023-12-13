package com.replaymod.lib.org.cakelab.blender.io.block;

import com.replaymod.lib.org.cakelab.blender.io.dna.DNAModel;
import com.replaymod.lib.org.cakelab.blender.io.dna.DNAStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class OverlappingBlocksException extends RuntimeException {
   private static final long serialVersionUID = 1L;
   private HashMap<Block, ArrayList<Block>> overlaps = new HashMap();
   private StringBuffer message = new StringBuffer("File contains overlapping blocks which are not properly handled by this version of Java .Blend");

   public String getMessage() {
      return this.toString();
   }

   public String getLocalizedMessage() {
      return this.toString();
   }

   public String toString() {
      return this.message.toString() + "\nPlease refer to Java .Blend's documentation to find a solution or contact the developer (http://homac.cakelab.org/contact/).";
   }

   public HashMap<Block, ArrayList<Block>> getOverlappingBlocks() {
      return this.overlaps;
   }

   public void add(Block a, Block b) {
      ArrayList<Block> list = (ArrayList)this.overlaps.get(a);
      if (list == null) {
         list = new ArrayList();
         this.overlaps.put(a, list);
      }

      list.add(b);
   }

   public void addDetailedInfo(DNAModel model) {
      this.message.append("\n");

      try {
         Iterator var2 = this.overlaps.entrySet().iterator();

         while(var2.hasNext()) {
            Entry<Block, ArrayList<Block>> e = (Entry)var2.next();
            Block a = (Block)e.getKey();
            this.message.append("block " + this.getBlockInfo(a, model) + " overlaps the following blocks: \n");
            Iterator var5 = ((ArrayList)e.getValue()).iterator();

            while(var5.hasNext()) {
               Block b = (Block)var5.next();
               this.message.append("\t").append(this.getBlockInfo(b, model));
            }
         }
      } catch (Throwable var7) {
         this.message.append("\nmissing information due to another internal exception during gathering of information");
      }

   }

   private String getBlockInfo(Block block, DNAModel model) {
      String info = "";
      DNAStruct s = model.getStruct(block.header.sdnaIndex);
      if (s != null) {
         info = info + s.getType().getName();
      }

      info = info + "(" + block.header.sdnaIndex + ")";
      return info;
   }
}
