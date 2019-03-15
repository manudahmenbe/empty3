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
package com.javafx.experiments.shape3d.symbolic;

import com.javafx.experiments.shape3d.PolygonMesh;

/**
 * Polygon mesh where the points are symbolic. That is, the values of the
 * points depend on other variables and they can be updated appropriately.
 */
public class SymbolicPolygonMesh {
    public SymbolicPointArray points;
    public float[] texCoords;
    public int[][] faces;
    public int[] faceSmoothingGroups;
    private int numEdgesInFaces = -1;

    public SymbolicPolygonMesh(SymbolicPointArray points, float[] texCoords, int[][] faces, int[] faceSmoothingGroups) {
        this.points = points;
        this.texCoords = texCoords;
        this.faces = faces;
        this.faceSmoothingGroups = faceSmoothingGroups;
    }

    public SymbolicPolygonMesh(PolygonMesh mesh) {
        this.points = new OriginalPointArray(mesh);
        this.texCoords = mesh.getTexCoords().toArray(this.texCoords);
        this.faces = mesh.faces;
        this.faceSmoothingGroups = mesh.getFaceSmoothingGroups().toArray(null);
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
}
