package tests.balleclou;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.extra.BalleClous;
import be.manudahmen.empty3.core.lighting.Colors;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;

/**
 * @author Manuel Dahmen
 */
public class TestBalleClous1111 extends TestObjetSub {

    public int MAXFRAMES = 2000;

    public int N = 3;
    private ITexture tc = new TextureCol(Color.red);
    private BalleClous ballec;
    private Point2D[][] s;
    private Point2D[][] v;
    private double V = 0.03;
    private double D = 1;
    private TextureMov textureMov;
    private BalleClous[] balles = new BalleClous[N];
    private int nBalles = 1;
    private int nPoints = 10;

    public static void main(String[] args) {
        TestBalleClous1111 th = new TestBalleClous1111();

        th.loop(true);

        //th.setResx(640);
        //th.setResy(480);

        th.setMaxFrames(th.MAXFRAMES);

        th.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        th.run();
    }

    @Override
    public void ginit() {
        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.X, Color.RED);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        lumierePonctuelle = new LumierePonctuelle(Point3D.Y, Color.BLUE);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);
        scene().lumieres().add(new LumierePonctuelle(Point3D.O0, Colors.random()));

        s = new Point2D[nBalles][N];
        v = new Point2D[nBalles][N];

        for (int b = 0; b < nBalles; b++) {
            tc =
                    new TextureCol(
                            Colors.random());
            for (int i = 0; i < N; i++) {
                s[b][i] = new Point2D(Math.random(), Math.random());

                v[b][i] = new Point2D(Math.random() * (V / 2 - V), Math.random() * (V / 2 - V));

            }
            ballec = new BalleClous(Point3D.O0, 10);

            balles[b] = ballec;
            ballec.texture(new TextureCol(Colors.random()));
            //textureMov = new TextureMov("C:\\Emptycanvas\\Resources\\BigFloEtOlie.mp4");
            //textureMov.setTransparent(Color.BLACK);
            //ballec.texture(textureMov);
            for(int j=0; j<nPoints; j++)
                ballec.addPoint(new Point2D(Math.random(), Math.random()));
            scene().add(ballec);


        }
        Camera camera;
        camera = new Camera(new Point3D(-1600, 0, 0),
                new Point3D(0, 0, 0));

        scene().cameraActive(camera);
    }

    public void bounce(int numBalle, int i) {
        s[numBalle][i] = s[numBalle][i].plus(v[numBalle][i]);


        if (s[numBalle][i].getX() > D && v[numBalle][i].getX() > 0) {
            v[numBalle][i].setX(-v[numBalle][i].getX());
        }
        if (s[numBalle][i].getX() < -D && v[numBalle][i].getX() < 0) {
            v[numBalle][i].setX(-v[numBalle][i].getX());
        }
        if (s[numBalle][i].getY() > D && v[numBalle][i].getY() > 0) {
            v[numBalle][i].setY(-v[numBalle][i].getY());
        }
        if (s[numBalle][i].getY() < -D && v[numBalle][i].getY() < 0) {
            v[numBalle][i].setY(-v[numBalle][i].getY());
        }
    }

    @Override
    public void testScene() throws Exception {
        for (int b = 0; b < nBalles; b++) {
            ballec = balles[b];

            for (int i = 0; i < s[0].length; i++) {
                bounce(b, i);
            }


            ballec.points().clear();
            double totalA = 0;
            double totalB = 0;

            for (int j = 0; j < N; j++) {
                if (s[b][j].getX() < 0) {
                    s[b][j].setX(s[b][j].getX() + D);
                }
                if (s[b][j].getY() < 0) {
                    s[b][j].setY(s[b][j].getY() + D);
                }
                if (s[b][j].getX() > D) {
                    s[b][j].setX(s[b][j].getX() - D);
                }
                if (s[b][j].getY() > D) {
                    s[b][j].setY(s[b][j].getY() - D);
                }

                totalA += s[b][j].getX();
                totalB += s[b][j].getY();

                ballec.addPoint(new Point2D(s[b][j].getX(), s[b][j].getY()));

            }

        }
    }

}
