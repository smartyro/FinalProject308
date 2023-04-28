package View;
import java.util.ArrayList;

import Model.Shape;

public class Problem {
    private static String probStatement;
    private ArrayList<Shape> shapes;

    public Problem(String pstatement, ArrayList<Shape> shapes2){
        probStatement = pstatement;
        this.shapes = shapes2;
    }

    public static String getProblemStatement()
    {
        return probStatement;
    }

    public ArrayList<Shape> getShapes()
    {
        return shapes;
    }
    
    
}
