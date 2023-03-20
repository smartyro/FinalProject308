package View;
import javax.swing.*;
import java.awt.*;

public class Blackboard extends JPanel {
	private static Blackboard instance;
	
	private Blackboard() {
		setBackground(Color.BLUE);
	}
	
	public static Blackboard getInstance() {
		if(instance == null) {
			instance = new Blackboard();
		}
		return instance;
	}
}
