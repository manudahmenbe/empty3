package one.empty3.tests;

import one.empty3.library.*;
import one.empty3.library.core.lighting.Colors;

public class Coque extends RepresentableConteneur {
    StructureMatrix<Point3D> pointsAccrocheLateraux = new StructureMatrix<Point3D>(1, Point3D.class);

    public Coque(Voiture voiture) {
        pointsAccrocheLateraux.setElem(P.n(voiture.getLongueur(), voiture.getHauteurPorte()/3, 0.), 0);
        pointsAccrocheLateraux.setElem(P.n(voiture.getEspacementRoues()/2, voiture.getHauteurPorte()/2, 0.), 1);
        pointsAccrocheLateraux.setElem(P.n(voiture.getLongueur()-voiture.getEpaisseurRoue()/3, voiture.getHauteurPorte(), 0.), 2);
        pointsAccrocheLateraux.setElem(P.n(-voiture.getEspacementRoues(), voiture.getHauteurCoffre(), 0.), 3);
        pointsAccrocheLateraux.setElem(P.n(-voiture.getLongueur()+30., voiture.getHauteurCoffre(), 0.), 4);
        pointsAccrocheLateraux.setElem(P.n(-voiture.getLongueur(), voiture.getHauteurCoffre(), 0.), 5);

        pointsAccrocheLateraux.setElem(P.n(-voiture.getLongueur(), voiture.getHauteurBasCaisse(), 0.), 5);
        pointsAccrocheLateraux.setElem(P.n(-voiture.getLongueur()+30., voiture.getHauteurBasCaisse(), 0.), 4);
        pointsAccrocheLateraux.setElem(P.n(-voiture.getEspacementRoues(), voiture.getHauteurBasCaisse(), 0.), 3);
        pointsAccrocheLateraux.setElem(P.n(voiture.getLongueur()-voiture.getEpaisseurRoue()/3, voiture.getHauteurBasCaisse(), 0.), 2);
        pointsAccrocheLateraux.setElem(P.n(voiture.getEspacementRoues()/2, voiture.getHauteurBasCaisse(), 0.), 1);
        pointsAccrocheLateraux.setElem(P.n(voiture.getLongueur(), voiture.getHauteurBasCaisse(), 0.), 0);



        Point3D[] gauche = new Point3D[pointsAccrocheLateraux.getData1d().size() / 2];
        Point3D[] droit = new Point3D[pointsAccrocheLateraux.getData1d().size() / 2];

        for(int i = 0 ; i<gauche.length; i++) {
            gauche[i] = new Point3D(0., 0., voiture.getLargeur()).plus(pointsAccrocheLateraux.getElem(i));
            droit[i] = new Point3D(0., 0., -voiture.getLargeur()).plus(pointsAccrocheLateraux.getElem(i));
        }


        add( new Polygon(pointsAccrocheLateraux.getData1d().toArray(gauche), Colors.random()));
        add( new Polygon(pointsAccrocheLateraux.getData1d().toArray(droit), Colors.random()));
    }
}
