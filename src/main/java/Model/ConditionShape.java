package Model;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.sqrt;

public class ConditionShape extends Shape {
    private static final int LENGTH = 50;
    private String label;

    
    /**
     * 
     * Constructor for the condition shape (diamond)
     * @param x
     * @param y
     * @param label
     */
    public ConditionShape(int x, int y, String label){
        super(x, y, label);
        maxIn = Integer.MAX_VALUE;
        maxOut = 2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillPolygon(new int[]{getX()-LENGTH, getX(), getX()+LENGTH, getX()}, new int[]{getY(), getY()+LENGTH, getY(), getY()-LENGTH}, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[]{getX()-LENGTH, getX(), getX()+LENGTH, getX()}, new int[]{getY(), getY()+LENGTH, getY(), getY()-LENGTH}, 4);
    }

    public void drawLabel(Graphics g){
        label = this.getLabel();
        g.drawString(label, (getX() + LENGTH / 2 - label.length() * 3) - 25, getY() + 5);
    }

    @Override
    public boolean contains(int x2, int y2) {
        return (x2 < (this.getX() +LENGTH) && (x2 > (this.getX()- LENGTH))
        && (y2 < (this.getY()+LENGTH)) && (y2 > (this.getY()-LENGTH)));
    }

    public int[] getArrowPoint(Shape s){
        //top point of rombus
        double dist = sqrt((s.getY() - (this.getY()-LENGTH)) * (s.getY() - (this.getY()-LENGTH)) + 
        ((s.getX()) - (this.getX())) * ((s.getX()) - (this.getX())));
        int[] ret = {this.getX(), this.getY()-LENGTH};
        // bottom of rombus
        double dist2 = sqrt((s.getY() - (this.getY()+LENGTH)) * (s.getY() - (this.getY()+LENGTH)) + 
        ((s.getX()) - (this.getX())) * ((s.getX()) - (this.getX())));
        // left of rombus
        double dist3 = sqrt((s.getY() - (this.getY())) * (s.getY() - (this.getY())) + 
        ((s.getX()) - (this.getX()-LENGTH)) * ((s.getX()) - (this.getX()-LENGTH)));
        // right of circle
        double dist4 = sqrt((s.getY() - (this.getY())) * (s.getY() - (this.getY())) + 
        ((s.getX()) - (this.getX()+LENGTH)) * ((s.getX()) - (this.getX()+LENGTH)));

        if (dist > dist2){
            dist = dist2;
            ret[1] = this.getY()+LENGTH;
        }
        else if (dist > dist3){
            dist = dist3;
            ret[0] = this.getX()-LENGTH;
            ret[1] = this.getY();
        }
        else if (dist > dist4){
            ret[0] = this.getX()+LENGTH;
            ret[1] = this.getY();
        }
        return ret;
    }
	
	@Override
	public ShapeType getShapeType() {
		return ShapeType.CONDITION;
	}
    
    @Override
    public String toString() {
        return getShapeType().toString() + " "
        + Integer.toString(getX()) + " " + Integer.toString(getY()) + " "
        + label + " ";
    }
}
