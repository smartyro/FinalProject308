package View;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JMenuBar implements ActionListener{
    JMenu fileMenu;
    JMenu helpMenu;
    JMenuItem newItem;
    JMenuItem loadItem;
    JMenuItem saveItem;

    public Menu(){
        fileMenu = new JMenu("File");

        helpMenu = new JMenu("Help");

        newItem = new JMenuItem("New");
        newItem.addActionListener(this);

        loadItem = new JMenuItem("Load");
        loadItem.addActionListener(this);

        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);

        fileMenu.add(newItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);

        add(fileMenu);
        add(helpMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem){
            Repository.getRepository().clearShapes();
        } else if (e.getSource() == saveItem){
            String key = JOptionPane.showInputDialog("Enter a name for your Diagram:");
            Repository.getRepository().saveShapes(key);
        } else if (e.getSource() == loadItem){
            String key = JOptionPane.showInputDialog("Enter the name of a saved Diagram:");
            Repository.getRepository().loadShapes(key);
        }
    }
}
