package databaseproject;

import java.util.Vector;

public class Operation
{

    DBConnection con = new DBConnection();

    void CreateTables()
    {
        String seq_userid = "CREATE SEQUENCE user_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10";

        String seq_mobileid = "CREATE SEQUENCE mobile_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1 CACHE 10";

        String table_userinfo = "CREATE TABLE user_info(user_id int PRIMARY KEY, username varchar(50), " +
                "password varchar(20))";

        String table_brandinfo = "CREATE TABLE brand_info(brand_id int PRIMARY KEY, brand varchar(50))";

        String table_osinfo = "CREATE TABLE os_info(os_id int PRIMARY KEY, os varchar(50))";


        String table_mobileinfo = "create table mobile_info( " +
                "mobile_id int PRIMARY KEY, " +
                "brand_id int REFERENCES brand_info(brand_id), " +
                "model VARCHAR2(50), " +
                "year int, " +
                "os_id int REFERENCES os_info(os_id), " +
                "display VARCHAR2(50), " +
                "camera VARCHAR2(50), " +
                "cpu VARCHAR2(50), " +
                "ram VARCHAR2(50), " +
                "battery int, " +
                "price int)";

        con.Modify("BEGIN EXECUTE IMMEDIATE ' " + seq_userid + " ' ; EXCEPTION WHEN OTHERS THEN "
                + "IF SQLCODE != -955 THEN RAISE; END IF; END; ");

        con.Modify("BEGIN EXECUTE IMMEDIATE ' " + seq_mobileid + " ' ; EXCEPTION WHEN OTHERS THEN "
                + "IF SQLCODE != -955 THEN RAISE; END IF; END; ");

        con.Modify("BEGIN EXECUTE IMMEDIATE ' " + table_osinfo + " ' ; EXCEPTION WHEN OTHERS THEN "
                + "IF SQLCODE != -955 THEN RAISE; END IF; END; ");

        con.Modify("BEGIN EXECUTE IMMEDIATE ' " + table_userinfo + " ' ; EXCEPTION WHEN OTHERS THEN "
                + "IF SQLCODE != -955 THEN RAISE; END IF; END; ");

        con.Modify("BEGIN EXECUTE IMMEDIATE ' " + table_brandinfo + " ' ; EXCEPTION WHEN OTHERS THEN "
                + "IF SQLCODE != -955 THEN RAISE; END IF; END; ");

        con.Modify("BEGIN EXECUTE IMMEDIATE ' " + table_mobileinfo + " ' ; EXCEPTION WHEN OTHERS THEN "
                + "IF SQLCODE != -955 THEN RAISE; END IF; END; ");

    }

    void Check()
    {
        con.close_connection(con.get_connection());
        CreateTables();
    }

    boolean CheckUsername(String user)
    {
        user = "'" + user + "'";
        String sql = "SELECT COUNT(1) FROM user_info WHERE username = " + user;

        Vector<Vector<String>> data = con.Query(sql);
        String str = data.get(0).get(0);
        return str.equals("1");
    }

    boolean CheckPassword(String user, String pass)
    {
        user = "'" + user + "'";
        String sql = "SELECT password FROM user_info WHERE username = " + user;

        Vector<Vector<String>> data = con.Query(sql);
        String str = data.get(0).get(0);
        return str.equals(pass);
    }

    void InsertUser(String user, String pass)
    {
        user = "'" + user + "'";
        pass = "'" + pass + "'";
        String sql = "INSERT INTO user_info values(user_id_seq.nextval, " + user + "," + pass + ")";
        con.Modify(sql);
    }

