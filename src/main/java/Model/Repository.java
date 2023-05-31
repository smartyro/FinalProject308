package Model;

import java.util.*;

import View.Problem;

import javax.swing.*;

public class Repository extends Observable implements RepositoryInterface {
    private static Repository repository ;
    private Stack<Shape> shapes;
    private HashMap<String, Stack<Shape>> saved;
    private Shape outlineShape;
    private int problemNum;
    private List<Problem> problems;
    private Stack<Shape> undoShapes;

    private ArrayList<String> messages;

    private Repository(){
        shapes = new Stack<>();
        saved = new HashMap<>();
        problems = new ArrayList<Problem>();
        messages = new ArrayList<>();
        undoShapes = new Stack<>();
        problemNum = 0;
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
     * Changes to next problem in the list.
     */
    public void nextProblem(){
        if (problemNum < 4)
        {
            this.problemNum++;
        }
    }

    public void previousProblem() {
        if (problemNum > 0) {
            this.problemNum--;
        }
    }

    /**
     * 
     * @return ArrayList of type Shapes
     */
    public Stack<Shape> getShapes(){
        return shapes;
    }

    /**
     * 
     * @param shape
     */
    public void addShape(Shape shape){
        shapes.add(shape);
        undoShapes.removeAllElements();
        setChanged();
        notifyObservers();
    }

    public boolean getProblemIsCorrect(){
        return CheckDiagram.getCorrectValue();
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
        shapes = new Stack<>();
        setChanged();
        notifyObservers();
    }

    /**
     * 
     * @param key
     */
    public void saveShapes(String key){
        this.saved.put(key, shapes);
        this.shapes = new Stack<Shape>();
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


    public int getProblemNum() {
        return problemNum;
    }

    public void setProblemNum(int num) {
        this.problemNum = num;
    }
    public Problem getProblem() {
        try{
            return this.problems.get(problemNum);
        }
        catch(IndexOutOfBoundsException e){
            return this.problems.get(problemNum--);
        }
    }

    public void checkDiagram() {
        try{
            CheckDiagram.check(shapes, problems.get(problemNum));
        }
        catch(IndexOutOfBoundsException e){

        }
    }

    public void addProblem(Problem problem) {this.problems.add(problem);}


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

    @Override
    public ArrayList<String> getMessages() {
        return this.messages;
    }

    public void Undo() {
        if (!shapes.empty()) {
            Shape undoShape = shapes.pop();
            if (!undoShape.getInArrows().isEmpty()) {
                for (Arrow inArrow : undoShape.getInArrows()) {
                    Shape outShape = inArrow.getOutShape();
                    for (int i = 0; i < outShape.getOutDegree(); i++) {
                        Arrow outArrow = outShape.getOutArrows().get(i);
                        if (outArrow.getX2() == inArrow.getX2()
                                && outArrow.getY2() == inArrow.getY2()) {
                            outShape.getOutArrows().remove(i);
                            break;
                        }
                    }
                }
            }
            undoShapes.push(undoShape);
            update();
        }
    }
    public void Clear() {
        if (!this.shapes.empty()) {
            this.shapes.clear();
            update();
        }
    }

    public void Redo() {
        if(!undoShapes.empty()) {
            Shape redoShape = undoShapes.pop();
            if (!redoShape.getInArrows().isEmpty()) {
                for (Arrow inArrow : redoShape.getInArrows()) {
                    Shape outShape = inArrow.getOutShape();
                    inArrow.setX2(redoShape.getArrowPoint(outShape)[0]);
                    inArrow.setY2(redoShape.getArrowPoint(outShape)[1]);
                    outShape.getOutArrows().add(inArrow);
                }
            }
            shapes.push(redoShape);
            update();
        }
	}

    public void addMessage(String message) {
        this.messages.add(message);
        setChanged();
        notifyObservers();
    }

}
