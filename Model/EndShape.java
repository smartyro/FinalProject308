package Model;

import java.awt.*;



public class EndShape extends Shape {
    private static final int RADIUS = 30;
    
    public EndShape(int x, int y, String label){
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillOval(x, y, RADIUS, RADIUS);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, RADIUS, RADIUS);
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
