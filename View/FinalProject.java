package View;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class FinalProject extends JFrame implements ActionListener{
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

        file.addActionListener(this);
        help.addActionListener(this);


        northPanel.add(file);
        northPanel.add(help);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(northPanel, BorderLayout.NORTH);

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


