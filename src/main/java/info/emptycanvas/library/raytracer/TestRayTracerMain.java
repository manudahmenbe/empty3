package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Cube;
import info.emptycanvas.library.object.Point3D;

import java.awt.*;
import java.io.IOException;

public class TestRayTracerMain extends Raytracer {
    public static void main(String[] args) {
        CScene myScene = new CScene();
        CScene myScene1 = new CScene();

        // Notre cam�ra
        CTargetCamera myCamera = null;
        Point3D myCameraPos = new Point3D(0.0f, 3.0f, -15f);    // Position de la camera
        Point3D myCameraLookAt = new Point3D(0.0f, 0.0f, 10.0f);    // Position du point regard�
        Point3D myCameraUpVec = new Point3D(0.0f, 1.0f, 0.0f);    // Vecteur haut de la cam�ra

        // Une sph�re
        CSphere mySphere = null;
        Point3D mySpherePos = new Point3D(0.0f, 0.0f, 10.0f);        // Position de la sph�re
        float mySphereRadius = 5.0f;                // Rayon de la sph�re

        // Un plan
        CPlane myPlane = null;
        Point3D myPlanePos = new Point3D(0.0f, 0.0f, 10.0f);
        Point3D myPlaneNormal = new Point3D(0.0f, 0.0f, 0.1f);

        // Une premi�re lumi�re (rouge)
        CPointLight myLight;
        Point3D myLightPos = new Point3D(3.0f, 3.0f, 0.0f);
        Color myLightDiffuseColor = new Color(1.0f, 0.0f, 0.0f);
        Color myLightSpecularColor = new Color(1.0f, 0.0f, 0.0f);
        Color myLightColor = new Color(1.0f, 0.0f, 0.0f);

        // Une deuxi�me lumi�re (bleue)
        CPointLight myLight1;
        Point3D myLight1Pos = new Point3D(-3.0f, 3.0f, 0.0f);
        Color myLight1DiffuseColor = new Color(0.0f, 0.0f, 1.0f);
        Color myLight1SpecularColor = new Color(0.0f, 0.0f, 1.0f);
        Color myLight1Color = new Color(0.0f, 0.0f, 1.0f);

        // Deux materiaux
        Matiere myMaterial;
        Matiere myMaterial1;


        myCamera = new CTargetCamera(myCameraPos, myCameraLookAt, myCameraUpVec);
        assert (myCamera != null);
        mySphere = new CSphere(mySpherePos, mySphereRadius);
        assert (mySphere != null);
        myPlane = new CPlane(myPlanePos, myPlaneNormal);
        assert (myPlane != null);
        myLight = new CPointLight(myLightPos, myLightDiffuseColor, myLightSpecularColor, myLightColor);
        assert (myLight != null);
        myLight1 = new CPointLight(myLight1Pos, myLight1DiffuseColor, myLight1SpecularColor, myLight1Color);
        assert (myLight1 != null);
        myMaterial = new Matiere("myMaterial", new Color(1.0f, 1.0f, 0.0f), new Color(1.0f, 1.0f, 1.0f), new Color(0.0f, 0.0f, 0.0f), new Color(1.0f, 1.0f, 0.0f), 1.0f, 1.0f);
        assert (myMaterial != null);
        myMaterial1 = new Matiere("myMaterial1", new Color(0.105882354f, 0.14509805f, 1.0f), new Color(0.7f, 0.7f, 0.7f), new Color(0.0f, 0.0f, 0.0f), new Color(0.11372549f, 0.12941177f, 1.0f), 1.0f, 1.0f);
        assert (myMaterial1 != null);

        // On assigne les materiaux � nos objets
        mySphere.setMaterial(myMaterial);
        myPlane.setMaterial(myMaterial1);

        // On ajoute les �l�ments � notre sc�ne
        myScene.addCamera(myCamera);
        myScene.addObject(mySphere);
        myScene.addObject(myPlane);
        myScene.addLight(myLight);
        myScene.addLight(myLight1);
        myScene.addMaterial(myMaterial);
        myScene.addMaterial(myMaterial1);
        myScene.setActiveCamera(0);

        myLight1 = new CPointLight(myLight1Pos, myLight1DiffuseColor, myLight1SpecularColor, myLight1Color);
        assert (myLight1 != null);

        Cube myCube = new Cube(new ColorTexture(Color.RED), 5, Point3D Point3D.O0);

        myScene.addObject(myCube);

        // On lance le rendu
        try {
            Render(myScene, 1920, 1080, "test plan sphere");
            System.out.println("test plan sphere" + "Rendu effectué");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Render(myScene1, 1920, 1080, "test cube");
            System.out.println("Chapitre2" + "Rendu effectué");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
