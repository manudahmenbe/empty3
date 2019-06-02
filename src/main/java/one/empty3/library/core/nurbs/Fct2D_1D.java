package one.empty3.library.core.nurbs;

/**
 * Created by manue on 28-05-19.
 */
public abstract class Fct2D_1D {
    public class Ix extends Fct2D_1D
    {

        public Ix()
        {

        }

        @Override
        public double result(double input, double input2) {
            return input;
        }
    }
    public class Iy extends Fct2D_1D
    {

        public Iy()
        {

        }

        @Override
        public double result(double input, double input2) {
            return input2;
        }
    }
    public abstract double result(double input1, double input2);
}
