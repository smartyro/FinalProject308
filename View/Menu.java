package View;

import javax.swing.*;

public class Menu extends JMenuBar{
    JMenu fileMenu;
    JMenu shapeMenu;
    JMenu helpMenu;

    public Menu(){
        fileMenu = new fileMenu("File");

        shapeMenu = new shapeMenu("Shape");

        helpMenu = new helpMenu("Help");

        add(fileMenu);
        add(shapeMenu);
        add(helpMenu);
    }
}
