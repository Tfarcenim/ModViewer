package com.replaymod.replaystudio.lib.viaversion.api.type;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.BlockChangeRecord;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.EulerAngle;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.GlobalPosition;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.PlayerMessageSignature;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.ProfileKey;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Quaternion;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Vector;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Vector3f;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.VillagerData;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.ArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.BooleanType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.ByteArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.ByteType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.ComponentType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.DoubleType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.FloatType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.IntType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.LongArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.LongType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.RemainingBytesType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.ShortByteArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.ShortType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.StringType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.UUIDIntArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.UUIDType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.UnsignedByteType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.UnsignedShortType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.VarIntArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.VarIntType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.VarLongType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.VoidType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.BlockChangeRecordType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.EulerAngleType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.FlatItemArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.FlatItemType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.FlatVarIntItemArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.FlatVarIntItemType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.GlobalPositionType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ItemArrayType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ItemType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.NBTType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.OptionalVarIntType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.PlayerMessageSignatureType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.Position1_14Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.PositionType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ProfileKeyType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.QuaternionType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.VarLongBlockChangeRecordType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.Vector3fType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.VectorType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.VillagerDataType;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import java.util.UUID;

public abstract class Type<T> implements ByteBufReader<T>, ByteBufWriter<T> {
   public static final ByteType BYTE = new ByteType();
   public static final UnsignedByteType UNSIGNED_BYTE = new UnsignedByteType();
   public static final Type<byte[]> BYTE_ARRAY_PRIMITIVE = new ByteArrayType();
   public static final Type<byte[]> OPTIONAL_BYTE_ARRAY_PRIMITIVE = new ByteArrayType.OptionalByteArrayType();
   public static final Type<byte[]> SHORT_BYTE_ARRAY = new ShortByteArrayType();
   public static final Type<byte[]> REMAINING_BYTES = new RemainingBytesType();
   public static final ShortType SHORT = new ShortType();
   public static final UnsignedShortType UNSIGNED_SHORT = new UnsignedShortType();
   public static final IntType INT = new IntType();
   public static final FloatType FLOAT = new FloatType();
   public static final FloatType.OptionalFloatType OPTIONAL_FLOAT = new FloatType.OptionalFloatType();
   public static final DoubleType DOUBLE = new DoubleType();
   public static final LongType LONG = new LongType();
   public static final Type<long[]> LONG_ARRAY_PRIMITIVE = new LongArrayType();
   public static final BooleanType BOOLEAN = new BooleanType();
   public static final Type<JsonElement> COMPONENT = new ComponentType();
   public static final Type<JsonElement> OPTIONAL_COMPONENT = new ComponentType.OptionalComponentType();
   public static final Type<String> STRING = new StringType();
   public static final Type<String> OPTIONAL_STRING = new StringType.OptionalStringType();
   public static final Type<String[]> STRING_ARRAY;
   public static final Type<UUID> UUID;
   public static final Type<UUID> OPTIONAL_UUID;
   public static final Type<UUID[]> UUID_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<UUID> UUID_INT_ARRAY;
   public static final VarIntType VAR_INT;
   public static final OptionalVarIntType OPTIONAL_VAR_INT;
   public static final Type<int[]> VAR_INT_ARRAY_PRIMITIVE;
   public static final VarLongType VAR_LONG;
   /** @deprecated */
   @Deprecated
   public static final Type<Byte[]> BYTE_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Short[]> UNSIGNED_BYTE_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Boolean[]> BOOLEAN_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Integer[]> INT_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Short[]> SHORT_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Integer[]> UNSIGNED_SHORT_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Double[]> DOUBLE_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Long[]> LONG_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Float[]> FLOAT_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Integer[]> VAR_INT_ARRAY;
   /** @deprecated */
   @Deprecated
   public static final Type<Long[]> VAR_LONG_ARRAY;
   public static final VoidType NOTHING;
   public static final Type<Position> POSITION;
   public static final Type<Position> OPTIONAL_POSITION;
   public static final Type<Position> POSITION1_14;
   public static final Type<Position> OPTIONAL_POSITION_1_14;
   public static final Type<EulerAngle> ROTATION;
   public static final Type<Vector> VECTOR;
   public static final Type<Vector3f> VECTOR3F;
   public static final Type<Quaternion> QUATERNION;
   public static final Type<CompoundTag> NBT;
   public static final Type<CompoundTag[]> NBT_ARRAY;
   public static final Type<GlobalPosition> GLOBAL_POSITION;
   public static final Type<GlobalPosition> OPTIONAL_GLOBAL_POSITION;
   public static final Type<BlockChangeRecord> BLOCK_CHANGE_RECORD;
   public static final Type<BlockChangeRecord[]> BLOCK_CHANGE_RECORD_ARRAY;
   public static final Type<BlockChangeRecord> VAR_LONG_BLOCK_CHANGE_RECORD;
   public static final Type<BlockChangeRecord[]> VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY;
   public static final Type<VillagerData> VILLAGER_DATA;
   public static final Type<Item> ITEM;
   public static final Type<Item[]> ITEM_ARRAY;
   public static final Type<ProfileKey> PROFILE_KEY;
   public static final Type<ProfileKey> OPTIONAL_PROFILE_KEY;
   public static final Type<PlayerMessageSignature> PLAYER_MESSAGE_SIGNATURE;
   public static final Type<PlayerMessageSignature> OPTIONAL_PLAYER_MESSAGE_SIGNATURE;
   public static final Type<PlayerMessageSignature[]> PLAYER_MESSAGE_SIGNATURE_ARRAY;
   public static final Type<Item> FLAT_ITEM;
   public static final Type<Item> FLAT_VAR_INT_ITEM;
   public static final Type<Item[]> FLAT_ITEM_ARRAY;
   public static final Type<Item[]> FLAT_VAR_INT_ITEM_ARRAY;
   public static final Type<Item[]> FLAT_ITEM_ARRAY_VAR_INT;
   public static final Type<Item[]> FLAT_VAR_INT_ITEM_ARRAY_VAR_INT;
   private final Class<? super T> outputClass;
   private final String typeName;

