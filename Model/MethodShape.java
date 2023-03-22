package Model;

import java.awt.*;



public class MethodShape extends Shape {


    public MethodShape(int x, int y, String label){
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(getX(), getY(), 100, 50);
        g.setColor(Color.black);
        g.drawRect(getX(), getY(), 100, 50);
        g.drawLine(getX()+10, getY(), getX()+10,getY()+50);
        g.drawLine(getX()+90, getY(), getX()+90,getY()+50);
    }

    public void drawLabel(Graphics g){
        g.drawString(this.getLabel(), this.getX() + 50, this.getY() + 25);
    }

    @Override
    public boolean contains(int x2, int y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}
