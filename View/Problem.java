package View;
import java.util.ArrayList;

import Model.Shape;

public class Problem {
    private String probStatement;
    private ArrayList<Shape> shapes;
    public Problem(String pstatement, ArrayList<Shape> shapes){
        probStatement = pstatement;
        this.shapes = shapes;
    }

    public String getProblemStatement()
    {
        return probStatement;
    }

    public ArrayList<Shape> getShapes()
    {
        return shapes;
    }
    
    
}
