/***
 * ect 27-08-17 Copyright.
 */

package tests.modeleStl;

import one.empty3.library.P;
import one.empty3.library.Scene;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.stl_loader.IncorrectFormatException;
import one.empty3.library.stl_loader.ParsingErrorException;
import one.empty3.library.stl_loader.StlFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class TestStl extends TestObjetSub {
    private BufferedReader reader;

    @Override
    public void ginit() {
        super.ginit();
        StlFile file = new StlFile();
        Scene load = new Scene();
        try {
            File file1 = new File("target/classes/be/manudahmen/empty3/one.empty3.library/tests2/modeleStl/another_nude_girl-ascii.stl");
            load = file.load(file1.getAbsolutePath());
        } catch (IncorrectFormatException | IOException | ParsingErrorException e) {
            e.printStackTrace();
        }
        scene().add(load.get(0));

        camera().setEye(P.n(0, 0, -1000.0));
    }


    public static void main(String[] args) {
        TestStl stl = new TestStl();
        new Thread(stl).start();
    }

}
