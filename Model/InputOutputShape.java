package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class InputOutputShape extends Shape{
    private static final int numPoints = 4;
    private static final int length = 100;
    private static final int height = 50;
    private static final int diffX = 15;
    private final int[] xArray = {0, 0, 0, 0};
    private final int[] yArray = {0, 0, 0, 0};
 

    public InputOutputShape(int x, int y, String label){
        super(x, y, label);
        maxIn = 1;
        maxOut = 1;
    }

    @Override
    public void draw(Graphics g) {
        xArray[0] = getX();
        xArray[1] = getX() + length;
        xArray[2] = getX() + length - diffX;
        xArray[3] = getX() - diffX;

        yArray[0] = getY();
        yArray[1] = getY();
        yArray[2] = getY() + height;
        yArray[3] = getY() + height;
        
        Polygon p = new Polygon(xArray, yArray, numPoints);
        g.setColor(Color.WHITE);
        g.fillPolygon(p);
        g.setColor(Color.BLACK);
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
