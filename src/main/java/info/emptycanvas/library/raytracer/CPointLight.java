package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

public class CPointLight extends CLight {

    @Override
    public CColor getLightAt(Point3D normal, Point3D intersectionPoint, Matiere material) {
        Point3D lightVector, reflectedLightVec;
        float angle;
        CColor finalColor;

        lightVector = intersectionPoint.moins(getPosition());

        lightVector = lightVector.norme1();

        angle = (float) normal.prodScalaire(lightVector.mult(-1));

        if (angle <= 0)
            finalColor = new CColor(0.0f, 0.0f, 0.0f);

        else
            finalColor = CColor.mult(getColor(), (CColor.mult(material.GetDiffuse(), angle)));

        return finalColor;
    }

    @Override
    public boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo) {
        return false;
    }
}