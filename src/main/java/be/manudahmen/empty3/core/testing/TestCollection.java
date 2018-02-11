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
package be.manudahmen.empty3.core.testing;

import be.manudahmen.empty3.core.script.ExtensionFichierIncorrecteException;
import be.manudahmen.empty3.core.script.Loader;
import be.manudahmen.empty3.core.script.VersionNonSupporteeException;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Manuel DAHMEN
 */
public class TestCollection {

    private final ArrayList<TestObjet> tests = new ArrayList<TestObjet>();
    private boolean dr;

    public void add(final File fichier) {
        TestObjet to = new TestObjetSub() {


            @Override
            public void ginit() {
                try {
                    new Loader().load(fichier, scene());
                } catch (VersionNonSupporteeException ex) {
                    Logger.getLogger(TestCollection.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExtensionFichierIncorrecteException ex) {
                    Logger.getLogger(TestCollection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        add(to);

    }

    public void add(File[] fichiers) {
        for (File fichier : fichiers) {
            add(fichier);
        }
    }

    public void add(TestObjet to) {
        tests.add(to);
    }

    public void displayResult(boolean b) {
        this.dr = b;

    }

    public void run() {
        Iterator<TestObjet> it = tests.iterator();
        while (it.hasNext()) {
            TestObjet next = it.next();
            next.publishResult(dr);
            next.run();
        }
    }

    public void testCollection() {
        Iterator<TestObjet> it = tests.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
    }
}
