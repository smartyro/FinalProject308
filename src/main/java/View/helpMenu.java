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
        //add(tutItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tutItem){
            add(createTutorial());
        }
        if (e.getSource() == docItem){
            String message = "The authors of this program are Liam Hyde, Keila Mohan, Jared Swislow, Anna Rosenberg, Gavid Stoddard, and Sophie Martyrossian.\n This application was developed for Cal Poly's CSC 309 Software Engineering II class, taught by Professor Gonzalez-Sanchez, Spring Quarter 2023. \n";
            JOptionPane.showConfirmDialog(null, message, "Documentation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
        }
    }

    public JInternalFrame createTutorial(){
        JInternalFrame tutorial = new JInternalFrame();
        tutorial.setClosable(true);
        tutorial.setResizable(true);
        tutorial.setMaximizable(true);
        tutorial.setIconifiable(true);
        tutorial.setSize(600, 400);
        tutorial.setVisible(true);
        
        JPanel tPanel = new JPanel(new GridLayout(2, 1));
        JLabel welcome = new JLabel("Welcome to the Functional Flow Block Diagram Tutorial! Here is an example of a proper diagram for the following program: ");
		welcome.setFont(new Font("Inter", Font.PLAIN, 20));
		JLabel prompt = new JLabel("Find the greatest common factor of two numbers" + 
		" and tell the user if it is even or odd.");
		prompt.setFont(new Font("Inter", Font.PLAIN, 20));
		tPanel.add(welcome, BorderLayout.CENTER);
		tPanel.add(prompt, BorderLayout.CENTER);
		JPanel bPanel = new JPanel(new GridLayout(1, 1));
		tutorial.add(tPanel, BorderLayout.NORTH);
		tutorial.add(bPanel, BorderLayout.CENTER);

        return tutorial;
    }
}
