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

 Vous êtes libre de :

 */
package be.manudahmen.empty3.core.tribase;

public class Instance {

    private BaseGenerator instance;
    private ThreadInstance thread;

    public Instance(BaseGenerator bg, Params params) {
        instance = bg;
        thread = new ThreadInstance(params);
        thread.start();
    }

    public void kill() {
        thread.setStopped(true);
        thread.setKilled(true);
    }

    public void pauseInstance() {
        thread.setPaused(true);
    }

    public void restartInstance() {
        thread.setStopped(true);
        thread.setStarted(true);
    }

    public void startInstance() {
        thread.setStarted(true);
    }

    public void stopInstance() {
        thread.setStopped(true);
    }

    private class ThreadInstance extends Thread {

        private boolean started = false;
        private boolean stopped = false;
        private boolean paused = false;
        private boolean killed = false;

        public ThreadInstance(Params params) {
            instance.setParams(params);
        }

        public void run() {
            while (!killed) {

                while (!stopped & started & !paused) {
                    instance.initFrame();
                    instance.computeFrame();
                    instance.showFrame();
                    instance.computeFrame();
                }
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setKilled(boolean killed) {
            this.killed = killed;
        }

        public void setPaused(boolean paused) {
            this.paused = paused;
        }

        public void setStarted(boolean started) {
            this.started = started;
        }

        public void setStopped(boolean stopped) {
            this.stopped = stopped;
        }

    }
}
