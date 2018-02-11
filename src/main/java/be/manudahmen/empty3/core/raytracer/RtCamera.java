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

import be.manudahmen.empty3.Point3D;

public class RtCamera extends RtNode {
    protected double mViewplaneDist;                                                // Distance du viexplane par rapport � la position de la cam.
    protected double mViewplaneWidth, mViewplaneHeight;                            // Largeur/Hauteur du viewplane.
    protected Point3D mCamPos, mVecDir, mUpVec, mRightVec, mViewPlaneUpLeft;

    public RtCamera(Point3D vCamPos, Point3D directionVec, Point3D vRightVec, Point3D vUpVector, int type)

    {
        super(type, "CAMERA");
        mCamPos = vCamPos;
        mVecDir = directionVec.norme1();
        mUpVec = vUpVector.norme1();
        mRightVec = vRightVec.norme1();
        mViewplaneDist = 1.0f;
        mViewplaneHeight = 1.0f;
        mViewplaneWidth = 1.0f;
        mViewPlaneUpLeft = mCamPos.plus(mVecDir.mult(mViewplaneDist))
                .plus(mRightVec.mult(-mViewplaneWidth)).plus(mUpVec.mult(-mViewplaneHeight));

    }

    Point3D calcDirVec(double x, double y, int xRes, int yRes) {
        double xIndent, yIndent;
        double posX = x;
        double posY = y;
        xIndent = 2.0 * mViewplaneWidth / xRes;
        yIndent = 2.0 * mViewplaneHeight / yRes;

        return mViewPlaneUpLeft.plus(mRightVec.mult(xIndent * posX).plus(mUpVec.mult(yIndent * posY))).moins(getPosition()).norme1();
    }


    @Override
    public boolean intersectsNode(RtRay ray, RtIntersectInfo intersectInfo) {
        return false;
    }

    public Point3D getPosition() {
        return mCamPos;
    }
}




