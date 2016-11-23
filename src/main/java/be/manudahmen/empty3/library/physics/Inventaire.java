package be.manudahmen.empty3.library.physics;

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
