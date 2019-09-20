package one.empty3.library;

import java.io.File;
import java.util.ArrayList;
import java.util.zip.ZipFile;

/**
 * Created by manue on 20-09-19.
 */
public interface XmlRepresentable {
    public  void xmlRepresentation(ZipFile zipFile, XmlRepresentable parent, StringBuilder stringBuilder, Double o);
    public  void xmlRepresentation(ZipFile zipFile, XmlRepresentable parent, StringBuilder stringBuilder, Integer o);
    public  void xmlRepresentation(ZipFile zipFile, XmlRepresentable parent, StringBuilder stringBuilder, String o);
    public  void xmlRepresentation(ZipFile zipFile, XmlRepresentable parent, StringBuilder stringBuilder, File o);
    public  void xmlRepresentation(ZipFile zipFile, XmlRepresentable parent, StringBuilder stringBuilder, ArrayList o);
    public  void xmlRepresentation(ZipFile ZipFile, XmlRepresentable parent, StringBuilder stringBuilder, Object o);
    public  void xmlRepresentation(ZipFile ZipFile, XmlRepresentable parent, StringBuilder stringBuilder);
}
