/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.script;

import java.util.ArrayList;

public interface Definition {

    void addOperateurs(ArrayList<Pile.Operateur> types);

    void addTypes(ArrayList<Pile.Type> types);

    void addVariable(ArrayList<Pile.Variable> types);
}
