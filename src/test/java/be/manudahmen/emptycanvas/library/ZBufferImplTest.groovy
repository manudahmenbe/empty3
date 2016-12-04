/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package be.manudahmen.emptycanvas.library

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