package one.empty3.apps.opad;

import one.empty3.apps.opad.menu.ToggleMenu;
import one.empty3.library.LineSegment;
import one.empty3.library.Point2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public abstract class Drawer {


    protected ToggleMenu toggleMenu =new ToggleMenu();
    //protected Plotter3D plotter3D;
    private Class level;

    public abstract void setLogic(PositionUpdate l);

    public void initFrame(Frame component) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame.setDefaultLookAndFeelDecorated(true);

        JMenuBar jMenuBar = new JMenuBar();

        jMenuBar.add(new JMenu("Game"));

        component.add(jMenuBar);

        screenSize.setSize(screenSize.getWidth()/2, screenSize.getHeight()/2);

        component.setSize(screenSize);
        /*
        toggleMenu.setDisplaySky(true);
        toggleMenu.setDisplayGround(true);
        toggleMenu.setDisplayGroundGrid(true);
        */
    }

    /*__
     *
     * @param p Point 2D in the window (mouse cordinates)
     * @return Segment Near Far direction of click
     */
    public abstract LineSegment click(Point2D p);

    public void setToggleMenu(ToggleMenu toggleMenu) {
        this.toggleMenu = toggleMenu;
    }

    /*public void setPlotter3D(Plotter3D plotter3D) {
        this.plotter3D  = plotter3D;
    }*/

    public Class getLevel() {
        return level;
    }

    public void setLevel(Class level) {
        this.level = level;
        Logger.getAnonymousLogger().info("Level: " + level.getCanonicalName());
    }

}
