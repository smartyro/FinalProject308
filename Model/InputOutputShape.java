package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class InputOutputShape extends Shape{
    private static final int numPoints = 4;
    private static int length = 100;
    private static int height = 50;
    private int x1, x2, x3, x4;
    private int y1, y2, y3, y4;
    private int[] xArray = {x1, x2, x3, x4};
    private int[] yArray = {y1, y2, y3, y4};
 

    public InputOutputShape(int x, int y, String label){
        super(x, y, label);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        x1 = getX();
        x2 = (getX() + length);
        x3 = x1 + getDistance(x1, height, length);
        x4 = x2 - getDistance(x2, height, length);

        y1 = y2 = getY();
        y3 = y4 = (getY()+height);

        Polygon p = new Polygon(xArray, yArray, numPoints);
        g.drawPolygon(p);
    }

    @Override
    public boolean contains(int x2, int y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    public int getDistance(int x1, int height, int length){
        int xdist;
        double a2, b2;

        a2 = (x1 + height);
        b2 = (length - x1);

        a2 = Math.pow(a2, 2.0);
        b2 = Math.pow(b2, 2.0);

        xdist = (int)(a2 + b2);
        xdist = (int)Math.sqrt(xdist);

        return xdist;
    }
}
