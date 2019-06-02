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

package one.empty3.library.core.tribase;

import one.empty3.library.Point3D;
import one.empty3.library.core.nurbs.ParametricCurve;

public abstract class Chemin extends ParametricCurve {

    private int max = 100;

    /**
     * *
     * Implémentation optionnelle pour l'instant
     *
     * @return Mesure de la longueur du chemin
     */
    public abstract double getLength();

    /**
     * Point d'index i sur Max
     *
     * @param i index
     * @return Point3D point du chemin discret C
     */
    public Point3D getPoint(int i) {
        return calculerPoint3D(1.0 * i / getMax());
    }

    /**
     * @return Nombre de points pour le chemin discret
     */
    public int getMax() {
        return max;
    }

    /**
     * *
     * Définit le nombre maximal de points
     *
     * @param n
     */
    public void setMax(int n) {
        this.max = n;
    }

    /**
     * *
     * Retourne la tangente au point d'index i
     *
     * @param i
     * @return
     */
    public Point3D tangent(int i) {
        if (i < max - 1 && i > 0) {
            return (getPoint(i).moins(getPoint(i - 1)));
        } else if (i == 0) {
            return tangent(i + 1);
        } else if (i == max - 1) {
            return tangent(i - 1);
        } else if (i == max) {
            return tangent(i - 2);
        }
        throw new UnsupportedOperationException("Index non permis: " + i + "." + max);
    }

    /**
     * *
     * Retourne les vecteurs du plan normal au point d'index i
     *
     * @param i
     * @return
     */
    public Point3D normale(int i) {
        Point3D n = Point3D.O0;

        if (i > 0 && i < max - 1) {
            n = tangent(i + 1).moins(tangent(i));
        } else if (i == 0) {
            n = normale(i + 1);
        } else if (i == max - 1) {
            n = normale(i - 1);
        } else if (i == max) {
            n = normale(i - 2);
        } else {
            n = tangent(i).prodVect(Point3D.r(1));
        }
        if (n.norme() == 0 || Double.isNaN(n.norme()))
            return Point3D.Z;
        else
            return n;
        //throw new UnsupportedOperationException("Index non permis: " + i + "." + max);
    }


}
