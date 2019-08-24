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

package one.empty3.library;

import java.awt.Color;

/**
 * @author Manuel Dahmen
 */
//#TODO Repair
public class TextureCol extends ITexture {

    private int color;

    public TextureCol() {
        color = Color.BLACK.getRGB();
    }

    public TextureCol(Color c) {
        if (c != null) {
            color = c.getRGB();
        }
        else
            color = Color.TRANSLUCENT;
    }

    public TextureCol(int c) {
        color = c;
    }
    public int color() {
        return color;
    }

    public void color(Color c) {
        color = c.getRGB();
    }

    @Override
    public void iterate() throws EOFVideoException {

    }

    public int getColorAt(double x, double y) {
        return color;
    }

    public void timeNext() {
    }

    public void timeNext(long milli) {
    }

    /**
     * Quadrilatère numQuadX = 1, numQuadY = 1, coordArr, y 3----2 ^2y |\ | | 4 |
     * 0--\-1 1 -> 2x
     *
     * @param numQuadX nombre de maillage en coordArr
     * @param numQuadY nombre de maillage en y
     * @param x        valeur de coordArr
     * @param y        valeur de y
     * @return
     */
    public Color getMaillageTexturedColor(int numQuadX, int numQuadY, double x,
                                          double y) {
        return new Color(color);
    }

    public String toString() {
        long c = this.color;
        return "texture ( red:" + ((c&0x000000FF)>>0)+ "; green:" +
                ((c&0x0000FF00)>>8)+ "; blue:" + ((c&0x00FF0000)>>16) +
                "; alpha:" + ((c&0xFF000000)>>24) + ")\n";
    }

}
