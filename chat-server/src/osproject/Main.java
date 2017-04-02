/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{

    public static int PORT;
    public static String server_dir = "C:\\OS_Project\\server_files";
    public static String client_dir = "C:\\OS_Project\\client_files";
    public static String client_downloads = "C:\\OS_Project\\client_downloads";

    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1.Echo Server 2.Chat Server 3.File Server 4.Exit");
        System.out.println("Enter choice:");
        int choice = Integer.parseInt(br.readLine());

        System.out.println("1.Server 2.Client");
        System.out.println("Enter choice:");
        int choice2 = Integer.parseInt(br.readLine());
        
        System.out.println("Enter port:");
        PORT = Integer.parseInt(br.readLine());

        if (choice == 1)
        {
            if (choice2 == 1)
            {
                new EchoServer();
            }
            else
            {
                new EchoClient();
            }

        }
        else if (choice == 2)
        {
            if (choice2 == 1)
            {
                new ChatServer();
            }
            else
            {
                new ChatClient();
            }
        }
        else if (choice == 3)
        {
            if (choice2 == 1)
            {
                new FileServer();
            }
            else
            {
                new FileClient();
            }

        }
    }
}
