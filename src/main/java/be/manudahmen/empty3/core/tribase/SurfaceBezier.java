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
package be.manudahmen.empty3.core.tribase;

import be.manudahmen.empty3.BezierCubique2D;
import be.manudahmen.empty3.Point3D;

/**
 * @author DAHMEN Manuel
 *         <p>
 *         dev
 * @date 24-mars-2012
 */
@Deprecated
public class SurfaceBezier extends TRIObjetGenerateurAbstract {

    BezierCubique2D bd = null;

    public SurfaceBezier(BezierCubique2D bd) {
        this.bd = bd;
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        return bd.calculerPoint3D(1.0 * x / getMaxX(), 1.0 * y / getMaxY());
    }

}
