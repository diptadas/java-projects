/*
 * Dipta Das CUET CSE 11
 */

package threadexample;


public class ThreadExample {

    public static void main(String[] args) {
        System.out.println("Initial thread: " + Thread.currentThread().getName());
        MyThread obj = new MyThread("User Created Thread 1");
    }

}
