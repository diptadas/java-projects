/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.net.Socket;

public class ChatClientThread extends Thread
{

    Socket socket;
    int id;
    Operations op;

    public ChatClientThread(Socket clientSocket, int id)
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
                String cmd = op.receiveMsg();

                if (cmd.equals("END"))
                {
                    System.out.println("Client " + id + ": DISCONNECTED");
                    socket.close();
                    ChatServer.clientSockets[id] = null;
                    return;
                }
                else
                {
                    int receiverID = Integer.parseInt(cmd);
                    Socket receiverSocket = ChatServer.clientSockets[receiverID];

                    String msg = op.receiveMsg();

                    if (receiverSocket != null)
                    {
                        new Operations(receiverSocket).sendMsg("From " + id + ": " + msg);
                        op.sendMsg("Message sent");
                        System.out.println("Client " + id + ": Send to: " + receiverID + ":" + msg);
                    }
                    else
                    {
                        op.sendMsg("Receiver not connected");
                    }
                }
            }

            catch (Exception e)
            {
                System.err.println(e);
            }
        }
    }
}
