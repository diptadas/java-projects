/*
 * Dipta Das CUET CSE 11
 */

package exceptionthrowingexample;


public class ExceptionThrowingExample {

    public static void main(String[] args)
    {
        try
        {
            compute(0);
        }
        catch (Exception e)
        {
            System.out.println("Exception caught " + e);
        }
    }

    public static void compute(int s) throws ArithmeticException
    {
        if (s == 0) throw new ArithmeticException("Don't divide by 0");
        else System.out.println(10 / s);

    }

}
