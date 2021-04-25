package test4;

import one.empty3.library.*;
import one.empty3.library.core.testing.*;
import one.empty3.library.core.tribase.Tubulaire3;

public class PerforageVertical extends TestObjetSub {
    public PerforageVertical() {
    }

    public void ginit() {
        TRI tri = new TRI(Point3D.O0, Point3D.Z, Point3D.X);
        scene().add(tri);
        Tubulaire3 tubulaire3 = new Tubulaire3();
        tubulaire3.getSoulCurve().getElem().getCoefficients().getData1d().add(new Point3D(Math.sqrt(2), 0., Math.sqrt(2)));
        tubulaire3.getSoulCurve().getElem().getCoefficients().getData1d().add(new Point3D(Math.sqrt(2), 0., Math.sqrt(2)).plus(Point3D.Y));
        tubulaire3.getDiameterFunction().getElem().setFormulaX("" + Math.sqrt(2.));
        scene().add(tubulaire3);
        Tubulaire3 cs1 = new Tubulaire3();
        Tubulaire3 cs2 = new Tubulaire3();
        cs1.getSoulCurve().getElem().getCoefficients().getData1d().add(Point3D.O0);
        cs1.getSoulCurve().getElem().getCoefficients().getData1d().add(Point3D.X);
        cs1.getSoulCurve().getElem().getCoefficients().getData1d().add(Point3D.X.moins(Point3D.Y));
        cs2.getSoulCurve().getElem().getCoefficients().getData1d().add(Point3D.O0);
        cs2.getSoulCurve().getElem().getCoefficients().getData1d().add(Point3D.Z);
        cs2.getSoulCurve().getElem().getCoefficients().getData1d().add(Point3D.Z.moins(Point3D.Y));
        scene().add(cs1);
        scene().add(cs2);
        Sphere sphere1 = new Sphere(P.n(0., 1., 0.3), 0.3);
        Sphere sphere2 = new Sphere(P.n(0.3, 1., 0.), 0.3);
        scene().add(sphere1);
        scene().add(sphere2);
        Camera camera = new Camera(Point3D.Z.mult(-4.), Point3D.O0, Point3D.Z.plus(Point3D.X));
        scene().cameras().add(camera);
        camera.declareProperties();
        scene().cameraActive(camera);

    }

    public static void main(String[] args) {
        PerforageVertical perforageVertical = new PerforageVertical();
        perforageVertical.setMaxFrames(10000);
        perforageVertical.setPublish(true);
        perforageVertical.setGenerate(GENERATE_MODEL|GENERATE_IMAGE|GENERATE_MOVIE);
        Thread thread = new Thread(perforageVertical);
        thread.start();

    }
}
