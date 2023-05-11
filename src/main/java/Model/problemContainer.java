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
        Problem p6 = new Problem("<html>public void callAddNums(x):<br/>int x = 4;<br/>if (5 > x)<br/>\t{<br/>addNums(x, 5);<br/>} </html>", s6);
        Repository.getRepository().addProblem(p6);

        // Problem 7
        Stack<Shape> s7 = new Stack<Shape>();
        BeginShape bs7 = new BeginShape(0, 0, "");
        VariableShape v7 = new VariableShape(0,0, "int c");
        MethodShape ms7 = new MethodShape(0, 0, "Math.sqrt();");
        InputOutputShape io7 = new InputOutputShape(0,0, "return c");
        EndShape e7 = new EndShape(0,0, "");
        Arrow a71 = new Arrow(0, 0, 0, 0, bs6, v6);
        Arrow a72 = new Arrow(0, 0, 0, 0, v6, cs6);
        Arrow a73 = new Arrow(0, 0, 0, 0, cs6, ms6);
        Arrow a74 = new Arrow(0, 0, 0, 0, ms6, es6);
        bs7.addOutArrow(a71);
        v7.addInArrow(a71);
        v7.addOutArrow(a72);
        ms7.addInArrow(a72);
        ms7.addOutArrow(a73);
        io7.addInArrow(a73);
        io7.addOutArrow(a74);
        e7.addInArrow(a74);
        s7.add(bs7);
        s7.add(v7);
        s7.add(ms7);
        s7.add(io7);
        s7.add(e7);
        Problem p7 = new Problem("<html>def triangleSolve(a, b):<br/>c = "+
        "Math.sqrt(a * a + b * b)<br/>return c </html>", s7);
        Repository.getRepository().addProblem(p7);

        //Problem 8
        Stack<Shape> s8 = new Stack<Shape>();
        BeginShape b8 = new BeginShape(0,0, "");
        ConditionShape cs8 = new ConditionShape(0,0, "if len(l1) == 0:");
        ConditionShape cs82 = new ConditionShape(0,0, "if len(l2) == 0:");
        ConditionShape cs83 = new ConditionShape(0,0, "if l1[0] <= l2[0]:");
        InputOutputShape io81 = new InputOutputShape(0, 0, "return l2");
        InputOutputShape io82 = new InputOutputShape(0, 0, "return l1");
        InputOutputShape io83 = new InputOutputShape(0, 0, "return [l1[0]] + merge(L1[1:], l2)");
        InputOutputShape io84 = new InputOutputShape(0, 0, "return [l2[0]] + merge(L1, l2[1:])");
        EndShape e8 = new EndShape(0, 0, "");

        Arrow a81 = new Arrow(0,0,0,0, b8, cs8);
        Arrow a82 = new Arrow(0,0,0,0, cs8, io81);
        Arrow a83 = new Arrow(0,0,0,0, io81, e8);
        Arrow a84 = new Arrow(0,0,0,0, cs8, cs82);
        Arrow a85 = new Arrow(0,0,0,0, cs82, io82);
        Arrow a88 = new Arrow(0, 0, 0, 0, io82, e8);
        Arrow a86 = new Arrow(0,0,0,0, cs82, cs83);
        Arrow a87 = new Arrow(0,0,0,0, cs83, io83);
        Arrow a89 = new Arrow(0,0,0,0, io83, cs8);
        Arrow a810 = new Arrow(0,0,0,0, cs83, io84);
        Arrow a811 = new Arrow(0,0,0,0, io84, cs8);

        //need to add in and out arrows
        s8.add(b8);
        s8.add(cs8);
        s8.add(cs82);
        s8.add(cs83);
        s8.add(io81);
        s8.add(io82);
        s8.add(io83);
        s8.add(io84);
        s8.add(e8);
        Problem p8 = new Problem("<html>def merge(l1, l2):<br/>"+
        "if len(l1) == 0:<br/>return l2 <br/>if len(l2) == 0:<br/>return l1 <br/>if l1[0] <= l2[0]:<br/>return l1[0] + merge(l1[1:], l2)"+
        "<br/>else:<br/>return l2[0] + merge(l1, l2[1:])</html>", s8);
        Repository.getRepository().addProblem(p8);


    }
}
