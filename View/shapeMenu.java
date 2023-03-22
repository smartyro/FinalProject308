package View;

import javax.swing.*;

import Controller.ControlHandler;
import Model.ShapeType;

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
        Object source = e.getSource();
        if (beginItem.equals(source)) {
            ControlHandler.getInstance().setShape(ShapeType.BEGIN);
        } else if (endItem.equals(source)) {
            ControlHandler.getInstance().setShape(ShapeType.END);
        } else if (callItem.equals(source)) {
            ControlHandler.getInstance().setShape(ShapeType.CALL);
        } else if (instructItem.equals(source)) {
            ControlHandler.getInstance().setShape(ShapeType.INSTRUCTION);
        } else if (ioItem.equals(source)) {
            ControlHandler.getInstance().setShape(ShapeType.IO);
        } else if (varItem.equals(source)) {
            ControlHandler.getInstance().setShape(ShapeType.VARIABLE);
        } else if (condItem.equals(source)) {
            ControlHandler.getInstance().setShape(ShapeType.CONDITION);
        }
    }
    
}
