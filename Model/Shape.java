package Model;

import javax.swing.*;
import java.awt.*;


/**
 *Setup for the Shape class
 */
public abstract class Shape{
    public int x, y;
    String label;
    /**
     *Definition of shape
     */
    public Shape(int x, int y, String label){
        this.x = x;
        this.y = y;
        this.label = label;
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

    public void setLabel(String s){
        label = s;
    }

    public String getLabel(){
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        
        if(!o.getClass().equals(this.getClass())) {
            return false;
        }
        
        Shape other = (Shape) o;
        
        return x == other.x && y == other.y && label.equals(other.label);
    }
    
}
