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

package be.manudahmen.empty3.stl_loader;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;

public class StlFileParser extends StreamTokenizer {

    /**
     * Constructor: object creation and setup
     *
     * @param r The Reader instance
     */
    public StlFileParser(Reader r) {
        super(r);
        setup();
    }

    /**
     * Gets a number from the stream. Note that we don't recognize numbers in
     * the tokenizer automatically because numbers might be in scientific
     * notation, which isn't processed correctly by StreamTokenizer. The number
     * is returned in nval.
     *
     * @return boolean.
     */
    boolean getNumber() {
        int t;

        try {
            nextToken();
            if (ttype != TT_WORD) {
                throw new IOException("Expected number on line " + lineno());
            }
            nval = (Double.valueOf(sval)).doubleValue();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    } // end of getNumber

    /**
     * Method that sets some params of the Tokenizer for reading the file
     * correctly
     */
    public void setup() {
        resetSyntax();
        eolIsSignificant(true);   // The End Of Line is important
        lowerCaseMode(true);

        // All printable ascii characters
        wordChars('!', '~');

        whitespaceChars(' ', ' ');
        whitespaceChars('\n', '\n');
        whitespaceChars('\r', '\r');
        whitespaceChars('\t', '\t');
    }// End setup

}// End of StlFileParser
