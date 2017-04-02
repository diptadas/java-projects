package databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;


public class SearchResult extends JFrame implements ActionListener
{
    JPanel panel_table = new JPanel();
    JPanel panel_button = new JPanel();
    JTable table;

    Vector<Vector<String>> data;

    JButton btn_delete = new JButton("Delete");
    JButton btn_update = new JButton("Update");
    JButton btn_image = new JButton("Refresh");

    String columnNames[] = {"MOBILE ID", "BRAND", "MODEL", "YEAR", "OS", "DISPLAY", "CAMERA", "CPU", "RAM",
            "BATTERY", "PRICE"};

    SearchResult(Vector data)
    {
        this.data = data;

        setTitle("Search Results");
        setBounds(200, 100, 1000, 300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        panel_table.setLayout(new BorderLayout());
        table = new JTable(data, new Vector(Arrays.asList(columnNames)));

        panel_table.add(new JScrollPane(table), BorderLayout.CENTER);
        panel_table.setBounds(0, 0, 1000, 200);

        panel_button.setLayout(new GridLayout(1, 3, 10, 20));
        panel_button.add(btn_delete);
        panel_button.add(btn_update);
        panel_button.add(btn_image);
        panel_button.setBounds(100, 220, 700, 30);

        add(panel_table);
        add(panel_button);

        btn_delete.addActionListener(this);
        btn_update.addActionListener(this);
        btn_image.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();
        int[] selection = table.getSelectedRows();

        if (Main.cur_user.equals("Admin") && str.equals("Delete") && selection.length > 0)
        {
            Vector<Vector<String>> ret = new Vector<Vector<String>>();
            for (int i = 0; i < selection.length; i++) ret.add(data.get(selection[i]));
            new ConfirmDelete(ret).setVisible(true);
            dispose();
        }
        else if (Main.cur_user.equals("Admin") && str.equals("Update") && selection.length == 1)
        {
            new ConfirmUpdate(data.get(selection[0])).setVisible(true);
            dispose();
        }
        else if (str.equals("Refresh") && selection.length == 1)
        {

        }
    }
}
