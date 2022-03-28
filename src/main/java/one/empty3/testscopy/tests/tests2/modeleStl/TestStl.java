/*__
 * ect 27-08-17 Copyright.
 */

package one.empty3.testscopy.tests.tests2.modeleStl;

import one.empty3.library.*;
import one.empty3.library.core.lighting.Colors;
import one.empty3.library.core.testing.TestObjetSub;
import one.empty3.library.stl_loader.IncorrectFormatException;
import one.empty3.library.stl_loader.ParsingErrorException;
import one.empty3.library.stl_loader.StlFile;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class TestStl extends TestObjetSub {
    private BufferedReader reader;

    @Override
    public void ginit() {
        super.ginit();


        StlFile file = new StlFile();
        Scene load = new Scene();
        try {
            File file1 = new File("samples/stl/another_nude_girl-ascii.stl");
            load = file.load(file1.getAbsolutePath());
        } catch (IncorrectFormatException | IOException | ParsingErrorException e) {
            e.printStackTrace();
        }



        scene().add(load.getObjets().getElem(0));

        System.out.println("scene objets= "+load.getObjets().data1d.size());

        TextureCol colorTexture0 = new TextureCol(Colors.random());
        for (int i = 0; i < ((RepresentableConteneur) scene().getObjets().getElem(0)).getListRepresentable().size(); i++) {
            TRI t = (TRI)((RepresentableConteneur) scene().getObjets().getElem(0)).getListRepresentable().get(i);
            t.texture(colorTexture0);
        }
        load.getObjets().getElem(0).texture(colorTexture0);
        //System.out.println(((RepresentableConteneur) scene().getObjets().getElem(0)).getListRepresentable().size());

        Sphere s = new Sphere(new Axe(new Point3D(0., -1., 0.),
                new Point3D(0., 1., 0.)), 10.0);
        s.texture(new TextureCol(Colors.random()));

        scene().add(s);

        scene().cameraActive(new Camera());

        Camera camera = new Camera(Point3D.Z.mult(-50), Point3D.O0, Point3D.Y);

        //camera.calculerMatrice(Point3D.Y);

        scene().cameraActive(camera);
    }


    public static void main(String[] args) {
        TestStl stl = new TestStl();
        stl.setMaxFrames(1);
        stl.setResolution(1000, 1000);
        new Thread(stl).start();
    }

}
