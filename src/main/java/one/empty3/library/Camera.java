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
package one.empty3.library;

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
        matrice = Matrix33.I;
    }

    public Camera(Point3D eye, Point3D lookat) {
        this.eye = eye;
        this.lookat = lookat;
        calculerMatrice(null);
    }

    public Camera(Point3D eye, Point3D lookat, Point3D up) {
        this.eye = eye;
        this.lookat = lookat;

        calculerMatrice(up);
    }

    private Point3D calculerVerticaleParDefaut(Point3D moinsZ) {
        Point3D z = moinsZ.mult(-1).norme1();
        return Point3D.Y.prodVect(z).prodVect(Point3D.X).norme1();
    }

    public void setMatrix(Point3D x, Point3D y, Point3D z) {
        Matrix33 m = new Matrix33();

        // Z SORT DE L4ECRAN
        for (int j = 0; j < 3; j++) {
            m.set(j, 2, z.get(j));
        }
        // X HORIZONTALE VERS LA GAUCHE
        for (int j = 0; j < 3; j++) {
            m.set(j, 0, x.get(j));
        }
        // Y VERTICALE VERS LE BAS
        for (int j = 0; j < 3; j++) {
            m.set(j, 1, y.get(j));
        }
        this.matrice = m.tild();
    }

    public void calculerMatrice(Point3D verticale) {
        if (!imposerMatrice) {
            if (verticale == null)
                verticale = calculerVerticaleParDefaut(getLookat().moins(getEye()));


            Point3D z = getLookat().moins(getEye()).norme1();
            Point3D x = z.prodVect(verticale/* Y */).norme1();
            Point3D y = verticale.norme1();

            setMatrix(x, y, z);
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
        calculerMatrice(null);
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
