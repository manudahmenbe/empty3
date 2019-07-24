package one.empty3.library;

import java.awt.*;

/**
 * Created by manue on 15-06-19.
 */
public class ZBufferGL implements ZBuffer {
    @Override
    public Camera camera() {
        return null;
    }

    @Override
    public Point coordonneesPoint2D(Point3D p) {
        return null;
    }

    @Override
    public Point3D coordonneesPoint3D(Point3D p) {
        return null;
    }

    @Override
    public void couleurDeFond(ITexture couleurFond) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void draw(Representable r) {

    }

    @Override
    public double distanceCamera(Point3D p) {
        return 0;
    }

    @Override
    public int getColorAt(Point p) {
        return 0;
    }

    @Override
    public ZBuffer getInstance(int x, int y) {
        return null;
    }

    @Override
    public ECBufferedImage image() {
        return null;
    }

    @Override
    public boolean isLocked() {
        return false;
    }

    @Override
    public void isobox(boolean isBox) {

    }

    @Override
    public void isometrique() {

    }

    @Override
    public void line(Point3D p1, Point3D p2, ITexture t) {

    }

    @Override
    public boolean lock() {
        return false;
    }

    @Override
    public void perspective() {

    }

    @Override
    public void plotPoint(Point3D p, Color c) {

    }

    @Override
    public int resX() {
        return 0;
    }

    @Override
    public int resY() {
        return 0;
    }

    @Override
    public Scene scene() {
        return null;
    }

    @Override
    public void scene(Scene s) {

    }

    @Override
    public void next() {

    }

    @Override
    public void testDeep(Point3D point3D) {

    }

    @Override
    public void testDeep(Point3D p, Color c) {

    }

    @Override
    public void testDeep(Point3D p, int c) {

    }

    @Override
    public void tracerLumineux() {

    }

    @Override
    public boolean unlock() {
        return false;
    }

    @Override
    public void zoom(float z) {

    }

    @Override
    public ITexture backgroundTexture() {
        return null;
    }

    @Override
    public void backgroundTexture(ITexture iTexture) {

    }

    @Override
    public int largeur() {
        return 0;
    }

    @Override
    public int hauteur() {
        return 0;
    }

    @Override
    public void setDimension(int width, int height) {

    }

    @Override
    public Point3D clickAt(double x, double y) {
        return null;
    }
}
