package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
   private final transient ImmutableMapEntry<K, V>[] entries;
   private final transient ImmutableMapEntry<K, V>[] table;
   private final transient int mask;
   private static final double MAX_LOAD_FACTOR = 1.2D;
   private static final long serialVersionUID = 0L;

   RegularImmutableMap(ImmutableMapEntry.TerminalEntry<?, ?>... theEntries) {
      this(theEntries.length, theEntries);
   }

   RegularImmutableMap(int size, ImmutableMapEntry.TerminalEntry<?, ?>[] theEntries) {
      this.entries = this.createEntryArray(size);
      int tableSize = Hashing.closedTableSize(size, 1.2D);
      this.table = this.createEntryArray(tableSize);
      this.mask = tableSize - 1;

      for(int entryIndex = 0; entryIndex < size; ++entryIndex) {
         ImmutableMapEntry.TerminalEntry<K, V> entry = theEntries[entryIndex];
         K key = entry.getKey();
         int tableIndex = Hashing.smear(key.hashCode()) & this.mask;
         ImmutableMapEntry<K, V> existing = this.table[tableIndex];
         ImmutableMapEntry<K, V> newEntry = existing == null ? entry : new RegularImmutableMap.NonTerminalMapEntry(entry, existing);
         this.table[tableIndex] = (ImmutableMapEntry)newEntry;
         this.entries[entryIndex] = (ImmutableMapEntry)newEntry;
         this.checkNoConflictInBucket(key, (ImmutableMapEntry)newEntry, existing);
      }

   }

   RegularImmutableMap(Entry<?, ?>[] theEntries) {
      int size = theEntries.length;
      this.entries = this.createEntryArray(size);
      int tableSize = Hashing.closedTableSize(size, 1.2D);
      this.table = this.createEntryArray(tableSize);
      this.mask = tableSize - 1;

      for(int entryIndex = 0; entryIndex < size; ++entryIndex) {
         Entry<K, V> entry = theEntries[entryIndex];
         K key = entry.getKey();
         V value = entry.getValue();
         CollectPreconditions.checkEntryNotNull(key, value);
         int tableIndex = Hashing.smear(key.hashCode()) & this.mask;
         ImmutableMapEntry<K, V> existing = this.table[tableIndex];
         ImmutableMapEntry<K, V> newEntry = existing == null ? new ImmutableMapEntry.TerminalEntry(key, value) : new RegularImmutableMap.NonTerminalMapEntry(key, value, existing);
         this.table[tableIndex] = (ImmutableMapEntry)newEntry;
         this.entries[entryIndex] = (ImmutableMapEntry)newEntry;
         this.checkNoConflictInBucket(key, (ImmutableMapEntry)newEntry, existing);
      }

   }

   private void checkNoConflictInBucket(K key, ImmutableMapEntry<K, V> entry, ImmutableMapEntry<K, V> bucketHead) {
      while(bucketHead != null) {
         checkNoConflict(!key.equals(bucketHead.getKey()), "key", entry, bucketHead);
         bucketHead = bucketHead.getNextInKeyBucket();
      }

   }

   private ImmutableMapEntry<K, V>[] createEntryArray(int size) {
      return new ImmutableMapEntry[size];
   }

   public V get(@Nullable Object key) {
      if (key == null) {
         return null;
      } else {
         int index = Hashing.smear(key.hashCode()) & this.mask;

         for(ImmutableMapEntry entry = this.table[index]; entry != null; entry = entry.getNextInKeyBucket()) {
            K candidateKey = entry.getKey();
            if (key.equals(candidateKey)) {
               return entry.getValue();
            }
         }

         return null;
      }
   }

   public int size() {
      return this.entries.length;
   }

   boolean isPartialView() {
      return false;
   }

   ImmutableSet<Entry<K, V>> createEntrySet() {
      return new RegularImmutableMap.EntrySet();
   }

   private class EntrySet extends ImmutableMapEntrySet<K, V> {
      private EntrySet() {
      }

      ImmutableMap<K, V> map() {
         return RegularImmutableMap.this;
      }

      public UnmodifiableIterator<Entry<K, V>> iterator() {
         return this.asList().iterator();
      }

      ImmutableList<Entry<K, V>> createAsList() {
         return new RegularImmutableAsList(this, RegularImmutableMap.this.entries);
      }

      // $FF: synthetic method
      EntrySet(Object x1) {
         this();
      }
   }

   private static final class NonTerminalMapEntry<K, V> extends ImmutableMapEntry<K, V> {
      private final ImmutableMapEntry<K, V> nextInKeyBucket;

      NonTerminalMapEntry(K key, V value, ImmutableMapEntry<K, V> nextInKeyBucket) {
         super(key, value);
         this.nextInKeyBucket = nextInKeyBucket;
      }

      NonTerminalMapEntry(ImmutableMapEntry<K, V> contents, ImmutableMapEntry<K, V> nextInKeyBucket) {
         super(contents);
         this.nextInKeyBucket = nextInKeyBucket;
      }

      ImmutableMapEntry<K, V> getNextInKeyBucket() {
         return this.nextInKeyBucket;
      }

      @Nullable
      ImmutableMapEntry<K, V> getNextInValueBucket() {
         return null;
      }
   }
}
