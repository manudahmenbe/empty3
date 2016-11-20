package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

public class CPlane extends CObject {
    private Point3D mPointPlane;
    private Point3D mNormal;


    public CPlane(Point3D pointplane, Point3D normal) {
        super();
        mNormal = normal;
        mNormal = mNormal.norme1();

        mPointPlane = pointplane;
    }

    public CPlane(Point3D point1, Point3D point2, Point3D point3) {
    }

    // [CNode inherited]
    public boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo) {
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
