package threadexample;


public class MyThread extends Thread
{
    public MyThread(String s)
    {
        super(s);
        this.start();
    }

    @Override
    public void run()
    {
        System.out.println("Current thread: " + Thread.currentThread().getName());
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("After sleep");
    }
}
