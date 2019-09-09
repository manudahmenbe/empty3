/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
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

import one.empty3.library.core.lighting.Colors;
import one.empty3.library.core.raytracer.RtIntersectInfo;
import one.empty3.library.core.raytracer.RtMatiere;
import one.empty3.library.core.raytracer.RtRay;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class Representable implements Serializable, Comparable {
    public static Point3D SCALE1 = new Point3D(1d, 1d,1d);
    public static final ITexture DEFAULT_TEXTURE = new TextureCol(Colors.random());
    protected static ArrayList<Painter> classPainters = new ArrayList<Painter>();
    public Rotation rotation  = new Rotation();
    protected double NFAST = 100;
    protected RtMatiere materiau;
    protected ITexture CFAST = DEFAULT_TEXTURE;
    protected Barycentre bc = new Barycentre();
    protected Representable parent;
    protected Scene scene;
    protected ITexture texture;
    private String id;
    private Painter painter = null;
    private int RENDERING_DEFAULT = 0;
    protected Render render = Render.getInstance(0, -1);
    protected Point3D scale = SCALE1;
    public Representable() {
        rotation = new Rotation();
        texture = new TextureCol(Colors.random());
    }

    public static void setPaintingActForClass(ZBuffer z, Scene s, PaintingAct pa) {
        Painter p = null;
        classPainters().add(new Painter(z, s, Representable.class));
        p.addAction(pa);
    }

    private static ArrayList<Painter> classPainters() {
        return classPainters;
    }

    public Rotation getRotation() {
        return rotation;
    }
    public Point3D rotate(Point3D p0, Representable ref) {
        if(ref!=null)
            return ref.getRotation().rotation(p0);
        else
            return p0;
    }

    public void setRotation(Rotation r) {
        this.rotation = r;
    }

    public Point3D calculerPoint(Point3D p) {
        return bc.calculer(p);

    }

    public String id() {
        return id;
    }

    public void id(String id) {
        this.id = id;
    }

    public void informer(Representable parent) {
        this.parent = parent;
    }

    public Barycentre position() {
        return bc;
    }

    public void position(Barycentre p) {
        bc = p;
    }

    public void replace(String moo) {
        throw new UnsupportedOperationException("Operation non supportee");
    }

    public void scene(Scene scene) {
        this.scene = scene;

    }


    public boolean supporteTexture() {
        return false;
    }

    public ITexture texture() {
        return this.texture;
    }

    public void texture(ITexture tc) {
        this.texture = tc;
    }


    /***
     * DOn't call ZBuffer dessiine methods here: it would loop.
     *
     * @param z ZBuffer use plot or dessine(P) or tracerTriangle(TRI, Itexture)
     */
    public void drawStructureDrawFast(ZBuffer z) {
        throw new UnsupportedOperationException("No genral method for drawing objects");
    }

    public boolean ISdrawStructureDrawFastIMPLEMENTED(ZBuffer z) {
        return false;
    }

    /**
     * When correctly initialized, PaintingAct action method is called while
     * the shape is rendered.
     *
     * @param z  the actual ZBuffer in which the action should occurs
     * @param s  the scene in which the actions can access to other objects properties.
     *           Optional parameter
     * @param pa The "painting act" (term referring to history of arts).
     */
    public void setPaintingAct(ZBuffer z, Scene s, PaintingAct pa) {
        this.painter = new Painter(z, s, this);
        pa.setObjet(this);
        pa.setScene(s);
        pa.setZBuffer(z);
        painter.addAction(pa);
    }

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

    public void paint() {
        if (getPainter() != null) {
            getPainter().getPaintingAct().paint();
        }
    }

    public Intersects.Intersection intersects(RtRay ray, RtIntersectInfo cii) {
        // TODO Implements
        return null;
    }

    public Representable intersects(Representable r2) {
        throw new UnsupportedOperationException("Pas implémenté  en cours" +
                "");
    }

    public void become(Representable r) {
        if (this.getClass().equals(r.getClass())) {
            set(r);
        }
    }

    private void set(Representable r) {
    }

    /***
     *
     * @param o
     * @return ???
     */
    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Representable))
            return 0;
        else
            return 1;

    }

    public void draw(ZBufferImpl zBuffer) {
    }

    public class RotationInt extends Rotation {

        public RotationInt() {

        }

        public RotationInt(Matrix33 m, Point3D c) {
            rot = m;
            centreRot = c;
        }

    }


    private HashMap<String,StructureMatrix> declaredDataStructure = new HashMap<>();
    public HashMap<String, StructureMatrix> getDeclaredDataStructure() {
        return declaredDataStructure;
    }

    public ITexture getTexture() {
        return texture;
    }

    public void setTexture(ITexture texture) {
        this.texture = texture;
    }

    public Class getPropertyType(String propertyName) throws NoSuchMethodException {
            Method propertyGetter = null;
            propertyGetter = this.getClass().getMethod("get" + ("" + propertyName.charAt(0)).toUpperCase() + (propertyName.length() >1 ? propertyName.substring(1) : ""));
            return propertyGetter.getReturnType();
    }

    public void setProperty(String propertyName, Object value) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method propertySetter = null;

        propertySetter = this.getClass().getMethod("set" + (""+propertyName.charAt(0)).toUpperCase() + (propertyName.substring(1)), value.getClass());
        propertySetter.invoke(this, value);
        System.out.println("RType : " + this.getClass().getName()+" Property: "+ propertyName+" New Value set "+getProperty(propertyName));
    }

    public Object getProperty(String propertyName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method propertySetter = null;
        propertySetter = this.getClass().getMethod("get" + (""+propertyName.charAt(0)).toUpperCase() + propertyName.substring(1));
        return propertySetter.invoke(this);
    }

    public String toString()
    {
        return "Representable()";
    }



    public void declareProperties()
    {
        

    }


    public HashMap<String, Object> declarations(){
        HashMap<String, Object> declarations = new HashMap<>();
        declarations.putAll(getDeclaredDataStructure());
        return declarations;
    }


    public ITexture getCFAST() {
        return CFAST;
    }
    
    public void setCFAST(ITexture CFAST) {
        this.CFAST = CFAST;
    }

    public Point3D getScale() {
        return scale;
    }

    public void setScale(Point3D scale) {
        this.scale = scale;
    }
}

