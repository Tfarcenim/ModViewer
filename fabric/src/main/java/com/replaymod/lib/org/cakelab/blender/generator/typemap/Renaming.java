package com.replaymod.lib.org.cakelab.blender.generator.typemap;

public class Renaming {
   public static String mapStruct2Class(String name) {
      return name.equals("Object") ? "BlenderObject" : name;
   }
}
