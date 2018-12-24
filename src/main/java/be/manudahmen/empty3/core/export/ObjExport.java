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

/**
 * *
 * Global license : * GNU GPL v3
 * <p>
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 * <p>
 * Creation time 25-oct.-2015 SURFACE D'ÉLASTICITÉ DE FRESNEL Fresnel's
 * elasticity surface, Fresnelsche Elastizitätfläche
 * http://www.mathcurve.com/surfaces/elasticite/elasticite.shtml *
 */
package be.manudahmen.empty3.core.export;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.nurbs.ParametricSurface;
import be.manudahmen.empty3.core.tribase.TRIGenerable;
import be.manudahmen.empty3.core.tribase.TRIObjetGenerateur;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class ObjExport {
    public class Object {
        private List<Face> faces;
    }

    public class Vertex {
        private double x, y, z;
    }

    public class VertexTexture {
        private double u, v;
    }

    public class VertexNormal {
        private double vx, vy, vz;
    }

    public class Face {
        private Vertex v;
        private VertexTexture vt;
        private VertexNormal vn;

    }


    public static void save(File file, Scene scene, boolean override)
            throws IOException {
        if (!file.exists() || file.exists() && override) {
            file.createNewFile();
            PrintWriter pw = new PrintWriter(new FileOutputStream(file));

            pw.println("o " + scene.description);

            Iterator<Representable> it = scene.iterator();

            while (it.hasNext()) {
                Representable r = it.next();

                traite(r, pw);
            }

            pw.close();
        }
    }

    private static void traite(Polygon r, PrintWriter pw) {
        for (int s = 0; s < r.getPoints().size(); s++) {
            write("t ", pw);
            for (int c = 0; c < 3; c++) {
                double A = r.getPoints().get(s).get(c);
                if (Double.isNaN(A)) {
                    A = 0;
                }
                write(A + " ", pw);
            }

            write("\n", pw);
        }
    }

    private static void traite(Representable r, PrintWriter pw) {
        write("", pw);

        if (r instanceof RepresentableConteneur) {
            traite((RepresentableConteneur) r, pw);
        }
        if (r instanceof ParametricSurface) {
            traite((ParametricSurface) r, pw);
        }
        if (r instanceof TRIObject) {
            traite((TRIObject) r, pw);
        }
        if (r instanceof TRIGenerable) {
            traite((TRIGenerable) r, pw);
        }
        if (r instanceof Polygon) {
            traite((Polygon) r, pw);
        }
        if (r instanceof TRI) {
            traite((TRI) r, pw);
        }
        if (r instanceof TRIObjetGenerateur) {
            traite((TRIObjetGenerateur) r, pw);
        }
        if (r instanceof TRIConteneur) {
            traite((TRIConteneur) r, pw);
        }
    }

    private static void traite(ParametricSurface r, PrintWriter pw) {
        write("", pw);
        for (double u = 0; u < r.getEndU(); u += r.incr1())
            for (double v = 0; v < r.getEndV(); v += r.incr2())
                traite(r.getElementSurface(u,
                        u + r.getIncrU(),
                        v, v + r.getIncrV()), pw);

    }

    private static void traite(RepresentableConteneur r, PrintWriter pw) {
        write("", pw);
        Iterator<Representable> it = r.iterator();
        while (it.hasNext()) {
            Representable next = it.next();
            traite(next, pw);
        }
    }

    private static void traite(TRI r, PrintWriter pw) {
        for (int s = 0; s < 3; s++) {
            write("f ", pw);
            for (int c = 0; c < 3; c++) {
                double A = r.getSommet()[s].get(c);
                if (Double.isNaN(A)) {
                    A = 0;
                }
                write(A + " ", pw);
            }
            write("\n", pw);
        }


        write("f 1/1/2", pw);
        write(" 2/2/2", pw);
        write(" 3/3/3\n", pw);
    }

    public static void traite(TRIConteneur TC, PrintWriter pw) {
        write("", pw);

        Iterator<TRI> it = TC.iterable().iterator();

        while (it.hasNext()) {
            TRI t = it.next();

            traite(t, pw);
        }
    }

    private static void traite(TRIGenerable r, PrintWriter pw) {
        r.generate();
    }

    private static void traite(TRIObject r, PrintWriter pw) {
        String s = "";
        Iterator<TRI> it = r.getTriangles().iterator();
        while (it.hasNext()) {

            traite(it.next(), pw);
        }
    }

    private static void traite(TRIObjetGenerateur r, PrintWriter pw) {
        String s = "";
        int x = r.getMaxX();
        int y = r.getMaxY();
        TRI[] tris = new TRI[2];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                r.getTris(i, j, tris);
                traite(tris[0], pw);
                traite(tris[1], pw);

            }
        }
    }

    public static void write(String flowElement, PrintWriter pw) {
        pw.write(flowElement);
    }
}
