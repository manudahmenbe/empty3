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
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public abstract class FonctionModele<R> extends Fonction {

    public abstract R fonctionModele(double time);

    public final void inject(Representable r, R value, Object... keys) {
        r.setProperty(value, keys);
    }
}
