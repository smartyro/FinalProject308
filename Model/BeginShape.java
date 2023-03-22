package Model;

import java.awt.*;



public class BeginShape extends Shape {


    public BeginShape(int x, int y, String label){
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 35, 35);
        g.setColor(Color.black);
        g.drawOval(x, y, 35, 35);
    }

    public void drawLabel(Graphics g){
        g.drawString(this.getLabel(), this.getX(), this.getY() + 20);
    }

    @Override
    public boolean contains(int x2, int y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}
