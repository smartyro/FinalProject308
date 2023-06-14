package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class helpMenu extends JMenu implements ActionListener {
    JMenuItem docItem;
    JMenuItem tutItem;
    JMenuItem chatItem;
    Chat chat;
    private int remainingQs;

    public helpMenu(String name) {
        setText(name);
        remainingQs = 3;

        docItem = new JMenuItem("Documentation");
        docItem.addActionListener(this);

        tutItem = new JMenuItem("Tutorial");
        tutItem.addActionListener(this);

        chatItem = new JMenuItem("Ask ChatGPT");
        chatItem.addActionListener(this);

        add(docItem);
        add(tutItem);
        add(chatItem);

        chat = new Chat("Default input");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tutItem) {
            createTutorial();
        } else if (e.getSource() == docItem) {
            String message = "The authors of this program are Liam Hyde, Keila Mohan, Jared Swislow, Anna Rosenberg, Gavid Stoddard, and Sophie Martyrossian.\n"
                    +
                    "This application was developed for Cal Poly's CSC 309 Software Engineering II class, taught by Professor Gonzalez-Sanchez, Spring Quarter 2023. \n";
            JOptionPane.showConfirmDialog(null, message, "Documentation", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE);
        } else if (e.getSource() == chatItem) {
            String response = null;
            if (remainingQs > 0) {
                String input = JOptionPane.showInputDialog(null,
                        "Ask me a question! You have " + remainingQs + " questions remaining.", null,
                        JOptionPane.PLAIN_MESSAGE);

                try {
                    response = chat.getResponse(input);
                } catch (Exception ex) {
                    JOptionPane.showConfirmDialog(null, "An error occurred while communicating with ChatGPT.", "Error",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null,
                        "Your input is '" + input + "'!\n" + "ChatGPT's Response is: " + response, "ChatGPT's Response",
                        JOptionPane.PLAIN_MESSAGE);
                --remainingQs;
            } else {
                JOptionPane.showConfirmDialog(null, "You are all out of questions. Please try again.", "ERROR!",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    public void createTutorial() {
        String message = "Welcome to the Functional Flow Block Diagram Tutorial!\n\n" +
                "The shapes for the program is as follows: \n"
                +
                "BEGIN SHAPE and END SHAPE are always a CIRCLE. Every program will have a start and end shape. \n"
                +
                "CONDITION SHAPE is a DIAMOND. This is used when there is a condition to be met, such as if a value is greater or less than another\n"
                +
                "METHOD SHAPE is a RECTANGLE WITH VERTICAL LINES. This is used when you are declaring a method, such as 'void message()'\n"
                +
                "INSTRUCTION SHAPE is a PLAIN RECTANGLE. This is used when you are performing an instruction, such as add.\n"
                +
                "INPUT OR OUTPUT is a PARALLELOGRAM. This is used when you are printing, or receiving user input.\n"
                + 
                "VARIABLE DECLARATION is a RECTANGLE WITH A HORIZONTAL AND VERTICAL LINE. This is used for declaring a variable, such as 'int x = 5;'\n"
                +
                "\nGood luck!";
        JOptionPane.showConfirmDialog(null, message, "Tutorial", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
    }
}
