package test4;
import one.empty3.library.Point3D;
import one.empty3.library.TRI;
import one.empty3.library.core.testing.*;
import one.empty3.library.core.tribase.Tubulaire3;

public class PerforageVertical extends TestObjetSub {
    public PerforageVertical() {
        scene().add(new TRI(Point3D.O0, Point3D.Z, Point3D.X));
        Tubulaire3 tubulaire3 = new Tubulaire3();
        tubulaire3.getSoulCurve().getElem().getCoefficients().getData1d().add(new Point3D(Math.sqrt(2), 0., Math.sqrt(2)));
        tubulaire3.getSoulCurve().getElem().getCoefficients().getData1d().add(new Point3D(Math.sqrt(2), 0., Math.sqrt(2)).plus(Point3D.Y));
        tubulaire3.getDiameterFunction().getElem().setFormulaX(""+Math.sqrt(2.));
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


    }
    public static void main(String [] args) {
        PerforageVertical perforageVertical = new PerforageVertical();
        perforageVertical.setMaxFrames(10000);
        perforageVertical.setPublish(true);
        Thread thread = new Thread(perforageVertical);
        thread.start();

    }
}
