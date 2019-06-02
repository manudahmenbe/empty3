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

public class TrajectoirePoint implements Trajectoire {

    private Point3D[] points;
    private int ind = 0;
    private double indD = 0;
    private double[] duree;
    private double d = 0.0;
    private int nbrFrames = 0;
    private int FPS = 25;
    private int f = 0;
    private double t = 0;
    private double tDebut;
    private double tFin;

    public TrajectoirePoint(Point3D[] point, double[] duree) {
        this.points = points;
        this.duree = duree;

        for (int i = 0; i < duree.length; i++) {
            d += duree[i];
        }
        nbrFrames = (int) d * FPS;
        indD = duree[0];

    }

    public boolean asuivant() {
        if (ind >= points.length - 1) {
            return false;
        }

        return t <= tFin;
    }

    public int frame() {
        return f;
    }

    public void frame(int f) {
        this.f = f;
    }

    public Point3D point() {
        double dureeEcoulee = t - tDebut;
        if (dureeEcoulee > indD) {
            ind++;
            indD += duree[ind];
        }

        t += 1.0 / FPS;
        indD += 1.0 / FPS;

        return points[ind + 1].mult(indD - t).plus(points[ind].mult(duree[ind] - (indD - t)));
    }

    /**
     * *
     * * DEPRECATED
     */
    public double t() {
        return 0.0;
    }

    /**
     * *
     * * DEPRECATED
     */
    public void t(double t) {

    }

    public double tDebut() {
        return tDebut;
    }

    public void tDebut(double t) {
        this.tDebut = tDebut;
        this.t = tDebut;
    }

    public double tFin() {
        return tDebut;
    }

    public void tFin(double t) {
        this.tFin = tFin;
    }

}
