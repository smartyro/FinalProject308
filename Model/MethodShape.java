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
        g.fillRect(getX(), getY(), WIDTH, HEIGHT);
        g.setColor(Color.black);
        g.drawRect(getX(), getY(), WIDTH, HEIGHT);
        g.drawLine(getX()+10, getY(), getX()+10,getY()+50);
        g.drawLine(getX()+90, getY(), getX()+90,getY()+50);
    }

    public void drawLabel(Graphics g){
        g.drawString(this.getLabel(), this.getX() + 50, this.getY() + 25);
    }

    @Override
    public boolean contains(int x2, int y2) {
        return x2 >= getX() && x2 <= getX() + WIDTH &&
                y2 >= getY() && y2 <= getY() + HEIGHT;
    }
}
