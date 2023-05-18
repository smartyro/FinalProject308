package View;

import Model.Repository;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HintPanel extends JPanel implements java.util.Observer {
	private static final Color myColor = new Color(217, 217, 217);
	private static final Color dColor = new Color(251, 251, 251);
	private JPanel dialogueBox;

	public HintPanel() {
		dialogueBox = new JPanel();
		dialogueBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		dialogueBox.setPreferredSize(new Dimension(500, 300));
		dialogueBox.setBackground(dColor);
		add(dialogueBox);
		setBackground(myColor);
	}

	@Override
	protected void paintComponent(Graphics g) {
		ArrayList<String> messages = Repository.getRepository().getMessages();
		super.paintComponent(g);

		dialogueBox.removeAll();

		dialogueBox.repaint();

		int y = 20;
		for (int i = 0; i < messages.size(); i++) {
			String message = messages.get(i);
			JLabel label = new JLabel(message);
			label.setBounds(20, y, getWidth() - 40, 20);
			dialogueBox.add(label);

			y += 30;

			if (i < messages.size() - 1) {
				int lineY = y - 10;
				Graphics2D g2d = (Graphics2D) dialogueBox.getGraphics();
				g2d.setColor(Color.BLACK);
				g2d.drawLine(20, lineY, dialogueBox.getWidth() - 20, lineY);
			}
		}
	}

	@Override
	public void update(java.util.Observable o, Object arg) {
		repaint();
	}
}
