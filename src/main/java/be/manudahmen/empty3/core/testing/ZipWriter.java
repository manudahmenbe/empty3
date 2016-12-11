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

package be.manudahmen.empty3.core.testing;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipWriter {

    private ZipOutputStream zos;

    public void addFile(ByteArrayOutputStream baos) {
        // TODO Auto-generated method stub

    }

    public void addFile(File image) throws IOException {
        byte[] b = new byte[1024];
        FileInputStream fis = new FileInputStream(image);
        fis.read(b, 0, b.length);
        ZipEntry ze = new ZipEntry(image.getName());
        ze.setSize((long) b.length);
        zos.setLevel(6);
        zos.putNextEntry(ze);
        zos.write(b, 0, b.length);
    }

    public void addFile(String name, byte[] b) throws IOException {
        ZipEntry ze = new ZipEntry(name);
        ze.setSize((long) b.length);
        zos.setLevel(6);
        zos.putNextEntry(ze);
        zos.write(b, 0, b.length);
    }

    public void end() throws IOException {
        zos.finish();
        zos.close();
    }

    public void init(File zipf) throws FileNotFoundException {
        zos = new ZipOutputStream(new FileOutputStream(zipf));
    }
}
