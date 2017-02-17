/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package be.manudahmen.empty3.gui.elements;

import be.manudahmen.empty3.ECBufferedImage;

import java.io.ByteArrayInputStream;

public class PPMFileInputStream extends ByteArrayInputStream {

    private StringBuilder stringBuilder;

    public PPMFileInputStream(StringBuilder sb) {
        super(sb.toString().getBytes());
        this.stringBuilder = sb;
    }

    public byte[] getBytes() {
        return stringBuilder.toString().getBytes();
    }

    public void update() {
        this.reset();
        int read = this.read();
        if (read > 0) {
            ECBufferedImage ppm = ECBufferedImage.ppm(getBytes(), "PPM");
        }
    }
}
