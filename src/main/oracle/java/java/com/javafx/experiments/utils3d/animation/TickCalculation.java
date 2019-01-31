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

package com.javafx.experiments.utils3d.animation;

import javafx.util.Duration;

public class TickCalculation {
    public static final int TICKS_PER_SECOND = 6000;
    private static final double TICKS_PER_MILI = TICKS_PER_SECOND / 1000.0;
    private static final double TICKS_PER_NANO = TICKS_PER_MILI * 1e-6;

    private TickCalculation() {
    }

    public static long add(long op1, long op2) {
        assert (op1 >= 0);

        if (op1 == Long.MAX_VALUE || op2 == Long.MAX_VALUE) {
            return Long.MAX_VALUE;
        } else if (op2 == Long.MIN_VALUE) {
            return 0;
        }

        if (op2 >= 0) {
            final long result = op1 + op2;
            return (result < 0) ? Long.MAX_VALUE : result;
        } else {
            return Math.max(0, op1 + op2);
        }

    }

    public static long sub(long op1, long op2) {
        assert (op1 >= 0);

        if (op1 == Long.MAX_VALUE || op2 == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        } else if (op2 == Long.MAX_VALUE) {
            return 0;
        }

        if (op2 >= 0) {
            return Math.max(0, op1 - op2);
        } else {
            final long result = op1 - op2;
            return result < 0 ? Long.MAX_VALUE : result;
        }

    }

    public static long fromMillis(double millis) {
        return Math.round(TICKS_PER_MILI * millis);
    }

    public static long fromNano(long nano) {
        return Math.round(TICKS_PER_NANO * nano);
    }

    public static long fromDuration(Duration duration) {
        return fromMillis(duration.toMillis());
    }

    public static long fromDuration(Duration duration, double rate) {
        return Math.round(TICKS_PER_MILI * duration.toMillis() / Math.abs(rate));
    }

    public static Duration toDuration(long ticks) {
        return Duration.millis(toMillis(ticks));
    }

    public static double toMillis(long ticks) {
        return ticks / TICKS_PER_MILI;
    }


}
