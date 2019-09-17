package one.empty3.library;

/**
 * Created by manue on 28-05-19.
 */
public abstract class TextureOp2D extends ITexture {
    protected ITexture upText;

    @Override
    public void iterate() throws EOFVideoException {

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
