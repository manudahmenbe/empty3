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
public class Camera extends CameraBox {

    /**
     *
     */
    private static final long serialVersionUID = 2743860672948547944L;

    public static Camera PARDEFAULT = new Camera();

    protected Point3D eye;
    protected Point3D lookat;

    protected boolean imposerMatrice = false;
    protected Matrix33 matrice;

    private Barycentre position;

    public Camera() {
        this.eye = new Point3D(0, 0, -100);
        this.lookat = Point3D.O0;
    }

    public Camera(Point3D camera, Point3D lookat) {
        this.eye = camera;
        this.lookat = lookat;
        calculerMatrice();
    }

    public void calculerMatrice() {
        if (!imposerMatrice) {
            Point3D verticale = Point3D.Y;
            if (getLookat().moins(getEye()).prodVect(verticale).norme() < 0.01) {
                verticale = Point3D.Z;
            }
            if (getLookat().moins(getEye()).prodVect(verticale).norme() < 0.01) {
                verticale = Point3D.X;
            }
            Matrix33 m = new Matrix33();

            Point3D v1 = getLookat().moins(eye).norme1();
            for (int j = 0; j < 3; j++) {
                m.set(j, 2, v1.get(j));
            }
            Point3D v2 = v1.prodVect(verticale).norme1().mult(-1);
            for (int j = 0; j < 3; j++) {
                m.set(j, 0, v2.get(j));
            }
            Point3D v3 = v1.prodVect(v2).norme1();
            for (int j = 0; j < 3; j++) {
                m.set(j, 1, v3.get(j));
            }
            this.matrice = m;
        }
    }

    public Point3D calculerPointDansRepere(Point3D p) {
        Point3D p2 = matrice.mult(p.moins(getEye()));
        p2.texture(p.texture());
        return p2;
    }

    /**
     * @return
     */
    public Point3D eye() {
        return getEye();
    }

    public Point3D getEye() {
        return calculerPoint(eye);
    }

    public void setEye(Point3D eye) {
        this.eye = eye;
    }

    public Point3D getLookat() {
        return calculerPoint(lookat);
    }

    public void setLookat(Point3D lookat) {
        this.lookat = lookat;
    }

    public void imposerMatrice(boolean im) {
        this.imposerMatrice = im;
    }

    public void imposerMatrice(Matrix33 mat) {
        this.imposerMatrice = true;
        this.matrice = mat;
    }

    @Deprecated
    public Point3D pointFocal() {
        return null;
    }

    /**
     * @return Position elements
     */
    @Override
    public Barycentre position() {
        Barycentre position1 = new Barycentre();
        position1.position = getEye();
        position1.rotation = matrice;
        position.agrandissement = 1.0; // Pas encore défini;
        return position1;
    }

    @Override
    public void position(Barycentre p) {
        this.position = p;

        eye = position.calculer(eye);
        lookat = position.calculer(lookat);
        calculerMatrice();
    }

    @Override
    public boolean supporteTexture() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ITexture texture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void texture(ITexture tc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return "camera (\n\t" + eye.toString() + "\n\t" + lookat.toString()
                + "\n\t)";
    }

}
