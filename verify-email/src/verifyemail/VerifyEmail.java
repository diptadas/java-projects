/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verifyemail;

import java.util.Scanner;

/**
 *
 * @author dipta
 */
public class VerifyEmail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Enter Email:");
        String email = new Scanner(System.in).next();
        //String email = "tigerworks.intern@gmail.com";

        String domain = email.substring(email.indexOf('@') + 1);

        try {
            String mailHost = NsLookup.lookupMailHosts(domain)[0];
            System.out.println("Mail Host: " + mailHost);
            System.out.println("Email Verification Status: " + new TelnetSmtp().call(email, mailHost));
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
