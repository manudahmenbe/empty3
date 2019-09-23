/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

/*
 * 2013 Manuel Dahmen
 */
package one.empty3.library;

import one.empty3.library.core.animation.Animation;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Scene extends Representable implements Serializable {

    public static final String VERSION = "2019.1";
    /**
     *
     */
    public String author;
    public String date;
    public String description;
    public StructureMatrix<Camera> cameraActive = new StructureMatrix<>(0, Camera.class);
    private StructureMatrix<Representable> objets = new StructureMatrix<>(1, Representable.class);
    private StructureMatrix<Animation> animations = new StructureMatrix<>(1, Animation.class);
    private StructureMatrix<Camera> cameras = new StructureMatrix<>(1, Camera.class);
    private StructureMatrix<ITexture> colors = new StructureMatrix<>(1, ITexture.class);
    private StructureMatrix<Lumiere> lumieres = new StructureMatrix<>(1, Lumiere.class);
    private SceneCadre cadre = new SceneCadre();
    private GTime gt = new GTime();
    private Lumiere lumiereActive;
    private String DESCRIPTION;
    private Time time;
    private List<Move> moves;

    {

    }
    // FOR LOADER
    private Representable dernierAjout;

    public Scene() {

        super();
        Camera camera = new Camera();
        cameras.setElem(camera, 0);
        cameraActive.setElem(camera);
    }



    public boolean add(Representable add) {

        this.dernierAjout = add;

        add.scene(this);

        objets.add(1, add);

        return true;

    }

    public boolean add(Representable add, ZBuffer zBuffer) {

        this.dernierAjout = add;


        add.scene(this);

        add.setPainter(new Painter(zBuffer, this));

        objets.add(1, add);

        return true;

    }

    public int calculerCouleurLumiere(int t, Point3D point, Point3D normale) {
        int size = lumieres().size();
        int[] cs = new int[size];
        for (int i = 0; i < size; i++) {

            cs[i] = lumieres().get(i).getCouleur(t, point, normale);

        }
        return colorAdd(cs);
    }

    @Deprecated
    public Camera camera() {
        return cameraActive();
    }

    @Deprecated
    public void camera(Camera c) {
        cameraActive.setElem(c);
    }

    public Camera cameraActive() {
        if (cameraActive != null) {
            return cameraActive.getElem();
        } else if (cameras.data1d.size() > 0) {
            return cameras.getElem(0);
        }
        return Camera.PARDEFAULT;
    }

    public void cameraActive(Camera c) {
        this.cameraActive.setElem(c);
        if (!cameras.getData1d().contains(c)) {
            cameras.add(1, c);
        }
    }

    public List<Camera> cameras() {
        return this.cameras.getData1d();
    }


    protected int colorAdd(int[] cs) {
        float[] compArray = new float[4];
        float[] compArray3 = new float[4];

        int l = cs.length;
        for (int c = 0; c < l; c++) {
            for (int i = 0; i < 3; i++) {
                compArray3 = new Color(cs[i]).getRGBComponents(compArray);

                compArray3[i] += compArray[i] / l;
            }
        }
        int res = new Color(compArray3[0], compArray3[1], compArray3[2], compArray3[3]).getRGB();

        return res;
    }

    public void dumpDATA() {
        this.setDESCRIPTION(toString());
    }

    public Representable find(String ido) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void flushImports() {
        dernierAjout = null;
    }

    public SceneCadre getCadre() {
        return cadre;
    }

    public void setCadre(SceneCadre cadre) {
        this.cadre = cadre;
    }

    public Representable getDernierAjout() {
        return dernierAjout;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String dESCRIPTION) {
        DESCRIPTION = dESCRIPTION;
    }

    public GTime getGt() {
        return gt;
    }

    public Iterator<Representable> iterator() {
        return objets.getData1d().iterator();
    }

    public Object[] liste() {
        Iterator<Representable> ir = iterator();

        Object[] liste = new Object[size()];
        int i = 0;
        while (ir.hasNext()) {
            liste[i] = ir.next().toString();
            liste[i] = ((String) liste[i]).length() >= 100 ? ((String) liste[i]).substring(0, 100) : liste[i];
            i++;
        }
        return liste;
    }

    public Lumiere lumiereActive() {
        if (lumiereActive != null) {
            return lumiereActive;
        } else if (lumieres.getData1d().size() > 0) {
            return lumieres.getData1d(). get(0);
        }
        return LumierePointSimple.PARDEFAUT;
    }

    public ArrayList<Lumiere> lumieres() {
        return (ArrayList<Lumiere>) lumieres.getData1d();
    }

    public int lumiereTotaleCouleur(int c, Point3D p, Point3D n) {
        if (lumieres.getData1d().isEmpty()) {
            return c;
        }

        float[] t = new float[]{0, 0, 0, 0};

        int cpt = 0;

        for (int i = 0; i < lumieres.getData1d().size(); i++) {
            Lumiere l = lumieres.getElem(i);

            int cP = l.getCouleur(c, p, n);

            Color color = new Color(cP);
            t[0] += color.getRed() / 256.0;

            t[1] += color.getGreen() / 256.0;

            t[2] += color.getBlue() / 256.0;

            t[3] += color.getAlpha() / 256.0;

            cpt++;
        }

        for (int i = 0; i < 4; i++) {
            t[i] /= cpt;
        }

        return new Color(t[0], t[1], t[2], t[3]).getRGB();
    }

    public Representable place(MODObjet aThis) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public boolean remove(Representable rem) {
        return objets.getData1d().remove(rem);
    }

    public int size() {
        return objets.getData1d().size();
    }

    @Override
    public boolean supporteTexture() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void texture(ITexture c) {
        colors.getData1d().add(c);
    }

    public ArrayList<ITexture> textures() {
        return (ArrayList<ITexture>) colors.getData1d()
                ;
    }

    @Override
    public String toString() {
        String str = "scene \n(\n\n";

        Iterator<Representable> it = iterator();
        while (it.hasNext()) {
            Representable r = it.next();
            if (r instanceof Point3D) {
                str += ((Point3D) r).toLongString();
            } else {
                str += r.toString();
            }
        }
        str += "cameras (\n\t";
        if (cameras.getData1d().isEmpty()) {
            str += "\n\t" + cameraActive().toString() + "\n";
        }
        Iterator<Camera> itC = cameras.getData1d().iterator();
        while (itC.hasNext()) {
            str += "\n\t" + itC.next().toString() + "\n";
        }
        str += "\n)";

        str += "\n\n)\n";
        return str;
    }

    public void updateFromText(Representable selectedComponent, String text) {
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return
     */
    public boolean updateTime() {
        return false;
    }

    public Time getTime() {
        return time;
    }

    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("objets/Objets à peindre",objets);
        getDeclaredDataStructure().put("animations/Animation (pas implémenté maintenant jamais",animations);
        getDeclaredDataStructure().put("cameras/Caméras de la scène. cameraActive caméra en cours",cameras);
        getDeclaredDataStructure().put("lumieres/Lumières additionnelles",lumieres);
        getDeclaredDataStructure().put("cameraActive/cameraActive", this.cameraActive);
    }

    public static String getVERSION() {
        return VERSION;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Camera getCameraActive() {
        return cameraActive.getElem();
    }

    public void setCameraActive(Camera cameraActive) {
        this.cameraActive.setElem(cameraActive);
    }


    public StructureMatrix<Representable> getObjets() {
        return objets;
    }

    public void setObjets(StructureMatrix<Representable> objets) {
        this.objets = objets;
    }

    public StructureMatrix<Animation> getAnimations() {
        return animations;
    }

    public void setAnimations(StructureMatrix<Animation> animations) {
        this.animations = animations;
    }

    public StructureMatrix<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(StructureMatrix<Camera> cameras) {
        this.cameras = cameras;
    }

    public StructureMatrix<ITexture> getColors() {
        return colors;
    }

    public void setColors(StructureMatrix<ITexture> colors) {
        this.colors = colors;
    }

    public StructureMatrix<Lumiere> getLumieres() {
        return lumieres;
    }

    public void setLumieres(StructureMatrix<Lumiere> lumieres) {
        this.lumieres = lumieres;
    }

    public void setGt(GTime gt) {
        this.gt = gt;
    }

    public Lumiere getLumiereActive() {
        return lumiereActive;
    }

    public void setLumiereActive(Lumiere lumiereActive) {
        this.lumiereActive = lumiereActive;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setDernierAjout(Representable dernierAjout) {
        this.dernierAjout = dernierAjout;
    }

    public void setLumieres(ArrayList<Lumiere> lumieres) {
        this.lumieres.setAll(lumieres);
    }

    public void setCameras(ArrayList<Camera> cameras) {
        this.cameras.setAll(cameras);

    }

    public void clear() {
        scene.clear();    }

    public Representable get(int i) {
        return getObjets().getElem(i);
    }
}
