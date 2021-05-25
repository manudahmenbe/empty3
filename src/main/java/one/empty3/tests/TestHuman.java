package one.empty3.tests;

import one.empty3.library.*;
import one.empty3.library.core.testing.TestObjet;
import one.empty3.library.core.testing.TestObjetSub;

public class TestHuman extends TestObjetSub {

    private Human humanoidModel;

    public void ginit() {
        setMaxFrames(18);
        z().setDisplayType(ZBufferImpl.DISPLAY_ALL);
        humanoidModel = new Human();
        humanoidModel.init();
        humanoidModel.update();
        scene().add(humanoidModel);
        Camera c = new Camera(Point3D.Z.mult(-8.), Point3D.O0);
        scene().cameras().add(c);
        scene().cameraActive(c);
    }

    public void finit() {
    }

    public static void main(String [] args) {
        TestHuman testHumanModel = new TestHuman();
        testHumanModel.setPublish(true);
        testHumanModel.setGenerate(testHumanModel.getGenerate()| TestObjet.GENERATE_MODEL);
        testHumanModel.setDimension(TestObjet.VGAZIZI);
        new Thread(testHumanModel).start();
    }

}
