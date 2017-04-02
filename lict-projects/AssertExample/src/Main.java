
public class Main {

	public static void main(String[] args)
	{
		int a = 5;
		int fact = 1;

		for (; a >= 1; a--)
			fact = fact + a; //fact=fact*a;

		assert (fact == 120) : "factorial is not Correct";

		System.out.println("Fact= " + fact);
	}

}
