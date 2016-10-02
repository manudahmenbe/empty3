package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

import java.awt.*;

public class CPointLight extends CLight {
    Point3D lightVector;
    Color lightDiffuseColor;
    Color lightSpecularColor;
    Color lightColor;

    public CPointLight(Point3D myLightPos, Color myLightDiffuseColor, Color myLightSpecularColor, Color myLightColor) {
        super(LIGHT, "LIGHT");
        lightDiffuseColor = myLightDiffuseColor;
        mColor = myLightDiffuseColor;
        lightSpecularColor = myLightSpecularColor;
        lightColor = myLightColor;
    }

    @Override
    public Color getLightAt(Point3D normal, Point3D intersectionPoint, Matiere material) {
        float angle;
        CColor finalColor;

        lightVector = intersectionPoint.moins(getPosition());

        lightVector = lightVector.norme1();

        angle = (float) normal.prodScalaire(lightVector.mult(-1));

        if (angle <= 0)
            finalColor = new CColor(0.0f, 0.0f, 0.0f);

        else
            finalColor = CColor.mult(new CColor(getColor()), (CColor.mult(new CColor(material.GetDiffuse()), angle)));

        return finalColor.convert();
    }

    @Override
    public boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo) {
        return false;
    }
}