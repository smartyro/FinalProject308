package Model;

import java.awt.Color;
import java.awt.Graphics;

public class ConditionShape extends BaseShape {
    private static final int LENGTH = 50;
    

    public ConditionShape(int x, int y){
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillPolygon(new int[]{x-LENGTH, x, x+LENGTH, x}, new int[]{y, y+LENGTH, y, y-LENGTH}, 4);
        g.setColor(Color.BLACK);
        g.drawPolygon(new int[]{x-LENGTH, x, x+LENGTH, x}, new int[]{y, y+LENGTH, y, y-LENGTH}, 4);
    }

    @Override
    public boolean contains(int x2, int y2) {
        return x2 >= x-LENGTH && x2 <= x+LENGTH 
                && y2 >= y-LENGTH && y2 <= y+LENGTH;
    }
    
}
