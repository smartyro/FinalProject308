package Model;

import java.awt.*;



public class EndShape extends BaseShape {


    public EndShape(int x, int y){
        super(x, y);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 30, 30);
    }

    @Override
    public boolean contains(int x2, int y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }
}
