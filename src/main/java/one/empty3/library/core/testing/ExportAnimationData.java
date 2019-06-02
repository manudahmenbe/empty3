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

package one.empty3.library.core.testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by manuel on 01-06-17.
 */
public class ExportAnimationData {
    private final TestObjet animation;
    private final File file;
    private PrintWriter printWriter;

    public ExportAnimationData(File file, TestObjet animation) throws FileNotFoundException {
        this.file = file;
        this.animation = animation;

        printWriter = new PrintWriter(new FileOutputStream(file));

        printWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");

        printWriter.println("<exportData filename='" + file.getAbsoluteFile() +
                "' width='" + animation.getResx() + "' height='" + animation.getResy() + "' length='" + animation.getMaxFrames() + "'>");
    }

    public void writeGlobalData(String key, Object data) {

        printWriter.println("<global key='" + key + "'>" + data + "</global>");

    }

    public void writeFrameData(int frameNo, Object data) {

        printWriter.println("<frame frameNo='" + frameNo +
                "' type='" + data.getClass().getSimpleName() + "' javaType='" + data.getClass().getCanonicalName() +
                "'>" + data + "</global>");

    }

    public void end() {

        printWriter.println("</exportData>");
        printWriter.flush();
        printWriter.close();

    }
}
