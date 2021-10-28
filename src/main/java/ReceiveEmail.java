/******************************************************************************
 * This piece of work is to enhance EmailApp project functionality.           *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ReceiveEmail.java                                               *
 * Created:   28/10/2021, 17:24                                               *
 * Modified:  28/10/2021, 17:25                                               *
 *                                                                            *
 * Copyright (c)  2021.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

import com.sun.mail.pop3.POP3Store;
import jakarta.mail.*;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class ReceiveEmail {

    public static String checkMail() {
        String response;
        response = "Success";
        Message[] messages;
        String emailHost;
        emailHost = null;
        String emailStore;
        emailStore = null;
        String emailUname;
        emailUname = null;
        String emailPword;
        emailPword = null;
        Session sess;
        POP3Store estore;
        estore = null;
        Folder dir;
        dir = null;
        try {
            File myFile;
            myFile = new File("/opt/secret/pop3.txt");
            Scanner myReader;
            myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                emailUname = myReader.nextLine();
                emailPword = myReader.nextLine();
                emailHost = myReader.nextLine();
                emailStore = myReader.nextLine();
            }
            myReader.close();
            Log.info("Successful reading email credentials");
        } catch (Exception e) {
            Log.error("Error reading email credentials: " + e);
        }
        try {
            Properties prop;
            prop = new Properties();
            prop.put("mail.pop3.host",emailHost);
            sess = Session.getDefaultInstance(prop);
            estore = (POP3Store) sess.getStore(emailStore);
            estore.connect(emailUname,emailPword);
            dir = estore.getFolder("INBOX");
            dir.open(Folder.READ_ONLY);
            messages = dir.getMessages();
            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                Log.info("==============================");
                Log.info("Email #" + (i + 1));
                Log.info("Subject: " + message.getSubject());
                Log.info("From: " + message.getFrom()[0]);
                Log.info("Time: " + message.getSentDate().getTime());
                Log.info("Body: " + message.getContent().toString());
            }
            dir.close(false);
            estore.close();
        } catch (NoSuchProviderException err) {
            Log.error("Error with the POP3 Store settings: " + err);
        } catch (MessagingException err) {
            Log.error("Error with the email and password credentials: " + err);
        } catch (IOException err) {
            Log.error("Error receiving email: " + err);
        }
        return response;
    }
}