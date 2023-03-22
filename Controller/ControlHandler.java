package Controller;

import View.Repository;
import View.Shape;
import View.InstructionShape;
import View.StatusBar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlHandler implements ActionListener, MouseListener {
	private static ControlHandler instance;
	private Shape lineStart;
	
	private ControlHandler() {}
	
	public static ControlHandler getInstance() {
		if(instance == null) {
			instance = new ControlHandler();
		}
		return instance;
	}

	public void setShape(String shape) {
		// DUMMY METHOD NEED TO MAKE ACTUAL IMPLEMENTATION!!
		// -Liam 3/20/23
		System.out.println(shape);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		String sLabel = "";
		StatusBar.getInstance().setMessage("mouse clicked");
		
		Repository repo = Repository.getRepository();
		Shape s = repo.anyContains(e.getX(), e.getY());
		if(s == null) {
			/*If we are here, the point is not within a shape, so draw a new shape*/
			Shape newShape = new InstructionShape(e.getX(), e.getY());
			repo.addShape(newShape);
			sLabel = JOptionPane.showInputDialog("Label:");
			newShape.setLabel(sLabel);
			lineStart = null;
		} else {
			/*Otherwise, the point is within a shape so start or finish a line*/
			if(lineStart != null) {
				/*Finish the line*/
				System.out.println("TODO: Finish line");
				
				lineStart = null;
			} else {
				/*Start the line*/
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
