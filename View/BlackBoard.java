package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * Final Project 308.
 * 
 * @author 
 */

public class BlackBoard extends JFrame implements ActionListener{
    public static BlackBoard blackboard;
    public static void main(String [] args)
    {
        BlackBoard main = new BlackBoard();
        main.setSize(600,400);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    /**
     * Constructor for BlackBoard.
     */
    public BlackBoard() {

        JPanel central = new JPanel();
        central.setBackground(Color.BLUE);
        GridLayout grid = new GridLayout(7,1);
        central.setLayout(grid);
        BorderLayout layout = new BorderLayout();
        add(central, BorderLayout.CENTER);
    }

    /**
     * Implemented Method from ActionListener class that allows the program to
     * acces the button that has been clicked to invoke an action.
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
    }

}
