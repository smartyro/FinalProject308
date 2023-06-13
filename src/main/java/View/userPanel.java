package View;

import javax.swing.*;
import java.awt.*;

public class userPanel extends JPanel {
    private static userPanel userpanel;
    private JPanel username;
    private static final Color myColor = new Color(217, 217, 217);


    public userPanel(){
        setBackground(myColor);
        username = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        add(username);

    }

    public static userPanel getUserPanel(){
        if(userpanel == null){
            userpanel = new userPanel();
        }
        return userpanel;
    }

    public void setUsername(String user){
        JLabel userLabel = new JLabel("Current User: " + user);
        userLabel.setFont(new Font("Inter", Font.BOLD, 16));
        userLabel.setBackground(myColor);
        userLabel.setOpaque(true);

        username.add(userLabel);
    }

}
