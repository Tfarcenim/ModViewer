package com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag;

import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.objects.Object2IntMap;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ByteArrayTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ByteTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.DoubleTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.FloatTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntArrayTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ListTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.LongArrayTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.LongTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ShortTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.Tag;
import java.util.function.Supplier;
import org.jetbrains.annotations.Nullable;

public final class TagRegistry {
   private static final int HIGHEST_ID = 12;
   private static final Class<? extends Tag>[] idToTag = new Class[13];
   private static final Supplier<? extends Tag>[] instanceSuppliers = new Supplier[13];
   private static final Object2IntMap<Class<? extends Tag>> tagToId = new Object2IntOpenHashMap();

   public static void register(int id, Class<? extends Tag> tag, Supplier<? extends Tag> supplier) throws TagRegisterException {
      if (id >= 0 && id <= 12) {
         if (idToTag[id] != null) {
            throw new TagRegisterException("Tag ID \"" + id + "\" is already in use.");
         } else if (tagToId.containsKey(tag)) {
            throw new TagRegisterException("Tag \"" + tag.getSimpleName() + "\" is already registered.");
         } else {
            instanceSuppliers[id] = supplier;
            idToTag[id] = tag;
            tagToId.put(tag, id);
         }
      } else {
         throw new TagRegisterException("Tag ID must be between 0 and 12");
      }
   }

   public static void unregister(int id) {
      tagToId.removeInt(getClassFor(id));
      idToTag[id] = null;
      instanceSuppliers[id] = null;
   }

   @Nullable
   public static Class<? extends Tag> getClassFor(int id) {
      return id >= 0 && id < idToTag.length ? idToTag[id] : null;
   }

   public static int getIdFor(Class<? extends Tag> clazz) {
      return tagToId.getInt(clazz);
   }

   public static Tag createInstance(int id) throws TagCreateException {
      Supplier<? extends Tag> supplier = id > 0 && id < instanceSuppliers.length ? instanceSuppliers[id] : null;
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
