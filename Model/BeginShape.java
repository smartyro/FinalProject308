package Model;

import java.awt.*;



public class BeginShape extends Shape {
    public static final int RADIUS = 35;

    public BeginShape(int x, int y, String label){
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, RADIUS, RADIUS);
        g.setColor(Color.black);
        g.drawOval(x, y, RADIUS, RADIUS);
    }
    
    public void drawLabel(Graphics g){
        g.drawString(this.getLabel(), this.getX(), this.getY() + 20);
    }
    
    @Override
    public boolean contains(int x2, int y2) {
        int centerX = x + RADIUS;
        int centerY = y + RADIUS;
        
        int deltaX = x2 - centerX;
        int deltaY = y2 - centerY;
        double distance = Math.sqrt((deltaX)*(deltaX) + (deltaY)*(deltaY));
        
        return distance < RADIUS;
    }
}
