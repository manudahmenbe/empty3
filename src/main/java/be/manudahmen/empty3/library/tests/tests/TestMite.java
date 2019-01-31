/*

    Vous êtes libre de :

*/
package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.script.Loader;
import be.manudahmen.empty3.core.testing.TestObjetStub;

import java.util.ResourceBundle;

/**
 * @author Manuel DAHMEN
 */
public class TestMite extends TestObjetStub {
    public static void main(String[] args) {
        TestMite to = new TestMite();
        to.camera(new Camera(new Point3D(0, 0, -30), new Point3D(0, 0, 0)));
        to.run();

    }

    @Override
    public void testScene() {
        ResourceBundle rb = ResourceBundle.getBundle("be/manudahmen/empty3/library/tests/tests/Mite");
        String mite = rb.getString("mite");
        new Loader().loadIF(mite, scene);
        description = "Primtive model. triangle mesh";
    }


}
