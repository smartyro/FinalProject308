package Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import static java.lang.Math.sqrt;

public class InputOutputShape extends Shape{
    private static final int numPoints = 4;
    private static int length = 100;
    private static int height = 50;
    private int x1, x2, x3, x4;
    private int y1, y2, y3, y4;
    private Polygon p;
 
    /**
     * 
     * Constructor for InputOutput Shape (Parallelogram)
     * @param x
     * @param y
     * @param label
     */

    public InputOutputShape(int x, int y, String label){
        super(x, y, label);
        maxIn = 1;
        maxOut = 1;
    }

    @Override
    public void draw(Graphics g) {
        x1 = getX();
        y1 = y2 = getY();

        x2 = x1 + height;
        x4 = x1 + length;
        x3 = x2 - length;

        y3 = y4 = y1+height;

        int[] xArray = {x1, x4, x2, x3};
        int[] yArray = {y1, y2, y3, y4};

        p = new Polygon(xArray, yArray, numPoints);

        g.setColor(Color.WHITE);
        g.fillPolygon(p);
        g.setColor(Color.black);
        g.drawPolygon(p);
    }

    public boolean contains(int x, int y) {
        if (p.contains(x, y)){
            return true;
        }
        return false;
    }

    @Override
    public void drawLabel(Graphics g){
        g.drawString(this.getLabel(), this.getX() + 50, this.getY() + 25);
    }

    /**
     * 
     * Gets hypotonuse by reciving the length and height of the parallelogram
     * @param x
     * @param height
     * @param length
     * @return
     */
    public int getDistance(int x, int height, int length){
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
    
    public int[] getArrowPoint(Shape s) {
        //top point of shape
        int m1 = this.getX();
        int m2 = (this.getX() + length);
        int m4 = x1 + getDistance(x1, height, length);
        int m3 = x2 - getDistance(x2, height, length);

        double dist = sqrt((s.getY() - this.getY()) * (s.getY() - this.getY()) + 
        ((s.getX() - m1 * ((s.getX()) - m1))));
        int[] ret = {(m1), this.getY()};
        // bottom of shape
        double dist2 = sqrt((s.getY() - (this.getY()+height)) * (s.getY() - (this.getY()+height)) + 
        ((s.getX() - (m2))) * ((s.getX()) - (m2)));

        if (dist > dist2){
            dist = dist2;
            ret[0] = m2;
            ret[1] = this.getY()+height;
        }
        return ret;
    }
}
