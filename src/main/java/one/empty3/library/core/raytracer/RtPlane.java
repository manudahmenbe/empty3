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

public class RtPlane extends RtObject {
    private Point3D mPointPlane;
    private Point3D mNormal;


    public RtPlane(Point3D pointplane, Point3D normal) {
        super();
        mNormal = normal;
        mNormal = mNormal.norme1();

        mPointPlane = pointplane;
    }

    public RtPlane(Point3D point1, Point3D point2, Point3D point3) {
    }

    // [RtNode inherited]
    public boolean intersectsNode(RtRay ray, RtIntersectInfo intersectInfo) {
        double t;
        double dv;

        dv = (float) mNormal.prodScalaire(ray.mVDir);

        if (dv == 0)
            return false;

        t = mNormal.prodScalaire(mPointPlane.moins(ray.mVStart)) / dv;

        if (t < 0)
            return false;

        if (intersectInfo != null) {
            intersectInfo.mIntersection = ray.mVStart.plus(ray.mVDir.mult(t));

            if (dv < 0)
                intersectInfo.mNormal = mNormal.mult(-1);

            else
                intersectInfo.mNormal = mNormal.mult(-1);

            intersectInfo.mNode = getNode();
            intersectInfo.mMaterial = getMaterial();
        }

        return true;
    }


}
