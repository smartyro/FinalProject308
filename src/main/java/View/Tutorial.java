package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.*;
import java.awt.*;

public class Tutorial extends JInternalFrame{
    public Tutorial(){
		createInternalFrame();
		JPanel tPanel = new JPanel(new GridLayout(2, 1));
		JLabel welcome = new JLabel("Welcome to the Functional Flow Block Diagram Tutorial! Here is an example of a proper diagram for the following program: ");
		welcome.setFont(new Font("Inter", Font.PLAIN, 20));
		JLabel prompt = new JLabel("Find the greatest common factor of two numbers" + 
		" and tell the user if it is even or odd.");
		prompt.setFont(new Font("Inter", Font.PLAIN, 20));
		tPanel.add(welcome, BorderLayout.CENTER);
		tPanel.add(prompt, BorderLayout.CENTER);
		JPanel bPanel = new JPanel(new GridLayout(1, 1));
		add(tPanel, BorderLayout.NORTH);
		add(bPanel, BorderLayout.CENTER);
    }

	private void createInternalFrame(){
	setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        setSize(600, 400);
        setVisible(false);
	}
}
