/*
 * Dipta Das CUET CSE 11
 */

package customexceptionexample;


public class CustomExceptionExample {

    public static void main(String[] args)
    {
        try
        {
            calculate(11);
        }
        catch (MyException e)
        {
            System.out.println("Exception caught " + e);
        }

    }

    public static void calculate(int x) throws MyException
    {
        if(x>10) throw new MyException("Greater than 10");
        else System.out.println("No exception");
    }

}
