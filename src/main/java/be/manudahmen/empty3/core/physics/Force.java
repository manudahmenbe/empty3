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

package be.manudahmen.empty3.core.physics;

import be.manudahmen.empty3.Point3D;

public class Force implements IntForce {
    public double amortissement = 0;
    public double intensiteRepulsion = 0;
    private double distMinFusion;
    private boolean fusion;
    private double G = 6.67E-11;
    private Bille[] courant = null;
    private Bille[] next = null;
    private double dt = 10E10;
    private Point3D cm;
    private double cmd;
    private double distMax = 0.0;
    private double distMin = Double.MAX_VALUE;
    private double[] dMin;
    private double[] dMax;

    @Override
    public void configurer(Bille[] courant) {
        this.courant = courant;
        this.dMax = new double[courant.length];
        this.dMin = new double[courant.length];


    }

    @Override
    public Point3D centreMasse() {
        return cm;
    }

    @Override
    public Point3D attractionRepulsion(Bille other, Bille p) {
        if (p != other) {
            double r = other.position.moins(p.position).norme();
            if (r > distMax)
                distMax = r;
            if (r < distMin)
                distMin = r;

            Point3D vu = other.position.moins(p.position).norme1();
            return vu.mult(
                    intensiteRepulsion * other.masse * p.masse / r / r / r
            )

                    .plus(

                            vu.mult(
                                    G * other.masse * p.masse / r / r
                            )
                    );
        }
        return Point3D.O0;
    }

    @Override
    public Point3D frottement(Bille p) {
        Point3D fvp = p.vitesse.mult(p.amortissement * amortissement * -1);

        return fvp;
    }

    private void delete1(int ind) {
        Bille[] courantMinus1 = new Bille[courant.length - 1];

        int i = 0;
        for (int a = 0; a < courant.length - 1; a++) {

            if (a == ind)
                continue;
            courantMinus1[a] = courant[i];
            i++;
        }

        this.courant = courantMinus1;
    }

    public double dMin(int ind) {
        return dMin[ind];
    }

    public double dMax(int ind) {
        return dMax[ind];
    }
    @Override
    public Point3D force(int ind) {
        Point3D f = Point3D.O0;
        dMin[ind] = Double.MAX_VALUE;
        dMax[ind] = Double.MIN_VALUE;
        for (int i = 0; i < courant.length; i++) {
            if (courant[i] != courant[ind]) {

                double dTmp = courant[ind].position.moins(courant[i].position).norme();
                if (dTmp < dMin[ind])
                    dMin[ind] = dTmp;
                if (dTmp > dMax[ind])
                    dMax[ind] = dTmp;

                f = f.plus(attractionRepulsion(courant[i], courant[ind])).plus(frottement(courant[i]));
                if (isFusion()) {
                    courant[ind].masse += courant[i].masse;
                    courant[ind].vitesse = courant[ind].vitesse.plus(courant[i].vitesse);

                    courant[i] = courant[ind];

                    delete1(ind);
                }
            }
        }
        f = f.plus(frottement(courant[ind]));

        return f;
    }

    @Override
    public Point3D acc(int ind) {
        return force(ind).mult(1 / courant[ind].masse);
    }

    @Override
    public Point3D vitesse(int ind) {
        return (next[ind].vitesse = courant[ind].vitesse.plus(acc(ind).mult(dt)));
    }

    @Override
    public Point3D position(int ind) {
        return (next[ind].position = courant[ind].position.plus(vitesse(ind).mult(dt)));
    }

    @Override
    public void calculer() {
        cm = Point3D.O0;
        cmd = 0.0;


        next = new Bille[courant.length];

        distMax = 0.0;
        distMin = Double.MAX_VALUE;

        for (int i = 0; i < courant.length; i++) {
            next[i] = new Bille(courant[i]);

            position(i);

            cm = cm.plus(next[i].position.mult(next[i].masse));
            cmd += next[i].masse;

        }

        cm = cm.mult(1 / cmd);

        courant = next;
    }

    @Override
    public double getDistMax() {
        return distMax;
    }

    @Override
    public void setDistMax(double distMax) {
        this.distMax = distMax;
    }

    @Override
    public double getDistMin() {
        return distMin;
    }

    @Override
    public void setDistMin(double distMin) {
        this.distMin = distMin;
    }

    @Override
    public Bille[] getCourant() {
        return courant;
    }

    @Override
    public void setCourant(Bille[] courant) {
        this.courant = courant;
    }

    @Override
    public Bille[] getNext() {
        return next;
    }

    @Override
    public void setNext(Bille[] next) {
        this.next = next;
    }

    @Override
    public double getDt() {
        return dt;
    }

    @Override
    public void setDt(double dt) {
        this.dt = dt;
    }

    @Override
    public double getG() {
        return G;
    }

    @Override
    public void setG(double g) {
        G = g;
    }

    @Override
    public double getDistMinFusion() {
        return distMinFusion;
    }

    @Override
    public void setDistMinFusion(double distMinFusion) {
        this.distMinFusion = distMinFusion;
    }

    @Override
    public boolean isFusion() {
        return fusion;
    }

    @Override
    public void setFusion(boolean fusion) {
        this.fusion = fusion;
    }
}
