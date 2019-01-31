/***
 Global license :

 Microsoft Public Licence

 author Manuel Dahmen <ibiiztera.it@gmail.com>
 ***/


package be.manudahmen.empty3.library.tests.spirale;

import be.manudahmen.empty3.core.renderer.TestObjetStub;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class Spirale extends TestObjetStub {
    public static void main(String[] args) {
        Spirale s = new Spirale();

        s.setResx(2000);
        s.setResy(1500);

        s.setMaxFrames(1500);

        s.setGenerate(GENERATE_IMAGE);

        new Thread(s).start();

    }

    @Override
    public void ginit() {
    }

    @Override
    public void testScene() throws Exception {
    }

}
