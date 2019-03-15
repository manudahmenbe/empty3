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

public abstract class MObject {
    final String name;
    MEnv env;

    public String toString() {
        return super.toString() + " MObject.name: " + name;
    }

    public MObject(MEnv env, String name) {
        this.env = env; this.name = name;
    }

    public String getName() {
        return name;
    }

    public MEnv getEnv() {
        return env;
    }

    public abstract void accept(MEnv.Visitor visitor);
}
