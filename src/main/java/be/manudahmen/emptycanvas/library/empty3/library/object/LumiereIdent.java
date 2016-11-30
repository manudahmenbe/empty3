package be.manudahmen.emptycanvas.library.empty3.library.object;

public class LumiereIdent implements Lumiere {

    @Override
    public ITexture getCouleur(ITexture base1, Point3D p, Point3D n) {
        return getCouleur(p.texture(), p, p.getNormale());
    }

}
