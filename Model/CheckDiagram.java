package Model;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import View.Problem;

public class CheckDiagram {
    public static void check(ArrayList<Shape> diagram, Problem key) {
        if (key == null) {
            JOptionPane.showMessageDialog(null, "You need to set the problem!");
            return;
        }
        if (diagram.size() != key.getShapes().size()) {
            if (diagram.size() < key.getShapes().size()) {
                JOptionPane.showMessageDialog(null, "You don't have enough elements!");
                return;
            }
            else {
                JOptionPane.showMessageDialog(null, "You have too many elements!");
                return;
            }
        }
        for (Shape diagramShape : diagram) {
            boolean match = false;
            for (Shape keyShape : key.getShapes()) {
                if (diagramShape.equals(keyShape)) {
                    match = true;
                }
            }
            if (!match) {
                JOptionPane.showMessageDialog(null, "You have an incorrect element!");
                return;
            }
        }
    }
}
