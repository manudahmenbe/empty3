package test4;

import one.empty3.library.*;
import one.empty3.library.Polygon;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.core.tribase.Tubulaire3;

import java.awt.*;

public class TestHumain2 extends TestObjetSub {
    public void tubeAddPoint(Tubulaire3 tube, Point3D p) {
        tube.getSoulCurve().getElem().getCoefficients().getData1d().add(p);
    }

    public void ginit() {
        setMaxFrames(180);
        z.setDisplayType(ZBufferImpl.DISPLAY_ALL);
        scene().lumieres().add(new LumierePonctuelle(new Point3D(10., 10., 2.), Color.BLUE));
    }

    public void finit() {
        scene().cameras().clear();
        scene().getObjets().getData1d().clear();
        Camera c = new Camera2Quad(
                z(), new Polygon(new Point3D[]{
                        new Point3D(-5., -5., -80.),
                        new Point3D(5.,  -5., -80.),
                        new Point3D(5., 5., -80.),
                        new Point3D(-5.,  5., -80.)},
                        Color.BLUE),
                new Polygon(new Point3D[]{
                        new Point3D(-50., -50., 0.),
                        new Point3D(50.,  -50., 0.),
                        new Point3D(50., 50., 0.),
                        new Point3D(-50.,  50., 0.)},
                        Color.BLUE)
        );
        scene().cameras().add(c);
        c.declareProperties();
        scene().cameraActive(c);

        Humain humain = new Humain();
        scene().add(humain);
        humain.setT(frame()/25.);
        humain.init();
    }

    public static void main(String[] args) {
        TestHumain2 testHumain = new TestHumain2();
        testHumain.setPublish(true);
        new Thread(testHumain).start();
    }

}

