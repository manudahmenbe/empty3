package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

public class CSphere extends CObject {
    private Point3D mCenter; // Le centre de la sph�re
    private double mRadius; // Le rayon de la sph�re


    public CSphere(Point3D center, double radius) {
        super();
        mCenter = (center);
        mRadius = (radius);
    }

    public boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo) {

        double a, b, c;
        double delta;
        double t;
        double t1, t2;
        Point3D intersect;
        Point3D tmpNormal;

        Point3D rayOrg = ray.mVStart.moins(mCenter);    // ray in space of the sphere

//CNAGES

/*
        a = 1;
        b = rayOrg.prodScalaire(ray.mVDir);
        c = (Math.pow(rayOrg.NormeCarree(), 2) - mRadius * mRadius);
        delta = ((b * b) - c);
*/
/*
        b = rayOrg.prodScalaire(ray.mVDir);
        a = (ray.mVDir.prodScalaire(ray.mVDir));
        c = (rayOrg.prodScalaire(rayOrg) - mRadius * mRadius);
        delta = b * b - 4 * a * c;

*/
/*
Le couple c'est pour les trous de balle
 */
        a = ray.mVDir.norme1().moins(ray.mVStart).NormeCarree() - mRadius * mRadius;
        b = -2 * mCenter.prodScalaire(ray.mVDir.norme1());
        c = mCenter.NormeCarree();
        delta = b * b - 4 * a * c;

        if (delta < 0.0f)
            return false; // pas d'intersection

        if (intersectInfo != null) {
            if (delta != 0) {
                delta = (float) Math.sqrt(delta);
                t1 = (-b + delta) / 2 / a;
                if (t1 < 0) return false;
                t2 = (-b - delta) / 2 / a;
                if (t2 < 0) return false;

                if (t1 < t2)
                    t = t1;
                else
                    t = t2;
            } else
                t = (-b);

            intersect = ray.mVStart.plus(ray.mVDir.mult(t));

            tmpNormal = (intersect.moins(mCenter)).mult(1 / mRadius);

            intersectInfo.mIntersection = intersect;
            intersectInfo.mNormal = tmpNormal;
            intersectInfo.mNode = getNode();
            intersectInfo.mMaterial = getMaterial();
        }

        return true;
    }
}