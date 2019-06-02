/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package one.empty3.library.core.testing;

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
