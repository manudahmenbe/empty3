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

/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core.tribase.equationeditor;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.tribase.TRIObjetGenerateurAbstract;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TRIObjetSurfaceEquationParametrique
        extends TRIObjetGenerateurAbstract {

    AnalyseurEquationJep sx;
    AnalyseurEquationJep sy;
    AnalyseurEquationJep sz;

    /**
     * *
     *
     * @param sx variable : (u,v)
     * @param sy variable : (u,v)
     * @param sz variable : (u,v)
     */
    public TRIObjetSurfaceEquationParametrique(AnalyseurEquationJep sx, AnalyseurEquationJep sy, AnalyseurEquationJep sz) {
        this.sx = sx;
        this.sy = sy;
        this.sz = sz;

        System.out.println(" ( " + sx + " , " + sy + " , " + sz + " ) ");
    }

    public TRIObjetSurfaceEquationParametrique() {
    }

    public Point3D value(double u, double v) {
        sx.setVariable("u", u);
        sy.setVariable("u", u);
        sz.setVariable("u", u);
        sx.setVariable("v", v);
        sy.setVariable("v", v);
        sz.setVariable("v", v);
        return new Point3D(sx.value(), sy.value(), sz.value());
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        return value(1.0 * x / getMaxX(), 1.0 * y / getMaxY());
    }

}
