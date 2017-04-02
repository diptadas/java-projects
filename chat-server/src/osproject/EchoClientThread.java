/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.io.File;
import java.net.Socket;

public class EchoClientThread extends Thread
{

    Socket socket;
    int id;
    Operations op;

    public EchoClientThread(Socket clientSocket, int id)
    {
        this.socket = clientSocket;
        this.id = id;

        System.out.println("Client " + id + ": CONNECTED");
    }

    @Override
    public void run()
    {

        try
        {
            op = new Operations(socket);
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
                String msg = op.receiveMsg();

                if (msg.equals("END"))
                {
                    System.out.println("Client " + id + ": DISCONNECTED");
                    socket.close();
                    return;
                }
                else
                {
                    System.out.println("Client " + id + ": " + msg);
                    op.sendMsg(msg);
                }
            }

            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }
}
