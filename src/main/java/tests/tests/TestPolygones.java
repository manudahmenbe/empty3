/*

    Vous êtes libre de :

*/
package tests.tests;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Polygon;
import be.manudahmen.empty3.core.testing.TestObjetStub;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Manuel DAHMEN
 */
public class TestPolygones extends TestObjetStub {

    public static void main(String[] argd) {
        TestPolygones tp = new TestPolygones();
        tp.run();

    }

    @Override
    public void testScene() {
        description = "octogone jaune";
        Polygon p = new Polygon(Color.yellow);
        ArrayList<Point3D> arrayList = new ArrayList<Point3D>();
        for (int i = 0; i < 8; i++) {
            arrayList.add(new Point3D(Math.cos(i / 8.0 * Math.PI * 2), Math.sin(i / 8.0 * Math.PI * 2), 0));
        }
        p.setPoints(arrayList);
        scene.add(p);
    }
}
