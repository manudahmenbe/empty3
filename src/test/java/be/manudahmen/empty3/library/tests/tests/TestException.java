package be.manudahmen.empty3.library.tests.tests;

import be.manudahmen.empty3.core.testing.TestObjetStub;

public class TestException extends TestObjetStub {
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
