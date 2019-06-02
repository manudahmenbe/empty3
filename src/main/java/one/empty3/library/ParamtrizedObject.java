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

package one.empty3.library;

import java.util.HashMap;
import java.util.Set;

public abstract class ParamtrizedObject {

    private HashMap<String, Object> parametres = new HashMap<String, Object>();

    public Object getParametre(String name) {
        return parametres.get(name);
    }
    /*
     * 	public abstract List<String> parameterNames();
 
     public abstract Class<?> parameterClass(String name);
     public abstract List<Object> parameterValues(String name);
     public abstract List<Object> setParameterValue(Object value);
     public abstract List<Object> setParameterValues(List<Object> value);
     public abstract List<Object> getParameterValue(String name);
     public abstract List<Object> getParameterValues(String name);
     */

    public Set<String> getParametres() {
        return parametres.keySet();
    }

    public void setParametre(String name, Object value) {
        parametres.put(name, value);
    }
}
