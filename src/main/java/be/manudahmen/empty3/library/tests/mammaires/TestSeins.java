package be.manudahmen.empty3.library.tests.mammaires;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point2D;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetStub;
import be.manudahmen.empty3.library.tests.TestSphere.Trajectoires;

import java.awt.*;


/**
 * Created by manuel on 01-11-15.
 * Copyright Manuel Dahmen. 2017
 */
public class TestSeins extends TestObjetStub {
    public static void main(String[] args) {

        TestSeins target = new TestSeins();
        target.loop(true);
        target.setMaxFrames(600);
        target.setGenerate(GENERATE_IMAGE | GENERATE_MODEL | GENERATE_MOVIE);
        new Thread(target).start();
    }

    public void ginit() {
        this.setMaxFrames(3);

    }

    @Override
    public void finit() {
        if (frame() == 0) {
            mammaires.Sein1 s = new mammaires.Sein1();
            s.texture(new ColorTexture(Color.BLUE));
            scene().add(s);
        } else if (frame() == 1) {
            mammaires.Sein2 s = new mammaires.Sein2();
            s.texture(new ColorTexture(Color.BLUE));
            scene().clear();
            scene().add(s);
        } else if (frame() == 2) {
            mammaires.Sein3 s = new mammaires.Sein3();
            s.texture(new ColorTexture(Color.BLUE));
            scene().clear();
            scene().add(s);
        }
    }

    private Point2D cercle() {

        return Trajectoires.sphere(0.0 + 1.0 * frame / getMaxFrames(), 0, 1).get2D();
    }

    public void testScene() {
        scene().cameraActive(new Camera(cercle().get3D().mult(2.5), Point3D.O0));

    }
}
