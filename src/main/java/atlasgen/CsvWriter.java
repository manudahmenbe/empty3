package atlasgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Win on 01-07-18.
 */
public class CsvWriter {
    private final String columnSeparator;
    private final String lineSeparator;
    FileOutputStream fis;

    public CsvWriter(String lineSeparator,
                     String columnSeparator
    ) {
        this.lineSeparator = lineSeparator;
        this.columnSeparator = columnSeparator;
    }

    public int openFile(File csvFile) {
        try {
            fis = new FileOutputStream(csvFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public int writeLine(String[] lineArray) {
        byte[] bytes;
        StringBuilder sb = new StringBuilder(100);
        int i = 0;
        for (String column : lineArray) {
            sb.append(column);
            if (i < lineArray.length - 1)
                sb.append(columnSeparator);
        }
        sb.append(lineSeparator);

        try {
            fis.write(sb.substring(0).getBytes());
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public int closeFile() {
        try {
            fis.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
        try {
            fis.close();
            return 0;
        } catch (IOException e) {

            e.printStackTrace();
            return -1;
        }
    }

}
