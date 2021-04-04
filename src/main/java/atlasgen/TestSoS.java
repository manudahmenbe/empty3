/*
 *  This file is part of Empty3.
 *
 *     Empty3 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Empty3 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Empty3.  If not, see <https://www.gnu.org/licenses/>. 2
 */

/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

package atlasgen;

import one.empty3.library.*;
import one.empty3.library.core.nurbs.CameraInPath;
import one.empty3.library.core.nurbs.PcOnPs;
import one.empty3.library.core.testing.TestObjetSub;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*__
 * G:\Apps\IdeaProjects\empty3\src\test\java\be\manudahmen\empty3\one.empty3.library\tests\TestSoS.java
 * Created by manue on 02-02-19.0
 */
public class TestSoS extends TestObjetSub {
    private CameraInPath camera;
    protected String[] list;
    private int planetNo;
    private boolean quadrillage;

    class HeightMapSurfaceSphere extends  HeightMapSurface {
        ITexture heightMap;

        public HeightMapSurfaceSphere(Axe axe, double radius, BufferedImage bi) {
            super(new Sphere(axe, radius), bi);
        }

        public Point3D height(double u, double v) {
            Point3D mult = surface.getElem().calculerPoint3D(u, v).moins(((Sphere) surface.getElem()).getCircle().getCenter()).norme1().
                    mult(
                            new Color(
                                            image.getElem().getImage().getElem().getRGB((int) (u * image.getElem().getImage().getElem().getWidth()),
                                                    (int) (v * image.getElem().getImage().getElem().getHeight())))
                            .getRed() / 256.0);
            return mult


                    ;
        }
    }

    protected static final double RADIUS = 6371000;
    private static final double HEIGHT_MAX_ALT = 8.870;
    protected static final double HEIGHT_MAX = HEIGHT_MAX_ALT * 10000;

    private static final int NSEG = 8;
    private static final int NSEG2 = 24;
    private Point3D pointsB;
    private Point3D pointsA;
    private RepresentableConteneur representableConteneur
            = new RepresentableConteneur();
    protected HeightMapSurfaceSphere heightMapSurfaceSphere;
    private Point3D sphereOrig = Point3D.O0;
    TextureCol textureCol = new TextureCol(Color.RED);
    private Point3D sphereDest = Point3D.Y;
    ITexture colorTextureSurface = new TextureCol(Color.GREEN);
    private double segemntSize = 1;

    public void ginit() {
        list = new File("res/img/planets").list();
        planetNo = 0;
        setMaxFrames(360 * list.length);
    }


    public void finit() {


        if ((frame() % (360)) == 1) {

            scene().getObjets().data1d.clear();

            BufferedImage bufferedImageHeightMap = null;
            BufferedImage bufferedImageTexture = null;
            try {
                bufferedImageHeightMap = ImageIO.read(new File("res/img/gebco_08_rev_elev_21600x10800.png"));
                bufferedImageTexture = ImageIO.read(new File("res/img/planets/" + list[planetNo++]));

            } catch (IOException e) {
                e.printStackTrace();
            }
            heightMapSurfaceSphere = new HeightMapSurfaceSphere(new Axe(sphereOrig.moins(Point3D.X),
                    sphereOrig.plus(Point3D.X)), RADIUS, bufferedImageHeightMap);
            heightMapSurfaceSphere.texture(colorTextureSurface);

            TextureImg textureImg = new TextureImg(new ECBufferedImage(bufferedImageTexture));
            TextureOpSphere textureOpSphere = new TextureOpSphere(textureImg);
            heightMapSurfaceSphere.setIncrU(0.1);
            heightMapSurfaceSphere.setIncrV(0.1);
            heightMapSurfaceSphere.texture(textureOpSphere);


            scene().add(representableConteneur);

            scene().add(heightMapSurfaceSphere);

            if (isQuadrillage()) {
                for (int s = 0; s < NSEG;
                     s++) {

                    pointsA = new Point3D(0d, 1.0 * s / NSEG, 0d);
                    pointsB = new Point3D(1d, 1.0 * s / NSEG, 0d);
                    LineSegment segmentDroite = new LineSegment(pointsA, pointsB);
                    segmentDroite.texture(textureCol);
                    pointsA.texture(textureCol);
                    pointsB.texture(textureCol);

                    PcOnPs pcOnPs = new PcOnPs(heightMapSurfaceSphere, segmentDroite);
                    pcOnPs.getParameters().setIncrU(0.0001);
                    representableConteneur.add(pcOnPs);

                }
                for (int s = 0; s < NSEG2;
                     s++) {

                    pointsA = new Point3D(1.0 * s / NSEG2, 0d, 0d);
                    pointsB = new Point3D(1.0 * s / NSEG2, 1d, 0d);
                    LineSegment segmentDroite = new LineSegment(pointsA, pointsB);
                    segmentDroite.texture(textureCol);
                    pointsA.texture(textureCol);
                    pointsB.texture(textureCol);

                    PcOnPs pcOnPs = new PcOnPs(heightMapSurfaceSphere, segmentDroite);
                    pcOnPs.getParameters().setIncrU(0.0001);
                    representableConteneur.add(pcOnPs);

                }
            }
        /*
        PcOnPs circleEquator = new SegmentsOnSurface(
                new Sphere(heightMapSurfaceSphere.getAxe(), RADIUS*3)
                , new LineSegment(
                new Point3D(0.0, 0.5, 0), new Point3D(1.0, 0.5, 0)));
*/
            camera = new CameraInPath(new Circle(
                    new Axe(Point3D.O0.plus(Point3D.X), Point3D.O0.moins(Point3D.X)), RADIUS * 4));
            scene().add(camera);

//        camera = new CameraInPath(circleEquator);
            scene().cameraActive(camera);
        }

        double t = 1.0 * frame() / (getMaxFrames() / list.length);
        camera.setT(t);

        Point3D z = Point3D.O0.moins(camera.getCourbe().calculerPoint3D(t)).norme1();
        Point3D x = camera.getCourbe().tangente(t).norme1().mult(-1d);
        Point3D y = x.prodVect(z).norme1();
        camera.setMatrix(x, y, z);
        //camera.calculerMatrice(y);
    }

    private boolean isQuadrillage() {
        return quadrillage;
    }

    protected void setQuadrillage(boolean q) {
        quadrillage = q;
    }

    public HeightMapSurfaceSphere getSphere() {
        return heightMapSurfaceSphere;
    }

    public void setSphere(HeightMapSurfaceSphere sphere) {

        heightMapSurfaceSphere = sphere;
    }

    public static void main(String[] args) {
        TestSoS testSoS = new TestSoS();
        new Thread(testSoS).start();
    }
}
