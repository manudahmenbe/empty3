package be.manudahmen.emptycanvas.library.empty3.library.raytracer;

import be.manudahmen.emptycanvas.library.empty3.library.object.Representable;

/**
 * Created by manuel on 02-10-16.
 */
public class RtRepresentable extends RtObject {
    Representable representable;

    public RtRepresentable(Representable r) {
        this.representable = r;
    }


    public boolean intersectsNode(RtRay ray, RtIntersectInfo intersectInfo) {

        return representable.intersects(ray, intersectInfo) != null; //TODO CHCECK
    }
}
