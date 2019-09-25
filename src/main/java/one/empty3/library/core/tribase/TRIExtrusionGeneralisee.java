/*
 *  This file is part of Empty3.
 *
 *     Empty3 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Empty3 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Empty3.  If not, see <https://www.gnu.org/licenses/>. 2
 */

/*
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>
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
