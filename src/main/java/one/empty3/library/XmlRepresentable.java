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
