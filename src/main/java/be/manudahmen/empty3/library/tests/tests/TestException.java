package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.core.testing.TestObjetSub;

public class TestException extends TestObjetSub {
    public static void main(String[] args) {
        TestException te = new TestException();

        te.loop(false);

        te.publishResult(true);

        te.run();


    }

    public void testScene() throws Exception {
        throw new Exception("Erreur : message :; test");
    }
}
