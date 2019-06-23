package com.fym.lta.ui;

import com.fym.lta.dto.SlotDto;

import com.jtattoo.plaf.mint.MintLookAndFeel;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import java.io.FileOutputStream;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

public class Utilities {


    // this method to achieve authorization opertion and block the user from going out of it's permission type
    public static void mandate(JButton updateBTN, JButton insertBTN, JButton deleteBTN, int screenID, boolean[] base2) {
        // view delete insert update
        if (base2 != null) { // now we will hide the buttons wich the user can't access
            if (base2[3] && updateBTN != null)
                updateBTN.setVisible(true);
            if (base2[2] && insertBTN != null)
                insertBTN.setVisible(true);
            if (base2[1] && deleteBTN != null)
                deleteBTN.setVisible(true);

        } else {
            updateBTN.setVisible(false);
            insertBTN.setVisible(false);
            deleteBTN.setVisible(false);
            JOptionPane.showMessageDialog(null, "Your Role not assigned yet so you can only view the data ");
        }


    }

    // Java method to calculate MD5 hash value

    public static String getMd5(String input) {
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
    public static int convertTOBase10(boolean[] base2) { // base10 = d0*1 + d1*2 + d2*4 + ... +di*2^i
        int base10 = 0; // hold the result
        int k = 0;
        // loop to get the sum
        for (int i = base2.length - 1; i >= 0; i--) {
            // true  --> 1
            // false --> 0
            int di = 0;
            if (base2[i])
                di = 1;

            // the relation
            base10 += di * Math.pow(2, k);
            k++;
        }
        return base10;
    }

    // this method invert to the method called convertTOBase10
    public static boolean[] convertTOBase2(int base10) {
        int container[] = new int[4];
        boolean base2[] = new boolean[4];
        int i = 0;
        while (base10 > 0) {
            container[i] = base10 % 2;
            i++;
            base10 = base10 / 2;

        }
        for (int j = i - 1; j >= 0; j--) {
            if (container[j] == 1)
                base2[j] = true;
            else
                base2[j] = false;

        }
        return base2;
    }

 // this method to install setLookAndFeel
    public static void setLookAndFeel() {
        try {
            Properties props = new Properties();
            props.put("logoString", " "); // this only to make a light side in menu
            MintLookAndFeel.setCurrentTheme(props);

            // UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"); // the best theme
            // UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");  // mac theme
            //  UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel"); // night theme
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
            // UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
            //  UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
            //  UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
            //  UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // method to ckeck if the char > max length implmented 

    public static boolean char_Limit_Ckeck(String word, int length) {

        String[] values = { "+", "-", "*", "?", ".", "!", "@", "#", "," };


        boolean flag = false;

        for (int i = 0; i < values.length; i++) {
            if (word.contains(values[i])) {
                word = word.replaceAll(values[i], "");
            }
        }
        if (word.length() < length) {

            flag = false;
        }

        else {
            flag = true;
        }


        return flag;
    }

    // Method For To Print Panel Contents
     public static void printRecord(JPanel panel){
         // Create PrinterJob Here
         PrinterJob printerJob = PrinterJob.getPrinterJob();
         // Set Printer Job Name
         printerJob.setJobName("Print Record");
         // Set Printable
         printerJob.setPrintable(new Printable() {
             @Override
             public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                 // Check If No Printable Content
                 if(pageIndex > 0){
                     return Printable.NO_SUCH_PAGE;
                 }
                 
                 // Make 2D Graphics to map content
                 Graphics2D graphics2D = (Graphics2D)graphics;
                 // Set Graphics Translations
                 // A Little Correction here Multiplication was not working so I replaced with addition
                 graphics2D.translate(pageFormat.getImageableX()+10, pageFormat.getImageableY()+10);
                 // This is a page scale. Default should be 0.3 I am using 0.5
                 graphics2D.scale(0.5, 0.5);
                 
                 // Now paint panel as graphics2D
                 panel.paint(graphics2D);
                 
                 // return if page exists
                 return Printable.PAGE_EXISTS;
             }
         });
         // Store printerDialog as boolean
         boolean returningResult = printerJob.printDialog();
         // check if dilog is showing
         if(returningResult){
             // Use try catch exeption for failure
             try{
                 // Now call print method inside printerJob to print
                 printerJob.print();
             }catch (PrinterException printerException){
                 JOptionPane.showMessageDialog(null, "Print Error: " + printerException.getMessage());
             }
         }
     }

//++++++++++++++++++++++++++++++++
     // method to export the table to pdf format 
     public static void export_PDF(JTable inputTable )
     {   String path = ""; // hold the path which the user will choos
          
         int colNum = inputTable.getColumnCount(); 
         // define java file chooser 
         JFileChooser  fchooser = new JFileChooser();
         // set mode 
         fchooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
         // showing save file dialoug 
         int uValue = fchooser.showSaveDialog(null);
         
         // check if the user select the place or no selecting
         if(uValue==JFileChooser.APPROVE_OPTION)
         {
             path = fchooser.getSelectedFile().getPath();
          }
          
          // create the document 
         Document doc  = new Document() ;
         // Calling writer and open the stream to write
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "Exported_LTA.pdf"));
            doc.open();
             // create output table    
            PdfPTable outTable = new PdfPTable(colNum);
             // loop to add header 
            for(int i=0; i<colNum; i++)
            {   // adding heeders 
                outTable.addCell(inputTable.getColumnName(i));
            } 
         
            
            // using neasted loop to getting the data from input table 
            for(int k=0; k<inputTable.getRowCount(); k++)
            {
               for(int j=0; j<colNum; j++)    
               {  // null exp pointer 
                   try {
                        outTable.addCell(inputTable.getValueAt(k, j).toString());
                    } catch (Exception e) {
                        outTable.addCell(" ");
                    }
                   
               }
            }
            
            // add the table to document 
            doc.add(outTable);
            JOptionPane.showMessageDialog(null, "the file saved"); 
                System.out.println(outTable.size());
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }

      // close the document 
        doc.close();

    }

// mehtod to sort the list based on the code 

   public static List<SlotDto> sort_ByCode(List<SlotDto> slots)
   {
     for(int i=0; i<slots.size(); i++)
       {
          for (int k=0; k<slots.size()-i-1 ; k++)
          {
           if(slots.get(k+1).getCode() < slots.get(k).getCode() )
           {// sawp slot no i , i+1 
           Collections.swap(slots, k, k+1);
           }
           
          }

       }
     
     
   return slots ; 
}
   
    //++++++++++++++++++++++++++++++++
         // method to export the table to pdf format 
         public static void export_XLX(JTable inputTable)
         {
             
        }  
}
