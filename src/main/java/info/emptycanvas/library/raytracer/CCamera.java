package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

public class CCamera extends CNode {
    protected Point3D mCamPos;
    protected Point3D mUpVec;
    protected double mViewplaneDist;
    protected double mViewplaneHeight;
    protected double mViewplaneWidth;
    protected Point3D mViewPlaneUpLeft;
    private Point3D mRightVec;

    public CCamera(Point3D vCamPos, Point3D vUpVector, int type)

    {
        mCamPos = vCamPos;
        mUpVec = vUpVector;
        mViewplaneDist = 1.0f;
        mViewplaneHeight = 0.35f;
        mViewplaneWidth = 0.5f;

    }

    Point3D calcDirVec(float x, float y, int xRes, int yRes) {
        double xIndent, yIndent;

        xIndent = mViewplaneWidth / (float) xRes;
        yIndent = mViewplaneHeight / (float) yRes;

        return (mViewPlaneUpLeft.plus(mRightVec.mult(xIndent * x).moins(mUpVec.mult(yIndent * y))).moins(getPosition()));
    }


    @Override
    public boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo) {
        return false;
    }

    public Point3D getPosition() {
        return mCamPos;
    }
}




