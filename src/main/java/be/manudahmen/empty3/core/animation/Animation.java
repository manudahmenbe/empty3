package be.manudahmen.empty3.core.animation;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Scene;
import be.manudahmen.empty3.ZBuffer;
import be.manudahmen.empty3.ZBufferImpl;
import be.manudahmen.empty3.core.ECDim;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Manuel
 */
public class Animation {
    protected List<Point3D> points = new ArrayList<>();
    protected List<AnimationTime> time = new ArrayList<>();

    protected ECDim resolution;

    protected Scene scene;
    ZBuffer z;
    private ArrayList<AnimationMouvements> moves = new ArrayList<AnimationMouvements>();
    private double duration;
    private int currentTimeNo;

    public Animation(Scene s, ECDim dim) {
        this.resolution = dim;
        this.scene = s;
        z = new ZBufferImpl(resolution.getDimx(), resolution.getDimy());
    }

    public void registerPoint3D(Point3D p) {
        this.points.add(p);
    }

    public void generate() {
        AnimationGenerator gen = new AnimationGenerator(this);
        gen.start();
    }

    public ECDim getResolution() {
        return resolution;
    }

    public Scene getScene() {
        return scene;
    }

    public List<AnimationTime> getTime() {
        return time;
    }

    public AnimationTime getCurrentTime() {
        return time.get(currentTimeNo);
    }

    public void update(int numberOfFrames) {
        for (Point3D point : points) {
            time.forEach(new Consumer<AnimationTime>() {
                @Override
                public void accept(AnimationTime animationTime) {
                    double t = (animationTime.getTimeCurrentInAnimation() + numberOfFrames * animationTime.getFps()) / duration;

                    point.changeTo(point.getTrajectory().calculerPoint3D(t));

                }
            });
        }
    }

    public List<Point3D> getPoints() {
        return points;
    }

    public void setPoints(List<Point3D> points) {
        this.points = points;
    }


    public void setResolution(ECDim resolution) {
        this.resolution = resolution;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public ZBuffer getZ() {
        return z;
    }

    public void setZ(ZBuffer z) {
        this.z = z;
    }

    public ArrayList<AnimationMouvements> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<AnimationMouvements> moves) {
        this.moves = moves;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }


}
