package Model;

import java.awt.*;



public class MethodShape extends Shape {

    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    public MethodShape(int x, int y, String label){
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.drawLine(x+10, y, x+10,y+50);
        g.drawLine(x+90, y, x+90,y+50);
    }

    @Override
    public boolean contains(int x2, int y2) {
        return x2 >= getX() && x2 <= getX() + WIDTH &&
                y2 >= getY() && y2 <= getY() + HEIGHT;
    }
}
