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

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.util.Pair;

import java.util.ServiceLoader;

/**
 * Base Importer for all supported 3D file formats
 */
public final class Importer3D {

    /**
     * Get array of extension filters for supported file formats.
     *
     * @return array of extension filters for supported file formats.
     */
    public static String[] getSupportedFormatExtensionFilters() {
        return new String[]{"*.ma", "*.ase", "*.obj", "*.fxml", "*.dae"};
    }

    /**
     * Load a 3D file, always loaded as TriangleMesh.
     *
     * @param fileUrl The url of the 3D file to load
     * @return The loaded Node which could be a MeshView or a Group
     * @throws IOException if issue loading file
     */
    public static Node load(String fileUrl) throws IOException {
        return load(fileUrl,false);
    }

    /**
     * Load a 3D file.
     *
     * @param fileUrl The url of the 3D file to load
     * @param asPolygonMesh When true load as a PolygonMesh if the loader supports
     * @return The loaded Node which could be a MeshView or a Group
     * @throws IOException if issue loading file
     */
    public static Node load(String fileUrl, boolean asPolygonMesh) throws IOException {
        return loadIncludingAnimation(fileUrl,asPolygonMesh).getKey();
    }

    /**
     * Load a 3D file.
     *
     * @param fileUrl The url of the 3D file to load
     * @param asPolygonMesh When true load as a PolygonMesh if the loader supports
     * @return The loaded Node which could be a MeshView or a Group and the Timeline animation
     * @throws IOException if issue loading file
     */
    public static Pair<Node,Timeline> loadIncludingAnimation(String fileUrl, boolean asPolygonMesh) throws IOException {
        // get extension
        final int dot = fileUrl.lastIndexOf('.');
        if (dot <= 0) {
            throw new IOException("Unknown 3D file format, url missing extension [" + fileUrl + "]");
        }
        final String extension = fileUrl.substring(dot + 1, fileUrl.length()).toLowerCase();
        // Reference all the importer jars
        ImporterFinder finder = new ImporterFinder();
        URLClassLoader classLoader = finder.addUrlToClassPath();

        ServiceLoader<Importer> servantLoader = ServiceLoader.load(Importer.class, classLoader);
        // Check if we have an implementation for this file type
        Importer importer = null;
        for (Importer plugin : servantLoader) {
            if (plugin.isSupported(extension)) {
                importer = plugin;
                break;
            }
        }

        // Check well known loaders that might not be in a jar (ie. running from an IDE)
        if ((importer == null) && (!extension.equals("fxml"))){
            String [] names = {
                 "com.javafx.experiments.importers.dae.DaeImporter",
                 "com.javafx.experiments.importers.max.MaxLoader",
                 "com.javafx.experiments.importers.maya.MayaImporter",
                 "com.javafx.experiments.importers.obj.ObjOrPolyObjImporter",
            };
            boolean fail = true;
            for (String name : names) {
                try {
                    Class<?> clazz = Class.forName(name);
                    Object obj = clazz.newInstance();
                    if (obj instanceof Importer) {
                        Importer plugin = (Importer) obj;
                        if (plugin.isSupported(extension)) {
                            importer = plugin;
                            fail = false;
                            break;
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    // FAIL SILENTLY
                }
            }
            if (fail) throw new IOException("Unknown 3D file format [" + extension + "]");
        }

        if (extension.equals("fxml")) {
            final Object fxmlRoot = FXMLLoader.load(new URL(fileUrl));
            if (fxmlRoot instanceof Node) {
                return new Pair<>((Node) fxmlRoot, null);
            } else if (fxmlRoot instanceof TriangleMesh) {
                return new Pair<>(new MeshView((TriangleMesh) fxmlRoot), null);
            }
            throw new IOException("Unknown object in FXML file [" + fxmlRoot.getClass().getName() + "]");
        } else {
            importer.load(fileUrl, asPolygonMesh);
            return new Pair<>(importer.getRoot(), importer.getTimeline());
        }
    }
}
