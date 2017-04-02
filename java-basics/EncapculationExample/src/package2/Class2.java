/*
 * Dipta Das CUET CSE 11
 */

package package2;


public class Class2
{
    public void iAmPublic()
    {
        System.out.println("this is public class");
    }

    private void iAmPrivet()
    {
        System.out.println("this is privet class");
    }

    protected void iAmProtected()
    {
        System.out.println("this is Protected class");
    }

    void iAmUnknown() //no identifier - package private
    {
        System.out.println("this is default class");
    }
}
