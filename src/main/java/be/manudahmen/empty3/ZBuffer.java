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
 * Global license : * Microsoft Public Licence
 * <p>
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 * <p>
 * *
 */
package be.manudahmen.empty3;

import java.awt.*;

/**
 * *
 * Rendu graphique
 *
 * @author Manuel Dahmen
 */
public interface ZBuffer {

    /**
     * Retourne la caméra de la scène virtuelle
     *
     * @return camera used for display
     */
    Camera camera();

    /**
     * Fixe une caméra dans la scène virtuelle L'appel est inutile si la
     * cameraActive de la scène est définie.
     *
     * @param c
     */
    void camera(Camera c);

    Point3D camera(Point3D p);

    /**
     * Coordonnées du point sur écran
     *
     * @param p point dans l'espace en 3 dim
     * @return point en coordonnées Image
     */
    Point coordonneesPoint2D(Point3D p);

    /**
     * *
     * ???
     *
     * @param p
     * @param zdistance
     * @return
     */
    Point3D coordonneesPoint3D(Point p, double zdistance);

    /**
     * *
     * Définit couleur de fond
     *
     * @param couleurFond
     */
    void couleurDeFond(ITexture couleurFond);

    /**
     * @deprecated
     */
    @Deprecated
    void dessinerContours();

    /**
     * @deprecated
     */
    @Deprecated
    void dessinerSilhouette();

    /**
     * Dessine la scène complète
     */
    void draw();

    /**
     * Ajoute un objet à l'image... (le dessine si tout est bien initialisé
     *
     * @param r         Objet à ajouter
     * @param refObject Objet de référence pour le déplacement et la rotation
     */
    void draw(Representable r, Representable refObject);

    void dessinerStructure();

    /**
     * Distance à la caméra ???
     *
     * @param p
     * @return
     */
    double distanceCamera(Point3D p);

    Color getColorAt(Point p);

    /**
     * *
     * Instancie un zbuffer. Si l'instance demandée (x, y) existe déjà, elle est
     * retournée.
     *
     * @param x largeur (resx)
     * @param y hauteur (resy)
     * @return instance
     */
    ZBuffer getInstance(int x, int y);

    /**
     * *
     * Retourne l'objet situé en (x,y)
     *
     * @param p
     * @return
     */
    Representable getObjectAt(Point p);

    /**
     * Retourne l'image, après dessin par draw
     *
     * @return image
     */
    ECBufferedImage image();

    /**
     * Verrou
     *
     * @return Verrou?
     */
    boolean isLocked();

    void isobox(boolean isBox);

    /**
     * Rendu en 3D isométrique
     */
    void isometrique();

    /**
     * Verouille le zbuffer pendant les calculs.
     *
     * @return false si le zbuffer a été préalablement verrouillé. true si
     * verrouillage par appel de cette méthode.
     */
    boolean lock();

    /**
     * Rendu en 3D caméra-oeil
     */
    void perspective();

    /**
     * Dessine un point
     *
     * @param p point
     * @param c couleur
     */
    void plotPoint(Point3D p, Color c);

    /**
     * *
     * Résolution X
     *
     * @return résolution x
     */
    int resX();

    /**
     * Résolution Y
     *
     * @return résolution y
     */
    int resY();

    /**
     * Retourne la scène en cours de traitement
     *
     * @return scene
     */
    Scene scene();

    /**
     * Assigne une nouvelle scène
     *
     * @param s scene
     */
    void scene(Scene s);

    /**
     * Passe une nouvelle image
     */
    void suivante();

    /**
     * Teste le point p
     *
     * @param point3D point
     */
    void testPoint(Point3D point3D);

    /**
     * Dessine un point
     *
     * @param p point
     * @param c couleur
     */
    void testPoint(Point3D p, Color c);

    void tracerLumineux();

    /**
     * Déverrouille le zbuffer
     *
     * @return true si déverrouillage. False si non-verrouillé
     */
    boolean unlock();

    /**
     * Ajuste le facteur de zoom (cadre) en 3D isométrique
     *
     * @param z
     */
    void zoom(float z);

    void backgroundTexture(ITexture tex);

    int largeur();

    int hauteur();
}
