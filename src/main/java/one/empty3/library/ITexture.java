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

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package one.empty3.library;

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
    public static final int COLOR_ROT_090 = 8;
    public static final int COLOR_ROT_180 = 16;
    public static final int COLOR_ROT_270 = 32;
    public int onTextureEnds = 0;
    protected int colorMask = 0;
    DeformMap dm;

    public int getColorMask() {
        return colorMask;
    }
    public abstract void iterate() throws EOFVideoException;

    public void setColorMask(int colorMask) {
        this.colorMask = colorMask;
    }

    public Point2D getCoord(double x, double y) {
        Point2D p = new Point2D(x, y);
        if (getColorMask() == COLOR_IDENT)
            return p;
        if ((getColorMask() & COLOR_MIROR_X) > 0) {
            p = new Point2D(1.0 - p.x, p.y);
        }
        if ((getColorMask() & COLOR_MIROR_Y) > 0) {
            p = new Point2D(p.x, 1.0 - p.y);
        }
        if ((getColorMask() & COLOR_MIROR_XY) > 0) {
            p = new Point2D(p.y, p.x);
        }
        if ((getColorMask() & COLOR_ROT_090) > 0) {
            p = new Point2D(1.0 - p.y, p.x);
        }
        if ((getColorMask() & COLOR_ROT_180) > 0) {
            p = new Point2D(1.0 - p.x, 1.0 - p.x);
        }
        if ((getColorMask() & COLOR_ROT_270) > 0) {
            p = new Point2D(p.y, 1.0 - p.x);
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
