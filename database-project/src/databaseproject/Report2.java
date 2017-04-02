package databaseproject;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

public class Report2 extends JFrame implements ActionListener
{
    JPanel panel_table = new JPanel();
    JPanel panel_button = new JPanel();
    JTable table;

    JButton btn_ok = new JButton("OK");

    String columnNames[] = {"MOBILE ID", "BRAND", "MODEL", "YEAR", "OS", "DISPLAY", "CAMERA", "CPU", "RAM",
            "BATTERY", "PRICE"};

    Report2(Vector<Vector<String>> data)
    {
        setTitle("Report 2");
        setBounds(200, 100, 1000, 300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        panel_table.setLayout(new BorderLayout());
        table = new JTable(data, new Vector(Arrays.asList(columnNames)));
        panel_table.add(new JScrollPane(table), BorderLayout.CENTER);
        panel_table.setBounds(0, 0, 1000, 200);

        btn_ok.setBounds(400, 220, 100, 30);

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
