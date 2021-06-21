/*
 * Created by JFormDesigner on Sat Jun 19 17:27:32 CEST 2021
 */

package one.empty3.gui;

import net.miginfocom.swing.MigLayout;
import one.empty3.library.*;
import one.empty3.library.core.export.STLExport;
import one.empty3.library.core.nurbs.CourbeParametriquePolynomialeBezier;
import one.empty3.library.core.nurbs.FctXY;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author Manuel Dahmen
 */
public class ModelingInterface extends JFrame {
    private static final int PAINT_POINT = 1;
    private static final int PAINT_RECT = 2;
    private final int RES_Y = 2000;
    private final int RES_X = 2000;
    private Tubulaire4map tubulaire4;
    private Camera camera;
    private BufferedImage image;
    private Color paintColor = Color.WHITE;
    private int drawUtil = 2;
    private boolean runningViewDisplay = false;
    private Point p1;
    private Point p2;
    private Scene scene;


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JMenuBar menuBar3;
    private JSplitPane splitPane1;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JMenuBar menuBar1;
    private JMenuItem menuItem16;
    private JMenuItem menuItem1;
    private JPanel panel3;
    private JScrollPane scrollPane2;
    private JPanel panel1;
    private JMenuBar menuBar2;
    private JMenuItem menuItem2;
    private JMenu menu1;
    private JMenuItem menuItem6;
    private JMenuItem menuItem5;
    private JMenu menu2;
    private JMenuItem menuItem10pc;
    private JMenuItem menuItem20pc;
    private JMenuItem menuItem30pc;
    private JMenuItem menuItem40pc;
    private JMenuItem menuItem50pc;
    private JMenuItem menuItem60pc;
    private JMenuItem menuItem7;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem13;
    private JTextField textField1;
    private JMenuItem menuItem14;
    private JTextField textField2;
    private JMenuItem menuItem15;
    private JPanel panel4;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public ModelingInterface() {
        initComponents();
        init();
    }

    public static void main(String[] args) {
        ModelingInterface modelingInterface = new ModelingInterface();
        modelingInterface.setVisible(true);
    }

    public void init() {

        image = new BufferedImage(RES_X, RES_Y, BufferedImage.TYPE_INT_RGB);
        //initImage();
        tubulaire4 = new Tubulaire4map();
        tubulaire4.declareProperties();
        tubulaire4.getSoulCurve().setElem(new CourbeParametriquePolynomialeBezier());
        tubulaire4.getSoulCurve().getElem().getCoefficients().add(new Point3D(0.25, 0., 10.));
        tubulaire4.getSoulCurve().getElem().getCoefficients().add(new Point3D(0., 0., 2.5));
        tubulaire4.getSoulCurve().getElem().getCoefficients().add(new Point3D(0., 0., -2.5));
        tubulaire4.getSoulCurve().getElem().getCoefficients().add(new Point3D(0., 0.25, -10.));
        tubulaire4.getDiameterFunction().setElem(new FctXY());
        tubulaire4.getDiameterFunction().getElem().setFormulaX("10.0");
        tubulaire4.texture(new ColorTexture(Color.BLUE));
        tubulaire4.setIncrU(0.01);
        tubulaire4.setIncrV(0.01);


        camera = new Camera(Point3D.Y.mult(-80.), Point3D.O0, Point3D.Z);

        Graphics g = image.getGraphics();
        g.setColor(Color.RED);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());


        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void refresh() {
        if (!runningViewDisplay)
            new Thread(() -> {
                runningViewDisplay = true;

                ZBufferImpl zBuffer = new ZBufferImpl(panel3.getWidth(), panel3.getHeight());
                zBuffer.setDisplayType(ZBufferImpl.SURFACE_DISPLAY_POINTS);
                zBuffer.texture(new ColorTexture(Color.WHITE));
                zBuffer.backgroundTexture(new ColorTexture(Color.WHITE));
                scene = new Scene();
                tubulaire4.updateBitmap(image);
                scene.add(tubulaire4);
                scene.cameraActive(camera);
                zBuffer.scene(scene);
                zBuffer.camera(camera);

                zBuffer.idzpp();

                zBuffer.draw();

                ECBufferedImage ecBufferedImage = zBuffer.image2();


                Graphics graphics = panel3.getGraphics();


                graphics.drawImage(
                        ecBufferedImage, 0, 0,
                        panel3.getWidth(), panel3.getHeight(), null);

                graphics = panel4.getGraphics();


                graphics.drawImage(image, 0, 0, panel4.getWidth(), panel4.getHeight(), null);

                runningViewDisplay = false;
            }).start();
    }

