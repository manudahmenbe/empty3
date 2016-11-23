/*

 Vous êtes libre de :

 */
package be.manudahmen.empty3.library.object;

/**
 * @author MANUEL DAHMEN
 *         <p>
 *         dev
 *         <p>
 *         21 oct. 2011
 */
public class ID {

    private String name;

    public ID(String id) {
        this.name = id;
    }

    public static String GEN(Object o) {
        String id = "";
        if (o instanceof Representable) {
            id = "19780626-091-33-05h--" + o.getClass().getName() + "--"
                    + System.currentTimeMillis();
        }
        return id;
    }

    public String getName() {
        return name;
    }
}
