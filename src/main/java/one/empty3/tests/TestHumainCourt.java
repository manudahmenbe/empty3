package one.empty3.tests;

import one.empty3.library.Camera;
import one.empty3.library.LumierePonctuelle;
import one.empty3.library.Point3D;
import one.empty3.library.ZBufferImpl;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.core.tribase.Tubulaire3;

import java.awt.*;

public class TestHumainCourt extends TestObjetSub {
    public void tubeAddPoint(Tubulaire3 tube, Point3D p) {
        tube.getSoulCurve().getElem().getCoefficients().getData1d().add(p);
    }

    public void ginit() {
        setMaxFrames(675);
        z.setDisplayType(ZBufferImpl.DISPLAY_ALL);
        scene().lumieres().add(new LumierePonctuelle(new Point3D(10., 10., 2.), Color.BLUE));
    }

    public void finit() {
        scene().cameras().clear();
        scene().getObjets().getData1d().clear();
        Camera c = new Camera(Point3D.Z.mult(-120.), Point3D.O0);
        scene().cameras().add(c);
        c.declareProperties();
        scene().cameraActive(c);

        HumainCourt humainCourt = new HumainCourt();
        scene().add(humainCourt);
        humainCourt.setT(frame()/25.);
        humainCourt.init();
    }

    public static void main(String[] args) {
        TestHumainCourt testHumain = new TestHumainCourt();
        testHumain.setPublish(true);
        new Thread(testHumain).start();
    }

}

