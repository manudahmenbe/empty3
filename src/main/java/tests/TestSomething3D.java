package tests;

import be.manudahmen.empty3.Representable;
import be.manudahmen.empty3.core.testing.TestObjet;

/**
 * Created by Win on 29-08-18.
 */
public abstract class TestSomething3D<T extends Representable> extends TestObjet {


    @Override
    public void afterRenderFrame() {

    }

    @Override
    public abstract void finit();

    @Override
    public void ginit() {

    }

    @Override
    public void afterRender() {
        System.gc();
    }

    @Override
    public void testScene() throws Exception {

    }
}
