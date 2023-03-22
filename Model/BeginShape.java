package Model;

import java.awt.*;



public class BeginShape extends BaseShape {
    public static final int RADIUS = 35;

    public BeginShape(int x, int y, String label){
        super(x, y, label);
        maxIn = 0;
        maxOut = 1;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(getX(), getY(), RADIUS, RADIUS);
        g.setColor(Color.black);
        g.drawOval(getX(), getY(), RADIUS, RADIUS);
    }
    
    public void drawLabel(Graphics g){
        g.drawString(this.getLabel(), this.getX(), this.getY() + 20);
    }
    
    @Override
    public boolean contains(int x2, int y2) {
        int centerX = getX() + RADIUS;
        int centerY = getY() + RADIUS;
        
        int deltaX = x2 - centerX;
        int deltaY = y2 - centerY;
        double distance = Math.sqrt((deltaX)*(deltaX) + (deltaY)*(deltaY));
        
        return distance < RADIUS;
    }
}
