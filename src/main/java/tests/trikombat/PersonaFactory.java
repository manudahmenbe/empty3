package tests.trikombat;

import be.manudahmen.empty3.Point3D;
import be.manudahmen.empty3.TRI;
import be.manudahmen.empty3.TRIObject;

import java.awt.*;

/**
 * Created by manuel on 14-08-16.
 */
public class PersonaFactory {

    private static int MAxJ;

    public static TRIObject create(int persona_type, int persona) {
        TRIObject tris = new TRIObject();
        double MaxI = 60, MaxJ = 60, MaxK = 60;
        switch (persona_type) {
            case IPersona.ROLE_AUTHOR:
                for (double i = 1; i < MaxI; i++) {
                    for (double j = 1; j < MaxJ; j++)
                        for (double k = 1; k < MaxK; k++) {
                            tris.add(new TRI(
                                    new Point3D(k / MaxK * 10, j * Math.PI * Math.cos(2 * Math.PI * i * MaxJ * MAxJ / MaxJ / MaxI) * Math.cos(2 * Math.PI * MaxI * j / MaxI / MaxJ), 2 * Math.PI * Math.cos(2 * Math.PI * j * MaxI / MaxJ / MaxI) * Math.cos(2 * Math.PI * j * MaxI) * MaxI),
                                    new Point3D(k / MaxK * 10, j * Math.PI * Math.sin(2 * Math.PI * i * MaxJ * MAxJ / MaxJ / MaxI) * Math.sin(2 * Math.PI * MaxI * j / MaxI / MaxJ), 2 * Math.PI * Math.sin(2 * Math.PI * j * MaxI / MaxJ / MaxI) * Math.sin(2 * Math.PI * j * MaxI) * MaxI),
                                    new Point3D(k / MaxK * 10, j * Math.PI * Math.sin(2 * Math.PI * i * MaxJ * MAxJ / MaxJ / MaxI) * Math.sin(2 * Math.PI * MaxI * j / MaxI / MaxJ), 2 * Math.PI * Math.sin(2 * Math.PI * j * MaxI / MaxJ / MaxI) * Math.sin(2 * Math.PI * j * MaxI) * MaxI)
                                    , Color.BLUE));

                        }
                }
                break;
        }
        return tris;
    }
}