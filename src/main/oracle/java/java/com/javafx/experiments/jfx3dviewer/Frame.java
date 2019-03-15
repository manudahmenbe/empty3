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
package com.javafx.experiments.jfx3dviewer;

import javafx.util.Duration;

public class Frame extends Duration {

    static double FPS = 24.0;

    // Experimentally trying to land the frames on whole frame values
    // Duration is still double, but internally, in Animation/Timeline,
    // the time is discrete.  6000 units per second.
    // Without this EPSILON, the frames might not land on whole frame values.
    // 0.000001f seems to work for now
    // 0.0000001f was too small on a trial run
    static double EPSILON = 0.000001;

    // static double EPSILON = 0.0;

    Frame(double millis) {
        super(millis);
    }

    public static Duration frame(int frame) {
        return Duration.seconds(frame / FPS + EPSILON);
    }

    public static Duration frame(long frame) {
        return Duration.seconds(frame / FPS + EPSILON);
    }

    public static long toFrame(Duration tion) {
        return Math.round(tion.toSeconds() * FPS);
    }

    public static int toFrameAsInt(Duration tion) {
        return (int) Math.round(tion.toSeconds() * FPS);
    }

    public static double toFrameAsDouble(Duration tion) {
        return (tion.toSeconds() * FPS);
    }
}

