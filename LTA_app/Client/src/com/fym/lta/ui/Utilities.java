package com.fym.lta.ui;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Utilities {
   
   

    // this method to achieve authorization opertion and block the user from going out of it's permission type
       public static void mandate(JButton updateBTN ,JButton insertBTN , JButton deleteBTN ,int screenID ,String permissionType) {
          
            if (permissionType != null) { // now we will hide the buttons wich the user can't access
                if (!(permissionType.contains("update")))
                    updateBTN.setVisible(false);
                if (!(permissionType.contains("insert")))
                    insertBTN.setVisible(false);
                if (!(permissionType.contains("delete")))
                    deleteBTN.setVisible(false);
              
            } else {
                updateBTN.setVisible(false);
                insertBTN.setVisible(false);
                deleteBTN.setVisible(false);
                JOptionPane.showMessageDialog(null, "Your Role not assigned yet so you can only view the data ");
            }


        }
     
    // Java method to calculate MD5 hash value 
   
        public static String getMd5(String input) 
        { 
            try { 
      
                // Static getInstance method is called with hashing MD5 
                MessageDigest md = MessageDigest.getInstance("MD5"); 
      
                // digest() method is called to calculate message digest 
                //  of an input digest() return array of byte 
                byte[] messageDigest = md.digest(input.getBytes()); 
      
                // Convert byte array into signum representation 
                BigInteger no = new BigInteger(1, messageDigest); 
      
                // Convert message digest into hex value 
                String hashtext = no.toString(16); 
                while (hashtext.length() < 32) { 
                    hashtext = "0" + hashtext; 
                } 
                return hashtext; 
            }  
      
            // For specifying wrong message digest algorithms 
            catch (NoSuchAlgorithmException e) { 
                throw new RuntimeException(e); 
            } 
        } 
}
