package test3;

import one.empty3.library.*;
import one.empty3.library.Polygon;
import one.empty3.library.core.script.InterpreteException;
import one.empty3.library.core.script.InterpretePolygone;
import one.empty3.library.core.testing.TestObjet;
import one.empty3.library.core.testing.TestObjetSub;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static one.empty3.library.P.p;

public class TestCrane extends TestObjetSub {
    public void ginit() {
        Properties properties = new Properties();
        try {
            properties.load(new BufferedReader(new FileReader("samples/head.properties")));
            String[] strings = {"frontal.x",
                    "frontal.-x",
                    "nose.x",
                    "nose.-x",
                    "joue.x",
                    "joue.-x",
                    "temporal.x",
                    "temporal.-x"};
            for(String polyString : strings) {
                polyString = properties.getProperty(polyString);
                Polygon polygon = (Polygon) new InterpretePolygone().interprete(polyString, 0);
                polygon.texture(new ColorTexture(Color.BLACK));
                scene().add(polygon);
            }
            scene().cameraActive(new Camera(
                            Point3D.Y.mult(10), Point3D.O0, Point3D.X));


            System.out.println("Scene= "+scene());
        } catch (IOException | InterpreteException e) {


            e.printStackTrace();
        }
    }

    @Override
    public void finit() throws Exception {
        super.finit();
    }

    public static void main(String [] args) {
        TestCrane testCrane = new TestCrane();
        testCrane.setDimension(TestObjet.HD720);
        testCrane.setMaxFrames(1);
        testCrane.setPublish(true);
        new Thread(testCrane).start();

    }

}
