package be.manudahmen.empty3.library.script;

import be.manudahmen.empty3.library.object.Cube;
import be.manudahmen.empty3.library.object.Point3D;
import be.manudahmen.empty3.library.object.TRI;
import be.manudahmen.empty3.library.tribase.TRICylindre;
import be.manudahmen.empty3.library.tribase.TRISphere;

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
