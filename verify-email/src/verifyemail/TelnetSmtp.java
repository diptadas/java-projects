/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifyemail;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.telnet.TelnetClient;

/**
 *
 * @author dipta
 */
public class TelnetSmtp implements Runnable {

    TelnetClient tc;
    String result;
    boolean finished;

    public TelnetSmtp() {
        tc = null;
        result = "";
        finished = false;
    }

    public boolean call(String email, String host) throws Exception {

        tc = new TelnetClient();
        tc.connect(host, 25);

        Thread reader = new Thread(this);
        reader.start();

        OutputStream outstr = tc.getOutputStream();

        String cmd = "helo\n";
        outstr.write(cmd.getBytes(), 0, cmd.length());
        outstr.flush();

        cmd = "mail from:<interns@thetigerworks.com>\n";
        outstr.write(cmd.getBytes(), 0, cmd.length());
        outstr.flush();

        cmd = "rcpt to:<" + email + ">\n";
        outstr.write(cmd.getBytes(), 0, cmd.length());
        outstr.flush();

        Thread.sleep(2000);
        finished = true;

        tc.disconnect();

        int count = 0;

        for (String word : result.split("\\W+")) {
            if (word.equals("250")) {
                count++;
            }
        }

        return count >= 3;
    }

    @Override
    public void run() {
        InputStream instr = tc.getInputStream();

        try {
            byte[] buff = new byte[1024];
            int ret_read;

            do {
                ret_read = instr.read(buff);
                if (ret_read > 0) {
                    //System.out.print(new String(buff, 0, ret_read));
                    result += new String(buff, 0, ret_read);
                }
            } while (ret_read >= 0 && !finished);

        } catch (IOException e) {
            System.err.println("Exception while reading socket:" + e.getMessage());
        }
    }

}
