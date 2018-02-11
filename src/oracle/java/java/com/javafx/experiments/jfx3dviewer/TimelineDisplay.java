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

import javafx.animation.Timeline;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

/**
 * Visual display for timeline play head and length
 */
public class TimelineDisplay extends Region {
    private SimpleDoubleProperty currentTimeAsPercentage = new SimpleDoubleProperty(0) {
        @Override protected void invalidated() {
            requestLayout();
        }
    };
    private final SimpleObjectProperty<Timeline> timeline = new SimpleObjectProperty<Timeline>() {
        private Timeline old;
        @Override protected void invalidated() {
            final Timeline t = get();
            if (old != null) {
                currentTimeAsPercentage.unbind();
                end.textProperty().unbind();
            }
            if (t == null) {
                setVisible(false);
            } else {
                setVisible(true);
                currentTimeAsPercentage.bind(
                        new DoubleBinding() {
                            { bind(t.currentTimeProperty(), t.cycleDurationProperty()); }

                            @Override protected double computeValue() {
                                return t.getCurrentTime().toMillis() / t.getCycleDuration().toMillis();
                            }
                        });
                end.textProperty().bind(
                        new StringBinding() {
                            { bind(t.cycleDurationProperty()); }

                            @Override protected String computeValue() {
                                return String.format("%.2fs", t.getCycleDuration().toSeconds());
                            }
                        });
                current.textProperty().bind(
                        new StringBinding() {
                            { bind(t.currentTimeProperty()); }

                            @Override protected String computeValue() {
                                return String.format("%.2fs", t.getCurrentTime().toSeconds());
                            }
                        });
            }
            old = t;
        }
    };
    public Timeline getTimeline() { return timeline.get(); }
    public SimpleObjectProperty<Timeline> timelineProperty() { return timeline; }
    public void setTimeline(Timeline timeline) { this.timeline.set(timeline); }

    private final Region background = new Region();
    private final Region bar = new Region();
    private final Region progress = new Region();
    private final Text start = new Text("0s");
    private final Text end = new Text();
    private final Text current = new Text();

    public TimelineDisplay() {
        getStyleClass().add("timeline-display");
        background.getStyleClass().add("background");
        background.setCache(true); // cache so we don't have to render shadow every frame
        bar.getStyleClass().add("bar");
        progress.getStyleClass().add("progress");
        getChildren().addAll(background,start,current,end,bar,progress);
    }

    @Override protected double computePrefWidth(double height) {
        return 200;
    }

    @Override protected double computePrefHeight(double width) {
        return 24;
    }

    @Override protected void layoutChildren() {
        final double w = getWidth() - snappedLeftInset() - snappedRightInset();
        background.resizeRelocate(0,0,getWidth(),getHeight());
        bar.resizeRelocate(snappedLeftInset(),snappedTopInset(),w,6);
        progress.resizeRelocate(snappedLeftInset(),snappedTopInset(),w*currentTimeAsPercentage.get(),6);
        start.setLayoutX(snappedLeftInset());
        start.setLayoutY(getHeight() - snappedBottomInset());
        current.setLayoutX((int)((getWidth() - current.getLayoutBounds().getWidth())/2d));
        current.setLayoutY(getHeight() - snappedBottomInset());
        end.setLayoutX(getWidth() - snappedRightInset() - end.getLayoutBounds().getWidth());
        end.setLayoutY(getHeight() - snappedBottomInset());
    }
}
