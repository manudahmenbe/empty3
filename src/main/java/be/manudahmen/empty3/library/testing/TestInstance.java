/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3.library.testing;

import java.util.ArrayList;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public abstract class TestInstance {

    protected TestObjet test;

    public abstract Parameter getDynParameter(String name);

    public abstract ArrayList<Parameter> getDynParameters();

    public abstract ArrayList<Parameter> getInitParameters();

    public abstract boolean newInstance(ArrayList<Parameter> parameter);

    public abstract boolean setDynParameter(Parameter parameter);

    public void theTest(TestObjet test) {
        this.test = test;
    }

    public class Parameter {

        public String name;
        public Class zclass;
        public Object value;
    }

}
