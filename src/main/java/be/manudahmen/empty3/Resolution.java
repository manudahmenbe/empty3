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

package be.manudahmen.empty3;

/**
 * @author Se7en
 */
public class Resolution {
    public static final Resolution K4RESOLUTION = new Resolution(1920 * 2, 1080 * 2).makeFinal();
    public static final Resolution HD720RESOLUTION = new Resolution(1600, 720).makeFinal();
    public static final Resolution HD1080RESOLUTION = new Resolution(1920, 1080).makeFinal();
    public static final Resolution XVGARESOLUTION = new Resolution(640, 480).makeFinal();
    private int x;
    private int y;
    private int nbits = 32;
    private boolean aFinal = false;

    public Resolution(int xv, int yv) {
        this.x = xv;
        this.y = yv;

    }

    public void x(int v) {
        if (!isFinal())
            this.x = v;
    }

    public void y(int v) {
        if (!isFinal())
            this.y = v;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public boolean isFinal() {
        return aFinal;
    }

    protected Resolution makeFinal() {
        aFinal = true;
        return this;
    }
}
