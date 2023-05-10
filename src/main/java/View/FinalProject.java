package View;
import Controller.ControlHandler;
import Model.Repository;
import javax.swing.border.TitledBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalProject extends JFrame {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	public static final Color myBlack = new Color(34, 34, 34);
	
	
	/**
	 * Main method for the FinalProject
	 */
	public static void main(String[] args) {
		FinalProject f = new FinalProject();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(new Dimension(WIDTH, HEIGHT));
		//Tutorial tut = new Tutorial();
		//f.add(tut);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
	}
	
    public FinalProject() {
		Blackboard board = new Blackboard();
		CodePanel codePanel = new CodePanel();
		HintPanel hintPanel = new HintPanel();
		StatusBar statusBar = new StatusBar();
		statusBar.setMessage("Status bar------------------------------------------------------------------------------------------------------------------------------");
		ControlHandler controlHandler = new ControlHandler(statusBar);
		Menu menu = new Menu(controlHandler);
		board.addMouseListener(controlHandler);
		board.addMouseMotionListener(controlHandler);
	    
	    	TitledBorder boardTitle = BorderFactory.createTitledBorder("Control Flow Diagram");
		TitledBorder codeTitle = BorderFactory.createTitledBorder("Problem Code");
		TitledBorder hintTitle = BorderFactory.createTitledBorder("Chat Help Bot");


		board.setBorder(boardTitle);
		codePanel.setBorder(codeTitle);
		hintPanel.setBorder(hintTitle);

		Repository.getRepository().addObserver(board);
		
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Repository.getRepository().Undo();
			}
		});
		add(undoButton);
		
        GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
        GridBagConstraints constraints = new GridBagConstraints();
        
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 0.001;
        add(menu, constraints);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.3;
		constraints.weighty = 0.8;
		add(codePanel, constraints);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 2;
		constraints.weightx = 0.7;
		constraints.weighty = 0.9;
		add(board, constraints);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0.3;
		constraints.weighty = 0.2;
		add(hintPanel, constraints);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.weightx = 1;
		constraints.weighty = 0.01;
		add(statusBar, constraints);
    }
}
