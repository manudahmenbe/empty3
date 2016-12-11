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

package be.manudahmen.empty3.utils;

public class Angle {
    public static final int NONE = -1;
    public static final int DEG = 1;
    public static final int RAD = 2;
    private double angleRadians = 0;
    private int type = 0;

    public Angle() {
        try {
            valueType(NONE);
        } catch (AngleTypeException e) {
            e.printStackTrace();
        }
    }

    public static Angle degree(double value) throws AngleTypeException {
        Angle ret = new Angle();
        ret.valueRad(value / 2 / Math.PI * 360);
        ret.valueType(DEG);
        return ret;
    }

    public static Angle radian(double value) throws AngleTypeException {
        Angle ret = new Angle();
        ret.valueRad(value);
        ret.valueType(RAD);
        return ret;
    }

    private void valueType(int v) throws AngleTypeException {
        int[] values = (new int[]{NONE, DEG, RAD});
        for (int i = 0; i < values.length; i++) {
            if (values[i] == v) {
                type = v;
                return;
            }
        }
        throw new AngleTypeException("Pas un bon type");
    }

    public Angle convert(int pType) throws AngleTypeException {
        if (pType == type)
            return this;
        if (pType == RAD) {
            valueRad(angleRadians);
            valueType(RAD);
            return this;
        }
        if (pType == DEG) {
            valueRad(angleRadians / 2 / Math.PI * 360);
            valueType(DEG);
            return this;
        }
        return null;
    }

    private void valueRad(double v) {
        this.angleRadians = v;
    }
}
