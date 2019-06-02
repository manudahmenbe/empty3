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

package one.empty3.library.elements;

import one.empty3.library.ECBufferedImage;
import one.empty3.library.Scene;
import one.empty3.library.core.raytracer.RtScene;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JPanelPPMPreview extends JPanel

{
    private Scene scene;
    private RtScene rtScene;
    private int typeScene;
    private StringBuilder ppmBuilder;
    private File recordFolder;
    private String filePrefix;
    private String timestampFormat;
    private String fileExtension;
    private String fileInfoPostfix;
    private Image previewImage;

    public JPanelPPMPreview(Scene scene) {

    }

    public void paint(Graphics graphics) {
        if (previewImage != null) {
            graphics.drawImage(previewImage, 0, 0, null, null);
        }
    }

    private void buildPreviewImage() {
        Graphics graphics = this.getGraphics();
        super.paint(graphics); // TODO CHECK

        PPMFileInputStream ppmFileInputStream = new PPMFileInputStream(ppmBuilder);

        // Read String
        // Complete with white, transparent or black

        ECBufferedImage ecBufferedImage = new ECBufferedImage(ppmFileInputStream);

    }
}
