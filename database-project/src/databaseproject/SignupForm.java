package databaseproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupForm extends JFrame implements ActionListener
{
    JTextField txt_username = new JTextField(15);
    JPasswordField txt_password = new JPasswordField(15);
    JPasswordField txt_password2 = new JPasswordField(15);
    JButton btn_signup = new JButton("Sign up");
    JLabel lbl1 = new JLabel("Username :");
    JLabel lbl2 = new JLabel("Password :");
    JLabel lbl3 = new JLabel("Confirm Password :");

    SignupForm()
    {
        pack();
        setTitle("Sign Up");
        setBounds(200, 100, 300, 250);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(btn_signup);
        add(txt_username);
        add(txt_password);
        add(txt_password2);
        add(lbl1);
        add(lbl2);
        add(lbl3);

        lbl1.setBounds(30, 20, 80, 10);
        lbl2.setBounds(30, 60, 80, 10);
        lbl3.setBounds(5, 100, 120, 10);
        txt_username.setBounds(120, 15, 120, 25);
        txt_password.setBounds(120, 55, 120, 25);
        txt_password2.setBounds(120, 95, 120, 25);
        btn_signup.setBounds(120, 150, 80, 30);

        btn_signup.addActionListener(this);
    }

    void Clear()
    {
        txt_username.setText(null);
        txt_password.setText(null);
        txt_password2.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String user = txt_username.getText().trim();
        String pass = txt_password.getText().trim();
        String pass2 = txt_password2.getText().trim();

        if (e.getActionCommand().equals("Sign up"))
        {
            if (user.isEmpty() || pass.isEmpty() || !pass.equals(pass2))
            {
                JOptionPane.showMessageDialog(null, "Blank field or Passwod not matched");
                Clear();
                return;
            }

            if (new Operation().CheckUsername(user))
            {
                JOptionPane.showMessageDialog(null, "Username not avaiable. Please try another.");
                Clear();
                return;
            }

            new Operation().InsertUser(user, pass);
            JOptionPane.showMessageDialog(null, "Sign up successful");
            setVisible(false);
            dispose();
        }
    }
}
