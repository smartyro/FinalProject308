package View;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;

import Model.CheckDiagram;
import Model.DatabaseConnect;
import Model.Repository;

public class Login extends JDialog implements ActionListener {
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel loginText;
    private JButton btnLogin;
    private JButton createAccount;
    private JButton btnGuest;

    public Login(Frame parent){
        super(parent, "Login", true);
        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints cs = new GridBagConstraints();
        JLabel lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
        cs.fill = GridBagConstraints.HORIZONTAL;

        JLabel lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("Login");
        cs.gridx = 1;
        cs.gridy = 2;
        btnLogin.addActionListener(this);
        panel.add(btnLogin, cs);

        // JLabel cont = new JLabel(" ");
        // cs.gridx = 1;
        // cs.gridy = 3;
        // cs.gridwidth = 1;
        // panel.add(cont, cs);

        btnGuest = new JButton("Continue as a Guest");
        cs.gridx = 0;
        cs.gridy = 4;
        cs.gridwidth = 3;
        btnGuest.addActionListener(this);
        panel.add(btnGuest, cs);


        loginText = new JLabel(" ");
        cs.gridx = 1;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(loginText, cs);

        createAccount = new JButton("Create an Account");
        cs.gridx = 0;
        cs.gridy = 6;
        cs.gridwidth = 3;
        createAccount.addActionListener(this);
        panel.add(createAccount, cs);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();
        switch (act) {
            case "Login":
            
                String tryLogin = DatabaseConnect.checkUserExists(getTfUsername(), getPfPassword());
                if (tryLogin.equals("no exist")) {
                    loginText.setText("Username not found.");
                } else if (tryLogin.equals("unmatched")) {
                    loginText.setText("Username and password do not match.");
                } else {
                    userPanel.getUserPanel().setUsername(getTfUsername());
                    //assuming it is the last problem they got right
                    Repository.getRepository().setProblemNum(Integer.parseInt(tryLogin) + 1);
                    CheckDiagram.loginCorrectValues(Integer.parseInt(tryLogin) + 1);
                    CodePanel.updateProblemText();
                    dispose();
                }
                break;
            case "Continue as a Guest":
                dispose();
                break;
            case "Create an Account":
                btnLogin.setText("Create Account");
                btnGuest.setVisible(false);
                loginText.setText(" ");
                createAccount.setText("Back to Login");
                break;
            case "Create Account":
                String tryAccount = DatabaseConnect.checkUserExists(getTfUsername(), getPfPassword());
                if (tryAccount.equals("no exist")) {
                    DatabaseConnect.addUser(getTfUsername(), getPfPassword());
                    dispose();
                } else {
                    loginText.setText("Username already taken.");
                }
            
                break;
            case "Back to Login":
                btnGuest.setVisible(true);
                loginText.setText(" ");
                createAccount.setText("Create an Account");
                btnLogin.setText("Login");
                break;
        }
	}

    public String getTfUsername() {
        return tfUsername.getText().trim();
    }

    public void setTfUsername(String username) {
        this.tfUsername.setText(username);
    }

    public String getPfPassword() {
        return new String(pfPassword.getPassword());
    }


}
    
