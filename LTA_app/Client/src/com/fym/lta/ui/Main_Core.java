
package com.fym.lta.ui;

import com.fym.lta.Bao.LoginEngine;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;


public class Main_Core {

    Main_Core main_Core = new Main_Core();

    public static void main(String[] args) {
        String usernameDe = " ";

        // check if the user logged
        boolean exists = false;
        try {
            exists =
                    new File(System.getProperty("user.dir"), "ab.txt").exists();

        } catch (Exception e) {
            e.printStackTrace();

        }

        if (exists) { // read the data


            try {
                String key =
                    "squirrel123"; // needs to be at least 8 characters for DES

                FileInputStream fis2 = new FileInputStream("ab.txt");
                FileOutputStream fos2 = new FileOutputStream("original");
                LoginEngine.decrypt(key, fis2, fos2);

                BufferedReader reader;
                try {
                    reader = new BufferedReader(new FileReader("original"));
                    usernameDe = reader.readLine();
                    reader.close();
                    System.out.print(usernameDe);
                    File file =
                        new File("original");
                    file.delete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // delete
            } catch (Throwable e) {
                e.printStackTrace();
            }

            if (LoginEngine.checkUsername(usernameDe)) {
                // now we know that login  done successfully so we can pass this user to our system 
                LoginEngine.currentUser =usernameDe ; 
                MMenu mu = new MMenu();
                mu.setVisible(true);
            } else {
                Login log = new Login();
                log.setVisible(true);
            }
        }

        else {
            Login log = new Login();
            log.setVisible(true);
        }
    }


}
