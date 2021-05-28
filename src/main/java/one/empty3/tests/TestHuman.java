package one.empty3.tests;

import one.empty3.library.*;
import one.empty3.library.Polygon;
import one.empty3.library.core.testing.TestObjet;
import one.empty3.library.core.testing.TestObjetSub;

import java.awt.*;

public class TestHuman extends TestObjetSub {

    public synchronized void ginit() {
        setMaxFrames(1);
        z().setDisplayType(ZBufferImpl.SURFACE_DISPLAY_COL_TRI);


        Human humanModel = new Human();
        humanModel.init();
        humanModel.update();

        Polygon polygon = new Polygon();
        polygon.getPoints().add(new Point3D(-100., -100., 0.));
        polygon.getPoints().add(new Point3D(100., -100., 0.));
        polygon.getPoints().add(new Point3D(100., 100., 0.));
        polygon.getPoints().add(new Point3D(-100., 100., 0.));

        polygon.texture(new ColorTexture(Color.GRAY));

        scene().add(humanModel);
        Camera c = new Camera(new Point3D(-10.0, 0.0, 1.0), new Point3D(0., 0.0, 0.0), new Point3D(0.0,0.0,1.0));
        c.setMatrice(c.getMatrice().tild());
        scene().cameraActive(c);

        humanModel.add(polygon);
    }

    public void finit() {
    }

    public static void main(String [] args) {
        TestHuman testHumanModel = new TestHuman();
        testHumanModel.setPublish(true);
        testHumanModel.setGenerate(testHumanModel.getGenerate()| TestObjet.GENERATE_MODEL);
        testHumanModel.setDimension(TestObjet.VGA);
        new Thread(testHumanModel).start();
    }

}
