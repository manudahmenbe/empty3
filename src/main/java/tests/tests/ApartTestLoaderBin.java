/*

 Copyright (C) 2010-2013  DAHMEN, Manuel, Daniel

 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.

 This library is distributed in the hope that it will be.manudahmen.empty3.library.tests.be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA

 */

package tests.tests;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.Scene;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.core.script.ExtensionFichierIncorrecteException;
import be.manudahmen.empty3.core.script.Loader;
import be.manudahmen.empty3.core.script.VersionNonSupporteeException;
import be.manudahmen.empty3.core.testing.TestObjetStub;

import java.awt.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Atelier
 */
public class ApartTestLoaderBin extends TestObjetStub {

    public static void main(String[] args) {
        ApartTestLoaderBin bin = new ApartTestLoaderBin();
        bin.run();
    }

    @Override
    public void testScene() {
        try {
            setResx(320);
            setResy(200);

            Loader l = new Loader();
            Scene sc = new Scene();
            sc.add(
                    new TRI(new Point3D(0, 0, 0), new Point3D(0, 1, 0), new Point3D(1, 0, 0), Color.BLACK));
            l.saveBin(new File("testTMP.bmoo"), sc);
            Scene s = l.loadBin(new File("testTMP.bmoo"));

            scene = s;

            description = "TRIANGLE NOIR";
        } catch (VersionNonSupporteeException ex) {
            Logger.getLogger(ApartTestLoaderBin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExtensionFichierIncorrecteException ex) {
            Logger.getLogger(ApartTestLoaderBin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
