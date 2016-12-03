package be.manudahmen.emptycanvas.library.empty3.library.raytracer;

import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

public class RtPointLight extends RtLight {
    Point3D lightVector;
    RtColor lightDiffuseColor;
    RtColor lightSpecularColor;
    RtColor lightColor;

    public RtPointLight(Point3D myLightPos, RtColor myLightDiffuseColor, RtColor myLightSpecularColor, RtColor myLightColor) {
        super(LIGHT, "LIGHT");
        mPosition = myLightPos;
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

        Point3D lightVector2 = lightVector.norme1();

        angle = (float) normal.prodScalaire(lightVector2.mult(1 / Math.sqrt(lightVector.norme())));

        //if (angle <= 0)
        //  finalColor = new RtColor(0.0f, 0.0f, 0.0f);

        //else
        finalColor = RtColor.mult(getColor(), (RtColor.mult(material.GetDiffuse(), Math.abs(angle))));

        return RtColor.mult(finalColor, (float) mIntensite);
    }

    @Override
    public boolean intersectsNode(RtRay ray, RtIntersectInfo intersectInfo) {
        return false;
    }
}