package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

public class CTargetCamera extends CCamera {
    protected Point3D mLookAtPoint;    // Le point observé
    private Point3D mVecDir = null;
    private Point3D mRightVec = null;
    private Point3D mViewPlaneUpLeft = null;
    public CTargetCamera(Point3D camPos, Point3D lookAtPoint, Point3D upVector) {
        super(camPos, lookAtPoint, lookAtPoint.prodVect(upVector).norme1(), upVector, TARGETCAMERA);
        mUpVec = upVector;
        mLookAtPoint = lookAtPoint;

        // Nous calculons le vecteur directeur de la camera
        mVecDir = (mLookAtPoint.moins(camPos));
        mVecDir.normalize();

        // Maintenant nous calculons le vecteur droite (en utilisant le produit en croix)
        mRightVec = (mUpVec.prodVect(mVecDir));

        // De meme pour le "vrai" vecteur haut.
        mUpVec = (mVecDir.prodVect(mRightVec));

        // Maintenant nous avons toutes les informations pour d�t�rminer la position
        // en haut � gauche du viewplane.
        mViewPlaneUpLeft = camPos.plus(mVecDir.mult(-mViewplaneDist)).plus(mUpVec.mult(-mViewplaneHeight / 2.0)).plus(mRightVec.mult(-mViewplaneWidth / 2.0f));
    }
}