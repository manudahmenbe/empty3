package tests.anneaux;

import be.manudahmen.empty3.Axe;
import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.Circle;
import be.manudahmen.empty3.core.lighting.Colors;
import be.manudahmen.empty3.core.testing.TestObjet;
import tests.TestSphere.Trajectoires;

/**
 * Created by Win on 28-08-18.
 */
public class TestCircles extends TestObjet {

    public static final int CIRCLES_COUNT = 100;

    private Circle[] circles;

    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() {
        scene().cameras().clear();
        int mod = getMaxFrames() / 4;
        double longpc = (frame() % mod) / 1.0 / mod;
        System.out.println("Longitude= " + longpc);
        scene().cameraActive(new Camera(
                Trajectoires.sphere(
                        longpc,
                        0,
                        200
                ), Point3D.O0));
    }

    @Override
    public void ginit() {
        scene().clear();
        circles = new Circle[CIRCLES_COUNT];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(new Axe(Point3D.random(100), Point3D.random(100)),
                    100);
            circles[i].texture(new TextureCol(Colors.random()));
            circles[i].incr = 0.01;
            scene().add(circles[i]);
            System.out.println("Center: " + circles[i].getCenter());
        }
    }

    @Override
    public void afterRender() {

    }

    @Override
    public void testScene() throws Exception {

    }

    public static void main(String... args) {
        TestCircles testCircles = new TestCircles();
        testCircles.setMaxFrames(4000);
        testCircles.setResolution(1600, 1200);
        new Thread(testCircles).start();
    }
}
