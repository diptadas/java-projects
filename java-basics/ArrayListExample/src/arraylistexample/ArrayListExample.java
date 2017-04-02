/*
 * Dipta Das CUET CSE 11
 */

package arraylistexample;

import java.util.ArrayList;


public class ArrayListExample {

    public static void main(String[] args) {
        ArrayList aList = new ArrayList();

        /*
        ArrayList<Integer> bList = new ArrayList<Integer>();
         */

        System.out.println("Initial size: " + aList.size());

        aList.add("A");
        aList.add("B");
        aList.add("C");
        System.out.println("New size: " + aList.size());
        System.out.println("Content: " + aList);

        aList.add(2,"D");
        System.out.println("Content: " + aList);

        aList.addAll(aList);
        System.out.println("Content: " + aList);

        aList.addAll(2,aList);
        System.out.println("Content: " + aList);

        aList.remove(3);
        System.out.println("Content: " + aList);

        aList.remove("D");
        System.out.println("Content: " + aList);
    }

}
