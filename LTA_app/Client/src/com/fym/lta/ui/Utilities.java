package com.fym.lta.ui;

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
                String str =
                    "Your current  permission on this screen is { " + permissionType +
                    " }  ask the admin to upgrade if you need ";
                JOptionPane.showMessageDialog(null, str);

            } else {
                updateBTN.setVisible(false);
                insertBTN.setVisible(false);
                deleteBTN.setVisible(false);
                JOptionPane.showMessageDialog(null, "Your Role not assigned yet so you can only view the data ");
            }


        }
}
