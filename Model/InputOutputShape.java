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
    
    /**Determines whether a given point is in the shape
     *
     * @param x2 x coordinate of point to test
     * @param y2 y coordinate of point to test
     * @return True if the shape includes the point; false otherwise
     */
    @Override
    public boolean contains(int x2, int y2) {
        /*This function checks what side of each line the point is in;
         * if the point is on the left side of each line (assuming
         * the lines are counterclockwise, which is how we pass them
         * to getSide()), the point is within the shape*/
        int[] sides = {0, 0, 0, 0};
        
        sides[0] = getSide(x2, y2, xArray[0], yArray[0], xArray[1], yArray[1]);
        sides[1] = getSide(x2, y2, xArray[1], yArray[1], xArray[2], yArray[2]);
        sides[2] = getSide(x2, y2, xArray[2], yArray[2], xArray[3], yArray[3]);
        sides[3] = getSide(x2, y2, xArray[3], yArray[3], xArray[0], yArray[0]);
        
        return sides[0] > 0 && sides[1] > 0 && sides[2] > 0 && sides[3] > 0;
    }
    
    /**
     * Determines what side of a given line a point is on
     *
     * @param xPoint x coordinate of the point to test
     * @param yPoint y coordinate of the point to test
     * @param x1 x coordinate of the start of the line
     * @param y1 y coordinate of the start of the line
     * @param x2 x coordinate of the end of the line
     * @param y2 y coordinate of the end of the line
     * @return >0 if point is on the left of the line; =0 if the point is on the line; <0 if the point is on the right of the line
     */
    private int getSide(int xPoint, int yPoint, int x1, int y1, int x2, int y2) {
        return (yPoint - y1) * (x2 - x1) - (xPoint - x1) * (y2 - y1);
    }
}
