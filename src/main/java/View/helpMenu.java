package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class helpMenu extends JMenu implements ActionListener{
    JMenuItem docItem;
    JMenuItem tutItem; 

    public helpMenu(String name){
        setText(name);

        docItem = new JMenuItem("Documentation");
        docItem.addActionListener(this);

        tutItem = new JMenuItem("Tutorial");
        tutItem.addActionListener(this);

        add(docItem);
        add(tutItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tutItem){
            createTutorial();
        }
        if (e.getSource() == docItem){
            String message = "The authors of this program are Liam Hyde, Keila Mohan, Jared Swislow, Anna Rosenberg, Gavid Stoddard, and Sophie Martyrossian.\n This application was developed for Cal Poly's CSC 309 Software Engineering II class, taught by Professor Gonzalez-Sanchez, Spring Quarter 2023. \n";
            JOptionPane.showConfirmDialog(null, message, "Documentation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void createTutorial(){
        String message = "Welcome to the Functional Flow Block Diagram Tutorial!\n" + 
        "The shapes for the program is as follows: \n" + 
        "Begin Shape and End Shape is always a circle. Every program will have a start and end shape. \n" + 
        "Condition Shape is a diamond. This is used when there is a condition to be met, such as if a value is greater or less than another\n" +
        "Method Shape is a rectangle with vertical lines. This is used when you are declaring a method, such as 'void message()'\n" +
        "Instruction Shape is a rectangle without vertical lines. This is used when you are performing an instruction, such as add.\n" + 
        "Input or Output is a parallelogram. This is used when you are printing, or receiving user input.\n" + 
        "Variable Declaration is a rectangle with a horizontal and vertical line. This is used for declaring a variable, such as 'int x = 5;'\n" +
        "Good luck!";
        JOptionPane.showConfirmDialog(null, message, "Tutorial", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE); 
    }
}
