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
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class ECDim {

    private int dimx;
    private int dimy;

    public ECDim(int dimx, int dimy) {
        this.dimx = dimx;
        this.dimy = dimy;
    }

    public int getDimx() {
        return dimx;
    }

    public void setDimx(int dimx) {
        this.dimx = dimx;
    }

    public int getDimy() {
        return dimy;
    }

    public void setDimy(int dimy) {
        this.dimy = dimy;
    }

    public Dimension getAwt() {
        return new Dimension(getDimx(), getDimy());
    }
}
