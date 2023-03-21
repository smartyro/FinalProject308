package Controller;

import Model.Arrow;
import View.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlHandler implements ActionListener, MouseListener {
	private static ControlHandler instance;
	private Shape lineStart;
	private ShapeType shapeToDraw = ShapeType.INSTRUCTION;
	
	private ControlHandler() {}
	
	public static ControlHandler getInstance() {
		if(instance == null) {
			instance = new ControlHandler();
		}
		return instance;
	}

	public void setShape(ShapeType shape) {
		shapeToDraw = shape;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		StatusBar.getInstance().setMessage("Mouse clicked");
		
		Repository repo = Repository.getRepository();
		Shape s = repo.anyContains(e.getX(), e.getY());
		if(s == null) {
			/*If we are here, the point is not within a shape, so draw a new shape*/
			StatusBar.getInstance().setMessage("Drawing " + shapeToDraw.toString());
			repo.addShape(shapeToDraw, e.getX(), e.getY());
			lineStart = null;
		} else {
			/*Otherwise, the point is within a shape so start or finish a line*/
			if(lineStart != null) {
				/*Finish the line*/
				StatusBar.getInstance().setMessage("Line finished. Drawing it...");
				repo.addArrow(new Arrow(lineStart.x , lineStart.y, s.x, s.y));
				lineStart = null;
			} else {
				/*Start the line*/
				StatusBar.getInstance().setMessage("Line started");
				lineStart = s;
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	
	}
}
