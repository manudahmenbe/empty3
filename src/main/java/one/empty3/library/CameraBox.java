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
package one.empty3.library;

/**
 * @author Manuel DAHMEN
 * @date
 */
public class CameraBox extends Representable {

    public static final int PERSPECTIVE_ISOMETRIQUE = 1;
    public static final int PERSPECTIVE_POINTDEFUITE = 1;
    private StructureMatrix<Double> angleX = new StructureMatrix<>(0);
    private StructureMatrix<Double> angleY = new StructureMatrix<>(0);
    private int type = PERSPECTIVE_POINTDEFUITE;

    public CameraBox() {

        angleX.setElem(Math.PI *2/360*60);
        angleY.setElem(Math.PI *2/360*60);
    }

    public Double getAngleX() {
        return angleX.getElem();
    }

    public void setAngleX(Double angleX) {
        this.angleX.setElem(angleX);
    }

    public void angleXr(double angleX, double ratioXY) {
        this.angleX.setElem(angleX);
        this.angleY.setElem(angleX / ratioXY);
    }

    public void angleXY(double angleX, double angleY) {
        this.angleX.setElem(angleX);
        this.angleY .setElem(angleY);
    }

    public Double getAngleY() {
        return angleY.getElem();
    }

    public void setAngleY(Double angleY) {
        this.angleY.setElem(angleY);
    }

    public void setAngleYr(double angleY, double ratioXY) {
        this.angleY .setElem( angleY);
        this.angleX .setElem( angleY * ratioXY);
    }

    public void perspectiveIsometrique() {
        this.type = PERSPECTIVE_ISOMETRIQUE;
    }

    public void perspectivePointDeFuite() {
        this.type = PERSPECTIVE_POINTDEFUITE;
    }

    public int type() {
        return type;
    }

    public void viserObjet(Representable r) {
        throw new UnsupportedOperationException("Non supportée");
    }

    @Override
    public void declareProperties() {
        super.declareProperties();
        getDeclaredDataStructure().put("angleX/angle horizontal caméra", angleX);
        getDeclaredDataStructure().put("angleY/angle vertical caméra", angleY);

    }
}
