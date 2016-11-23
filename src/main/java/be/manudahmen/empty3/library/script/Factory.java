/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.script;

import be.manudahmen.empty3.library.object.Scene;

public interface Factory {

    IInterprete interprete(String id);

    void lancerInterprete(String script, Scene scene);
}
