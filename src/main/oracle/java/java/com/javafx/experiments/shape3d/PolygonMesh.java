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
package com.javafx.experiments.shape3d;

import javafx.collections.FXCollections;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableIntegerArray;

/**
 * A Mesh where each face can be a Polygon
 *
 * can convert to using ObservableIntegerArray
 */
public class PolygonMesh {
    private final ObservableFloatArray points = FXCollections.observableFloatArray();
    private final ObservableFloatArray texCoords = FXCollections.observableFloatArray();
    public int[][] faces = new int[0][0];
    private final ObservableIntegerArray faceSmoothingGroups = FXCollections.observableIntegerArray();
    protected int numEdgesInFaces = -1; // TODO invalidate automatically by listening to faces (whenever it is an observable)

    public PolygonMesh() {}

    public PolygonMesh(float[] points, float[] texCoords, int[][] faces) {
        this.points.addAll(points);
        this.texCoords.addAll(texCoords);
        this.faces = faces;
    }

    public ObservableFloatArray getPoints() {
        return points;
    }

    public ObservableFloatArray getTexCoords() {
        return texCoords;
    }

    public ObservableIntegerArray getFaceSmoothingGroups() {
        return faceSmoothingGroups;
    }

    public int getNumEdgesInFaces() {
        if (numEdgesInFaces == -1) {
            numEdgesInFaces = 0;
            for(int[] face : faces) {
                numEdgesInFaces += face.length;
            }
           numEdgesInFaces /= 2;
        }
        return numEdgesInFaces;
    }

    // TODO: Hardcode to constants for FX 8 (only one vertex format)
    private static final int NUM_COMPONENTS_PER_POINT = 3;
    private static final int NUM_COMPONENTS_PER_TEXCOORD = 2;
    private static final int NUM_COMPONENTS_PER_FACE = 6;

    public int getPointElementSize() {
        return NUM_COMPONENTS_PER_POINT;
    }

    public int getTexCoordElementSize() {
        return NUM_COMPONENTS_PER_TEXCOORD;
    }

    public int getFaceElementSize() {
        return NUM_COMPONENTS_PER_FACE;
    }
}
