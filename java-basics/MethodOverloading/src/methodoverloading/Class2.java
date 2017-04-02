/*
 * Dipta Das CUET CSE 11
 */

package methodoverloading;

/*
1. Number of parameters.
2. Data type of parameters.
3. Sequence of Data type of parameters.
*/


public class Class2 {
    
    public void call()
    {
        System.out.println("No parameter");
    }
    
    public void call(int n)
    {
        System.out.println(n);
    }
    
    public void call(String s)
    {
        System.out.println(s);
    }

}
