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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JoueurDescription extends DataPanel {

    /**
     *
     */
    private static final long serialVersionUID = 3560368014780722435L;
    int n;
    private GameApplet gp;

    public JoueurDescription(final int n, final GameApplet gp) {
        this.n = n;
        this.gp = gp;

        final JColorChooser cc = new JColorChooser();

        cc.setColor(gp.getJoueurs().get(n).color);

        add(cc);
        add(gp.getInventaires().get(gp.getJoueurs().get(n)));
        gp.getInventaires().get(gp.getJoueurs().get(n)).updateData();
        //gp.getInventaires().get(gp.getJoueurs().get(n)).buildGUI();

        final JTextArea nomJ = new JTextArea(gp.getJoueurs().get(n).nom);


        add(nomJ);

        JButton enregistrer = new JButton("Enregistrer");

        JButton annuler = new JButton("Annuler");

        add(enregistrer);

        add(annuler);


        enregistrer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gp.replaceGUI(new PresentationJoueurs(gp));
                gp.getJoueurs().get(n)
                        .nom = nomJ.getText();
                gp.getJoueurs().get(n)
                        .color = cc.getColor();

                gp.replaceGUI(new PresentationJoueurs(gp));
            }
        });
        annuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gp.replaceGUI(new PresentationJoueurs(gp));

            }
        });
    }
}
