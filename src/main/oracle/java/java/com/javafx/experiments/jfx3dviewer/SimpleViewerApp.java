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
package com.javafx.experiments.jfx3dviewer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import com.javafx.experiments.importers.Importer3D;

/**
 * JavaFX 3D Viewer Application
 */
public class SimpleViewerApp extends Application {
    private final Group root3D = new Group();
    private final PerspectiveCamera camera = new PerspectiveCamera(true);
    private final Rotate cameraXRotate = new Rotate(-20,0,0,0,Rotate.X_AXIS);
    private final Rotate cameraYRotate = new Rotate(-20,0,0,0,Rotate.Y_AXIS);
    private final Rotate cameraLookXRotate = new Rotate(0,0,0,0,Rotate.X_AXIS);
    private final Rotate cameraLookZRotate = new Rotate(0,0,0,0,Rotate.Z_AXIS);
    private final Translate cameraPosition = new Translate(0,0,-7);
    private AutoScalingGroup autoScalingGroup = new AutoScalingGroup(2);

    @Override public void start(Stage stage) throws Exception {
        List<String> args = getParameters().getRaw();
        final Scene scene = new Scene(root3D,1920,1080,true);
        scene.setFill(Color.TRANSPARENT);
        stage.initStyle(StageStyle.TRANSPARENT);

        // CAMERA
        camera.getTransforms().addAll(
                cameraXRotate,
                cameraYRotate,
                cameraPosition,
                cameraLookXRotate,
                cameraLookZRotate);
        camera.setNearClip(0.1);
        camera.setFarClip(100);
        scene.setCamera(camera);
        root3D.getChildren().addAll(camera, autoScalingGroup);

        // LOAD DROP HERE MODEL
        try {
            Node content;
            if (args.isEmpty()) {
                content = Importer3D.load(ContentModel.class.getResource("drop-here.obj").toExternalForm());
            } else {
                content = Importer3D.load(new File(args.get(0)).toURI().toURL().toExternalForm());
            }
            autoScalingGroup.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(cameraYRotate.angleProperty(),0)),
                new KeyFrame(Duration.seconds(4), new KeyValue(cameraYRotate.angleProperty(),360))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        stage.setScene(scene);
        stage.show();

        // MEASURE FPS
        //TODO: RT-40270 - Public PerformanceTracker support should be added
//        Timeline fpsTimeline = new Timeline(new KeyFrame(Duration.seconds(2), t ->
//                System.out.println("fps = " + PerformanceTracker.getSceneTracker(scene).getInstantFPS())));
//        fpsTimeline.setCycleCount(Timeline.INDEFINITE);
//        fpsTimeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
