package Model;

import java.util.Stack;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import View.Problem;

public class CheckDiagram {
    public static void check(Stack<Shape> diagram, Problem key) {
    
        if (key == null) {
            JOptionPane.showMessageDialog(null, "You need to set the problem!");
            return;
        }
        
        Flowchart correct = new Flowchart(key.getShapes());
        Flowchart toCheck = new Flowchart(diagram);
        
        Flowchart.DiffResult diffResult = correct.diff(toCheck);
        
        switch(diffResult.summary) {
            case NONE:
                JOptionPane.showMessageDialog(null, "Your diagram is correct!");
                break;
            case TOO_MANY_ELEMENTS:
                JOptionPane.showMessageDialog(null, "You have too many elements!");
                break;
            case NOT_ENOUGH_ELEMENTS:
                JOptionPane.showMessageDialog(null, "You don't have enough elements!");
                break;
            case TOO_MANY_SPECIFIC:
                JOptionPane.showMessageDialog(null, "You don't have enough " + diffResult.type + " elements!");
                break;
            case NOT_ENOUGH_SPECIFIC:
                JOptionPane.showMessageDialog(null, "You have too many " + diffResult.type + " elements!");
                break;
        }
    }
}
