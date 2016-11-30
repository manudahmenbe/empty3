/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.emptycanvas.library.empty3.library.object;

import com.xuggle.mediatool.MediaListenerAdapter;

import java.awt.*;

/**
 * @author manu
 */
public abstract class ITexture extends MediaListenerAdapter {
    public static final int COLOR_IDENT = 0;
    public static final int COLOR_MIROR_X = 1;
    public static final int COLOR_MIROR_Y = 2;
    public static final int COLOR_MIROR_XY = 4;
    public static final int COLOR_ROT_090 = 4;
    public static final int COLOR_ROT_180 = 4;
    public static final int COLOR_ROT_270 = 4;
    public int onTextureEnds = 0;
    protected int colorMask = 0;
    DeformMap dm;

    public int getColorMask() {
        return colorMask;
    }

    public void setColorMask(int colorMask) {
        this.colorMask = colorMask;
    }

    public be.manudahmen.emptycanvas.library.empty3.library.tribase.Point getCoord(double x, double y) {
        be.manudahmen.emptycanvas.library.empty3.library.tribase.Point p = new be.manudahmen.emptycanvas.library.empty3.library.tribase.Point(x, y);
        if (getColorMask() == COLOR_IDENT)
            return p;
        if ((getColorMask() & COLOR_MIROR_X) > 0) {
            p = new be.manudahmen.emptycanvas.library.empty3.library.tribase.Point(1.0 - p.x, p.y);
        }
        if ((getColorMask() & COLOR_MIROR_Y) > 0) {
            p = new be.manudahmen.emptycanvas.library.empty3.library.tribase.Point(p.x, 1.0 - p.y);
        }
        if ((getColorMask() & COLOR_MIROR_XY) > 0) {
            p = new be.manudahmen.emptycanvas.library.empty3.library.tribase.Point(p.y, p.x);
        }
        if ((getColorMask() & COLOR_ROT_090) > 0) {
            p = new be.manudahmen.emptycanvas.library.empty3.library.tribase.Point(1.0 - p.y, p.x);
        }
        if ((getColorMask() & COLOR_ROT_180) > 0) {
            p = new be.manudahmen.emptycanvas.library.empty3.library.tribase.Point(1.0 - p.x, 1.0 - p.x);
        }
        if ((getColorMask() & COLOR_ROT_270) > 0) {
            p = new be.manudahmen.emptycanvas.library.empty3.library.tribase.Point(p.y, 1.0 - p.x);
        }
        return p;
    }

    public void setDeformMap(DeformMap map) {
        dm = map;
    }

    public DeformMap getDeformMap(DeformMap map) {
        return dm;
    }

    /***
     * Retourne color at point (x*textresx, y*textresy)
     *
     * @param x 0..1
     * @param y 0..1
     * @return color;
     */
    public abstract int getColorAt(double x, double y);

    /***
     * @param numQuadX
     * @param numQuadY
     * @param u
     * @param v
     * @return
     */
    public abstract Color getMaillageTexturedColor(int numQuadX, int numQuadY, double u,
                                                   double v);

    public abstract void timeNext();

    public abstract void timeNext(long milli);
}
