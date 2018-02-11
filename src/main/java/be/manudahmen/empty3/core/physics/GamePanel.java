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

package be.manudahmen.empty3.core.physics;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends DataPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1552746400473185110L;
    protected JSlider[] s;
    private GameApplet gp;
    private int joueur;


    public GamePanel(GameApplet gp)

    {
        this.gp = gp;
    }

    public void updateData() {

        for (int i = 0; i < 3; i++) {
            add(new JLabel("Joueur: " + gp.getJoueurs().get(i)));
            add(s[0] = new JSlider(gp.getJoueurs().get(i).billes));
        }
        final JSlider mise;
        add(new JLabel("Mise pour:"));
        add(mise = new JSlider(0, 100));
        mise.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (gp.getJoueurs().get(joueur()).billes > mise.getValue()) {
                    gp.getJoueurs().get(joueur()).billes -= mise.getValue();
                }

            }

        });

        JButton suiv = new JButton("Suivant");
        suiv.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finTour();
            }
        });
        add(suiv);

    }

    public int joueur() {
        return joueur;
    }

    public void finTour() {
        joueur = (joueur++ % 4);
    }
}
