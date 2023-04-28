package View;

import javax.swing.*;
import java.awt.*;
import View.Problem;
import java.util.ArrayList;

import Model.BeginShape;
import Model.Shape;


public class CodePanel extends JPanel {
	private static final Color myColor = new Color(175, 203, 255);
	CodePanel() {
		setBackground(myColor);
		ArrayList<Shape> shapes = new ArrayList<>();
		shapes.add(new BeginShape(0,0, ""));

		Problem p = new Problem("<html>int x = 4;<br/>int y = 5;<br/>if (y > x)<br/>\t{<br/>add_nums(x, y);<br/>} </html>", shapes);
		String statement = Problem.getProblemStatement();
		JLabel label = new JLabel(statement);
		add(label);
	}
}
