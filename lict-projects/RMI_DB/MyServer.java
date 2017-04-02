import java.rmi.*;

public class MyServer
{
	public static void main(String args[]) throws Exception
	{
		Bank r = new BankImpl();
		Naming.rebind("rmi://localhost:6666/o",r);
		System.out.println("Server Started");
	}
}
