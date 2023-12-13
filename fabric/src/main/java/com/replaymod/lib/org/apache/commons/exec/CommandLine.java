package com.replaymod.lib.org.apache.commons.exec;

import com.replaymod.lib.org.apache.commons.exec.util.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

public class CommandLine {
   private final Vector<CommandLine.Argument> arguments = new Vector();
   private final String executable;
   private Map<String, ?> substitutionMap;
   private final boolean isFile;

   public static CommandLine parse(String line) {
      return parse(line, (Map)null);
   }

   public static CommandLine parse(String line, Map<String, ?> substitutionMap) {
      if (line == null) {
         throw new IllegalArgumentException("Command line can not be null");
      } else if (line.trim().length() == 0) {
         throw new IllegalArgumentException("Command line can not be empty");
      } else {
         String[] tmp = translateCommandline(line);
         CommandLine cl = new CommandLine(tmp[0]);
         cl.setSubstitutionMap(substitutionMap);

         for(int i = 1; i < tmp.length; ++i) {
            cl.addArgument(tmp[i]);
         }

         return cl;
      }
   }

   public CommandLine(String executable) {
      this.isFile = false;
      this.executable = this.toCleanExecutable(executable);
   }

   public CommandLine(File executable) {
      this.isFile = true;
      this.executable = this.toCleanExecutable(executable.getAbsolutePath());
   }

   public CommandLine(CommandLine other) {
      this.executable = other.getExecutable();
      this.isFile = other.isFile();
      this.arguments.addAll(other.arguments);
      if (other.getSubstitutionMap() != null) {
         Map<String, Object> omap = new HashMap();
         this.substitutionMap = omap;
         Iterator iterator = other.substitutionMap.keySet().iterator();

         while(iterator.hasNext()) {
            String key = (String)iterator.next();
            omap.put(key, other.getSubstitutionMap().get(key));
         }
      }

   }

   public String getExecutable() {
      return StringUtils.fixFileSeparatorChar(this.expandArgument(this.executable));
   }

   public boolean isFile() {
      return this.isFile;
   }

   public CommandLine addArguments(String[] addArguments) {
      return this.addArguments(addArguments, true);
   }

   public CommandLine addArguments(String[] addArguments, boolean handleQuoting) {
      if (addArguments != null) {
         String[] arr$ = addArguments;
         int len$ = addArguments.length;

         for(int i$ = 0; i$ < len$; ++i$) {
            String addArgument = arr$[i$];
            this.addArgument(addArgument, handleQuoting);
         }
      }

      return this;
   }

   public CommandLine addArguments(String addArguments) {
      return this.addArguments(addArguments, true);
   }

   public CommandLine addArguments(String addArguments, boolean handleQuoting) {
      if (addArguments != null) {
         String[] argumentsArray = translateCommandline(addArguments);
         this.addArguments(argumentsArray, handleQuoting);
      }

      return this;
   }

   public CommandLine addArgument(String argument) {
      return this.addArgument(argument, true);
   }

   public CommandLine addArgument(String argument, boolean handleQuoting) {
      if (argument == null) {
         return this;
      } else {
         if (handleQuoting) {
            StringUtils.quoteArgument(argument);
         }

         this.arguments.add(new CommandLine.Argument(argument, handleQuoting));
         return this;
      }
   }

   public String[] getArguments() {
      String[] result = new String[this.arguments.size()];

      for(int i = 0; i < result.length; ++i) {
         CommandLine.Argument currArgument = (CommandLine.Argument)this.arguments.get(i);
         String expandedArgument = this.expandArgument(currArgument.getValue());
         result[i] = currArgument.isHandleQuoting() ? StringUtils.quoteArgument(expandedArgument) : expandedArgument;
      }

      return result;
   }

   public Map<String, ?> getSubstitutionMap() {
      return this.substitutionMap;
   }

   public void setSubstitutionMap(Map<String, ?> substitutionMap) {
      this.substitutionMap = substitutionMap;
   }

   public String[] toStrings() {
      String[] result = new String[this.arguments.size() + 1];
      result[0] = this.getExecutable();
      System.arraycopy(this.getArguments(), 0, result, 1, result.length - 1);
      return result;
   }

   public String toString() {
      return "[" + StringUtils.toString(this.toStrings(), ", ") + "]";
   }

   private String expandArgument(String argument) {
      StringBuffer stringBuffer = StringUtils.stringSubstitution(argument, this.getSubstitutionMap(), true);
      return stringBuffer.toString();
   }

   private static String[] translateCommandline(String toProcess) {
      if (toProcess != null && toProcess.length() != 0) {
         int normal = false;
         int inQuote = true;
         int inDoubleQuote = true;
         int state = 0;
         StringTokenizer tok = new StringTokenizer(toProcess, "\"' ", true);
         ArrayList<String> list = new ArrayList();
         StringBuilder current = new StringBuilder();
         boolean lastTokenHasBeenQuoted = false;

         while(true) {
            while(tok.hasMoreTokens()) {
               String nextTok = tok.nextToken();
               switch(state) {
               case 1:
                  if ("'".equals(nextTok)) {
                     lastTokenHasBeenQuoted = true;
                     state = 0;
                  } else {
                     current.append(nextTok);
                  }
                  continue;
               case 2:
                  if ("\"".equals(nextTok)) {
                     lastTokenHasBeenQuoted = true;
                     state = 0;
                  } else {
                     current.append(nextTok);
                  }
                  continue;
               }

               if ("'".equals(nextTok)) {
                  state = 1;
               } else if ("\"".equals(nextTok)) {
                  state = 2;
               } else if (" ".equals(nextTok)) {
                  if (lastTokenHasBeenQuoted || current.length() != 0) {
                     list.add(current.toString());
                     current = new StringBuilder();
                  }
               } else {
                  current.append(nextTok);
               }

               lastTokenHasBeenQuoted = false;
            }

            if (lastTokenHasBeenQuoted || current.length() != 0) {
               list.add(current.toString());
            }

            if (state != 1 && state != 2) {
               String[] args = new String[list.size()];
               return (String[])list.toArray(args);
            }

            throw new IllegalArgumentException("Unbalanced quotes in " + toProcess);
         }
      } else {
         return new String[0];
      }
   }

   private String toCleanExecutable(String dirtyExecutable) {
      if (dirtyExecutable == null) {
         throw new IllegalArgumentException("Executable can not be null");
      } else if (dirtyExecutable.trim().length() == 0) {
         throw new IllegalArgumentException("Executable can not be empty");
      } else {
         return StringUtils.fixFileSeparatorChar(dirtyExecutable);
      }
   }

   class Argument {
      private final String value;
      private final boolean handleQuoting;

      private Argument(String value, boolean handleQuoting) {
         this.value = value.trim();
         this.handleQuoting = handleQuoting;
      }

      private String getValue() {
         return this.value;
      }

      private boolean isHandleQuoting() {
         return this.handleQuoting;
      }

      // $FF: synthetic method
      Argument(String x1, boolean x2, Object x3) {
         this(x1, x2);
      }
   }
}
