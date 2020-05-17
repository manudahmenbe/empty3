/*
 *  This file is part of Empty3.
 *
 *     Empty3 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Empty3 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Empty3.  If not, see <https://www.gnu.org/licenses/>. 2
 */

/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

package one.empty3.library;

//import com.xuggle.mediatool.IMediaReader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


public class TextureMov extends ITexture {
BufferedImage image;
    VideoDecoder defs;
    public final int maxBuffSize = 4;
    private final Object e = null;
//  private IMediaReader reader;
    private boolean notSuivante = false;
    private int track = 0;
    private StructureMatrix<File> fileStructureMatrix = new StructureMatrix<>(0, File.class);
    private File file = null;
    private int transparent = Color.WHITE.getRGB();
    /*__
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
        fileStructureMatrix.setElem(file);
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
        fileStructureMatrix.setElem(file);

        CAPACITY = 4;

        images = new ArrayList<>();
        defs = VideoDecoderFactory.createInstance(file, this);
        defs.start();
    }


    @Override
    public void iterate() throws EOFVideoException {

    }

    public int getColorAt(double u, double v) {
        
     
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

    protected void current() {
        while(defs.size()==0 && !defs.isClosed() && !((image=defs.current())==null))
        {
            try {
                Thread.sleep(10);
                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }


    @Override
    public void timeNext() {
        nextFrame();
    }

    @Override
    public void timeNext(long milli) {

    }

    @Override
    public StructureMatrix getDeclaredProperty(String name) {
        return fileStructureMatrix;
    }

    @Override
    public MatrixPropertiesObject copy() throws CopyRepresentableError, IllegalAccessException, InstantiationException {
        return null;
    }


    public boolean nextFrame() {
        current();
        return image!=null;
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
