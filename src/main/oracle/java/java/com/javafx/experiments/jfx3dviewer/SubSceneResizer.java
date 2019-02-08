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

import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;
import javafx.scene.SubScene;
import javafx.scene.layout.Pane;

/**
 * Resizable container for a SubScene
 */
public class SubSceneResizer extends Pane {
    private SubScene subScene;
    private final Node controlsPanel;

    public SubSceneResizer(SubScene subScene, Node controlsPanel) {
        this.subScene = subScene;
        this.controlsPanel = controlsPanel;
        setPrefSize(subScene.getWidth(),subScene.getHeight());
        setMinSize(50,50);
        setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        getChildren().addAll(subScene, controlsPanel);
    }

    public SubSceneResizer(ObjectProperty<SubScene> subScene, Node controlsPanel) {
        this.subScene = subScene.get();
        this.controlsPanel = controlsPanel;
        if (this.subScene != null) {
            setPrefSize(this.subScene.getWidth(),this.subScene.getHeight());
            getChildren().add(this.subScene);
        }
        subScene.addListener((o,old,newSubScene) -> {
            this.subScene = newSubScene;
            if (this.subScene != null) {
                setPrefSize(this.subScene.getWidth(),this.subScene.getHeight());
                if (getChildren().size() == 1) {
                    getChildren().add(0,this.subScene);
                } else {
                    getChildren().set(0,this.subScene);
                }
            }
        });
        setMinSize(50,50);
        setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
        getChildren().add(controlsPanel);
    }

    @Override protected void layoutChildren() {
        final double width = getWidth();
        final double height = getHeight();
        if (subScene!=null) {
            subScene.setWidth(width);
            subScene.setHeight(height);
        }
        final int controlsWidth = (int)snapSize(controlsPanel.prefWidth(-1));
        final int controlsHeight = (int)snapSize(controlsPanel.prefHeight(-1));
        controlsPanel.resizeRelocate(width-controlsWidth,0,controlsWidth,controlsHeight);
    }
}
