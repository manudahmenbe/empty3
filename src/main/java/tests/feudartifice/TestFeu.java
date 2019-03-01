/***
 Global license :

 CC Attribution

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package tests.feudartifice;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.RepresentableConteneur;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import tests.balleclou.TestBalleClous111;

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

        th.setGenerate(TestBalleClous111.GENERATE_IMAGE);

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

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
