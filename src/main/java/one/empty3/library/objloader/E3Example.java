package one.empty3.library.objloader;

import one.empty3.apps.pad.DarkFortressGUI;
import one.empty3.apps.pad.EcDrawer;
import one.empty3.library.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by manue on 02-06-19.
 */
public class E3Example extends EcDrawer {
    private E3Model chairModel;
    private Scene s;

    public E3Example(DarkFortressGUI darkFortress) {
        super(darkFortress);
        if(!loadModels())
            System.exit(1);

    }

    @Override
    public void dessiner() {
        Graphics g = component.getGraphics();

        //z.couleurDeFond(new TColor(Color.BLACK));
        if (g != null && component.getWidth() > 0 && component.getHeight() > 0) {

            s = new Scene();
            z.scene(s);
            if(chairModel!=null) {
                s.add(chairModel);
                s.cameraActive(new Camera
                        (Point3D.Z.mult(100), Point3D.Z.mult(0)));
                System.out.println("ok");
            }
            else return;
            Camera camera = new Camera(new Point3D(Point3D.Z.mult(100)),
                    Point3D.O0);
            camera.calculerMatrice(Point3D.Y);
            s.cameraActive(camera);
            try {
                z.draw(s);
            } catch (Exception ex) {
                System.err.println("Ex");
            }
            ECBufferedImage ri = z.image();

            g.drawImage(ri, 0, 0, component.getWidth(), component.getHeight(), null);

            z.next();
        }

    }


    private Boolean loadModels() {
        chairModel = ModelLoaderOBJ.LoadModelE3("resources/models/c.obj",
                "resources/models/c.mtl");
        if (chairModel == null) {
            System.err.print("Model not loaded");
            return false;
        }
        //System.out.println(chairModel.toString());
        return true;
    }

    public static void main(String[] args) {
        DarkFortressGUI darkFortressGUI = new DarkFortressGUI(E3Example.class);
        darkFortressGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        darkFortressGUI.setVisible(true);
        new E3Example(darkFortressGUI);


    }
}
