/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.script;

public class InterpreteFunction implements Interprete {

    private String repertoire;

    public void addVars(String string) {
        // TODO Auto-generated method stub

    }

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPosition() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        // TODO Auto-generated method stub
        return null;
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
