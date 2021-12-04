/*__
 * Importer une autre test: ah si ca pouvait être fait par classes!
 */
package tests.tests2.repereAssocieAUneCourbeEX;

import one.empty3.library.*;
import one.empty3.library.core.nurbs.CameraInPath;
import one.empty3.library.core.nurbs.CourbeParametriquePolynomialeBezier;
import one.empty3.library.core.nurbs.ExtrusionB1B1;
import one.empty3.library.core.testing.Resolution;
import one.empty3.library.core.testing.TestObjet;
import one.empty3.library.core.tribase.TRICylindre;

import java.awt.*;

/*__
 *
 * @author Manuel Dahmen
 */
public class TestCameraEnMouvementCylindre extends TestObjet {

    TextureMov textureMov;
    private CameraInPath cam;
    private ExtrusionB1B1 e;

    public static void main(String[] args) {
        TestCameraEnMouvementCylindre t = new TestCameraEnMouvementCylindre();
        t.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        t.setMaxFrames(30 * 25);
        t.setDimension(new Resolution(640, 480));
        t.setPublish(true);
        new Thread(t).start();
    }

    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() throws EOFVideoException {
        cam.setT(frame / 25.0 / 8);
        cam.setMatrice(cam.getMatrice().tild());
        textureMov.nextFrame();
    }

    @Override
    public void ginit() {
        CourbeChoisie cc = new CourbeChoisie(4, 0.8, 0.7, 8);

        cam = new CameraInPath(cc);

        e = new ExtrusionB1B1();
        e.getPath().setElem(new CourbeParametriquePolynomialeBezier());
        e.getBase().setElem(new Circle(new Axe(Point3D.Y.mult(-1), Point3D.Y), 10));
        ((CourbeParametriquePolynomialeBezier)(e.getPath().getElem())).getCoefficients().add(Point3D.O0);
        ((CourbeParametriquePolynomialeBezier)(e.getPath().getElem())).getCoefficients().add(Point3D.Z);
        textureMov = new TextureMov("C:\\Users\\manue\\Videos\\mes vidéos\\VID_20201019_132528.mp4");
        textureMov.setTransparent(Color.BLACK);
        e.texture(textureMov);

        scene().add(e);

        scene().cameraActive(cam);

    }

    @Override
    public void testScene() throws Exception {

    }

    public void afterRender() {

    }
}
