package runnableexample;


public class MyThread implements Runnable
{
    Thread thread;

    public MyThread(String s)
    {
        thread = new Thread(this,s);
//        if (s.equals("Thread 1")) thread.setPriority(Thread.MAX_PRIORITY);
//        else thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }
    @Override
    public void run()
    {
        for(int i=1; i<=5; i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }

//        try
//        {
//            Thread.sleep(3000);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
    }                                                                           
}
