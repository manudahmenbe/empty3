package be.manudahmen.empty3.nnio;

/**
 * Created by Win on 29-08-18.
 */
public interface CreationsManager {
    void connectTo(MediaServer mediaServer);

    void createSpace();

    void createDirectory();

    void mvTo();

    void save();

    void load(Creation x);
}
