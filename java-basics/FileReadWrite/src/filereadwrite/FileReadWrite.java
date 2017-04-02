/*
 * Dipta Das CUET CSE 11
 */

package filereadwrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class FileReadWrite {

    public static void withBuffering()
    {
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;

        try
        {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Dipta\\Desktop\\in.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Dipta\\Desktop\\out2.txt"));

            String s;
            while ((s = bufferedReader.readLine()) != null)
            {
                bufferedWriter.write(s);
                // write a new line
                bufferedWriter.newLine();
                // flush
                bufferedWriter.flush();
            }

            bufferedReader.close();
            bufferedWriter.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void withoutBuffering()
    {
        FileReader reader;
        FileWriter writer;

        try
        {
            reader = new FileReader("C:\\Users\\Dipta\\Desktop\\in.txt");
            writer = new FileWriter("C:\\Users\\Dipta\\Desktop\\out.txt");

            int a;
            while ((a = reader.read()) != -1)
            {
                writer.write(a);
            }

            reader.close();
            writer.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    public static void main(String[] args)
    {
        withoutBuffering();
        withBuffering();
    }

}
