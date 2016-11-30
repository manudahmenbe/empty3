/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.script;

import be.manudahmen.emptycanvas.library.empty3.library.object.Scene;

import java.io.File;

public interface SceneLoader {

    void loadFObject(File file, Scene sc) throws Exception;
}
