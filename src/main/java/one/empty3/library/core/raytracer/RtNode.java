/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package one.empty3.library.core.raytracer;

public abstract class RtNode {
    public static final int LIGHT = 0x0001000;
    public static final int OMNILIGHT = 0x0001002;
    public static final int CAMERA = 0x0010004;
    public static final int TARGETCAMERA = 0x0010008;

    protected int mNodeType;
    protected String mName;

    // constructeurs et destructeur
    public RtNode() {
        mName = null;
    }

    public RtNode(int nodeType, String name) {
        mNodeType = nodeType;
        mName = name;
    }

    // raytrace related
    public abstract boolean intersectsNode(RtRay ray, RtIntersectInfo intersectInfo);

    // get
    public final int getNodeType() {
        return mNodeType;
    }

    // set
    public void setNodeType(int nodeType) {
        mNodeType = nodeType;
    }

    public final String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public final RtNode getNodeInstance() {
        return this;
    }
}