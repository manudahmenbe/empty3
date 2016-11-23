package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

public class RtPointLight extends RtLight {
    Point3D lightVector;
    RtColor lightDiffuseColor;
    RtColor lightSpecularColor;
    RtColor lightColor;

    public RtPointLight(Point3D myLightPos, RtColor myLightDiffuseColor, RtColor myLightSpecularColor, RtColor myLightColor) {
        super(LIGHT, "LIGHT");
        lightDiffuseColor = myLightDiffuseColor;
        mColor = myLightDiffuseColor;
        lightSpecularColor = myLightSpecularColor;
        lightColor = myLightColor;
    }

    @Override
    public RtColor getLightAt(Point3D normal, Point3D intersectionPoint, RtMatiere material) {
        float angle;
        RtColor finalColor;

        lightVector = intersectionPoint.moins(getPosition());

        lightVector = lightVector.norme1();

        angle = (float) normal.prodScalaire(lightVector.mult(-1));

        if (angle <= 0)
            finalColor = new RtColor(0.0f, 0.0f, 0.0f);

        else
            finalColor = RtColor.mult(getColor(), (RtColor.mult(material.GetDiffuse(), angle)));

        return finalColor;
    }

    @Override
    public boolean intersectsNode(RtRay ray, RtIntersectInfo intersectInfo) {
        return false;
    }
}