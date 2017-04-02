/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.io.File;
import java.net.Socket;

public class FileClientThread extends Thread
{

    Socket socket;
    int id;
    Operations op;

    public FileClientThread(Socket clientSocket, int id)
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

                if (cmd.equals("UPLOAD"))
                {
                    String fileName = op.receiveMsg();
                    op.receiveFile(Main.server_dir + "\\" + fileName);
                    System.out.println("Client " + id + ": UPLOADED " + fileName);
                }
                else if (cmd.equals("DOWNLOAD"))
                {
                    String fileName = op.receiveMsg();
                    op.sendFile(Main.server_dir + "\\" + fileName);
                    System.out.println("Client " + id + ": DOWNLOADED " + fileName);
                }
                else if (cmd.equals("LIST"))
                {
                    File[] listOfFiles = new File(Main.server_dir).listFiles();
                    String names = "";

                    for (int i = 0; i < listOfFiles.length; i++)
                    {
                        if (i != 0)
                        {
                            names += ":";
                        }
                        names += listOfFiles[i].getName();
                    }
                    
                    op.sendMsg(names);
                    System.out.println("Client " + id + ": VIEW LIST");

                }
                else if (cmd.equals("END"))
                {
                    System.out.println("Client " + id + ": DISCONNECTED");
                    socket.close();
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
