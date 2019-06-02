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
import java.awt.*;


public class Inventaire extends DataPanel {
    /**
     *
     */
    private static final long serialVersionUID = 3867647238212721677L;
    public int NUMMAX = 100;
    protected int numero = NUMMAX;
    protected int empochees = 0;
    protected int perdues = 0;
    protected Joueur j;

    public Inventaire() {

        add(new JSlider(0, NUMMAX, numero));

    }

    @Override
    public void updateData() {
        super.updateData();
    }

    @Override
    public void buildGUI() {
        super.buildGUI();
        setMinimumSize(new Dimension(50, 50));
        setSize(new Dimension(50, 50));


        Graphics g = getGraphics();

        g.setColor(Color.BLUE);
        g.fillOval(0, 0, (int) (1.0 * numero / NUMMAX) * 50, (int) (1.0 * numero / NUMMAX) * 50);


    }
}
