package tests2;

import one.empty3.library.Axe;
import one.empty3.library.Circle;
import one.empty3.library.Point3D;
import one.empty3.library.core.nurbs.CameraInPath;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.objloader.E3Model;
import one.empty3.library.objloader.ModelLoaderOBJ;

public class TestObjTeapot extends TestObjetSub {
    private CameraInPath cameraInPath;

    public void ginit() {
        E3Model modelLoaderOBJ = ModelLoaderOBJ.LoadModelE3("resources/teapot.obj", "");
        scene().add(modelLoaderOBJ);
        camera().getEye().setZ(-5.);
        setPublish(true);
        setMaxFrames(8);
        cameraInPath = new CameraInPath(new Circle(new Axe(Point3D.Z, Point3D.Z.mult(-1.)), 10.), Point3D.Z);

        scene().cameraActive(cameraInPath);
    }

    public void finit() {
        cameraInPath.setT(1.0*frame()/getMaxFrames());
        Point3D eye = cameraInPath.getEye();
        //scene().cameraActive().setEye(eye);
        System.out.println(eye);
        eye = scene().cameraActive().eye();
        System.out.println(eye);
        System.out.println(cameraInPath.getLookat());
    }

    public static void main(String [] args) {
        TestObjTeapot testObjTeapot = new TestObjTeapot();
        new Thread(testObjTeapot).start();
    }
}
