package one.empty3.tests;

import one.empty3.library.Point3D;
import one.empty3.library.Representable;
import one.empty3.library.RepresentableConteneur;
import one.empty3.tests.Human;

import java.util.HashMap;
import java.util.List;

public class Move {

    private final double time2;
    private final Object moved;
    private double time1;
    private String moveName;
    private Representable representable;
    private double time;
    private Point3D[] positions;
    private String property;

    /***
     *
     * @param moveName
     * @param representable
     * @param property
     * @param time1
     * @param time2
     * @param moved
     */
    public Move(String moveName, Representable representable, String property, double time1, double time2,
                Object moved) {
        this.moveName = moveName;
        this.representable = representable;
        this.property = property;
        this.time1 = time1;
        this.time2 = time2;
        this.moved = moved;
    }

    public String getProperty() {
        return property;
    }
}