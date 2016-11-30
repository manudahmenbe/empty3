import be.manudahmen.emptycanvas.library.empty3.library.object.Representable;

import java.awt.*;

public interface DegradeCouleur {

    Color color(float[] params01);

    void dim(int[] params);

    Representable objet3D();
}
