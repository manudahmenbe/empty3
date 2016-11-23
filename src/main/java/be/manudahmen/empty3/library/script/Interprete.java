/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.script;

public interface Interprete {

    InterpreteConstants constant();

    int getPosition();

    Object interprete(String text, int pos) throws InterpreteException;

    void setConstant(InterpreteConstants c);

    void setRepertoire(String r);

}
