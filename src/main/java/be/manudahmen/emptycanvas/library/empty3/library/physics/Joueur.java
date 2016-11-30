package be.manudahmen.emptycanvas.library.empty3.library.physics;

import java.awt.*;
import java.net.URL;


public class Joueur {
    public String nom;
    public Color color;
    public URL avatar;
    public URL email;
    public String password;
    public int billes;

    public Joueur(String text, Color color2) {
        this.nom = text;
        this.color = color2;
    }

}
