package databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;


public class ConfirmDelete extends JFrame implements ActionListener
{
    JPanel panel_table = new JPanel();
    JPanel panel_button = new JPanel();
    JTable table;

    Vector<Vector<String>> data;

    JButton btn_delete = new JButton("Confirm Delete");
    JButton btn_cancel = new JButton("Cancel");

    String columnNames[] = {"MOBILE ID", "BRAND", "MODEL", "YEAR", "OS", "DISPLAY", "CAMERA", "CPU", "RAM",
            "BATTERY", "PRICE"};

    ConfirmDelete(Vector<Vector<String>> data)
    {
        this.data = data;

        setTitle("Confirm Delete");
        setBounds(200, 100, 1000, 300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        panel_table.setLayout(new BorderLayout());
        table = new JTable(data, new Vector(Arrays.asList(columnNames)));
        panel_table.add(new JScrollPane(table), BorderLayout.CENTER);
        panel_table.setBounds(0, 0, 1000, 200);

        panel_button.setLayout(new GridLayout(1, 2, 10, 20));
        panel_button.add(btn_delete);
        panel_button.add(btn_cancel);
        panel_button.setBounds(100, 220, 700, 30);

        add(panel_table);
        add(panel_button);

        btn_delete.addActionListener(this);
        btn_cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();

        if (str.equals("Confirm Delete"))
        {
            String ids = "";

            for (int i = 0; i < data.size(); i++)
            {
                if (i == 0) ids += data.get(i).get(0);
                else ids += " ," + data.get(i).get(0);
            }

            new Operation().DeleteMobileInfo(ids);
            JOptionPane.showMessageDialog(null, "Delete Completed");
            dispose();
        }
        else if (str.equals("Cancel")) dispose();
    }
}
