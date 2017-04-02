package databaseproject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class Report3 extends JFrame implements ActionListener
{
    JPanel panel_table = new JPanel();
    JPanel panel_button = new JPanel();
    JTable table;

    JButton btn_ok = new JButton("OK");

    String columnNames[] = {"MOBILE ID", "MODEL", "BRAND NAME", "PRICE STATUS"};

    Report3(Vector<Vector<String>> data)
    {
        setTitle("Report 3");
        setBounds(200, 100, 440, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        panel_table.setLayout(new BorderLayout());
        table = new JTable(data, new Vector(Arrays.asList(columnNames)));
        panel_table.add(new JScrollPane(table), BorderLayout.CENTER);
        panel_table.setBounds(20, 20, 400, 350);

        btn_ok.setBounds(150, 420, 100, 30);

        add(panel_table);
        add(btn_ok);

        btn_ok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        dispose();
    }
}
