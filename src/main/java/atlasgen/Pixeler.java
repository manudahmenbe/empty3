package atlasgen;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by manuel on 19-06-18.
 */
public class Pixeler {
    private BufferedImage image;
    private int width;
    private int height;


    public Pixeler(BufferedImage image) {
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
    }

    public void pixelize(int x, int y, Color color) {
        image.setRGB(x < 0 ? 0 : (x > width - 1 ? width - 1 : x),
                y < 0 ? 0 : (y > width - 1 ? width - 1 : y),
                color.getRGB());
    }

    public Point convert(double ratioX, double ratioY) {
        return new Point((int) (ratioX * width), (int) (ratioY * height));
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