    private void menuItemRefresh3DActionPerformed(ActionEvent e) {
        refresh();
    }

    private void menuItemUpdateViewActionPerformed(ActionEvent e) {
        refresh();
    }

    private void menuItemChooseColorActionPerformed(ActionEvent e) {
        JColorChooser colorChooser = new JColorChooser(paintColor);
        colorChooser.setVisible(true);
        if ((paintColor = JColorChooser.showDialog(this, "Choose paint color", paintColor)) != null) {
            menuItem3.setBackground(paintColor);
        }
    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        refresh();
    }

    private void menuItemDrawRectangleActionPerformed(ActionEvent e) {
        drawUtil = PAINT_RECT;
    }

    private void panel4MouseDragged(MouseEvent e) {
        p2 = new Point((int)(e.getLocationOnScreen().getX()-panel4.getLocation().getX()-this.getLocation().getX()),
                (int)(e.getLocationOnScreen().getY()-panel4.getLocation().getY()-this.getLocation().getY()));
        draw(p1, p2);
    }

    private void draw(Point p1, Point p2) {
        Graphics g = image.getGraphics();

        switch (drawUtil) {
            case PAINT_RECT:
                g.setColor(paintColor);
                g.fillRect((int) (p1.getX() / panel3.getWidth() * image.getWidth()), (int) (p1.getY() / panel3.getHeight() * image.getHeight()),
                        (int) (p2.getX() / panel3.getWidth() * image.getWidth()), (int) (p2.getY() / panel3.getHeight() * image.getHeight()));
                System.out.printf("Action: ", "Rect drawn");
                break;
        }
        refresh();
    }

    private void panel4MousePressed(MouseEvent e) {
        p1 = e.getPoint();
    }

    private void panel4MouseClicked(MouseEvent e) {
        p1 = e.getPoint();
    }

    private void panel4MouseReleased(MouseEvent e) {
        draw(p1, p2);
    }

