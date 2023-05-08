package Model;

import java.util.ArrayList;
import View.Problem;


public interface RepositoryInterface {
    ArrayList<Shape> getShapes();
    void addShape(Shape shape);
    void addShape(ShapeType type, int x, int y, String label);
    void clear();
    void saveShapes(String key);
    void loadShapes(String key);
    void setProblem(Problem problem);
    Problem getProblem();
    void checkDiagram();
    Shape anyContains(int x, int y);
    Shape getOutlineShape();
    void setOutlineShape(ShapeType type, int x, int y);
    void clearOutlineShape();
    void update();
}
