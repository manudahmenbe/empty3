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
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX 3D Viewer Application
 */
public class Jfx3dViewerApp extends Application {
    public static final String FILE_URL_PROPERTY = "fileUrl";
    private static ContentModel contentModel;
    private SessionManager sessionManager;

    public static ContentModel getContentModel() {
        return contentModel;
    }

    @Override public void start(Stage stage) throws Exception {
        sessionManager = SessionManager.createSessionManager("Jfx3dViewerApp");
        sessionManager.loadSession();

        List<String> args = getParameters().getRaw();
        if (!args.isEmpty()) {
            sessionManager.getProperties().setProperty(FILE_URL_PROPERTY,
                    new File(args.get(0)).toURI().toURL().toString());
        }
        contentModel = new ContentModel();
        Scene scene = new Scene(
                FXMLLoader.<Parent>load(Jfx3dViewerApp.class.getResource("main.fxml")),
                1024,600);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> sessionManager.saveSession());

//        org.scenicview.ScenicView.show(contentModel.getSubScene().getRoot());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
