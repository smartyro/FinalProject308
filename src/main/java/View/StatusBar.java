package View;

import javax.swing.*;

public class StatusBar extends JPanel {
	private final JTextField text;
	
	public StatusBar() {
		text = new JTextField("");
		text.setEditable(false);
		add(text);
	}
	
	/**
	 * Sets a new message
	 * @param msg
	 */
	public void setMessage(String msg) {
		text.setText(msg);
	}
}
