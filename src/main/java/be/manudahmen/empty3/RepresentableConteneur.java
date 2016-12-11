/*
 * Copyright (c) 2016. Tous les fichiers dans ce programme sont soumis à la License Publique Générale GNU créée par la Free Softxware Association, Boston.
 * La plupart des licenses de parties tièrces sont compatibles avec la license principale.
 * Les parties tierces peuvent être soumises à d'autres licenses.
 * Montemedia : Creative Commons
 * ECT : Tests à valeur artistique ou technique.
 * La partie RayTacer a été honteusement copiée sur le Net. Puis traduite en Java et améliorée.
 * Java est une marque de la société Oracle.
 *
 * Pour le moment le programme est entièrement accessible sans frais supplémentaire. Get the sources, build it, use it, like it, share it.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.manudahmen.empty3;

import java.util.*;

/**
 * @author Atelier
 */
public class RepresentableConteneur extends Representable {

    private Collection<Representable> re = Collections.synchronizedCollection(new ArrayList<Representable>());

    public RepresentableConteneur() {
    }

    public RepresentableConteneur(Representable[] r) {
        re.addAll(Arrays.asList(r));
    }

    public synchronized void add(Representable r) {
        re.add(r);
    }

    public synchronized void clear() {
        re.clear();
    }

    public synchronized Collection<Representable> getListRepresentable() {
        return re;
    }

    public Iterator<Representable> iterator() {
        return re.iterator();
    }

    public synchronized void remove(Representable r2) {
        re.remove(r2);
    }

    @Override
    public String toString() {
        String s = "conteneur (\n\n";

        Iterator<Representable> rs = iterator();

        while (rs.hasNext()) {
            Representable next = rs.next();

            s += next.toString();
        }

        s += "\n\n)\n\n";

        return s;
    }
}
