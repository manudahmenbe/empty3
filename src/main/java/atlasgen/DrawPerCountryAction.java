package atlasgen;

import one.empty3.library.core.lighting.Colors;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manuel Dagmen on 29-06-18.
 */
public class DrawPerCountryAction implements Action {
    private boolean firstPass = false;
    private Map<String, Color> colors = new HashMap<String, Color>();

    private Pixeler pixeler;

    public DrawPerCountryAction(Pixeler pixeler) {
        this.pixeler = pixeler;
    }


    @Override
    public void init() {

    }

    @Override
    public void processLine(CsvLine csvLine) {
        int lattitudeColumn = 4;
        int longitudeColumn = 5;
        int countryCodeColumn = 8;
        String[] lineArray = csvLine.getValue();
        String countryCode = lineArray[countryCodeColumn];
        colors.computeIfAbsent(countryCode, k -> Colors.random());

        pixeler.pixelize(
                (int) ((Double.parseDouble(lineArray[longitudeColumn]) / 180 + 1) / 2 * pixeler.getImage().getWidth()),
                (int) ((-Double.parseDouble(lineArray[lattitudeColumn]) / 90 + 1) / 2 * pixeler.getImage().getHeight()),
                colors.get(countryCode)
        );
    }
}
