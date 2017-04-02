package databaseproject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbedMenu extends JFrame implements ActionListener
{
    JTabbedPane tabbedPane = new JTabbedPane();

    TabbedMenu()
    {
        setTitle("Menu");
        setBounds(200, 100, 500, 600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        add(tabbedPane);
        tabbedPane.addTab("Account", new AccountPanel());
        if (Main.cur_user.equals("Admin")) tabbedPane.addTab("Insert", new InsertPanel());
        tabbedPane.addTab("Search", new SearchPanel());
        tabbedPane.addTab("Reports", new ReportPanel());
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
