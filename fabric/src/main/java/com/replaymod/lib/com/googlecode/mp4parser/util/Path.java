package com.replaymod.lib.com.googlecode.mp4parser.util;

import com.replaymod.lib.com.coremedia.iso.boxes.Box;
import com.replaymod.lib.com.coremedia.iso.boxes.Container;
import com.replaymod.lib.com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Path {
   static Pattern component = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");

   private Path() {
   }

   public static String createPath(Box box) {
      return createPath(box, "");
   }

   private static String createPath(Box box, String path) {
      Container parent = box.getParent();
      int index = 0;
      List<Box> siblings = parent.getBoxes();
      Iterator var6 = siblings.iterator();

      while(var6.hasNext()) {
         Box sibling = (Box)var6.next();
         if (sibling.getType().equals(box.getType())) {
            if (sibling == box) {
               break;
            }

            ++index;
         }
      }

      path = String.format("/%s[%d]", box.getType(), index) + path;
      return parent instanceof Box ? createPath((Box)parent, path) : path;
   }

   public static <T extends Box> T getPath(Box box, String path) {
      List<T> all = getPaths(box, path, true);
      return all.isEmpty() ? null : (Box)all.get(0);
   }

   public static <T extends Box> T getPath(Container container, String path) {
      List<T> all = getPaths(container, path, true);
      return all.isEmpty() ? null : (Box)all.get(0);
   }

   public static <T extends Box> T getPath(AbstractContainerBox containerBox, String path) {
      List<T> all = getPaths(containerBox, path, true);
      return all.isEmpty() ? null : (Box)all.get(0);
   }

   public static <T extends Box> List<T> getPaths(Box box, String path) {
      return getPaths(box, path, false);
   }

   public static <T extends Box> List<T> getPaths(Container container, String path) {
      return getPaths(container, path, false);
   }

   private static <T extends Box> List<T> getPaths(AbstractContainerBox container, String path, boolean singleResult) {
      return getPaths((Object)container, path, singleResult);
   }

   private static <T extends Box> List<T> getPaths(Container container, String path, boolean singleResult) {
      return getPaths((Object)container, path, singleResult);
   }

   private static <T extends Box> List<T> getPaths(Box box, String path, boolean singleResult) {
      return getPaths((Object)box, path, singleResult);
   }

   private static <T extends Box> List<T> getPaths(Object thing, String path, boolean singleResult) {
      if (path.startsWith("/")) {
         for(path = path.substring(1); thing instanceof Box; thing = ((Box)thing).getParent()) {
         }
      }

      if (path.length() == 0) {
         if (thing instanceof Box) {
            return Collections.singletonList((Box)thing);
         } else {
            throw new RuntimeException("Result of path expression seems to be the root container. This is not allowed!");
         }
      } else {
         String later;
         String now;
         if (path.contains("/")) {
            later = path.substring(path.indexOf(47) + 1);
            now = path.substring(0, path.indexOf(47));
         } else {
            now = path;
            later = "";
         }

         Matcher m = component.matcher(now);
         if (!m.matches()) {
            throw new RuntimeException(now + " is invalid path.");
         } else {
            String type = m.group(1);
            if ("..".equals(type)) {
               return thing instanceof Box ? getPaths(((Box)thing).getParent(), later, singleResult) : Collections.emptyList();
            } else if (!(thing instanceof Container)) {
               return Collections.emptyList();
            } else {
               int index = -1;
               if (m.group(2) != null) {
                  String indexString = m.group(3);
                  index = Integer.parseInt(indexString);
               }

               List<T> children = new LinkedList();
               int currentIndex = 0;
               Iterator iterator = ((Container)thing).getBoxes().iterator();

               do {
                  do {
                     if (!iterator.hasNext()) {
                        return children;
                     }

                     Box box1 = (Box)iterator.next();
                     if (box1.getType().matches(type)) {
                        if (index == -1 || index == currentIndex) {
                           children.addAll(getPaths(box1, later, singleResult));
                        }

                        ++currentIndex;
                     }
                  } while(!singleResult && index < 0);
               } while(children.isEmpty());

               return children;
            }
         }
      }
   }

   public static boolean isContained(Box box, String path) {
      assert path.startsWith("/") : "Absolute path required";

      return getPaths(box, path).contains(box);
   }
}
