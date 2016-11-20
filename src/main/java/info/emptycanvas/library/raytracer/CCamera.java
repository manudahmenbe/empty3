package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

public class CCamera extends CNode {
    protected double mViewplaneDist;                                                // Distance du viexplane par rapport � la position de la cam.
    protected float mViewplaneWidth, mViewplaneHeight;                            // Largeur/Hauteur du viewplane.
    protected Point3D mCamPos, mVecDir, mUpVec, mRightVec, mViewPlaneUpLeft;

    public CCamera(Point3D vCamPos, Point3D directionVec, Point3D vRightVec, Point3D vUpVector, int type)

    {
        super(type, "CAMERA");
        mCamPos = vCamPos;
        mVecDir = directionVec.norme1();
        mUpVec = vUpVector.norme1();
        mRightVec = vRightVec.norme1();
        mViewplaneDist = 1.0f;
        mViewplaneHeight = 0.35f;
        mViewplaneWidth = 0.35f;
        mViewPlaneUpLeft = mCamPos.plus(mVecDir.mult(mViewplaneDist))
                .plus(mRightVec.mult(-mViewplaneWidth/2)).plus(mUpVec.mult(-mViewplaneHeight/2));

    }

    Point3D calcDirVec(float x, float y, int xRes, int yRes) {
        double xIndent, yIndent;

        xIndent = mViewplaneWidth / (float) xRes;
        yIndent = mViewplaneHeight / (float) yRes;

        return mViewPlaneUpLeft.plus(mRightVec.mult(xIndent * x).moins(mUpVec.mult(yIndent * y))).moins(getPosition());
    }


    @Override
    public boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo) {
        return false;
    }

    public Point3D getPosition() {
        return mCamPos;
    }
}




