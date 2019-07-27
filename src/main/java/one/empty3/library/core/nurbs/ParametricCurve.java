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
public class ParametricCurve extends Representable {
    private static ParametricCurve.Globals globals;


    static {
        if(globals==null)

        {
            Globals globals1 = new Globals();
            ParametricCurve.setGlobals(globals1);
            globals1.setIncrU(0.0001);
        }
    }
    public ParametricCurve()
    {
        super();
    }

    protected Double startU = 0.0;
    protected Double endU= 1.0;
    protected boolean connected = true;
    private Parameters parameters = new Parameters(true);
    private Double incrU = 0.0001;
    private Double incrTAN = 0.0001;

    public static void setGlobals(Globals globals) {
        ParametricCurve.globals = globals;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public Point3D calculerPoint3D(double t)
    {
        throw new UnsupportedOperationException("To implements. Subclasses");
    }

    public Point3D calculerVitesse3D(double t)
    {
        return calculerPoint3D(t*(1+incrTAN)).moins(calculerPoint3D(t)).mult(incrTAN);
    }

    public Point3D tangente(Double t)
    {
        return calculerPoint3D(t*1.0001).moins(calculerPoint3D(t));
    }

    public Double endU() {
        return endU;
    }

    public void endU(Double e) {
        endU = e;
    }

    public Double getIncrU() {
        Double incr = 1.0;
        if (parameters.isGlobal()) {
            incr = parameters.getIncrU();
        } else {
            incr = globals.getIncrU();
        }
        ;
        return incr <= incrU? incrU : incr;
    }

    public Double start() {
        return startU;
    }

    public void start(Double s) {
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
        private Double incrU = 0.0;

        public Double getIncrU() {
            return Globals.this.incrU;
        }

        public void setIncrU(Double incrU) {
            Globals.this.incrU = incrU;
        }

    }

    public class Parameters {

        private boolean isGlobal;
        private Double incrU = 0.0001;
        private Double startU;
        private Double endU;

        public Parameters(Double incrU) {
            Parameters.this.setIncrU(incrU);
        }

        public Parameters(boolean isGlobal) {
            setGlobal(isGlobal);
        }

        public Double getIncrU() {

            return Parameters.this.incrU;
        }
        public Double getStartU() {

            return Parameters.this.startU;
        }
        public Double getEndU() {

            return Parameters.this.endU;
        }

        public void setIncrU(Double incrU) {
            Parameters.this.incrU = incrU;
        }

        public boolean isGlobal() {
            return Parameters.this.isGlobal;
        }

        public void setGlobal(boolean global) {
            Parameters.this.isGlobal = global;
        }

        public void setEndU(Double endU) {
            Parameters.this.endU = endU;
        }
        public void setStartU(Double endU) {
            Parameters.this.startU = endU;
        }
    }

    public ParametricCurve morph(Double incrU)
    {
        // TODO
        return this;
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDoubles().put("incrU/incrU", incrU);
        getDeclaredDoubles().put("startU/startU", startU);
        getDeclaredDoubles().put("endU/endU", endU);
        getDeclaredBoolean().put("connected/dotted or lines", connected);
    }

    public static Globals getGlobals() {
        return globals;
    }

    public Double getStartU() {
        return startU;
    }

    public void setStartU(Double startU) {
        this.startU = startU;
    }

    public Double getEndU() {
        return endU;
    }

    public void setEndU(Double endU) {
        this.endU = endU;
    }

    public void setIncrU(Double incrU) {
        this.incrU = incrU;
    }

    public Double getIncrTAN() {
        return incrTAN;
    }

    public void setIncrTAN(Double incrTAN) {
        this.incrTAN = incrTAN;
    }

}


