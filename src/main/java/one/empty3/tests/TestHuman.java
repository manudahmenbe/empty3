package one.empty3.tests;

import one.empty3.library.*;
import one.empty3.library.core.nurbs.ParametricCurve;
import one.empty3.library.core.testing.TestObjet;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.core.tribase.TubulaireN2;

import java.awt.*;

public class TestHuman extends TestObjetSub {

    private Human humanModel;

    public synchronized void ginit() {
        setMaxFrames(18);
        z().setDisplayType(ZBufferImpl.DISPLAY_ALL);
        humanModel = new Human();
        humanModel.init();
        humanModel.update();
        scene().add(humanModel);
        Camera c = new Camera(Point3D.Z.mult(-8.), Point3D.O0);
        scene().cameras().add(c);
        scene().cameraActive(c);

        RepresentableConteneur rc = new RepresentableConteneur();
        for(Representable r : humanModel.actualBody.getListRepresentable()) {
            if(r instanceof TubulaireN2) {
                ParametricCurve elem = ((TubulaireN2) r).getSoulCurve().getElem();
                elem.texture(new ColorTexture(Color.BLUE));
                if(elem==null)
                    System.out.println("Error parametric curve == null // TubulaireN2.getSoulCurve");
                else
                    System.out.println(""+elem.getClass()+" "+((LineSegment)elem).getOrigine()+" "
                                    +((LineSegment)elem).getExtremite()+" "+((LineSegment)elem).getLength()+" ");
                rc.add(elem);
            }
        }
        humanModel.add(rc);

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
