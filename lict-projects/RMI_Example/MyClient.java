import java.rmi.*;

public class MyClient
{
	public static void main(String args[])
	{
		try
		{
			Adder adder = (Adder) Naming.lookup("rmi://localhost:5000/SAMPLE");
			System.out.println(adder.add(30,50));
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
}