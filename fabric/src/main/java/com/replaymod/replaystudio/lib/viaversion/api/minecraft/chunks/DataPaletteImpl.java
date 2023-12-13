package com.replaymod.replaystudio.lib.viaversion.api.minecraft.chunks;

import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2IntMap;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntArrayList;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntList;

public final class DataPaletteImpl implements DataPalette {
   private final IntList palette;
   private final Int2IntMap inversePalette;
   private final int[] values;
   private final int sizeBits;

   public DataPaletteImpl(int valuesLength) {
      this(valuesLength, 8);
   }

   public DataPaletteImpl(int valuesLength, int expectedPaletteLength) {
      this.values = new int[valuesLength];
      this.sizeBits = Integer.numberOfTrailingZeros(valuesLength) / 3;
      this.palette = new IntArrayList(expectedPaletteLength);
      this.inversePalette = new Int2IntOpenHashMap(expectedPaletteLength);
      this.inversePalette.defaultReturnValue(-1);
   }

   public int index(int x, int y, int z) {
      return (y << this.sizeBits | z) << this.sizeBits | x;
   }

   public int idAt(int sectionCoordinate) {
      int index = this.values[sectionCoordinate];
      return this.palette.getInt(index);
   }

   public void setIdAt(int sectionCoordinate, int id) {
      int index = this.inversePalette.get(id);
      if (index == -1) {
         index = this.palette.size();
         this.palette.add(id);
         this.inversePalette.put(id, index);
      }

      this.values[sectionCoordinate] = index;
   }

   public int paletteIndexAt(int packedCoordinate) {
      return this.values[packedCoordinate];
   }

   public void setPaletteIndexAt(int sectionCoordinate, int index) {
      this.values[sectionCoordinate] = index;
   }

   public int size() {
      return this.palette.size();
   }

   public int idByIndex(int index) {
      return this.palette.getInt(index);
   }

   public void setIdByIndex(int index, int id) {
      int oldId = this.palette.set(index, id);
      if (oldId != id) {
         this.inversePalette.put(id, index);
         if (this.inversePalette.get(oldId) == index) {
            this.inversePalette.remove(oldId);

            for(int i = 0; i < this.palette.size(); ++i) {
               if (this.palette.getInt(i) == oldId) {
                  this.inversePalette.put(oldId, i);
                  break;
               }
            }
         }

      }
   }

   public void replaceId(int oldId, int newId) {
      int index = this.inversePalette.remove(oldId);
      if (index != -1) {
         this.inversePalette.put(newId, index);

         for(int i = 0; i < this.palette.size(); ++i) {
            if (this.palette.getInt(i) == oldId) {
               this.palette.set(i, newId);
            }
         }

      }
   }

   public void addId(int id) {
      this.inversePalette.put(id, this.palette.size());
      this.palette.add(id);
   }

   public void clear() {
      this.palette.clear();
      this.inversePalette.clear();
   }
}
