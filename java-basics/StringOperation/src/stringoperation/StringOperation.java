/*
 * Dipta Das CUET CSE 11
 */

package stringoperation;


public class StringOperation {

    public static void main(String[] args) {
        // string class or datatype
        String x = "CUETCSE"; //datatype
        String y = new String("CUETcse"); //class
        System.out.println(x + " " + y);

        //equals
        if(x.equals(y)) System.out.println("match");
        if(x.equalsIgnoreCase(y)) System.out.println("match ignoring case");

        //compare
        x = "ABC";
        y = "ABC";
        System.out.println(x.compareTo(y)); // x - y

        x = "ABX";
        y = "ABC";
        System.out.println(x.compareTo(y));

        x = "ABC";
        y = "ABX";
        System.out.println(x.compareTo(y));

        x = "ABCDEFG";
        y = "ABC";
        System.out.println(x.compareTo(y)); //len(x)-len(y)

        x = "ABC";
        y = "ABCDE";
        System.out.println(x.compareTo(y));

        //Substring
        x = "CUETCSE";
        System.out.println(x.substring(3)); //3 to end
        System.out.println(x.substring(3,5)); //3 to (5-1)

        //Region Match
        x = "abcCUeT";
        y = "xycuetxy";
        System.out.println(x.regionMatches(3, y, 2, 4)); //index_1st, 2nd_string, index_2nd, length
        System.out.println(x.regionMatches(true,3,y,2,4)); //true: case ignore, false: case consider
        
    }

}
