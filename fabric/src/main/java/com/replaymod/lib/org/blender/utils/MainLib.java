package com.replaymod.lib.org.blender.utils;

import com.replaymod.lib.org.blender.dna.BlenderObject;
import com.replaymod.lib.org.blender.dna.Brush;
import com.replaymod.lib.org.blender.dna.CacheFile;
import com.replaymod.lib.org.blender.dna.Camera;
import com.replaymod.lib.org.blender.dna.Curve;
import com.replaymod.lib.org.blender.dna.FileGlobal;
import com.replaymod.lib.org.blender.dna.FreestyleLineStyle;
import com.replaymod.lib.org.blender.dna.Group;
import com.replaymod.lib.org.blender.dna.ID;
import com.replaymod.lib.org.blender.dna.IdAdtTemplate;
import com.replaymod.lib.org.blender.dna.Image;
import com.replaymod.lib.org.blender.dna.Ipo;
import com.replaymod.lib.org.blender.dna.Key;
import com.replaymod.lib.org.blender.dna.Lamp;
import com.replaymod.lib.org.blender.dna.Lattice;
import com.replaymod.lib.org.blender.dna.Library;
import com.replaymod.lib.org.blender.dna.Mask;
import com.replaymod.lib.org.blender.dna.Material;
import com.replaymod.lib.org.blender.dna.Mesh;
import com.replaymod.lib.org.blender.dna.MetaBall;
import com.replaymod.lib.org.blender.dna.MovieClip;
import com.replaymod.lib.org.blender.dna.PaintCurve;
import com.replaymod.lib.org.blender.dna.Palette;
import com.replaymod.lib.org.blender.dna.ParticleSettings;
import com.replaymod.lib.org.blender.dna.Scene;
import com.replaymod.lib.org.blender.dna.Script;
import com.replaymod.lib.org.blender.dna.Speaker;
import com.replaymod.lib.org.blender.dna.Tex;
import com.replaymod.lib.org.blender.dna.Text;
import com.replaymod.lib.org.blender.dna.VFont;
import com.replaymod.lib.org.blender.dna.World;
import com.replaymod.lib.org.blender.dna.bAction;
import com.replaymod.lib.org.blender.dna.bArmature;
import com.replaymod.lib.org.blender.dna.bGPdata;
import com.replaymod.lib.org.blender.dna.bNodeTree;
import com.replaymod.lib.org.blender.dna.bScreen;
import com.replaymod.lib.org.blender.dna.bSound;
import com.replaymod.lib.org.blender.dna.wmWindowManager;
import com.replaymod.lib.org.cakelab.blender.io.BlenderFile;
import com.replaymod.lib.org.cakelab.blender.io.FileVersionInfo;
import com.replaymod.lib.org.cakelab.blender.nio.CFacade;
import com.replaymod.lib.org.cakelab.blender.nio.CPointer;
import com.replaymod.lib.org.cakelab.blender.utils.MainLibBase;
import java.io.IOException;

public class MainLib extends MainLibBase {
   public static final short BLENDER_VERSION = 279;
   public static final short BLENDER_SUBVERSION = 0;
   public static final short BLENDER_MINVERSION = 270;
   public static final short BLENDER_MINSUBVERSION = 6;
   private MainLib next;
   private MainLib prev;
   private FileGlobal fileGlobal;
   private Library library;
   private Ipo ipo;
   private Key key;
   private Text text;
   private Camera camera;
   private Image image;
   private Tex tex;
   private Lamp lamp;
   private Material material;
   private VFont vFont;
   private MetaBall metaBall;
   private Curve curve;
   private Mesh mesh;
   private Lattice lattice;
   private BlenderObject object;
   private World world;
   private Scene scene;
   private Script script;
   private bScreen bScreen;
   private bSound bSound;
   private Group group;
   private bArmature bArmature;
   private bAction bAction;
   private bNodeTree bNodeTree;
   private Brush brush;
   private Palette palette;
   private PaintCurve paintCurve;
   private ParticleSettings particleSettings;
   private bGPdata bGPdata;
   private wmWindowManager wmWindowManager;
   private IdAdtTemplate idAdtTemplate;
   private Speaker speaker;
   private MovieClip movieClip;
   private Mask mask;
   private FreestyleLineStyle freestyleLineStyle;
   private CacheFile cacheFile;

   public MainLib(BlenderFile blendFile) throws IOException {
      super("com.replaymod.lib.org.blender.dna", blendFile);
      this.fileGlobal = BlenderFactory.getFileGlobal(blendFile);
   }

   public static boolean doVersionCheck(FileVersionInfo fileVersionInfo) throws IOException {
      int version = fileVersionInfo.getVersion().getCode();
      int subversion = fileVersionInfo.getSubversion();
      return version == 279 && subversion == 0;
   }

   public static boolean doCompatibilityCheck(FileVersionInfo fileVersionInfo) throws IOException {
      int version = fileVersionInfo.getVersion().getCode();
      int subversion = fileVersionInfo.getSubversion();
      return (version > 270 || version == 270 && subversion >= 6) && (version < 279 || version == 279 && subversion <= 0);
   }

   protected CFacade getFirst(CFacade libElem) throws IOException {
      CPointer<?> p = CFacade.__io__addressof(libElem);

      ID id;
      for(id = (ID)p.cast(ID.class).get(); id.getPrev().isValid(); id = (ID)id.getPrev().cast(ID.class).get()) {
      }

      return (CFacade)id.__io__addressof().cast(libElem.getClass()).get();
   }

   public MainLib getNext() {
      return this.next;
   }

