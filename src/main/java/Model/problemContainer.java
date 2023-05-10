package Model;

import View.Problem;
import jdk.internal.util.xml.impl.Input;

import java.util.Stack;

public class problemContainer {

    public static void createProblems(){
        // Problem 1
        ConditionShape c1 = new ConditionShape(0,0, "x < 0");
        BeginShape b1 = new BeginShape(0, 0, "");
        InputOutputShape i1 = new InputOutputShape(0,0, "return 0");
        InputOutputShape i2 = new InputOutputShape(0,0, "return 1");
        EndShape e1 = new EndShape(0,0, "");
        Stack<Shape> s1 = new Stack<Shape>();
        s1.add(c1);
        s1.add(b1);
        s1.add(i1);
        s1.add(i2);
        s1.add(e1);
        Problem p1 = new Problem("<html>def uselessFunc(x):<br/>if x < 0:<br/>  " +
                "return 1<br/>else:<br/> return 0</html>", s1);
        Repository.getRepository().addProblem(p1);
    }
}
