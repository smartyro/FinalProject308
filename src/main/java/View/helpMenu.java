package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.TrustAnchor;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class helpMenu extends JMenu implements ActionListener{
    JMenuItem docItem;
    JMenuItem tutItem; 

    public helpMenu(String name){
        setText(name);

        docItem = new JMenuItem("Documentation");
        docItem.addActionListener(this);

        tutItem = new JMenuItem("Tutorial");
        tutItem.addActionListener(this);

        add(docItem);
        add(tutItem);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tutItem){
            // Tutorial tut = new Tutorial();
            // tut.showTutorial();
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
