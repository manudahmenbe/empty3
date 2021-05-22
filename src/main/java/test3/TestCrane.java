package test3;

import one.empty3.library.*;
import one.empty3.library.Polygon;
import one.empty3.library.core.nurbs.CameraInPath;
import one.empty3.library.core.nurbs.Point3DS;
import one.empty3.library.core.script.InterpreteException;
import one.empty3.library.core.script.InterpretePolygone;
import one.empty3.library.core.testing.TestObjet;
import one.empty3.library.core.testing.TestObjetSub;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class TestCrane extends TestObjetSub {
    public void ginit() {
        Properties properties = new Properties();
        try {
            properties.load(new BufferedReader(new FileReader("samples/head.properties")));
            String[] strings = {"frontal.x", "frontal.-x",
                    "nose.x", "nose.-x",
                    "joue.x", "joue.-x",
                    "temporal.x", "temporal.-x"};
            for (String polyString : strings) {
                polyString = properties.getProperty(polyString);
                Polygon polygon = (Polygon) new InterpretePolygone().interprete(polyString, 0);
                polygon.texture(new ColorTexture(Color.BLACK));
                scene().add(polygon);
            }

            Camera camera = new Camera(
                    Point3D.Z.mult(50), Point3D.O0, Point3D.Y.mult(-1.0));
            /*CameraInPath camera2 = new CameraInPath(new LineSegment(
                    new Point3D(0., 0., 30.),
                    new Point3D(0., 0., 0.)
                    ), Point3D.Y);
            camera2.setT(0.0);
            camera.setLookat(Point3D.O0);
            camera2.calculerMatriceT(Point3D.Y);
*/
            /*camera.setMatrice(new Matrix33(new double[]{1, 0, 0,
                    0, 1, 0, 0, 0, -1}));
*/
            scene().cameraActive(camera);


            System.out.println("Scene= " + scene());
        } catch (IOException | InterpreteException e) {


            e.printStackTrace();
        }
    }

    @Override
    public void finit() throws Exception {
        super.finit();
    }

    public static void main(String[] args) {
        TestCrane testCrane = new TestCrane();
        testCrane.setDimension(TestObjet.HD720);
        testCrane.setMaxFrames(1);
        testCrane.setPublish(true);
        new Thread(testCrane).start();

    }

}
