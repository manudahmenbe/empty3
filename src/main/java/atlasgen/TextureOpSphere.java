package atlasgen;

import one.empty3.library.EOFVideoException;
import one.empty3.library.ITexture;
import one.empty3.library.TextureOp2D;

/**
 * Created by manue on 10-05-19.
 */
public class TextureOpSphere extends TextureOp2D {
    public TextureOpSphere(ITexture up) {
        setUpText(up);
    }

    @Override
    public void iterate() throws EOFVideoException {

    }

    @Override
    public void timeNext() {

    }

    @Override
    public void timeNext(long milli) {

    }

    @Override
    public int getColorAt(double u, double v) {
        return upText.getColorAt(u, 1 - v);
    }
}
