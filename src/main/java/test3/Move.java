package test3;

import one.empty3.library.Point3D;
import one.empty3.library.Representable;
import one.empty3.library.RepresentableConteneur;
import one.empty3.tests.Human;

import java.util.HashMap;
import java.util.List;

public class Move {

    private String moveName;
    private Representable representable;
    private double time;
    private Point3D[] positions;

    /***
     *
     * @param moveName
     * @param representable
     * @param property
     * @param time
     * @param positions
     */
    public void addMove(String moveName, Representable representable, String property, double time, Point3D... positions) {
        this.moveName = moveName;
        this.representable = representable;
        this.time = time;
        this.positions = positions;
    }
}
class MoveCollection {
    Human human;
    HashMap<String, List<Move>> moves;
    public double move(double dt) {
        return 0.0;
    }
}