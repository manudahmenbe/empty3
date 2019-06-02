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
package one.empty3.library.core.tribase;

import one.empty3.library.*;

/**
 * @author Manuel DAHMEN
 */
@Deprecated
public class TourRevolution extends TRIObjetGenerateurAbstract {

    private ApproximationFonction1D ame;
    private ApproximationFonction2D base;
    private Barycentre position;

    public TourRevolution(ApproximationFonction1D ame, ApproximationFonction2D base) {
        this.ame = ame;
        this.base = base;
    }

    @Override
    public Point3D coordPoint3D(int x, int y) {
        // TODO Auto-generated method stub
        return null;
    }

}
