package be.manudahmen.emptycanvas.library.empty3.library.physics;

import be.manudahmen.emptycanvas.library.empty3.library.object.Matrix33;
import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Ball {


    public String nom;
    public Color color;
    public Point3D vitesse;
    public Point3D forceAttaction;
    public Point3D forceRepulsion;
    public double masse;
    public double energie;
    public Point3D position;
    public BufferedImage texture;
    public Matrix33 rotation;

    public Ball(String nom, Color color, Point3D vitesse, double masse,
                double energie, Point3D position, BufferedImage texture,
                Matrix33 rotation) {
        super();
        this.nom = nom;
        this.color = color;
        this.vitesse = vitesse;
        this.masse = masse;
        this.energie = energie;
        this.position = position;
        this.texture = texture;
        this.rotation = rotation;
    }
}
