/*
 * Dipta Das CUET CSE 11
 */

package encapculationexample;

import package2.Class1;
import package2.Class2;


public class EncapculationExample extends Class2{
    
    public EncapculationExample()
    {
        Class2 obj = new Class2();
        obj.iAmPublic();
        //obj.iAmPrivet();
        //obj.iAmProtected(); //obj can not access
        //obj.iAmUnknown();
        iAmProtected(); //sub class can access
        //iAmUnknown();
    }

    public static void main(String[] args) {
        new EncapculationExample();
        new Class1();
    }

}
