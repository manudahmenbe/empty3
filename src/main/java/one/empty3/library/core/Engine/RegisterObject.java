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

package one.empty3.library.core.Engine;

import one.empty3.library.*;

import java.lang.reflect.Method;

/**
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class RegisterObject {
    public class Entry {
        private Class<Representable> class3d;
        private boolean positionnable;
        private boolean rotatable;
        private boolean moveable;
        private boolean sizable;
        private Method positionnableSpecialMethod;
        private Method rotatableSpecialMethod;
        private Method moveableSpecialMethod;
        private Method sizableSpecialMethod;

        public Entry(Class<Representable> class3d, boolean positionnable, boolean rotatable, boolean moveable, boolean sizable, Method positionnableSpecialMethod, Method rotatableSpecialMethod, Method moveableSpecialMethod, Method sizableSpecialMethod) {
            this.class3d = class3d;
            this.positionnable = positionnable;
            this.rotatable = rotatable;
            this.moveable = moveable;
            this.sizable = sizable;
            this.positionnableSpecialMethod = positionnableSpecialMethod;
            this.rotatableSpecialMethod = rotatableSpecialMethod;
            this.moveableSpecialMethod = moveableSpecialMethod;
            this.sizableSpecialMethod = sizableSpecialMethod;
        }


        public Class<Representable> getClass3d() {
            return class3d;
        }

        public boolean isPositionnable() {
            return positionnable;
        }

        public boolean isRotatable() {
            return rotatable;
        }

        public boolean isMoveable() {
            return moveable;
        }

        public Method getPositionnableSpecialMethod() {
            return positionnableSpecialMethod;
        }

        public Method getRotatableSpecialMethod() {
            return rotatableSpecialMethod;
        }

        public Method getMoveableSpecialMethod() {
            return moveableSpecialMethod;
        }

        public Method getSizableSpecialMethod() {
            return sizableSpecialMethod;
        }


    }


}
