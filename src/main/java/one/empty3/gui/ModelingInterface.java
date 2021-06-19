/*
 * Created by JFormDesigner on Sat Jun 19 17:27:32 CEST 2021
 */

package one.empty3.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import net.miginfocom.swing.*;
import one.empty3.library.*;
import one.empty3.library.core.lighting.Colors;
import one.empty3.library.core.nurbs.CourbeParametriquePolynomialeBezier;
import one.empty3.library.core.nurbs.FctXY;
import one.empty3.library.core.tribase.Tubulaire3;

/**
 * @author Manuel Dahmen
 */
public class ModelingInterface extends JFrame {
    private static final int PAINT_POINT = 1;
    private final Tubulaire4map tubulaire4;
    private final int RES_Y = 2000;
    private final int RES_X = 2000;
    private Camera camera;
    private BufferedImage image;
    private Color paintColor = Color.WHITE;
    private int drawUtil;

    public ModelingInterface() {
        initComponents();

        image = new BufferedImage(RES_X, RES_Y, BufferedImage.TYPE_INT_RGB);
        initImage();
        tubulaire4 = new Tubulaire4map();
        tubulaire4.getSoulCurve().setElem(new CourbeParametriquePolynomialeBezier());
        tubulaire4.getSoulCurve().getElem().getCoefficients().add(new Point3D(0., 0., 0.));
        tubulaire4.getSoulCurve().getElem().getCoefficients().add(new Point3D(0., 0., 10.));
        tubulaire4.getDiameterFunction().getElem().setFormulaX("10.0");

        tubulaire4.texture(new ColorTexture(Colors.random()));



        camera = new Camera(Point3D.Y.mult(-40.), Point3D.O0);
        camera = new Camera(new Point3D(-40.0, 1.0, 1.0), new Point3D(0., 0.0, 0.0), new Point3D(0.0, 0.0, 1.0));

    }

    private void menuItemRefresh3DActionPerformed(ActionEvent e) {
        refresh();
    }
    public void refresh() {
        ZBufferImpl zBuffer = new ZBufferImpl(panel3.getWidth(), panel3.getHeight());
        Scene scene = new Scene();
        scene.add(tubulaire4);
        scene.cameraActive(camera);
        zBuffer.scene(scene);
        zBuffer.camera(camera);

        ECBufferedImage ecBufferedImage = zBuffer.image2();

        tubulaire4.updateBitmap(image);


        Graphics graphics = panel3.getGraphics();



        graphics.drawImage(
                ecBufferedImage, 0, 0,
                panel3.getWidth(), panel3.getHeight(), null);

        graphics = panel4.getGraphics();


        graphics.drawImage(image, 0, 0, panel4.getWidth(), panel4.getHeight(), null);

    }

    private void menuItemUpdateViewActionPerformed(ActionEvent e) {
        refresh();
    }
    public void initImage() {
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    }
    private BufferedImage getImage() {
        return image;
    }

    private void menuItemChooseColorActionPerformed(ActionEvent e) {
        JColorChooser jColorChooser = new JColorChooser(paintColor);
        jColorChooser.setVisible(true);
        Color color = jColorChooser.getColor();

        if(color!=null)
            this.paintColor = color;
    }

    private void menuItemDrawActionPerformed(ActionEvent e) {
        this.drawUtil = PAINT_POINT;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        menuBar3 = new JMenuBar();
        splitPane1 = new JSplitPane();
        scrollPane1 = new JScrollPane();
        panel2 = new JPanel();
        menuBar1 = new JMenuBar();
        menuItem1 = new JMenuItem();
        panel3 = new JPanel();
        scrollPane2 = new JScrollPane();
        panel1 = new JPanel();
        menuBar2 = new JMenuBar();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
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
                        menuItem2.addActionListener(e -> menuItemUpdateViewActionPerformed(e));
                        menuBar2.add(menuItem2);

                        //---- menuItem3 ----
                        menuItem3.setText("Color");
                        menuItem3.addActionListener(e -> menuItemChooseColorActionPerformed(e));
                        menuBar2.add(menuItem3);

                        //---- menuItem4 ----
                        menuItem4.setText("Draw");
                        menuItem4.addActionListener(e -> menuItemDrawActionPerformed(e));
                        menuBar2.add(menuItem4);
                    }
                    panel1.add(menuBar2, "cell 0 0");

                    //======== panel4 ========
                    {
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JMenuBar menuBar3;
    private JSplitPane splitPane1;
    private JScrollPane scrollPane1;
    private JPanel panel2;
    private JMenuBar menuBar1;
    private JMenuItem menuItem1;
    private JPanel panel3;
    private JScrollPane scrollPane2;
    private JPanel panel1;
    private JMenuBar menuBar2;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JPanel panel4;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public static void main(String [] args) {
        ModelingInterface modelingInterface = new ModelingInterface();
        modelingInterface.setVisible(true);
    }
}
