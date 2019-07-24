package atlasgen;

import one.empty3.library.ColorTexture;
import one.empty3.library.core.lighting.Colors;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ColoredMaps {

    public static void main(String[] args) {
        System.out.println(
                "Colored Maps -- first pass Setting Rect Boundaries"
        );


        CsvReader csvReader = new CsvReader(new File("allCountries/allCountries.txt"),
                "" + '\t', "" + '\n', false);
        SetMinMax setMinMax = new SetMinMax();
        csvReader.setAction(setMinMax);
        csvReader.process();


        HashMap<String, SetMinMax.MyDim> myDims = setMinMax.getMyDims();

        myDims.forEach((s, dim) -> {
            System.out.println(s);
            System.out.println(dim);
        });
        System.out.println("myDims size " + myDims.size());


        String serial = Seriald.newSerial();


        myDims.forEach((countryCode, myDim) -> {
            System.out.println(
                    "Colored Maps map " + countryCode
            );
            try {
                BufferedImage image = new BufferedImage(1800,
                        (int)
                                Ratio.imageHeight(myDim.latitudeExtend(),
                                        myDim.longitudeExtend(),
                                        0,
                                        1800), BufferedImage.TYPE_INT_RGB);
                Pixeler pixeler = new Pixeler(image);
                Graphics graphics = image.getGraphics();
                graphics.setColor(new Color(Color.TRANSLUCENT));
                graphics.fillRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);

                CsvReader csvReader1 = new CsvReader(new File("allCountries/allCountries.txt"),
                        "" + '\t', "" + '\n', false);
                csvReader1.setAction(new DrawOneCountryAction(
                        pixeler,
                        myDim,
                        new ColorTexture(Colors.random())
                ));
                csvReader1.process();
                ImageIO.write(pixeler.getImage(), "jpg", new File(
                        getColoredMaps(serial, countryCode)));

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        });
    }

    private static String getColoredMaps(String serial, String countryCode) {
        String fileStr1 = ".\\generated_Maps\\"
                + "\\map-" + serial + "\\" + countryCode;
        File file = new File(fileStr1);
        file.mkdirs();
        return fileStr1 + ".jpg";
    }
}
