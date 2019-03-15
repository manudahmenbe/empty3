package tests;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.Sphere;
import be.manudahmen.empty3.core.nurbs.PcOnPs;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * G:\Apps\IdeaProjects\empty3\src\test\java\be\manudahmen\empty3\library\tests\TestSoS.java
 * Created by manue on 02-02-19.
 */
public class TestSoS extends TestObjetSub {
    private static final double RADIUS = 10.0;
    private static final int NSEG = 20;
    private Point3D[] pointsB = new Point3D[NSEG];
    private Point3D[] pointsA = new Point3D[NSEG];
    private RepresentableConteneur representableConteneur
            = new RepresentableConteneur();
    private Sphere sphere;
    private Point3D sphereOrig = Point3D.O0;
    TextureCol textureCol = new TextureCol(Color.BLACK);
    private Point3D sphereDest = Point3D.Y;
    ITexture colorTextureSurface = new TextureCol(Color.GREEN);

    public void ginit() {
        representableConteneur.clear();
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

    }

    public void finit() {

//        representableConteneur
        //= new RepresentableConteneur();


        sphereOrig = sphereOrig.plus(Point3D.random(RADIUS / 100));
        sphereDest = sphereDest.plus(Point3D.random(RADIUS / 100));


        sphere = new Sphere(new Axe(sphereOrig, sphereDest), RADIUS);
        SegmentsOnSurface segmentsOnSurface = new SegmentsOnSurface
                (
                        sphere
                        ,
                        new SegmentDroite(Point3D.O0, Point3D.O0)
                );
        sphere.texture(colorTextureSurface);
        segmentsOnSurface.texture(colorTextureSurface);
        representableConteneur.texture(textureCol);
        scene().cameraActive(
                new Camera(sphereOrig, sphereDest));
    }

    public static void main(String[] args) {
        TestSoS testSoS = new TestSoS();
        testSoS.setMaxFrames(3000);
        new Thread(testSoS).start();
    }
}
