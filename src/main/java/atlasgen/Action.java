package atlasgen;

/**
 * Created by Manuel Dahmen
 * on 19-06-18.
 */
public interface Action {
    public void init();

    public void processLine(CsvLine csvLine);
}
