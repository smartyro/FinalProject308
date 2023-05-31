package View;

import javax.swing.*;

import Model.CheckDiagram;
import Model.Repository;
import Model.RepositoryInterface;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodePanel extends JPanel implements ActionListener{
	private static final Color myColor = new Color(175, 203, 255);
	private Problem currentProb;
	private static JLabel label;
	CodePanel() {
		setBackground(myColor);
		JButton prev = new JButton("Prev");
		prev.addActionListener(this);
		add(prev);
		currentProb = RepositoryInterface.getRepository().getProblem();
		label = new JLabel(currentProb.getProblemStatement());
		Font font = new Font("Courier", Font.LAYOUT_LEFT_TO_RIGHT, 20);
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
			if (CheckDiagram.getCorrectValue()){
				RepositoryInterface.getRepository().nextProblem();
				label.setText(RepositoryInterface.getRepository().getProblem().getProblemStatement());
				RepositoryInterface.getRepository().Clear();
			}
		}
		else if (act.equals("Prev")) {
			RepositoryInterface.getRepository().previousProblem();

			label.setText(RepositoryInterface.getRepository().getProblem().getProblemStatement());
		}
	}

	public static void updateProblemText(){
		label.setText(Repository.getRepository().getProblem().getProblemStatement());
	}
}
