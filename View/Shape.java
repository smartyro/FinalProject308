package View;

import java.awt.*;


/**
 *Setup for the Shape class
 */
public abstract class Shape{
    private int x, y;
    /**
     *Definition of shape
     */
    public Shape(int x, int y){
        this.x = x;
        this.y = y;

    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    /**
     *Empty draw method
     */
    public abstract void draw(Graphics g);
    
    /**
     * Empty contains method to determine whether a shape includes a given point
     * @param x2 x coordinate of point
     * @param y2 y coordinate of point
     */
    public abstract boolean contains(int x2, int y2);
}
