package Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 *Setup for the Shape class
 */
public abstract class Shape{
    private int x, y;
    private String label;
    protected int maxIn, maxOut;
    private ArrayList<Arrow> inArrows, outArrows;
    
    /**
     * 
     * Constructor for Shapes abstract class
     * @param x
     * @param y
     * @param label
     */
    public Shape(int x, int y, String label){
        this.x = x;
        this.y = y;
        this.label = label;
        this.inArrows = new ArrayList<>();
        this.outArrows = new ArrayList<>();
    }
    
    /**
     * 
     * @return x value
     */
    public int getX() {
        return x;
    }
    
    /**
     * 
     * @return y value
     */
    public int getY() {
        return y;
    }
    
    /**
     *Empty draw method to be used by child shape classes
     */
    public abstract void draw(Graphics g);
    
    /**
     * Determines whether a given point is in the shape
     * @param x2 x coordinate of point to test
     * @param y2 y coordinate of point to test
     * @return True if the shape includes the point; false otherwise
     */
    public abstract boolean contains(int x2, int y2);

    /**
     * 
     * @param s
     */
    public void setLabel(String s){
        label = s;
    }

    /**
     * 
     * @return label that will be displayed on the shape
     */
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

    /**
     * 
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * 
     * @param g
     */
    public void drawLabel(Graphics g){}
    

    public int getInDegree() {
        return this.inArrows.size();
    }
    
    public int getOutDegree() {
        return this.outArrows.size();
    }
    
    public int getMaxIn() {
        return maxIn;
    }
    
    public int getMaxOut() {
        return maxOut;
    }

    public void addInArrow(Arrow a) {
        this.inArrows.add(a);
    }

    public ArrayList<Arrow> getInArrows() {
        return this.inArrows;
    }

    public void addOutArrow(Arrow a) {
        this.outArrows.add(a);
    }

    public ArrayList<Arrow> getOutArrows() {
        return this.outArrows;
    }

    /**
     * 
     * @param s
     * @return point for the Arrow
     */
    public int[] getArrowPoint(Shape s) {
        int [] ret = {0,0};
        return ret;
    }
}
