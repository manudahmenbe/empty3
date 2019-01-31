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

import java.util.Comparator;

public class MConnection {
    private MPath sourcePath;
    private MPath targetPath;

    public MConnection(MPath sourcePath, MPath targetPath) {
        this.sourcePath = sourcePath;
        this.targetPath = targetPath;
    }

    public MPath getSourcePath() {
        return sourcePath;
    }

    public MPath getTargetPath() {
        return targetPath;
    }

    public boolean equals(Object arg) {
        if (!(arg instanceof MConnection)) {
            return false;
        }
        MConnection other = (MConnection) arg;
        return (sourcePath.equals(other.sourcePath) &&
                targetPath.equals(other.targetPath));
    }

    public int hashCode() {
        return sourcePath.hashCode() ^ targetPath.hashCode();
    }

    public static final Comparator SOURCE_PATH_COMPARATOR = (o1, o2) -> {
        MConnection c1 = (MConnection) o1;
        MConnection c2 = (MConnection) o2;
        return c1.getSourcePath().compareTo(c2.getSourcePath());
    };

    public static final Comparator TARGET_PATH_COMPARATOR = (o1, o2) -> {
        MConnection c1 = (MConnection) o1;
        MConnection c2 = (MConnection) o2;
        return c1.getTargetPath().compareTo(c2.getTargetPath());
    };
}
