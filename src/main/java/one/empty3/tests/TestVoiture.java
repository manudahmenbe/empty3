package one.empty3.tests;

import one.empty3.library.core.testing.TestObjetSub;

public class TestVoiture extends TestObjetSub {
    public void ginit() {
        scene().add(new Voiture());
        setGenerate(GENERATE_MODEL | getGenerate());
        setPublish(true);
        setMaxFrames(1);
    }

    @Override
    public void finit() throws Exception {
        super.finit();
    }
    public static void main(String [] args) {
        TestVoiture testVoiture = new TestVoiture();
        testVoiture.setPublish(true);
        new Thread(testVoiture).start();
    }
}
