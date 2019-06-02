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

import java.awt.*;

public class My2DarrayColor {

    private Color[] el;
    private int dimx;
    private int dimy;
    private Color bg;

    public My2DarrayColor(int dimx, int dimy, Color backgroundColor) {
        this.dimx = dimx;
        this.dimy = dimy;
        this.bg = backgroundColor;
        el = new Color[dimx * dimy];
        for (int i = 0; i < dimx * dimy; i++) {
            el[i] = bg;
        }
    }

    public Color getElement(int x, int y) {
        return el[x + dimx * y];
    }

    public Color getElementWC(int x, int y) {
        if (x >= 0 && y >= 0 && x < dimx && y < dimy) {
            return el[x + dimx * y];
        }
        return bg;
    }

    public void setElement(int x, int y, Color c) {
        el[x + dimx * y] = c;
    }

    public void setElementWC(int x, int y, Color c) {
        if (x >= 0 && y >= 0 && x < dimx && y < dimy) {
            el[x + dimx * y] = c;
        }
    }
}
