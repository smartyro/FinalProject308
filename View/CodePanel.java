package View;

import javax.swing.*;
import java.awt.*;
import View.Problem;
import java.util.ArrayList;

import Model.BeginShape;
import Model.Shape;


public class CodePanel extends JPanel {
	CodePanel() {
		setBackground(Color.RED);
		ArrayList<Shape> shapes = new ArrayList<>();
		shapes.add(new BeginShape(0,0, ""));
		Problem p = new Problem("int x = 4;", shapes);
		String statement = Problem.getProblemStatement();
		JLabel label = new JLabel(statement);
		add(label);

	}
}
