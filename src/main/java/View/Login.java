package View;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;

import Model.CheckDiagram;
import Model.DatabaseConnect;
import Model.Repository;
import javax.swing.JComboBox;


public class Login extends JDialog implements ActionListener {
    private static JTextField tfUsername;
    private static JPasswordField pfPassword;
    private JLabel loginText;
    private JButton btnLogin;
    private JButton createAccount;
    private JButton btnGuest;
    private JComboBox<String> roleComboBox;




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
        cs.fill = GridBagConstraints.HORIZONTAL;
        panel.setBorder(new LineBorder(Color.GRAY));

        // JLabel lbRole = new JLabel("Role: ");
        // cs.gridx = 0;
        // cs.gridy = 2;
        // cs.gridwidth = 1;
        // panel.add(lbRole, cs);


        String[] roles = {"Student", "Teacher"};
        roleComboBox = new JComboBox<>(roles);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(roleComboBox, cs);
        roleComboBox.setVisible(false);



        btnLogin = new JButton("Login");
        cs.gridx = 1;
        cs.gridy = 4;
        btnLogin.addActionListener(this);
        panel.add(btnLogin, cs);

        // JLabel cont = new JLabel(" ");
        // cs.gridx = 1;
        // cs.gridy = 3;
        // cs.gridwidth = 1;
        // panel.add(cont, cs);

        btnGuest = new JButton("Continue as a Guest");
        cs.gridx = 0;
        cs.gridy = 5;
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
            
                int tryLogin = DatabaseConnect.checkUser(getUsername(), getPassword());
                if (tryLogin == -2) {
                    loginText.setText("Username not found.");
                } else if (tryLogin == -1) {
                    loginText.setText("Username and password do not match.");
                } else {
                    userPanel.getUserPanel().setUsername(getUsername());
                    //assuming it is the last problem they got right
                    Repository.getRepository().setProblemNum(tryLogin + 1);
                    CheckDiagram.loginCorrectValues(tryLogin + 1);
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
                roleComboBox.setVisible(true);
                loginText.setText(" ");
                createAccount.setText("Back to Login");
                break;
            case "Create Account":
                String selectedRole = (String) roleComboBox.getSelectedItem();
                int tryAccount = DatabaseConnect.checkUser(getUsername(), getPassword());
                if (tryAccount == -1) {
                    DatabaseConnect.addUser(getUsername(), getPassword(), selectedRole);
                    dispose();
                } else {
                    loginText.setText("Username already taken.");
                }
            
                break;
            case "Back to Login":
                roleComboBox.setVisible(false);
                btnGuest.setVisible(true);
                loginText.setText(" ");
                createAccount.setText("Create an Account");
                btnLogin.setText("Login");
                break;
        }
	}

    public static String getUsername() {
        return tfUsername.getText().trim();
    }

    public void setUsername(String username) {
        this.tfUsername.setText(username);
    }

    public static String getPassword() {
        return new String(pfPassword.getPassword());
    }


}
    
