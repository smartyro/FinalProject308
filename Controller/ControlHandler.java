package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlHandler implements ActionListener, MouseListener {
	private static ControlHandler instance;
	private BaseShape lineStart;
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
		String sLabel;
		
		Repository repo = Repository.getRepository();
		BaseShape s = repo.anyContains(e.getX(), e.getY());
		if(s == null) {
			/*If we are here, the point is not within a shape, so draw a new shape*/
			StatusBar.getInstance().setMessage("Drawing a shape...");
			if(shapeToDraw == ShapeType.BEGIN) {
				repo.addShape(shapeToDraw, e.getX(), e.getY(), "Begin");
			} else if(shapeToDraw == ShapeType.END) {
				repo.addShape(shapeToDraw, e.getX(), e.getY(), "End");
			} else {
				sLabel = JOptionPane.showInputDialog("Label:");
				repo.addShape(shapeToDraw, e.getX(), e.getY(), sLabel);
			}
			lineStart = null;

		} else {
			/*Otherwise, the point is within a shape so start or finish a line*/
			if(lineStart != null) {
				/*Finish the line*/
				/*  Only draw a line for two different shapes*/
				if(!s.equals(lineStart)) {
					if(lineStart.getOutDegree() + 1 > lineStart.getMaxOut()) {
						StatusBar.getInstance().setMessage("The first shape clicked has its max amount of arrows out of it already");
					} else if(s.getInDegree() + 1 > s.getMaxIn()) {
						StatusBar.getInstance().setMessage("The second shape clicked has its max amount of arrows it to it already");
					} else {
						StatusBar.getInstance().setMessage("Line finished. Drawing it...");
						repo.addArrow(new Arrow(lineStart.getX(), lineStart.getY(), s.getX(), s.getY()));
						lineStart.incrementOutDegree();
						s.incrementInDegree();
					}
				} else {
					StatusBar.getInstance().setMessage("Not drawing a line to the same object");
				}
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
