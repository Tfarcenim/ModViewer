package com.replaymod.replay.gui.screen;

import com.google.common.util.concurrent.SettableFuture;
import com.replaymod.core.ReplayMod;
import com.replaymod.core.SettingsRegistry;
import com.replaymod.core.gui.GuiReplaySettings;
import com.replaymod.core.utils.Utils;
import com.replaymod.core.versions.MCVer;
import com.replaymod.lib.de.johni0702.minecraft.gui.GuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.RenderInfo;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.AbstractGuiContainer;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiContainer;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiPanel;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiScreen;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiButton;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiImage;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiLabel;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiTextField;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiTooltip;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.advanced.AbstractGuiResourceLoadingList;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Typeable;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.CustomLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.HorizontalLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.LayoutData;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.VerticalLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.popup.AbstractGuiPopup;
import com.replaymod.lib.de.johni0702.minecraft.gui.popup.GuiYesNoPopup;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Colors;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Dimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadablePoint;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.Image;
import com.replaymod.lib.org.apache.commons.lang3.StringUtils;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Pair;
import com.replaymod.render.gui.GuiRenderQueue;
import com.replaymod.render.rendering.VideoRenderer;
import com.replaymod.render.utils.RenderJob;
import com.replaymod.replay.ReplayModReplay;
import com.replaymod.replay.Setting;
import com.replaymod.replaystudio.replay.ReplayFile;
import com.replaymod.replaystudio.replay.ReplayMetaData;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import net.minecraft.ChatFormatting;
import net.minecraft.CrashReport;
import net.minecraft.ReportedException;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.AlertScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.filefilter.SuffixFileFilter;

