package View;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.*;
import java.awt.*;

public class Tutorial extends JInternalFrame{
    public Tutorial(){
		setSize(300, 200);
		setVisible(true);
		setClosable(true);
		setMaximizable(true);
		setResizable(true);

		JPanel tPanel = new JPanel(new GridLayout(2, 1));
		JLabel welcome = new JLabel("Welcome to the Functional Flow Block Diagram Tutorial! Here is an example of a proper diagram for the following program: ");
		welcome.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel prompt = new JLabel("Find the greatest common factor of two numbers" + 
		" and tell the user if it is even or odd.");
		prompt.setFont(new Font("Serif", Font.PLAIN, 20));
		tPanel.add(welcome, BorderLayout.CENTER);
		tPanel.add(prompt, BorderLayout.CENTER);
		JPanel bPanel = new JPanel(new GridLayout(1, 1));
		bPanel.add(new JLabel(new ImageIcon("View/flowchartImg1.png")), BorderLayout.CENTER);
		add(tPanel, BorderLayout.NORTH);
		add(bPanel, BorderLayout.CENTER);
    }

    public void showTutorial(){
        setSize(300, 200);
		setVisible(true);
		setClosable(true);
		setMaximizable(true);
		setResizable(true);

		JPanel tPanel = new JPanel(new GridLayout(2, 1));
		JLabel welcome = new JLabel("Welcome to the Functional Flow Block Diagram Tutorial! Here is an example of a proper diagram for the following program: ");
		welcome.setFont(new Font("Serif", Font.BOLD, 20));
		JLabel prompt = new JLabel("Find the greatest common factor of two numbers" + 
		" and tell the user if it is even or odd.");
		prompt.setFont(new Font("Serif", Font.PLAIN, 20));
		tPanel.add(welcome, BorderLayout.CENTER);
		tPanel.add(prompt, BorderLayout.CENTER);
		JPanel bPanel = new JPanel(new GridLayout(1, 1));
		bPanel.add(new JLabel(new ImageIcon("View/flowchartImg1.png")), BorderLayout.CENTER);
		add(tPanel, BorderLayout.NORTH);
		add(bPanel, BorderLayout.CENTER);
    }
}
