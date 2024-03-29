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
        Stack<Shape> s1 = new Stack<>();
        Arrow a1P1 = new Arrow(0,0,0,0, i1, c1);
        Arrow a2P1 = new Arrow(0,0,0,0,i2, c1);
        Arrow a3P1 = new Arrow(0,0,0,0, e1, i1);
        Arrow a4P1 = new Arrow(0,0,0,0, e1, i2);
        Arrow a5P1 = new Arrow(0,0,0,0, c1, b1);
        i1.addInArrow(a1P1); c1.addOutArrow(a1P1);
        i2.addInArrow(a2P1); c1.addOutArrow(a2P1);
        e1.addInArrow(a3P1); i1.addOutArrow(a3P1);
        e1.addInArrow(a4P1); i2.addOutArrow(a4P1);
        c1.addInArrow(a5P1); b1.addOutArrow(a5P1);
        s1.add(c1); s1.add(b1); s1.add(i1); s1.add(i2); s1.add(e1);
        Problem p1 = new Problem("<html>def uselessFunc(x):<br/>&emsp if x &lt 0:<br/>" +
                "&emsp &emsp return 1<br/>&emsp else:<br/>&emsp &emsp return 0</html>", s1);
        RepositoryInterface.getRepository().addProblem(p1);

        // Problem 2
        Stack<Shape> s7 = new Stack<Shape>();
        BeginShape bs7 = new BeginShape(0, 0, "");
        VariableShape v7 = new VariableShape(0,0, "int c");
        MethodShape ms7 = new MethodShape(0, 0, "Math.sqrt();");
        InputOutputShape io7 = new InputOutputShape(0,0, "return c");
        EndShape e7 = new EndShape(0,0, "");
        Arrow a71 = new Arrow(0, 0, 0, 0, v7, bs7);
        Arrow a72 = new Arrow(0, 0, 0, 0, ms7, v7);
        Arrow a73 = new Arrow(0, 0, 0, 0, io7, ms7);
        Arrow a74 = new Arrow(0, 0, 0, 0, e7, io7);
        bs7.addOutArrow(a71); v7.addInArrow(a71); v7.addOutArrow(a72); ms7.addInArrow(a72);
        ms7.addOutArrow(a73); io7.addInArrow(a73); io7.addOutArrow(a74); e7.addInArrow(a74);
        s7.add(bs7); s7.add(v7); s7.add(ms7); s7.add(io7); s7.add(e7);
        Problem p7 = new Problem("<html>def triangleSolve(a, b):<br/>&emsp c = "+
                "Math.sqrt(a * a + b * b)<br/>&emsp return c </html>", s7);
        RepositoryInterface.getRepository().addProblem(p7);

        // Problem 3
        BeginShape b2 = new BeginShape(0, 0, "");
        EndShape e2 = new EndShape(0,0, "");
        VariableShape v1 = new VariableShape(0,0, "int i = 0;");
        ConditionShape c2 = new ConditionShape(0,0, "if A[i] == x:");
        ConditionShape c3 = new ConditionShape(0,0,"i < len(A)");
        InputOutputShape i3 = new InputOutputShape(0,0, "return True");
        InstructionShape m1 = new InstructionShape(0,0, "i++");
        InputOutputShape i4 = new InputOutputShape(0,0, "return False");
        Stack<Shape> s2 = new Stack<Shape>();
        Arrow a1P2 = new Arrow(0,0,0,0, v1, b2);
        Arrow a3P2 = new Arrow(0,0,0,0,c3,v1);
        Arrow a6P2 = new Arrow(0,0,0,0, i4, c3);
        Arrow a9P2 = new Arrow(0,0,0,0, c2, c3);
        Arrow a4P2 = new Arrow(0,0,0,0,m1,c2);
        Arrow a2P2 = new Arrow(0,0,0,0,i3,c2);
        Arrow a5P2 = new Arrow(0,0,0,0, c3, m1);
        Arrow a7P2 = new Arrow(0,0,0,0,e2,i4);
        Arrow a8P2 = new Arrow(0,0,0,0,e2, i3);
        v1.addInArrow(a1P2); b2.addOutArrow(a1P2); c3.addInArrow(a3P2); v1.addOutArrow(a3P2); i4.addInArrow(a6P2); c3.addOutArrow(a6P2);
        c2.addInArrow(a9P2); c3.addOutArrow(a9P2); m1.addInArrow(a4P2); c2.addOutArrow(a4P2); i3.addInArrow(a2P2); c2.addOutArrow(a2P2);
        c3.addInArrow(a5P2); m1.addOutArrow(a5P2); e2.addInArrow(a7P2); i4.addOutArrow(a7P2); e2.addInArrow(a8P2); i3.addOutArrow(a8P2);
        s2.add(b2); s2.add(e2); s2.add(c2); s2.add(c3); s2.add(i3); s2.add(m1); s2.add(i4); s2.add(v1);
        Problem p2 = new Problem("<html>def simpleSearch(x, A):<br/>&emsp for i in range(len(A)):<br/>" +
                "&emsp &emsp if A[i] == x:<br/> &emsp &emsp &emsp return True <br/> &emsp return False", s2);
        RepositoryInterface.getRepository().addProblem(p2);

        // Problem 4
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
        bs6.addOutArrow(a1); v6.addInArrow(a1); v6.addOutArrow(a2); cs6.addInArrow(a2);
        cs6.addOutArrow(a3); ms6.addInArrow(a3); ms6.addOutArrow(a4); es6.addInArrow(a4);
        s6.add(bs6); s6.add(v6); s6.add(cs6); s6.add(ms6); s6.add(es6);
        Problem p6 = new Problem("<html>public void callAddNums(x):<br/>&emsp int x = 4;<br/>" +
                "&emsp if (5 > x){<br/>\t&emsp &emsp addNums(x, 5);<br/>&emsp } </html>", s6);
        RepositoryInterface.getRepository().addProblem(p6);



        //Problem 5
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
        s8.add(b8); s8.add(cs8); s8.add(cs82); s8.add(cs83); s8.add(io81); s8.add(io82); s8.add(io83); s8.add(io84); s8.add(e8);
        Problem p8 = new Problem("<html>def merge(l1, l2):<br/>"+
                "&emsp if len(l1) == 0:<br/>&emsp &emsp return l2 <br/>&emsp if len(l2) == 0:<br/>&emsp &emsp return l1 <br/>" +
                "&emsp if l1[0] <= l2[0]:<br/>&emsp &emsp return l1[0] + merge(l1[1:], l2)"+
                "<br/>&emsp else:<br/>&emsp &emsp return l2[0] + merge(l1, l2[1:])</html>", s8);

        RepositoryInterface.getRepository().addProblem(p8);

        // Problem 6
        Stack<Shape> s9 = new Stack<Shape>();
        BeginShape b9 = new BeginShape(0,0, "");
        VariableShape v9 = new VariableShape(0,0, "mid = (max + min) // 2");
        ConditionShape cs9 = new ConditionShape(0,0, "if max < min:");
        ConditionShape cs92 = new ConditionShape(0,0, "else if x < A[mid]:");
        ConditionShape cs93 = new ConditionShape(0,0, "else if x > A[mid]:");
        InputOutputShape io91 = new InputOutputShape(0, 0, "return -1");
        InputOutputShape io92 = new InputOutputShape(0, 0, "return binarySearch(A, x, min, mid-1");
        InputOutputShape io93 = new InputOutputShape(0, 0, "return binarySearch(A, x, mid + 1, max");
        InputOutputShape io94 = new InputOutputShape(0, 0, "return mid");
        EndShape e9 = new EndShape(0,0, "");
        Arrow a91 = new Arrow(0,0,0,0, v9, b9);
        Arrow a92 = new Arrow(0,0,0,0, cs9, v9);
        Arrow a93 = new Arrow(0,0,0,0, cs92, cs9);
        Arrow a94 = new Arrow(0,0,0,0, io91, cs9);
        Arrow a95 = new Arrow(0,0,0,0, cs93, cs92);
        Arrow a98 = new Arrow(0, 0, 0, 0, io92, cs92);
        Arrow a96 = new Arrow(0,0,0,0, io93, cs93);
        Arrow a97 = new Arrow(0,0,0,0, io94, cs93);
        Arrow a99 = new Arrow(0,0,0,0, e9, io94);
        Arrow a910 = new Arrow(0,0,0,0, e9, io91);
        Arrow a911 = new Arrow(0,0,0,0, v9, io92);
        Arrow a912 = new Arrow(0,0,0,0, v9, io93);
        v9.addInArrow(a91); b9.addOutArrow(a91); cs9.addInArrow(a92); v9.addOutArrow(a92); cs92.addInArrow(a93);
        cs9.addOutArrow(a93); io91.addInArrow(a94); cs9.addOutArrow(a94); cs93.addInArrow(a95); cs92.addOutArrow(a95);
        io92.addInArrow(a98); cs92.addOutArrow(a98); io93.addInArrow(a96); cs93.addOutArrow(a96); io94.addInArrow(a97);
        cs93.addOutArrow(a97); e9.addInArrow(a99); io94.addOutArrow(a99); e9.addInArrow(a910); io91.addOutArrow(a910);
        v9.addInArrow(a911); io92.addOutArrow(a911); v9.addInArrow(a912); io93.addOutArrow(a912);
        s9.add(b9); s9.add(v9); s9.add(cs9); s9.add(cs92); s9.add(cs93); s9.add(io91); s9.add(io92); s9.add(io93);
        s9.add(io94); s9.add(e9);

        Problem p9 = new Problem("<html>def binarySearch(A, x, min, max):<br/> &emsp mid = (max + min) // 2<br/>" +
                "&emsp if max < min: &emsp &emsp return -1 <br/> &emsp else if x < A[mid]: <br/> &emsp &emsp " +
                "return binarySearch(A, x, min, mid-1) <br/> &emsp else if x > A[mid]: <br/> &emsp &emsp " +
                "return binarySearch(A, x, mid + 1, max) <br/> &emsp else: <br/> &emsp &emsp return mid <html>", s9);

        Repository.getRepository().addProblem(p9);

    }
}
