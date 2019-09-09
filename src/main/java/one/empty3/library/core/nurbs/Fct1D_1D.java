package one.empty3.library.core.nurbs;

import one.empty3.library.Point3D;

/**
 * Created by manue on 28-05-19.
 */
public abstract class Fct1D_1D extends ParametricCurve {
    public class I extends Fct1D_1D {

        public I() {

        }

        @Override
        public double result(double input) {
            return input;
        }
    }
    public class Fx extends Fct1D_1D {

        private final double x;

        public Fx(double x) {
            this.x = x;
        }

        @Override
        public double result(double input) {
            return x;
        }
    }
/*
    StructureMatrix<Fct1D_1D> predifinedFunctions = new StructureMatrix<>(1);
    {
        predifinedFunctions.add(1, new I());
        predifinedFunctions.add(1, new Fx(0.0));
    }
*/
public abstract double result(double input);

    @Override
    public Point3D calculerPoint3D(double t) {
        return new Point3D(t, result(t), 0d);
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
    }
}
