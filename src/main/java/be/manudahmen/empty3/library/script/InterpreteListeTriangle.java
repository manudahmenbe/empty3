/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.script;

import be.manudahmen.empty3.library.object.TRI;
import be.manudahmen.empty3.library.object.TRIObject;

import java.util.ArrayList;

public class InterpreteListeTriangle implements Interprete {

    private String repertoire;

    private int pos = 0;

    private int numFacettes;

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        TRIObject fo = new TRIObject();
        InterpretesBase ib;
        ArrayList<Integer> pattern;
        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.LEFTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        pos = ib.getPosition();

        boolean ok = true;
        while (ok) {
            InterpreteTriangle ifacette = new InterpreteTriangle();
            try {
                fo.add((TRI) ifacette.interprete(text, pos));
                if (ifacette.getPosition() > pos) {
                    pos = ifacette.getPosition();
                    numFacettes++;
                }
            } catch (Exception ex) {
                ok = false;
            }
            try {
                InterpretesBase ib1 = new InterpretesBase();
                ArrayList<Integer> pattern1 = new ArrayList<Integer>();
                pattern1.add(ib.COMA);
                ib1.compile(pattern1);
                ib1.read(text, pos);
                pos = ib1.getPosition();
            } catch (InterpreteException ie) {
            }
        }
        System.out.println(numFacettes + "" + text.substring(pos));
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        pattern.add(ib.RIGHTPARENTHESIS);
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);
        this.pos = ib.getPosition();
        return fo;
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
