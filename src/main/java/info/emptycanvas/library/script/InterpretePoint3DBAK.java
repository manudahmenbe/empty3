/*

 Vous êtes libre de :

 */
package info.emptycanvas.library.script;

import java.util.ArrayList;

import info.emptycanvas.library.object.Point3D;

public class InterpretePoint3DBAK implements Interprete {

    private String repertoire;
    private InterpreteConstants c;
    private int pos;

    @Override
    public InterpreteConstants constant() {
        return c;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public Object interprete(String point, int pos) throws InterpreteException {
        InterpretesBase ib = new InterpretesBase();
        ArrayList<Integer> pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        pattern.add(ib.DECIMAL);
        pattern.add(ib.BLANK);
        pattern.add(ib.COMA);
        pattern.add(ib.BLANK);
        pattern.add(ib.DECIMAL);
        pattern.add(ib.BLANK);
        pattern.add(ib.COMA);
        pattern.add(ib.BLANK);
        pattern.add(ib.DECIMAL);
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);

        ib.compile(pattern);
        ArrayList<Object> os = ib.read(point, pos);
        this.pos = ib.getPosition();

        return new Point3D((Double) os.get(3), (Double) os.get(7),
                (Double) os.get(11));
    }

    @Override
    public void setConstant(InterpreteConstants c) {
        this.c = c;
    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
