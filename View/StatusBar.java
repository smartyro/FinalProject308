package View;

import javax.swing.*;
import java.awt.*;

public class StatusBar extends JPanel {
	private static StatusBar instance;
	private final JTextField text;
	
	private StatusBar() {
		text = new JTextField();
		text.setBounds(10, 10, 500, 100);
		//text.setMinimumSize(new Dimension(FinalProject.WIDTH, 10));
		text.setEditable(false);
		add(text, BorderLayout.CENTER);
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
