package Model;

import java.awt.Color;
import java.awt.Graphics;

public class ConditionShape extends BaseShape {
    private static final int LENGTH = 50;
    

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
        g.drawString(this.getLabel(), this.getX()-20, this.getY());
    }

    @Override
    public boolean contains(int x2, int y2) {
        return (x2 < (this.getX() +LENGTH) && (x2 > (this.getX()- LENGTH))
        && (y2 < (this.getY()+LENGTH)) && (y2 > (this.getY()-LENGTH)));
    }
    
}
