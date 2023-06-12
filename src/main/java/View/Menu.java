package View;

import javax.swing.*;

import Controller.ControlHandler;

import java.awt.*;

public class Menu extends JMenuBar{
    JMenu fileMenu;
    JMenu shapeMenu;
    JMenu helpMenu;
    private static final Color myColor = new Color(217, 217, 217);

    public Menu(ControlHandler controlHandler){
        setBackground(myColor);
        fileMenu = new fileMenu("File");

        shapeMenu = new shapeMenu("Shape", controlHandler);

        helpMenu = new helpMenu("Help");

        add(fileMenu);
        add(shapeMenu);
        add(helpMenu);
    }
}
