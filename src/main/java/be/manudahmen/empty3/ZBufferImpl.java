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

/**
 * *
 * Global license : * GNU GPL v3
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * Creation time 25-oct.-2014 SURFACE D'ÉLASTICITÉ DE FRESNEL Fresnel's
 * elasticity surface, Fresnelsche Elastizitätfläche
 * http://www.mathcurve.com/surfaces/elasticite/elasticite.shtml *
 */
package be.manudahmen.empty3;

import be.manudahmen.empty3.core.HeightMapSurface;
import be.manudahmen.empty3.core.extra.SimpleSphere;
import be.manudahmen.empty3.core.nurbs.ParametricCurve;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;
import be.manudahmen.empty3.core.nurbs.ThickSurface;
import be.manudahmen.empty3.core.tribase.TRIObjetGenerateurAbstract;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Iterator;

/**
 * *
 * Classe de rendu graphique
 */
public class ZBufferImpl extends Representable implements ZBuffer {

    public static final int PERSPECTIVE_ISOM = 0;
    public static final int PERSPECTIVE_OEIL = 1;
    /**
     * Couleur de fond (texture: couleur, image, vidéo, ...
     */
    // DEFINITIONS
    public double INFINI_PROF = Double.MAX_VALUE;
    public int type_perspective = PERSPECTIVE_OEIL;
    protected Point3D planproj = null;
    protected Point3D camera = null;
    protected boolean colorationActive = false;
    protected boolean experimental = true;
    protected double angleX = Math.PI / 3;
    protected double angleY = Math.PI / 3;
    protected ECBufferedImage bi;
    protected ImageMap ime;
    protected int ha;
    protected int la;
    private Point3D INFINI = new Point3D(0, 0, INFINI_PROF);
    private Camera cameraC = new Camera();
    // PARAMETRES
    private float zoom = 1.05f;
    private boolean locked = false;
    private boolean firstRun = true;
    // VARIABLES
    private long idImg = 1;
    private int dimx;
    private int dimy;
    private Point3D[][] Scordinate;
    private int[] Scolor;
    private long[][] Simeid;
    private float[][] Simeprof;
    private Scene currentScene;
    private Box2D box;
    private Point3D activeLight = new Point3D(-10, 0, 100);

    public ZBufferImpl() {
        la = Resolution.K4RESOLUTION.x();
        ha = Resolution.K4RESOLUTION.y();
        dimx = la;
        dimy = ha;
        this.ime = new ImageMap(la, ha);
    }

    public ZBufferImpl(Resolution resolution) {
        this();
        la = resolution.x();
        ha = resolution.y();
        dimx = la;
        dimy = ha;
    }

    public ZBufferImpl(int l, int h) {
        this();
        la = l;
        ha = h;
        dimx = la;
        dimy = ha;
    }

    protected long idImg() {
        return idImg;
    }

    public Point3D activeLight() {
        return activeLight;
    }

    public void activeLight(Point3D l) {
        activeLight = l;
    }

    public Camera camera() {
        return this.scene().cameraActive;
    }

    public void camera(Camera c) {
        this.cameraC = c;
    }


    public Point coordonneesPoint2D(Point3D p) {
        switch (type_perspective) {
            case PERSPECTIVE_ISOM:
                return coordonneesPointEcranIsometrique(
                        coordonneesPoint3D(p));
            case PERSPECTIVE_OEIL:
                return coordonneesPointEcranPerspective(
                        coordonneesPoint3D(p)
                );
            default:
                throw new UnsupportedOperationException(
                        "Type de perspective non reconnu");
        }
    }

    public Point3D coordonneesPoint3D(Point3D p) {
        return scene().cameraActive().calculerPointDansRepere(p);
    }

    protected Point coordonneesPointEcranIsometrique(Point3D p) {
        java.awt.Point p2 = new java.awt.Point(
                (int) (1.0 * la / (box.getMaxx() - box.getMinx()) * (p.getX() - box
                        .getMinx())),
                ha
                        - (int) (1.0 * ha / (box.getMaxy() - box.getMiny()) * (p
                        .getY() - box.getMiny())));
        if (p2.getX() >= 0.0 && p2.getX() < la && p2.getY() >= 0
                && p2.getY() < ha) {
            return p2;
        } else {
            return null;
        }
    }

    public Point coordonneesPointEcranPerspective(Point3D x3d) {

       // if (x3d.getZ() > 0 && -angleX < Math.atan(x3d.getX() / x3d.getZ())
            //    && Math.atan(x3d.getX() / x3d.getZ()) < angleX
              //  && -angleY < Math.atan(x3d.getY() / x3d.getZ())
                //&& Math.atan(x3d.getY() / x3d.getZ()) < angleY) {
            double scale = (1.0 / (x3d.getZ()));
            return new Point((int) (x3d.getX() * scale * la + la / 2),
                    (int) (-x3d.getY() * scale * ha + ha / 2));
        //}
        //return null;
    }

    public void draw() {
        if (firstRun) {
            ime = new ImageMap(la, ha);
            firstRun = false;
        }

        next();

        currentScene.cameraActive().calculerMatrice();

        if (type_perspective == PERSPECTIVE_ISOM) {

            box = new Box2D();

        }
        draw(currentScene, null);
    }

