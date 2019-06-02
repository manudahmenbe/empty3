/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */
/**
 *
 */
package one.empty3.library.core.script;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         27 oct. 2011
 */
public class InterpreteNomFichier implements Interprete {

    private int pos;
    private String repertoire;

    /*
     * (non-Javadoc) @see
     * be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#constant()
     */
    @Override
    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc) @see
     * be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#getPosition()
     */
    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public Object interprete(String text, int pos) throws InterpreteException {
        try {
            int pos1 = text.indexOf("\"", pos);
            int pos2 = text.indexOf("\"", pos1 + 1);

            this.pos = pos2 + 1;

            return InterpreteIO.getFile(text.substring(pos1 + 1, pos2), repertoire);
            //new File(repertoire+File.separator+text.substring(pos1+1, pos2));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterpreteNomFichier.class.getName()).log(Level.SEVERE, null, ex);
            throw new InterpreteException(ex);
        }
    }

    /*
     * (non-Javadoc) @see
     * be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#setConstant(be.ibiiztera.md.pmatrix.pushmatrix.scripts.InterpreteConstants)
     */
    @Override
    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub
    }

    @Override
    public void setRepertoire(String r) {
        this.repertoire = r;
    }
    /*
     * (non-Javadoc) @see
     * be.ibiiztera.md.pmatrix.pushmatrix.scripts.Interprete#interprete(java.lang.String,
     * int)
     */

}
