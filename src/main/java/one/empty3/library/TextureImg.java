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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package one.empty3.library;

import org.monte.media.avi.AVIReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;


/**
 * @author manu
 */
public class TextureImg extends ITexture {

    private ECBufferedImage image;

    private String nom = "texture";

    private String nomFichier = "image.png";

    private AVIReader reader;
    private int track = 0;
    private File avifile = null;
    private int transparent = Color.TRANSLUCENT;

    public TextureImg() {

    }
    public TextureImg(ECBufferedImage bi) {
        this.image = bi;
    }

    @Override
    public void iterate() throws EOFVideoException {

    }

    @Override
    public int getColorAt(double rx, double ry) {
        Point2D trans = getCoord(rx, ry);
        return couleur(trans.x, trans.y);
    }

    protected int couleur(double rx, double ry) {
        int x = (int) (rx * image.getWidth());
        int y = (int) (ry * image.getHeight());
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x >= image.getWidth()) {
            x = image.getWidth() - 1;
        }
        if (y >= image.getHeight()) {
            y = image.getHeight() - 1;
        }


        int c = image != null ? image
                .getRGB(x, y)
                :
                transparent;

        return c;
    }


    public ECBufferedImage getImage() {
        return image;
    }

    public void setImage(ECBufferedImage image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }


    public void setTransparent(Color tr) {
        this.transparent = tr.getRGB();
    }

    public void timeNext() {
    }

    public void timeNext(long milli) {
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
        Point2D p = getCoord(x, y);

        int xi = ((int) (1d * image.getWidth() * p.x));
        int yi = ((int) (1d * image.getHeight() * p.y));


        if (xi >= image.getWidth()) {
            xi = image.getWidth() - 1;
        }
        if (yi >= image.getHeight()) {
            yi = image.getHeight() - 1;
        }
        Color c = new Color(image.getRGB(xi, yi));
        if (c.equals(transparent)) {
            return new Color(transparent);
        } else {
            return c;
        }
    }
    public String toString() {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();
    
            Base64.Encoder encoder =Base64.getEncoder();
            imageString = encoder.encodeToString(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String t  = "textureImg( filename:"+getFilename()+"\n\tdata : { "+imageString+" } \n)";
        return t;
    }

    public String getFilename() {
        return getNomFichier();
    }
}
