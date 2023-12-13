package com.replaymod.replaystudio.data;

import java.beans.ConstructorProperties;

public class ModInfo {
   private final String id;
   private final String name;
   private final String version;

   @ConstructorProperties({"id", "name", "version"})
   public ModInfo(String id, String name, String version) {
      this.id = id;
      this.name = name;
      this.version = version;
   }

   public String getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getVersion() {
      return this.version;
   }

   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ModInfo)) {
         return false;
      } else {
         ModInfo other = (ModInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            label47: {
               Object this$id = this.getId();
               Object other$id = other.getId();
               if (this$id == null) {
                  if (other$id == null) {
                     break label47;
                  }
               } else if (this$id.equals(other$id)) {
                  break label47;
               }

               return false;
            }

            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null) {
               if (other$name != null) {
                  return false;
               }
            } else if (!this$name.equals(other$name)) {
               return false;
            }

            Object this$version = this.getVersion();
            Object other$version = other.getVersion();
            if (this$version == null) {
               if (other$version != null) {
                  return false;
               }
            } else if (!this$version.equals(other$version)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof ModInfo;
   }

   public int hashCode() {
      int PRIME = true;
      int result = 1;
      Object $id = this.getId();
      int result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      return result;
   }

   public String toString() {
      return "ModInfo(id=" + this.getId() + ", name=" + this.getName() + ", version=" + this.getVersion() + ")";
   }
}
