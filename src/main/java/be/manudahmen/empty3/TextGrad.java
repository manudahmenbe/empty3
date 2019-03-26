package be.manudahmen.empty3;

import java.awt.image.BufferedImage;

public class TextGrad extends TextureMov {
    private BufferedImage currentImg;
    private BufferedImage nextImg;

    public TextGrad(String s) {
        super(s);
    }

    public void iterate() {

        try {
            currentImg = current(0);
            nextImg = current(1);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public int getColorAt(double u, double v) {

        currentImg = images.get(0);
        nextImg = images.get(1);

        //TODO
        int[] col1 = getRGB(currentImg, u, v);
        int[] colN = getRGB(nextImg, u, v);
        int[] col = new int[]{0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            col[i] = (int) ((col1[i] - colN[i]) / 2. + 256.);

        }
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
            return new int[]{0xff, 0xff, 0xff, 0xff};


    }
}
