package be.manudahmen.emptycanvas.library.utils;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by manuel on 30-11-16.
 */
public class ConsoleUtils {
    protected static DateFormat dateFormat;

    static {
        DateFormatter dfer = new DateFormatter();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss-SSSXX");

    }

    public static String currentDate() {

        return dateFormat.format(new Date());
    }
}
