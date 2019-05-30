package be.manudahmen.empty3.core.nurbs;

/**
 * Created by manue on 28-05-19.
 */
public abstract class Fct1D_1D {
    public class I extends Fct1D_1D
    {

        public I()
        {

        }

        @Override
        public double result(double input) {
            return input;
        }
    }
    public class Fx extends Fct1D_1D
    {

        private final double x;

        public Fx(double x)
        {
            this.x = x;
        }

        @Override
        public double result(double input) {
            return x;
        }
    }
    public abstract double result(double input);
}
