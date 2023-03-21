package View;
import Controller.ControlHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class FinalProject extends JFrame {
	public static void main(String[] args) {
		FinalProject f = new FinalProject();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setSize(new Dimension(600, 400));
		f.setVisible(true);
	}
	
    public FinalProject() {
        Menu menu = new Menu();

		Blackboard board = Blackboard.getInstance();
		board.addMouseListener(ControlHandler.getInstance());

		Repository.getRepository().addObserver(board);

        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        add(menu, BorderLayout.NORTH);
        add(board, BorderLayout.CENTER);
    }
}

