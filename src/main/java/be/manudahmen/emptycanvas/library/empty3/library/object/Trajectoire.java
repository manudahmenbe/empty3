/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.object;

public interface Trajectoire {

    boolean asuivant();

    int frame();

    void frame(int f);

    Point3D point();

    double t();

    void t(double t);

    double tDebut();

    void tDebut(double t);

    double tFin();

    void tFin(double t);
}
