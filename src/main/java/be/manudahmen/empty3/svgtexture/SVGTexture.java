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

package be.manudahmen.empty3.svgtexture;

import be.manudahmen.empty3.EOFVideoException;
import be.manudahmen.empty3.ITexture;

import java.awt.*;
import java.io.File;

/**
 * Created by manue on 24-09-15.
 */
public class SVGTexture extends ITexture {

    public SVGTexture(File file) {
        // String parser = XMLResourceDescriptor.getXMLParserClassName();
        //SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
        String uri = file.toURI().toString();

    }

    @Override
    public void iterate() throws EOFVideoException {

    }

    @Override
    public int getColorAt(double x, double y) {
        return 0;
    }

    @Override
    public Color getMaillageTexturedColor(int numQuadX, int numQuadY, double u, double v) {
        return null;
    }


    @Override
    public void timeNext() {
        // NOTHING TO DO HERE
    }

    @Override
    public void timeNext(long milli) {
        // NOTHING TO DO HERE
    }
}
