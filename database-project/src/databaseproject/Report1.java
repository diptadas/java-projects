package databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;


public class Report1 extends JFrame implements ActionListener
{
    JPanel panel_table = new JPanel();
    JPanel panel_button = new JPanel();
    JTable table;

    JButton btn_ok = new JButton("OK");

    String columnNames[] = {"BRAND NAME", "TOTAL SMARTPHONES"};

    Report1(Vector<Vector<String>> data)
    {
        setTitle("Report 1");
        setBounds(200, 100, 550, 300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        panel_table.setLayout(new BorderLayout());
        table = new JTable(data, new Vector(Arrays.asList(columnNames)));
        panel_table.add(new JScrollPane(table), BorderLayout.CENTER);
        panel_table.setBounds(50, 50, 400, 150);

        btn_ok.setBounds(200, 220, 100, 30);

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
