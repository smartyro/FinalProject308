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
	private static final Color myColor = new Color(255, 239, 211);
	
	private Blackboard() {
		setBackground(myColor);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(myColor);
		for(Shape s : Repository.getRepository().getShapes()) {
			s.draw(g);
			if(s.getLabel() != null) {
				//g.drawString(s.getLabel(), s.getX() + 50, s.getY() + 25);
				s.drawLabel(g);
			}
		}
		for (Shape s : Repository.getRepository().getShapes()) {
			if (s.getOutDegree() > 0) {
				for (Arrow a : s.getOutArrows()) {
					a.draw(g);
				}
			}
		}
		if (Repository.getRepository().getOutlineShape() != null){
			Repository.getRepository().getOutlineShape().draw(g);
		}
	}
	
	/**
	 * 
	 * @return new instance of a Blackboard
	 */
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
