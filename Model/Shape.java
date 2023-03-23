package Model;

import javax.swing.*;
import java.awt.*;


/**
 *Setup for the Shape class
 */
public abstract class Shape{
    private int x, y;
    private String label;
    private int inDegree, outDegree;
    protected int maxIn, maxOut;
    
    /**
     *Definition of shape
     */
    public Shape(int x, int y, String label){
        this.x = x;
        this.y = y;
        this.label = label;
        inDegree = 0;
        outDegree = 0;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void drawLabel(Graphics g){}
    
    public void incrementInDegree() {
        inDegree++;
    }
    
    public void incrementOutDegree() {
        outDegree++;
    }
    
    public int getInDegree() {
        return inDegree;
    }
    
    public int getOutDegree() {
        return outDegree;
    }
    
    public int getMaxIn() {
        return maxIn;
    }
    
    public int getMaxOut() {
        return maxOut;
    }

    public int[] getArrowPoint(Shape s) {
        int [] ret = {0,0};
        return ret;
    }

}
