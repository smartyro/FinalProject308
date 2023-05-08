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
    private ControlHandler controlHandler;

    /**
     * Creates new shapeMenu for the JMenu
     * @param name
     */
    public shapeMenu(String name, ControlHandler controlHandler) {
        this.controlHandler = controlHandler;

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
            controlHandler.setShape(ShapeType.BEGIN);
        } else if (endItem.equals(source)) {
            controlHandler.setShape(ShapeType.END);
        } else if (callItem.equals(source)) {
            controlHandler.setShape(ShapeType.CALL);
        } else if (instructItem.equals(source)) {
            controlHandler.setShape(ShapeType.INSTRUCTION);
        } else if (ioItem.equals(source)) {
            controlHandler.setShape(ShapeType.IO);
        } else if (varItem.equals(source)) {
            controlHandler.setShape(ShapeType.VARIABLE);
        } else if (condItem.equals(source)) {
            controlHandler.setShape(ShapeType.CONDITION);
        }
    }
    
}
