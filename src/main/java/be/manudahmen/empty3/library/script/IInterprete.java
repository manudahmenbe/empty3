/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.script;

import be.manudahmen.empty3.library.object.Representable;

public interface IInterprete {

    IInterprete interprete(int TYPE);

    IInterprete liste(int TYPE);

    Representable resultat();

    Class<Representable> typeResultat(int TYPE);
}
