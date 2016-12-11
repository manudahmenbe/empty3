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

package be.manudahmen.empty3.core.script;

import be.manudahmen.empty3.Cube;
import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.core.tribase.TRICylindre;
import be.manudahmen.empty3.core.tribase.TRISphere;

import java.util.HashMap;
import java.util.Map;

public class RepresentableLoader {

    public static Map<String, Class<?>> listObjectTypes() {
        Map<String, Class<?>> m = new HashMap<String, Class<?>>();

        m.put("p", Point3D.class);
        m.put("tri", TRI.class);
        m.put("sphere", TRISphere.class);
        m.put("cylindre", TRICylindre.class);
        m.put("cube", Cube.class);
        return m;

    }

    public Map<String, Object[]> classParametre(Class<Object> clazz) {

        return null;
    }

    public class ParametreObjet {

        public String nomCourt;
        public String nomComplet;
        public String caption;
        public String description;
        public Class<Object> clazz;
        public String defaultValue;
    }
}
