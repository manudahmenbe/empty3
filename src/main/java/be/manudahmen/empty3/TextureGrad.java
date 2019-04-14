package be.manudahmen.empty3;

import java.awt.image.BufferedImage;

public class TextureGrad extends TextureMov {
    private BufferedImage currentImg;
    private BufferedImage nextImg;

    public TextureGrad(String s) {
        super(s);
    }

    public int getColorAt(double u, double v) {

        currentImg = images.get(0);
        nextImg = images.get(1);

        //TODO
        int[] col1 = getRGB(currentImg, u, v);
        int[] colN = getRGB(nextImg, u, v);
        int[] col = new int[]{0, 0, 0, 0};
        col[0] = (int) ((col1[0] - colN[0]) / 2. + 256.);

        col[1] = (int) ((col1[1] - colN[1]) / 2. + 256.);

        col[2] = (int) ((col1[2] - colN[2]) / 2. + 256.);

        col[3] = (int) ((col1[3] - colN[3]) / 2. + 256.);

        return col[0] << 24 + col[1] << 16 + col[2] << 8 + col[2];
    }

    public int[] getRGB(BufferedImage image, double u, double v) {
        int x = (int) u * image.getWidth();
        int y = (int) v * image.getHeight();
        if (x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight()) {
            int rgb = image.getRGB(x, y);
            int a = rgb >> 24 & 0xFF;
            int r = rgb >> 16 & 0xFF;
            int g = rgb >> 8 & 0xFF;
            int b = rgb >> 0 & 0xFF;
            return new int[]{a, r, g, b};

        } else
            return new int[]{0, 0xff, 0xff, 0xff};


    }
}
