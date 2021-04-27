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
        fctXY.setFormulaX("60.0");
        t.getDiameterFunction().setElem(fctXY);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(-voiture.LARGEUR_ROUE/2, 35., voiture.getLargeur()-voiture.getEpaisseurRoue()));
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(-voiture.LARGEUR_ROUE/2, 35., voiture.getLargeur()));

        add(t);


        t = new Tubulaire3();
        fctXY = new FctXY();
        fctXY.setFormulaX("60.0");
        t.getDiameterFunction().setElem(fctXY);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(-voiture.LARGEUR_ROUE/2, 35., -voiture.getLargeur()+voiture.getEpaisseurRoue()));
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(-voiture.LARGEUR_ROUE/2, 35., -voiture.getLargeur()));
        add(t);


        t = new Tubulaire3();
        fctXY = new FctXY();
        fctXY.setFormulaX("60.0");
        t.getDiameterFunction().setElem(fctXY);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(voiture.LARGEUR_ROUE/2, 35., voiture.getLargeur()-voiture.getEpaisseurRoue()));
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(voiture.LARGEUR_ROUE/2, 35., voiture.getLargeur()));

        add(t);


        t = new Tubulaire3();
        t = new Tubulaire3();
        fctXY = new FctXY();
        fctXY.setFormulaX("60.0");
        t.getDiameterFunction().setElem(fctXY);
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(voiture.LARGEUR_ROUE/2, 35., -voiture.getLargeur()+voiture.getEpaisseurRoue()));
        t.getSoulCurve().getElem().getCoefficients().setElem(new Point3D(voiture.LARGEUR_ROUE/2, 35., -voiture.getLargeur()));
        add(t);
    }
}
