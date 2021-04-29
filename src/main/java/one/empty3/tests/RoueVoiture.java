package one.empty3.tests;

import one.empty3.library.Point3D;
import one.empty3.library.RepresentableConteneur;
import one.empty3.library.core.nurbs.Fct1D_1D;
import one.empty3.library.core.nurbs.FctXY;
import one.empty3.library.core.tribase.Tubulaire3;

public class RoueVoiture extends RepresentableConteneur {

    public RoueVoiture(Voiture voiture) {

        Tubulaire3 t = new Tubulaire3();
        FctXY fctXY = new FctXY();
        fctXY.setFormulaX(""+voiture.getRayonRoue());


        t.getDiameterFunction().setElem(fctXY);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(-voiture.getEspacementRoues()/2+voiture.getRayonRoue()/2, voiture.getEpaisseurRoue()/2., voiture.getLargeur()-voiture.getEpaisseurRoue()), 0);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(-voiture.getEspacementRoues()/2, voiture.getEspacementRoues(), voiture.getLargeur()), 1);

        add(t);


        t = new Tubulaire3();
        t.getDiameterFunction().setElem(fctXY);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(-voiture.getEspacementRoues()/2, voiture.getEspacementRoues(), -voiture.getLargeur()+voiture.getEpaisseurRoue()), 0);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(-voiture.getEspacementRoues()/2, voiture.getEspacementRoues(), -voiture.getLargeur()), 1);
        add(t);


        t = new Tubulaire3();
        t.getDiameterFunction().setElem(fctXY);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(voiture.getEspacementRoues()/2, voiture.getEspacementRoues(), voiture.getLargeur()-voiture.getEpaisseurRoue()), 0);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(voiture.getEspacementRoues()/2, voiture.getEspacementRoues(), voiture.getLargeur()), 1);

        add(t);


        t = new Tubulaire3();
        t = new Tubulaire3();
        t.getDiameterFunction().setElem(fctXY);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(voiture.getEspacementRoues()/2, voiture.getEspacementRoues(), -voiture.getLargeur()+voiture.getEpaisseurRoue()), 0);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(voiture.getEspacementRoues()/2, voiture.getEspacementRoues(), -voiture.getLargeur()), 1);
        add(t);
    }
}
