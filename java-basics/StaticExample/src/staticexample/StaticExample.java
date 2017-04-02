/*
 * Dipta Das CUET CSE 11
 */

package staticexample;


public class StaticExample {

    public static void main(String[] args) {
        Class2 ob1 = new Class2();
        Class2 ob2 = new Class2();

        ob1.x++;
        ob2.x++;
        System.out.println(ob1.x + " " + ob2.x);

        ob1.y++;
        ob2.y++;
        System.out.println(ob1.y + " " + ob2.y);

        System.out.println(Class2.y);
        
    }

}
