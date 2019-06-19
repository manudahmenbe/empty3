/*
 *     3D game
 *     Copyright (C) 2010-2017  Manuel DAHMEN
 *
 *     This program is free software: you can redistribute it and/or modify
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
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package one.empty3.apps.pad;

import one.empty3.apps.pad.help.Cheval_Licorne;
import one.empty3.apps.pad.help.Escargot;
import one.empty3.apps.pad.help.MouvementDirectionnel;
import one.empty3.library.ColorTexture;
import one.empty3.library.Point3D;
import one.empty3.library.Representable;
import one.empty3.library.RepresentableConteneur;

import java.awt.*;
import java.util.Random;
import java.util.ResourceBundle;

public class Bonus extends RepresentableConteneur {

    private static final int SIZE;
    private static final int licorne;
    private static final int escargot;
    private static final int fuite;
    private static int maxx = 4, maxy = 4;
    private static ResourceBundle bundle;


    static {
        bundle = ResourceBundle.getBundle("one.empty3.apps.pad.Bundle"); // NOI18N
        SIZE = Integer.parseInt(bundle.getString("bonus.size"));
        licorne = Integer.parseInt(bundle.getString("licorne.size"));
        escargot = Integer.parseInt(bundle.getString("escargot.size"));
        fuite = Integer.parseInt(bundle.getString("fuite.size"));
        maxx = Integer.parseInt(bundle.getString("bonus.max.x"));
        maxy = Integer.parseInt(bundle.getString("bonus.max.y"));
    }

    Random r = new Random();
    private boolean locked = false;

    public Bonus() {

        for (int i = 0; i < SIZE; i++) {
            TRISphere2<SimpleBonus> s = new TRISphere2<SimpleBonus>(this, random(), 0.01);

            s.texture(new ColorTexture(Color.RED));

            s.setMaxX(maxx);

            s.setMaxY(maxy);

            s.setGameObject(new SimpleBonus());

            add(s);

        }

        for (int i = 0; i < licorne; i++) {
            TRISphere2<Cheval_Licorne> s;
            s = new TRISphere2<Cheval_Licorne>(this, random(), 0.01);
            s.texture(new ColorTexture(Color.BLUE));

            s.setMaxX(maxx);

            s.setMaxY(maxy);

            s.setGameObject(new Cheval_Licorne());
            add(s);

        }
        for (int i = 0; i < escargot; i++) {
            TRISphere2<Escargot> s = new TRISphere2<Escargot>(this, random(), 0.01);
            s.texture(new ColorTexture(Color.BLACK));

            s.setMaxX(maxx);

            s.setMaxY(maxy);
            s.setGameObject(new Escargot());

            add(s);

        }
        for (int i = 0; i < fuite; i++) {
            TRISphere2<MouvementDirectionnel> s = new TRISphere2<MouvementDirectionnel>(this, random(), 0.01);
            s.texture(new ColorTexture(Color.GRAY));

            s.setMaxX(maxx);

            s.setMaxY(maxy);

            s.setGameObject(new MouvementDirectionnel());
            add(s);

        }
    }

    public Point3D random() {
        double u, v;
        u = r.nextDouble();
        v = r.nextDouble();
        return new Point3D(u, v, 0);
    }

    public boolean removeBonus(Representable r2) {
        boolean success = false;
        while (!success && this.getListRepresentable().contains(r2)) {
            try {
                super.remove(r2);
                success = true;
                if (this.getListRepresentable().isEmpty()) {
                    return true;
                }
            } catch (Exception ex) {
                success = false;
            }
        }
        return false;
    }
//
//    public boolean isLocked()
//    {
//        return locked;
//    }
//    public void setLocked(boolean locked)
//    {
//        this.locked = locked;
//    }
//    public boolean getLock()
//    {
//        if(!locked)
//        {
//            locked = true;
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//
//    public void waitForLock() {
//        while(!getLock())
//        {
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Bonus.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
