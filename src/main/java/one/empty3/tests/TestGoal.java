package one.empty3.tests;

import one.empty3.library.*;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.core.tribase.Tubulaire3;

import java.awt.*;

public class TestGoal extends TestObjetSub {
    int fps = 25;
    Point3D pa = new Point3D(-100., 0., 0.);
    Point3D pb = new Point3D(100., 0., 0.);
    private int tempsTotal = 10;
    Point3D v = pb.moins(pa).mult(1./fps/tempsTotal);
    private Point3D current = pa;
    private Cube cubeA;
    private Cube cubeB;
    private Color ca = Color.PINK;
    private Color cb = Color.ORANGE;


    public void tubeAddPoint(Tubulaire3 tube, Point3D p) {
        tube.getSoulCurve().getElem().getCoefficients().getData1d().add(p);
    }

    public void ginit() {
        setMaxFrames(tempsTotal*25);
        z.setDisplayType(ZBufferImpl.SURFACE_DISPLAY_TEXT_TRI);
        //scene().lumieres().add(new LumierePonctuelle(new Point3D(10., 10., 2.), Color.BLUE));
    }

    public void finit() {
        scene().texture(new ColorTexture(Color.BLACK));
        z().texture(scene().texture());
        z().idzpp();
        scene().cameras().clear();
        scene().clear();

        cubeA = new Cube(20, pa);
        cubeA.texture(new ColorTexture(ca));
        TRIObject cubeA1 = cubeA.generate();
        cubeB = new Cube(20, pb);
        cubeB.texture(new ColorTexture(cb));
        TRIObject cubeB1 = cubeA.generate();


        scene().add(cubeA1);
        scene().add(cubeB1);

        scene().add(new LineSegment(pa, pb, new ColorTexture(Color.BLUE)));


        // Plus ligne
        Sphere sphere = new Sphere(new Axe(current.plus(Point3D.Y),
                current.moins(Point3D.Y)), 10.);
        sphere.texture(new ColorTexture(Color.WHITE));
        scene().add(sphere);

        Point3D eye = current.plus(Point3D.Z.mult(100));
        Camera camera = new Camera(eye, current, Point3D.Y.mult(-1));
        camera.declareProperties();
        scene().cameraActive(camera);

        current = pa.plus(v.mult(frame()));

    }

    public static void main(String[] args) {
        TestGoal testHumain = new TestGoal();
        testHumain.setPublish(true);
        testHumain.setGenerate(testHumain.getGenerate()|GENERATE_MODEL);
        new Thread(testHumain).start();
    }

}

