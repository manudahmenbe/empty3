/*
 Vous êtes libre de :
 */
package be.manudahmen.empty3.library.script;

import be.manudahmen.empty3.library.object.Representable;
import be.manudahmen.empty3.library.object.Scene;

import java.io.*;

public class ModeleIO {

    public static boolean sauvergarder(Representable o, File file) {
        boolean r = false;
        ObjectOutputStream dos = null;
        FileOutputStream fos = null;
        try {
            dos = new ObjectOutputStream(fos = new FileOutputStream(file));
            r = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return r;
    }

    public static boolean sauvergarder(Scene sc, File file) {
        boolean r = false;
        ObjectOutputStream dos = null;
        FileOutputStream fos = null;
        try {
            sc.dumpDATA();
            fos = new FileOutputStream(file);
            dos = new ObjectOutputStream(fos);
            r = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.writeObject(sc);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return r;
    }

    public static boolean sauvergarderTXT(Scene sc, File file) {
        String txt = sc.toString();
        boolean r = false;
        FileOutputStream dos = null;
        BufferedOutputStream pw = null;
        try {
            dos = new FileOutputStream(file);
            pw = new BufferedOutputStream(dos);
            pw.write(txt.getBytes(), 0, txt.length());
            pw.close();
            dos.close();
            r = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                pw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return r;
    }

    public Scene charger(Scene sc, File file) {
        boolean r = false;
        ObjectInputStream dos = null;
        try {
            dos = new ObjectInputStream(new FileInputStream(file));
            r = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return (Scene) dos.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }
}
