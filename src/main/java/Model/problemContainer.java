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

                // Problem 6
                Stack<Shape> s6 = new Stack<Shape>();
                BeginShape bs6 = new BeginShape(0, 0, "");
                VariableShape v6 = new VariableShape(0, 0, "x = 4");
                ConditionShape cs6 = new ConditionShape(0, 0, "if (y > x)");
                MethodShape ms6 = new MethodShape(0, 0, "addNums(x, y)");
                EndShape es6 = new EndShape(0, 0, "");
                Arrow a1 = new Arrow(0, 0, 0, 0, bs6, v6);
                Arrow a2 = new Arrow(0, 0, 0, 0, v6, cs6);
                Arrow a3 = new Arrow(0, 0, 0, 0, cs6, ms6);
                Arrow a4 = new Arrow(0, 0, 0, 0, ms6, es6);
                bs6.addOutArrow(a1);
                v6.addInArrow(a1);
                v6.addOutArrow(a2);
                cs6.addInArrow(a2);
                cs6.addOutArrow(a3);
                ms6.addInArrow(a3);
                ms6.addOutArrow(a4);
                es6.addInArrow(a4);
                s6.add(bs6);
                s6.add(v6);
                s6.add(cs6);
                s6.add(ms6);
                s6.add(es6);
                Problem p6 = new Problem("<html>def callAddNums(x):<br/>int x = 4;<br/>if (5 > x)<br/>\t{<br/>addNums(x, 5);<br/>} </html>", s6);
                Repository.getRepository().addProblem(p6);
    }
}
