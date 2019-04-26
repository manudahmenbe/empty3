package tests;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.Sphere;
import be.manudahmen.empty3.core.nurbs.PcOnPs;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import tests.TestSphere.Trajectoires;

import java.awt.*;

/**
 * G:\Apps\IdeaProjects\empty3\src\test\java\be\manudahmen\empty3\library\tests\TestSoS.java
 * Created by manue on 02-02-19.
 */
public class TestSoS extends TestObjetSub {
    private static final double RADIUS = 10.0;
    private static final int NSEG = 10;
    private Point3D pointsB;
    private Point3D pointsA;
    private RepresentableConteneur representableConteneur
            = new RepresentableConteneur();
    private Sphere sphere;
    private Point3D sphereOrig = Point3D.O0;
    TextureCol textureCol = new TextureCol(Color.RED);
    private Point3D sphereDest = Point3D.Y;
    ITexture colorTextureSurface = new TextureCol(Color.GREEN);
    private double segemntSize = 1;
    public void ginit() {
        scene().clear();
        sphere = new Sphere(sphereOrig, RADIUS);
        sphere.texture(colorTextureSurface);
       scene().add(representableConteneur);
        //scene().add(sphere);

        scene().cameraActive(
                new Camera(Point3D.Z.mult(RADIUS).mult(2.0), Point3D.O0));
    }
    public void finit()
    {
        representableConteneur.clear();
        for (int s = 0; s < NSEG;
             s++) {
            pointsA = new Point3D(0, 1.0*s/NSEG, 0);
            pointsB = new Point3D(1, 1.0*s/NSEG, 0);
            SegmentDroite segmentDroite = new SegmentDroite(pointsA, pointsB);
            segmentDroite.texture(textureCol);
            pointsA.texture(textureCol);
            pointsB.texture(textureCol);

            PcOnPs pcOnPs = new PcOnPs(sphere, segmentDroite);
//            pcOnPs.getParameters().setIncrU(0.0001);
            representableConteneur.add(pcOnPs);

        }
        scene().cameraActive(
                new Camera(Trajectoires.sphere(0,
                        0, RADIUS*2.3), Point3D.O0));
    }

    public static void main(String[] args) {
        TestSoS testSoS = new TestSoS();
        testSoS.setMaxFrames(10);
        new Thread(testSoS).start();
    }
}
