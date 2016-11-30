/*

 Vous êtes libre de :

 */
package be.manudahmen.emptycanvas.library.empty3.library.animation;

import be.manudahmen.emptycanvas.library.empty3.library.ECDim;
import be.manudahmen.emptycanvas.library.empty3.library.object.Scene;
import be.manudahmen.emptycanvas.library.empty3.library.object.ZBuffer;
import be.manudahmen.emptycanvas.library.empty3.library.object.ZBufferImpl;

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
