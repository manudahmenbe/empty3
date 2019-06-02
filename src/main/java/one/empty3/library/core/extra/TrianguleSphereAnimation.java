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

/*

 Vous êtes libre de :

 */
package one.empty3.library.core.extra;

/**
 * @author MANUEL DAHMEN
 * <p>
 * dev
 * <p>
 * 28 déc. 2011
 */
/*
 public class TrianguleSphereAnimation extends Animation {
 private TRIObject o;
 int n = 2;

 public TrianguleSphereAnimation(Scene s) {
 super(s);
 }

 public void modifier() {
 o = new TRIObject();
 double a = 0, b = 0, R = 10;
 n++;
 Point3D[][] pcurrent = null;
 if (n > 1) {
 pcurrent = new Point3D[n][n];

 int i = 0;
 for (b = 0; b < Math.PI; b += Math.PI / n) {
 int j = 0;
 for (a = -Math.PI; a < Math.PI; a += Math.PI / n) {
 if (i < n && j < n)
 pcurrent[i][j] = new Point3D(R * Math.cos(a)
 * Math.cos(b), R * Math.cos(a) * Math.sin(b), R
 * Math.sin(a));
 j++;

 }
 i++;
 }
 }

 for (int i1 = 0; i1 < n - 1; i1++)
 for (int j = 0; j < n - 1; j++) {
 o.add(new TRI(pcurrent[i1][j], pcurrent[i1][j + 1],
 pcurrent[i1 + 1][j + 1], Color.black));
 o.add(new TRI(pcurrent[i1 + 1][j], pcurrent[i1 + 1][j],
 pcurrent[i1 + 1][j + 1], Color.black));
 }
 Scene s = new Scene();
 s.add(o);
 scene(s);
 }

	
 }
 */
