package com.replaymod.lib.com.github.steveice10.opennbt.tag;

import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.ByteArrayTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.ByteTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.CompoundTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.DoubleTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.FloatTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.IntArrayTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.IntTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.ListTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.LongArrayTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.LongTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.ShortTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.StringTag;
import com.replaymod.lib.com.github.steveice10.opennbt.tag.builtin.Tag;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public class TagRegistry {
   private static final Int2ObjectMap<Class<? extends Tag>> idToTag = new Int2ObjectOpenHashMap();
   private static final Object2IntMap<Class<? extends Tag>> tagToId = new Object2IntOpenHashMap();
   private static final Int2ObjectMap<Supplier<? extends Tag>> instanceSuppliers = new Int2ObjectOpenHashMap();

   public static void register(int id, Class<? extends Tag> tag, Supplier<? extends Tag> supplier) throws TagRegisterException {
      if (idToTag.containsKey(id)) {
         throw new TagRegisterException("Tag ID \"" + id + "\" is already in use.");
      } else if (tagToId.containsKey(tag)) {
         throw new TagRegisterException("Tag \"" + tag.getSimpleName() + "\" is already registered.");
      } else {
         instanceSuppliers.put(id, supplier);
         idToTag.put(id, tag);
         tagToId.put(tag, id);
      }
   }

   public static void unregister(int id) {
      tagToId.removeInt(getClassFor(id));
      idToTag.remove(id);
   }

   @Nullable
   public static Class<? extends Tag> getClassFor(int id) {
      return (Class)idToTag.get(id);
   }

   public static int getIdFor(Class<? extends Tag> clazz) {
      return tagToId.getInt(clazz);
   }

   public static Tag createInstance(int id) throws TagCreateException {
      Supplier<? extends Tag> supplier = (Supplier)instanceSuppliers.get(id);
      if (supplier == null) {
         throw new TagCreateException("Could not find tag with ID \"" + id + "\".");
      } else {
         return (Tag)supplier.get();
      }
   }

   static {
      tagToId.defaultReturnValue(-1);
      register(1, ByteTag.class, ByteTag::new);
      register(2, ShortTag.class, ShortTag::new);
      register(3, IntTag.class, IntTag::new);
      register(4, LongTag.class, LongTag::new);
      register(5, FloatTag.class, FloatTag::new);
      register(6, DoubleTag.class, DoubleTag::new);
      register(7, ByteArrayTag.class, ByteArrayTag::new);
      register(8, StringTag.class, StringTag::new);
      register(9, ListTag.class, ListTag::new);
      register(10, CompoundTag.class, CompoundTag::new);
      register(11, IntArrayTag.class, IntArrayTag::new);
      register(12, LongArrayTag.class, LongArrayTag::new);
   }
}
