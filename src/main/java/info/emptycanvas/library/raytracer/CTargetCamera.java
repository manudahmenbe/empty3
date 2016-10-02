package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

public class CTargetCamera extends CCamera {
    protected Point3D mLookAtPoint;    // Le point observé
    private Point3D mVecDir = null;
    private Point3D mRightVec = null;
    private Point3D mViewPlaneUpLeft = null;
    public CTargetCamera(Point3D camPos, Point3D lookAtPoint, Point3D upVector) {
        super(camPos, lookAtPoint, lookAtPoint.prodVect(upVector).norme1(), upVector, TARGETCAMERA);
    }
}