package one.empty3.tests;

import one.empty3.library.core.testing.TestObjetSub;

public class TestVoiture extends TestObjetSub {
    public void ginit() {
        scene().add(new Voiture());
        setMaxFrames(1);
    }

    @Override
    public void finit() throws Exception {
        super.finit();
    }
    public static void main(String [] args) {
        TestVoiture testVoiture = new TestVoiture();
        testVoiture.setGenerate(GENERATE_MODEL | testVoiture.GENERATE_IMAGE|GENERATE_MOVIE);
        testVoiture.setPublish(true);
        new Thread(testVoiture).start();
    }
}
