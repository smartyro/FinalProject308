package View;

import javax.swing.*;

import Model.Repository;

import java.awt.*;
import View.Problem;
import java.util.ArrayList;
import java.util.Stack;

import Model.BeginShape;
import Model.Shape;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodePanel extends JPanel implements ActionListener{
	private static final Color myColor = new Color(175, 203, 255);
	Problem currentProb;
	JLabel label;
	CodePanel() {
		setBackground(myColor);
		currentProb = Repository.getRepository().getProblem();
		label = new JLabel(currentProb.getProblemStatement());
		Font font = new Font("Inter", Font.LAYOUT_LEFT_TO_RIGHT, 20);
		label.setFont(font);
		add(label);
		JButton next = new JButton("Next");
		next.addActionListener(this);
		add(next);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String act = e.getActionCommand();
		if (act.equals("Next"))
		{
			Repository.getRepository().nextProblem();

			label.setText(Repository.getRepository().getProblem().getProblemStatement());
		}
	}
}
