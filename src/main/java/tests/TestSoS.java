package tests;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.lighting.Colors;
import be.manudahmen.empty3.core.nurbs.PcOnPs;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

/**
 * G:\Apps\IdeaProjects\empty3\src\test\java\be\manudahmen\empty3\library\tests\TestSoS.java
 * Created by manue on 02-02-19.
 */
public class TestSoS extends TestObjetSub {
    private static final double RADIUS = 10.0;
    private static final int NSEG = 100;
    private Point3D[] pointsB = new Point3D[NSEG];
    private Point3D[] pointsA = new Point3D[NSEG];
    private RepresentableConteneur representableConteneur
            = new RepresentableConteneur();
    private TRISphere sphere;
    private Point3D sphereOrig = Point3D.O0;
    TextureCol textureCol = new TextureCol(Color.RED);
    private Point3D sphereDest = Point3D.Y;
    ITexture colorTextureSurface = new TextureCol(Color.GREEN);

    public void finit() {
        scene().clear();
        representableConteneur.clear();
        sphere = new TRISphere(sphereOrig, RADIUS);
        sphere.texture(new ColorTexture(Colors.TRANSPARENT));
        for (int s = 0; s < NSEG;
             s++) {
            pointsA[s] = Point3D.random(1).moins(new Point3D(0.5, 0.5, 0.5));
            pointsB[s] = Point3D.random(0.5).moins(new Point3D(0.5, 0.5, 0.5));
            SegmentDroite segmentDroite = new SegmentDroite(pointsA[s], pointsB[s]);
            segmentDroite.texture(textureCol);
            segmentDroite.getOrigine().texture(textureCol);
            segmentDroite.getExtremite().texture(textureCol);
            representableConteneur.add(new PcOnPs(sphere, segmentDroite));

        }
        scene().add(representableConteneur);
        //scene().add(sphere);

        scene().cameraActive(
                new Camera(Point3D.Z.mult(RADIUS*1.3).mult(2.0), Point3D.O0));
    }


    public static void main(String[] args) {
        TestSoS testSoS = new TestSoS();
        testSoS.setMaxFrames(3000);
        new Thread(testSoS).start();
    }
}
