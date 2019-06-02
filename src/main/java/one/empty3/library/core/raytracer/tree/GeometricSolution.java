package one.empty3.library.core.raytracer.tree;

import one.empty3.library.ECBufferedImage;
import one.empty3.library.Scene;
import one.empty3.library.ZBuffer;
import one.empty3.library.core.raytracer.RtRaytracer;

/**
 * Created by Manuel Dahmen on 15-12-16.
 */
public abstract class GeometricSolution {
    private ECBufferedImage graph;
    private Scene scene;

    public GeometricSolution(ECBufferedImage graph, Scene scene) {
        this.graph = graph;
        this.scene = scene;
    }

    public void setGraph(ECBufferedImage graph) {
        this.graph = graph;
    }

    public ECBufferedImage getGraph() {
        return graph;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public abstract boolean plot();

    class ZBufferGeometricSolution extends GeometricSolution
    {
        private ZBuffer zbuffer;
        public ZBufferGeometricSolution(ZBuffer z, Scene scene) {
            super(graph, scene);
            zbuffer = z;
        }

        @Override
        public boolean plot() {
            return false;
        }
    }
    class RayTracerGeometricSolution extends GeometricSolution
    {

        private RtRaytracer raytracer;
        public RayTracerGeometricSolution(RtRaytracer rt, Scene scene) {
            super(graph, scene);
            raytracer = rt;

        }

        @Override
        public boolean plot() {
            return false;
        }
    }
}
