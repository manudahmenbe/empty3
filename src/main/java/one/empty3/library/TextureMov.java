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

import com.xuggle.mediatool.IMediaReader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class TextureMov extends ITexture {
    public final int maxBuffSize = 25 * 60 * 700;
    private final Object e = null;
    private IMediaReader reader;
    private boolean notSuivante = false;
    private int track = 0;
    private File file = null;
    private int transparent = Color.WHITE.getRGB();
    /**
     * The video stream index, used to ensure we display frames from one and
     * only one video stream from the media container.
     */
    private int mVideoStreamIndex = -1;
    protected ArrayList<ECBufferedImage> images;
    private int current;
    private int CAPACITY;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
        init(file.getAbsolutePath());
    }

    public TextureMov() {
    }

    public TextureMov(String filename) {
        init(filename);
    }
    public void init(String filename)
    {
        this.file = new File(filename);


        CAPACITY = 100;

        images = new ArrayList<>();
        new DecodeAndCaptureFrames(file, this).start();
    }


    @Override
    public void iterate() throws EOFVideoException {

    }

    public int getColorAt(double u, double v) {
        BufferedImage image;
        try {
            image  = current(0);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            return 0;
        }
        if(image==null)
            return 0;

        int x = (int) (u * image.getWidth());
        int y = (int) (v * image.getHeight());
        if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
            int rgb = image.getRGB(x, y);
            int a = rgb >> 24 & 0xFF;
            int r = rgb >> 16 & 0xFF;
            int g = rgb >> 8 & 0xFF;
            int b = rgb >> 0 & 0xFF;
            return rgb&0x00FFFFFF;

        } else
            return Color.TRANSLUCENT;
    }

    protected BufferedImage current(int i) {
        while(images==null || images.size()==0)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        return images.get(i);

    }


    @Override
    public void timeNext() {

    }

    @Override
    public void timeNext(long milli) {

    }


    public boolean nextFrame() {
        if(images.size()>0) {
            images.remove(0);
            return true;
        }
        else
        {
            return true;
        }
    }


    public void add(BufferedImage image) {
        images.add(new ECBufferedImage(image));
    }

    public boolean hasCapacity() {
        return images.size()<CAPACITY;
    }

    public void setTransparent(Color black) {
        this.transparent = black.getRGB();
    }
}
