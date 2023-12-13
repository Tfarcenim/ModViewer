package com.replaymod.replaystudio.lib.guava.collect;

import com.replaymod.replaystudio.lib.guava.annotations.Beta;
import com.replaymod.replaystudio.lib.guava.annotations.GwtCompatible;
import com.replaymod.replaystudio.lib.guava.annotations.GwtIncompatible;
import com.replaymod.replaystudio.lib.guava.base.Equivalence;
import com.replaymod.replaystudio.lib.guava.base.Function;
import com.replaymod.replaystudio.lib.guava.base.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/** @deprecated */
@Deprecated
@Beta
@GwtCompatible(
   emulated = true
)
abstract class GenericMapMaker<K0, V0> {
   @GwtIncompatible("To be supported")
   MapMaker.RemovalListener<K0, V0> removalListener;

   @GwtIncompatible("To be supported")
   abstract GenericMapMaker<K0, V0> keyEquivalence(Equivalence<Object> var1);

   public abstract GenericMapMaker<K0, V0> initialCapacity(int var1);

   abstract GenericMapMaker<K0, V0> maximumSize(int var1);

   public abstract GenericMapMaker<K0, V0> concurrencyLevel(int var1);

   @GwtIncompatible("java.lang.ref.WeakReference")
   public abstract GenericMapMaker<K0, V0> weakKeys();

   @GwtIncompatible("java.lang.ref.WeakReference")
   public abstract GenericMapMaker<K0, V0> weakValues();

   /** @deprecated */
   @Deprecated
   @GwtIncompatible("java.lang.ref.SoftReference")
   public abstract GenericMapMaker<K0, V0> softValues();

   abstract GenericMapMaker<K0, V0> expireAfterWrite(long var1, TimeUnit var3);

   @GwtIncompatible("To be supported")
   abstract GenericMapMaker<K0, V0> expireAfterAccess(long var1, TimeUnit var3);

   @GwtIncompatible("To be supported")
   <K extends K0, V extends V0> MapMaker.RemovalListener<K, V> getRemovalListener() {
      return (MapMaker.RemovalListener)Objects.firstNonNull(this.removalListener, GenericMapMaker.NullListener.INSTANCE);
   }

   public abstract <K extends K0, V extends V0> ConcurrentMap<K, V> makeMap();

   @GwtIncompatible("MapMakerInternalMap")
   abstract <K, V> MapMakerInternalMap<K, V> makeCustomMap();

   /** @deprecated */
   @Deprecated
   abstract <K extends K0, V extends V0> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> var1);

   @GwtIncompatible("To be supported")
   static enum NullListener implements MapMaker.RemovalListener<Object, Object> {
      INSTANCE;

      public void onRemoval(MapMaker.RemovalNotification<Object, Object> notification) {
      }
   }
}
