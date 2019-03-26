/*
 * 2013 Manuel Dahmen
 */
package be.manudahmen.empty3.library.tests.horloge;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.tribase.TRISphere;
import be.manudahmen.empty3.core.tribase.TubulaireN2;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Horloge extends JFrame {
    private final JLabel label;
    Configuration c = new Configuration();
    Color h;
    Color m;
    Color s;
    Dimension res;
    Scene sc;
    private boolean montre = true;
    private TRISphere s0;
    private TRISphere sH;
    private TRISphere sS;
    private TRISphere sM;
    private SegmentDroite droite2;
    private SegmentDroite droite0;
    private SegmentDroite droite1;

    public Horloge(Color h, Color m, Color s) {
        super("Horloge 3D");
        this.h = h;
        this.m = m;
        this.s = s;
        label = new JLabel("Horloge");

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {

                System.out.println("Resize ...");

            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == new Character('f')) {
                } else {
                    c.showAndReturnBack();

                    update(c);
                }
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setContentPane(label);

        setSize(1024, 768);


        setVisible(true);

    }

    public static void main(String[] args) {

        Horloge h = new Horloge(null, null, null);
        h.montrer();
    }

    public void initTime() {
        double f = 2 * Math.PI;

        Date d = new Date();

        sc = new Scene();

        s0 = new TRISphere(Point3D.O0, 10);
        sH = new TRISphere(position(f * d.getHours() / 12)
                .mult(80), 12);
        sM = new TRISphere(position(f * d.getMinutes() / 60)
                .mult(80), 8);
        sS = new TRISphere(position(f * d.getSeconds() / 60)
                .mult(80), 6);
        TRISphere sG0 = new TRISphere(position(f * 0.0 / 12)
                .mult(80), 10);
        TRISphere sG3 = new TRISphere(position(f * 3.0 / 12)
                .mult(80), 10);
        TRISphere sG6 = new TRISphere(position(f * 6.0 / 12)
                .mult(80), 10);
        TRISphere sG9 = new TRISphere(position(f * 9.0 / 12)
                .mult(80), 10);
        sG0.texture(new TextureCol(Color.GREEN));
        sG3.texture(new TextureCol(Color.GREEN));
        sG6.texture(new TextureCol(Color.GREEN));
        sG9.texture(new TextureCol(Color.GREEN));
        s0.texture(new TextureCol(Color.WHITE));
        sH.texture(new TextureCol(Color.MAGENTA));
        sM.texture(new TextureCol(Color.BLUE));
        sS.texture(new TextureCol(Color.RED));
        try {
            s0.texture(
                    new TextureImg(
                            new ECBufferedImage(
                                    ImageIO.read(new File("c:\\Emptycanvas\\textures\\troisbandes.jpg")))));
            sH.texture(
                    new TextureImg(
                            new ECBufferedImage(
                                    ImageIO.read(new File("c:\\Emptycanvas\\textures\\moi1.jpg")))));
            sM.texture(
                    new TextureImg(
                            new ECBufferedImage(
                                    ImageIO.read(new File("c:\\Emptycanvas\\textures\\be.manudahmen.empty3.library.tests.spheres.jpg")))));
            sS.texture(
                    new TextureImg(
                            new ECBufferedImage(
                                    ImageIO.read(new File("c:\\Emptycanvas\\textures\\paillettes.jpg")))));

        } catch (Exception ex) {
            s0.texture(new TextureCol(Color.RED));
            sH.texture(new TextureCol(Color.GREEN));
            sM.texture(new TextureCol(Color.BLUE));
            sS.texture(new TextureCol(Color.YELLOW));
            Logger.getLogger(Horloge.class.getName()).log(Level.SEVERE, "Fichiers textures absents", ex);
        }

        for (int i = 0; i < 12; i++) {
            TRISphere sGm = new TRISphere(position(f * i / 12)
                    .mult(80), 6);
            sGm.texture(new TextureCol(Color.BLUE));
            sc.add(sGm);
        }
        sc.add(s0);
        sc.add(sH);
        sc.add(sM);
        sc.add(sS);
        sc.add(sG0);
        sc.add(sG3);
        sc.add(sG6);
        sc.add(sG9);
        droite0 = new SegmentDroite(
                position(f * d.getHours() / 12).mult(60),
                Point3D.O0, new TextureCol(Color.GREEN));
        droite1 = new SegmentDroite(position(f * d.getHours() / 12).mult(60),
                Point3D.O0, new TextureCol(Color.BLUE));
        droite2 = new SegmentDroite(
                position(f * d.getHours() / 12).mult(60),
                Point3D.O0, new TextureCol(Color.RED));
        sc.add(droite0);
        sc.add(droite1);
        sc.add(droite2);

        TubulaireN2<SegmentDroite> segmentDroiteTubulaireN20 = new TubulaireN2<>();
        segmentDroiteTubulaireN20.curve(droite0);
        segmentDroiteTubulaireN20.diam(20);
        sc.add(segmentDroiteTubulaireN20);
        TubulaireN2<SegmentDroite> segmentDroiteTubulaireN21 = new TubulaireN2<>();
        segmentDroiteTubulaireN21.curve(droite1);
        sc.add(segmentDroiteTubulaireN21);
        segmentDroiteTubulaireN20.diam(20);
        TubulaireN2<SegmentDroite> segmentDroiteTubulaireN22 = new TubulaireN2<>();
        segmentDroiteTubulaireN22.curve(droite2);
        sc.add(segmentDroiteTubulaireN22);
        segmentDroiteTubulaireN20.diam(20);

        sc.cameraActive(new Camera(Point3D.Z.mult(-200), Point3D.O0));
    }

    public void time() {
        double f = 2 * Math.PI;
        Date d = new Date();

        sH.setCentre(position(f * d.getHours() / 12).mult(60));
        sM.setCentre(position(f * d.getMinutes() / 60).mult(80));
        sS.setCentre(position(f * d.getSeconds() / 60).mult(100));
        droite0.setOrigine(position(f * d.getHours() / 12).mult(60));
        droite1.setOrigine(position(f * d.getMinutes() / 60).mult(80));
        droite2.setOrigine(position(f * d.getSeconds() / 60).mult(100));
    }

    public Point3D position(double angle) {

        Point3D p0
                = new Point3D(
                -Math.sin(angle),
                Math.cos(angle),
                0
        );

        return p0;
    }

    public void montrer() {
        initTime();


        while (montre) {

            ZBuffer z = ZBufferFactory.instance(
                    this.getWidth(),
                    this.getHeight());
            time();
            z.next();
            z.couleurDeFond(new TextureCol(Color.WHITE));
            z.scene(sc);
            z.draw();

            Image bi = z.image();
            try {
                label.getGraphics().drawImage(bi, 0, 0, this.getWidth(), this.getHeight(), null);
            } catch (Exception ex) {
            }
        }
    }

    /**
     * @param c
     */
    public void update(Configuration<Horloge> c) {
    }

    private static class Configuration<T extends JFrame> {

        public Configuration() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void showAndReturnBack() {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
