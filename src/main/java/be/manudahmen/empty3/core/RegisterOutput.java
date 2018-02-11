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
package be.manudahmen.empty3.core;

import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author manue_001
 */
public class RegisterOutput {

    private Logger logger;
    private OutputStream output;
    private JTextPane pane;

    public void addOutput(Logger l) {
        this.logger = l;
    }

    public void addOutput(OutputStream o) {
        this.output = o;
    }

    public void addOutput(JTextPane p) {
        this.pane = p;
    }

    public Logger getLogger() {
        return logger;
    }

    public OutputStream getOutput() {
        return output;
    }

    public JTextPane getPane() {
        return pane;
    }

    public void println(String s) {
        if (logger != null)
            logger.log(Level.INFO, s);
        if (output != null)
            new PrintWriter(output).println(s);
        if (pane != null)
            pane.setText(pane.getText() + "\n" + s);


    }
}
