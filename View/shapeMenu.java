package View;

import javax.swing.*;

import Controller.ControlHandler;

import java.awt.event.*;

public class shapeMenu extends JMenu implements ActionListener {
    JMenuItem beginItem;
    JMenuItem endItem;
    JMenuItem callItem;
    JMenuItem instructItem;
    JMenuItem ioItem;
    JMenuItem varItem;
    JMenuItem condItem;

    public shapeMenu(String name) {
        setText(name);

        beginItem = new JMenuItem("Begin");
        beginItem.addActionListener(this);
        
        endItem = new JMenuItem("End");
        endItem.addActionListener(this);
        
        callItem = new JMenuItem("Call a Method");
        callItem.addActionListener(this);
        
        instructItem = new JMenuItem("Instruction");
        instructItem.addActionListener(this);

        ioItem = new JMenuItem("Input or Output");
        ioItem.addActionListener(this);

        varItem = new JMenuItem("Variable Declaration");
        varItem.addActionListener(this);

        condItem = new JMenuItem("Condition");
        condItem.addActionListener(this);

        add(beginItem);
        add(endItem);
        add(callItem);
        add(instructItem);
        add(ioItem);
        add(varItem);
        add(condItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == beginItem){
            ControlHandler.getInstance().setShape("Begin");
        } else if (e.getSource() == endItem) {
            ControlHandler.getInstance().setShape("End");
        } else if (e.getSource() == callItem) {
            ControlHandler.getInstance().setShape("Call a Method");
        } else if (e.getSource() == instructItem) {
            ControlHandler.getInstance().setShape("Instruction");
        } else if (e.getSource() == ioItem) {
            ControlHandler.getInstance().setShape("Input or Output");
        } else if (e.getSource() == varItem) {
            ControlHandler.getInstance().setShape("Variable Declaration");
        } else if (e.getSource() == condItem) {
            ControlHandler.getInstance().setShape("Condition");
        }
    }
    
}
