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
}
