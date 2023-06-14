package Model;

import java.util.ArrayList;
import java.util.Stack;

import View.Problem;


public interface RepositoryInterface {
    static Repository getRepository() {
        return Repository.getRepository();
    }

    Stack<Shape> getShapes();
    void addShape(Shape shape);
    void addShape(ShapeType type, int x, int y, String label);
    void clear();
    void saveShapes(String key);
    void loadShapes(String key);
    Problem getProblem();
    public int getProblemNum();
    void checkDiagram();
    Shape anyContains(int x, int y);
    Shape getOutlineShape();
    void setOutlineShape(ShapeType type, int x, int y);
    void clearOutlineShape();
    void update();
    ArrayList<String> getMessages();
    void muteMusic();
    void unmuteMusic();
    boolean musicMuted();
    void playMusic(String mp3Path);
}
