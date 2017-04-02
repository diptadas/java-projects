import java.rmi.*;
import java.rmi.registry.*;

public class MyServer
{
	public static void main(String args[])
	{
		try
		{
			Adder adder = new AdderRemote();
			Naming.rebind("rmi://localhost:5000/SAMPLE", adder);
			System.out.println("Server Waiting and Ready...");
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
}