package com.replaymod.lib.org.cakelab.blender.io.dna.internal;

import com.replaymod.lib.org.cakelab.blender.io.util.CDataReadWriteAccess;
import com.replaymod.lib.org.cakelab.blender.io.util.CStringUtils;
import com.replaymod.lib.org.cakelab.blender.io.util.Identifier;
import java.io.IOException;
import java.util.Arrays;

public class StructDNA {
   static final Identifier SDNA = new Identifier("SDNA");
   static final Identifier NAME = new Identifier("NAME");
   public int names_len;
   public String[] names;
   static final Identifier TYPE = new Identifier("TYPE");
   public int types_len;
   public String[] types;
   static final Identifier TLEN = new Identifier("TLEN");
   public short[] type_lengths;
   static final Identifier STRC = new Identifier("STRC");
   public int structs_len;
   public StructDNA.Struct[] structs;

   public void read(CDataReadWriteAccess io) throws IOException {
      Identifier ident = new Identifier();
      ident.consume(io, SDNA);
      ident.consume(io, NAME);
      this.names_len = io.readInt();
      this.names = new String[this.names_len];

      int i;
      for(i = 0; i < this.names_len; ++i) {
         this.names[i] = CStringUtils.readNullTerminatedString(io, true);
      }

      io.padding(4);
      ident.consume(io, TYPE);
      this.types_len = io.readInt();
      this.types = new String[this.types_len];

      for(i = 0; i < this.types_len; ++i) {
         this.types[i] = CStringUtils.readNullTerminatedString(io, true);
      }

      io.padding(4);
      ident.consume(io, TLEN);
      this.type_lengths = new short[this.types_len];

      for(i = 0; i < this.types_len; ++i) {
         this.type_lengths[i] = io.readShort();
      }

      io.padding(4);
      ident.consume(io, STRC);
      this.structs_len = io.readInt();
      this.structs = new StructDNA.Struct[this.structs_len];

      for(i = 0; i < this.structs_len; ++i) {
         this.structs[i] = new StructDNA.Struct();
         this.structs[i].read(io);
      }

   }

   public void write(CDataReadWriteAccess io) throws IOException {
      SDNA.write(io);
      NAME.write(io);
      io.writeInt(this.names_len);

      int i;
      for(i = 0; i < this.names_len; ++i) {
         CStringUtils.writeNullTerminatedString(this.names[i], CStringUtils.ASCII, io, true);
      }

      io.padding(4, true);
      TYPE.write(io);
      io.writeInt(this.types_len);

      for(i = 0; i < this.types_len; ++i) {
         CStringUtils.writeNullTerminatedString(this.types[i], CStringUtils.ASCII, io, true);
      }

      io.padding(4, true);
      TLEN.write(io);

      for(i = 0; i < this.types_len; ++i) {
         io.writeShort(this.type_lengths[i]);
      }

      io.padding(4, true);
      STRC.write(io);
      io.writeInt(this.structs_len);

      for(i = 0; i < this.structs_len; ++i) {
         this.structs[i].write(io);
      }

   }

   public String toString() {
      return "StructDNA {\n\tnames_len=" + this.names_len + "\n\tnames=[" + Arrays.toString(this.names) + "\n\ttypes_len=" + this.types_len + "\n\ttypes=[\n" + Arrays.toString(this.types) + "\n\ttype_lengths=[\n" + Arrays.toString(this.type_lengths) + "\nstructs_len=" + this.structs_len + "\nstructs=[\n" + Arrays.toString(this.structs) + "\n]\n";
   }

   public class Struct {
      public short type;
      public short fields_len;
      public StructDNA.Struct.Field[] fields;

      public void read(CDataReadWriteAccess io) throws IOException {
         this.type = io.readShort();
         this.fields_len = io.readShort();
         this.fields = new StructDNA.Struct.Field[this.fields_len];

         for(int i = 0; i < this.fields_len; ++i) {
            this.fields[i] = new StructDNA.Struct.Field();
            this.fields[i].read(io);
         }

      }

      public void write(CDataReadWriteAccess io) throws IOException {
         io.writeShort(this.type);
         io.writeShort(this.fields_len);

         for(int i = 0; i < this.fields_len; ++i) {
            this.fields[i].write(io);
         }

      }

      public String toString() {
         return "Struct [type=" + this.type + ", fields_len=" + this.fields_len + ", fields=" + Arrays.toString(this.fields) + "]";
      }

      public class Field {
         public short type;
         public short name;

         public void read(CDataReadWriteAccess io) throws IOException {
            this.type = io.readShort();
            this.name = io.readShort();
         }

         public void write(CDataReadWriteAccess io) throws IOException {
            io.writeShort(this.type);
            io.writeShort(this.name);
         }

         public String toString() {
            return "Field [type=" + this.type + ", name=" + this.name + "]";
         }
      }
   }
}
