package Model;

import java.awt.*;
import static java.lang.Math.sqrt;



public class EndShape extends Shape {
    private static final int RADIUS = 30;
    
    public EndShape(int x, int y, String label){
        super(x, y, label);
        maxIn = Integer.MAX_VALUE;
        maxOut = 0;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillOval(getX(), getY(), RADIUS, RADIUS);
        g.setColor(Color.BLACK);
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

    public int[] getArrowPoint(Shape s){
        //top point of circle
        double dist = sqrt((s.getY() - (this.getY())) * (s.getY() - (this.getY())) + 
        ((s.getX()) - (this.getX()+RADIUS/2)) * ((s.getX()) - (this.getX()+RADIUS/2)));
        int[] ret = {this.getX()+RADIUS/2, this.getY()};
        // bottom of circle
        double dist2 = sqrt((s.getY() - (this.getY()+RADIUS)) * (s.getY() - (this.getY()+RADIUS)) + 
        ((s.getX()) - (this.getX()+RADIUS/2)) * ((s.getX()) - (this.getX()+RADIUS/2)));
        // right of circle
        double dist3 = sqrt((s.getY() - (this.getY()+RADIUS/2)) * (s.getY() - (this.getY()+RADIUS/2)) + 
        ((s.getX()) - this.getX()) * ((s.getX()) - this.getX()));
        // left of circle
        double dist4 = sqrt((s.getY() - (this.getY()+RADIUS/2)) * (s.getY() - (this.getY()+RADIUS/2)) + 
        ((s.getX()) - (this.getX()+RADIUS)) * ((s.getX()) - (this.getX()+RADIUS)));

        if (dist > dist2){
            dist = dist2;
            ret[1] = this.getY()+RADIUS;
        }
        else if (dist > dist3){
            dist = dist3;
            ret[0] = this.getX();
            ret[1] = this.getY()+RADIUS/2;
        }
        else if (dist > dist4){
            ret[0] = this.getX()+RADIUS;
            ret[1] = this.getY()+RADIUS/2;
        }
        return ret;
    }

}
