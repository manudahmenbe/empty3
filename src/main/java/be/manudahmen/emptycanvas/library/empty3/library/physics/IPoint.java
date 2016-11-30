package be.manudahmen.emptycanvas.library.empty3.library.physics;

import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;

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