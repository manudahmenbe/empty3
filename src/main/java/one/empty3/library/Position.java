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

public class Position extends Representable {

    public Point3D position = Point3D.O0;
    public Matrix33 rotation = Matrix33.I;
    public double agrandissement = 1.0;

    public Position() {
    }

    public Point3D calculer(Point3D p0) {
        if (p0 == null) {
            System.err.println("Erreur de positionnement p0==null");
        }
        Point3D res = p0;
        if (position != null) {
            res = res.plus(position);
        }
        if (rotation != null) {
            res = rotation.mult(res);
        }
        if (agrandissement != 1d && position != null) {
            res = position.plus(res.moins(position).mult(agrandissement));
        }
        return res;
    }

    @Override
    public String toString() {
        return "position (\t\t@ " + position.toString()
                + "\t\t* " + rotation.toString()
                + "\t\t*" + agrandissement
                + " \t)\n";
    }
}
