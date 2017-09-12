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
package com.javafx.experiments.importers;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class ImporterFinder {

    public URLClassLoader addUrlToClassPath() {
        final Class<?> referenceClass = ImporterFinder.class;
        final URL url = referenceClass.getProtectionDomain().getCodeSource().getLocation();

        File libDir = null;
        try {
            File currentDir = new File(url.toURI()).getParentFile();
            libDir = new File(currentDir, "lib");
        } catch (URISyntaxException ue) {
            ue.printStackTrace();
            throw new RuntimeException("Could not import library. Failed to determine library location. URL = " + url.getPath());
        }
        if (libDir != null) {
            File[] files = libDir.listFiles();
            final List<URL> urlList = new ArrayList<>();
            if (files != null) {
                for (File file : files) {
                    try {
                        urlList.add(file.toURI().toURL());
                    } catch (MalformedURLException me) {
                        me.printStackTrace();
                    }
                }
            }
            URLClassLoader cl = new URLClassLoader((URL[]) urlList.toArray(new URL[0]), this.getClass().getClassLoader());
            return cl;
        } else {
            throw new RuntimeException("Could not import library. Failed to determine importer library location ");
        }
    }
}
