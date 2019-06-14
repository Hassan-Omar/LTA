package com.fym.lta.ui;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Utilities {
   
   

    // this method to achieve authorization opertion and block the user from going out of it's permission type
       public static void mandate(JButton updateBTN ,JButton insertBTN , JButton deleteBTN ,int screenID ,boolean[] base2) {
          // view delete insert update 
            if (base2 != null) { // now we will hide the buttons wich the user can't access
                if (base2[3])
                    updateBTN.setVisible(false);
                if (base2[2])
                    insertBTN.setVisible(false);
                if (base2[1])
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
        
        // this method created to screen_role to convert the boolean value of selected 
        public static int convertTOBase10 (boolean[] base2)
        {   // base10 = d0*1 + d1*2 + d2*4 + ... +di*2^i
            int base10 = 0 ; // hold the result 
            int k=0 ;
            // loop to get the sum 
            for (int i=base2.length-1; i>=0; i--)
            {   
                // true  --> 1
                // false --> 0
                int di = 0 ; 
                if(base2[i])
                    di = 1 ;
               
                // the relation
                base10+=di*Math.pow(2,k);
                k++ ;
            }
       return base10; }
        
    // this method invert to the method called convertTOBase10
    public static boolean[]  convertTOBase2 (int base10)
    {     
    int container[] = new int[100];
    boolean base2[] = new boolean[100];
    int i = 0;
    while (base10 > 0){
        container[i] = base10%2;
        i++;
        base10 = base10/2;
    }
    for (int j = i -1 ; j >= 0 ; j--){
        if(container[j]==1)
        base2[i] = true ; 
        else 
        base2[i] = false ;
         
    }
    return base2;
    }
    
    
    
    }

