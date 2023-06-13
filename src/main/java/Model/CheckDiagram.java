package Model;

import java.util.Observable;
import java.util.Stack;
import javax.swing.JOptionPane;
import View.HintPanel;
import View.Problem;
import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class CheckDiagram extends Observable {
    private static boolean isCorrect[] = new boolean[10];
    private static int level = 0;
    
    public static void check(Stack<Shape> diagram, Problem key) {
        if (key == null) {
            String message = "You need to set the problem!\n";
            JOptionPane.showConfirmDialog(null, message, "Error: Set Problem", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            return;
        }

        Flowchart correct = new Flowchart(key.getShapes());
        Flowchart toCheck = new Flowchart(diagram);
        
        Flowchart.DiffResult diffResult = correct.diff(toCheck);
        String message;
        String errorTitle = "Error!";
        String congrats = "Good Job!";
        
        switch(diffResult.summary) {
            case NONE:
                try {
                    FileInputStream fis = new FileInputStream("src/main/java/Model/star.mp3");
                    Player playMP3 = new Player(fis);
                    new Thread() {
                        public void run() {
                            try { playMP3.play(); }
                            catch (Exception e) { System.out.println(e); }
                        }
                    }.start();

                } catch(Exception e) {
                    System.out.println(e);
                }
                message = "Your diagram is correct!";
                JOptionPane.showConfirmDialog(null, message, congrats, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                isCorrect[RepositoryInterface.getRepository().getProblemNum()] = true;
                level++;
                break;
            case TOO_MANY_ELEMENTS:
                message = "You have too many elements!";
                JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                RepositoryInterface.getRepository().addMessage(message);
                break;
            case NOT_ENOUGH_ELEMENTS:
                message = "You don't have enough elements!";
                JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                RepositoryInterface.getRepository().addMessage(message);
                break;
            case TOO_MANY_SPECIFIC:
                message = "You don't have enough " + diffResult.specificType + " elements!";
                JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                RepositoryInterface.getRepository().addMessage(message);
                break;
            case NOT_ENOUGH_SPECIFIC:
                message = "You have too many " + diffResult.specificType + " elements!";
                JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                RepositoryInterface.getRepository().addMessage(message);
                break;
            case TOO_MANY_EDGES:
                message = "You have too many connections!";
                JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                RepositoryInterface.getRepository().addMessage(message);
                break;
            case NOT_ENOUGH_EDGES:
                message = "You don't have enough connections!";
                JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                RepositoryInterface.getRepository().addMessage(message);
                break;
            case TOO_MANY_EDGES_SPECIFIC:
                message = "You have too many connections from " + diffResult.specificTypeFrom + " to " + diffResult.specificTypeTo + "!";
                JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                RepositoryInterface.getRepository().addMessage(message);
                break;
            case NOT_ENOUGH_EDGES_SPECIFIC:
                message = "You don't have enough connections from " + diffResult.specificTypeFrom + " to " + diffResult.specificTypeTo + "!";
                JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
                RepositoryInterface.getRepository().addMessage(message);
                break;
        }
    }
 
    public static boolean getCorrectValue() {
        String message = "Your diagram must be correct to move onto the next question.";
        String errorTitle = "Error: Not Complete";
        if (!isCorrect[RepositoryInterface.getRepository().getProblemNum()]){
            JOptionPane.showConfirmDialog(null, message, errorTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE );
        }
        return isCorrect[RepositoryInterface.getRepository().getProblemNum()];
    }

    public static void setCorrectValue(boolean reset){
        isCorrect[RepositoryInterface.getRepository().getProblemNum()] = reset;
    }

    public static void loginCorrectValues(int num){
        for(int i = 0; i < num; i ++){
            isCorrect[i] = true; 
        }
    }
    
    public static int getLevel() {return level;}
}
