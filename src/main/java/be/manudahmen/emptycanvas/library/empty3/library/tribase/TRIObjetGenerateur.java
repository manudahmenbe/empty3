/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.tribase;

import be.manudahmen.emptycanvas.library.empty3.library.object.Point3D;
import be.manudahmen.emptycanvas.library.empty3.library.object.TRI;

/**
 * Implémentations requises: TRIGenerable, TourDeRevolution, Tubulaire, Spheres
 *
 * @author manuel
 */
public interface TRIObjetGenerateur {

    Point3D coordPoint3D(int x, int y);

    boolean getCirculaireX();

    void setCirculaireX(boolean cx);

    boolean getCirculaireY();

    void setCirculaireY(boolean cy);

    int getMaxX();

    void setMaxX(int maxX);

    int getMaxY();

    void setMaxY(int maxX);

    Point3D getPoint3D(TRI[] tris, int numX, int numY, double ratioX, double ratioY);

    /**
     * *
     *
     * @param numX           numéro de valeur de x par rapport à maxX
     * @param numY           numéro de valeur de y par rapport à maxY
     * @param tris_LEFT_NORD
     */
    void getTris(int numX, int numY, TRI[] tris);

}
