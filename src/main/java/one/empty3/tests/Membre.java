package one.empty3.tests;

import one.empty3.library.ColorTexture;
import one.empty3.library.Matrix33;
import one.empty3.library.Representable;

import java.awt.*;

public class Membre {
    private final Representable representable;

    public Membre(Representable representable) {
        this.representable = representable;
        representable.texture(new ColorTexture(Color.BLACK));


    }

    public void addMembre(Membre membre, Matrix33 rotationMin, Matrix33 rotationMax) {

    }

    public void addObjectContraint(RealObject realObject, Matrix33 matrixRelative) {

    }

    public Representable getRepresentable() {
        return representable;
    }
}
