/***
 * ect 27-08-17 Copyright.
 */

package tests.modeleStl;

import be.manudahmen.empty3.P;
import be.manudahmen.empty3.Scene;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.stl_loader.IncorrectFormatException;
import be.manudahmen.empty3.stl_loader.ParsingErrorException;
import be.manudahmen.empty3.stl_loader.StlFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class TestStl2 extends TestObjetSub {
    private BufferedReader reader;

    @Override
    public void ginit() {
        super.ginit();
        StlFile file = new StlFile();
        Scene load = new Scene();
        try {
            File file1 = new File("target/classes/be/manudahmen/empty3/library/tests/modeleStl/Skull-ascii.stl");
            load = file.load(file1.getAbsolutePath());
        } catch (IncorrectFormatException | IOException | ParsingErrorException e) {
            e.printStackTrace();
        }
        scene().add(load.get(0));

        camera().setEye(P.n(0, 0, -1500.0));
    }


    public static void main(String[] args) {
        TestStl2 stl = new TestStl2();
        new Thread(stl).start();
    }

}
