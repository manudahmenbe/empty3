package tests.tubulaire2ncc;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.nurbs.CourbeParametriquePolynomialeBezier;
import be.manudahmen.empty3.core.nurbs.Fct1D_1D;
import be.manudahmen.empty3.core.testing.TestObjetSub;
import be.manudahmen.empty3.core.tribase.TubulaireN2cc;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by manue on 28-05-19.
 */
public class TestCones extends TestObjetSub{

    public int MAXFRAMES = 2000;
    public int N = 7;
    public int Ncolors = 6;
    private Point3D[] s;
    private Point3D[] v;
    private double V = 0.08;
    private double D = 1.0;
    private double TUBE_RAYON = 0.1;
    private HashMap<Point2D, Color> map = new HashMap<Point2D, Color>();
    private TubulaireN2cc tubulaireNcc;
    private ITexture itext;

    public static void main(String[] args) {
        TestCones th = new TestCones();

        th.loop(true);

        th.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        th.run();
    }

    @Override
    public void ginit() {
        try {
            itext = new TextureImg(ECBufferedImage.getFromFile(new File("resources/img/2iu2h2w0.bmp")));
        } catch (IOException ex) {
            itext = new TextureCol(Color.BLUE);
        }


        s = new Point3D[N];
        v = new Point3D[N];
        for (int i = 0; i < N; i++) {

            s[i] = rand(-D, D);

            v[i] = rand(-V, V);

        }

        Camera camera;
        camera = new Camera(new Point3D(0d, 0d, -3d),
                new Point3D(0d, 0d, 0d));

        scene().cameraActive(camera);

    }

    public Point3D rand(double limitMinus, double limitPlus) {
        double[] d = new double[3];
        for (int i = 0; i < 3; i++) {
            d[i] = (limitPlus - limitMinus) * Math.random() + limitMinus;
        }
        return new Point3D(d, null);
    }

    public void bounce(int i) {
        s[i] = s[i].plus(v[i]);

        if (s[i].getX() > D && v[i].getX() > 0) {
            v[i].setX(-v[i].getX());
        }
        if (s[i].getX() < -D && v[i].getX() < 0) {
            v[i].setX(-v[i].getX());
        }
        if (s[i].getY() > D && v[i].getY() > 0) {
            v[i].setY(-v[i].getY());
        }
        if (s[i].getY() < -D && v[i].getY() < 0) {
            v[i].setY(-v[i].getY());
        }
        if (s[i].getZ() > D && v[i].getZ() > 0) {
            v[i].setZ(-v[i].getZ());
        }
        if (s[i].getZ() < -D && v[i].getZ() < 0) {
            v[i].setZ(-v[i].getZ());
        }
    }

    @Override
    public void finit() {
        scene().clear();
        for (int i = 0; i < s.length; i++) {
            bounce(i);

        Point3D[] point3DS = new Point3D[s.length];
        for(int j=0; j<s.length; j++)
            point3DS[j] = s[j];

        tubulaireNcc = new TubulaireN2cc(new CourbeParametriquePolynomialeBezier(point3DS),
                new Fct1D_1D() {
                    @Override
                    public double result(double input) {
                        return input*TUBE_RAYON;
                    }
                });
        tubulaireNcc.texture(itext);
        tubulaireNcc.nbrAnneaux(40);
        tubulaireNcc.nbrRotations(20);
        scene().add(tubulaireNcc);
        }

        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.X, Color.RED);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);

        lumierePonctuelle = new LumierePonctuelle(Point3D.Y, Color.GREEN);
        lumierePonctuelle.setR0(1);

        scene().lumieres().add(lumierePonctuelle);
        scene().lumieres().add(new LumierePonctuelle(Point3D.O0, Color.WHITE));

    }

}
