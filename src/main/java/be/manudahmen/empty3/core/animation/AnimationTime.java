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
 * Global license : * CC Attribution
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.core.animation;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class AnimationTime {
    protected long temps;
    int fpsDest = 25;

    public AnimationTime(double tempsSecondes) {
        this.temps = (long) (tempsSecondes * 1000.0);
    }

    public AnimationTime(long temps) {
        this.temps = temps;
    }

    public void avanceUneFrame() {
        temps += 1000 / fpsDest;
    }

    public int getFpsDest() {
        return fpsDest;
    }

    public void setFpsDest(int fpsDest) {
        this.fpsDest = fpsDest;
    }

    public long getTemps() {
        return temps;
    }

    public void setTemps(long temps) {
        this.temps = temps;
    }

    public long getTime() {
        return temps;
    }

    public double getTimeInSeconds() {
        return temps / 1000.0;
    }

}
