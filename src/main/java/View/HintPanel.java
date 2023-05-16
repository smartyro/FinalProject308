package View;

import javax.swing.*;
import java.awt.*;

public class HintPanel extends JPanel {
	private static final Color myColor = new Color(217, 217, 217);
	private static final Color dColor = new Color(251, 251, 251);
	private JPanel dialogueBox;

	HintPanel() {
		dialogueBox = new JPanel();
		dialogueBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		dialogueBox.setPreferredSize(new Dimension(500, 300));
		dialogueBox.setBackground(dColor);
       	add(dialogueBox);
		setBackground(myColor);
	}
}
