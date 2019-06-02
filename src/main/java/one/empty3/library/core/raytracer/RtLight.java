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

import one.empty3.library.*;

/**
 * Created by manuel on 03-08-16.
 */
public abstract class RtLight extends RtNode {
    protected float mDiffuseColor;
    protected float mSpecularColor;
    protected Point3D mPosition = new Point3D();
    protected RtColor mColor;
    protected int mLightType;
    protected double mIntensite = 1;

    public RtLight(Point3D position, float diffuseColor, float specularColor, RtColor CColor, int type) {
        super(LIGHT, "LIGHT");
        assert (position != null);
        mPosition = position;
        mDiffuseColor = diffuseColor;
        mSpecularColor = specularColor;
        mColor = CColor;
        mLightType = type;
    }

    public RtLight(int light, String light1) {
        mLightType = light;
        mNodeType = LIGHT;
    }

    /*public RtLight(int light, String light1) {
        super(light, light1);
    }*/

    // get
    public Point3D getPosition() {
        return mPosition;
    }

    public RtColor getColor() {
        return mColor;
    }

    public int getType() {
        return mLightType;
    }

    // La méthode virtuel pure d'éclairage.
    public abstract RtColor getLightAt(Point3D normal, Point3D intersectionPoint, RtMatiere material);

    public void setIntensite(int intensite) {
        this.mIntensite = intensite;
    }
}
