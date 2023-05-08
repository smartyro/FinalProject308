package View;

import javax.swing.*;

import Controller.ControlHandler;

public class Menu extends JMenuBar{
    JMenu fileMenu;
    JMenu shapeMenu;
    JMenu helpMenu;

    public Menu(ControlHandler controlHandler){
        fileMenu = new fileMenu("File");

        shapeMenu = new shapeMenu("Shape", controlHandler);

        helpMenu = new helpMenu("Help");

        add(fileMenu);
        add(shapeMenu);
        add(helpMenu);
    }
}
