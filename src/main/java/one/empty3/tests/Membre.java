package one.empty3.tests;

import one.empty3.library.Matrix33;
import one.empty3.library.Representable;

public class Membre {
    private final Representable representable;

    public Membre(Representable representable) {
        this.representable = representable;


    }

    public void addMembre(Membre membre, Matrix33 rotationMin, Matrix33 rotationMax) {

    }

    public void addObjectContraint(RealObject realObject, Matrix33 matrixRelative) {

    }

    public Representable getRepresentable() {
        return representable;
    }
}
