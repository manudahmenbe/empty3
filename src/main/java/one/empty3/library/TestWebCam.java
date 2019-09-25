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

package one.empty3.library;/*
 * 2013 Manuel Dahmen
 */

import com.github.sarxos.webcam.Webcam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Se7en
 */
public class TestWebCam {

    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        boolean isOpen = webcam.isOpen();
        if (!isOpen) {
            webcam.open();
        }
        BufferedImage image = webcam.getImage();
        try {
            ImageIO.write(image, "PNG", new File("test.png"));
        } catch (IOException ex) {
            Logger.getLogger(TestWebCam.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!isOpen) {
            webcam.close();
        }
    }
}
