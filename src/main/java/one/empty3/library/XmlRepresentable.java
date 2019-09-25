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

package one.empty3.library;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by manue on 20-09-19.
 */
public interface XmlRepresentable {
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, Representable o1);
    public  void xmlRepresentation(String filesPath,  XmlRepresentable parent, StringBuilder stringBuilder, Double o);
    public  void xmlRepresentation(String filesPath,  XmlRepresentable parent, StringBuilder stringBuilder, Integer o);
    public  void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, String o);
    public  void xmlRepresentation(String filesPath,  XmlRepresentable parent, StringBuilder stringBuilder, File o);
    public  void xmlRepresentation(String filesPath,  XmlRepresentable parent, StringBuilder stringBuilder, ArrayList o);
    public  void xmlRepresentation(String filesPath,  XmlRepresentable parent, StringBuilder stringBuilder, Object o);
    public  void xmlRepresentation(String filesPath,  XmlRepresentable parent, StringBuilder stringBuilder);
    public void xmlRepresentation(String filesPath, XmlRepresentable parent, StringBuilder stringBuilder, String name, StructureMatrix is);
}
