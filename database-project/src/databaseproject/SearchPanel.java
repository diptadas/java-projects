package databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SearchPanel extends JPanel implements ActionListener
{
    String[] brand_list = {"Any", "Samsung", "Sony", "HTC", "Apple", "Walton", "Symphony"};
    JComboBox cbox_brand = new JComboBox(brand_list);

    JTextField txt_model = new JTextField(15);
    JTextField txt_price_start = new JTextField(15);
    JTextField txt_price_end = new JTextField(15);

    JLabel lb_brand = new JLabel("Brand :");
    JLabel lb_model = new JLabel("Model :");
    JLabel lb_price_start = new JLabel("Start Price :");
    JLabel lb_price_end = new JLabel("End Price :");

    JButton btn_search = new JButton("Search");
    JButton btn_cancel = new JButton("Cancel");

    JPanel panel = new JPanel();

    SearchPanel()
    {
        panel.setLayout(new GridLayout(5, 2, 10, 20));

        panel.add(lb_brand);
        panel.add(cbox_brand);
        panel.add(lb_model);
        panel.add(txt_model);
        panel.add(lb_price_start);
        panel.add(txt_price_start);
        panel.add(lb_price_end);
        panel.add(txt_price_end);
        panel.add(btn_search);
        panel.add(btn_cancel);

        add(panel);

        btn_search.addActionListener(this);
        btn_cancel.addActionListener(this);
    }

    String GetSearchConditions()
    {
        String search_conditions = "";

        int count = 0;

        if (cbox_brand.getSelectedItem().toString() != "Any")
        {
            search_conditions += "brand = '" + cbox_brand.getSelectedItem().toString() + "'";
            count++;
        }
        if (!txt_model.getText().isEmpty())
        {
            if (count > 0) search_conditions += " AND ";
            search_conditions += "model LIKE '%" + txt_model.getText() + "%'";
            count++;
        }
        if (!txt_price_start.getText().isEmpty())
        {
            if (count > 0) search_conditions += " AND ";
            if (!txt_price_end.getText().isEmpty())
                search_conditions += "price BETWEEN " + txt_price_start.getText() + " AND " + txt_price_end.getText();
            else search_conditions += "price > " + txt_price_start.getText();
            count++;
        }
        else if (!txt_price_end.getText().isEmpty())
        {
            if (count > 0) search_conditions += " AND ";
            search_conditions += "price < " + txt_price_end.getText();
            count++;
        }

        if (count == 0) search_conditions += "1 = 1";

        return search_conditions;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String search_conditions = GetSearchConditions();
        Vector data = new Operation().Search(search_conditions);
        new SearchResult(data).setVisible(true);
    }
}
