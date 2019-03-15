package be.manudahmen.empty3.library.tests.sw;

import be.manudahmen.empty3.Camera;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.testing.TestObjetSub;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Win on 16-01-16.
 */
public class TestTitle extends TestObjetSub {
    String text;
    TextObjet textObjet = new TextObjet(new Point3D(1000, 1000, 1000), new Point3D(-2000, 0, 0), new Point3D(0, -2000 * Math.tan(angle()), -2000 * Math.sin(angle())));
    Camera c = new Camera(new Point3D(0, 0, -1000), new Point3D(0, 0, 1000));

    public static void main(String[] args) {
        TestTitle ts = new TestTitle();

        ts.loop(true);

        ts.setMaxFrames(200);

        new Thread(ts).start();
    }

    public double angle() {
        return 45.0 / 360 * 2 * Math.PI;
    }

    @Override
    public void ginit() {
        byte[] readbefore = new byte[512];
        InputStream is = null;
        try {
            is = getClass().getResourceAsStream("text.txt");
            while (is.read(readbefore) > 0) {
                text += readbefore.toString();
            }
        } catch (IOException e) {
            text = "Not initialized or error";
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        textObjet.setTextColor(Color.WHITE);
        textObjet.setText(text);

        scene().add(textObjet);
    }

    @Override
    public void finit() {
        textObjet.deplace(new Point3D(
                0, 10 * Math.tan(angle()), 20 * Math.sin(angle())));
    }

    @Override
    public void testScene() throws Exception {
        super.testScene();
    }

}

