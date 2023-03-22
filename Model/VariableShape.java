package Model;

import java.awt.*;

public class VariableShape extends BaseShape {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    public VariableShape(int x, int y, String label){
        super(x, y, label);
        maxIn = 1;
        maxOut = 1;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 50);
        g.setColor(Color.black);
        g.drawRect(x, y, 100, 50);
        g.drawLine(x, y+10, x+100,y+10);
        g.drawLine(x+10, y, x+10,y+50);
    }

    @Override
    public boolean contains(int x2, int y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}
