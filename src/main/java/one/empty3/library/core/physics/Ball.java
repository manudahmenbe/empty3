/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package one.empty3.library.core.physics;


import one.empty3.library.*;

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
