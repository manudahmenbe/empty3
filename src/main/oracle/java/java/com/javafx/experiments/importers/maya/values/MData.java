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

package com.javafx.experiments.importers.maya.values;

import java.util.Iterator;
import java.util.List;
import com.javafx.experiments.importers.maya.MEnv;
import com.javafx.experiments.importers.maya.types.MDataType;

public interface MData {
    public MEnv getEnv();

    public MDataType getType();

    public void setSize(int size);

    public void parse(String field, List<String> values);

    public void parse(List<String> values);

    public void parse(Iterator<String> iter);

    /** Get the data associated with the given string path. */
    public MData getData(String path);

    /** Field access for those values which support it, such as compound values. */
    public MData getFieldData(String name);

    /** Index access for those values which suport it, such as array values. */
    public MData getData(int index);

    /** Slice access for those values which support it, such as array values. */
    public MData getData(int start, int end);
}
