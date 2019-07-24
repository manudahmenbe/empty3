package atlasgen;

/**
 * Created by Win on 10-07-18.
 */
public class Ratio {
    public static double
    imageHeight(
            double latitudeExtension,
            double longitudeExtension,
            double ratioLatitudePerLongitude,
            int imageWidth) {
        if (ratioLatitudePerLongitude <= 0)
            ratioLatitudePerLongitude = 1;
        return latitudeExtension / longitudeExtension /
                ratioLatitudePerLongitude * imageWidth;
    }
}
