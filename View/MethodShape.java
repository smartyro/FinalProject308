package View;

import java.awt.*;



public class MethodShape extends Shape {


    public MethodShape(int x, int y){
        super(x, y);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 100, 50);
        g.setColor(Color.black);
        g.drawRect(x, y, 100, 50);
        g.drawLine(x+10, y, x+10,y+50);
        g.drawLine(x+90, y, x+90,y+50);
    }

    @Override
    public boolean contains(int x2, int y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}
