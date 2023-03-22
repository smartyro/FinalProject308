package View;
import Model.Arrow;
import Model.Repository;
import Model.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Blackboard extends JPanel implements Observer {
	private static Blackboard instance;
	
	private Blackboard() {
		setBackground(Color.LIGHT_GRAY);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.LIGHT_GRAY);
		for(Shape s : Repository.getRepository().getShapes()) {
			s.draw(g);
			if(s.getLabel() != null) {
				g.drawString(s.getLabel(), s.getX() + 50, s.getY() + 25);
			}

		}
		for(Arrow a : Repository.getRepository().getArrows()) {
			a.draw(g);
		}
	}
	
	public static Blackboard getInstance() {
		if(instance == null) {
			instance = new Blackboard();
		}
		return instance;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	public void deleteAll(){}
	
	public void save(){}
	
	public void load(){}
}
