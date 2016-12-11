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

package be.manudahmen.empty3.core.physics;

import be.manudahmen.empty3.Point3D;

import java.awt.*;

public interface IPoint {
    Color getColor();

    void setColor(Color color);

    Point3D getPosition();

    void setPosition(Point3D position);

    Point3D getVitesse();

    void setVitesse(Point3D vitesse);

    double getAttraction();

    void setAttraction(double attraction);

    double getRepulsion();

    void setRepulsion(double repulsion);

    double getMasse();

    void setMasse(double masse);

    double getAmortissement();

    void setAmortissement(double amortissement);

}