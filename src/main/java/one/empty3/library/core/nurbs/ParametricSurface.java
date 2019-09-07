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
import one.empty3.library.Polygon;
import one.empty3.library.ZBuffer;
import one.empty3.library.core.tribase.TRIObjetGenerateurAbstract;

/**
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class ParametricSurface extends TRIObjetGenerateurAbstract {



    private static Globals globals;

    static {
        if(globals==null)

        {
            Globals globals1 = new Globals();
            ParametricSurface.setGlobals(globals1);
            globals1.setIncrU(0.1);
            globals1.setIncrV(0.1);
        }



    }

    private Double incrU = 0.1;
    private Double incrV = 0.1;
    private Double incrVitesse = 0.0001;
    private Double incrNormale = 0.000001;
    private Double startU = 0.0, startV = 0.0;
    private Double endU = 1.0, endV = 1.0;
    private ParametricSurface.Parameters parameters = new ParametricSurface.Parameters(true);

    public static Globals getGlobals() {
        return globals;
    }

    public static void setGlobals(Globals globals) {
        ParametricSurface.globals = globals;
    }

    public Double getIncrU() {
       return incrU;
    }

    public void setIncrU(Double incr1) {
        if (parameters.isGlobal()) {
            parameters.setIncrU(incr1);
        } else {
            globals.setIncrU(incr1);
        }
        this.incrU = incr1;
    }
    public void setIncrV(Double incr2) {
        if (parameters.isGlobal()) {
            parameters.setIncrV(incr2);
        } else {
            globals.setIncrV(incr2);
        }
        this.incrV = incr2;
    }

    public Double getIncrV() {
        return incrV;
    }


    public Point3D calculerPoint3D(double u, double v)
    {
        return new Point3D();
    }

    public Point3D calculerVitesse3D(double u, double v) {
        Point3D moins = calculerPoint3D(u + incrVitesse, v).moins(calculerPoint3D(u, v));
        Point3D moins1 = calculerPoint3D(u, v + incrVitesse).moins(calculerPoint3D(u, v));
        return moins.plus(moins1).mult(0.5 / incrVitesse / incrVitesse).norme1();
    }

    public Point3D calculerNormale3D(double u, double v) {
        Point3D moins = calculerPoint3D(u + incrNormale, v).plus(calculerPoint3D(u, v));
        Point3D moins1 = calculerPoint3D(u, v + incrNormale).plus(calculerPoint3D(u, v));
        return moins.prodVect(moins1).mult(0.5 / incrNormale / incrNormale).norme1();
    }

    public Point3D calculerTangenteU(double u, double v) {
        Point3D moins = calculerPoint3D(u + incrVitesse, v).moins(calculerPoint3D(u, v));
        return moins.mult(1.0 / incrVitesse / incrVitesse).norme1();
    }

    public Point3D calculerTangenteV(double u, double v) {
        Point3D moins1 = calculerPoint3D(u, v + incrVitesse).moins(calculerPoint3D(u, v));
        return moins1.mult(1.0 / incrVitesse).norme1();
    }

    public Double incr1() {
        return incrU;
    }

    public Double incr2() {
        return incrU;
    }

    public Double getStartU() {
        return startU;
    }

    public void setStartU(Double s1) {
        this.startU = s1;
    }

    public Double getStartV() {
        return startV;
    }

    public void setStartV(Double s2) {
        this.startV = s2;
    }

    public Double getEndU() {
        return endU;
    }

    public void setEndU(Double e1) {
        this.endU = e1;
    }

    public Double getEndV() {
        return endV;
    }

    public void setEndV(Double e2) {
        this.endV = e2;
    }

    public Point3D velocity(Double u1, Double v1, Double u2, Double v2) {
        return calculerPoint3D(u2, v2).moins(calculerPoint3D(u1, v1));
    }

    public Point3D coordPoint3D(int x, int y) {
        return calculerPoint3D(1.0 * x / getMaxX(), 1.0 * y / getMaxY());
    }

    @Override
    public void drawStructureDrawFast(ZBuffer z) {
        System.out.println("Drawn structure ffaast START");
        Double incrU = 1.0 / NFAST;
        Double incrV = 1.0 / NFAST;
        for (Double u = startU; u < endU; u += incrU) {
            for (Double v = startU; v < endU; v += incrV) {
                Double[][] uvincr = new Double[][]{
                        {u, v},
                        {u + incrU, v},
                        {u + incrU, v + incrV},
                        {u, v + incrV}
                };
                for (int i = 0; i < 3; i++) {

                    z.line(calculerPoint3D(uvincr[i][0], uvincr[i][1]),
                            calculerPoint3D(uvincr[(i + 1) % 3][0], uvincr[(i + 1) % 3][0]), CFAST);
                }
            }
        }
        System.out.println("Drawn structure ffaast END");
    }

    public Polygon getElementSurface(Double u, Double incrU, Double v, Double incrV) {
        Double[][] uvincr = new Double[][]{
                {u, v},
                {u + incrU, v},
                {u + incrU, v + incrV},
                {u, v + incrV}
        };
        Polygon polygon = new Polygon(new Point3D[]{
                calculerPoint3D(uvincr[0][0], uvincr[0][1]),
                calculerPoint3D(uvincr[1][0], uvincr[1][1]),
                calculerPoint3D(uvincr[2][0], uvincr[2][1]),
                calculerPoint3D(uvincr[3][0], uvincr[3][1])},
                texture());
        return polygon;
    }

    public static class Globals {
        private Double incrU;
        private Double incrV;

        public Double getIncrU() {
            return incrU;
        }

        public void setIncrU(Double incrU) {
            this.incrU = incrU;
        }

        public Double getIncrV() {
            return incrV;
        }

        public void setIncrV(Double incrV) {
            this.incrV = incrV;
        }
    }

    public class Parameters {

        private boolean isGlobal = true;
        private Double incrV = 0.1;
        private Double incrU = 0.1;

        public Parameters(Double incrU, Double incrV) {
            this.setIncrU(incrU);
            this.setIncrV(incrV);
        }

        public Parameters(boolean isGlobal) {
            setGlobal(isGlobal);
        }

        public Double getIncrU() {
            return incrU;
        }

        public void setIncrU(Double incrU) {
            this.incrU = incrU;
        }

        public Double getIncrV() {
            return incrV;
        }

        public void setIncrV(Double incrV) {
            this.incrV = incrV;
        }

        public boolean isGlobal() {
            return isGlobal;
        }

        public void setGlobal(boolean global) {
            this.isGlobal = global;
        }
    }
    public ParametricSurface morph(Double incr1,
        Double incr2)
    {
        // TODO
        return this;

    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDoubles().put("startU/startU", startU);
        getDeclaredDoubles().put("startV/startV", startV);
        getDeclaredDoubles().put("incrU/incrU", incrU);
        getDeclaredDoubles().put("incrV/incrV", incrV);
        getDeclaredDoubles().put("endU/endU", endU);
        getDeclaredDoubles().put("endV/endV", endV);
    }

    public Double getIncrVitesse() {
        return incrVitesse;
    }

    public void setIncrVitesse(Double incrVitesse) {
        this.incrVitesse = incrVitesse;
    }

    public Double getIncrNormale() {
        return incrNormale;
    }

    public void setIncrNormale(Double incrNormale) {
        this.incrNormale = incrNormale;
    }


    public Double getNFAST() {
        return NFAST;
    }
    public void setNFAST(Double NFAST) {
        this.NFAST = NFAST;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "ParametricSurface()\n";
    }
}
