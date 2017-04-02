/*
 * Dipta Das CUET CSE 11
 */

package customexceptionexample;


public class MyException extends Exception
{
    String value;

    public MyException(String s)
    {
        value = "MyException: " + s;
    }

    public String toString()
    {
        return value;
    }
}
