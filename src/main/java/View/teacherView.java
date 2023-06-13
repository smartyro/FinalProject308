package View;
import Model.DatabaseConnect;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class teacherView extends JButton implements ActionListener{
    private static teacherView instance;
    private JDialog studentProgress;

    public teacherView(String name){
        super(name);
        addActionListener(this);
        setVisible(false); // Set the button initially invisible

    }

    public static teacherView getInstance(String text) {
        if (instance == null) {
            synchronized (teacherView.class) {
                if (instance == null) {
                    instance = new teacherView(text);
                }
            }
        }
        return instance;
    }

    public static teacherView getTeacherViewInstance() {
        return instance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (studentProgress == null) {
            String[][] studentProgressSet = DatabaseConnect.getStudentProgress();
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            studentProgress = new JDialog(frame, "Student Progress", true);
            JPanel panel = new JPanel();
            StringBuilder htmlTextBuilder = new StringBuilder("<html>");
            for (int i = 0; i < studentProgressSet.length; i++) {
                if (studentProgressSet[i][0] == null) {
                    break;
                }
                String studentName = studentProgressSet[i][0];
                String studentProgress = studentProgressSet[i][1];
                htmlTextBuilder.append("Student Username: ").append(studentName).append(", Levels Completed: ").append(studentProgress).append("<br/>");
                }
            htmlTextBuilder.append("</html>");
            JLabel label = new JLabel(htmlTextBuilder.toString());
            panel.add(label);
            studentProgress.getContentPane().add(panel);
            studentProgress.pack();
            studentProgress.setLocationRelativeTo(frame);
        }
        studentProgress.setVisible(true);
    }

    public void setTeacherViewVisible() {
        setVisible(true);
    }

 
}
