package Model;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class CheckDiagram {
    public static void check(ArrayList<Shape> diagram, ArrayList<Shape> key) {
        if (diagram.size() != key.size()) {
            if (diagram.size() < key.size()) {
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
            for (Shape keyShape : key) {
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
