/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatClient
{

    Socket socket;
    Operations op;

    public ChatClient()
    {
        try
        {
            String host = "localhost";
            socket = new Socket(host, Main.PORT);
            op = new Operations(socket);
            System.out.println("CONNECTED with " + host + ":" + Main.PORT);
        }
        catch (Exception e)
        {
            System.err.println(e);
            return;
        }

        Thread thread = new Thread(new Runnable()
        {

            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                while (!Thread.interrupted())
                {
                    try
                    {
                        String msg = op.receiveMsg();
                        System.out.println("SERVER: " + msg);
                        System.out.println("1. SEND 2. Exit");
                    }
                    catch (Exception e)
                    {
                        System.err.println(e);
                    }

                }
            }

        });
        thread.start();

        while (true)
        {
            System.out.println("1. SEND 2. Exit");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try
            {
                int choice = Integer.parseInt(br.readLine());

                if (choice == 1)
                {
                    System.out.println("Send to: ");
                    String receiver = br.readLine();

                    System.out.println("Write message: ");
                    String msg = br.readLine();

                    op.sendMsg(receiver);
                    op.sendMsg(msg);
                }
                else
                {
                    op.sendMsg("END");
                    thread.interrupt();
                    return;
                }
            }
            catch (Exception e)
            {
                System.err.println(e);
            }
        }

    }
}
