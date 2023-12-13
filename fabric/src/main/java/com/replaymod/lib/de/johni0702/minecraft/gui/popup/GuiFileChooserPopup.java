package com.replaymod.lib.de.johni0702.minecraft.gui.popup;

import com.replaymod.lib.de.johni0702.minecraft.gui.GuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.RenderInfo;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiContainer;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiPanel;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiScrollable;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiVerticalList;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiButton;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiTextField;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.advanced.GuiDropdownMenu;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Typeable;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.CustomLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.HorizontalLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.LayoutData;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.VerticalLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Colors;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Consumer;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Dimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadablePoint;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.MCVer;
import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class GuiFileChooserPopup extends AbstractGuiPopup<GuiFileChooserPopup> implements Typeable {
   private Consumer<File> onAccept = (file) -> {
   };
   private Runnable onCancel = () -> {
   };
   private final GuiScrollable pathScrollable;
   private final GuiPanel pathPanel;
   private final GuiVerticalList fileList;
   private final GuiTextField nameField;
   private final GuiButton acceptButton;
   private final GuiButton cancelButton;
   private final String[] fileExtensions;
   private final boolean load;
   private File folder;

   public static GuiFileChooserPopup openSaveGui(GuiContainer container, String buttonLabel, String... fileExtensions) {
      GuiFileChooserPopup popup = (GuiFileChooserPopup)(new GuiFileChooserPopup(container, fileExtensions, false)).setBackgroundColor(Colors.DARK_TRANSPARENT);
      popup.acceptButton.setI18nLabel(buttonLabel, new Object[0]);
      popup.open();
      return popup;
   }

   public static GuiFileChooserPopup openLoadGui(GuiContainer container, String buttonLabel, String... fileExtensions) {
      GuiFileChooserPopup popup = (GuiFileChooserPopup)(new GuiFileChooserPopup(container, fileExtensions, true)).setBackgroundColor(Colors.DARK_TRANSPARENT);
      ((GuiButton)popup.acceptButton.setI18nLabel(buttonLabel, new Object[0])).setDisabled();
      popup.open();
      return popup;
   }

   public GuiFileChooserPopup(GuiContainer container, String[] fileExtensions, boolean load) {
      super(container);
      this.pathScrollable = new GuiScrollable(this.popup) {
         public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
            this.scrollX(0);
            super.draw(renderer, size, renderInfo);
         }
      };
      this.pathPanel = (GuiPanel)(new GuiPanel(this.pathScrollable)).setLayout(new HorizontalLayout());
      this.fileList = new GuiVerticalList(this.popup);
      this.nameField = (GuiTextField)((GuiTextField)((GuiTextField)(new GuiTextField(this.popup)).onEnter(new Runnable() {
         public void run() {
            if (GuiFileChooserPopup.this.acceptButton.isEnabled()) {
               GuiFileChooserPopup.this.acceptButton.onClick();
            }

         }
      })).onTextChanged(new Consumer<String>() {
         public void consume(String oldName) {
            GuiFileChooserPopup.this.updateButton();
         }
      })).setMaxLength(Integer.MAX_VALUE);
      this.acceptButton = (GuiButton)((GuiButton)(new GuiButton(this.popup)).onClick(new Runnable() {
         public void run() {
            String fileName = GuiFileChooserPopup.this.nameField.getText();
            if (!GuiFileChooserPopup.this.load && GuiFileChooserPopup.this.fileExtensions.length > 0 && !GuiFileChooserPopup.this.hasValidExtension(fileName)) {
               fileName = fileName + "." + GuiFileChooserPopup.this.fileExtensions[0];
            }

            GuiFileChooserPopup.this.onAccept.consume(new File(GuiFileChooserPopup.this.folder, fileName));
            GuiFileChooserPopup.this.close();
         }
      })).setSize(50, 20);
      this.cancelButton = (GuiButton)((GuiButton)((GuiButton)(new GuiButton(this.popup)).onClick(new Runnable() {
         public void run() {
            GuiFileChooserPopup.this.onCancel.run();
            GuiFileChooserPopup.this.close();
         }
      })).setI18nLabel("gui.cancel", new Object[0])).setSize(50, 20);
      this.fileList.setLayout((new VerticalLayout()).setSpacing(1));
      this.popup.setLayout(new CustomLayout<GuiPanel>() {
         protected void layout(GuiPanel container, int width, int height) {
            this.pos(GuiFileChooserPopup.this.pathScrollable, 0, 0);
            this.size(GuiFileChooserPopup.this.pathScrollable, width, 20);
            this.pos(GuiFileChooserPopup.this.cancelButton, width - this.width(GuiFileChooserPopup.this.cancelButton), height - this.height(GuiFileChooserPopup.this.cancelButton));
            this.pos(GuiFileChooserPopup.this.acceptButton, this.x(GuiFileChooserPopup.this.cancelButton) - 5 - this.width(GuiFileChooserPopup.this.acceptButton), this.y(GuiFileChooserPopup.this.cancelButton));
            this.size(GuiFileChooserPopup.this.nameField, this.x(GuiFileChooserPopup.this.acceptButton) - 5, 20);
            this.pos(GuiFileChooserPopup.this.nameField, 0, height - this.height(GuiFileChooserPopup.this.nameField));
            this.pos(GuiFileChooserPopup.this.fileList, 0, this.y(GuiFileChooserPopup.this.pathScrollable) + this.height(GuiFileChooserPopup.this.pathScrollable) + 5);
            this.size(GuiFileChooserPopup.this.fileList, width, this.y(GuiFileChooserPopup.this.nameField) - this.y(GuiFileChooserPopup.this.fileList) - 5);
         }

         public ReadableDimension calcMinSize(GuiContainer container) {
            return new Dimension(300, 200);
         }
      });
      this.fileExtensions = fileExtensions;
      this.load = load;
      this.setFolder(new File("."));
   }

   protected void updateButton() {
      String name = this.nameField.getText();
      File file = new File(this.folder, name);
      boolean valid = !name.contains(File.separator);

      try {
         file.toPath();
      } catch (InvalidPathException var5) {
         valid = false;
      }

      if (this.load) {
         valid &= file.exists();
      }

      this.acceptButton.setEnabled(valid);
   }

   public void setFolder(File folder) {
      if (!folder.isDirectory()) {
         throw new IllegalArgumentException("Folder has to be a directory.");
      } else {
         try {
            this.folder = folder = folder.getCanonicalFile();
         } catch (IOException var11) {
            this.close();
            throw new RuntimeException(var11);
         }

         this.updateButton();
         Iterator var2 = (new ArrayList(this.pathPanel.getElements().keySet())).iterator();

         GuiElement element;
         while(var2.hasNext()) {
            element = (GuiElement)var2.next();
            this.pathPanel.removeElement(element);
         }

         var2 = (new ArrayList(this.fileList.getListPanel().getElements().keySet())).iterator();

         while(var2.hasNext()) {
            element = (GuiElement)var2.next();
            this.fileList.getListPanel().removeElement(element);
         }

         File[] files = folder.listFiles();
         final File selected;
         File[] roots;
         GuiPanel var10000;
         GuiElement[] var10002;
         GuiButton var10005;
         String var10006;
         if (files != null) {
            Arrays.sort(files, new Comparator<File>() {
               public int compare(File f1, File f2) {
                  if (f1.isDirectory() && !f2.isDirectory()) {
                     return -1;
                  } else {
                     return !f1.isDirectory() && f2.isDirectory() ? 1 : f1.getName().compareToIgnoreCase(f2.getName());
                  }
               }
            });
            roots = files;
            int var4 = files.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               selected = roots[var5];
               if (selected.isDirectory()) {
                  var10000 = this.fileList.getListPanel();
                  VerticalLayout.Data var10001 = new VerticalLayout.Data(0.0D);
                  var10002 = new GuiElement[1];
                  var10005 = (GuiButton)(new GuiButton()).onClick(new Runnable() {
                     public void run() {
                        GuiFileChooserPopup.this.setFolder(selected);
                     }
                  });
                  var10006 = selected.getName();
                  var10002[0] = var10005.setLabel(var10006 + File.separator);
                  var10000.addElements(var10001, var10002);
               } else if (this.hasValidExtension(selected.getName())) {
                  this.fileList.getListPanel().addElements(new VerticalLayout.Data(0.0D), new GuiElement[]{((GuiButton)(new GuiButton()).onClick(new Runnable() {
                     public void run() {
                        GuiFileChooserPopup.this.setFileName(selected.getName());
                     }
                  })).setLabel(selected.getName())});
               }
            }
         }

         this.fileList.setOffsetY(0);
         roots = File.listRoots();
         if (roots != null && roots.length > 1) {
            final GuiDropdownMenu<File> dropdown = new GuiDropdownMenu<File>(this.pathPanel) {
               private final GuiButton skin = new GuiButton();

               protected ReadableDimension calcMinSize() {
                  ReadableDimension dim = super.calcMinSize();
                  int var10002 = dim.getWidth() - 5;
                  Objects.requireNonNull(MCVer.getFontRenderer());
                  return new Dimension(var10002 - 9, dim.getHeight());
               }

               public void layout(ReadableDimension size, RenderInfo renderInfo) {
                  super.layout(size, renderInfo);
                  if (renderInfo.layer == 0) {
                     this.skin.layout(size, renderInfo);
                  }

               }

               public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
                  super.draw(renderer, size, renderInfo);
                  if (renderInfo.layer == 0) {
                     this.skin.setLabel(((File)this.getSelectedValue()).toString());
                     this.skin.draw(renderer, size, renderInfo);
                  }

               }
            };
            List<File> actualRoots = new ArrayList();
            selected = null;
            File[] var7 = roots;
            int var8 = roots.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               File root = var7[var9];
               if (root.isDirectory()) {
                  actualRoots.add(root);
                  if (folder.getAbsolutePath().startsWith(root.getAbsolutePath())) {
                     selected = root;
                  }
               }
            }

            assert selected != null;

            ((GuiDropdownMenu)dropdown.setValues((File[])actualRoots.toArray(new File[actualRoots.size()]))).setSelected(selected);
            dropdown.onSelection(new Consumer<Integer>() {
               public void consume(Integer old) {
                  GuiFileChooserPopup.this.setFolder((File)dropdown.getSelectedValue());
               }
            });
         }

         LinkedList parents;
         for(parents = new LinkedList(); folder != null; folder = folder.getParentFile()) {
            parents.addFirst(folder);
         }

         Iterator var17 = parents.iterator();

         while(var17.hasNext()) {
            selected = (File)var17.next();
            var10000 = this.pathPanel;
            var10002 = new GuiElement[1];
            var10005 = (GuiButton)(new GuiButton()).onClick(new Runnable() {
               public void run() {
                  GuiFileChooserPopup.this.setFolder(selected);
               }
            });
            var10006 = selected.getName();
            var10002[0] = var10005.setLabel(var10006 + File.separator);
            var10000.addElements((LayoutData)null, var10002);
         }

         this.pathScrollable.setOffsetX(Integer.MAX_VALUE);
      }
   }

   public void setFileName(String fileName) {
      this.nameField.setText(fileName);
      this.nameField.setCursorPosition(fileName.length());
      this.updateButton();
   }

   private boolean hasValidExtension(String name) {
      String[] var2 = this.fileExtensions;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String fileExtension = var2[var4];
         if (name.endsWith("." + fileExtension)) {
            return true;
         }
      }

      return false;
   }

   protected GuiFileChooserPopup getThis() {
      return this;
   }

   public GuiFileChooserPopup onAccept(Consumer<File> onAccept) {
      this.onAccept = onAccept;
      return this;
   }

   public GuiFileChooserPopup onCancel(Runnable onCancel) {
      this.onCancel = onCancel;
      return this;
   }

   public boolean typeKey(ReadablePoint mousePosition, int keyCode, char keyChar, boolean ctrlDown, boolean shiftDown) {
      if (keyCode == 256) {
         this.cancelButton.onClick();
         return true;
      } else {
         return false;
      }
   }

   public GuiButton getAcceptButton() {
      return this.acceptButton;
   }

   public GuiButton getCancelButton() {
      return this.cancelButton;
   }
}
