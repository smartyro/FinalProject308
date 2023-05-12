package Model;

import View.Problem;
//import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.List;
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
        Arrow a1P1 = new Arrow(0,0,0,0, i1, c1);
        Arrow a2P1 = new Arrow(0,0,0,0,i2, c1);
        Arrow a3P1 = new Arrow(0,0,0,0, e1, i1);
        Arrow a4P1 = new Arrow(0,0,0,0, e1, i2);
        Arrow a5P1 = new Arrow(0,0,0,0, c1, b1);
        b1.addOutArrow(a5P1);
        c1.addOutArrow(a1P1);
        c1.addOutArrow(a2P1);
        i1.addInArrow(a1P1);
        i2.addInArrow(a2P1);
        e1.addInArrow(a3P1);
        e1.addInArrow(a4P1);
        s1.add(c1);
        s1.add(b1);
        s1.add(i1);
        s1.add(i2);
        s1.add(e1);
        Problem p1 = new Problem("<html>def uselessFunc(x):<br/>if x < 0:<br/>  " +
                "return 1<br/>else:<br/> return 0</html>", s1);
        Repository.getRepository().addProblem(p1);

        // Problem 2
        BeginShape b2 = new BeginShape(0, 0, "");
        EndShape e2 = new EndShape(0,0, "");
        ConditionShape c2 = new ConditionShape(0,0, "if A[i] == x:");
        ConditionShape c3 = new ConditionShape(0,0,"i < len(A)");
        InputOutputShape i3 = new InputOutputShape(0,0, "return 1");
        InstructionShape m1 = new InstructionShape(0,0, "i++");
        InputOutputShape i4 = new InputOutputShape(0,0, "return 0");
        Stack<Shape> s2 = new Stack<Shape>();
        Arrow a1P2 = new Arrow(0,0,0,0, c2, b2);
        Arrow a2P2 = new Arrow(0,0,0,0,i3,c2);
        Arrow a3P2 = new Arrow(0,0,0,0,c3,c2);
        Arrow a4P2 = new Arrow(0,0,0,0,m1,c3);
        Arrow a5P2 = new Arrow(0,0,0,0, c2, m1);
        Arrow a6P2 = new Arrow(0,0,0,0, i4, c3);
        Arrow a7P2 = new Arrow(0,0,0,0,e2,i4);
        Arrow a8P2 = new Arrow(0,0,0,0,e2, i3);
        c2.addInArrow(a1P2);
        b2.addOutArrow(a1P2);
        i3.addInArrow(a2P2);
        c2.addOutArrow(a2P2);
        c3.addInArrow(a3P2);
        c2.addOutArrow(a3P2);
        m1.addInArrow(a4P2);
        c3.addOutArrow(a4P2);
        c2.addInArrow(a5P2);
        m1.addOutArrow(a5P2);
        i4.addInArrow(a6P2);
        c3.addOutArrow(a6P2);
        e2.addInArrow(a7P2);
        i4.addOutArrow(a7P2);
        e2.addInArrow(a8P2);
        i3.addOutArrow(a8P2);
        s2.add(b2);
        s2.add(e2);
        s2.add(c2);
        s2.add(i3);
        s2.add(m1);
        s2.add(i4);
        Problem p2 = new Problem("<html>def simpleSearch(x, A):<br/>for i in range(len(A)):<br/>" +
                "if A[i] == x:<br/> return True <br/> return False", s2);
        Repository.getRepository().addProblem(p2);




    }
}
