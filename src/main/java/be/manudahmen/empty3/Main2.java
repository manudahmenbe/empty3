/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package be.manudahmen.empty3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by manuel on 25-01-17.
 */
public class Main2 extends JFrame {
    public Main2() {
        super("Application 2D/3D");
        JTextArea jTextArea = new JTextArea("# Variables: \n" +
                "# t : temps en secondes d'animation dans la vidéo\n" +
                "# xRes : résolution de la vidéo en x\n" +
                "# yRes : résolution de la vidéo en y\n" +
                "# x, y : coordonnées du point en (x, y)\n" +
                "# tMax : fin de la vidéo en secondes\n");
        //jTextArea.setCursor(new Cursor(jTextArea.getLineCount()));
        JRootPane jRootPane = new JRootPane();
        jRootPane.setContentPane(jTextArea);
        add(jRootPane);
        this.setRootPane(jRootPane);
        this.setBounds(new Rectangle(0, 0, 800, 400));
    }

    public static void main(String[] args) {
        new Main2().setVisible(true);
    }
}
