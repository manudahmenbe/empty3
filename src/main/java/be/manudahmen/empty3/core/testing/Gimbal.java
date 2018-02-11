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

/***
 * Global license :
 * <p>
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 ***/


package be.manudahmen.empty3.core.testing;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class Gimbal {
    public static final double CIRCLE = 2 * Math.PI;
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    public static final int XYZ = 3;
    private final int dim;
    private double value;

    public Gimbal(int i) {
        this.dim = i;
    }

    public void changeValue(double value) {

        this.value = Math.IEEEremainder(2 * Math.PI, value);

    }

    @Override
    public String toString() {
        return "Gimball (\ndim:" + dim + " val:" + value + "\n)rad\n";
    }


}
