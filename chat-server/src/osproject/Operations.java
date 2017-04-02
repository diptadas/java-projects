/*
 * Dipta Das CUET CSE 11
 */
package osproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class Operations
{

    DataInputStream din;
    DataOutputStream dout;
    Socket socket;

    public Operations(Socket socket) throws Exception
    {
        this.socket = socket;
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());
    }

    public String receiveMsg() throws Exception
    {
        String msg = din.readUTF();
        return msg;
    }

    public void sendMsg(String msg) throws Exception
    {
        dout.writeUTF(msg);

    }

    public void receiveFile(String fileName) throws Exception
    {
        File file = new File(fileName);
        FileOutputStream fout = new FileOutputStream(file);

        int ch;
        String temp;

        do
        {
            temp = din.readUTF();
            ch = Integer.parseInt(temp);
            if (ch != -1)
            {
                fout.write(ch);
            }
        }
        while (ch != -1);
        fout.close();
    }

    public void sendFile(String fileName) throws Exception
    {
        File f = new File(fileName);

        if (!f.exists())
        {
            throw new Exception("File not exists");
        }
        else
        {
            FileInputStream fin = new FileInputStream(f);
            int ch;
            do
            {
                ch = fin.read();
                dout.writeUTF(String.valueOf(ch));
            }
            while (ch != -1);
            fin.close();

        }

    }

}
