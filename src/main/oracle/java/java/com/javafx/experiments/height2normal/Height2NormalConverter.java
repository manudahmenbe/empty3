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
package com.javafx.experiments.height2normal;

import javafx.geometry.Point3D;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 * Util class to convert height maps into normal maps
 */
public class Height2NormalConverter {
    public static Image convertToNormals(Image heightMap, boolean invert, double scale) {
        final int w = (int)heightMap.getWidth();
        final int h = (int)heightMap.getHeight();
        final byte[] heightPixels = new byte[w*h*4];
        final byte[] normalPixels = new byte[w*h*4];
        // get pixels
        final PixelReader reader = heightMap.getPixelReader();
        reader.getPixels(0, 0, w, h, PixelFormat.getByteBgraInstance(),heightPixels,0,w*4);
        if (invert) {
            for (int y=0; y<h; y++) {
                for (int x=0; x<w; x++) {
                    final int pixelIndex = (y*w*4) + (x*4);
                    heightPixels[pixelIndex] = (byte)(255-Byte.toUnsignedInt(heightPixels[pixelIndex]));
                    heightPixels[pixelIndex+1] = (byte)(255-Byte.toUnsignedInt(heightPixels[pixelIndex+1]));
                    heightPixels[pixelIndex+2] = (byte)(255-Byte.toUnsignedInt(heightPixels[pixelIndex+2]));
                    heightPixels[pixelIndex+3] = heightPixels[pixelIndex+3];
                }
            }
        }
        // generate normal map
        for (int y=0; y<h; y++) {
            for (int x=0; x<w; x++) {
                final int yAbove = Math.max(0,y-1);
                final int yBelow = Math.min(h - 1, y + 1);
                final int xLeft = Math.max(0, x - 1);
                final int xRight = Math.min(w - 1, x + 1);
                final int pixelIndex = (y*w*4) + (x*4);
                final int pixelAboveIndex = (yAbove*w*4) + (x*4);
                final int pixelBelowIndex = (yBelow*w*4) + (x*4);
                final int pixelLeftIndex = (y*w*4) + (xLeft*4);
                final int pixelRightIndex = (y*w*4) + (xRight*4);
                final int pixelAboveHeight = Byte.toUnsignedInt(heightPixels[pixelAboveIndex]);
                final int pixelBelowHeight = Byte.toUnsignedInt(heightPixels[pixelBelowIndex]);
                final int pixelLeftHeight = Byte.toUnsignedInt(heightPixels[pixelLeftIndex]);
                final int pixelRightHeight = Byte.toUnsignedInt(heightPixels[pixelRightIndex]);

                Point3D pixelAbove = new Point3D(x,yAbove,pixelAboveHeight);
                Point3D pixelBelow = new Point3D(x,yBelow,pixelBelowHeight);
                Point3D pixelLeft = new Point3D(xLeft,y,pixelLeftHeight);
                Point3D pixelRight = new Point3D(xRight,y,pixelRightHeight);
                Point3D H = pixelLeft.subtract(pixelRight);
                Point3D V = pixelAbove.subtract(pixelBelow);
                Point3D normal = H.crossProduct(V);
                // normalize normal
                normal = new Point3D(
                        normal.getX()/w,
                        normal.getY()/h,
                        normal.getZ()
                );
                // it seems there is lots of ways to calculate the Z element of normal map, 3 options here
//                normalPixels[pixelIndex] = (byte)((normal.getZ()*128)+128); // Option 1
                normalPixels[pixelIndex] = (byte)(255-(normal.getZ() * scale)); // Option 2
//                normalPixels[pixelIndex] = (byte)255; // Option 3
                normalPixels[pixelIndex+1] = (byte)((normal.getY()*128)+128);
                normalPixels[pixelIndex+2] = (byte)((normal.getX()*128)+128);
                normalPixels[pixelIndex+3] = (byte)255;
            }
        }
        // create output image
        final WritableImage outImage = new WritableImage(w,h);
        outImage.getPixelWriter().setPixels(0,0,w,h,PixelFormat.getByteBgraInstance(),normalPixels,0,w*4);
        return outImage;
    }
}
