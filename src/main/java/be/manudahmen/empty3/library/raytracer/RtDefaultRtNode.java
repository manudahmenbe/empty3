package be.manudahmen.empty3.library.raytracer;

/**
 * Created by manuel on 03-08-16.
 */
public class RtDefaultRtNode extends RtNode {
    @Override
    public boolean intersectsNode(RtRay ray, RtIntersectInfo intersectInfo) {
        return false;
    }
}
