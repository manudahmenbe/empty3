package test4;

import one.empty3.library.*;
import one.empty3.library.core.nurbs.CourbeParametriquePolynomialeBezier;
import one.empty3.library.core.nurbs.FctXY;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.core.tribase.Tubulaire3;

import java.awt.*;

public class TestHumain extends TestObjetSub {
    public void tubeAddPoint(Tubulaire3 tube, Point3D p) {
        tube.getSoulCurve().getElem().getCoefficients().getData1d().add(p);
    }
        public void ginit() {
            setMaxFrames(18);
            z.setDisplayType(ZBufferImpl.DISPLAY_ALL);
            Tubulaire3[] patte = new Tubulaire3[4];
            Point3D tete = new Point3D(0., 21., 0.); //tête
            Point3D queue = new Point3D(1., 0., 1.); // queue
            Sphere tetes = new Sphere(tete, 2.); //sphère
            tetes.texture(new TextureCol(Color.RED));
            queue.texture(new TextureCol(Color.BLACK));

            Cube ventre = new Cube(5.0, P.n(0., 15., 0));
            for (int i = 0; i < 4; i++) {
                patte[i] = new Tubulaire3();
                patte[i].getSoulCurve().getElem().getCoefficients().getData1d().clear();
                patte[i].texture(new TextureCol(Color.ORANGE));
                ((FctXY) (patte[i].getDiameterFunction().getElem())).setFormulaX("0.6");
            }
            Tubulaire3 corps;
            corps = new Tubulaire3();
            corps.getSoulCurve().getElem().getCoefficients().getData1d().clear();
            corps.getSoulCurve().getElem().getCoefficients().setElem(P.n(0.,1.,0.));
            corps.getSoulCurve().getElem().getCoefficients().setElem(P.n(1.,1.,0.));
            corps.texture(new TextureCol(Color.ORANGE));
            ((FctXY) (corps.getDiameterFunction().getElem())).setFormulaX("1.5");
// JAMBE AVANT DROIT
// §1
            for(int i=0; i<2; i++) {
            tubeAddPoint(patte[0], new Point3D(-1., 0.,  2.*(2*i-1)));
            tubeAddPoint(patte[0], new Point3D(0., 0.,  2.*(2*i-1)));
            tubeAddPoint(patte[0], new Point3D(0., 5.,  2.*(2*i-1)));
            tubeAddPoint(patte[0], new Point3D(0., 10.,  2.*(2*i-1)));
            tubeAddPoint(patte[0], new Point3D(0., 11.,  0.));
            tubeAddPoint(patte[0], new Point3D(0., 15.,  0.));
            tubeAddPoint(patte[0], new Point3D(0., 20.,  0.));
            tubeAddPoint(patte[0], new Point3D(0., 21.,  0.));
            }
            for(int i=0; i<2; i++) {
                tubeAddPoint(patte[0], new Point3D(0., 20.,  1.*(2*i-1)));
                tubeAddPoint(patte[0], new Point3D(0., 20.,  2.*(2*i-1)));
                tubeAddPoint(patte[0], new Point3D(0., 15.,  2.*(2*i-1)));
                tubeAddPoint(patte[0], new Point3D(0., 10.,  2.*(2*i-1)));
                tubeAddPoint(patte[0], new Point3D(0., 9.,   2.*(2*i-1)));
            }
            for(int i=0; i<2; i++) {
            }
                scene().add(corps);
            scene().add(tetes);
            scene().add(ventre);
            for (int i = 0; i < 4; i ++) {
                scene().add(patte[i]);

            }
            scene().lumieres().add(new LumierePonctuelle(new Point3D(10., 10., 2.), Color.BLUE));
        }

        public void finit() {
            scene().cameras().clear();
            Camera c = new Camera(Point3D.Z.mult(-40.), Point3D.O0, Point3D.Y);
            scene().cameras().add(c);
            c.declareProperties();
            scene().cameraActive(c);
        }

        public static void main(String [] args) {
            TestHumain testHumain = new TestHumain();
            testHumain.setPublish(true);
            new Thread(testHumain).start();
        }

    }

