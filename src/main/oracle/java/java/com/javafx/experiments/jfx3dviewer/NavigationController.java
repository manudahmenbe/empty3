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

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.ScrollBar;

/**
 * Controller class for settings panel
 */
public class NavigationController implements Initializable {
//    public FourWayNavControl eyeNav;
    public ScrollBar zoomBar;
//    public FourWayNavControl camNav;
    private ContentModel contentModel = Jfx3dViewerApp.getContentModel();

    @Override public void initialize(URL location, ResourceBundle resources) {
        zoomBar.setMin(-100);
        zoomBar.setMax(0);
        zoomBar.setValue(contentModel.getCameraPosition().getZ());
        zoomBar.setVisibleAmount(5);
        contentModel.getCameraPosition().zProperty().bindBidirectional(zoomBar.valueProperty());
//        eyeNav.setListener(new FourWayNavControl.FourWayListener() {
//            @Override public void navigateStep(Side direction, double amount) {
//                switch (direction) {
//                    case TOP:
//                        contentModel.getCameraLookXRotate().setAngle(contentModel.getCameraLookXRotate().getAngle()+amount);
//                        break;
//                    case BOTTOM:
//                        contentModel.getCameraLookXRotate().setAngle(contentModel.getCameraLookXRotate().getAngle()-amount);
//                        break;
//                    case LEFT:
//                        contentModel.getCameraLookZRotate().setAngle(contentModel.getCameraLookZRotate().getAngle()-amount);
//                        break;
//                    case RIGHT:
//                        contentModel.getCameraLookZRotate().setAngle(contentModel.getCameraLookZRotate().getAngle()+amount);
//                        break;
//                }
//            }
//        });
//        camNav.setListener(new FourWayNavControl.FourWayListener() {
//            @Override public void navigateStep(Side direction, double amount) {
//                switch (direction) {
//                    case TOP:
//                        contentModel.getCameraXRotate().setAngle(contentModel.getCameraXRotate().getAngle()-amount);
//                        break;
//                    case BOTTOM:
//                        contentModel.getCameraXRotate().setAngle(contentModel.getCameraXRotate().getAngle()+amount);
//                        break;
//                    case LEFT:
//                        contentModel.getCameraYRotate().setAngle(contentModel.getCameraYRotate().getAngle()+amount);
//                        break;
//                    case RIGHT:
//                        contentModel.getCameraYRotate().setAngle(contentModel.getCameraYRotate().getAngle()-amount);
//                        break;
//                }
//            }
//        });
    }
}
