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
import javafx.animation.Timeline;
import javafx.scene.Group;

public abstract class Importer {
    /**
     * Loads the 3D file
     *
     * @param url The url of the 3D file to load
     * @param asPolygonMesh When true load as a PolygonMesh if the loader
     * supports.
     * @throws IOException If issue loading file
     */
    public abstract void load(String url, boolean asPolygonMesh) throws IOException;
    /**
     * Gets the 3D node that was loaded earlier through the load() call
     * @return The loaded node
     */
    public abstract Group getRoot();
    /**
     * Tests if the given 3D file extension is supported (e.g. "ma", "ase",
     * "obj", "fxml", "dae").
     *
     * @param supportType The file extension (e.g. "ma", "ase", "obj", "fxml",
     * "dae")
     * @return True if the extension is of a supported type. False otherwise.
     */
    public abstract boolean isSupported(String supportType);
    /**
     * Can be overridden to return a timeline animation for the 3D file
     * @return A timeline animation. Null if there is no timeline animation.
     */
    public Timeline getTimeline() {
        return null;
    }
}
