import java.awt.*;
import java.util.Objects;


/**
 *Setup for Instruction shape
 */
public class Instruction extends Shape{
    /**
     *Definition of Instruction object
     */
    public Instruction(int x, int y){
        super(x, y);
    }
    /**
     *Draws the Instruction object
     */
    @Override
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.drawRect(x-10, y-5, x+10, y+5);
    }

}

