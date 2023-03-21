import java.awt.*;


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
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 50);
        g.setColor(Color.black);
        g.drawRect(x, y, 100, 50);
    }

}
