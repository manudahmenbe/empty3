package tests2.anneaux;


import one.empty3.library.*;
import one.empty3.library.core.move.Trajectoires;
import one.empty3.library.core.testing.TestObjetSub;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestSpheres extends TestObjetSub {

    public static final int CIRCLES_COUNT = 10;
    public double step = 10000.0;

    public static void main(String... args) {
        TestSpheres testSpheres = new TestSpheres();
        testSpheres.setResolution(800, 800);
        testSpheres.setMaxFrames(3300);
        new Thread(testSpheres).start();
    }

    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() {
        scene().cameraActive(new Camera(Trajectoires.sphere(
                1. * frame() / getMaxFrames(), 0.0,
                400.0), Point3D.O0));

        //scene().lumieres().add(new LumierePointSimple(Color.BLUE, Point3D.O0, 10));

    }

    @Override
    public void ginit() {
        scene().clear();
        Sphere[] spheres = new Sphere[TestSpheres.CIRCLES_COUNT];
        for (int i = 0; i < spheres.length; i++) {
            Axe axe = new Axe(Point3D.random(100), Point3D.random(100));
            spheres[i] = new Sphere(axe,
                    100);
            spheres[i].texture(new TextureCol(Color.ORANGE));
            spheres[i].setIncrU(.01);
            spheres[i].setIncrV(.01);
            try {
                TextureImg imageTexture = new TextureImg(
                        new ECBufferedImage(
                                ImageIO.read(new File("./samples/img/herbe.jpg"))));

                spheres[i].texture(imageTexture);
            } catch (IOException e) {
                e.printStackTrace();
            }
            scene().add(spheres[i]);
        }
    }

    @Override
    public void afterRender() {

    }

    @Override
    public void testScene() throws Exception {

    }


    public void gc() {
        Runnable gc = () -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.gc();
            }
        };
        new Thread(gc).start();
    }
}