public class GuiReplayViewer extends GuiScreen {
   private final ReplayModReplay mod;
   public final GuiReplayViewer.GuiReplayList list = new GuiReplayList(this).onSelectionChanged(this::updateButtons).onSelectionDoubleClicked(() -> {
      if (this.loadButton.isEnabled()) {
         this.loadButton.onClick();
      }

   });
   public final GuiButton loadButton = new GuiButton().onClick(new Runnable() {
      private boolean loading = false;

      public void run() {
         if (!this.loading) {
            this.loading = true;
            GuiReplayViewer.this.loadButton.setDisabled();
            List<GuiReplayEntry> selected = GuiReplayViewer.this.list.getSelected();
            if (selected.size() == 1) {
               File file = selected.get(0).file;
               ReplayModReplay.LOGGER.info("Opening replay in viewer: " + file);

               try {
                  GuiReplayViewer.this.mod.startReplay(file);
               } catch (IOException var4) {
                  var4.printStackTrace();
               }
            } else {
               Iterator<Pair<File, List<RenderJob>>> replays = selected.stream().filter(it -> {
                  return !it.renderQueue.isEmpty();
               }).map(it -> {
                  return Pair.of(it.file, it.renderQueue);
               }).iterator();
               GuiRenderQueue.processMultipleReplays(GuiReplayViewer.this, GuiReplayViewer.this.mod, replays, () -> {
                  this.loading = false;
                  GuiReplayViewer.this.updateButtons();
                  GuiReplayViewer.this.display();
               });
            }

         }
      }
   }).setSize(150, 20);
   public final GuiButton folderButton = new GuiButton().onClick(new Runnable() {
      public void run() {
         try {
            File folder = GuiReplayViewer.this.mod.getCore().folders.getReplayFolder().toFile();
            MCVer.openFile(folder);
         } catch (IOException var2) {
            GuiReplayViewer.this.mod.getLogger().error("Cannot open file", var2);
         }

      }
   }).setSize(150, 20).setI18nLabel("replaymod.gui.viewer.replayfolder");
   public final GuiButton renameButton = new GuiButton().onClick(new Runnable() {
      public void run() {
         Path path = GuiReplayViewer.this.list.getSelected().get(0).file.toPath();
         String name = Utils.fileNameToReplayName(path.getFileName().toString());
         GuiTextField nameField = new GuiTextField().setSize(200, 20).setFocused(true).setText(name);
         GuiYesNoPopup popup = GuiYesNoPopup.open(GuiReplayViewer.this, new GuiLabel().setI18nText("replaymod.gui.viewer.rename.name", new Object[0]).setColor(Colors.BLACK), nameField).setYesI18nLabel("replaymod.gui.rename").setNoI18nLabel("replaymod.gui.cancel");
         ((VerticalLayout)popup.getInfo().getLayout()).setSpacing(7);
         nameField.onEnter(new Runnable(popup) {
            // $FF: synthetic field
            final GuiYesNoPopup val$popup;
            // $FF: synthetic field
            final <undefinedtype> this$1;

            {
               this.this$1 = this$1;
               this.val$popup = var2;
            }

            public void run() {
               if (this.val$popup.getYesButton().isEnabled()) {
                  this.val$popup.getYesButton().onClick();
               }

            }
         }).onTextChanged(obj -> {
            popup.getYesButton().setEnabled(!nameField.getText().isEmpty() && Files.notExists(Utils.replayNameToPath(path.getParent(), nameField.getText())));
         });
         popup.onAccept(() -> {
            String newName = nameField.getText().trim();
            Path targetPath = Utils.replayNameToPath(path.getParent(), newName);

            try {
               Files.move(path, targetPath);
            } catch (IOException var6) {
               var6.printStackTrace();
               GuiReplayViewer.this.getMinecraft().setScreen(new AlertScreen(GuiReplayViewer.this::display, Component.translatable("replaymod.gui.viewer.delete.failed1"), Component.translatable("replaymod.gui.viewer.delete.failed2")));
               return;
            }

            GuiReplayViewer.this.list.load();
         });
      }
   }).setSize(73, 20).setI18nLabel("replaymod.gui.rename", new Object[0]).setDisabled();
   public final GuiButton deleteButton = new GuiButton().onClick(() -> {
      Iterator var1 = this.list.getSelected().iterator();

      while(var1.hasNext()) {
         GuiReplayEntry entry = (GuiReplayEntry)var1.next();
         String name = entry.name.getText();
         GuiYesNoPopup.open(this, new GuiLabel().setI18nText("replaymod.gui.viewer.delete.linea", new Object[0]).setColor(Colors.BLACK), new GuiLabel().setI18nText("replaymod.gui.viewer.delete.lineb", new Object[]{name + ChatFormatting.RESET}).setColor(Colors.BLACK)).setYesI18nLabel("replaymod.gui.delete").setNoI18nLabel("replaymod.gui.cancel").onAccept(() -> {
            try {
               FileUtils.forceDelete(entry.file);
            } catch (IOException var3) {
               var3.printStackTrace();
            }

            this.list.load();
         });
      }

   }).setSize(73, 20).setI18nLabel("replaymod.gui.delete", new Object[0]).setDisabled();
   public final GuiButton settingsButton;
   public final GuiButton cancelButton;
   public final List<GuiButton> replaySpecificButtons;
   public final GuiPanel editorButton;
   public final GuiPanel upperButtonPanel;
   public final GuiPanel lowerButtonPanel;
   public final GuiPanel buttonPanel;
   private static final GuiImage DEFAULT_THUMBNAIL;

