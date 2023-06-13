package View;

import javax.swing.*;

import Controller.ControlHandler;
import Model.CheckDiagram;
import Model.Repository;
import Model.RepositoryInterface;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Menu extends JMenuBar implements Observer {
    JMenu fileMenu;
    JMenu shapeMenu;
    JMenu helpMenu;
    JMenu badgeMenu;
    private static final Color myColor = new Color(217, 217, 217);

    public Menu(ControlHandler controlHandler){
        setBackground(myColor);
        fileMenu = new fileMenu("File");

        shapeMenu = new shapeMenu("Shape", controlHandler);

        helpMenu = new helpMenu("Help");
    
        badgeMenu = new JMenu("");
        
        RepositoryInterface.getRepository().addObserver(this);

        add(fileMenu);
        add(shapeMenu);
        add(helpMenu);
        add(badgeMenu);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        int level = CheckDiagram.getLevel();
        
        if(level >= 10) {
            badgeMenu.setIcon(new ImageIcon("src/main/resources/badge_gold.png"));
        } else if (level >= 5) {
            badgeMenu.setIcon(new ImageIcon("src/main/resources/badge_silver.png"));
        } else if (level >= 1) {
            badgeMenu.setIcon(new ImageIcon("src/main/resources/badge_bronze.png"));
        }
    }
}
