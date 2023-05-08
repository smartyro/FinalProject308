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
	CodePanel() {
		setBackground(myColor);
		Stack<Shape> shapes = new Stack<Shape>();
		shapes.add(new BeginShape(0,0, ""));

		Problem p = new Problem("<html>int x = 4;<br/>if (5 > x)<br/>\t{<br/>add_nums(x, 5);<br/>} </html>", shapes);
		String statement = Problem.getProblemStatement();
		JLabel label = new JLabel(statement);
		add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Repository.getRepository().checkDiagram();
	}
}
