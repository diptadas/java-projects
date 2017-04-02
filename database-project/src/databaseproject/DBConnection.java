package databaseproject;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;

public class DBConnection
{
    Vector getTable(ResultSet res)
    {
        try
        {
            ResultSetMetaData metaData = res.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector<Vector<String>> data = new Vector<Vector<String>>();

            while (res.next())
            {
                Vector<String> newRow = new Vector<String>();
                for (int i = 1; i <= numberOfColumns; i++)
                {
                    newRow.addElement(res.getObject(i).toString());
                }
                data.addElement(newRow);
            }

            return data;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }

    Connection get_connection()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }

        Connection con = null;

        try
        {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return con;
    }

    void close_connection(Connection con)
    {
        try
        {
            if (con != null)
            {
                con.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

    }

    void Modify(String cmd)
    {
        Connection con = null;

        try
        {
            con = get_connection();
            con.createStatement().execute(cmd);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        close_connection(con);
    }

    Vector Query(String cmd)
    {
        ResultSet res = null;
        Connection con = null;

        try
        {
            con = get_connection();
            res = con.createStatement().executeQuery(cmd);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        Vector data = getTable(res);
        close_connection(con);
        return data;
    }

}
