package View;
import java.util.ArrayList;

import Model.BeginShape;
import Model.ConditionShape;
import Model.EndShape;
import Model.InputOutputShape;
import Model.MethodShape;
import Model.Shape;
import Model.VariableShape;

public class Problem {
    private static String probStatement;
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    public Problem(String pstatement, ArrayList<Shape> shapes2){
        probStatement = pstatement;
        this.shapes.add(new BeginShape(0, 0, ""));
        this.shapes.add(new VariableShape(0, 0, "x = 4"));
        this.shapes.add(new VariableShape(0, 0, "y = 5"));
        this.shapes.add(new ConditionShape(0, 0, "if (y > x)"));
        this.shapes.add(new MethodShape(0, 0, "add_nums(x, y)"));
        this.shapes.add(new EndShape(0, 0, ""));

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
