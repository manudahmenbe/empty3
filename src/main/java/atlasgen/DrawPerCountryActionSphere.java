package atlasgen;

import one.empty3.library.ColorTexture;
import one.empty3.library.Point3D;
import one.empty3.library.core.lighting.Colors;
import one.empty3.library.core.nurbs.PcOnPs;
import one.empty3.library.core.nurbs.Point3DS;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manuel Dagmen on 29-06-18.
 */
public class DrawPerCountryActionSphere implements Action {
    int countLine = 0;
    private final TestEarth testEarth;
    private boolean firstPass = false;
    private Map<String, Color> colors = new HashMap<String, Color>();

    private Pixeler pixeler;

    public DrawPerCountryActionSphere(TestEarth testEarth) {
        this.testEarth = testEarth;
    }


    @Override
    public void init() {

    }

    @Override
    public void processLine(CsvLine csvLine) {
        //if (countLine % 1000 == 0) {
        int lattitudeColumn = 4;
        int longitudeColumn = 5;
        int countryCodeColumn = 8;
        String[] lineArray = csvLine.getValue();
        String countryCode = lineArray[countryCodeColumn];
        colors.computeIfAbsent(countryCode, k -> Colors.random());
        double lng = (Double.parseDouble(lineArray[longitudeColumn]) / 180 + 1) / 2;
        double lat = Double.parseDouble(lineArray[lattitudeColumn]) / 90;
        Point3DS d = new Point3DS(new Point3D(
                lng, lat, 0d));
        d.texture(new ColorTexture(colors.get(countryCode)));
        PcOnPs pcOnPs = new PcOnPs(testEarth.getSphere(), d);
        pcOnPs.texture(new ColorTexture(colors.get(countryCode)));
        pcOnPs.getParameters().setIncrU(1);
        pcOnPs.getParameters().setEndU(0.1);
        pcOnPs.setConnected(false);
        testEarth.getZ().draw(pcOnPs);
        if (countLine % 100000 == 0) {
            System.out.println("Lines" + countLine);
            System.out.println(d.calculerPoint3D(0.0));
        }
        //}
        countLine++;
    }
}
