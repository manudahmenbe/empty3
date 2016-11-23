package be.manudahmen.empty3.library.object;

public interface ZBuffer3D extends ZBuffer {

    void genererEtRetourner(Scene sc);

    ECBufferedImage imageDroite();

    ECBufferedImage imageGauche();

    int LR();

    void LR(int lr);
}
