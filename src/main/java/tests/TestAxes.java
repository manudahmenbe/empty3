package tests;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Matrix33;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.Plan3D;

import java.awt.*;

/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * Creation time 02-nov.-2014
 * <p>
 * *
 */

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestAxes extends TestObjetSub {

    public static void main(String[] args) {
        TestAxes testAxes = new TestAxes();
        testAxes.loop(true);
        testAxes.setMaxFrames(3);
        new Thread(testAxes).start();

    }

    @Override
    public void testScene() {
        Plan3D planX = new Plan3D();
        Plan3D planY = new Plan3D();
        Plan3D planZ = new Plan3D();
        planX.pointOrigine(Point3D.O0);
        planX.pointXExtremite(Point3D.X);
        planX.pointYExtremite(Point3D.Y.mult(0.3));
        planX.texture(new TextureCol(Color.RED));
        planY.pointOrigine(Point3D.O0);
        planY.pointXExtremite(Point3D.Y);
        planY.pointYExtremite(Point3D.Z.mult(0.3));
        planY.texture(new TextureCol(Color.GREEN));
        planZ.pointOrigine(Point3D.O0);
        planZ.pointXExtremite(Point3D.Z);
        planZ.pointYExtremite(Point3D.X.mult(0.3));
        planZ.texture(new TextureCol(Color.BLUE));
        scene().add(planX);
        scene().add(planY);
        scene().add(planZ);
        Camera camera = new Camera();
        camera.setEye(Point3D.Z.mult(-1));
        if (frame() == 0) {
            camera.imposerMatrice(new Matrix33(
                    new double[]
                            {
                                    1, 0, 0,
                                    0, 1, 0,
                                    0, 0, 1
                            }
            ));
        } else if (frame() == 1) {
            camera.imposerMatrice(new Matrix33(
                    new double[]
                            {
                                    0, 0, 1,
                                    1, 0, 0,
                                    0, 1, 0
                            }
            ));
        } else if (frame() == 2) {
            camera.imposerMatrice(new Matrix33(
                    new double[]
                            {
                                    0, 1, 0,
                                    0, 0, 1,
                                    1, 0, 0
                            }
            ));
        }

        camera.calculerMatrice();
        scene().cameraActive(camera);
    }

}