    private void menuItemExportModelActionPerformed(ActionEvent e) {
        File file = new File("sauvegardes/objet" + Math.random() + ".stl");
        try {
            STLExport.save(file, scene, false);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            ImageIO.write(image, "jpg", new File(file.getAbsolutePath() + ".jpg"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        menuBar3 = new JMenuBar();
        splitPane1 = new JSplitPane();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        menuBar1 = new JMenuBar();
        menuItem16 = new JMenuItem();
        menuItem1 = new JMenuItem();
        panel3 = new JPanel();
        scrollPane2 = new JScrollPane();
        panel1 = new JPanel();
        menuBar2 = new JMenuBar();
        menuItem2 = new JMenuItem();
        menu1 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu2 = new JMenu();
        menuItem10pc = new JMenuItem();
        menuItem20pc = new JMenuItem();
        menuItem30pc = new JMenuItem();
        menuItem40pc = new JMenuItem();
        menuItem50pc = new JMenuItem();
        menuItem60pc = new JMenuItem();
        menuItem7 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem13 = new JMenuItem();
        textField1 = new JTextField();
        menuItem14 = new JMenuItem();
        textField2 = new JTextField();
        menuItem15 = new JMenuItem();
        panel4 = new JPanel();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[]"));
        setJMenuBar(menuBar3);

        //======== splitPane1 ========
        {
            splitPane1.setResizeWeight(0.5);
            splitPane1.setOneTouchExpandable(true);

            //======== scrollPane1 ========
            {

                //======== panel2 ========
                {
                    panel2.setLayout(new MigLayout(
                            "fill,hidemode 3",
                            // columns
                            "[fill]" +
                                    "[fill]",
                            // rows
                            "[]" +
                                    "[]" +
                                    "[]"));

                    //======== menuBar1 ========
                    {

                        //---- menuItem16 ----
                        menuItem16.setText("Save model");
                        menuItem16.addActionListener(e -> menuItemExportModelActionPerformed(e));
                        menuBar1.add(menuItem16);

                        //---- menuItem1 ----
                        menuItem1.setText("Refresh");
                        menuItem1.addActionListener(e -> menuItemRefresh3DActionPerformed(e));
                        menuBar1.add(menuItem1);
                    }
                    panel2.add(menuBar1, "cell 0 0 2 1");

                    //======== panel3 ========
                    {
                        panel3.setLayout(new MigLayout(
                                "hidemode 3",
                                // columns
                                "[fill]" +
                                        "[fill]",
                                // rows
                                "[]" +
                                        "[]" +
                                        "[]"));
                    }
                    panel2.add(panel3, "cell 0 1 2 2,dock center");
                }
                scrollPane1.setViewportView(panel2);
            }
            splitPane1.setLeftComponent(scrollPane1);

            //======== scrollPane2 ========
            {

                //======== panel1 ========
                {
                    panel1.setLayout(new MigLayout(
                            "fill,hidemode 3",
                            // columns
                            "[fill]" +
                                    "[fill]",
                            // rows
                            "[]" +
                                    "[]" +
                                    "[]"));

                    //======== menuBar2 ========
                    {

                        //---- menuItem2 ----
                        menuItem2.setText("Update View");
                        menuItem2.setHorizontalAlignment(SwingConstants.LEFT);
                        menuItem2.addActionListener(e -> menuItemUpdateViewActionPerformed(e));
                        menuBar2.add(menuItem2);

                        //======== menu1 ========
                        {
                            menu1.setText("Draw");
                            menu1.setHorizontalAlignment(SwingConstants.LEFT);

                            //---- menuItem6 ----
                            menuItem6.setText("Line");
                            menu1.add(menuItem6);

                            //---- menuItem5 ----
                            menuItem5.setText("Rectangle");
                            menuItem5.addActionListener(e -> menuItemDrawRectangleActionPerformed(e));
                            menu1.add(menuItem5);

                            //======== menu2 ========
                            {
                                menu2.setText("text");

                                //---- menuItem10pc ----
                                menuItem10pc.setText("10%");
                                menu2.add(menuItem10pc);

                                //---- menuItem20pc ----
                                menuItem20pc.setText("20%");
                                menu2.add(menuItem20pc);

                                //---- menuItem30pc ----
                                menuItem30pc.setText("30%");
                                menu2.add(menuItem30pc);

                                //---- menuItem40pc ----
                                menuItem40pc.setText("40%");
                                menu2.add(menuItem40pc);

                                //---- menuItem50pc ----
                                menuItem50pc.setText("50%");
                                menu2.add(menuItem50pc);

                                //---- menuItem60pc ----
                                menuItem60pc.setText("60pc");
                                menu2.add(menuItem60pc);
                            }
                            menu1.add(menu2);

                            //---- menuItem7 ----
                            menuItem7.setText("Text");
                            menu1.add(menuItem7);
                        }
                        menuBar2.add(menu1);

                        //---- menuItem3 ----
                        menuItem3.setText("Color");
                        menuItem3.setHorizontalAlignment(SwingConstants.LEFT);
                        menuItem3.addActionListener(e -> {
                            menuItemChooseColorActionPerformed(e);
                            menuItem3ActionPerformed(e);
                        });
                        menuBar2.add(menuItem3);

                        //======== menu3 ========
                        {
                            menu3.setText("Gradient");
                            menu3.setHorizontalAlignment(SwingConstants.LEFT);

                            //---- menuItem13 ----
                            menuItem13.setText("Radius");
                            menu3.add(menuItem13);

                            //---- textField1 ----
                            textField1.setText("40");
                            menu3.add(textField1);

                            //---- menuItem14 ----
                            menuItem14.setText("Intensity");
                            menu3.add(menuItem14);

                            //---- textField2 ----
                            textField2.setText("20");
                            menu3.add(textField2);

                            //---- menuItem15 ----
                            menuItem15.setText("Apply");
                            menu3.add(menuItem15);
                        }
                        menuBar2.add(menu3);
                    }
                    panel1.add(menuBar2, "cell 0 0 2 1");

                    //======== panel4 ========
                    {
                        panel4.addMouseMotionListener(new MouseMotionAdapter() {
                            @Override
                            public void mouseDragged(MouseEvent e) {
                                panel4MouseDragged(e);
                            }
                        });
                        panel4.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                panel4MouseClicked(e);
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {
                                panel4MousePressed(e);
                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {
                                panel4MouseReleased(e);
                            }
                        });
                        panel4.setLayout(new MigLayout(
                                "hidemode 3",
                                // columns
                                "[fill]" +
                                        "[fill]",
                                // rows
                                "[]" +
                                        "[]" +
                                        "[]"));
                    }
                    panel1.add(panel4, "cell 0 1 2 2,dock center");
                }
                scrollPane2.setViewportView(panel1);
            }
            splitPane1.setRightComponent(scrollPane2);
        }
        contentPane.add(splitPane1, "cell 0 1 2 4,dock center");

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1, "cell 0 5 2 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}