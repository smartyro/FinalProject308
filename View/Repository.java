package View;

import java.util.ArrayList;
import java.util.Observable;
import java.util.HashMap;

public class Repository extends Observable {
    private static Repository repository;
    private ArrayList<Shape> shapes;
    private HashMap<String, ArrayList<Shape>> saved;

    private Repository(){
        shapes = new ArrayList<Shape>();
        saved = new HashMap<String, ArrayList<Shape>>();
    }

    public static Repository getRepository(){
        if (repository == null){
            repository = new Repository();
        }
        return repository;
    }

    public ArrayList<Shape> getShapes(){
        return shapes;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
        setChanged();
        notifyObservers();
    }

    public void clearShapes(){
        this.shapes = new ArrayList<Shape>();
        setChanged();
        notifyObservers();
    }

    public void saveShapes(String key){
        this.saved.put(key, shapes);
        this.shapes = new ArrayList<Shape>();
        setChanged();
        notifyObservers();
    }

    public void loadShapes(String key){
        this.shapes = this.saved.get(key);
        setChanged();
        notifyObservers();
    }
    
    /**
     * Tests if any shape contains the given point
     *
     * @param x x coordinate of point to test
     * @param y y coordinate of point to test
     * @return Shape that contains this point, if any; otherwise, returns null
     */
    public Shape anyContains(int x, int y) {
        for(Shape s : shapes) {
            if(s.contains(x, y)) {
                return s;
            }
        }
        return null;
    }
}