   public GuiReplayViewer(ReplayModReplay mod) {
      this.settingsButton = new GuiButton(this).setSize(20, 20).setTexture(ReplayMod.TEXTURE, 256).setSpriteUV(20, 0).setTooltip(new GuiTooltip().setI18nText("replaymod.gui.settings")).onClick(() -> {
         new GuiReplaySettings(this.toMinecraft(), this.getMod().getCore().getSettingsRegistry()).display();
      });
      this.cancelButton = new GuiButton().onClick(new Runnable() {
         public void run() {
            GuiReplayViewer.this.getMinecraft().setScreen(null);
         }
      }).setSize(73, 20).setI18nLabel("replaymod.gui.cancel");
      this.replaySpecificButtons = new ArrayList<>();
      this.replaySpecificButtons.add(this.renameButton);
      this.editorButton = new GuiPanel();
      this.upperButtonPanel = new GuiPanel().setLayout(new HorizontalLayout().setSpacing(5)).addElements(null, this.loadButton);
      this.lowerButtonPanel = new GuiPanel().setLayout(new HorizontalLayout().setSpacing(5)).addElements(null, this.renameButton, this.deleteButton, this.editorButton, this.cancelButton);
      this.buttonPanel = new GuiPanel(this).setLayout(new VerticalLayout().setSpacing(5)).addElements(null, this.upperButtonPanel, this.lowerButtonPanel);
      this.mod = mod;

      try {
         this.list.setFolder(mod.getCore().folders.getReplayFolder().toFile());
      } catch (IOException var3) {
         throw new ReportedException(CrashReport.forThrowable(var3, "Getting replay folder"));
      }

      this.setTitle(new GuiLabel().setI18nText("replaymod.gui.replayviewer"));
      this.setLayout(new CustomLayout<GuiScreen>() {
         protected void layout(GuiScreen container, int width, int height) {
            this.pos(GuiReplayViewer.this.buttonPanel, width / 2 - this.width(GuiReplayViewer.this.buttonPanel) / 2, height - 10 - this.height(GuiReplayViewer.this.buttonPanel));
            this.pos(GuiReplayViewer.this.list, 0, 30);
            this.size(GuiReplayViewer.this.list, width, this.y(GuiReplayViewer.this.buttonPanel) - 10 - this.y(GuiReplayViewer.this.list));
            this.pos(GuiReplayViewer.this.settingsButton, width - this.width(GuiReplayViewer.this.settingsButton) - 5, 5);
         }
      });
      this.updateButtons();
   }

   public ReplayModReplay getMod() {
      return this.mod;
   }

   private void updateButtons() {
      List<GuiReplayViewer.GuiReplayEntry> selected = this.list.getSelected();
      int count = selected.size();
      this.replaySpecificButtons.forEach(b -> {
         b.setEnabled(count == 1);
      });
      this.deleteButton.setEnabled(count > 0);
      if (count > 1) {
         Set<RenderJob> jobs = selected.stream().flatMap(entry -> {
            return entry.renderQueue.stream();
         }).collect(Collectors.toSet());
         String[] tooltipLines = jobs.stream().map(RenderJob::getName).toArray(x$0 -> {
            return new String[x$0];
         });
         this.loadButton.setI18nLabel("replaymod.gui.viewer.bulkrender", jobs.size());
         this.loadButton.setTooltip(new GuiTooltip().setText(tooltipLines));
         this.loadButton.setEnabled(!jobs.isEmpty());
         String[] compatError = VideoRenderer.checkCompat(jobs.stream().map(RenderJob::getSettings));
         if (compatError != null) {
            this.loadButton.setDisabled().setTooltip(new GuiTooltip().setText(compatError));
         }
      } else {
         this.loadButton.setI18nLabel("replaymod.gui.load");
         this.loadButton.setTooltip(null);
         this.loadButton.setEnabled(count == 1 && !selected.get(0).incompatible);
      }

   }

   static {
      DEFAULT_THUMBNAIL = new GuiImage().setTexture(Utils.DEFAULT_THUMBNAIL);
   }

   public static class GuiReplayList extends AbstractGuiResourceLoadingList<GuiReplayViewer.GuiReplayList, GuiReplayViewer.GuiReplayEntry> implements Typeable {
      private File folder = null;
      private final GuiTextField filterTextField = new GuiTextField().setFocused(true);

