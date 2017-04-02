package databaseproject;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportPanel extends JPanel implements ActionListener
{

    String[] choice_list = {"1. No of smartphones of each brand", "2. Specification of Flagship smartphones of each " +
            "brand", "3. Price status"};

    JComboBox cbox_choice = new JComboBox(choice_list);
    JButton btn_ok = new JButton("OK");

    ReportPanel()
    {
        setLayout(null);
        add(cbox_choice).setBounds(50, 100, 400, 30);
        add(btn_ok).setBounds(180, 150, 100, 25);
        btn_ok.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (cbox_choice.getSelectedIndex() == 0)
        {
            new Report1(new Operation().Report1_res()).setVisible(true);
        }
        else if (cbox_choice.getSelectedIndex() == 1)
        {
            new Report2(new Operation().Report2_res()).setVisible(true);
        }
        else if (cbox_choice.getSelectedIndex() == 2)
        {
            new Report3(new Operation().Report3_res()).setVisible(true);
        }
    }
}
