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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class GameApplet extends JApplet implements Runnable

{

    /**
     *
     */
    private static final long serialVersionUID = -2729176474797816893L;
    protected Jeu jeu;
    protected List<Joueur> joueurs;
    protected Hashtable<Joueur, Inventaire> inventaires = new Hashtable<Joueur, Inventaire>();
    private GameApplet gp = this;
    private JPanel old;
    private JButton startGame;
    private BallePanel bp;
    private boolean done = false;
    private long interval = 200;
    private boolean pause = false;
    private Thread flow;

    public void replaceGUI(DataPanel newP) {
        if (old != null)
            remove(old);

        newP.updateData();

        old = newP;
        add(newP);

        //newP.buildGUI();

        paintComponents(getGraphics());

        repaint();
    }

    public void init() {
        joueurs = new ArrayList<Joueur>();

        joueurs.add(new Joueur("Joueur 1", Color.RED));
        joueurs.add(new Joueur("Joueur 2", Color.GREEN));
        joueurs.add(new Joueur("Joueur 3", Color.BLUE));
        joueurs.add(new Joueur("Joueur 4", Color.YELLOW));

        inventaires.put(joueurs.get(0), new Inventaire());
        inventaires.put(joueurs.get(1), new Inventaire());
        inventaires.put(joueurs.get(2), new Inventaire());
        inventaires.put(joueurs.get(3), new Inventaire());

        add(old = new PresentationJoueurs(this));
        JPopupMenu pp = new JPopupMenu("D�marrer");
        pp.add(new JMenuItem(new Action() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gp.add(new ButtonStart(gp));

            }

            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public void addPropertyChangeListener(
                    PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(
                    PropertyChangeListener listener) {

            }
        }));
        final JButton demarrer = new JButton("D�marrer");

        demarrer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                remove(demarrer);
                bp = new BallePanel();
                replaceGUI(bp);
                new Thread(bp).start();

            }

        });


        add(demarrer);
    }

    public synchronized Jeu getJeu() {
        return jeu;
    }

    public synchronized List<Joueur> getJoueurs() {

        return joueurs;
    }

    public Hashtable<Joueur, Inventaire> getInventaires() {

        return inventaires;
    }

    public void run() {
        try {
            while (!done) {
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
        }
    }

    public void start() {
        done = false;
        pause = false;
        flow = new Thread(this);
        flow.start();
    }

    public void stop() {
        done = true;
        flow.stop();
    }

    class ButtonStart extends GamePanel {

        public ButtonStart(final GameApplet gp) {
            super(gp);
            startGame = new JButton("D�marrer la partie");

            add(startGame);

            startGame.addActionListener(new ActionListener() {


                @Override
                public void actionPerformed(ActionEvent e) {
                    GamePanel ga = new GamePanel(gp);
                    ga.setGameApplet(gp);
                    replaceGUI(ga);

                }
            });
        }


    }

}
