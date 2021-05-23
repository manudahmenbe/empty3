package one.empty3.tests;

import one.empty3.apps.pad.models.HumanoidModel;
import one.empty3.library.*;
import one.empty3.library.core.nurbs.CourbeParametriquePolynomialeBezier;
import one.empty3.library.core.nurbs.FctXY;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.core.tribase.Tubulaire3;

import java.awt.*;

public class TestHumanModel extends TestObjetSub {

    private Human humanoidModel;

    public void ginit() {
        setMaxFrames(18);
        z().setDisplayType(ZBufferImpl.DISPLAY_ALL);
        humanoidModel = new Human();
        humanoidModel.init();
        humanoidModel.update();
        scene().add(humanoidModel);
        Camera c = new Camera(Point3D.Z.mult(-4.), Point3D.O0);
        scene().cameras().add(c);
        scene().cameraActive(c);
    }

    public void finit() {
    }

    public static void main(String [] args) {
        TestHumanModel testHumanModel = new TestHumanModel();
        testHumanModel.setPublish(true);

        new Thread(testHumanModel).start();
    }

}
