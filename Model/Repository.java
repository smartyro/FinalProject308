package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.HashMap;
import View.Problem;
import View.Problem;

public class Repository extends Observable {
    private static Repository repository;
    private ArrayList<Shape> shapes;
    private HashMap<String, ArrayList<Shape>> saved;
    private Shape outlineShape;

    private Repository(){
        shapes = new ArrayList<>();
        saved = new HashMap<>();
    }

    /**
     * 
     * @return new repositiory of two ArrayLists and one HashMap
     */
    public static Repository getRepository(){
        if (repository == null){
            repository = new Repository();
        }
        return repository;
    }

    /**
     * 
     * @return ArrayList of type Shapes
     */
    public ArrayList<Shape> getShapes(){
        return shapes;
    }

    /**
     * 
     * @param shape
     */
    public void addShape(Shape shape){
        shapes.add(shape);
        setChanged();
        notifyObservers();
    }
    
    /**
     * 
     * Adds shapes to the ArrayList
     * @param type
     * @param x
     * @param y
     * @param label
     */
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
                addShape(new InputOutputShape(x, y, label));
                break;
            case VARIABLE:
                addShape(new VariableShape(x, y, label));
                break;
            case CONDITION:
                addShape(new ConditionShape(x, y, label));
                break;
        }
    }

    public void clear(){
        shapes = new ArrayList<>();
        setChanged();
        notifyObservers();
    }

    /**
     * 
     * @param key
     */
    public void saveShapes(String key){
        this.saved.put(key, shapes);
        this.shapes = new ArrayList<Shape>();
        setChanged();
        notifyObservers();
    }

    /**
     * 
     * @param key
     */
    public void loadShapes(String key){
        this.shapes = this.saved.get(key);
        setChanged();
        notifyObservers();
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return this.problem;
    }

    public void CheckDiagram() {
        CheckDiagram.check(shapes, problem.getShapes());
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

    /**
     * 
     * @return
     */
    public Shape getOutlineShape(){
        return this.outlineShape;
    }

    /**
     * 
     * @param type
     * @param x
     * @param y
     */
    public void setOutlineShape(ShapeType type, int x, int y){
        switch(type) {
            case BEGIN:
                outlineShape = new BeginShape(x, y, null);
                break;
            case END:
                outlineShape = new EndShape(x, y, null);
                break;
            case CALL:
                outlineShape = new MethodShape(x, y, null);
                break;
            case INSTRUCTION:
                outlineShape = new InstructionShape(x, y, null);
                break;
            case IO:
                outlineShape = new InputOutputShape(x, y, null);
                break;
            case VARIABLE:
                outlineShape = new VariableShape(x, y, null);
                break;
            case CONDITION:
                outlineShape = new ConditionShape(x, y, null);
                break;
        }
    }

    public void clearOutlineShape(){
        this.outlineShape = null;
    }

    public void update() {
        setChanged();
        notifyObservers();
    }
}