   protected Type(Class<? super T> outputClass) {
      this(outputClass.getSimpleName(), outputClass);
   }

   protected Type(String typeName, Class<? super T> outputClass) {
      this.outputClass = outputClass;
      this.typeName = typeName;
   }

   public Class<? super T> getOutputClass() {
      return this.outputClass;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Class<? extends Type> getBaseClass() {
      return this.getClass();
   }

   public String toString() {
      return this.typeName;
   }

   static {
      STRING_ARRAY = new ArrayType(STRING);
      UUID = new UUIDType();
      OPTIONAL_UUID = new UUIDType.OptionalUUIDType();
      UUID_ARRAY = new ArrayType(UUID);
      UUID_INT_ARRAY = new UUIDIntArrayType();
      VAR_INT = new VarIntType();
      OPTIONAL_VAR_INT = new OptionalVarIntType();
      VAR_INT_ARRAY_PRIMITIVE = new VarIntArrayType();
      VAR_LONG = new VarLongType();
      BYTE_ARRAY = new ArrayType(BYTE);
      UNSIGNED_BYTE_ARRAY = new ArrayType(UNSIGNED_BYTE);
      BOOLEAN_ARRAY = new ArrayType(BOOLEAN);
      INT_ARRAY = new ArrayType(INT);
      SHORT_ARRAY = new ArrayType(SHORT);
      UNSIGNED_SHORT_ARRAY = new ArrayType(UNSIGNED_SHORT);
      DOUBLE_ARRAY = new ArrayType(DOUBLE);
      LONG_ARRAY = new ArrayType(LONG);
      FLOAT_ARRAY = new ArrayType(FLOAT);
      VAR_INT_ARRAY = new ArrayType(VAR_INT);
      VAR_LONG_ARRAY = new ArrayType(VAR_LONG);
      NOTHING = new VoidType();
      POSITION = new PositionType();
      OPTIONAL_POSITION = new PositionType.OptionalPositionType();
      POSITION1_14 = new Position1_14Type();
      OPTIONAL_POSITION_1_14 = new Position1_14Type.OptionalPosition1_14Type();
      ROTATION = new EulerAngleType();
      VECTOR = new VectorType();
      VECTOR3F = new Vector3fType();
      QUATERNION = new QuaternionType();
      NBT = new NBTType();
      NBT_ARRAY = new ArrayType(NBT);
      GLOBAL_POSITION = new GlobalPositionType();
      OPTIONAL_GLOBAL_POSITION = new GlobalPositionType.OptionalGlobalPositionType();
      BLOCK_CHANGE_RECORD = new BlockChangeRecordType();
      BLOCK_CHANGE_RECORD_ARRAY = new ArrayType(BLOCK_CHANGE_RECORD);
      VAR_LONG_BLOCK_CHANGE_RECORD = new VarLongBlockChangeRecordType();
      VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY = new ArrayType(VAR_LONG_BLOCK_CHANGE_RECORD);
      VILLAGER_DATA = new VillagerDataType();
      ITEM = new ItemType();
      ITEM_ARRAY = new ItemArrayType();
      PROFILE_KEY = new ProfileKeyType();
      OPTIONAL_PROFILE_KEY = new ProfileKeyType.OptionalProfileKeyType();
      PLAYER_MESSAGE_SIGNATURE = new PlayerMessageSignatureType();
      OPTIONAL_PLAYER_MESSAGE_SIGNATURE = new PlayerMessageSignatureType.OptionalPlayerMessageSignatureType();
      PLAYER_MESSAGE_SIGNATURE_ARRAY = new ArrayType(PLAYER_MESSAGE_SIGNATURE);
      FLAT_ITEM = new FlatItemType();
      FLAT_VAR_INT_ITEM = new FlatVarIntItemType();
      FLAT_ITEM_ARRAY = new FlatItemArrayType();
      FLAT_VAR_INT_ITEM_ARRAY = new FlatVarIntItemArrayType();
      FLAT_ITEM_ARRAY_VAR_INT = new ArrayType(FLAT_ITEM);
      FLAT_VAR_INT_ITEM_ARRAY_VAR_INT = new ArrayType(FLAT_VAR_INT_ITEM);
   }
}
