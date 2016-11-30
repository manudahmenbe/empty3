/**
 * *
 * Global license : * CC Attribution
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.emptycanvas.library.empty3.library.object.colorcomp;

import java.awt.*;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public abstract class Colors {

    public abstract Color add(Color c1, Color c2, double pond1, double pond2);

    public abstract Color add(Color[] cs, double[] pond);
}
