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

package be.manudahmen.empty3;

import java.awt.*;

/**
 * @author Manuel Dahmen
 */
public class ColorTexture extends ITexture {

    private Color color;

    public ColorTexture() {
        color = Color.BLACK;
    }

    public ColorTexture(Color c) {
        this();
        if (c != null) {
            color = c;
        }
    }

    public Color color() {
        return color;
    }

    public void color(Color c) {
        color = c;
    }

    public int getColorAt(double x, double y) {
        return color.getRGB();
    }

    public void timeNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void timeNext(long milli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Quadrilatère numQuadX = 1, numQuadY = 1, x, y 3----2 ^2y |\ | | 4 |
     * 0--\-1 1 -> 2x
     *
     * @param numQuadX nombre de maillage en x
     * @param numQuadY nombre de maillage en y
     * @param x        valeur de x
     * @param y        valeur de y
     * @return
     */
    public Color getMaillageTexturedColor(int numQuadX, int numQuadY, double x,
                                          double y) {
        return color;
    }

    public String toString() {
        return "texture ( red:" + color.getRed() + "; green:" +
                color.getGreen() + "; blue:" + color.getBlue() +
                "; alpha:" + color.getAlpha() + ")\n";
    }

}
