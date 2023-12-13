package com.replaymod.lib.org.cakelab.blender.utils;

import com.replaymod.lib.org.cakelab.blender.generator.typemap.Renaming;
import com.replaymod.lib.org.cakelab.blender.io.BlenderFile;
import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockCodes;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockHeader;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.io.dna.DNAField;
import com.replaymod.lib.org.cakelab.blender.io.dna.DNAModel;
import com.replaymod.lib.org.cakelab.blender.io.dna.DNAStruct;
import com.replaymod.lib.org.cakelab.blender.io.util.Identifier;
import com.replaymod.lib.org.cakelab.blender.metac.CField;
import com.replaymod.lib.org.cakelab.blender.metac.CStruct;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class MainLibBase {
   protected BlockTable blockTable;
   private String packageName;
   protected BlenderFile blenderFile;

   protected MainLibBase(String packageName, BlenderFile blend) throws IOException {
      this.packageName = packageName;
      this.blenderFile = blend;
      DNAModel model = blend.getBlenderModel();
      this.blockTable = blend.getBlockTable();
      List<Block> blocks = blend.getBlocks();
      Iterator var5 = blocks.iterator();

      while(var5.hasNext()) {
         Block block = (Block)var5.next();
         BlockHeader header = block.header;
         if (this.isPossibleLibraryBlock(header.getCode())) {
            DNAStruct struct = model.getStruct(block.header.getSdnaIndex());
            if (isLibraryElement(struct)) {
               this.addLibraryElements(block, struct);
            }
         }
      }

   }

   private void addLibraryElements(Block block, DNAStruct struct) throws IOException {
      short size = struct.getType().getSize();

      try {
         Class<? extends CFacade> clazz = MainLibBase.class.getClassLoader().loadClass(this.packageName + '.' + Renaming.mapStruct2Class(struct.getType().getName()));
         int count = 0;

         for(long address = block.header.getAddress(); count < block.header.getCount(); address += (long)size) {
            CFacade libElem = CFacade.__io__newInstance(clazz, address, block, this.blockTable);
            this.addLibraryElement(libElem);
            ++count;
         }

      } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException var9) {
         throw new IOException(var9);
      }
   }

   private void addLibraryElement(CFacade libElem) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {
      String methodName = libElem.getClass().getSimpleName();
      methodName = Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1);
      String getMethodName = "get" + methodName;
      Method getter = null;

      try {
         getter = this.getClass().getDeclaredMethod(getMethodName);
      } catch (NoSuchMethodException var8) {
         return;
      }

      CFacade first = (CFacade)getter.invoke(this);
      if (first == null) {
         String setMethodName = "set" + methodName;
         Method setter = this.getClass().getDeclaredMethod(setMethodName, libElem.getClass());
         setter.invoke(this, this.getFirst(libElem));
      }

   }

   protected abstract CFacade getFirst(CFacade var1) throws IOException;

   private boolean isPossibleLibraryBlock(Identifier code) {
      return !code.equals(BlockCodes.ID_DNA1) && !code.equals(BlockCodes.ID_ENDB) && !code.equals(BlockCodes.ID_TEST);
   }

   public static boolean isLibraryElement(CStruct struct) {
      ArrayList<CField> blendFields = struct.getFields();
      return blendFields.size() > 0 ? ((CField)blendFields.get(0)).getType().getSignature().equals("ID") : false;
   }

   private static boolean isLibraryElement(DNAStruct struct) {
      DNAField[] blendFields = struct.getFields();
      return blendFields.length > 0 ? blendFields[0].getType().getName().equals("ID") : false;
   }
}
