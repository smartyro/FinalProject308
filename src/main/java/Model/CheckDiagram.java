package Model;

import java.util.Stack;

import javax.swing.JOptionPane;

import View.HintPanel;
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
        String message;
        
        switch(diffResult.summary) {
            case NONE:
                message = "Your diagram is correct!";
                JOptionPane.showMessageDialog(null, message);
                break;
            case TOO_MANY_ELEMENTS:
                message = "You have too many elements!";
                JOptionPane.showMessageDialog(null, message);
                Repository.getRepository().addMessage(message);
                break;
            case NOT_ENOUGH_ELEMENTS:
                message = "You don't have enough elements!";
                JOptionPane.showMessageDialog(null, message);
                Repository.getRepository().addMessage(message);
                break;
            case TOO_MANY_SPECIFIC:
                message = "You don't have enough " + diffResult.type + " elements!";
                JOptionPane.showMessageDialog(null, message);
                Repository.getRepository().addMessage(message);
                break;
            case NOT_ENOUGH_SPECIFIC:
                message = "You have too many " + diffResult.type + " elements!";
                JOptionPane.showMessageDialog(null, message);
                Repository.getRepository().addMessage(message);
                break;
        }
    }
}
