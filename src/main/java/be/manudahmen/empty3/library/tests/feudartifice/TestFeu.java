/***
 Global license :

 CC Attribution

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.feudartifice;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.RepresentableConteneur;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.library.tests.balleclou.TestBalleClous111;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestFeu extends TestObjetSub {

    public static void main(String[] args) {
        TestFeu th = new TestFeu();

        th.loop(true);

        th.setMaxFrames(400);

        th.setResx(1920);

        th.setResy(1080);

        th.setGenerate(GENERATE_IMAGE|GENERATE_MOVIE);

        th.run();
    }

    @Override
    public void ginit() {
        FeuArbre fey = new FeuArbre();
        RepresentableConteneur generate = fey.generate();
        scene().add(generate);
        System.out.println(generate.getListRepresentable().size());


    }

    @Override
    public void testScene() throws Exception {

        scene().cameraActive(new Camera(Point3D.Z.mult(-100 + frame / 2.0), Point3D.Z.mult(200)));


    }

}
