package View;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login extends JDialog implements ActionListener {
    private JTextField tfUsername;
    private JPasswordField pfPassword;
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

        JButton btnLogin = new JButton("Login");
        cs.gridx = 2;
        cs.gridy = 2;
        btnLogin.addActionListener(this);
        panel.add(btnLogin, cs);

        JLabel cont = new JLabel(" ");
        cs.gridx = 2;
        cs.gridy = 3;
        cs.gridwidth = 2;
        panel.add(cont, cs);

        JButton btnGuest = new JButton("Guest Login");
        cs.gridx = 2;
        cs.gridy = 4;
        cs.gridwidth = 1;
        btnGuest.addActionListener(this);
        panel.add(btnGuest, cs);

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String act = e.getActionCommand();
		if (act.equals("Login"))
		{
			System.out.println(getTfUsername());
            System.out.println(getPfPassword());
            dispose();
		}
		else if (act.equals("Guest Login")) {
            dispose();
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
    
