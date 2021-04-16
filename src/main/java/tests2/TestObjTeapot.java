package tests2;

import one.empty3.library.*;
import one.empty3.library.core.nurbs.CameraInPath;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.objloader.E3Model;
import one.empty3.library.objloader.ModelLoaderOBJ;

import javax.swing.text.ZoneView;
import java.awt.*;

public class TestObjTeapot extends TestObjetSub {
    private CameraInPath cameraInPath;

    public void ginit() {
        z.setDisplayType(ZBufferImpl.DISPLAY_ALL);
        E3Model modelLoaderOBJ = ModelLoaderOBJ.LoadModelE3("resources/teapot.obj", "");
        scene().add(modelLoaderOBJ);
        //camera().getEye().setZ(-5.);
        setMaxFrames(120);
        frame = 30;
        Circle circle = new Circle(new Axe(Point3D.Y, Point3D.Y.mult(-1.)), 10.);
        circle.texture(new ColorTexture(Color.BLACK));
        cameraInPath = new CameraInPath(circle, Point3D.Y);
        scene().add(circle);
        scene().texture(new ColorTexture(Color.YELLOW));
        scene().cameraActive(cameraInPath);

        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.O0, Color.YELLOW);
        scene().lumieres().add(lumierePonctuelle);

    }

    public void finit() {
        cameraInPath.setT(1.0 * frame() / getMaxFrames());
        Point3D eye = cameraInPath.getEye();
        //scene().cameraActive().setEye(eye);
        System.out.println(eye);
        eye = scene().cameraActive().eye();
        System.out.println(eye);
        System.out.println(cameraInPath.getLookat());
    }

    public static void main(String[] args) {
        TestObjTeapot testObjTeapot = new TestObjTeapot();
        testObjTeapot.setPublish(true);
        new Thread(testObjTeapot).start();
    }
}
