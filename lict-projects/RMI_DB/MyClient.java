import java.util.*;
import java.rmi.*;

public class MyClient
{
	public static void main(String args[]) throws Exception
	{
		Bank b = (Bank) Naming.lookup("rmi://localhost:6666/o");

		System.out.println("Customer Data:");

		List<Customer> list = b.getCustomers();
		for(Customer c:list)
		{
			System.out.println(c.getAcc_no() + " " + c.getFirstname() + " " + c.getLastname() + " " + c.getAmount());
		}

	}
}
