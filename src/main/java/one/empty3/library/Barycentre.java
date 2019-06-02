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

public class Barycentre {

    public Point3D position = Point3D.O0;
    public Matrix33 rotation = Matrix33.I;
    public double agrandissement = 1.0;

    public Barycentre() {
    }

    public Point3D calculer(Point3D p0) {
        Point3D res = p0;

        if (p0 == null) {
            System.err.println("Erreur de positionnement p0==null");
        } else {
            if (agrandissement != 1d) {
                res = p0.moins(position).mult(agrandissement).plus(position);
            }
            if (rotation != Matrix33.I) {
                res = rotation.mult(res.moins(position)).plus(position);
            }
            if (position != null) {
                res = res.plus(position);
            }
            return res;
        }
        return res == null ? p0 : res;
    }

    public String id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "position (\t\t@ " + position.toString()
                + "\t\t* " + rotation.toString()
                + "\t\t*" + agrandissement
                + " \t)\n";
    }
}
