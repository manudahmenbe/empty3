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

 Vous êtes libre de :

 */
package one.empty3.library;

public class Axe extends Representable{

    private StructureMatrix<Point3D> p1 =  new StructureMatrix<>(0, Point3D.class);
    private StructureMatrix<Point3D> p2 =  new StructureMatrix<>(0, Point3D.class);


    public Axe()
    {
        super();
        p1.setElem(Point3D.Y);
        p2.setElem(Point3D.Y.mult(-1d));
    }

    public Axe(Point3D p1, Point3D p2) {
        this.p1.setElem(p1);
        this.p2.setElem(p2);
    }

    public Point3D getP1() {
        return p1.getElem();
    }

    public void setP1(Point3D p1) {
        this.p1.setElem(p1);
    }

    public Point3D getP2() {
        return p2.getElem();
    }

    public void setP2(Point3D p2) {
        this.p2.setElem(p2);
    }

    public Point3D getVectAxe() {
        return p2.getElem().plus(p1.getElem().mult(-1d));
    }

    public Point3D rotation(double angle, Point3D point) {
        return point;
    }

    public Point3D getCenter() {
        return p1.getElem().plus(p2.getElem()).mult(0.5);
    }

    public Point3D getVector() {
        return p2.getElem().moins(p1.getElem());
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("p1/p1", p1);
        getDeclaredDataStructure().put("p2/p1", p2);

    }

    @Override
    public String toString() {
        return "axis (\np1"+getP1()+"\n"+getP2()+"\n)\n";
    }
}
