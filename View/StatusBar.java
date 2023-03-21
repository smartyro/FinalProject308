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
	
	public static StatusBar getInstance() {
		if(instance == null) {
			instance = new StatusBar();
		}
		return instance;
	}
	
	public void setMessage(String msg) {
		text.setText(msg);
	}
}
