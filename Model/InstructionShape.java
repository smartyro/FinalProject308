package Model;

import java.awt.*;


/**
 *Setup for Instruction shape
 */
public class InstructionShape extends Shape{
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    
    /**
     *Definition of Instruction object
     */
    public InstructionShape(int x, int y, String label){
        super(x, y, label);
        maxIn = 1;
        maxOut = 1;
    }
    /**
     *Draws the Instruction object
     */
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(getX(), getY(), WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.drawRect(getX(), getY(), WIDTH, HEIGHT);
    }

    public void drawLabel(Graphics g){
        g.drawString(this.getLabel(), this.getX() + 50, this.getY() + 25);
    }
    
    @Override
    public boolean contains(int x2, int y2) {
        return x2 >= getX() && x2 <= getX() + WIDTH &&
                y2 >= getY() && y2 <= getY() + HEIGHT;
    }
    
    public int[] getArrowPoint(Shape s) {
        //top point of shape
        double dist = sqrt((s.getY() - this.getY()) * (s.getY() - this.getY()) + 
        ((s.getX() - (this.getX()+WIDTH/2))) * ((s.getX()) - (this.getX()+WIDTH/2)));
        int[] ret = {this.getX()+WIDTH/2, this.getY()+HEIGHT};
        // bottom of shape
        double dist2 = sqrt((s.getY() - this.getY()+HEIGHT) * (s.getY() - this.getY()+HEIGHT) + 
        ((s.getX() - (this.getX()+WIDTH/2))) * ((s.getX()) - (this.getX()+WIDTH/2)));
        // left of shape
        double dist3 = sqrt((s.getY() - (this.getY()+HEIGHT/2)) * (s.getY() - (this.getY()+HEIGHT/2)) + 
        ((s.getX()) - (this.getX())) * ((s.getX()) - (this.getX())));
        // // right of circle
        double dist4 = sqrt((s.getY() - (this.getY()+HEIGHT/2)) * (s.getY() - (this.getY()+HEIGHT/2)) + 
        ((s.getX()) - (this.getX()+WIDTH)) * ((s.getX()) - (this.getX()+WIDTH)));

        if (dist > dist2){
            dist = dist2;
            ret[1] = this.getY();
        }
        else if (dist > dist3){
            dist = dist3;
            ret[0] = this.getX();
            ret[1] = this.getY()+HEIGHT/2;
        }
        else if (dist > dist4){
            ret[0] = this.getX()+WIDTH;
            ret[1] = this.getY()+HEIGHT/2;
        }
        return ret;
    }
    
}
