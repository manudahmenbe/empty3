package atlasgen;

import java.awt.*;

/**
 * Created by manue on 19-06-18.
 */
public class DrawAction implements Action {

    private Color color;
    private Pixeler pixeler;

    public DrawAction(Pixeler pixeler, Color color) {
        this.pixeler = pixeler;
        this.color = color;
    }


    @Override
    public void init() {

    }

    @Override
    public void processLine(CsvLine csvLine) {
        int lattitudeColumn = 4;
        int longitudeColumn = 5;
        String[] lineArray = csvLine.getValue();
        /*for(int i=0; i<lineArray.length; i++)
            if(lineArray[i]!=null)
                System.out.println(""+i+"  "+lineArray[i]);
        */
        pixeler.pixelize(
                (int) ((Double.parseDouble(lineArray[longitudeColumn]) / 180 + 1) / 2 * pixeler.getImage().getWidth()),
                (int) ((-Double.parseDouble(lineArray[lattitudeColumn]) / 90 + 1) / 2 * pixeler.getImage().getHeight()),
                color
        );
    }
}
