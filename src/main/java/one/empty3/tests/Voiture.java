package one.empty3.tests;

import one.empty3.library.RepresentableConteneur;

public class Voiture extends RepresentableConteneur {
        public static final double LARGEUR_ROUE = 60.0;
        RoueVoiture roueVoiture;
        Chassis chassis;
        Coque coque = new Coque();
        PorteAvant porteAvant = new PorteAvant();
        PorteArriere porteArrieres = new PorteArriere();
        Coffre coffre = new Coffre();
        PhareAvant phareGros = new PhareAvant();
        PhareArriere phareArriere =  new PhareArriere();
        SiegeAvant siegeAvant = new SiegeAvant();
        SiegeArriere siegeArriere = new SiegeArriere();
        PareChoc pareChoc = new PareChoc();
        PareBrise pareBrise =  new PareBrise();
        Mecanique mecanique = new Mecanique();
        private double largeur;
        private double longueur;
        private double espacementRoues = 10.;

        public Voiture() {
            super();
            chassis = new Chassis(this);
            roueVoiture = new RoueVoiture(this);
            add(chassis);
        }

        public double getLargeur() {
            return largeur;
        }

        public double getLongueur() {
                return longueur;
        }

        public double getEspacementRoues() {
                return espacementRoues;
        }

        public double getEpaisseurRoue() {
                return 40;
        }
}
