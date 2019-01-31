/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.nurbs;

import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.SegmentDroite;
import be.manudahmen.empty3.core.nurbs.NurbsCurve;
import be.manudahmen.empty3.core.testing.TestObjetStub;

import java.awt.*;
import java.util.AbstractMap;
import java.util.Arrays;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestNurbsCurve extends TestObjetStub {
    public static void main(String[] args) {
        System.err.println("Circle");
        TestObjetStub t;

        t = new TestNurbsCurve();
        t.setResx(320);
        t.setResy(240);
        t.loop(false);
        new Thread(t).start();

    }

    @Override
    public void testScene() throws Exception {
        loop(false);

        NurbsCurve c = new NurbsCurve();
        c.getKnots().addAll(
                Arrays.asList(
                        0.0, 0.0, 0.0, Math.PI / 2, Math.PI / 2, Math.PI, Math.PI, 3 * Math.PI / 2, 3 * Math.PI / 2, 2 * Math.PI, 2 * Math.PI, 2 * Math.PI)
        );
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(1, 0, 0), 1.0));
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(1, 1, 0), Math.sqrt(2) / 2));
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(0, 1, 0), 1.0));
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(-1, 1, 0), Math.sqrt(2) / 2));
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(-1, 0, 0), 1.0));
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(-1, -1, 0), Math.sqrt(2) / 2));
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(0, -1, 0), 1.0));
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(1, -1, 0), Math.sqrt(2) / 2));
        c.getPointsPoids().add(new AbstractMap.SimpleEntry<Point3D, Double>(new Point3D(1, 0, 0), 1.0));


        scene().add(c);

        System.out.print(c);

        scene().cameraActive().setEye(Point3D.Z.mult(-5));


        scene().add(new SegmentDroite(Point3D.O0, Point3D.X, new ColorTexture(Color.RED)));
        scene().add(new SegmentDroite(Point3D.O0, Point3D.Y, new ColorTexture(Color.GREEN)));
        scene().add(new SegmentDroite(Point3D.O0, Point3D.Z, new ColorTexture(Color.BLUE)));
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ginit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

