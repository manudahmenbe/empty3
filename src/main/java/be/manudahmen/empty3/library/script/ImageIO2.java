package be.manudahmen.empty3.library.script;

import be.manudahmen.empty3.library.object.Scene;

import java.io.File;

public class ImageIO2 {

    public Scene read(File directory, File mooName) {
        Scene sc = new Scene();
        new Loader().loadIF(
                new File(directory.getAbsolutePath() + File.separator + mooName + ".ec"), sc
        );

        new Loader().loadData(
                new File(directory.getAbsolutePath() + File.separator + mooName + ".ecd"), sc
        );

        return sc;
    }

}