      public GuiReplayList(GuiContainer container) {
         super(container);
         this.onLoad(results -> {
            File[] files = this.folder.listFiles(new SuffixFileFilter(".mcpr", IOCase.INSENSITIVE));
            if (files == null) {
               ReplayModReplay.LOGGER.warn("Failed to list files in {}", this.folder);
            } else {
               Map<File, Long> lastModified = new HashMap();
               Arrays.sort(files, Comparator.comparingLong(f -> {
                  return lastModified.computeIfAbsent(f, File::lastModified);
               }).reversed());
               File[] var4 = files;
               int var5 = files.length;

               for(int var6 = 0; var6 < var5; ++var6) {
                  File file = var4[var6];
                  if (Thread.interrupted()) {
                     break;
                  }

                  try {
                     ReplayFile replayFile = ReplayMod.instance.files.open(file.toPath());

                     try {
                        Image thumb = Optional.ofNullable(replayFile.getThumbBytes().orNull()).flatMap(stream -> {
                           try {
                              InputStream in = stream;

                              Optional var2;
                              try {
                                 var2 = Optional.of(Image.read(in));
                              } catch (Throwable var5) {
                                 if (stream != null) {
                                    try {
                                       in.close();
                                    } catch (Throwable var4) {
                                       var5.addSuppressed(var4);
                                    }
                                 }

                                 throw var5;
                              }

                              if (stream != null) {
                                 stream.close();
                              }

                              return var2;
                           } catch (IOException var6) {
                              var6.printStackTrace();
                              return Optional.empty();
                           }
                        }).orElse(null);
                        ReplayMetaData metaData = replayFile.getMetaData();
                        List<RenderJob> renderQueue = RenderJob.readQueue(replayFile);
                        if (metaData != null) {
                           results.consume(() -> {
                              return new GuiReplayEntry(file, metaData, thumb, renderQueue) {
                                 // $FF: synthetic field
                                 final GuiReplayList this$0;

                                 {
                                    super(file, metaData, thumbImage, renderQueue);
                                    this.this$0 = this$0;
                                 }

                                 public ReadableDimension calcMinSize() {
                                    return this.this$0.isFiltered(this) ? new Dimension(-4, -4) : super.calcMinSize();
                                 }
                              };
                           });
                        }
                     } catch (Throwable var13) {
                        if (replayFile != null) {
                           try {
                              replayFile.close();
                           } catch (Throwable var12) {
                              var13.addSuppressed(var12);
                           }
                        }

                        throw var13;
                     }

                     if (replayFile != null) {
                        replayFile.close();
                     }
                  } catch (Exception var14) {
                     ReplayModReplay.LOGGER.error("Could not load Replay File {}", file.getName(), var14);
                  }
               }

            }
         }).setDrawShadow(true).setDrawSlider(true);
      }

      public void setFolder(File folder) {
         this.folder = folder;
      }

      private boolean isFiltered(GuiReplayViewer.GuiReplayEntry entry) {
         String filter = this.filterTextField.getText().toLowerCase();
         if (filter.isEmpty()) {
            return false;
         } else {
            return !entry.name.getText().toLowerCase().contains(filter);
         }
      }

      public boolean typeKey(ReadablePoint mousePosition, int keyCode, char keyChar, boolean ctrlDown, boolean shiftDown) {
         if (keyCode == 290) {
            SettingsRegistry reg = ReplayMod.instance.getSettingsRegistry();
            reg.set(Setting.SHOW_SERVER_IPS, !(Boolean)reg.get(Setting.SHOW_SERVER_IPS));
            reg.save();
            this.load();
         }

         boolean filterHasPriority = !this.filterTextField.getText().isEmpty();
         if (filterHasPriority && this.filterTextField.typeKey(mousePosition, keyCode, keyChar, ctrlDown, shiftDown)) {
            this.scrollY(0);
            return true;
         } else if (super.typeKey(mousePosition, keyCode, keyChar, ctrlDown, shiftDown)) {
            return true;
         } else if (!filterHasPriority && this.filterTextField.typeKey(mousePosition, keyCode, keyChar, ctrlDown, shiftDown)) {
            this.scrollY(0);
            return true;
         } else {
            return false;
         }
      }

      public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
         super.draw(renderer, size, renderInfo);
         String filter = this.filterTextField.getText();
         if (!filter.isEmpty()) {
            boolean anyMatches = this.getListPanel().calcMinSize().getHeight() > 0;
            Font fontRenderer = com.replaymod.lib.de.johni0702.minecraft.gui.versions.MCVer.getFontRenderer();
            int filterTextWidth = fontRenderer.width(filter);
            Objects.requireNonNull(fontRenderer);
            int filterTextHeight = 9;
            renderer.drawRect(size.getWidth() - 3 - 2 - filterTextWidth - 2, size.getHeight() - 3 - 2 - filterTextHeight - 2, 2 + filterTextWidth + 2, 2 + filterTextHeight + 2, Colors.WHITE);
            renderer.drawString(size.getWidth() - 3 - 2 - filterTextWidth, size.getHeight() - 3 - 2 - filterTextHeight, anyMatches ? Colors.BLACK : Colors.DARK_RED, filter);
         }

      }

