package View;
import Model.Arrow;
import Model.Repository;
import Model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class Blackboard extends JPanel implements Observer, ActionListener, MouseListener {
	JButton check = new JButton("Check");
	private static final Color myColor = new Color(70, 74, 83);
	private static final Color valColor = new Color(51, 156, 53);
	
	public Blackboard() {
		setBackground(myColor);
		check.setBackground(valColor);
		check.setOpaque(true);
		check.setForeground(Color.WHITE);
		check.setFont(new Font("Inter", Font.BOLD, 20));
		check.setBorderPainted(false);
		check.addActionListener(this);
		check.addMouseListener(this);
		setLayout(new BorderLayout());
		add(check,BorderLayout.SOUTH );
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(myColor);
		for(Shape s : Repository.getRepository().getShapes()) {
			s.draw(g);
			if(s.getLabel() != null) {
				//g.drawString(s.getLabel(), s.getX() + 50, s.getY() + 25);
				s.drawLabel(g);
			}
		}
		for (Shape s : Repository.getRepository().getShapes()) {
			if (s.getOutDegree() > 0) {
				for (Arrow a : s.getOutArrows()) {
					a.draw(g);
				}
			}
		}
		if (Repository.getRepository().getOutlineShape() != null){
			Repository.getRepository().getOutlineShape().draw(g);
		}
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
	
	public void deleteAll(){}
	
	public void save(){}
	
	public void load(){}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Check"))
		{
			Repository.getRepository().checkDiagram();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		setBackground(new Color(2, 121, 51));
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
