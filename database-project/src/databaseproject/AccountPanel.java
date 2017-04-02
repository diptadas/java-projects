package databaseproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountPanel extends JPanel implements ActionListener
{
    JPasswordField txt_password = new JPasswordField(15);
    JPasswordField txt_password2 = new JPasswordField(15);
    JButton btn_change_pass = new JButton("Change Password");
    JButton btn_delete = new JButton("Delete Account");
    JLabel lbl1 = new JLabel("New Password :");
    JLabel lbl2 = new JLabel("Confirm Password :");

    AccountPanel()
    {
        setLayout(null);
        add(btn_change_pass);
        add(btn_delete);
        add(txt_password);
        add(txt_password2);
        add(lbl1);
        add(lbl2);

        lbl1.setBounds(70, 50, 120, 10);
        lbl2.setBounds(70, 85, 120, 10);
        txt_password.setBounds(220, 45, 120, 25);
        txt_password2.setBounds(220, 80, 120, 25);
        btn_change_pass.setBounds(50, 150, 150, 30);
        btn_delete.setBounds(220, 150, 150, 30);

        btn_change_pass.addActionListener(this);
        btn_delete.addActionListener(this);
    }

    void Clear()
    {
        txt_password.setText(null);
        txt_password2.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();

        if (str.equals("Change Password"))
        {
            String pass = txt_password.getText().trim();
            String pass2 = txt_password2.getText().trim();

            if (pass.isEmpty() || !pass.equals(pass2))
            {
                JOptionPane.showMessageDialog(null, "Blank field or Passwod not matched");
                Clear();
                return;
            }

            new Operation().ChangePassword(pass);

            JOptionPane.showMessageDialog(null, "Passwod changed");
            Clear();
        }
        else if (str.equals("Delete Account") && !Main.cur_user.equals("Admin"))
        {
            new Operation().DeleteUserInfo();
            JOptionPane.showMessageDialog(null, "Account deleted");
            Clear();
        }

    }
}