   public MainLib getPrev() {
      return this.prev;
   }

   public FileGlobal getFileGlobal() {
      return this.fileGlobal;
   }

   public Library getLibrary() {
      return this.library;
   }

   public void setLibrary(Library library) {
      this.library = library;
   }

   public Ipo getIpo() {
      return this.ipo;
   }

   public void setIpo(Ipo ipo) {
      this.ipo = ipo;
   }

   public Key getKey() {
      return this.key;
   }

   public void setKey(Key key) {
      this.key = key;
   }

   public Text getText() {
      return this.text;
   }

   public void setText(Text text) {
      this.text = text;
   }

   public Camera getCamera() {
      return this.camera;
   }

   public void setCamera(Camera camera) {
      this.camera = camera;
   }

   public Image getImage() {
      return this.image;
   }

   public void setImage(Image image) {
      this.image = image;
   }

   public Tex getTex() {
      return this.tex;
   }

   public void setTex(Tex tex) {
      this.tex = tex;
   }

   public Lamp getLamp() {
      return this.lamp;
   }

   public void setLamp(Lamp lamp) {
      this.lamp = lamp;
   }

   public Material getMaterial() {
      return this.material;
   }

   public void setMaterial(Material material) {
      this.material = material;
   }

   public VFont getVFont() {
      return this.vFont;
   }

   public void setVFont(VFont vFont) {
      this.vFont = vFont;
   }

   public MetaBall getMetaBall() {
      return this.metaBall;
   }

   public void setMetaBall(MetaBall metaBall) {
      this.metaBall = metaBall;
   }

   public Curve getCurve() {
      return this.curve;
   }

   public void setCurve(Curve curve) {
      this.curve = curve;
   }

   public Mesh getMesh() {
      return this.mesh;
   }

   public void setMesh(Mesh mesh) {
      this.mesh = mesh;
   }

   public Lattice getLattice() {
      return this.lattice;
   }

   public void setLattice(Lattice lattice) {
      this.lattice = lattice;
   }

   public BlenderObject getObject() {
      return this.object;
   }

   public void setObject(BlenderObject object) {
      this.object = object;
   }

   public World getWorld() {
      return this.world;
   }

   public void setWorld(World world) {
      this.world = world;
   }

   public Scene getScene() {
      return this.scene;
   }

   public void setScene(Scene scene) {
      this.scene = scene;
   }

   public Script getScript() {
      return this.script;
   }

   public void setScript(Script script) {
      this.script = script;
   }

   public bScreen getBScreen() {
      return this.bScreen;
   }

   public void setBScreen(bScreen bScreen) {
      this.bScreen = bScreen;
   }

   public bSound getBSound() {
      return this.bSound;
   }

   public void setBSound(bSound bSound) {
      this.bSound = bSound;
   }

   public Group getGroup() {
      return this.group;
   }

   public void setGroup(Group group) {
      this.group = group;
   }

   public bArmature getBArmature() {
      return this.bArmature;
   }

   public void setBArmature(bArmature bArmature) {
      this.bArmature = bArmature;
   }

   public bAction getBAction() {
      return this.bAction;
   }

   public void setBAction(bAction bAction) {
      this.bAction = bAction;
   }

   public bNodeTree getBNodeTree() {
      return this.bNodeTree;
   }

   public void setBNodeTree(bNodeTree bNodeTree) {
      this.bNodeTree = bNodeTree;
   }

   public Brush getBrush() {
      return this.brush;
   }

   public void setBrush(Brush brush) {
      this.brush = brush;
   }

   public Palette getPalette() {
      return this.palette;
   }

   public void setPalette(Palette palette) {
      this.palette = palette;
   }

   public PaintCurve getPaintCurve() {
      return this.paintCurve;
   }

   public void setPaintCurve(PaintCurve paintCurve) {
      this.paintCurve = paintCurve;
   }

   public ParticleSettings getParticleSettings() {
      return this.particleSettings;
   }

   public void setParticleSettings(ParticleSettings particleSettings) {
      this.particleSettings = particleSettings;
   }

   public bGPdata getBGPdata() {
      return this.bGPdata;
   }

   public void setBGPdata(bGPdata bGPdata) {
      this.bGPdata = bGPdata;
   }

   public wmWindowManager getWmWindowManager() {
      return this.wmWindowManager;
   }

   public void setWmWindowManager(wmWindowManager wmWindowManager) {
      this.wmWindowManager = wmWindowManager;
   }

   public IdAdtTemplate getIdAdtTemplate() {
      return this.idAdtTemplate;
   }

   public void setIdAdtTemplate(IdAdtTemplate idAdtTemplate) {
      this.idAdtTemplate = idAdtTemplate;
   }

   public Speaker getSpeaker() {
      return this.speaker;
   }

   public void setSpeaker(Speaker speaker) {
      this.speaker = speaker;
   }

   public MovieClip getMovieClip() {
      return this.movieClip;
   }

   public void setMovieClip(MovieClip movieClip) {
      this.movieClip = movieClip;
   }

   public Mask getMask() {
      return this.mask;
   }

   public void setMask(Mask mask) {
      this.mask = mask;
   }

   public FreestyleLineStyle getFreestyleLineStyle() {
      return this.freestyleLineStyle;
   }

   public void setFreestyleLineStyle(FreestyleLineStyle freestyleLineStyle) {
      this.freestyleLineStyle = freestyleLineStyle;
   }

   public CacheFile getCacheFile() {
      return this.cacheFile;
   }

   public void setCacheFile(CacheFile cacheFile) {
      this.cacheFile = cacheFile;
   }
}
