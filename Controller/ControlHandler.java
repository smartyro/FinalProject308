package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlHandler implements ActionListener {
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
}
