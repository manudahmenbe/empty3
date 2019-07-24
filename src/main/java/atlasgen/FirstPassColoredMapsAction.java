package atlasgen;

import one.empty3.library.core.lighting.Colors;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Manuel Dahmen on 30-06-18.
 */
public class FirstPassColoredMapsAction implements Action {
    private Pixeler pixeler;
    private HashMap<String, Color> colors = new HashMap<>();

    @Override
    public void init() {
        this.pixeler = pixeler;
    }

    @Override
    public void processLine(CsvLine csvLine) {
        int lattitudeColumn = 4;
        int longitudeColumn = 5;
        int countryCodeColumn = 8;
        String[] lineArray = csvLine.getValue();
        String countryCode = lineArray[17];
        /*for(int i=0; i<lineArray.length; i++)
            if(lineArray[i]!=null)
            System.out.println(""+i+"  "+lineArray[i]);
*/
        if (colors.get(countryCode) == null) {
            colors.put(countryCode, Colors.random());
        }
        pixeler.pixelize(
                (int) ((Double.parseDouble(lineArray[longitudeColumn]) / 180 + 1) / 2 * pixeler.getImage().getWidth()),
                (int) ((-Double.parseDouble(lineArray[lattitudeColumn]) / 90 + 1) / 2 * pixeler.getImage().getHeight()),
                colors.get(countryCode)
        );
    }
}
