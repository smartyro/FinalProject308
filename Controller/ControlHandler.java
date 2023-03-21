package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlHandler implements ActionListener, MouseListener {
	private static ControlHandler instance;
	
	private ControlHandler() {}
	
	public static ControlHandler getInstance() {
		if(instance == null) {
			instance = new ControlHandler();
		}
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	
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
