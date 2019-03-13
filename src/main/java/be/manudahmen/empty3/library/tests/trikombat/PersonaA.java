package be.manudahmen.empty3.library.tests.trikombat;

import be.manudahmen.empty3.TRIObject;

import java.io.IOException;

/**
 * Created by manuel on 14-08-16.
 */
public class PersonaA extends IPersona {
    public PersonaA(int persona) throws IOException {
        super(IPersona.ROLE_AUTHOR);
        switch (persona) {
            case 1:
        }
    }

    @Override
    public TRIObject algo_constr() {
        return null;
    }
}
