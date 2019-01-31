package be.manudahmen.empty3.library.tests.trikombat;

import be.manudahmen.empty3.*;
import be.manudahmen.empty3.core.export.STLExport;
import be.manudahmen.empty3.core.nurbs.CourbeParametriquePolynomialeBezier;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by manuel on 14-08-16.
 */
public abstract class IPersona extends RepresentableConteneur {
    public static final int TYPE_TRIS = 1;
    public static final int ROLE_AUTHOR = 1;
    protected TRIObject tris = new TRIObject();
    protected CourbeParametriquePolynomialeBezier ame;

    public IPersona(int persona_type) throws IOException {
        tris = PersonaFactory.create(ROLE_AUTHOR, persona_type);
        Scene sc = new Scene();
        ame = new CourbeParametriquePolynomialeBezier(new Point3D[]{Point3D.O0, Point3D.X, Point3D.X.plus(Point3D.Y)});
        sc.add(tris);
        STLExport.save(new File(String.format("rendered persona%s.STL", "" + "" + new Date().toInstant() + "" + Math.random())), sc, false);
    }

    public static void main(String[] args) throws IOException {
        new PersonaA(TYPE_TRIS);

    }

    public abstract TRIObject algo_constr()
            ;

    public Representable getObj() {
        return tris;

    }

    public Iterable<TRI> iterable() {
        return (Iterable<TRI>) tris.iterator();
    }
}
