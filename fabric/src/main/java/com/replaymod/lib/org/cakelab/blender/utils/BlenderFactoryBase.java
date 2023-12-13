package com.replaymod.lib.org.cakelab.blender.utils;

import com.replaymod.lib.org.cakelab.blender.io.BlenderFile;
import com.replaymod.lib.org.cakelab.blender.io.FileHeader;
import com.replaymod.lib.org.cakelab.blender.io.block.Block;
import com.replaymod.lib.org.cakelab.blender.io.block.BlockTable;
import com.replaymod.lib.org.cakelab.blender.io.dna.internal.StructDNA;
import com.replaymod.lib.org.cakelab.blender.io.util.BigEndianInputStreamWrapper;
import com.replaymod.lib.org.cakelab.blender.io.util.Identifier;
import com.replaymod.lib.org.cakelab.blender.nio.CArrayFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class BlenderFactoryBase {
   protected BlenderFile blend;
   private CPointer<Object> NULL;

   public BlenderFactoryBase(BlenderFile blend) throws IOException {
      this.blend = blend;
      this.NULL = getNullPointer(blend);
   }

   public static CPointer<Object> getNullPointer(BlenderFile blend) throws IOException {
      return new CPointer(0L, new Class[]{Object.class}, (Block)null, blend.getBlockTable());
   }

   public CPointer<Object> getNullPointer() {
      return this.NULL;
   }

   public static <T extends CFacade> T newCStructBlock(Identifier blockCode, Class<T> facetClass, BlenderFile blend) throws IOException {
      BlockTable blockTable = blend.getBlockTable();

      try {
         Field field__dna__sdnaIndex = facetClass.getDeclaredField("__DNA__SDNA_INDEX");
         int sdnaIndex = field__dna__sdnaIndex.getInt((Object)null);
         Block block = blockTable.allocate(blockCode, CFacade.__io__sizeof(facetClass, blend.getEncoding().getAddressWidth()), sdnaIndex, 1);
         blend.add(block);
         return CFacade.__io__newInstance(facetClass, block.header.getAddress(), block, blockTable);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | SecurityException | IllegalArgumentException var7) {
         throw new IOException(var7);
      } catch (NoSuchFieldException var8) {
         throw new IOException("you cannot instantiate pointers or arrays this way. Use the appropriate factory methods for the respective types instead.", var8);
      }
   }

   public <T extends CFacade> T newCStructBlock(Identifier blockCode, Class<T> facetClass) throws IOException {
      return newCStructBlock(blockCode, facetClass, this.blend);
   }

   public static <T extends CFacade> CArrayFacade<T> newCStructBlock(Identifier blockCode, Class<T> facetClass, int count, BlenderFile blend) throws IOException {
      BlockTable blockTable = blend.getBlockTable();

      try {
         Field field__dna__sdnaIndex = facetClass.getDeclaredField("__DNA__SDNA_INDEX");
         int sdnaIndex = field__dna__sdnaIndex.getInt((Object)null);
         Block block = blockTable.allocate(blockCode, CFacade.__io__sizeof(facetClass, blend.getEncoding().getAddressWidth()), sdnaIndex, count);
         blend.add(block);
         return new CArrayFacade(block.header.getAddress(), new Class[]{facetClass}, new int[]{count}, block, blockTable);
      } catch (IllegalAccessException | SecurityException | IllegalArgumentException var8) {
         throw new IOException(var8);
      } catch (NoSuchFieldException var9) {
         throw new IOException("you cannot instantiate pointers or arrays this way. Use the appropriate factory methods for the respective types instead.", var9);
      }
   }

   public <T extends CFacade> CArrayFacade<T> newCStructBlock(Identifier blockCode, Class<T> facetClass, int count) throws IOException {
      return newCStructBlock(blockCode, facetClass, count, this.blend);
   }

   public static <T> CArrayFacade<T> newCArrayBlock(Identifier blockCode, Class<T> componentType, int arrayLength, BlenderFile blend) throws IOException {
      if (CFacade.__io__subclassof(componentType, CArrayFacade.class)) {
         throw new IOException("Multi-dimensional arrays have to be instantiated giving all component types of the embedded arrays and their lengths.");
      } else if (CFacade.__io__subclassof(componentType, CPointer.class)) {
         throw new IOException("Arrays of pointers have to be instantiated giving all types of the pointer, too.");
      } else {
         int[] dimensions = new int[]{arrayLength};
         Class<?>[] typeList = new Class[]{componentType};
         return newCArrayBlock(blockCode, typeList, dimensions, blend);
      }
   }

   public <T> CArrayFacade<T> newCArrayBlock(Identifier blockCode, Class<T> componentType, int arrayLength) throws IOException {
      return newCArrayBlock(blockCode, componentType, arrayLength, this.blend);
   }

   public static <T> CArrayFacade<T> newCArrayBlock(Identifier blockCode, Class<?>[] typeList, int[] dimensions, BlenderFile blend) throws IOException {
      BlockTable blockTable = blend.getBlockTable();
      int sdnaIndex = 0;
      Class<?> elementaryType = typeList[dimensions.length - 1];
      long size = CArrayFacade.__io__sizeof(elementaryType, dimensions, blend.getEncoding());
      Block block = blockTable.allocate(blockCode, size);
      block.header.setCount(dimensions[0]);
      block.header.setSdnaIndex(sdnaIndex);
      blend.add(block);
      return new CArrayFacade(block.header.getAddress(), typeList, dimensions, block, blockTable);
   }

   public <T> CArrayFacade<T> newCArrayBlock(Identifier blockCode, Class<?>[] typeList, int[] dimensions) throws IOException {
      return newCArrayBlock(blockCode, typeList, dimensions, this.blend);
   }

   public static <T> CPointer<CPointer<T>> newCPointerBlock(Identifier blockCode, Class<?>[] typeList, BlenderFile blend) throws IOException {
      BlockTable blockTable = blend.getBlockTable();
      int sdnaIndex = 0;
      int count = 1;
      int size = blend.getEncoding().getAddressWidth();
      Block block = blockTable.allocate(blockCode, size);
      block.header.setCount(count);
      block.header.setSdnaIndex(sdnaIndex);
      blend.add(block);
      Class<?>[] typeListExtended = new Class[typeList.length + 1];
      System.arraycopy(typeList, 0, typeListExtended, 1, typeList.length);
      typeListExtended[0] = CPointer.class;
      return new CPointer(block.header.getAddress(), typeList, block, blockTable);
   }

   public <T> CPointer<CPointer<T>> newCPointerBlock(Identifier blockCode, Class<?>[] typeList) throws IOException {
      return newCPointerBlock(blockCode, typeList, this.blend);
   }

   public static <T> CArrayFacade<CPointer<T>> newCPointerBlock(Identifier blockCode, Class<?>[] typeList, int count, BlenderFile blend) throws IOException {
      BlockTable blockTable = blend.getBlockTable();
      int sdnaIndex = 0;
      int size = blend.getEncoding().getAddressWidth();
      Block block = blockTable.allocate(blockCode, size);
      block.header.setCount(count);
      block.header.setSdnaIndex(sdnaIndex);
      blend.add(block);
      Class<?>[] typeListExtended = new Class[typeList.length + 1];
      System.arraycopy(typeList, 0, typeListExtended, 1, typeList.length);
      typeListExtended[0] = CPointer.class;
      return new CArrayFacade(block.header.getAddress(), typeList, new int[]{count}, block, blockTable);
   }

   public <T> CArrayFacade<CPointer<T>> newCPointerBlock(Identifier blockCode, Class<?>[] typeList, int count) throws IOException {
      return newCPointerBlock(blockCode, typeList, count, this.blend);
   }

   protected static StructDNA createStructDNA(String resourcePathTo_sdna_blend) throws IOException {
      InputStream in = BlenderFactoryBase.class.getClassLoader().getResourceAsStream(resourcePathTo_sdna_blend);
      BlenderFactoryBase.StructDNAImage sdnaImage = new BlenderFactoryBase.StructDNAImage(new BigEndianInputStreamWrapper(in, 8));
      StructDNA sdna = sdnaImage.getStructDNA();
      sdnaImage.close();
      return sdna;
   }

   protected static class StructDNAImage extends BlenderFile {
      protected StructDNAImage(BigEndianInputStreamWrapper in) throws IOException {
         this.io = in;
         this.header = new FileHeader();

         try {
            this.header.read(in);
            this.firstBlockOffset = in.offset();
            this.readStructDNA();
            in.close();
         } catch (IOException var10) {
            throw new IOException("Error reading sdna image file", var10);
         } finally {
            try {
               in.close();
            } catch (Throwable var9) {
            }

         }

      }
   }

   protected static class BlenderFileImplBase extends BlenderFile {
      protected BlenderFileImplBase(File file, StructDNA sdna, int blenderVersion) throws IOException {
         super(file, sdna, blenderVersion, (String[])null);
      }
   }
}
