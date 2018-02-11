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
package com.javafx.experiments.importers.max;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.geometry.Point3D;

/** Max file format data objects */
public class MaxData {
    public static class MappingChannel {
        public int ntPoints;
        public float tPoints[];
        public int faces[]; // t0 t1 t2
    }

    public static class Mesh {
        public String name;
        public int nPoints;
        public float points[]; // x,y,z, x,y,z, ....
        public int nFaces;
        public int faces[];    // [[p0,p1,p2, smoothing]...]
        public MappingChannel mapping[];
    }

    public static class NodeTM {
        public String name;
        public Point3D pos;
        public Point3D tm[] = new Point3D[3];
    }

    public static class Material {
        public String name;
        public String diffuseMap;
        public Point3D ambientColor;
        public Point3D diffuseColor;
        public Point3D specularColor;
    }

    public static class Node {
        public String name;
        public NodeTM nodeTM;
        public Node parent;
        public List<Node> children;
    }

    public static class LightNode extends Node {
        public float intensity;
        public float r, g, b;
    }

    public static class CameraNode extends Node {
        public NodeTM target;
        public float near, far, fov;
    }

    public static class GeomNode extends Node {
        public Mesh mesh;
        public int materialRef;
    }

    public Material materials[];
    public Map<String, Node> nodes = new HashMap<>();
    public Map<String, Node> roots = new HashMap<>();
}
