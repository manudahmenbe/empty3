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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.empty3.library.core.testing;

/**
 * @author Se7en
 */
/*
*
* @(#) TextAreaOutputStream.java
*
*/

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * An output stream that writes its output to a javax.swing.JTextArea
 * control.
 *
 * @author Ranganath Kini
 * @see javax.swing.JTextArea
 */
public class TextAreaOutputStream extends OutputStream {
    private JTextArea textControl;

    /**
     * Creates a new instance of TextAreaOutputStream which writes
     * to the specified instance of javax.swing.JTextArea control.
     *
     * @param control A reference to the javax.swing.JTextArea
     *                control to which the output must be redirected
     *                to.
     */
    public TextAreaOutputStream(JTextArea control) {
        textControl = control;
    }

    /**
     * Writes the specified byte as a character to the
     * javax.swing.JTextArea.
     *
     * @param b The byte to be written as character to the
     *          JTextArea.
     */
    public void write(int b) throws IOException {
        // append the data as characters to the JTextArea control
        textControl.append(String.valueOf((char) b));
    }
}