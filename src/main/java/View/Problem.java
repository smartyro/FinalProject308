package View;
import java.util.ArrayList;
import java.util.Stack;

import Model.Arrow;
import Model.BeginShape;
import Model.ConditionShape;
import Model.EndShape;
import Model.InputOutputShape;
import Model.MethodShape;
import Model.Shape;
import Model.VariableShape;

public class Problem {
    private String probStatement;
    private Stack<Shape> shapes = new Stack<Shape>();

    public Problem(String pstatement, Stack<Shape> shapes){
        probStatement = pstatement;
        this.shapes = shapes;
    }

    public String getProblemStatement()
    {
        return probStatement;
    }

    public Stack<Shape> getShapes()
    {
        return shapes;
    }
}
