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

package one.empty3.library.core.physics;

import javax.swing.*;


public class DataPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 8643829020005475144L;
    private GameApplet gp;

    public void setGameApplet(GameApplet gp) {
        this.gp = gp;
    }

    public void updateData() {
    }

    public void buildGUI() {
        paintComponent(getGraphics());
    }
}
