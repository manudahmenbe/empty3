/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
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
package one.empty3.library.core.nurbs;

import one.empty3.library.Point3D;
import one.empty3.library.Representable;
import one.empty3.library.ZBuffer;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public abstract class ParametricCurve extends Representable {
    private static ParametricCurve.Globals globals;

    static {
        if(globals==null)

        {
            Globals globals1 = new Globals();
            ParametricCurve.setGlobals(globals1);
            globals1.setIncrU(0.0001);
        }
    }

    protected double startU = 0;
    protected double endU= 1;
    protected boolean connected = true;
    private Parameters parameters = new Parameters(true);
    private double incrU = 0.0001;
    private double incrTAN = 0.0001;

    public static void setGlobals(Globals globals) {
        ParametricCurve.globals = globals;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public abstract Point3D calculerPoint3D(double t);

    public Point3D calculerVitesse3D(double t)
    {
        return calculerPoint3D(t*(1+incrTAN)).moins(calculerPoint3D(t)).mult(incrTAN);
    }

    public Point3D tangente(double t)
    {
        return calculerPoint3D(t*1.0001).moins(calculerPoint3D(t));
    }

    public double endU() {
        return endU;
    }

    public void endU(double e) {
        endU = e;
    }

    public double getIncrU() {
        double incr = 0;
        if (parameters.isGlobal()) {
            incr = parameters.getIncrU();
        } else {
            incr = globals.getIncrU();
        }
        ;
        return incr <= incrU? incrU : incr;
    }

    public double start() {
        return startU;
    }

    public void start(double s) {
        startU = s;
    }

    @Override
    public boolean ISdrawStructureDrawFastIMPLEMENTED(ZBuffer z) {
        return true;
    }

    @Override
    public void drawStructureDrawFast(ZBuffer z) {
        for (int i = 0; i < 100; i++) {
            Point3D d = calculerPoint3D(0.0 + 1.0 * i / NFAST);
            d.texture(CFAST);
            if (d.ISdrawStructureDrawFastIMPLEMENTED(z)) {
                d.drawStructureDrawFast(z);

            } else
                ;
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public static class Globals {
        private double incrU = 0;

        public double getIncrU() {
            return Globals.this.incrU;
        }

        public void setIncrU(double incrU) {
            Globals.this.incrU = incrU;
        }

    }

    public class Parameters {

        private boolean isGlobal;
        private double incrU = 0.0001;
        private double startU;
        private double endU;

        public Parameters(double incrU) {
            Parameters.this.setIncrU(incrU);
        }

        public Parameters(boolean isGlobal) {
            setGlobal(isGlobal);
        }

        public double getIncrU() {

            return Parameters.this.incrU;
        }
        public double getStartU() {

            return Parameters.this.startU;
        }
        public double getEndU() {

            return Parameters.this.endU;
        }

        public void setIncrU(double incrU) {
            Parameters.this.incrU = incrU;
        }

        public boolean isGlobal() {
            return Parameters.this.isGlobal;
        }

        public void setGlobal(boolean global) {
            Parameters.this.isGlobal = global;
        }

        public void setEndU(double endU) {
            Parameters.this.endU = endU;
        }
        public void setStartU(double endU) {
            Parameters.this.startU = endU;
        }
    }

    public ParametricCurve morph(double incrU)
    {
        // TODO
        return this;
    }


    {
        getDeclaredDoubles().put("incrU/incrU", incrU);
        getDeclaredDoubles().put("startU/startU", startU);
        getDeclaredDoubles().put("endV/endV", endU);
    }
}


