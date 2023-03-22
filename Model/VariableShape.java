package Model;

import java.awt.*;



public class VariableShape extends BaseShape {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;

    public VariableShape(int x, int y){
        super(x, y);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.drawLine(x, (int)(y + HEIGHT * .2), x + WIDTH, (int)(y + HEIGHT * .2));
        g.drawLine((int)(x + (WIDTH * .1)), y, (int)(x + (WIDTH * .1)), y + HEIGHT);
    }

    @Override
    public boolean contains(int x2, int y2) {
        return x2 >= x && x2 <= x + WIDTH 
                && y2 >= y && y2 <= y + HEIGHT;
    }
}
