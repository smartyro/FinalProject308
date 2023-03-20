package View;
import javax.swing.*;
import java.awt.*;

public class Blackboard extends JPanel {
	private Blackboard instance;
	
	private Blackboard() {
	
	}
	
	public Blackboard getInstance() {
		if(instance == null) {
			instance = new Blackboard();
		}
		return instance;
	}
}
