/*
 * Copyright (c) 2017. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */
package com.javafx.experiments.importers.obj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.scene.paint.PhongMaterial;

import static com.javafx.experiments.importers.obj.ObjImporter.*;

/** Reader for OBJ file MTL material files. */
public class MtlReader {

    private String baseUrl;

    public MtlReader(String filename, String parentUrl) {
        baseUrl = parentUrl.substring(0,parentUrl.lastIndexOf('/')+1);
        String fileUrl = baseUrl + filename;
        try {
            URL mtlUrl = new URL(fileUrl);
            log("Reading material from filename = " + mtlUrl);
            read(mtlUrl.openStream());
        } catch (FileNotFoundException ex) {
            System.err.println("No material file found for obj. ["+fileUrl+"]");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Map<String, Material> materials = new HashMap<>();
    private PhongMaterial material = new PhongMaterial();
    private boolean modified = false;

    private void read(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String name = "default";
        while ((line = br.readLine()) != null) {
            try {
                if (line.isEmpty() || line.startsWith("#")) {
                    // comments and empty lines are ignored
                } else if (line.startsWith("newmtl ")) {
                    addMaterial(name);
                    name = line.substring("newmtl ".length());
                } else if (line.startsWith("Kd ")) {
                    material.setDiffuseColor(readColor(line.substring(3)));
                    modified = true;
                } else if (line.startsWith("Ks ")) {
                    material.setSpecularColor(readColor(line.substring(3)));
                    modified = true;
                } else if (line.startsWith("Ns ")) {
                    material.setSpecularPower(Double.parseDouble(line.substring(3)));
                    modified = true;
                } else if (line.startsWith("map_Kd ")) {
                    material.setDiffuseColor(Color.WHITE);
                    material.setDiffuseMap(loadImage(line.substring("map_Kd ".length())));
//                    material.setSelfIlluminationMap(loadImage(line.substring("map_Kd ".length())));
//                    material.setSpecularColor(Color.WHITE);
                    modified = true;
                    //            } else if (line.startsWith("illum ")) {
                    //                int illumNo = Integer.parseInt(line.substring("illum ".length()));
                    /*
                        0    Color on and Ambient off
                        1    Color on and Ambient on
                        2    Highlight on
                        3    Reflection on and Ray trace on
                        4    Transparency: Glass on
                             Reflection: Ray trace on
                        5    Reflection: Fresnel on and Ray trace on
                        6    Transparency: Refraction on
                             Reflection: Fresnel off and Ray trace on
                        7    Transparency: Refraction on
                             Reflection: Fresnel on and Ray trace on
                        8    Reflection on and Ray trace off
                        9    Transparency: Glass on
                             Reflection: Ray trace off
                        10   Casts shadows onto invisible surfaces
                     */
                } else {
                    log("material line ignored for " + name + ": " + line);
                }
            } catch (Exception ex) {
                Logger.getLogger(MtlReader.class.getName()).log(Level.SEVERE, "Failed to parse line:" + line, ex);
            }
        }
        addMaterial(name);
    }

    private void addMaterial(String name) {
        if (modified) {
            if (!materials.containsKey(name)) {
                materials.put(name, material);
            } else {
                log("This material is already added. Ignoring " + name);
            }
            material = new PhongMaterial(Color.WHITE);
        }
    }

    private Color readColor(String line) {
        String[] split = line.trim().split(" +");
        float red = Float.parseFloat(split[0]);
        float green = Float.parseFloat(split[1]);
        float blue = Float.parseFloat(split[2]);
        return Color.color(red, green, blue);
    }

    private Image loadImage(String filename) {
        filename = baseUrl + filename;
        log("Loading image from " + filename);
        Image image = new Image(filename);
        return new Image(filename);
    }

    public Map<String, Material> getMaterials() {
        return Collections.unmodifiableMap(materials);
    }
}
