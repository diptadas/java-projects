package databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class InsertPanel extends JPanel implements ActionListener
{
    String[] brand_list = {"Samsung", "Sony", "HTC", "Apple", "Walton", "Symphony"};
    JComboBox cbox_brand = new JComboBox(brand_list);
    String[] os_list = {"Android", "Windows", "iOS", "Firefox"};
    JComboBox cbox_os = new JComboBox(os_list);

    JTextField txt_model = new JTextField(15);
    JTextField txt_year = new JTextField(15);
    JTextField txt_display = new JTextField(15);
    JTextField txt_camera = new JTextField(15);
    JTextField txt_cpu = new JTextField(15);
    JTextField txt_ram = new JTextField(15);
    JTextField txt_battery = new JTextField(15);
    JTextField txt_price = new JTextField(15);

    JLabel lb_brand = new JLabel("Brand :");
    JLabel lb_model = new JLabel("Model :");
    JLabel lb_year = new JLabel("Year :");
    JLabel lb_os = new JLabel("OS :");
    JLabel lb_display = new JLabel("Display :");
    JLabel lb_camera = new JLabel("Camera :");
    JLabel lb_cpu = new JLabel("CPU :");
    JLabel lb_ram = new JLabel("RAM :");
    JLabel lb_battery = new JLabel("Battery(mAh) :");
    JLabel lb_price = new JLabel("Price :");

    JButton btn_insert = new JButton("Insert");
    JButton btn_cancel = new JButton("Cancel");

    GridLayout gridLayout = new GridLayout(11, 2, 10, 20);
    JPanel panel = new JPanel();

    InsertPanel()
    {
        panel.setLayout(gridLayout);
        panel.add(lb_brand);
        panel.add(cbox_brand);
        panel.add(lb_model);
        panel.add(txt_model);
        panel.add(lb_year);
        panel.add(txt_year);
        panel.add(lb_os);
        panel.add(cbox_os);
        panel.add(lb_display);
        panel.add(txt_display);
        panel.add(lb_camera);
        panel.add(txt_camera);
        panel.add(lb_cpu);
        panel.add(txt_cpu);
        panel.add(lb_ram);
        panel.add(txt_ram);
        panel.add(lb_battery);
        panel.add(txt_battery);
        panel.add(lb_price);
        panel.add(txt_price);
        panel.add(btn_insert);
        panel.add(btn_cancel);

        add(panel);

        btn_insert.addActionListener(this);
        btn_cancel.addActionListener(this);
    }

    void Clear()
    {
        txt_model.setText(null);
        txt_year.setText(null);
        txt_display.setText(null);
        txt_camera.setText(null);
        txt_cpu.setText(null);
        txt_ram.setText(null);
        txt_battery.setText(null);
        txt_price.setText(null);
    }

    boolean CheckInt(String s)
    {
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();

        if (str.equals("Insert"))
        {
            if (txt_model.getText().isEmpty() || txt_year.getText().isEmpty() || txt_display.getText().isEmpty() ||
                    txt_camera.getText().isEmpty() ||
                    txt_cpu.getText().isEmpty() || txt_ram.getText().isEmpty() || txt_battery.getText().isEmpty() ||
                    txt_price.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fillup all fields");
                return;
            }

            if (!CheckInt(txt_year.getText()) || !CheckInt(txt_battery.getText()) || !CheckInt(txt_price.getText()))
            {
                JOptionPane.showMessageDialog(null, "Year, Battery and Price must be integer");
                return;
            }

            Vector<String> data = new Vector<String>();

            data.add(cbox_brand.getSelectedItem().toString());
            data.add(txt_model.getText());
            data.add(txt_year.getText());
            data.add(cbox_os.getSelectedItem().toString());
            data.add(txt_display.getText());
            data.add(txt_camera.getText());
            data.add(txt_cpu.getText());
            data.add(txt_ram.getText());
            data.add(txt_battery.getText());
            data.add(txt_price.getText());

            new Operation().InsertMobileInfo(data);
            JOptionPane.showMessageDialog(null, "Data inserted successfully");
            Clear();
        }
        else if (str.equals("Cancel"))
        {
            Clear();
        }
    }
}