      protected GuiReplayViewer.GuiReplayList getThis() {
         return this;
      }
   }

   public static class GuiReplayEntry extends AbstractGuiContainer<GuiReplayViewer.GuiReplayEntry> implements Comparable<GuiReplayViewer.GuiReplayEntry> {
      public final File file;
      public final GuiLabel name = new GuiLabel();
      public final GuiLabel server;
      public final GuiLabel date;
      public final GuiPanel infoPanel;
      public final GuiLabel version;
      public final GuiImage thumbnail;
      public final GuiLabel duration;
      public final GuiPanel durationPanel;
      public final GuiImage renderQueueIcon;
      private final long dateMillis;
      private final boolean incompatible;
      private final List<RenderJob> renderQueue;

      public GuiReplayEntry(File file, ReplayMetaData metaData, Image thumbImage, List<RenderJob> renderQueue) {
         this.server = new GuiLabel().setColor(Colors.LIGHT_GRAY);
         this.date = new GuiLabel().setColor(Colors.LIGHT_GRAY);
         this.infoPanel = new GuiPanel(this).setLayout(new VerticalLayout().setSpacing(2)).addElements(null, this.name, this.server, this.date);
         this.version = new GuiLabel(this).setColor(Colors.RED);
         this.duration = new GuiLabel();
         this.durationPanel = new GuiPanel().setBackgroundColor(Colors.HALF_TRANSPARENT).addElements(null, new GuiElement[]{this.duration}).setLayout(new CustomLayout<GuiPanel>() {
            // $FF: synthetic field
            final GuiReplayEntry this$0;

            {
               this.this$0 = this$0;
            }

            protected void layout(GuiPanel container, int width, int height) {
               this.pos(this.this$0.duration, 2, 2);
            }

            public ReadableDimension calcMinSize(GuiContainer<?> container) {
               ReadableDimension dimension = this.this$0.duration.calcMinSize();
               return new Dimension(dimension.getWidth() + 2, dimension.getHeight() + 2);
            }
         });
         this.renderQueueIcon = new GuiImage().setSize(10, 10).setTexture(ReplayMod.TEXTURE, 40, 0, 20, 20);
         this.file = file;
         this.renderQueue = renderQueue;
         ChatFormatting var10001 = ChatFormatting.UNDERLINE;
         this.name.setText(var10001 + Utils.fileNameToReplayName(file.getName()));
         if (!StringUtils.isEmpty(metaData.getCustomServerName())) {
            this.server.setText(metaData.getCustomServerName());
         } else if (!StringUtils.isEmpty(metaData.getServerName()) && ReplayMod.instance.getSettingsRegistry().get(Setting.SHOW_SERVER_IPS)) {
            this.server.setText(metaData.getServerName());
         } else {
            this.server.setI18nText("replaymod.gui.iphidden", new Object[0]).setColor(Colors.DARK_RED);
         }

         this.incompatible = !ReplayMod.isCompatible(metaData.getFileFormatVersion(), metaData.getRawProtocolVersionOr0());
         if (this.incompatible) {
            this.version.setText("Minecraft " + metaData.getMcVersion());
         }

         this.dateMillis = metaData.getDate();
         this.date.setText(new SimpleDateFormat().format(new Date(this.dateMillis)));
         if (thumbImage == null) {
            this.thumbnail = new GuiImage(GuiReplayViewer.DEFAULT_THUMBNAIL).setSize(53, 30);
            this.addElements(null, this.thumbnail);
         } else {
            this.thumbnail = new GuiImage(this).setTexture(thumbImage).setSize(53, 30);
         }

         this.duration.setText(Utils.convertSecondsToShortString(metaData.getDuration() / 1000));
         this.addElements(null, this.durationPanel);
         if (!renderQueue.isEmpty()) {
            this.renderQueueIcon.setTooltip(new GuiTooltip().setText(renderQueue.stream().map(RenderJob::getName).toArray(String[]::new)));
            this.addElements(null, this.renderQueueIcon);
         }

         this.setLayout(new CustomLayout<GuiReplayViewer.GuiReplayEntry>() {
            // $FF: synthetic field
            final GuiReplayViewer.GuiReplayEntry this$0;

            {
               this.this$0 = this$0;
            }

            protected void layout(GuiReplayViewer.GuiReplayEntry container, int width, int height) {
               this.pos(this.this$0.thumbnail, 0, 0);
               this.x(this.this$0.durationPanel, this.width(this.this$0.thumbnail) - this.width(this.this$0.durationPanel));
               this.y(this.this$0.durationPanel, this.height(this.this$0.thumbnail) - this.height(this.this$0.durationPanel));
               this.pos(this.this$0.infoPanel, this.width(this.this$0.thumbnail) + 5, 0);
               this.pos(this.this$0.version, width - this.width(this.this$0.version), 0);
               if (this.this$0.renderQueueIcon.getContainer() != null) {
                  this.pos(this.this$0.renderQueueIcon, this.width(this.this$0.thumbnail) - this.width(this.this$0.renderQueueIcon), 0);
               }

            }

            public ReadableDimension calcMinSize(GuiContainer<?> container) {
               return new Dimension(300, this.this$0.thumbnail.getMinSize().getHeight());
            }
         });
      }

      protected GuiReplayViewer.GuiReplayEntry getThis() {
         return this;
      }

      public int compareTo(GuiReplayViewer.GuiReplayEntry o) {
         return Long.compare(o.dateMillis, this.dateMillis);
      }
   }

   public static class GuiSelectReplayPopup extends AbstractGuiPopup<GuiReplayViewer.GuiSelectReplayPopup> {
      private final SettableFuture<File> future = SettableFuture.create();
      private final GuiReplayViewer.GuiReplayList list;
      private final GuiButton acceptButton;
      private final GuiButton cancelButton;

      public static GuiReplayViewer.GuiSelectReplayPopup openGui(GuiContainer container, File folder) {
         GuiReplayViewer.GuiSelectReplayPopup popup = new GuiReplayViewer.GuiSelectReplayPopup(container, folder);
         popup.list.load();
         popup.open();
         return popup;
      }

      public GuiSelectReplayPopup(GuiContainer container, File folder) {
         super(container);
         this.list = new GuiReplayViewer.GuiReplayList(this.popup);
         this.acceptButton = new GuiButton(this.popup).setI18nLabel("gui.done", new Object[0]).setSize(50, 20).setDisabled();
         this.cancelButton = new GuiButton(this.popup).setI18nLabel("gui.cancel", new Object[0]).setSize(50, 20);
         this.list.setFolder(folder);
         this.list.onSelectionChanged(() -> {
            this.acceptButton.setEnabled(this.list.getSelected() != null);
         }).onSelectionDoubleClicked(() -> {
            this.close();
            this.future.set(this.list.getSelected().get(0).file);
         });
         this.acceptButton.onClick(() -> {
            this.future.set(this.list.getSelected().get(0).file);
            this.close();
         });
         this.cancelButton.onClick(() -> {
            this.future.set(null);
            this.close();
         });
         this.popup.setLayout(new CustomLayout<GuiPanel>() {
            // $FF: synthetic field
            final GuiReplayViewer.GuiSelectReplayPopup this$0;

            {
               this.this$0 = this$0;
            }

            protected void layout(GuiPanel container, int width, int height) {
               this.pos(this.this$0.cancelButton, width - this.width(this.this$0.cancelButton), height - this.height(this.this$0.cancelButton));
               this.pos(this.this$0.acceptButton, this.x(this.this$0.cancelButton) - 5 - this.width(this.this$0.acceptButton), this.y(this.this$0.cancelButton));
               this.pos(this.this$0.list, 0, 5);
               this.size(this.this$0.list, width, height - this.height(this.this$0.cancelButton) - 10);
            }

            public ReadableDimension calcMinSize(GuiContainer container) {
               return new Dimension(330, 200);
            }
         });
      }

      public SettableFuture<File> getFuture() {
         return this.future;
      }

      public GuiReplayViewer.GuiReplayList getList() {
         return this.list;
      }

      public GuiButton getAcceptButton() {
         return this.acceptButton;
      }

      public GuiButton getCancelButton() {
         return this.cancelButton;
      }

      protected GuiReplayViewer.GuiSelectReplayPopup getThis() {
         return this;
      }
   }
}
