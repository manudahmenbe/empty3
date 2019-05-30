package be.manudahmen.empty3.core;

import be.manudahmen.empty3.EOFVideoException;
import be.manudahmen.empty3.ITexture;

import java.awt.*;

/**
 * Created by manue on 28-05-19.
 */
public abstract class TextureOp2D extends ITexture {
    protected ITexture upText;

    @Override
    public void iterate() throws EOFVideoException {

    }

    @Override
    public Color getMaillageTexturedColor(int numQuadX, int numQuadY, double u, double v) {
        return null;
    }

    @Override
    public void timeNext() {

    }

    @Override
    public void timeNext(long milli) {

    }

    public abstract int getColorAt(double u, double v);

    public void setUpText(ITexture upText) {
        this.upText = upText;
    }
}
