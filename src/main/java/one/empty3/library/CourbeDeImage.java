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

/*

 Vous êtes libre de :

 */
package one.empty3.library;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import java.util.Set;

public class CourbeDeImage {

    private BufferedImage image;
    private Hashtable<Point2D, Color> points;

    public CourbeDeImage(BufferedImage image) {
        super();
        this.image = image;
        this.points = new Hashtable<Point2D, Color>();

        anayliserImage();
    }

    public void anayliserImage() {
        for (int i = 0; i < image.getWidth(); i++) {
            int y0 = -1;
            int y1 = -1;
            for (int j = 0; j < image.getHeight(); j++) {
                if (!new Color(image.getRGB(i, j)).equals(Color.white)) {
                    y0 = y1;
                    y1 = j;
                    if (y0 == -1 || (y1 > y0 + 1)) {
                        points.put(new Point2D(i, j), new Color(image.getRGB(i, j)));
                        break;
                    }
                }

            }
        }
    }

    public void classerPoints() {
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(ECBufferedImage image) {
        this.image = image;
    }

    public Hashtable<Point2D, Color> getPoints() {
        return points;
    }

    public void setPoints(Hashtable<Point2D, Color> points) {
        this.points = points;
    }

    public Set<Point2D> getPointsList() {
        return points.keySet();
    }
}
