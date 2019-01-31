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

package com.javafx.experiments.importers.maya.values.impl;

import java.util.Iterator;
import com.javafx.experiments.importers.maya.types.MCharacterMappingType;
import com.javafx.experiments.importers.maya.values.MCharacterMapping;

public class MCharacterMappingImpl extends MDataImpl implements MCharacterMapping {

    class EntryImpl implements Entry {
        public String getKey() {
            return key;
        }

        public int getSourceIndex() {
            return sourceIndex;
        }

        public int getTargetIndex() {
            return targetIndex;
        }

        String key;
        int sourceIndex;
        int targetIndex;

        public EntryImpl(String key, int sourceIndex, int targetIndex) {
            this.key = key; this.sourceIndex = sourceIndex; this.targetIndex = targetIndex;
        }
    }

    Entry[] entries;

    public MCharacterMappingImpl(MCharacterMappingType type) {
        super(type);
    }

    public Entry[] getMapping() {
        return entries;
    }

    public void parse(Iterator<String> values) {
        int count = Integer.parseInt(values.next());
        entries = new Entry[count];
        for (int i = 0; i < count; i++) {
            String k = values.next();
            int i1 = Integer.parseInt(values.next());
            int i2 = Integer.parseInt(values.next());
            entries[i] = new EntryImpl(k, i1, i2);
        }
    }

}
