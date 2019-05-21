/**
 * Importer une autre test: ah si ca pouvait être fait par classes!
 */
package tests.repereAssocieAUneCourbeEX;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.EOFVideoException;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TextureMov;
import be.manudahmen.empty3.core.nurbs.CameraInPath;
import be.manudahmen.empty3.core.testing.TestObjet;
import be.manudahmen.empty3.core.tribase.TRIEllipsoide;

import java.awt.*;

/**
 * @author Manuel Dahmen
 */
public class TestCameraEnMouvement extends TestObjet {

    TextureMov textureMov;
    private CameraInPath cam;
    private TRIEllipsoide e;

    public static void main(String[] args) {
        TestCameraEnMouvement t = new TestCameraEnMouvement();
        t.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        t.setMaxFrames(10 * 25);
        new Thread(t).start();
    }

    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() throws EOFVideoException {
        cam.setT(frame / 25.0 / 8);
        cam.calculerMatrice(null);
        textureMov.nextFrame();
    }

    @Override
    public void ginit() {
        CourbeChoisie cc = new CourbeChoisie(21, 11, 11, 8);

        cam = new CameraInPath(cc);

        e = new TRIEllipsoide(Point3D.O0, 20, 10, 10);
        textureMov = new TextureMov("resources/mov/moi.mp4");
        textureMov.setTransparent(Color.BLACK);
        e.texture(textureMov);

        e.setMaxX(40);
        e.setMaxY(40);

        scene().add(e);

        scene().cameraActive(new Camera(new Point3D(30, 0, -30), new Point3D(0, 0, 0)));

        scene().cameraActive(cam);

    }

    @Override
    public void testScene() throws Exception {
        textureMov.nextFrame();
    }

    public void afterRender() {

    }
}
