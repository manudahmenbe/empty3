package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Point3D;

import java.io.IOException;

public class TestRayTracerMain extends Raytracer {
    public static void main(String[] args) {
        CScene myScene = new CScene();

        // Notre camera
        CTargetCamera myCamera = null;
        Point3D myCameraPos = new Point3D(0.0f, 0.0f, -15.0f);    // Position de la camera
        Point3D myCameraLookAt = new Point3D(0.0f, 0.0f, 10.0f);    // Position du point regard�
        Point3D myCameraUpVec = new Point3D(0.0f, 1.0f, 0.0f);    // Vecteur haut de la cam�ra

        // Une sphere
        CSphere mySphere = null;
        Point3D mySpherePos = new Point3D(0.0f, 0.0f, 10.0f);        // Position de la sph�re
        float mySphereRadius = 5.0f;                // Rayon de la sph�re

        // Un plan
        CPlane myPlane = null;
        Point3D myPlanePos = new Point3D(0.0f, 0.0f, 10.0f);
        Point3D myPlaneNormal = new Point3D(0.0f, 0.0f, 1.0f);

        // Une premiere lumiere (rouge)
        CPointLight myLight;
        Point3D myLightPos = new Point3D(3.0f, 3.0f, 0.0f);
        CColor myLightDiffuseColor = new CColor(1.0f, 0.0f, 0.0f);
        CColor myLightSpecularColor = new CColor(1.0f, 0.0f, 0.0f);
        CColor myLightColor = new CColor(1.0f, 0.0f, 0.0f);

        // Une deuxieme lumiere (bleue)
        CPointLight myLight1;
        Point3D myLight1Pos = new Point3D(-3.0f, 3.0f, 0.0f);
        CColor myLight1DiffuseColor = new CColor(0.0f, 0.0f, 1.0f);
        CColor myLight1SpecularColor = new CColor(0.0f, 0.0f, 1.0f);
        CColor myLight1Color = new CColor(0.0f, 0.0f, 1.0f);

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
        myMaterial = new Matiere("myMaterial", new CColor(1.0f, 1.0f, 0.0f), new CColor(1.0f, 1.0f, 1.0f), new CColor(0.0f, 0.0f, 0.0f), new CColor(1.0f, 1.0f, 0.0f), 1.0f, 1.0f);
        assert (myMaterial != null);
        myMaterial1 = new Matiere("myMaterial1", new CColor(1.0f, 1.0f, 0.0f), new CColor(0.7f, 0.7f, 0.7f), new CColor(0.0f, 0.0f, 0.0f), new CColor(1.0f, 1.0f, 0.0f), 1.0f, 1.0f);
        assert (myMaterial1 != null);

        // On assigne les materiaux a nos objets
        mySphere.setMaterial(myMaterial);
        myPlane.setMaterial(myMaterial1);

        // On ajoute les
        // elements a notre scene
        myScene.addCamera(myCamera);
        myScene.addObject(mySphere);
        myScene.addObject(myPlane);
        myScene.addLight(myLight);
        myScene.addLight(myLight1);
        myScene.addMaterial(myMaterial);
        myScene.setActiveCamera(0);
        // On lance le rendu
        try {
            Render(myScene, 1920, 1080, "Chapitre2");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return;
    }

}