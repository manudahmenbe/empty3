package be.manudahmen.empty3.library.raytracer;

import be.manudahmen.empty3.library.object.Point3D;

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
        float t;
        float dv;

        dv = (float) mNormal.prodScalaire(ray.mVDir);

        if (dv == 0)
            return false;

        t = (float) (-(mNormal.prodScalaire(ray.mVStart.moins(mPointPlane))) / dv);

        if (t < 0)
            return false;

        if (intersectInfo != null) {
            intersectInfo.mIntersection = ray.mVStart.plus(ray.mVDir.mult(t));

            if (dv < 0)
                intersectInfo.mNormal = mNormal;

            else
                intersectInfo.mNormal = mNormal.mult(-1);

            intersectInfo.mNode = getNode();
            intersectInfo.mMaterial = getMaterial();
        }

        return true;
    }


}
