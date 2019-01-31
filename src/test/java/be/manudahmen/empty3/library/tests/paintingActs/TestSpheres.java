package be.manudahmen.empty3.library.tests.paintingActs;

import be.manudahmen.empty3.ColorTexture;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.renderer.TestObjet;
import be.manudahmen.empty3.core.renderer.TestObjetStub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

/**
 * Created by manue on 12-10-15.
 */
public class TestSpheres extends TestObjetStub {
    public static void main(String[] args) {
        TestObjet to = new TestSpheres();

        to.loop(true);
        to.unterminable(false);
        to.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        to.setMaxFrames(2000);

        new Thread(to).start();
    }

    public void ginit() {
        TRISphere sphere = new TRISphere(Point3D.O0, 10);
        sphere.texture(new ColorTexture(Color.GREEN));
        scene().add(sphere);
        sphere.setPaintingAct(getZ(), scene(), new SpheresPA());
    }

    public void testScene() {

    }
}
