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
package one.empty3.library.core.nurbs;

import one.empty3.library.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Manuel Dahmen
 */

public class BSpline extends ParametricCurve {

    private ArrayList<Point3D> controls = new ArrayList<Point3D>();
    private ArrayList<Double> T = new ArrayList<>();
    private int degree = 1;
    private Color color;

    public BSpline() {

        add(new Point3D(20.0, 10d, 0d));
        add(new Point3D(20d, 20d, 0d));
        add(new Point3D(10.0, 20d, 0d));
        add(new Point3D(10d, 10d, 0d));
        add(new Point3D(20d, 10d, 0d));
    }

    public void add1()

    {
        T.clear();
        for (int i = 0; i < controls.size(); i++)
            T.add(1.0);

    }

    public void add(Point3D point) {
        controls.add(point);
        T.clear();

        //T.add(0.0);
        int size = (controls.size() + degree * 2 + 1);
        double incr = 1.0/size;
        for (double i = incr; i < incr*size; i += incr) {
            for (int j = 0; j < 1; j++)
                T.add(i);
        }
        T.add(0.0);
    }

    public double boor(double t, int i, int d) {
        if (d <= 0) {
            if (i >= 0 && i < T.size())
                return t < get(i + 1) && t > get(i) ? 1.0 : 0.0;
            else
                return 0.0;
        }
        return avoidNaN((t - get(i)), get(i + d) - t)*avoidNaN(boor(t, i, d - 1), 1.0)
                +
                avoidNaN((get(i + d + 1) - t) , get(i + d + 1) - get(i + 1))* avoidNaN(boor(t, i + 1, d - 1), 1.0);
    }

    private double avoidNaN(double a, double b) {
        if (Double.isFinite(a / b))
            return a / b;
        return 0.0;
    }

    public Point3D calculerPoint3D(double t) {
        Point3D p = Point3D.O0;
        for (int i = 0; i < controls.size(); i++) {
            double boor = 0d;
            for (int j = 0; j < T.size(); j++)

            {
                if(j==i)
                     boor += boor(t, j, degree);
            }

            p = p.plus(controls.get(i).mult(boor));
        }
        System.out.println("p = " + p.toString() + "\tt = " + t);
        return p;
    }

    public double get(int i) {
        if (i < 0) {
            return 0.0;
        }
        if (i >= T.size()) {
            return 0.0;
        }
        return T.get(i);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDegree() {
        return controls.size();
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Iterator<Point3D> iterator() {
        return controls.iterator();
    }

    public Point3D remove(int arg0) {
        return controls.remove(arg0);
    }

    public Point3D set(int arg0, Point3D arg1) {
        return controls.set(arg0, arg1);
    }

    public int size() {
        return controls.size();
    }

    public String toString() {
        String s = "bspline \n(\n\n";
        Iterator<Point3D> ps = iterator();
        while (ps.hasNext()) {
            s += "\n" + ps.next().toString() + "\n";
        }
        return s;
    }

    public ArrayList<Point3D> getControls() {
        return controls;
    }

    public void setControls(ArrayList<Point3D> controls) {
        this.controls = controls;
    }

    public ArrayList<Double> getT() {
        return T;
    }

    public void setT(ArrayList<Double> t) {
        T = t;
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredLists().put("controls/Points de contrôle", controls);
        getDeclaredLists().put("T/poids des points de contrôle", T);
    }

    public void add(Double d, Point3D p) {
        controls.add(p);
        T.add(d);
    }


}
