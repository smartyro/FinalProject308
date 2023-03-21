package View;
import Controller.ControlHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class FinalProject extends JFrame {
	public static void main(String[] args) {
		FinalProject f = new FinalProject();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(new Dimension(600, 400));
		f.setVisible(true);
	}
	
    public FinalProject() {
		

        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.WHITE);
        JButton file = new JButton("File");
        JButton help = new JButton("Help");

        file.addActionListener(ControlHandler.getInstance());
        help.addActionListener(ControlHandler.getInstance());

        northPanel.add(file);
        northPanel.add(help);
        
		Blackboard board = Blackboard.getInstance();
		board.addMouseListener(ControlHandler.getInstance());

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(northPanel, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);

    }
}

