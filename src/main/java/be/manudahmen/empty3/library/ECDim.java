/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class ECDim {

    private int dimx;
    private int dimy;

    public ECDim(int dimx, int dimy) {
        this.dimx = dimx;
        this.dimy = dimy;
    }

    public int getDimx() {
        return dimx;
    }

    public void setDimx(int dimx) {
        this.dimx = dimx;
    }

    public int getDimy() {
        return dimy;
    }

    public void setDimy(int dimy) {
        this.dimy = dimy;
    }

    public Dimension getAwt() {
        return new Dimension(getDimx(), getDimy());
    }
}
