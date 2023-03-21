package View;
import Controller.ControlHandler;

import javax.swing.*;
import java.awt.*;

public class FinalProject extends JFrame {
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	
	public static void main(String[] args) {
		FinalProject f = new FinalProject();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(new Dimension(WIDTH, HEIGHT));
		f.setVisible(true);
	}
	
    public FinalProject() {
        Menu menu = new Menu();

		Blackboard board = Blackboard.getInstance();
		board.addMouseListener(ControlHandler.getInstance());
		
		Repository.getRepository().addObserver(board);
		
		StatusBar statusBar = StatusBar.getInstance();
		
		statusBar.setMessage("Status bar------------------------------------------------------------------------------------------------------------------------------");
		
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(menu, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
		add(statusBar, BorderLayout.SOUTH);

    }
}

