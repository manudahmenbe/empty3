/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */
package com.javafx.experiments.importers.maya;

import javafx.animation.Interpolator;

/**
 * MayaAnimationCurveInterpolator
 * <p/>
 * Interpolator is from javafx.animation
 */
class MayaAnimationCurveInterpolator extends Interpolator {

    float p1Delta;
    float p2Delta;
    boolean zeroDuration;
    public String debug; // hack

    //=========================================================================
    // MayaAnimationCurveInterpolator
    //=========================================================================
    public MayaAnimationCurveInterpolator(
            float p1Delta, float p2Delta,
            boolean zeroDuration) {
        this.p1Delta = p1Delta;
        this.p2Delta = p2Delta;
        this.zeroDuration = zeroDuration;
    }

    //=========================================================================
    // MayaAnimationCurveInterpolator.curve
    //=========================================================================
    public double curve(double t) { return t; }

    //=========================================================================
    // MayaAnimationCurveInterpolator.interpolate
    //=========================================================================
    // [!] API Change
    public double interpolate2(
            double startValue, double endValue,
            double fraction) {
        if (Double.isNaN(fraction)) {
            return startValue;
        }
        if (zeroDuration) {
            return endValue;
        }
        float t = (float) fraction;
        float oneMinusT = 1.0f - t;
        float tSquared = t * t;
        float oneMinusTSquared = oneMinusT * oneMinusT;
        float p0 = (float) startValue;
        float p3 = (float) endValue;
        float p1 = p0 + p1Delta;
        float p2 = p3 + p2Delta;
        float ret = ((oneMinusTSquared * oneMinusT * p0) +
                (3 * oneMinusTSquared * t * p1) +
                (3 * oneMinusT * tSquared * p2) +
                (tSquared * t * p3));

        if (debug != null) {
            // if (DEBUG) System.out.println("interpolate: " + debug + ": " + t + " " + startValue + " to " + endValue + ": "+ret);
        }

        return ret;
    }

    //=========================================================================
    // MayaAnimationCurveInterpolator.interpolate
    //=========================================================================
    // [!] API Change
    public int interpolate2(int startValue, int endValue, double fraction) {
        return (int) interpolate(
                (double) startValue,
                (double) endValue,
                fraction);
    }

    //=========================================================================
    // MayaAnimationCurveInterpolator.interpolate
    //=========================================================================
    // [!] API Change
    public Object interpolate2(Object startValue, Object endValue, double fraction) {
        return interpolate(
                ((Number) startValue).doubleValue(),
                ((Number) endValue).doubleValue(),
                fraction);
    }
}
