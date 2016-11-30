/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.emptycanvas.library.empty3.library.script;

import be.manudahmen.emptycanvas.library.empty3.library.object.ID;
import be.manudahmen.emptycanvas.library.empty3.library.object.Scene;

import java.io.File;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public interface Chargeur {

    void chargerFichierEntier(File f, Scene scene);

    void chercherObjet(ID id, Scene scene);

    void modifierObjet(ID id, String objet, Scene scene);

    String[] supportType();
}
