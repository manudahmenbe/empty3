package one.empty3.pointset;

import one.empty3.library.Point3D;
import one.empty3.library.Representable;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by manue on 16-07-19.
 */
public class PCont<T extends Point3D> extends Representable{

    protected ArrayList<T> points;

    public PCont() {
        points = new ArrayList<T>();
    }

    public void add(T p) {
        points.add(p);
    }

    public T get(int index) {
        return
                points.get(index);
    }

    public ArrayList<T> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<T> points) {
        this.points = points;
    }

    public boolean isEmpty() {
        return points.isEmpty();
    }

    public Iterator<T> iterator() {
        return points.iterator();
    }

    public Point3D remove(int arg0) {
        return points.remove(arg0);
    }

    public boolean remove(T arg0) {
        return points.remove(arg0);
    }

    public int size() {
        return points.size();
    }


    public String toString() {
        String s = "tri \n(\n\n";
        Iterator<T> tris = iterator();
        while (tris.hasNext()) {
            s += "\n" + tris.next().toString() + "\n";
        }
        return s + "\n)\n";
    }
}



