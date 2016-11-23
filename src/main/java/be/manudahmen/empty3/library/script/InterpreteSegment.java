/*

 Vous êtes libre de :

 */
/**
 *
 */
package be.manudahmen.empty3.library.script;

import be.manudahmen.empty3.library.object.ColorTexture;
import be.manudahmen.empty3.library.object.Point3D;
import be.manudahmen.empty3.library.object.SegmentDroite;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         15 oct. 2011
 */
public class InterpreteSegment implements Interprete {

    private String repertoire;
    private int pos;
    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#constant()
     */

    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }
    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#getPosition()
     */

    @Override
    public int getPosition() {
        // TODO Auto-generated method stub
        return pos;
    }

    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#interprete(java.lang.String, int)
     */
    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        InterpretesBase isb;
        ArrayList<Integer> pattern;
        isb = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(isb.BLANK);
        pattern.add(isb.LEFTPARENTHESIS);
        pattern.add(isb.BLANK);
        isb.compile(pattern);
        isb.read(text, pos);
        pos = isb.getPosition();

        InterpretePoint3DBAK ip3 = new InterpretePoint3DBAK();
        Point3D p1 = (Point3D) ip3.interprete(text, pos);
        pos = ip3.getPosition();
        ip3 = new InterpretePoint3DBAK();
        Point3D p2 = (Point3D) ip3.interprete(text, pos);
        pos = ip3.getPosition();

        InterpreteCouleur ic = new InterpreteCouleur();
        Color c = (Color) ic.interprete(text, pos);
        pos = ic.getPosition();

        isb = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(isb.BLANK);
        pattern.add(isb.RIGHTPARENTHESIS);
        pattern.add(isb.BLANK);
        isb.compile(pattern);
        isb.read(text, pos);
        pos = isb.getPosition();

        this.pos = pos;

        SegmentDroite sd = new SegmentDroite(p1, p2);
        sd.texture(new ColorTexture(c));

        return sd;
    }

    /* (non-Javadoc)
     * @see be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#setConstant(be.ibiiztera.md.pmatrix.pushmatrix.scripts.InterpreteConstants)
     */
    @Override
    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
