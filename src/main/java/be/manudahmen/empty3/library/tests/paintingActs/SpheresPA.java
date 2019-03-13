package be.manudahmen.empty3.library.tests.paintingActs;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.PaintingAct;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.awt.*;

/**
 * Created by manue on 12-10-15.
 */
public class SpheresPA extends PaintingAct {
    double[][] s;

    public void ginit() {
        s = new double[][]{{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
    }

    public void finit() {
        double pas = 0.001;
        for (int i = 0; i < s[0].length; i++) {
            s[0][i] += (Math.random() - 0.5) * Math.PI * 2 * pas;
            s[1][i] += (Math.random() - 0.5) * Math.PI * 2 * pas;
        }
    }

    @Override
    public void paint() {
        if (s == null)
            ginit();
        finit();
        if (getObjet() instanceof TRISphere) {
            TRISphere sph = (TRISphere) getObjet();

            for (int i = 0; i < s[0].length; i++) {
                TRISphere s2 = new TRISphere(sph.calculerPoint3D(s[0][i], s[1][i]), 2);
                s2.texture(new TextureCol(Color.BLUE));
                getZBuffer().draw(s2, null);
            }
        }
    }
}
