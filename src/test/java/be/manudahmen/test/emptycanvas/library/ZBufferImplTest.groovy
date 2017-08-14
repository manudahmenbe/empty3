/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package be.manudahmen.test.emptycanvas.library

import be.manudahmen.empty3.*
import junit.framework.TestCase
import junit.framework.TestSuite
import org.junit.Test

import java.awt.*

/***
 *
 */
class ZBufferImplTestSuite extends TestSuite {
    /***
     *
     * @return
     */
    @Test
    void testImageSizeGSZBufferBaseDeliveredByZBufferFactory() {
        Number laPres = 640
        Number haPres = 480

        def z = ZBufferFactory.instance(laPres, haPres)

        def la = z.largeur()
        def ha = z.hauteur()

        TestCase.assertTrue((boolean) (la == 640))
        TestCase.assertTrue((boolean) (ha == 480))

        def resx = 1024
        def resy = 768



        Camera camera
        camera = new Camera(new Point3D(0, 0, 0), new Point3D(0, 0, 1))
        camera.calculerMatrice()

        z.camera(camera)

        TestCase.assertNotNull(camera)
    }

/****
 *
 * @return
 */
    @Test
    void testSinglePointAB() {
        ZBuffer z = ZBufferFactory.instance(640, 480)


        Camera c = new Camera(new Point3D(0, 0, 0), new Point3D(0, 0, 1))

        c.calculerMatrice()

        z.camera(c)

        Scene sc = new Scene()

        sc.add(new Point3D(0, 0, 0, new ColorTexture(Color.RED)))

        z.scene(sc)

        z.draw()

        ECBufferedImage eCBufferedImage = z.image()


        z.scene(new Scene())

        z.plotPoint(new Point3D(0, 0, 0), Color.RED)

        TestCase.assertEquals(new Color(eCBufferedImage.getRGB(320, 240)), Color.RED)

    }
/****
 *
 * @return
 */
    @Test
    void testCameraDefault() {
        ZBuffer z = ZBufferFactory.instance(640, 480)

        //Camera c = new Camera(new Point3D(0,0,0), new Point3D(0,0,1))

        //c.calculerMatrice()

        //z.camera(c)

        Scene sc = new Scene()

        sc.add(new Point3D(0, 0, 0, new ColorTexture(Color.RED)))

        z.scene(sc)

        z.draw()

        ECBufferedImage eCBufferedImage = z.image()


        z.scene(new Scene())

        z.plotPoint(new Point3D(0, 0, 0), Color.RED)

        TestCase.assertEquals(new Color(eCBufferedImage.getRGB(320, 240)), Color.RED)

    }
/***
 *
 * @return
 * @throws Exception
 */
    /*
    @Test
    public static void suite() throws Exception {

        def suite = new ZBufferImplTestSuite();
suite.testImageSizeGSZBufferBaseDeliveredByZBufferFactory()
        suite.        testSinglePointAB()
        suite.testCameraDefault()
    }
*/
}