package databaseproject;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Vector;

public class ViewPanel extends JPanel
{
    String columnNames[] = {"MOBILE ID", "BRAND", "MODEL", "YEAR", "OS", "DISPLAY", "CAMERA", "CPU", "RAM",
            "BATTERY", "PRICE"};

    String sql = "SELECT mobile_id, brand, model, year, os, display, camera, cpu, ram, battery, price FROM " +
            "mobile_info JOIN brand_info ON mobile_info.brand_id = brand_info.brand_id " +
            "JOIN os_info ON mobile_info.os_id = os_info.os_id";

    ViewPanel()
    {
        Vector data = new DBConnection().Query(sql);
        JTable table = new JTable(data, new Vector(Arrays.asList(columnNames)));
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
