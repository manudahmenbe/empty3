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

package one.empty3.library.core.tribase;


import one.empty3.library.*;

public class TRIExtrusionGeneralisee extends TRIObjetGenerateurAbstract {

    public Chemin chemin;
    public Surface surface;
    private boolean sectionA = true;
    private boolean sectionB = true;
    private Point3D normaleFixe;

    public TRIExtrusionGeneralisee() {
        setCirculaireY(true);
        setCirculaireX(false);

    }

    public boolean isSectionA() {
        return sectionA;
    }

    public void setSectionA(boolean sectionA) {
        this.sectionA = sectionA;
    }

    public boolean isSectionB() {
        return sectionB;
    }

    public void setSectionB(boolean sectionB) {
        this.sectionB = sectionB;
    }

    @Override
    public void setMaxY(int maxY) {
        super.setMaxY(maxY); //To change body of generated methods, choose Tools | Templates.
        surface.setMax(getMaxY());
    }

    @Override
    public void setMaxX(int maxX) {
        super.setMaxX(maxX); //To change body of generated methods, choose Tools | Templates.
        chemin.setMax(getMaxX());
    }

    public Chemin getChemin() {
        return chemin;
    }

    public void setChemin(Chemin chemin) {
        this.chemin = chemin;
        this.setMaxX(chemin.getMax());
    }

    public Surface getSurface() {
        return surface;
    }

    public void setSurface(Surface surface) {
        this.surface = surface;
        this.setMaxY(surface.getMax());
    }

    @Override
    public Point3D coordPoint3D(int ichemin, int isurface) {

        Point3D Op, T, NX, NY, pO;

        Op = chemin.getPoint(ichemin);

        if (ichemin == chemin.getMax() - 1 && sectionB) {
            return Op;
        } else if (ichemin == 0 && sectionA) {
            return Op;
        }

        T = chemin.tangent(ichemin);


        /**
         * Plan normal pour le chemin
         *
         */
        Point3D normale = chemin.normale(ichemin);
        /*if ((normale.norme() < 0.001 || normale.prodVect(T).norme() < 0.001)) {
            if (normaleFixe == null) {
                normaleFixe = T.prodVect(Point3D.r(1));
            }
            NX = normaleFixe.norme1();
        } else {
            NX = normale.norme1();
        }//*/
        T = T.norme1();
        NX = normale.norme1();
        NY = NX.prodVect(T).norme1();
/*
        System.err.println("\nT "+T );
        System.err.println("NX"+NX);
        System.err.println("NY"+NY);
 */
        pO = Op.plus(T.mult(surface.getPoint(isurface).getZ()).plus(NX.mult(surface.getPoint(isurface).getX()))).plus(
                NY.mult(surface.getPoint(isurface).getY()));
        return pO;

    }
}
