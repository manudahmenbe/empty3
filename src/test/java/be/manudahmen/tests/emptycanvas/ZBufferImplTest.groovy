package be.manudahmen.tests.emptycanvas

import be.manudahmen.emptycanvas.library.empty3.library.object.ZBufferFactory

class ZBufferImplTest extends groovy.util.GroovyTestCase {
    def void testAsssertionZBufferBase() {
        def Number
        def Number laPres = 640
        def Number haPres = 480

        def z = ZBufferFactory.instance(laPres, haPres);

        def la = z.largeur();
        def ha = z.hauteur();

        assertTrue(la == 640)
        assertTrue(ha == 480)
    }
}