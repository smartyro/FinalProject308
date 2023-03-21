package View;

import javax.swing.*;
import java.awt.event.*;

public class fileMenu extends JMenu implements ActionListener{
    JMenuItem newItem;
    JMenuItem loadItem;
    JMenuItem saveItem;

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
