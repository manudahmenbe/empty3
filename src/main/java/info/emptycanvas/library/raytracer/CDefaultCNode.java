package info.emptycanvas.library.raytracer;

/**
 * Created by manuel on 03-08-16.
 */
public class CDefaultCNode extends CNode {
    @Override
    public boolean intersectsNode(CRay ray, CIntersectInfo intersectInfo) {
        return false;
    }
}