    public void draw(Representable re, Representable refObject) {
        if (re instanceof RepresentableType) {
            try {
                ((RepresentableType) re).draw(this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (re.getPainter() != null) {
            try {
                re.paint();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        Iterator<Representable> it = null;
        // COLLECTION
        if (re instanceof RepresentableConteneur) {
            RepresentableConteneur name = (RepresentableConteneur) re;
            it = name.getListRepresentable().iterator();
            while (it.hasNext()) {
                draw(it.next(), re);
            }
        } else if (re instanceof Scene) {
            Scene scene = (Scene) re;
            it = scene.iterator();
            while (it.hasNext()) {
                draw(it.next(), re);
            }
        } else if (re != null) {
            Representable r = re;

            // GENERATORS
            if (r instanceof ThickSurface) {
                // System.out.println("Surface");
                ThickSurface n = (ThickSurface) r;
                // TODO Dessiner les bords

                for (double u = n.getStartU(); u <= n.getEndU(); u += n.getIncrU()) {
                    //System.out.println("(u,v) = ("+u+","+")");
                    for (double v = n.getStartU(); v <= n.getEndV(); v += n.getIncrV()) {
                        Point3D p1, p2, p3, p4;
                        p1 = n.calculerPoint3D(u, v);
                        p2 = n.calculerPoint3D(u + n.getIncrU(), v);
                        p3 = n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV());
                        p4 = n.calculerPoint3D(u, v + n.getIncrV());
                        tracerQuad(p1, p2, p3, p4, n.texture(), u, u + n.getIncrU(), v, v + n.getIncrV());
                    }
                }
            }
            // GENERATORS
            if (r instanceof ParametricSurface) {
                // System.out.println("Surface");
                ParametricSurface n = (ParametricSurface) r;
                // TODO Dessiner les bords
                for (double u = n.getStartU(); u <= n.getEndU(); u += n.getIncrU()) {
                    //System.out.println("(u,v) = ("+u+","+")");
                    for (double v = n.getStartU(); v <= n.getEndV(); v += n.getIncrV()) {
                /*
                        draw(new TRI(n.calculerPoint3D(u, v),
                                n.calculerPoint3D(u + n.getIncrU(), v),
                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                n.texture()), n);
                        draw(new TRI(n.calculerPoint3D(u, v),
                                n.calculerPoint3D(u, v + n.getIncrV()),
                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                n.texture()), n);
*/
 /*tracerTriangle(n.calculerPoint3D(u, v),
                                n.calculerPoint3D(u + n.getIncrU(), v),
                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                new Color(n.texture().getColorAt(0.5,0.5)));
                        tracerTriangle(n.calculerPoint3D(u, v),
                                n.calculerPoint3D(u, v + n.getIncrV()),
                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                new Color(n.texture().getColorAt(0.5,0.5)));
*//*
                        tracerTriangle(n.calculerPoint3D(u, v),
                                n.calculerPoint3D(u + n.getIncrU(), v),
                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                n.texture());
                        tracerTriangle(n.calculerPoint3D(u, v),
                                n.calculerPoint3D(u, v + n.getIncrV()),
                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                n.texture());

*/
                        /*
                        Point3D[][] point3DS = {{n.calculerPoint3D(u, v),
                                n.calculerPoint3D(u + n.getIncrU(), v)},
                                {n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                        n.calculerPoint3D(u, v + n.getIncrV())}};

                        SurfaceParametricPolygonalBezier surfaceParametriquePolynomialeBezier = new SurfaceParametricPolygonalBezier(point3DS);
                        draw(surfaceParametriquePolynomialeBezier, n);
*/
                        Point3D p1, p2, p3, p4;
                        p1 = n.calculerPoint3D(u, v);
                        p2 = n.calculerPoint3D(u + n.getIncrU(), v);
                        p3 = n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV());
                        p4 = n.calculerPoint3D(u, v + n.getIncrV());
                        if (n instanceof HeightMapSurface) {
                            Point3D n1, n2, n3, n4;
                            HeightMapSurface h = (HeightMapSurface) n;
                            n1 = n.calculerNormale3D(u, v);
                            n2 = n.calculerNormale3D(u + n.getIncrU(), v);
                            n3 = n.calculerNormale3D(u + n.getIncrU(), v + n.getIncrV());
                            n4 = n.calculerNormale3D(u, v + n.getIncrV());
                            p1 = p1.plus(n1.norme1().mult(h.height(u, v)));
                            p2 = p2.plus(n2.norme1().mult(h.height(u + n.getIncrU(), v)));
                            p3 = p3.plus(n3.norme1().mult(h.height(u + n.getIncrU(), v + n.getIncrV())));
                            p4 = p4.plus(n4.norme1().mult(h.height(u, v + n.getIncrV())));
                            tracerQuad(p1, p2, p3, p4, n.texture(), u, u + n.getIncrU(), v, v + n.getIncrV());
                        } else {
                            tracerQuad(p1, p2, p3, p4, n.texture(), u, u + n.getIncrU(), v, v + n.getIncrV());
                        }


/*
                        line(n.calculerPoint3D(u, v),
                                n.calculerPoint3D(u + n.getIncrU(), v),
                                n.texture, u);
                        line(
                            n.calculerPoint3D(u + n.getIncrU(), v),
                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                n.texture, v);
                        line(
                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
                                n.calculerPoint3D(u, v + n.getIncrV()),
                                n.texture, u);
                        line(
                        n.calculerPoint3D(u, v + n.getIncrV()),
                                n.calculerPoint3D(u, v),
                                n.texture, v);
*/

                        //
//
//                        draw(new TRI(n.calculerPoint3D(u, v),
//                                n.calculerPoint3D(u + n.getIncrU(), v),
//                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
//                                n.texture()), n, u, v);
//                        draw(new TRI(n.calculerPoint3D(u, v),
//                                n.calculerPoint3D(u, v + n.getIncrV()),
//                                n.calculerPoint3D(u + n.getIncrU(), v + n.getIncrV()),
//                                n.texture()), n, u, v);
//
                    }

                }
            }
            if (r instanceof TRIGenerable) {
                r = ((TRIGenerable) r).generate();
            } else if (r instanceof PGenerator) {
                r = ((PGenerator) r).generatePO();
            }
            if (r instanceof TRIConteneur) {
                r = ((TRIConteneur) r).getObj();
            }

            // OBJETS
            if (r instanceof TRIObject) {
                TRIObject o = (TRIObject) r;
                Iterator<TRI> ts = o.triangles().iterator();
                while (ts.hasNext()) {
                    // System.out.println("Triangle suivant");

                    TRI t = ts.next();
                    tracerTriangle(r.rotation(t.getSommet()[0]),
                            r.rotation(t.getSommet()[1]), r.rotation(t.getSommet()[2]),
                            t.texture());

                }
            } else if (r instanceof Point3D) {
                Point3D p = (Point3D) r;
                ime.testDeep(p, r.texture());
            } else if (r instanceof SegmentDroite) {
                SegmentDroite s = (SegmentDroite) r;
                Point3D pO = refObject == null ? s.getOrigine() : refObject.rotation(s.getOrigine());
                Point3D pE = refObject == null ? s.getExtremite() : refObject.rotation(s.getExtremite());
                line(pO, pE, s.texture());
            } else if (r instanceof BSpline) {
                BSpline b = (BSpline) r;
                int nt = 100;
                for (double i = 0; i < nt; i++) {
                    try {
                        Point3D p3d = b
                                .calculerPoint3D(3.0 + 1.0 * nt / 200);
                        ime.testDeep(p3d, b.texture().getColorAt(0.5, 0.5));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (r instanceof BezierCubique) {
                BezierCubique b = (BezierCubique) r;
                int nt = largeur() / 10;
                Point3D p0 = b.calculerPoint3D(0.0);
                for (double t = 0; t < 1.0; t += 1.0 / nt) {
                    try {
                        Point3D p1 = b.calculerPoint3D(t);
                        line(p0, p1, b.texture());
                        p0 = p1;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (r instanceof BezierCubique2D) {
                BezierCubique2D b = (BezierCubique2D) r;
                int i1 = BezierCubique2D.DIM1, i2 = BezierCubique2D.DIM2;
                for (int i = 0; i < i1; i++) {
                    for (int j = 0; j < i2; j++) {
                        draw(new Polygon(
                                new Point3D[]{
                                        r.rotation(b.calculerPoint3D((i - 1 < 0 ? 0
                                                : i - 1) * 1d / i1, (j) * 1d
                                                / i2)),
                                        r.rotation(b.calculerPoint3D((i) * 1d / i1, (j)
                                                * 1d / i2)),
                                        r.rotation(b.calculerPoint3D((i) * 1d / i1,
                                                (j - 1 < 0 ? 0 : j - 1) * 1d
                                                        / i2)),
                                        r.rotation(b.calculerPoint3D((i - 1 < 0 ? 0
                                                        : i - 1) * 1d / i1,
                                                (j - 1 < 0 ? 0 : j - 1) * 1d
                                                        / i2))}, new TextureCol(
                                b.getColor(i1, i2, 1.0d * i / i1, 1.d
                                        * j / i2))), r);
                    }
                }
            } else if (r instanceof PObjet) {
                PObjet b = (PObjet) r;
                for (Point3D p : b.getPoints()) {
                    {
                        ime.testDeep(r.rotation(p), p.texture());
                    }
                }
            } else if (r instanceof POConteneur) {
                POConteneur c = (POConteneur) r;
                for (Point3D p : c.iterable()) {
                    {
                        ime.testDeep(r.rotation(p), p.texture());
                    }
                }
            } else if (r instanceof TRIConteneur) {
                for (TRI t : ((TRIConteneur) r).iterable()) {
                    {
                        tracerTriangle(r.rotation(t.getSommet()[0]),
                                r.rotation(t.getSommet()[1]),
                                r.rotation(t.getSommet()[2]),
                                t.texture());
                    }
                }

            } else if (r instanceof TRIObjetGenerateurAbstract) {
                TRIObjetGenerateurAbstract to = (TRIObjetGenerateurAbstract) r;

                to.draw(this);
            } else if (r instanceof PGeneratorZ) {
                PGeneratorZ p = (PGeneratorZ) r;
                p.generate(this);
                p.dessine(this);
            } else if (r instanceof ParametricCurve) {
                //System.out.println("Curve");
                ParametricCurve n = (ParametricCurve) r;
                double incr = n.getIncrU();
                for (double i = n.start(); i <= n.endU(); i += n.getIncrU()) {
                    if (n.isConnected()) {
                        line(n.calculerPoint3D(i), n.calculerPoint3D(i + incr),
                                n.texture());
                    } else {
                        ime.testDeep(n.calculerPoint3D(i), n.texture);
                    }
                    // System.out
                    // .print("+"+n.calculerPoint3D(i).toString());
                }

            }

        }

    }


    public double distanceCamera(Point3D x3d) {
        switch (type_perspective) {
            case PERSPECTIVE_ISOM:
                return x3d.getZ() - scene().cameraActive.eye.getZ();
            case PERSPECTIVE_OEIL:
                return x3d.moins(scene().cameraActive().eye()).norme();
            default:
                throw new UnsupportedOperationException(
                        "Type de perspective non reconnu");
        }

    }

    public double echelleEcran() {
        return box.echelleEcran();
    }

    public int getColorAt(Point p) {
        if (ime.getIME().getElementProf((int) p.getX(), (int) p.getY()) >= INFINI_PROF) {
            return ime.getIME().getElementCouleur((int) p.getX(),
                    (int) p.getY());
        } else {
            return Color.TRANSLUCENT;
        }
    }

    public int[] getData() {
        return Scolor;
    }

    public ZBuffer getInstance(int x, int y) {
        return new ZBufferImpl(x, y);
    }


    /**
     * @return hauteur du zbuffer
     */
    public int hauteur() {
        return ha;
    }

    public ECBufferedImage image() {
        ECBufferedImage bi2 = new ECBufferedImage(la, ha,
                ECBufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < la; i++) {
            for (int j = 0; j < ha; j++) {
                int elementCouleur = ime.ime.getElementCouleur(i, j);
                bi2.setRGB(i, j, elementCouleur);

            }
        }
        System.out.print("+");
        this.bi = bi2;
        return bi2;

    }

    public ECBufferedImage image2() {
        BufferedImage bi = new BufferedImage(la, ha, BufferedImage.TYPE_INT_RGB);
        bi.setRGB(0, 0, la, ha, getData(), 0, la);
        return new ECBufferedImage(bi);
    }

    public boolean isLocked() {
        return locked;
    }

    public void isobox(boolean isBox) {
    }

    public void isometrique() {
        type_perspective = PERSPECTIVE_ISOM;
    }

    /**
     * @return largeur du zbuffer
     */
    public int largeur() {
        return la;
    }


    @Override
    /**
     * @param p1 premier point
     * @param p2 second point
     * @param t  couleur de la line
     */
    public void line(Point3D p1, Point3D p2, ITexture t) {
        Point x1 = coordonneesPoint2D(p1);
        Point x2 = coordonneesPoint2D(p2);
        if (x1 == null || x2 == null) {
            return;
        }
        Point3D n = p1.moins(p2).norme1();
        double itere = Math.max(Math.abs(x1.getX() - x2.getX()),
                Math.abs(x1.getY() - x2.getY())) * 4 + 1;
        for (int i = 0; i < itere; i++) {
            Point3D p = p1.plus(p2.moins(p1).mult(i/itere));
            p.texture(t);
            ime.testDeep(p, t);
        }

    }

    public boolean lock() {
        if (locked) {
            return false;
        }
        locked = true;
        return true;
    }

    public Lumiere lumiereActive() {
        return currentScene.lumiereActive();
    }

    public double[][] map() {
        double[][] Map = new double[la][ha];
        for (int i = 0; i < la; i++) {
            for (int j = 0; j < ha; j++) {
                if (ime.getIME().getElementPoint(i, j) != null) {
                    Map[i][j] = ime.getIME().getElementPoint(i, j).getZ();
                } else {
                    Map[i][j] = INFINI_PROF;
                }
            }
        }
        return Map;

    }

    private double maxDistance(Point p1, Point p2, Point p3) {
        return Math.max(
                Math.max(Point.distance(p1.x, p1.y, p2.x, p2.y),
                        Point.distance(p2.x, p2.y, p3.x, p3.y)),
                Point.distance(p3.x, p3.y, p1.x, p1.y));
    }

    private double maxDistance(Point p1, Point p2, Point p3, Point p4) {
        return Math.max(Math.max(
                Math.max(Point.distance(p1.x, p1.y, p2.x, p2.y),
                        Point.distance(p2.x, p2.y, p3.x, p3.y)),
                Point.distance(p3.x, p3.y, p4.x, p4.y)),
                Point.distance(p4.x, p4.y, p1.x, p1.y));
    }

    public void perspective() {
        type_perspective = PERSPECTIVE_OEIL;
    }

    public void plotPoint(Color color, Point3D p) {
        if (p != null && color != null) {
            ime.testDeep(p, color.getRGB());
        }

    }

    public void plotPoint(Point3D p) {
        if (p != null && p.texture() != null) {
            ime.dessine(p, p.texture());
        }
    }

    public void plotPoint(Point3D p, Color c) {
        if (p != null && c != null) {
            ime.dessine(p, c);
        }
    }

    public Image rendu() {
        return null;
    }

    public int resX() {
        return dimx;
    }

    public int resY() {
        return dimy;
    }

    public Scene scene() {
        return currentScene;
    }

    public void scene(Scene s) {
        this.currentScene = s;
    }

    public void setAngles(double angleXRad, double angleYRad) {
        this.angleX = angleXRad;
        this.angleY = angleYRad;
    }

    @Deprecated
    public void setColoration(boolean a) {
        this.colorationActive = a;
    }

    public void next() {
        if (texture() instanceof TextureMov) {
                ((TextureMov) texture()).nextFrame();
        }
        idImg++;
    }

    @Override
    public void testDeep(Point3D p, Color c) {

        ime.testDeep(p, c);
    }

    @Override
    public void testDeep(Point3D p, int c) {
        ime.testDeep(p, c);

    }

    public void testDeep(Point3D p) {
        if (p != null && p.texture() != null) {
            ime.testDeep(p, p.texture());
        }
    }

    public void testPoint(Point3D p, Color c) {
        int cc = c.getRGB();

        if (scene().lumiereActive() != null) {
            cc = scene().lumiereActive().getCouleur(
                    c.getRGB(), p, p.getNormale());
        }
        ime.testDeep(p, cc);
    }

    private void tracerAretes(Point3D point3d, Point3D point3d2, Color c) {
        Point p1 = coordonneesPoint2D(point3d);
        Point p2 = coordonneesPoint2D(point3d2);
        if (p1 == null || p2 == null) {
            return;
        }
        double iteres = Math.abs(p1.getX() - p2.getX())
                + Math.abs(p1.getY() - p2.getY() + 1);
        for (double a = 0; a < 1.0; a += 1 / iteres) {
            Point pp = new Point(p1);
            Point3D p = point3d.mult(a).plus(point3d2.mult(1 - a));
            pp.setLocation(p1.getX() + (int) (a * (p2.getX() - p1.getX())),
                    p1.getY() + (int) (a * (p2.getY() - p1.getY())));
            ime.testDeep(p, c.getRGB());

        }

    }

    public void tracerLumineux() {
        throw new UnsupportedOperationException("Not supported yet."); // To
        // change
        // body
        // of
        // generated
        // methods,
        // choose
        // Tools
        // |
        // Templates.
    }

    public void tracerTriangle(Point3D pp1, Point3D pp2, Point3D pp3, Color c) {
        Point p1 = coordonneesPoint2D(pp1);
        Point p2 = coordonneesPoint2D(pp2);
        Point p3 = coordonneesPoint2D(pp3);
        if (p1 == null || p2 == null || p3 == null) {
            return;
        }
        double iteres1 = 1.0 / (Math.abs(p1.getX() - p2.getX()) + Math.abs(p1
                .getY() - p2.getY()));
        for (double a = 0; a < 1.0; a += iteres1) {
            Point3D p3d = pp1.plus(pp1.mult(-1).plus(pp2).mult(a));
            Point pp = coordonneesPoint2D(p3d);
            double iteres2 = 1.0 / (Math.abs(pp.getX() - p3.getX()) + Math
                    .abs(pp.getY() - p3.getY()));
            for (double b = 0; b < 1.0; b += iteres2) {
                Point3D p = p3d.plus(p3d.mult(-1).plus(pp3).mult(b));
                // Point p22 = coordonneesPoint2D(p);
                ime.testDeep(p, c.getRGB());
            }
        }
    }

    public void tracerQuad(Point3D pp1, Point3D pp2, Point3D pp3, Point3D pp4, ITexture texture,
                           double u0, double u1, double v0, double v1) {
        Point p1, p2, p3, p4;
        p1 = coordonneesPoint2D(pp1);
        p2 = coordonneesPoint2D(pp2);
        p3 = coordonneesPoint2D(pp3);
        p4 = coordonneesPoint2D(pp4);

        TRI triBas = new TRI(pp1, pp2, pp3, texture);
        if (p1 == null || p2 == null || p3 == null) {
            return;
        }
        Point3D normale = triBas.normale();
        double inter = 1.0 / (maxDistance(p1, p2, p3, p4) + 1) / 3;
        for (double a = 0; a < 1.0; a += inter) {
            Point3D pElevation1 = pp1.plus(pp1.mult(-1).plus(pp2).mult(a));
            Point3D pElevation2 = pp4.plus(pp4.mult(-1).plus(pp3).mult(a));
            for (double b = 0; b < 1.0; b += inter) {
                Point3D pFinal = (
                        pElevation1.plus(pElevation1
                                .mult(-1).plus(pElevation2).mult(b)
                        )
                );
                pFinal.setNormale(normale);
                /*System.out.print("u:"+(
                                u0 + (u1 - u0) * a
                        )+", v:"+(
                        v0 + (v1 - v0) * b

                        )+"\n");*/
                pFinal.texture(texture);
                ime.testDeep(pFinal, texture.getColorAt(u0 + (u1 - u0) * a,
                        v0 + (v1 - v0) * b));
            }
        }
    }


    public void tracerTriangle(Point3D pp1, Point3D pp2, Point3D pp3,
                               ITexture c) {
        Point p1, p2, p3;
        p1 = coordonneesPoint2D(pp1);
        p2 = coordonneesPoint2D(pp2);
        p3 = coordonneesPoint2D(pp3);

        Point3D n = (pp3.moins(pp1)).prodVect(pp2.moins(pp1)).norme1();

        if (p1 == null || p2 == null || p3 == null) {
            return;
        }
        double iteres1 = 1.0 / (maxDistance(p1, p2, p3) + 1) / 3;
        for (double a = 0; a < 1.0; a += iteres1) {
            Point3D p3d = pp1.plus(pp1.mult(-1).plus(pp2).mult(a));
            double iteres2 = 1.0 / maxDistance(p1, p2, p3) / 3;
            for (double b = 0; b < 1.0; b += iteres2) {
                Point3D p = p3d.plus(p3d.mult(-1).plus(pp3).mult(b));
                p.setNormale(n);
                ime.testDeep(p, n, c.getColorAt(a, b));
            }
        }
    }

    public boolean unlock() {
        if (!locked) {
            return false;
        }
        locked = false;
        return true;
    }

    public void zoom(float z) {
        if (z > 0) {
            zoom = z;
        }
    }

    @Override
    public ITexture backgroundTexture() {
        return texture();
    }

    public void couleurDeFond(ITexture couleurFond) {
    }

    public void backgroundTexture(ITexture texture) {
        if (texture != null) {
            texture(texture);
            applyTex();
        }
    }

    public void applyTex() {
        if (texture instanceof TextureMov) {
            for (int i = 0; i < la; i++) {
                for (int j = 0; j < ha; j++) {
                    ime.ime.setElementCouleur(
                            i,
                            j,
                            texture()
                                    .getColorAt(1.0 * i / la, 1.0 * j / ha));
                }
            }
        }
    }

    public class Box2D {

        private double minx = 1000000;
        private double miny = 1000000;
        private double minz = 1000000;
        private double maxx = -1000000;
        private double maxy = -1000000;
        private double maxz = -1000000;
        private boolean notests = false;

        public Box2D() {
            SceneCadre cadre = currentScene.getCadre();
            if (cadre.isCadre()) {
                for (int i = 0; i < 4; i++) {
                    if (cadre.get(i) != null) {
                        test(cadre.get(i));
                    }
                }
                /*
                 * if (!cadre.isExterieur()) { notests = true; }
                 */
            }

            if (!notests) {
                Iterator<Representable> it = currentScene.iterator();
                while (it.hasNext()) {
                    Representable r = it.next();
                    // GENERATORS
                    if (r instanceof TRIGenerable) {
                        r = ((TRIGenerable) r).generate();
                    } else if (r instanceof PGenerator) {
                        r = ((PGenerator) r).generatePO();
                    } else if (r instanceof TRIConteneur) {
                        r = ((TRIConteneur) r).getObj();
                    }
                    // OBJETS
                    if (r instanceof TRIObject) {
                        TRIObject o = (TRIObject) r;
                        Iterator<TRI> ts = o.triangles().iterator();
                        while (ts.hasNext()) {
                            TRI t = ts.next();
                            for (Point3D p : t.getSommet()) {
                                test(p);
                            }
                        }
                    } else if (r instanceof Point3D) {
                        Point3D p = (Point3D) r;
                        test(p);
                    } else if (r instanceof SegmentDroite) {
                        SegmentDroite p = (SegmentDroite) r;
                        test(p.getOrigine());
                        test(p.getExtremite());
                    } else if (r instanceof TRI) {
                        TRI t = (TRI) r;
                        test(t.getSommet()[0]);
                        test(t.getSommet()[1]);
                        test(t.getSommet()[2]);
                    } else if (r instanceof BSpline) {
                        BSpline b = (BSpline) r;
                        Iterator<Point3D> ts = b.iterator();
                        while (ts.hasNext()) {
                            Point3D p = ts.next();
                            test(p);
                        }
                    } else if (r instanceof BezierCubique) {
                        BezierCubique b = (BezierCubique) r;
                        Iterator<Point3D> ts = b.iterator();
                        while (ts.hasNext()) {
                            Point3D p = ts.next();
                            test(p);
                        }
                    } else if (r instanceof BezierCubique2D) {
                        BezierCubique2D b = (BezierCubique2D) r;
                        for (int i = 0; i < 4; i++) {
                            for (int j = 0; j < 4; j++) {
                                Point3D p = b.getControle(i, j);
                                test(p);
                            }
                        }
                    } else if (r instanceof POConteneur) {
                        for (Point3D p : ((POConteneur) r).iterable()) {
                            test(p);
                        }

                    } else if (r instanceof PObjet) {
                        for (Point3D p : ((PObjet) r).iterable()) {
                            test(p);
                        }

                    } else if (r instanceof SimpleSphere) {
                        test(((SimpleSphere) r).CoordPoint(0, 0));
                        test(((SimpleSphere) r).CoordPoint(Math.PI, 0));
                        test(((SimpleSphere) r).CoordPoint(0, Math.PI));
                        test(((SimpleSphere) r).CoordPoint(Math.PI, Math.PI));
                    } else if (r instanceof TRIObjetGenerateurAbstract) {
                        TRIObjetGenerateurAbstract t = (TRIObjetGenerateurAbstract) r;
                        TRI[] ts = new TRI[2];
                        ts[0] = new TRI(INFINI, INFINI, INFINI);
                        ts[1] = new TRI(INFINI, INFINI, INFINI);
                        for (int x = 0; x < t.getMaxX() - 1; x++) {
                            for (int y = 0; y < t.getMaxY() - 1; y++) {
                                t.getTris(x, y, ts);
                                for (int i = 0; i < 2; i++) {
                                    for (int j = 0; j < 3; j++) {
                                        test(ts[i].getSommet()[j]);
                                    }
                                }
                            }
                        }

                    } else if (r instanceof RepresentableConteneur) {
                        throw new UnsupportedOperationException(
                                "Conteneur non supporté");
                    }
                }
            }
            // Adapter en fonction du ratio largeur/hauteur
            double ratioEcran = 1.0 * la / ha;
            double ratioBox = (maxx - minx) / (maxy - miny);
            double minx2 = minx, miny2 = miny, maxx2 = maxx, maxy2 = maxy;
            if (ratioEcran > ratioBox) {
                // Ajouter des points en x
                minx2 = minx - (1 / ratioBox * ratioEcran / 2) * (maxx - minx);
                maxx2 = maxx + (1 / ratioBox * ratioEcran / 2) * (maxx - minx);
            } else if (ratioEcran < ratioBox) {
                // Ajouter des points en y
                miny2 = miny - (ratioBox / ratioEcran / 2) * (maxy - miny);
                maxy2 = maxy + (ratioBox / ratioEcran / 2) * (maxy - miny);

            }
            minx = minx2;
            miny = miny2;
            maxx = maxx2;
            maxy = maxy2;

            double ajuste = zoom - 1.0;
            minx2 = minx - ajuste * (maxx - minx);
            miny2 = miny - ajuste * (maxy - miny);
            maxx2 = maxx + ajuste * (maxx - minx);
            maxy2 = maxy + ajuste * (maxy - miny);
            minx = minx2;
            miny = miny2;
            maxx = maxx2;
            maxy = maxy2;

        }

        public boolean checkPoint(Point3D p) {
            return p.getX() > minx & p.getX() < maxx & p.getY() > miny
                    & p.getY() < maxy;
        }

        public double echelleEcran() {
            return (box.getMaxx() - box.getMinx()) / la;
        }

        public double getMaxx() {
            return maxx;
        }

        public void setMaxx(double maxx) {
            this.maxx = maxx;
        }

        public double getMaxy() {
            return maxy;
        }

        public void setMaxy(double maxy) {
            this.maxy = maxy;
        }

        public double getMaxz() {
            return maxz;
        }

        public void setMaxz(double maxz) {
            this.maxz = maxz;
        }

        public double getMinx() {
            return minx;
        }

        public void setMinx(double minx) {
            this.minx = minx;
        }

        public double getMiny() {
            return miny;
        }

        public void setMiny(double miny) {
            this.miny = miny;
        }

        public double getMinz() {
            return minz;
        }

        public void setMinz(double minz) {
            this.minz = minz;
        }

        public Rectangle rectangle() {
            return new Rectangle((int) minx, (int) miny, (int) maxx, (int) maxy);
        }

        private void test(Point3D p) {
            if (p.getX() < minx) {
                minx = p.getX();
            }
            if (p.getY() < miny) {
                miny = p.getY();
            }
            if (p.getZ() < minz) {
                minz = p.getZ();
            }
            if (p.getX() > maxx) {
                maxx = p.getX();
            }
            if (p.getY() > maxy) {
                maxy = p.getY();
            }
            if (p.getZ() > maxz) {
                maxz = p.getZ();
            }

        }
    }

    public class Box2DPerspective {

        public float d = -10.0f;
        public float w = 10.0f;
        public float h = w * la / ha;

        /**
         * @param scene
         */
        public Box2DPerspective(Scene scene) {
        }
    }

    public class ImageMap {

        protected ImageMapElement ime;

        public ImageMap(int x, int y) {
            dimx = x;
            dimy = y;
            ime = new ImageMapElement();
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    ime.setElementID(x, y, idImg);
                    ime.setElementPoint(x, y, INFINI);
                    ime.setElementCouleur(x, y, 0);
                }
            }
        }

        public void dessine(Point3D x3d, Color c) {
            Point ce = coordonneesPoint2D(x3d);
            if (ce == null) {
                return;
            }
            double prof = -1000;
            int x = (int) ce.getX();
            int y = (int) ce.getY();
            if (x >= 0 & x < la & y >= 0 & y < ha && c.getAlpha() == 255) {
                ime.setElementID(x, y, idImg);
                ime.setElementPoint(x, y, x3d);
                ime.setElementCouleur(x, y, c.getRGB());
                ime.setDeep(x, y, prof);
            }
        }

        public int getDimx() {
            return dimx;
        }

        public int getDimy() {
            return dimy;
        }

        public ImageMapElement getIME() {
            return ime;
        }


        public void reinit() {
            idImg++;
        }

        /*
         * private boolean checkCoordinates(int x, int y) { if (x >= 0 & x < la
         * & y >= 0 & y < ha) { return true; } return false; }
         */
        public void setIME(int x, int y) {
            ime.setElementID(x, y, idImg);
        }

        public void testDeep(Point3D x3d, int c) {
            if (x3d == null)
                return;
            int cc = c;
            Point ce = coordonneesPoint2D(x3d);
            if (ce == null)
                return;
            double deep = distanceCamera(x3d);

            int x = (int) ce.getX();
            int y = (int) ce.getY();
            if (x >= 0
                    & x < la
                    & y >= 0
                    & y < ha
                    && (deep < ime.getElementProf(x, y) /*|| ime.getElementID(x,
                    y) != idImg*/) /*&& (((cc>>24)&0xff) == 0)*/) {
                ime.setElementID(x, y, idImg);
                ime.setElementPoint(x, y, x3d);
                if (scene().lumiereActive() != null) {
                    cc = scene().lumiereTotaleCouleur(c,
                            x3d,
                            x3d.getNormale());

                }

                ime.setElementCouleur(x, y, cc);
                ime.setDeep(x, y, deep);
                ime.setElementPoint(x, y, x3d);
            }
        }


        public void testDeep(Point3D p, Point3D n, Color c) {
            // Color cc = c.getCouleur();
            p.setNormale(n);
            testDeep(p, c.getRGB());
        }

        public void testDeep(Point3D p, Point3D n, int c) {
            testDeep(p, n, new Color(c));
        }

        public void testDeep(Point3D p, ITexture texture) {
            testDeep(p, texture.getColorAt(0.5, 0.5));

        }

        public void dessine(Point3D p, ITexture texture) {
            dessine(p, new Color(texture.getColorAt(0.5, 0.5)));

        }

        public void testDeep(Point3D p) {
            testDeep(p, p.texture());
        }

        public void testDeep(Point3D p, Color c) {
            testDeep(p, p.getNormale(), c);
        }
    }

    public class ImageMapElement {

        protected int couleur_fond_int = -1;
        private ImageMapElement instance;

        public ImageMapElement() {
            Scordinate = new Point3D[la][ha];
            Scolor = new int[la * ha];
            Simeid = new long[la][ha];
            Simeprof = new float[la][ha];

            for (int i = 0; i < la; i++) {
                for (int j = 0; j < ha; j++) {
                    Simeprof[i][j] = (float) INFINI.getZ();
                    Simeid[i][j] = idImg;
                    Scolor[j * la + i] = COULEUR_FOND_INT(i, j);

                }
            }
        }

        public boolean checkCordinates(int x, int y) {
            return x >= 0 && x < resX() && y >= 0 && y < resY();
        }

        public int COULEUR_FOND_INT(int x, int y) {
            couleur_fond_int = texture().getColorAt(
                    1.0 * x / largeur(), 1.0 * y / hauteur());
            return couleur_fond_int;
        }

        public int getElementCouleur(int x, int y) {
            if (checkCordinates(x, y) && Simeid[x][y] == idImg() && Simeprof[x][y] < INFINI.getZ()) {
                return getRGBInt(Scolor, x, y);
            } else {
                return COULEUR_FOND_INT(x, y);
            }
        }

        public long getElementID(int x, int y) {
            if (checkCordinates(x, y)) {
                return Simeid[x][y];
            } else {
                return -1;
            }
        }

        public Point3D getElementPoint(int x, int y) {
            if (checkCordinates(x, y) && Simeid[x][y] == idImg) {
                return Scordinate[x][y];
            } else {
                return INFINI;
            }
        }

        private double getElementProf(int x, int y) {
            if (checkCordinates(x, y) && Simeid[x][y] == idImg) {
                return Simeprof[x][y];
            } else {
                return INFINI_PROF;
            }
        }


        public ImageMapElement getInstance(int x, int y) {
            if (instance == null) {
                instance = new ImageMapElement();
            }
            return instance;
        }

        private int getRGBInt(int[] sc, int x, int y) {
            return sc[x + y * la];

        }

        public void setElementCouleur(int x, int y, int pc) {

            if (checkCordinates(x, y)) {
                setElementID(x, y, idImg);
                setRGBInts(pc, Scolor, x, y);
            }
        }

        public void setElementID(int x, int y, long id) {
            if (checkCordinates(x, y)) {
                Simeid[x][y] = idImg;
            }
        }

        public void setElementPoint(int x, int y, Point3D px) {
            if (checkCordinates(x, y)) {
                setElementID(x, y, idImg);
                Scordinate[x][y] = px;
            }
        }


        private void setDeep(int x, int y, double d) {
            if (checkCordinates(x, y)) {
                Simeprof[x][y] = (float) d;
            }
        }

        private void setRGBInts(int rgb, int[] sc, int x, int y) {
            sc[x + y * la] = rgb;
        }
    }

}
