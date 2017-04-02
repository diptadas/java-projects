package databaseproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ConfirmUpdate extends JFrame implements ActionListener
{
    String[] brand_list = {"Samsung", "Sony", "HTC", "Apple", "Walton", "Symphony", "Others"};
    JComboBox cbox_brand = new JComboBox(brand_list);
    String[] os_list = {"Android", "Windows Phone", "iOS", "Firefox", "Others"};
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
    JLabel lb_battery = new JLabel("Battery :");
    JLabel lb_price = new JLabel("Price :");

    JButton btn_update = new JButton("Update");
    JButton btn_cancel = new JButton("Cancel");

    GridLayout gridLayout = new GridLayout(9, 2, 10, 20);
    JPanel panel = new JPanel();

    String mobile_id;

    ConfirmUpdate(Vector<String> data)
    {
        setTitle("Confirm Update");
        setBounds(200, 100, 500, 580);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);

        mobile_id = data.get(0);
        txt_model = new JTextField(data.get(2));
        txt_year = new JTextField(data.get(3));
        txt_display = new JTextField(data.get(5));
        txt_camera = new JTextField(data.get(6));
        txt_cpu = new JTextField(data.get(7));
        txt_ram = new JTextField(data.get(8));
        txt_battery = new JTextField(data.get(9));
        txt_price = new JTextField(data.get(10));

        panel.setLayout(gridLayout);
        panel.add(lb_model);
        panel.add(txt_model);
        panel.add(lb_year);
        panel.add(txt_year);
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
        panel.add(btn_update);
        panel.add(btn_cancel);

        panel.setBounds(25, 10, 450, 500);

        cbox_brand.setEditable(true);
        cbox_os.setEditable(true);

        add(panel);

        btn_update.addActionListener(this);
        btn_cancel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();

        if (str.equals("Update"))
        {
            Vector<String> data = new Vector<String>();

            data.add(txt_model.getText());
            data.add(txt_year.getText());
            data.add(txt_display.getText());
            data.add(txt_camera.getText());
            data.add(txt_cpu.getText());
            data.add(txt_ram.getText());
            data.add(txt_battery.getText());
            data.add(txt_price.getText());

            new Operation().UpdateMobileInfo(mobile_id, data);
            JOptionPane.showMessageDialog(null, "Data updated successfully");
            dispose();
        }
        else if (str.equals("Cancel")) dispose();
    }
}
