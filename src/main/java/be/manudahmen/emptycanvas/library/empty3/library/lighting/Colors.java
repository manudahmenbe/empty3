/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.manudahmen.emptycanvas.library.empty3.library.lighting;

import java.awt.*;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class Colors {
    public static Color random() {
        return new Color(
                (float) Math.random(),
                (float) Math.random(),
                (float) Math.random()
        );
    }
}
