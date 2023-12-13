package com.replaymod.render.shader;

import com.replaymod.core.versions.MCVer;
import java.io.InputStream;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.ARBShaderObjects;

public class Program {
   private final int program;

   public Program(ResourceLocation vertexShader, ResourceLocation fragmentShader) throws Exception {
      int vertShader = this.createShader(vertexShader, 35633);
      int fragShader = this.createShader(fragmentShader, 35632);
      this.program = ARBShaderObjects.glCreateProgramObjectARB();
      if (this.program == 0) {
         throw new Exception("glCreateProgramObjectARB failed");
      } else {
         ARBShaderObjects.glAttachObjectARB(this.program, vertShader);
         ARBShaderObjects.glAttachObjectARB(this.program, fragShader);
         ARBShaderObjects.glLinkProgramARB(this.program);
         if (ARBShaderObjects.glGetObjectParameteriARB(this.program, 35714) == 0) {
            throw new Exception("Error linking: " + getLogInfo(this.program));
         } else {
            ARBShaderObjects.glValidateProgramARB(this.program);
            if (ARBShaderObjects.glGetObjectParameteriARB(this.program, 35715) == 0) {
               throw new Exception("Error validating: " + getLogInfo(this.program));
            }
         }
      }
   }

   private int createShader(ResourceLocation resourceLocation, int shaderType) throws Exception {
      byte shader = 0;

      try {
         int shader = ARBShaderObjects.glCreateShaderObjectARB(shaderType);
         if (shader == 0) {
            throw new Exception("glCreateShaderObjectARB failed");
         } else {
            Resource resource = MCVer.getMinecraft().getResourceManager().getResourceOrThrow(resourceLocation);
            InputStream is = resource.open();

            try {
               ARBShaderObjects.glShaderSourceARB(shader, IOUtils.toString(is));
            } catch (Throwable var9) {
               if (is != null) {
                  try {
                     is.close();
                  } catch (Throwable var8) {
                     var9.addSuppressed(var8);
                  }
               }

               throw var9;
            }

            if (is != null) {
               is.close();
            }

            ARBShaderObjects.glCompileShaderARB(shader);
            if (ARBShaderObjects.glGetObjectParameteriARB(shader, 35713) == 0) {
               throw new RuntimeException("Error creating shader: " + getLogInfo(shader));
            } else {
               return shader;
            }
         }
      } catch (Exception var10) {
         ARBShaderObjects.glDeleteObjectARB(shader);
         throw var10;
      }
   }

   private static String getLogInfo(int obj) {
      return ARBShaderObjects.glGetInfoLogARB(obj, ARBShaderObjects.glGetObjectParameteriARB(obj, 35716));
   }

   public void use() {
      ARBShaderObjects.glUseProgramObjectARB(this.program);
   }

   public void stopUsing() {
      ARBShaderObjects.glUseProgramObjectARB(0);
   }

   public void delete() {
      ARBShaderObjects.glDeleteObjectARB(this.program);
   }

   public Program.Uniform getUniformVariable(String name) {
      return new Program.Uniform(ARBShaderObjects.glGetUniformLocationARB(this.program, name));
   }

   public class Uniform {
      private final int location;

      public Uniform(int location) {
         this.location = location;
      }

      public void set(boolean bool) {
         ARBShaderObjects.glUniform1iARB(this.location, bool ? 1 : 0);
      }

      public void set(int integer) {
         ARBShaderObjects.glUniform1iARB(this.location, integer);
      }
   }
}
