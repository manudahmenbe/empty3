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

/**
 * *
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package one.empty3.library.core.export;
/*
import one.empty3.library.*;
import com.sun.org.apache.xml.internal.utils.DOMBuilder;
import org.jdom.Attribute;
import org.jdom.Comment;
import org.jdom.Element;
import org.jdom.Text;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
public class Export3DXML {

    public DOMBuilder domBuilder;

    public static void main(String[] args) {
        Export3DXML e = new Export3DXML();
        try {
            e.save(new File("EMPTYCANVAS.3DXML"), new Scene(), false);
        } catch (IOException ex) {
            Logger.getLogger(Export3DXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void save(File file, Scene scene, boolean overwrite) throws IOException {
        Element scnXml = new Element("XML3D");
        scnXml.setAttribute(new Attribute("version", "4.3"));
        scnXml.setAttribute(new Attribute("namespace", "http://www.3ds.com/xsd/3DXML"));
        scnXml.addContent(new Comment("Not implemented yet"));
        Element RepresentationLinkType = new Element("RepresentationLinkType");
        RepresentationLinkType.addContent(new Text("urn:3DXML:Emptycanvas.simple_exemple001"));
        scnXml.addContent(RepresentationLinkType);

        XMLOutputter xmlOutputter = new org.jdom.output.XMLOutputter(Format.getPrettyFormat());

        if (!file.exists() || (file.exists() && overwrite)) {
            xmlOutputter.output(scnXml, new FileOutputStream(file));
        }
    }
}
*/