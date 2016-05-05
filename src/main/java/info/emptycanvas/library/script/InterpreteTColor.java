/*

 Vous êtes libre de :

 */
package info.emptycanvas.library.script;

import info.emptycanvas.library.object.ECBufferedImage;
import info.emptycanvas.library.object.TColor;

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