    void InsertMobileInfo(Vector<String> data)
    {
        String ch1 = "'", ch2 = ",";

        String sql = "INSERT INTO mobile_info values(mobile_id_seq.nextval" + ch2;

        sql += "(SELECT brand_id FROM brand_info WHERE brand = " + ch1 + data.get(0) + ch1 + ")" + ch2;
        sql += ch1 + data.get(1) + ch1 + ch2;
        sql += data.get(2) + ch2;
        sql += "(SELECT os_id FROM os_info WHERE os = " + ch1 + data.get(3) + ch1 + ")" + ch2;
        sql += ch1 + data.get(4) + ch1 + ch2;
        sql += ch1 + data.get(5) + ch1 + ch2;
        sql += ch1 + data.get(6) + ch1 + ch2;
        sql += ch1 + data.get(7) + ch1 + ch2;
        sql += data.get(8) + ch2;
        sql += data.get(9) + ")";

        con.Modify(sql);
    }

    void UpdateMobileInfo(String mobile_id, Vector<String> data)
    {
        String ch1 = "'", ch2 = ",";

        String sql = "UPDATE mobile_info SET ";

        sql += "model = " + ch1 + data.get(0) + ch1 + ch2;
        sql += "year = " + data.get(1) + ch2;
        sql += "display = " + ch1 + data.get(2) + ch1 + ch2;
        sql += "camera = " + ch1 + data.get(3) + ch1 + ch2;
        sql += "cpu = " + ch1 + data.get(4) + ch1 + ch2;
        sql += "ram = " + ch1 + data.get(5) + ch1 + ch2;
        sql += "battery = " + data.get(6) + ch2;
        sql += "price = " + data.get(7);

        sql += " where mobile_id = " + mobile_id;

        new DBConnection().Modify(sql);
    }

    void DeleteMobileInfo(String ids)
    {
        String sql = "Delete from mobile_info where mobile_id in (" + ids + ")";
        con.Modify(sql);
    }

    Vector<Vector<String>> Search(String search_conditions)
    {
        String sql = "SELECT mobile_id, brand, model, year, os, display, camera, cpu, ram, battery, price FROM " +
                "mobile_info JOIN brand_info ON mobile_info.brand_id = brand_info.brand_id " +
                "JOIN os_info ON mobile_info.os_id = os_info.os_id WHERE ";
        sql += search_conditions + " ORDER BY mobile_id ASC";
        return con.Query(sql);
    }

    Vector<Vector<String>> Report1_res()
    {
        String sql = "SELECT brand, COUNT(mobile_id) Total " +
                "FROM MOBILE_INFO a JOIN BRAND_INFO b " +
                "ON a.brand_id = b.brand_id " +
                "GROUP BY brand";
        return con.Query(sql);
    }

    Vector<Vector<String>> Report2_res()
    {
        String sql = "SELECT mobile_id, model, brand, year, os, display, camera, cpu, ram, battery, price FROM " +
                "( " +
                "SELECT * FROM MOBILE_INFO a INNER JOIN " +
                "    ( " +
                "       SELECT MAX(price) max_price FROM MOBILE_INFO group by brand_id " +
                "    ) b ON a.price = b.max_price " +
                ") x " +
                "JOIN BRAND_INFO y ON x.brand_id = y.brand_id " +
                "JOIN os_info z ON x.os_id = z.os_id";
        return con.Query(sql);
    }

    Vector<Vector<String>> Report3_res()
    {
        String sql = "SELECT mobile_id, model, brand, " +
                "  ( " +
                "    CASE  " +
                "    WHEN price >= 25000 THEN '1.High' " +
                "    WHEN price >= 15000 THEN '2.Medium' " +
                "    ELSE '3.Low' " +
                "    END " +
                "  ) Class " +
                "FROM MOBILE_INFO a JOIN BRAND_INFO b ON a.brand_id = b.brand_id ORDER BY Class, brand";
        return con.Query(sql);
    }

    void DeleteUserInfo()
    {
        String sql = "Delete from user_info where username = " + "'" + Main.cur_user + "'";
        con.Modify(sql);
    }

    void ChangePassword(String pass)
    {
        pass = "'" + pass + "'";
        String sql = "Update user_info SET password = " + pass + " where username = " + "'" + Main.cur_user + "'";
        con.Modify(sql);
    }

}
