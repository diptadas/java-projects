
/**
 *
 * @author dipta
 */
import java.io.*;
import java.net.*;
import java.util.*;

public class ProxyServer extends Thread {

    String[] blocked = {"facebook", "youtube"};

    Socket connectedClient = null;
    BufferedReader inFromClient = null;
    DataOutputStream outToClient = null;

    String dataFile = null;

    public ProxyServer(Socket client) {
        connectedClient = client;
    }

    public void run() {

        try {

            System.out.println("The Client "
                    + connectedClient.getInetAddress() + ":" + connectedClient.getPort() + " is connected");

            inFromClient = new BufferedReader(new InputStreamReader(connectedClient.getInputStream()));
            outToClient = new DataOutputStream(connectedClient.getOutputStream());

            String requestString = inFromClient.readLine();
            String headerLine = requestString;

            if (headerLine == null) {
                outToClient.close();
                return;
            }

            StringTokenizer tokenizer = new StringTokenizer(headerLine);
            String httpMethod = tokenizer.nextToken();
            String httpQueryString = tokenizer.nextToken();

//            while (inFromClient.ready()) 
//            {
//                // Read the HTTP complete HTTP Query           
//                requestString = inFromClient.readLine();
//            }
            if (httpMethod.equals("GET")) {

                for (String item : blocked) {
                    if (httpQueryString.toLowerCase().contains(item.toLowerCase())) {
                        outToClient.writeBytes("Site Blocked");
                        outToClient.close();
                        return;
                    }
                }

                dataFile = httpQueryString.replaceAll("[^\\w\\s]", "");
                if (!new File(dataFile).isFile()) {
                    call(httpQueryString.substring(1));
                }

                sendResponse(dataFile);
            }

            outToClient.close();

        } catch (Exception e) {
            try {
                //e.printStackTrace();
                outToClient.writeBytes("404 Not found");
                outToClient.close();
            } catch (IOException ex) {
                //e.printStackTrace();
            }
        }
    }

    public void call(String input) throws Exception {
        URL url = new URL(input);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    public void sendResponse(String fileName) throws Exception {

        String statusLine = "HTTP/1.1 200 OK" + "\r\n";
        String serverdetails = "Server: Java HTTPServer";
        String contentTypeLine = "Content-Type: text/html" + "\r\n";
        FileInputStream fin = new FileInputStream(fileName);
        String contentLengthLine = "Content-Length: " + Integer.toString(fin.available()) + "\r\n";

        outToClient.writeBytes(statusLine);
        outToClient.writeBytes(serverdetails);
        outToClient.writeBytes(contentTypeLine);
        outToClient.writeBytes(contentLengthLine);
        outToClient.writeBytes("Connection: close\r\n");
        outToClient.writeBytes("\r\n");

        sendFile(fin, outToClient);
        outToClient.close();
    }

    public void sendFile(FileInputStream fin, DataOutputStream out) throws Exception {
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = fin.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        fin.close();
    }

    public static void main(String args[]) throws Exception {

        ServerSocket Server = new ServerSocket(5000, 10, InetAddress.getByName("127.0.0.1"));
        System.out.println("TCPServer Waiting for client on port 5000");

        while (true) {
            Socket connected = Server.accept();
            (new ProxyServer(connected)).start();
        }
    }
}
