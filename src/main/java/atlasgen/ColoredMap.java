package atlasgen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColoredMap {

    public static void main(String[] args) {
        System.out.println(
                "Colored Map"
        );
        BufferedImage image = new BufferedImage(1800, 1600, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(new Color(Color.TRANSLUCENT));
        graphics.fillRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);
        Pixeler pixeler = new Pixeler(image);
        CsvReader csvReader = new CsvReader(new File("allCountries/allCountries.txt"),
                "" + '\t', "" + '\n', false);
        csvReader.setAction(new DrawPerCountryAction(pixeler));
        csvReader.process();
        try {
            ImageIO.write(pixeler.getImage(), "jpg", Seriald.newOutputFile("ColoredMap"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
