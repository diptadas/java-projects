/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer
{

    public static Socket[] clientSockets = new Socket[100];

    public ChatServer()
    {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try
        {
            serverSocket = new ServerSocket(Main.PORT);
            System.out.println("Server started on port " + Main.PORT);
        }
        catch (IOException e)
        {
            System.out.println(e);
            return;
        }

        int id = 0;

        while (true)
        {
            try
            {
                socket = serverSocket.accept();
                id++;
                clientSockets[id] = socket;
                new ChatClientThread(socket, id).start();
            }
            catch (IOException e)
            {
                System.out.println(e);
            }
        }
    }

}
