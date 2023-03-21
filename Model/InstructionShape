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
    public InstructionShape(int x, int y){
        super(x, y);
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
    
    @Override
    public boolean contains(int x2, int y2) {
        return x2 >= getX() && x2 <= getX() + WIDTH &&
                y2 >= getY() && y2 <= getY() + HEIGHT;
    }
    
}
