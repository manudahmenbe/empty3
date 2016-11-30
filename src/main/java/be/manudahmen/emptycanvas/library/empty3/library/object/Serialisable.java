/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.object;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 * @author Manuel DAHMEN
 */
public interface Serialisable {

    Serialisable decode(DataInputStream in);

    int encode(DataOutputStream out);

    int type();
}
