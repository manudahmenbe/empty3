package tests.mammaires;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import tests.TestSphere.Trajectoires;

import java.awt.*;


/**
 * Created by manuel on 01-11-15.
 * Copyright Manuel Dahmen. 2017
 */
public class TestSeins extends TestObjetSub {
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
            tests.mammaires.mammaires.Sein1 s = new tests.mammaires.mammaires.Sein1();
            s.texture(new TextureCol(Color.BLUE));
            scene().add(s);
        } else if (frame() == 1) {
            tests.mammaires.mammaires.Sein2 s = new tests.mammaires.mammaires.Sein2();
            s.texture(new TextureCol(Color.BLUE));
            scene().clear();
            scene().add(s);
        } else if (frame() == 2) {
            tests.mammaires.mammaires.Sein3 s = new tests.mammaires.mammaires.Sein3();
            s.texture(new TextureCol(Color.BLUE));
            scene().clear();
            scene().add(s);
        }
    }

    private Point2D cercle() {

        return Trajectoires.sphere(0.0 + 1.0 * frame / getMaxFrames(), 0, 1, Matrix33.I).get2D();
    }

    public void testScene() {
        scene().cameraActive(new Camera(cercle().get3D().mult(2.5), Point3D.O0));

    }
}
