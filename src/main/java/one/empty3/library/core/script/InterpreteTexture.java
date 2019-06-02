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

package one.empty3.library.core.script;

import one.empty3.library.ECBufferedImage;
import one.empty3.library.ITexture;
import one.empty3.library.TextureCol;
import one.empty3.library.TextureImg;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class InterpreteTexture implements Interprete {

    private String rep;
    private int position;

    public InterpreteConstants constant() {
        return null;
    }

    public int getPosition() {
        return position;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public Object interprete(String text, int pos) throws InterpreteException {
        ITexture tc = null;

        boolean pass = false;
        try {
            InterpreteCouleur ic = new InterpreteCouleur();
            Color c = (Color) ic.interprete(text, pos);
            pos = ic.getPosition();
            pass = true;

            tc = new TextureCol(c);

        } catch (InterpreteException ex) {
        }
        if (!pass) {
            try {
                InterpreteNomFichier inf = new InterpreteNomFichier();
                inf.interprete(text, pos);
                pos = inf.getPosition();
                File f = (File) inf.interprete(text, pos);
                pos = inf.getPosition();
                pass = true;

                try {
                    tc = new TextureImg(new ECBufferedImage(ImageIO.read(f)));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (InterpreteException ex) {
            }
        }

        this.position = pos;

        return tc;
    }

    public void setConstant(InterpreteConstants c) {

    }

    public void setRepertoire(String r) {
        this.setRep(r);

    }

}
