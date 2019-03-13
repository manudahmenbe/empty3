/**
 * Importer une autre test: ah si ca pouvait être fait par classes!
 */
package be.manudahmen.empty3.library.tests.repereAssocieAUneCourbeEX;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.EOFilmException;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TextureMov;
import be.manudahmen.empty3.core.sanorm.CameraInPath;
import be.manudahmen.empty3.core.testing.TestObjet;
import be.manudahmen.empty3.core.tribase.TRICylindre;

import java.awt.*;

/**
 *
 * @author Manuel Dahmen
 */
public class TestCameraEnMouvementCylindre extends TestObjet {

    TextureMov textureMov;
    private CameraInPath cam;
    private TRICylindre e;

    public static void main(String[] args) {
        TestCameraEnMouvementCylindre t = new TestCameraEnMouvementCylindre();
        t.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        t.setMaxFrames(30 * 25);
        t.setResx(640);
        t.setResy(480);
        new Thread(t).start();
    }

    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() throws EOFilmException {
        cam.setTemps01(frame / 25.0 / 8);
        textureMov.nextFrame();
    }

    @Override
    public void ginit() {
        CourbeChoisie cc = new CourbeChoisie(11, 11, 21, 8);

        cam = new CameraInPath(cc);

        e = new TRICylindre(10, 20);
        textureMov = new TextureMov("C:\\Users\\Win\\Videos\\MOV0007A.AVI");
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

    }

    public void afterRender() {

    }
}
