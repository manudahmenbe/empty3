/**
 * *
 * Global license : * CC Attribution
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.emptycanvas.library.empty3.library.animation;

import be.manudahmen.emptycanvas.library.empty3.library.object.Representable;

/**
 * @param <R>
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public abstract class FonctionTemps<R> extends Fonction {

    public abstract R fonctionTemps(double time);

    public final void inject(Representable r, R value, Object... keys) {
        r.setProperty(value, keys);
    }

}
