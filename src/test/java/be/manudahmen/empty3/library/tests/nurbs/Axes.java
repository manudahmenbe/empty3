/***
 Global license :

 CC Attribution

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.nurbs;

import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.RepresentableConteneur;
import be.manudahmen.empty3.SegmentDroite;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
class Axes extends RepresentableConteneur {
    public Axes(ColorTexture a1, ColorTexture a2, ColorTexture a3) {
        add(new SegmentDroite(Point3D.O0, Point3D.X, a1));
        add(new SegmentDroite(Point3D.O0, Point3D.Y, a2));
        add(new SegmentDroite(Point3D.O0, Point3D.Z, a3));

    }

    public Axes() {
        this(new ColorTexture(Color.RED), new ColorTexture(Color.GREEN), new ColorTexture(Color.BLUE));
    }
}
