/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Socket;

public class FileClient
{

    Socket socket;
    Operations op;

    public FileClient()
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
                System.out.println("1.UPLOAD 2.DOWNLOAD 3.LIST 4.EXIT");
                System.out.println("Enter choice:");

                int choice = Integer.parseInt(br.readLine());

                if (choice == 1)
                {
                    File[] listOfFiles = new File(Main.client_dir).listFiles();

                    for (int i = 1; i <= listOfFiles.length; i++)
                    {
                        System.out.println(i + ". " + listOfFiles[i - 1].getName());
                    }
                    System.out.println("0. cancel upload");

                    System.out.println("Enter file no:");
                    int fileNo = Integer.parseInt(br.readLine());

                    if (fileNo > 0 && fileNo <= listOfFiles.length)
                    {
                        op.sendMsg("UPLOAD");
                        String fileName = listOfFiles[fileNo - 1].getName();

                        System.out.println("UPLOADEDING.....");

                        op.sendMsg(fileName);
                        op.sendFile(Main.client_dir + "\\" + fileName);

                        System.out.println("FILE UPLOADED");
                    }
                    else
                    {
                        System.out.println("UPLOAD CANCLED");
                    }
                }
                else if (choice == 2)
                {
                    op.sendMsg("LIST");
                    String msg = op.receiveMsg();

                    String[] names = msg.split(":");

                    for (int i = 1; i <= names.length; i++)
                    {
                        System.out.println(i + ". " + names[i - 1]);
                    }
                    System.out.println("0. cancel download");

                    System.out.println("Enter file no:");
                    int fileNo = Integer.parseInt(br.readLine());

                    if (fileNo > 0 && fileNo <= names.length)
                    {
                        String fileName = names[fileNo - 1];
                        op.sendMsg("DOWNLOAD");

                        System.out.println("DOWNLOADEDING.....");

                        op.sendMsg(fileName);
                        op.receiveFile(Main.client_downloads + "\\" + fileName);

                        System.out.println("FILE DOWNLOADED");
                    }
                    else
                    {
                        System.out.println("DOWNLOAD CANCLED");
                    }

                }
                else if (choice == 3)
                {
                    op.sendMsg("LIST");
                    String msg = op.receiveMsg();

                    String[] names = msg.split(":");

                    for (int i = 1; i <= names.length; i++)
                    {
                        System.out.println(i + ". " + names[i - 1]);
                    }

                }
                else if (choice == 4)
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
