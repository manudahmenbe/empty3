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

/*__
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen _manuel.dahmen@gmx.com_
 * <p>
 * *
 */
package one.empty3.library;

import java.awt.*;

/*__
 * @author Manuel Dahmen _manuel.dahmen@gmx.com_
 */
public final class LumierePonctuelle extends Lumiere {

double minThreshold=0.1, maxThreshold=0.9;

    private StructureMatrix<ITexture> couleurLumiere = new StructureMatrix<>(0, ITexture.class);
    private StructureMatrix<Point3D> position = new StructureMatrix<>(0, Point3D.class);
    private double r0 = 1.0;
    private StructureMatrix<Boolean> directional = new StructureMatrix<>(0, Boolean.class);

    public LumierePonctuelle() {
        position.setElem(Point3D.O0);
        this.couleurLumiere.setElem(new ColorTexture(Color.WHITE));
        directional.setElem(Boolean.FALSE);
    }
    public LumierePonctuelle(Point3D pos, Color couleurLumiere) {
        this.position .setElem(pos);
        this.couleurLumiere.setElem(new ColorTexture(couleurLumiere));
        directional.setElem(false);
        
    }

    @Override
    public int getCouleur(int base, Point3D p, Point3D n) {
        if(n==null)
            n = Point3D.X;
        double x = p.moins(position.getElem()).dot(n);
        double r = 0.0;
        if(x<=0.0)
            x = - x;
// if(r>=1.0)
//            return Color.WHITE.getRGB();

        if (directional.getElem()) {
            r = 1*r0/x;
                    //* (Math.cos(Math.abs(x) / Math.PI * 2 / ));
        } else {
            r = 1 * r0 /x;
                    //* (Math.cos(Math.abs(x) / Math.PI * 2/ p.moins(position.getElem()).norme()))/x;
        }
        if (r < minThreshold) {
            r = minThreshold;
        }
        if (r > maxThreshold) {
            r = maxThreshold;
        }

        Color couleurObjet = new Color(base);
        Color color = new Color(couleurLumiere.getElem().getColorAt(0, 0));
        return new Color(
                 minmaxc((Ls.getRed  ())*(couleurObjet.getRed  ())  + color.getRed()   * ( La.getRed()) /(Ls.getRed()  +La.getRed  ()),
                 minmaxc((Ls.getGreen())*(couleurObjet.getGreen())  + color.getGreen() * (La.getGreen())/(Ls.getGreen()+La.getGreen()),
                 minmaxc((Ls.getBlue ())*(couleurObjet.getBlue ())  + color.getBlue()  * ( La.getBlue())/(Ls.getBlue() +La.getBlue ()) ).getRGB();
    }

    public void intensite(int r0) {
        this.r0 = r0;
    }

    public StructureMatrix<Boolean> getDirectional() {
        return directional;
    }

    public void setDirectional(StructureMatrix<Boolean> directional) {
        this.directional = directional;
    }

    public void setR0(double r0) {
        this.r0 = r0;
    }
   float minmaxc(double c){
       return (float)Math.max(1.0, Math.min(0.0, c));
   }

    public void declareProperties()
    {
        getDeclaredDataStructure().put("position/Position de la provenace lumineuse", position);
        getDeclaredDataStructure().put("color/Couleur de la lumière", couleurLumiere);
        getDeclaredDataStructure().put("directinal/isDirectional rayons parallèle et sphèrique", directional);
    }
}
