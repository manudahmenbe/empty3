package be.manudahmen.empty3.library.raytracer;

import be.manudahmen.empty3.library.object.Point3D;

import java.io.IOException;

public class TestRayTracerMain extends RtRaytracer {
    public static void main(String[] args) {
        RtScene myScene = new RtScene();

        // Notre camera
        RtTargetCamera myCamera = null;
        Point3D myCameraPos = new Point3D(0.0f, 0.0f, -15.0f);    // Position de la camera
        Point3D myCameraLookAt = new Point3D(0.0f, 0.0f, 10.0f);    // Position du point regard�
        Point3D myCameraUpVec = new Point3D(0.0f, 1.0f, 0.0f);    // Vecteur haut de la cam�ra

        // Une sphere
        RtSphere mySphere = null;
        Point3D mySpherePos = new Point3D(0.0f, 0.0f, 10.0f);        // Position de la sph�re
        float mySphereRadius = 2.0f;                // Rayon de la sph�re

        // Un plan
        RtPlane myPlane = null;
        Point3D myPlanePos = new Point3D(0.0f, 0.0f, 10.0f);
        Point3D myPlaneNormal = new Point3D(0.0f, 0.0f, 1.0f);

        // Une premiere lumiere (rouge)
        RtPointLight myLight;
        Point3D myLightPos = new Point3D(3.0f, 3.0f, 0.0f);
        RtColor myLightDiffuseColor = new RtColor(1.0f, 0.0f, 0.0f);
        RtColor myLightSpecularColor = new RtColor(1.0f, 0.0f, 0.0f);
        RtColor myLightColor = new RtColor(1.0f, 0.0f, 0.0f);

        // Une deuxieme lumiere (bleue)
        RtPointLight myLight1;
        Point3D myLight1Pos = new Point3D(-3.0f, 3.0f, 0.0f);
        RtColor myLight1DiffuseColor = new RtColor(0.0f, 0.0f, 1.0f);
        RtColor myLight1SpecularColor = new RtColor(0.0f, 0.0f, 1.0f);
        RtColor myLight1Color = new RtColor(0.0f, 0.0f, 1.0f);

        // Deux materiaux
        RtMatiere myMaterial;
        RtMatiere myMaterial1;


        myCamera = new RtTargetCamera(myCameraPos, myCameraLookAt, myCameraUpVec);
        assert (myCamera != null);
        mySphere = new RtSphere(mySpherePos, mySphereRadius);
        assert (mySphere != null);
        myPlane = new RtPlane(myPlanePos, myPlaneNormal);
        assert (myPlane != null);
        myLight = new RtPointLight(myLightPos, myLightDiffuseColor, myLightSpecularColor, myLightColor);
        assert (myLight != null);
        myLight1 = new RtPointLight(myLight1Pos, myLight1DiffuseColor, myLight1SpecularColor, myLight1Color);
        assert (myLight1 != null);
        myMaterial = new RtMatiere("myMaterial", new RtColor(1.0f, 1.0f, 0.0f), new RtColor(1.0f, 1.0f, 1.0f), new RtColor(0.0f, 0.0f, 0.0f), new RtColor(1.0f, 1.0f, 0.0f), 1.0f, 1.0f);
        assert (myMaterial != null);
        myMaterial1 = new RtMatiere("myMaterial1", new RtColor(1.0f, 1.0f, 0.0f), new RtColor(0.7f, 0.7f, 0.7f), new RtColor(0.0f, 0.0f, 0.0f), new RtColor(1.0f, 1.0f, 0.0f), 1.0f, 1.0f);
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
            Render(myScene, 1920, 1080, "Chapitre2-" + Math.random());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return;
    }

}