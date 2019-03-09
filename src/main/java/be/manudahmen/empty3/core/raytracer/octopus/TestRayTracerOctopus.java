/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

package be.manudahmen.empty3.core.raytracer.octopus;

import be.manudahmen.empty3.TextureCol;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.core.raytracer.*;
import be.manudahmen.empty3.core.tribase.TRISphere;
import be.manudahmen.empty3.utils.ConsoleUtils;

import java.awt.*;
import java.io.IOException;

public class TestRayTracerOctopus extends RtRaytracer {
    public static void main(String[] args) {
        RtScene myScene = new RtScene();

        // Notre camera
        RtTargetCamera myCamera = null;
        Point3D myCameraPos = new Point3D(0.0f, 0.0f, -10.0f);    // Position de la camera
        Point3D myCameraLookAt = new Point3D(0.0f, 0.0f, 10.0f);    // Position du point regard�
        Point3D myCameraUpVec = new Point3D(0.0f, 1.0f, 0.0f);    // Vecteur haut de la cam�ra

        // Une sphere
        TRISphere mySphere = null;
        Point3D mySpherePos = new Point3D(0.0f, 0.0f, 9.0f);        // Position de la sphere
        double mySphereRadius = 4f;                // Rayon de la sphere

        // Un plan
        RtPlane myPlane = null;
        Point3D myPlanePos = new Point3D(0.0f, 0.0f, 5.0f);
        Point3D myPlaneNormal = new Point3D(0.0f, 0.0f, 1.0f);

        // Une premiere lumiere (rouge)
        RtPointLight myLight;
        Point3D myLightPos = new Point3D(10.0f, 5.0f, 6.0f);
        RtColor myLightDiffuseColor = new RtColor(1.0f, 1.0f, 0.5f);
        RtColor myLightSpecularColor = new RtColor(1.0f, 1.0f, 0.5f);
        RtColor myLightColor = new RtColor(1.0f, 1.0f, 0.0f);

        // Une deuxieme lumiere (bleue)
        RtPointLight myLight1;
        Point3D myLight1Pos = new Point3D(-10.0f, 5.0f, 6.0f);
        RtColor myLight1DiffuseColor = new RtColor(0.7f, 0.7f, 0.7f);
        RtColor myLight1SpecularColor = new RtColor(0.7f, 0.7f, 0.7f);
        RtColor myLight1Color = new RtColor(1.0f, 1.0f, 1.0f);

        // Deux materiaux
        RtMatiere myMaterial;
        RtMatiere myMaterial1;


        myCamera = new RtParameterCamera(myCameraPos, myCameraLookAt, myCameraUpVec);
        mySphere = new TRISphere(mySpherePos, mySphereRadius);
        myPlane = new RtPlane(myPlanePos, myPlaneNormal);
        myLight = new RtPointLight(myLightPos, myLightDiffuseColor, myLightSpecularColor, myLightColor);
        myLight1 = new RtPointLight(myLight1Pos, myLight1DiffuseColor, myLight1SpecularColor, myLight1Color);
        //myLight.setIntensite(100);
        //myLight1.setIntensite(100);
        myMaterial = new RtMatiere("myMaterial", new RtColor(1.0f, 0.0f, 0.0f), new RtColor(1.0f, 0.0f, 0.0f), new RtColor(1.0f, 0.0f, 0.0f), new RtColor(1.0f, 0.0f, 0.0f), 1.0f, 1.0f);
        myMaterial1 = new RtMatiere("myMaterial1", new RtColor(0.0f, 1.0f, 1.0f), new RtColor(0.7f, 1.0f, 0.7f), new RtColor(0.0f, 1.0f, 1.0f), new RtColor(1.0f, 1.0f, 1.0f), 1.0f, 1.0f);

        // On assigne les materiaux a nos objets
        mySphere.texture(new TextureCol(Color.GREEN));
        myPlane.setMaterial(myMaterial1);

        // On ajoute les
        // elements a notre scene
        myScene.addCamera(myCamera);
        myScene.addLight(myLight);
        myScene.addObject(mySphere);
        myScene.addObject(myPlane);
        myScene.addLight(myLight1);
        myScene.addMaterial(myMaterial);
        myScene.addMaterial(myMaterial1);
        myScene.setActiveCamera(0);
        // On lance le rendu
        try {
            Render(myScene, 1920, 1080, "tests-results/raytracer-octopus" + ConsoleUtils.currentDate());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}