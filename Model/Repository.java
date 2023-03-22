package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.HashMap;

public class Repository extends Observable {
    private static Repository repository;
    private ArrayList<Shape> shapes;
    private ArrayList<Arrow> arrows;
    private HashMap<String, ArrayList<Shape>> saved;

    private Repository(){
        shapes = new ArrayList<>();
        arrows = new ArrayList<>();
        saved = new HashMap<>();
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
    
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
        setChanged();
        notifyObservers();
    }
    
    public void addShape(ShapeType type, int x, int y, String label) {
        switch(type) {
            case BEGIN:
                addShape(new BeginShape(x, y, label));
                break;
            case END:
                addShape(new EndShape(x, y, label));
                break;
            case CALL:
                addShape(new MethodShape(x, y, label));
                break;
            case INSTRUCTION:
                addShape(new InstructionShape(x, y, label));
                break;
            case IO:
                //TODO
                break;
            case VARIABLE:
                addShape(new VariableShape(x, y, label));
                break;
            case CONDITION:
                addShape(new ConditionShape(x, y, label));
                break;
        }
    }
    
    public void addArrow(Arrow arrow) {
        arrows.add(arrow);
        setChanged();
        notifyObservers();
    }

    public void clear(){
        shapes = new ArrayList<>();
        arrows = new ArrayList<>();
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
