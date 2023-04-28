package View;

import javax.swing.*;

import Model.Repository;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CodePanel extends JPanel implements ActionListener{
	CodePanel() {
		setBackground(Color.RED);
		JButton check = new JButton("Check");
		check.addActionListener(this);
		add(check);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Repository.getRepository().CheckDiagram();
	}
}
