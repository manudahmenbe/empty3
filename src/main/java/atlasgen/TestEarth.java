package atlasgen;

import java.io.File;

/**
 * Created by manue on 28-04-19.
 */
public class TestEarth extends TestSoS {


    private CsvReader csvReader;

    public static void main(String[] args) {
        TestEarth testEarth = new TestEarth();
        testEarth.setResolution(800, 600);
        testEarth.setQuadrillage(false);
        //testEarth.addAudioFile(new File("res/mp3/Louis Armstrong - What a wonderful world  ( 1967 ).mp3"));
        new Thread(testEarth).start();
    }

    public void ginit() {
        super.ginit();
        setMaxFrames(360 * list.length);
        csvReader = new CsvReader(new File("allCountries/allCountries.txt"),
                "" + '\t', "" + '\n', false);
        csvReader.setAction(new DrawPerCountryActionSphere(this));


    }

    public void finit() {
        try {
            super.finit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testScene() {
        //csvReader.process();
        //System.out.println("rendering now!");
    }
}