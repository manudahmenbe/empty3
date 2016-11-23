/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.script;

import be.manudahmen.empty3.library.tribase.Tubulaire;

public class InterpreteTubes implements Interprete {

    private String repertoire;
    private int pos;

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPosition() {
        // TODO Auto-generated method stub
        return pos;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        Tubulaire t = new Tubulaire();

        return t;
    }

    @Override
    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
