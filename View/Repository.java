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
        return this.shapes;
    }

    public void addShape(Shape shape){
        this.shapes.add(shape);
        notifyObservers();
    }

    public void clearShapes(){
        this.shapes = new ArrayList<Shape>();
    }

    public void saveShapes(String key){
        this.saved.put(key, shapes);
        this.shapes = new ArrayList<Shape>();
    }

    public void loadShapes(String key){
        this.shapes = this.saved.get(key);
    }
}
