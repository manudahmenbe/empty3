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

import be.manudahmen.emptycanvas.library.empty3.library.object.*

import java.awt.*

class ZBufferImplTest extends groovy.util.GroovyTestCase {
    def void testImageSizeGSZBufferBaseDeliveredByZBufferFactory() {
        def Number laPres = 640
        def Number haPres = 480

        def z = ZBufferFactory.instance(laPres, haPres)

        def la = z.largeur();
        def ha = z.hauteur();

        assertTrue(la == 640)
        assertTrue(ha == 480)

        def resx = 1024
        def resy = 768



        def Camera camera
        camera = new Camera(new Point3D(0, 0, 0), new Point3D(0, 0, 1))
        camera.calculerMatrice()

        z.camera(camera)

        assertNotNull(camera)
    }

    @Override
    void setUp() {
        super.setUp()

    }

    @Override
    void tearDown() {
        super.tearDown();
    }

    void testSinglePointAB() {
        ZBuffer z = ZBufferFactory.instance(640, 480)


        Camera c = new Camera(new Point3D(0, 0, 0), new Point3D(0, 0, 1))

        c.calculerMatrice()

        z.camera(c)

        Scene sc = new Scene()

        sc.add(new Point3D(0, 0, 0, new ColorTexture(Color.RED)))

        z.scene(sc)

        z.dessinerSilhouette3D()

        def ECBufferedImage eCBufferedImage = z.image()


        z.scene(new Scene())

        z.plotPoint(new Point3D(0, 0, 0), Color.RED)

        assertEquals(new Color(eCBufferedImage.getRGB(320, 240)), Color.RED)

    }

    void testCameraDefault() {
        ZBuffer z = ZBufferFactory.instance(640, 480)

        //Camera c = new Camera(new Point3D(0,0,0), new Point3D(0,0,1))

        //c.calculerMatrice()

        //z.camera(c)

        Scene sc = new Scene()

        sc.add(new Point3D(0, 0, 0, new ColorTexture(Color.RED)))

        z.scene(sc)

        z.dessinerSilhouette3D()

        def ECBufferedImage eCBufferedImage = z.image()


        z.scene(new Scene())

        z.plotPoint(new Point3D(0, 0, 0), Color.RED)

        assertEquals(new Color(eCBufferedImage.getRGB(320, 240)), Color.RED)

    }

}