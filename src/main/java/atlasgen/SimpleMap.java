package atlasgen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SimpleMap {

    public static void main(String[] args) {
        System.out.println(
                "One color Map"
        );

        Color color = Color.WHITE;
        Pixeler pixeler = new Pixeler(new BufferedImage(1800, 1600, BufferedImage.TYPE_INT_RGB));
        CsvReader csvReader = new CsvReader(new File("allCountries/allCountries.txt"),
                "" + '\t', "" + '\n', false);
        csvReader.setAction(new DrawAction(pixeler, color));
        csvReader.process();
        try {
            File file = Seriald.newOutputFile("SimpleMap");
            file.mkdirs();
            ImageIO.write(pixeler.getImage(), "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
