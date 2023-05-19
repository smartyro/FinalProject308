package View;

import Model.Repository;
import Model.RepositoryInterface;

import javax.swing.*;
import java.awt.event.*;

public class fileMenu extends JMenu implements ActionListener{
    JMenuItem newItem;
    JMenuItem loadItem;
    JMenuItem saveItem;

    /**
     * Creates new fileMenu
     * @param name
     */
    public fileMenu(String name){
        setText(name);
        
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);

        saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);

        loadItem = new JMenuItem("Load");
        loadItem.addActionListener(this);

        add(newItem);
        add(saveItem);
        add(loadItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem){
            RepositoryInterface.getRepository().clear();
        } else if (e.getSource() == saveItem){
            String key = JOptionPane.showInputDialog("Enter a name for your Diagram:");
            RepositoryInterface.getRepository().saveShapes(key);
        } else if (e.getSource() == loadItem){
            String key = JOptionPane.showInputDialog("Enter the name of a saved Diagram:");
            RepositoryInterface.getRepository().loadShapes(key);
        }
    }
    
}
