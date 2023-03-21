package View;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class Repository extends Observable {
    private static Repository repository;
    private ArrayList<Shape> shapes;

    private Repository(){
        shapes = new ArrayList<Shape>();
    }

    public static Repository getRepository(){
        if (repository == null){
            repository = new Repository();
        }
        return repository;
    }

    public ArrayList<Shape> getShapes(){
        return this.shapes;
    }

    public void addShape(Shape shape){
        this.shapes.add(shape);
        notifyObservers();
    }
    
    /**
     * Check if a given point is in any shape
     * @param x x coordinate of point to check
     * @param y y coordinate of point to check
     * @return Shape that this point is within, or null if it is not in a shape
     */
    public Shape anyContains(int x, int y) {
        for(Shape s: shapes) {
            if(s.contains(x, y)) {
                return s;
            }
        }
        return null;
    }
    
}
