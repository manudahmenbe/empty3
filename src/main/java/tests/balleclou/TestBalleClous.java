package tests.balleclou;


import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.extra.BalleClous;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Se7en
 */
public class TestBalleClous extends TestObjetSub {
    public int MAXFRAMES;
    private TextureCol tc = new TextureCol(Color.red);
    private BalleClous ballec;

    public static void main(String[] args) {
        TestBalleClous th = new TestBalleClous();

        th.loop(true);

        th.MAXFRAMES = 1000;

        th.setMaxFrames(th.MAXFRAMES);

        th.setGenerate(GENERATE_MOVIE | GENERATE_IMAGE);

        th.run();
    }

    @Override
    public void ginit() {


        ballec = new BalleClous(Point3D.O0, 50);


        ballec.setMaxX(40);

        ballec.setMaxY(40);


        int m, n;

        m = 5;
        n = 5;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                ballec.addPoint(new Point2D(1.0 * i / m, 1.0 * j / n));
            }


        try {

            ballec.texture(
                    new TextureImg(
                            new ECBufferedImage(ImageIO.read(new File("samples/img/PHOTO-NU.jpg")))
                    ));


        } catch (IOException ex) {
            Logger.getLogger(TestBalleClous1.class.getName()).log(Level.SEVERE, null, ex);
            ballec.texture(new TextureCol(Color.RED));
        }

        scene().add(ballec);


        scene().lumieres().add(new LumierePonctuelle(Point3D.Z, Color.YELLOW));


        Camera camera;
        camera = new Camera(new Point3D(0d, 0d, -200d),
                new Point3D(0d, 0d, 0d));

        scene().cameraActive(camera);

    }

    @Override
    public void testScene() throws Exception {
        ballec.param(1.0 / (0.001+frame /0.001) * MAXFRAMES);
        exportFrame("export-stl", "export-" + frame + ".STL");


    }
}

