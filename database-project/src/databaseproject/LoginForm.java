package databaseproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener
{
    JTextField txt_username = new JTextField(15);
    JPasswordField txt_password = new JPasswordField(15);
    JButton btn_signin = new JButton("Sign in"), btn_signup = new JButton("Sign up");
    String[] str = {"Admin", "User"};
    JComboBox cbox = new JComboBox(str);
    JLabel lbl1 = new JLabel("Username :");
    JLabel lbl2 = new JLabel("Password :");

    LoginForm()
    {
        setTitle("Login");
        setBounds(200, 100, 300, 300);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(cbox);
        add(btn_signin);
        add(btn_signup);
        add(txt_username);
        add(txt_password);
        add(lbl1);
        add(lbl2);

        cbox.setBounds(100, 20, 80, 25);
        lbl1.setBounds(30, 75, 80, 10);
        lbl2.setBounds(30, 115, 80, 10);
        txt_username.setBounds(120, 70, 120, 25);
        txt_password.setBounds(120, 110, 120, 25);
        btn_signin.setBounds(40, 170, 80, 30);
        btn_signup.setBounds(160, 170, 80, 30);

        btn_signin.addActionListener(this);
        btn_signup.addActionListener(this);
    }

    void Clear()
    {
        txt_username.setText(null);
        txt_password.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();
        String user = txt_username.getText().trim();
        String pass = txt_password.getText().trim();

        if (str.equals("Sign in"))
        {
            if (user.isEmpty() || pass.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Blank username or password");
                Clear();
            }
            else if (cbox.getSelectedItem().equals("Admin"))
            {
                if (!user.equals("Admin") || !new Operation().CheckPassword(user, pass))
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    Clear();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Sign in successful");
                    dispose();
                    Main.cur_user = user;
                    new TabbedMenu().setVisible(true);
                }
            }
            else
            {
                if (user.equals("Admin") || !new Operation().CheckUsername(user) || !new Operation().CheckPassword
                        (user, pass))
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    Clear();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Sign in successful");
                    dispose();
                    Main.cur_user = user;
                    new TabbedMenu().setVisible(true);
                }
            }
        }
        else if (str.equals("Sign up"))
        {
            new SignupForm().setVisible(true);
        }
    }
}
