package View;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JPanel {
	private static StatusBar instance;
	private final JTextField text;
	
	private StatusBar() {
		text = new JTextField("");
		text.setEditable(false);
		add(text);
	}
	
	/**
	 * 
	 * @return new instance of statusBar
	 */
	public static StatusBar getInstance() {
		if(instance == null) {
			instance = new StatusBar();
		}
		return instance;
	}
	
	/**
	 * Sets a new message
	 * @param msg
	 */
	public void setMessage(String msg) {
		text.setText(msg);
	}
}
