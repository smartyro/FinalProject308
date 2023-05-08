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
    private static String probStatement;
    private Stack<Shape> shapes = new Stack<Shape>();

    public Problem(String pstatement, Stack<Shape> shapes2){
        probStatement = pstatement;
        BeginShape bs = new BeginShape(0, 0, "");
        VariableShape v1 = new VariableShape(0, 0, "x = 4");
        ConditionShape cs = new ConditionShape(0, 0, "if (y > x)");
        MethodShape ms = new MethodShape(0, 0, "add_nums(x, y)");
        EndShape es = new EndShape(0, 0, "");
        Arrow a1 = new Arrow(0, 0, 0, 0, bs, v1);
        Arrow a2 = new Arrow(0, 0, 0, 0, v1, cs);
        Arrow a3 = new Arrow(0, 0, 0, 0, cs, ms);
        Arrow a4 = new Arrow(0, 0, 0, 0, ms, es);
        bs.addOutArrow(a1);
        v1.addInArrow(a1);
        v1.addOutArrow(a2);
        cs.addInArrow(a2);
        cs.addOutArrow(a3);
        ms.addInArrow(a3);
        ms.addOutArrow(a4);
        es.addInArrow(a4);
        this.shapes.add(bs);
        this.shapes.add(v1);
        this.shapes.add(cs);
        this.shapes.add(ms);
        this.shapes.add(es);

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

    public Stack<Shape> getShapes()
    {
        return shapes;
    }
}
