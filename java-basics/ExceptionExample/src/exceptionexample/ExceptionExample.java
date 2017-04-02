/*
 * Dipta Das CUET CSE 11
 */

package exceptionexample;


public class ExceptionExample {

    public static void main(String[] args) {
                try{
            int a = 5/0;
            System.out.println("After division " + a);
        }
        catch (Exception e)
        {
            System.out.println("Exception caught " + e);
        }
        finally {
            System.out.println("finaly block");
        }
        System.out.println("try catch block end");
        
    }

}
