package tests.gods;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.Sphere;
import be.manudahmen.empty3.core.tribase.TubulaireN2;

import java.awt.*;

public class God extends RepresentableConteneur
{
    public God(double radius, double length, ITexture texture)
    {
        TubulaireN2<SegmentDroite> tubulaireN2 = new TubulaireN2<SegmentDroite>(new SegmentDroite(Point3D.O0, Point3D.X.mult(length)));
        tubulaireN2.radius(radius);
        Sphere sphere = new Sphere(new Axe(Point3D.Y.mult(radius), Point3D.Y.mult(-radius)), radius);
        Sphere sphere1 = new Sphere(new Axe(Point3D.X.mult(length).plus(Point3D.Y.mult(radius)), Point3D.X.mult(length).plus(Point3D.Y.mult(-radius))), radius);
        tubulaireN2.texture(new ColorTexture(Color.PINK));
        sphere.texture(new ColorTexture(Color.PINK));
        sphere1.texture(new ColorTexture(Color.PINK));


        add(new RepresentableConteneur(new Representable[]{tubulaireN2, sphere1, sphere}));
    }


    public void testScene()
    {

    }
}
