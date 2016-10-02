package info.emptycanvas.library.raytracer;

import info.emptycanvas.library.object.Representable;

/**
 * Created by manuel on 02-10-16.
 */
public class CRepresentable extends CObject{
    Representable representable;
    public CRepresentable(Representable r)
    {
        this.representable = r;
    }


    public boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo) {

        return representable.intersects(ray, intersectInfo)!=null; //TODO CHCECK
    }
}
