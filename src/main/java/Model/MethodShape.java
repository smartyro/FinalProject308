package Model;

import java.awt.*;
import static java.lang.Math.sqrt;

public class MethodShape extends Shape {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    private String label;

    /**
     * 
     * Constructor for MethodShape (Rectangle with verical lines)
     * 
     * @param x
     * @param y
     * @param label
     */
    public MethodShape(int x, int y, String label) {
        super(x, y, label);
        maxIn = 3;
        maxOut = 3;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(getX(), getY(), WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.drawRect(getX(), getY(), WIDTH, HEIGHT);
        g.drawLine(getX() + 10, getY(), getX() + 10, getY() + 50);
        g.drawLine(getX() + 90, getY(), getX() + 90, getY() + 50);
    }

    public void drawLabel(Graphics g) {
        label = this.getLabel();
        g.drawString(label, getX() + WIDTH / 2 - label.length() * 3, getY() + HEIGHT / 2);    }

    @Override
    public boolean contains(int x2, int y2) {
        return x2 >= getX() && x2 <= getX() + WIDTH &&
                y2 >= getY() && y2 <= getY() + HEIGHT;
    }

    public int[] getArrowPoint(Shape s) {
        // top point of shape
        double dist = sqrt((s.getY() - this.getY()) * (s.getY() - this.getY()) +
                ((s.getX() - (this.getX() + WIDTH / 2))) * ((s.getX()) - (this.getX() + WIDTH / 2)));
        int[] ret = { this.getX() + WIDTH / 2, this.getY() + HEIGHT };
        // bottom of shape
        double dist2 = sqrt((s.getY() - this.getY() + HEIGHT) * (s.getY() - this.getY() + HEIGHT) +
                ((s.getX() - (this.getX() + WIDTH / 2))) * ((s.getX()) - (this.getX() + WIDTH / 2)));
        // left of shape
        double dist3 = sqrt((s.getY() - (this.getY() + HEIGHT / 2)) * (s.getY() - (this.getY() + HEIGHT / 2)) +
                ((s.getX()) - (this.getX())) * ((s.getX()) - (this.getX())));
        // // right of circle
        double dist4 = sqrt((s.getY() - (this.getY() + HEIGHT / 2)) * (s.getY() - (this.getY() + HEIGHT / 2)) +
                ((s.getX()) - (this.getX() + WIDTH)) * ((s.getX()) - (this.getX() + WIDTH)));

        if (dist > dist2) {
            dist = dist2;
            ret[1] = this.getY();
        } else if (dist > dist3) {
            dist = dist3;
            ret[0] = this.getX();
            ret[1] = this.getY() + HEIGHT / 2;
        } else if (dist > dist4) {
            ret[0] = this.getX() + WIDTH;
            ret[1] = this.getY() + HEIGHT / 2;
        }
        return ret;
    }
	
	@Override
	public ShapeType getShapeType() {
		return ShapeType.CALL;
	}
    
    @Override
    public String toString() {
        return getShapeType().toString() + " "
        + Integer.toString(getX()) + " " + Integer.toString(getY()) + " "
        + label + " ";
    }
}
