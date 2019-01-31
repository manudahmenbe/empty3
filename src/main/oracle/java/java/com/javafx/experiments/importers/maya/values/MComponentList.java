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

import java.util.List;

public interface MComponentList extends MData {
    public static class Component {
        // Ideally we would have an enum of these, but we don't know all of the mappings yet.
        // The possible values are listed in MFn::Type (MFn.h), but not the names.
        // Here are some, derived by using the Maya selection tool and
        // watching the script editor output:
        //   "f[i]"          -> faces
        //   "vtx[i]"        -> vertices
        //   "e[i]"          -> edges
        //   "map[i]"        -> uvs
        //   "vtxFace[i][j]" -> vertices within faces
        private String name;
        private int startIndex; // Or -1 if "all"
        private int endIndex;   // Inclusive

        public String name() { return name; }

        public int startIndex() { return startIndex; }

        public int endIndex() { return endIndex; }

        public Component(String name, int startIndex, int endIndex) {
            this.name = name;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        public static Component parse(String str) {
            String name = null;
            int startIndex = 0;
            int endIndex = 0;

            int bracket = str.indexOf("[");
            int endBracket = str.indexOf("]");
            if (bracket < 0) {
                name = str;
                startIndex = -1;
            } else {
                name = str.substring(0, bracket);
                if (str.charAt(bracket + 1) == '*') {
                    startIndex = -1;
                    endIndex = -1;
                } else {
                    int i = bracket + 1;
                    for (; i < endBracket; i++) {
                        if (str.charAt(i) == ':')
                            break;
                        startIndex *= 10;
                        startIndex += str.charAt(i) - '0';
                    }
                    if (str.charAt(i) == ':') {
                        i++;
                        for (; i < endBracket; i++) {
                            endIndex *= 10;
                            endIndex += str.charAt(i) - '0';
                        }
                    } else {
                        endIndex = startIndex;
                    }
                }
            }

            return new Component(name, startIndex, endIndex);
        }

        public String toString() {
            StringBuffer buf = new StringBuffer();
            buf.append(name);
            buf.append("[");
            if (startIndex < 0) {
                buf.append("*");
            } else {
                buf.append(startIndex);
                if (endIndex > startIndex) {
                    buf.append(":");
                    buf.append(endIndex);
                }
            }
            buf.append("]");
            return buf.toString();
        }
    }

    public void set(List<Component> value);

    public List<Component> get();
}
