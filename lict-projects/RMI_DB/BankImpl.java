import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;
import java.util.*;

class BankImpl extends UnicastRemoteObject implements Bank{

	BankImpl() throws RemoteException{}

	public List<Customer> getCustomers()
	{
		List<Customer> list = new ArrayList<Customer>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LICT_MySQL","root","");
			PreparedStatement ps = con.prepareStatement("select * from customer");
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				Customer c=new Customer();
				c.setAcc_no(rs.getInt(1));
				c.setFirstname(rs.getString(2));
				c.setLastname(rs.getString(3));
				c.setAmount(rs.getFloat(4));
				list.add(c);
			}

			con.close();
		}
		catch(Exception e){System.out.println(e);}
		return list;
	}
}
