package Controller;

import Model.*;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControlHandler implements ActionListener, MouseListener, MouseMotionListener {
	private static ControlHandler instance;
	private Shape lineStart;
	private ShapeType shapeToDraw = ShapeType.INSTRUCTION;
	private Shape draggedShape = null;

	private ControlHandler() {
	}

	/**
	 * 
	 * @return new instance if it hasn't been instantiated yet  
	 */
	public static ControlHandler getInstance() {
		if (instance == null) {
			instance = new ControlHandler();
		}
		return instance;
	}

	/**
	 * 
	 * @param shape
	 */
	public void setShape(ShapeType shape) {
		shapeToDraw = shape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Repository.getRepository().clearOutlineShape();
		String sLabel;

		Repository repo = Repository.getRepository();
		Shape s = repo.anyContains(e.getX(), e.getY());
		if (draggedShape != null) {
			draggedShape = null;
			return;
		}
		if (s == null) {
			/* If we are here, the point is not within a shape, so draw a new shape */
			StatusBar.getInstance().setMessage("Drawing a shape...");
			if (shapeToDraw == ShapeType.BEGIN) {
				repo.addShape(shapeToDraw, e.getX(), e.getY(), "Begin");
			} else if (shapeToDraw == ShapeType.END) {
				repo.addShape(shapeToDraw, e.getX(), e.getY(), "End");
			} else {
				sLabel = JOptionPane.showInputDialog("Label:");
				if (sLabel != null) {
					repo.addShape(shapeToDraw, e.getX(), e.getY(), sLabel);
				}
			}
			lineStart = null;

		} else {
			/* Otherwise, the point is within a shape so start or finish a line */
			if (lineStart != null) {
				/* Finish the line */
				/* Only draw a line for two different shapes */
				if (!s.equals(lineStart)) {
					if (lineStart.getOutDegree() + 1 > lineStart.getMaxOut()) {
						StatusBar.getInstance()
								.setMessage("The first shape clicked has its max amount of arrows out of it already");
					} else if (s.getInDegree() + 1 > s.getMaxIn()) {
						StatusBar.getInstance()
								.setMessage("The second shape clicked has its max amount of arrows it to it already");
					} else {
						StatusBar.getInstance().setMessage("Line finished. Drawing it...");
						Arrow a = new Arrow((lineStart.getArrowPoint(s))[0], lineStart.getArrowPoint(s)[1],
						s.getArrowPoint(lineStart)[0], s.getArrowPoint(lineStart)[1], lineStart, s);
						lineStart.addOutArrow(a);
						s.addInArrow(a);
						Repository.getRepository().update();
					}
				} else {
					StatusBar.getInstance().setMessage("Not drawing a line to the same object");
				}
				lineStart = null;
			} else {
				/* Start the line */
				StatusBar.getInstance().setMessage("Line started");
				lineStart = s;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (Repository.getRepository().anyContains(e.getX(), e.getY()) != null && draggedShape == null) {
			draggedShape = Repository.getRepository().anyContains(e.getX(), e.getY());
		} else if (draggedShape != null) {
			draggedShape.setX(e.getX());
			draggedShape.setY(e.getY());
			if (draggedShape.getInDegree() > 0) {
				for (Arrow a : draggedShape.getInArrows()) {
					a.setX2(a.getOutShape().getArrowPoint(draggedShape)[0]);
					a.setY2(a.getOutShape().getArrowPoint(draggedShape)[1]);
				}
			}
			if (draggedShape.getOutDegree() > 0) {
				for (Arrow a : draggedShape.getOutArrows()) {
					a.setX1(draggedShape.getArrowPoint(a.getInShape())[0]); 
					a.setY1(draggedShape.getArrowPoint(a.getInShape())[1]);
				}
			}
		} else {
			Repository.getRepository().setOutlineShape(shapeToDraw, e.getX(), e.getY());
		}
		StatusBar.getInstance().setMessage("dragging mouse");
		Repository.getRepository().update();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
