/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Socket;

public class EchoClient
{

    Socket socket;
    Operations op;

    public EchoClient()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

        while (true)
        {
            try
            {
                System.out.println("1.SEND 2.EXIT");
                System.out.println("Enter choice:");

                int choice = Integer.parseInt(br.readLine());

                if (choice == 1)
                {
                    System.out.println("Write msg:");
                    String msg = br.readLine();
                    op.sendMsg(msg);
                    String reply = op.receiveMsg();
                    System.out.println("Server Reply: " + reply);
                }
                else if (choice == 2)
                {
                    op.sendMsg("END");
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
