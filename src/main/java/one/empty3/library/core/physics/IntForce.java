package one.empty3.library.core.physics;

import one.empty3.library.*;

/**
 * Created by manuel on 07-06-18.
 */
public interface IntForce {
    void configurer(Bille[] courant);

    Point3D centreMasse();

    Point3D attractionRepulsion(Bille other, Bille p);

    Point3D frottement(Bille p);

    Point3D force(int ind);

    Point3D acc(int ind);

    Point3D vitesse(int ind);

    Point3D position(int ind);

    void calculer();

    double getDistMax();

    void setDistMax(double distMax);

    double getDistMin();

    void setDistMin(double distMin);

    Bille[] getCourant();

    void setCourant(Bille[] courant);

    Bille[] getNext();

    void setNext(Bille[] next);

    double getDt();

    void setDt(double dt);

    double getG();

    void setG(double g);

    double getDistMinFusion();

    void setDistMinFusion(double distMinFusion);

    boolean isFusion();

    void setFusion(boolean fusion);
}
