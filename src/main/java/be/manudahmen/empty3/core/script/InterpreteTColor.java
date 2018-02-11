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

/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.core.script;

import be.manudahmen.empty3.ECBufferedImage;
import be.manudahmen.empty3.TColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InterpreteTColor implements Interprete {

    public boolean success;
    private String repertoire;
    private int pos;

    public InterpreteConstants constant() {
        // TODO Auto-generated method stub
        return null;
    }

    public int getPosition() {
        return pos;
    }

    public Object interprete(String text, int pos) throws InterpreteException {

        success = false;

        TColor tc = null;

        InterpretesBase ib;
        ib = new InterpretesBase();
        ArrayList<Integer> pattern;
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);

        pos = ib.getPosition();

        try {
            InterpreteCouleur ic = new InterpreteCouleur();

            Color c = (Color) ic.interprete(text, pos);

            tc = new TColor(c);

            pos = ic.getPosition();

            success = true;
        } catch (InterpreteException ex) {
            try {
                InterpreteNomFichier inf = new InterpreteNomFichier();

                inf.setRepertoire(repertoire);
                File f = (File) inf.interprete(text, pos);

                ECBufferedImage bi = new ECBufferedImage(ImageIO.read(f));

                tc = new TColor(bi);

                pos = inf.getPosition();
                /*
                 InterpretePGM iPGM = new InterpretePGM();
				
                 ECBufferedImage ec = (ECBufferedImage) iPGM.interprete(text, pos);
				
                 tc = new ColorTexture(ec);
				
                 this.pos = inf.getPosition();
                 */
                success = true;
            } catch (FileNotFoundException ex2) {
                Logger.getLogger(InterpreteTColor.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("File not found");

            } catch (IOException ex1) {
                Logger.getLogger(InterpreteTColor.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("IO error");
            } catch (InterpreteException ex3) {
                Logger.getLogger(InterpreteTColor.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Interprete Error");
            } catch (Exception ex4) {
                Logger.getLogger(InterpreteTColor.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error");
            }
        }

        ib = new InterpretesBase();
        pattern = new ArrayList<Integer>();
        pattern.add(ib.BLANK);
        ib.compile(pattern);
        ib.read(text, pos);

        pos = ib.getPosition();

        this.pos = pos;

        return tc;

    }

    public void setConstant(InterpreteConstants c) {
        // TODO Auto-generated method stub

    }

    public void setRepertoire(String r) {
        this.repertoire = r;
    }

}
