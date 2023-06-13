package View;

import Controller.ControlHandler;
import Model.RepositoryInterface;
import Model.problemContainer;

import javax.swing.border.TitledBorder;

import javax.swing.*;
import java.awt.*;

public class FinalProject extends JFrame {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;

	/**
	 * Main method for the FinalProject
	 */
	public static void main(String[] args) {
		problemContainer.createProblems();
		FinalProject f = new FinalProject();
		Login loginDlg = new Login(f);
		loginDlg.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(new Dimension(WIDTH, HEIGHT));
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
	}

	public FinalProject() {
		Blackboard board = new Blackboard();
		CodePanel codePanel = new CodePanel();
		HintPanel hintPanel = new HintPanel();
		StatusBar statusBar = new StatusBar();
		statusBar.setMessage(
				"Status bar------------------------------------------------------------------------------------------------------------------------------");
		ControlHandler controlHandler = new ControlHandler(statusBar);
		Menu menu = new Menu(controlHandler);
		board.addMouseListener(controlHandler);
		board.addMouseMotionListener(controlHandler);

		TitledBorder boardTitle = BorderFactory.createTitledBorder("Control Flow Diagram");
		TitledBorder codeTitle = BorderFactory.createTitledBorder("Problem Code");
		TitledBorder hintTitle = BorderFactory.createTitledBorder("Chat Help Bot");

		boardTitle.setTitleFont(new Font("Inter", Font.PLAIN, 20));
		boardTitle.setTitlePosition(TitledBorder.CENTER);
		boardTitle.setTitleColor(Color.WHITE);
		codeTitle.setTitleFont(new Font("Inter", Font.PLAIN, 20));
		codeTitle.setTitlePosition(TitledBorder.CENTER);
		hintTitle.setTitleFont(new Font("Inter", Font.PLAIN, 20));
		hintTitle.setTitlePosition(TitledBorder.CENTER);

		board.setBorder(boardTitle);
		codePanel.setBorder(codeTitle);
		hintPanel.setBorder(hintTitle);

		RepositoryInterface.getRepository().addObserver(board);
		RepositoryInterface.getRepository().addObserver(hintPanel);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setOpaque(false);
		
		teacherView teacherV = teacherView.getInstance("Teacher View");
		buttonPanel.add(teacherV);
	
		JButton undoButton = new JButton("Undo");
		undoButton.addActionListener(e -> RepositoryInterface.getRepository().Undo());
		buttonPanel.add(undoButton);

		JButton redoButton = new JButton("Redo");
		redoButton.addActionListener(e -> RepositoryInterface.getRepository().Redo());
		buttonPanel.add(redoButton);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(e -> RepositoryInterface.getRepository().Clear());
		buttonPanel.add(clearButton);

		JPanel spacingPanel = new JPanel();
		spacingPanel.setOpaque(false);

		menu.add(Box.createHorizontalGlue());
		//menu.add(Box.createHorizontalStrut(400));

		//menu.add(spacingPanel);
		userPanel userpanel = userPanel.getUserPanel();
		menu.add(userpanel);
		menu.add(buttonPanel);

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
