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

package one.empty3.library.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author manuel
 */
public class Developer {

    public static BufferedImage getImageFromClasspath(Object clazz, String path) {
        try {
            return ImageIO.read(clazz.getClass()
                    .getResourceAsStream(
                            path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage getImageFromOuter(String[] path, String name) {
        for (int i = 0; i < path.length; i++) {
            try {
                return ImageIO.read(new File(path + File.separator + name));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
