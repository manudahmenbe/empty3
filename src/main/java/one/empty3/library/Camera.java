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
 * @author Manuel Dahmen
 */
public class Camera extends CameraBox {

    /**
     *
     */
    private static final long serialVersionUID = 2743860672948547944L;

    public static Camera PARDEFAULT = new Camera();

    protected StructureMatrix<Point3D> eye = new StructureMatrix<>(0, Point3D.class);
    protected StructureMatrix<Point3D> lookat = new StructureMatrix<>(0, Point3D.class);

    protected StructureMatrix<Boolean> imposerMatrice = new StructureMatrix<>(0, Point3D.class);
    protected StructureMatrix<Matrix33> matrice = new StructureMatrix<>(0, Matrix33.class);

    {

    matrice.setElem(Matrix33.I);
}
    private Barycentre position;

    public Camera() {
        this(new Point3D(0d, 0d, -100d), Point3D.O0, Point3D.Y);
    }

    public Camera(Point3D eye, Point3D lookat) {
        this(eye, lookat, null);
    }

    public Camera(Point3D eye, Point3D lookat, Point3D up) {
        imposerMatrice.setElem(false);
        this.eye.setElem(eye);
        this.lookat.setElem(lookat);
        calculerMatrice(up);

    }

    protected void rotateMatrixXaxis(double angle)
    {
           matrice.setElem(Matrix33.rotationX(angle).mult(matrice.getElem()));
    }
    protected void rotateMatrixYaxis(double angle)
    {
        matrice.setElem(Matrix33.rotationY(angle).mult(matrice.getElem()));

    }
    protected void rotateMatrixZaxis(double angle)
    {
        matrice.setElem(Matrix33.rotationZ(angle).mult(matrice.getElem()));

    }


    protected Point3D calculerVerticaleParDefaut(Point3D senseAxeCamera) {
        Point3D z = senseAxeCamera.norme1();
        return Point3D.Y.prodVect(z).prodVect(z).mult(-1d).norme1();
    }
    protected Point3D calculerHorizontaParDefaut(Point3D senseAxeCamera) {
        Point3D z = senseAxeCamera.norme1();
        return z.prodVect(Point3D.X).prodVect(z).norme1();
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
        this.matrice .setElem(m.tild());
    }

    public void calculerMatrice(Point3D verticale) {
        if (!imposerMatrice.getElem()) {
            if (verticale == null)
                verticale = calculerVerticaleParDefaut(getLookat().moins(getEye()));


            Point3D z = getLookat().moins(getEye()).norme1();
            Point3D x = z.prodVect(verticale/* Y */).norme1();
            Point3D y = verticale;

            setMatrix(x, y, z);
        }
    }

    public Point3D calculerPointDansRepere(Point3D p) {
        Point3D p2 = matrice.getElem().mult(p.moins(getEye()));
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
        return calculerPoint(eye.getElem());
    }

    public void setEye(Point3D eye) {
        this.eye.setElem(eye);
    }

    public Point3D getLookat() {
        return calculerPoint(lookat.getElem());
    }

    public void setLookat(Point3D lookat) {
        this.lookat.setElem(lookat);
    }

    public void imposerMatrice(boolean im) {
        this.imposerMatrice.setElem(im);
    }

    public void imposerMatrice(Matrix33 mat) {
        this.imposerMatrice.setElem(true);
        this.matrice.setElem(mat);
    }


    /**
     * @return Position elements
     */
    @Override
    public Barycentre position() {
        Barycentre position1 = new Barycentre();
        position1.position = getEye();
        position1.rotation = matrice.getElem();
        position.agrandissement = 1.0; // Pas encore défini;
        return position1;
    }

    @Override
    public void position(Barycentre p) {
        this.position = p;

        eye.setElem(position.calculer(eye.getElem()));
        lookat.setElem(position.calculer(lookat.getElem()));
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

    public Matrix33 getMatrice() {
        return matrice.getElem();
    }

    public void setMatrice(Matrix33 matrice) {
        this.matrice.setElem(matrice);
    }

    {
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("eye/eye", eye);
        getDeclaredDataStructure().put("lookat/lookAt", lookat);
        getDeclaredDataStructure().put("matrice/matrice", matrice);

    }
}
