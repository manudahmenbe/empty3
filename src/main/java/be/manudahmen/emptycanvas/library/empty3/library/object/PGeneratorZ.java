/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.object;

import java.awt.*;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         17 oct. 2011
 */
public abstract class PGeneratorZ extends Representable {

    public abstract void dessine(ZBuffer z);

    public void dessineStructure(ZBuffer zBufferImpl) {
        // TODO Auto-generated method stub

    }

    public abstract void generate(ZBuffer z);

    public int hauteurImage(ZBuffer z) {
        return z.resY();
    }

    public int largeurImage(ZBuffer z) {
        return z.resX();
    }

    public Point point(ZBuffer z, Point3D p) {
        return z.coordonneesPoint2D(p);
    }
}
