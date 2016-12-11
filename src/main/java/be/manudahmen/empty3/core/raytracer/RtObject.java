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

package be.manudahmen.empty3.core.raytracer;

/**
 * Created by manuel on 03-08-16.
 */
public abstract class RtObject extends RtNode {

    protected RtNode mNode;
    protected RtMatiere mMaterial;

    public RtObject() {
        mNode = getNodeInstance();
    }

    // get
    public RtMatiere getMaterial() {
        return mMaterial;
    }

    public void setMaterial(RtMatiere material) {
        mMaterial = material;
    }

    public RtNode getNode() {
        return mNode;
    }

    // set
    public void setNode(RtNode node) {
        mNode = node;
    }

}
