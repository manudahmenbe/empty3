/*

    Vous êtes libre de :

*/
package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.script.Loader;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.util.ResourceBundle;

/**
 * @author Manuel DAHMEN
 */
public class TestMartienSpheres extends TestObjetSub {
    public static void main(String[] args) {
        TestMartienSpheres to = new TestMartienSpheres();
        to.camera(new Camera(new Point3D(0, 0, -10), new Point3D(0, 0, 0)));
        to.run();

    }

    @Override
    public void testScene() {
        ResourceBundle rb = ResourceBundle.getBundle("be/manudahmen/empty3/library/tests/tests/Mite");
        String mite = rb.getString("sphere1");
        new Loader().loadIF(mite, scene());
        description = "Primitive model. Green face made up with be.manudahmen.empty3.library.tests.spheres";
    }


}
