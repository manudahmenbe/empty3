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
package be.manudahmen.empty3;

/**
 * @author Atelier
 */
public class Camera3D extends Camera {

    /**
     *
     */
    private static final long serialVersionUID = 1907724549670145492L;
    protected Camera cGauche;
    protected Camera cDroite;
    double d = 1;
    private double angle3D = Math.PI / 360 * 20;
    private boolean enable = true;
    private Point3D ccg;
    private Point3D ccd;
    private double dist3D;

    public Camera3D(Point3D camera, Point3D lookAt, double dist3D) {
        enable3D();
        d = camera.moins(lookAt).norme();

        configure(dist3D);

        cGauche = new Camera(camera, lookAt);
        cDroite = new Camera(camera, lookAt);

        store();
    }

    public double angle3D() {
        return angle3D;
    }

    public void angle3D(double angle3D) {
        this.angle3D = angle3D;
    }

    @Override
    public void calculerMatrice() {
        restore();
        /*
         Point3D offsetGauche = cGauche.camera.prodVect(Point3D.Y).norme1()
         .mult(d * Math.atan(angle3D));
         Point3D offsetDroite = cDroite.camera.prodVect(Point3D.Y).norme1()
         .mult(-d * Math.atan(angle3D));
         */
        cGauche.eye = cGauche.eye
                .plus(Point3D.X.mult(-dist3D / 2));
        cDroite.eye = cDroite.eye
                .plus(Point3D.X.mult(dist3D / 2));

        calculerNouveauPoint();

        cGauche.calculerMatrice();
        cDroite.calculerMatrice();

        store();
    }

    protected void calculerNouveauPoint() {
    }

    public Point3D calculerPointDansRepereDROIT(Point3D p) {
        Point3D p2 = cDroite.calculerPointDansRepere(p);
        p2.texture(p.texture());
        return p2;
    }

    public Point3D calculerPointDansRepereGAUCHE(Point3D p) {
        Point3D p2 = cGauche.calculerPointDansRepere(p);
        p2.texture(p.texture());
        return p2;
    }

    public void configure(double dist3D) {
        this.dist3D = dist3D;
    }

    public boolean enable3D() {
        return enable;
    }

    public void enable3D(boolean d3) {
        this.enable = d3;
    }

    public Matrix33 oeilDroite() {
        return null;
    }

    public Matrix33 oeilGauche() {
        return null;
    }

    public Barycentre position() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void restore() {
        cGauche.eye = this.ccg;
        cDroite.eye = this.ccd;

    }

    private void store() {
        this.ccg = cGauche.eye;
        this.ccd = cDroite.eye;

    }

    public TextureCol texture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
