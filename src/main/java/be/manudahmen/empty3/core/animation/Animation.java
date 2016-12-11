/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.core.animation;

import be.manudahmen.empty3.Scene;
import be.manudahmen.empty3.ZBuffer;
import be.manudahmen.empty3.ZBufferImpl;
import be.manudahmen.empty3.core.ECDim;

import java.util.ArrayList;

/**
 * @author Manuel
 */
public class Animation {

    protected AnimationTime time;

    protected ECDim resolution;

    protected Scene scene;
    ZBuffer z;
    private ArrayList<AnimationMouvements> moves = new ArrayList<AnimationMouvements>();

    public Animation(Scene s, ECDim dim) {
        this.resolution = dim;
        this.scene = s;
        z = new ZBufferImpl(resolution.getDimx(), resolution.getDimy());
    }

    public void addMove(AnimationMouvements m) {
        moves.add(m);
    }

    public void generate() {
        AnimationGenerator gen = new AnimationGenerator(this);
        gen.start();
    }

    public ArrayList<AnimationMouvements> getMoves() {
        return moves;
    }

    public ECDim getResolution() {
        return resolution;
    }

    public Scene getScene() {
        return scene;
    }

    public AnimationTime getTime() {
        return time;
    }

    public void setDuration(double duration) {
        time = new AnimationTime(duration);
    }
}
