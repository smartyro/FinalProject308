package Model;

import java.awt.*;


public class Arrow {
    int x1;
    int x2;
    int y1;
    int y2;
    Shape inShape, outShape;

    /**
     * 
     * Constructor for the Arrow
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Arrow(int x1, int y1, int x2, int y2, Shape inShape, Shape outShape){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.inShape = inShape;
        this.outShape = outShape;
    }


    /**
     * 
     * Creates the drawing for the arrow
     * @param g
     */
    public void draw(Graphics g){
        int width = 10;
        int height = 10;
        int dx = x2 - x1, dy = y2 - y1;
        double hypotenuse = Math.sqrt(dx*dx + dy*dy);
        double xDiff = hypotenuse - width, xn = xDiff, yDiff = height, yn = -height, x;
        double sin = dy / hypotenuse, cos = dx / hypotenuse;

        x = xDiff*cos - yDiff*sin + x1;
        yDiff = xDiff*sin + yDiff*cos + y1;
        xDiff = x;
        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xList = {x2, (int) xDiff, (int) xn};
        int[] yList = {y2, (int) yDiff, (int) yn};
        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xList, yList, 3);
    }

    public void setX1(int x) {
        this.x1 = x;
    }

    public void setX2(int x) {
        this.x2 = x;
    }

    public void setY1(int y) {
        this.y1 = y;
    }

    public void setY2(int y) {
        this.y2 = y;
    }

    public Shape getInShape() {
        return this.inShape;
    }

    public Shape getOutShape() {
        return this.outShape;
    }

    public int getX1() {
        return this.x1;
    }

    public int getX2() {
        return this.x2;
    }

    public int getY1() {
        return this.y1;
    }

    public int getY2() {
        return this.y2;
    }
}
