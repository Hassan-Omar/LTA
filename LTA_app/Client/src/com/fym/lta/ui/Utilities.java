package com.fym.lta.ui;

import com.fym.lta.dto.CourseDto;
import com.fym.lta.dto.EmployeeDto;
import com.fym.lta.dto.LocationTypeDto;
import com.fym.lta.dto.SchedualDto;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Utilities {


    // this method to achieve authorization opertion and block the user from going out of it's permission type
    public static void mandate(JButton updateBTN, JButton insertBTN, JButton deleteBTN, int screenID, boolean[] base2) {
        // view delete insert update
        if (base2 != null) { // now we will hide the buttons wich the user can't access
            if (base2[3] && updateBTN != null)
                updateBTN.setVisible(true);
            else 
                updateBTN.setVisible(false);  
            
            if (base2[2] && insertBTN != null)
                insertBTN.setVisible(true);
            else 
                insertBTN.setVisible(false);
            
            if (base2[1] && deleteBTN != null)
                deleteBTN.setVisible(true);
            else 
                deleteBTN.setVisible(false);
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
         // Method to  Create Printer Job 
                PrinterJob printerJob = PrinterJob.getPrinterJob();
                // Method to Printer Job Name
                printerJob.setJobName("Print Record");
                // Method to  Printable
                printerJob.setPrintable(new Printable() {
                    @Override
                    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                        // Check If No Printable Content
                        if(pageIndex > 0){
                            return Printable.NO_SUCH_PAGE;
                        }
                        
                        // Make 2D Graphics 
                        Graphics2D graphics2D = (Graphics2D)graphics;
                        // Set Graphics Translations
                        graphics2D.translate(pageFormat.getImageableX()+10, pageFormat.getImageableY()+10);
                        // This is a page scale
                        graphics2D.scale(1,1);
                        
                        // Now paint panel as graphics2D
                        panel.paint(graphics2D);
                        
                        // return if page exists
                        return Printable.PAGE_EXISTS;
                    }
                });
                
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
                outTable.addCell("+"+inputTable.getColumnName(i));
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

   /*  public static List<SlotDto> sort_ByCode(List<SlotDto> slots)
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
} */
   
    //++++++++++++++++++++++++++++++++
         // method to export the schedual table to xls format 
         public static void exportSch_XLX(JTable inputTable)
         {   
            SchedualDto schedule = new SchedualDto();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");   
            int returnVal =  fileChooser.showSaveDialog(null);     
            if (returnVal == JFileChooser.APPROVE_OPTION) {
              String  filepath = fileChooser.getSelectedFile().getAbsolutePath();
              File file = new File(filepath +".xls");
                 if (file.exists() == false) {
                         HSSFWorkbook workbook = new HSSFWorkbook();
                         HSSFSheet Sheet = workbook.createSheet(); 
                         HSSFRow DepartmentCodeRow = Sheet.createRow(0);
                         HSSFRow AcademicYearRow = Sheet.createRow(1);
                         HSSFRow ScheduleCodeRow = Sheet.createRow(2);
                         HSSFRow TimeSlotRow = Sheet.createRow(3);
                         HSSFRow RowAfterTimeSlot = Sheet.createRow(4);
                         
                         
                         AcademicYearRow.createCell(1).setCellValue(schedule.getAcademicYear());
                         DepartmentCodeRow.createCell(0).setCellValue(schedule.getDepartment().getName());
                         DepartmentCodeRow.createCell(1).setCellValue(schedule.getCodeDeparment()); 
                         ScheduleCodeRow.createCell(0).setCellValue("SCHEDULECODE"); 
                         ScheduleCodeRow.createCell(1).setCellValue(schedule.getSCHEDULECODE()); 
                         AcademicYearRow.createCell(2).setCellValue("STUDENT NUMBER");
                         AcademicYearRow.createCell(3).setCellValue(schedule.getStudent_number());
                         TimeSlotRow.createCell(0).setCellValue("Time slot");
                         TimeSlotRow.createCell(1).setCellValue("1st slot");
                         TimeSlotRow.createCell(3).setCellValue("2nd slot");
                         TimeSlotRow.createCell(5).setCellValue("3rd slot");
                         TimeSlotRow.createCell(7).setCellValue("4th slot");
                           for(int i=1; i<8; i+=2) {
                               RowAfterTimeSlot.createCell(i).setCellValue("start-end");}
                         RowAfterTimeSlot.createCell(2).setCellValue("8.50");
                         RowAfterTimeSlot.createCell(4).setCellValue("10.20");
                         RowAfterTimeSlot.createCell(6).setCellValue("12.30");
                         RowAfterTimeSlot.createCell(8).setCellValue("2");
                         HSSFRow row1 =  Sheet.createRow(5);
                         row1.createCell(0).setCellValue("Sunday");
                         HSSFRow row2 =  Sheet.createRow(10);
                         row2.createCell(0).setCellValue("Monday");
                         HSSFRow row3 =  Sheet.createRow(15);
                         row3.createCell(0).setCellValue("Tuesday");
                         HSSFRow row4 =  Sheet.createRow(20);
                         row4.createCell(0).setCellValue("Wednesday");
                         HSSFRow row5 =  Sheet.createRow(25);
                         row5.createCell(0).setCellValue("Thursday");

                         for (int i = 5; i < 30; i += 5){                       
                              HSSFRow courseNameRow = Sheet.createRow(i); 
                              HSSFRow StaffNameRow = Sheet.createRow(i + 1);
                              HSSFRow TypeRow = Sheet.createRow(i + 3);
                              HSSFRow PrefSpaceRow = Sheet.createRow(i + 4);   
                                          
                               for (int k = 1; k < 9; k += 2){                                    
                                    EmployeeDto instructor = new EmployeeDto();
                                    StaffNameRow.createCell(k).setCellValue(instructor.getCareerDgree()+"/t"+instructor.getFName()+ "/t" +instructor.getSName()+ "/t"+instructor.getLName()+"/t"+instructor.getFamilyName());                               
                            
                                    CourseDto course = new CourseDto();
                                    courseNameRow.createCell(k+1).setCellValue(course.getCode());
                                    courseNameRow.createCell(k).setCellValue(course.getName());
                                     
                                    LocationTypeDto loctionType = new LocationTypeDto() ;
                                    TypeRow.createCell(k).setCellValue("Type");
                                    TypeRow.createCell(k+1).setCellValue(loctionType.getCode());
                                    PrefSpaceRow.createCell(k).setCellValue("PrefSpace");
                                    PrefSpaceRow.createCell(k+1).setCellValue(course.getNeededLocType().getCode());
                                              } // end of inner loop
                                              } // end of outer loop
                                try (
                                   //Write the workbook in file 
                                    FileOutputStream out = new FileOutputStream(file)) {
                                    workbook.write(out);
                                    JOptionPane.showMessageDialog(null, "File Saved Successfully ");
                                        }
                         catch (IOException e){
                             System.out.println("error");
                               }
                     }
                
                          else { // Sheet already exists
                               JOptionPane.showMessageDialog(null,"File already exist");}       
                                
                      }
                      else { // Sheet already exists
                        JOptionPane.showMessageDialog(null,"User cancelled  ");}       
                         
                            }   
        
      
      
      
      
      
            public static void schResetModel(JTable table, List<SlotDto> slots) 
            {  


                if (slots != null) {
                    Object[][] sArray = new Object[25][5];
                    //======
                    sArray[0][0] = "Sunday";
                    sArray[1][0] = "  ";
                    sArray[2][0] = " ";
                    sArray[3][0] = " ";
                    sArray[4][0] = " ";
                    sArray[5][0] = "Monday";
                    sArray[6][0] = " ";
                    sArray[7][0] = " ";
                    sArray[8][0] = " ";
                    sArray[9][0] = " ";
                    sArray[10][0] = "Tuesday";
                    sArray[11][0] = " ";
                    sArray[12][0] = " ";
                    sArray[13][0] = " ";
                    sArray[14][0] = " ";
                    sArray[15][0] = "Wednesday";
                    sArray[16][0] = " ";
                    sArray[17][0] = " ";
                    sArray[18][0] = " ";
                    sArray[19][0] = " ";
                    sArray[20][0] = "Thursday";
                    sArray[21][0] = " ";
                    sArray[22][0] = " ";
                    sArray[23][0] = " ";
                    sArray[24][0] = " ";

                    // loop and check
                    int flagSlot1 = 0;
                    int flagSlot2 = 0;
                    int flagSlot3 = 0;
                    int flagSlot4 = 0;
                    int flagSlot5 = 0;
                    int flagSlot6 = 0;
                    int flagSlot7 = 0;
                    int flagSlot8 = 0;
                    int flagSlot9 = 0;
                    int flagSlot10 = 0;
                    int flagSlot11 = 0;
                    int flagSlot12 = 0;
                    int flagSlot13 = 0;
                    int flagSlot14 = 0;
                    int flagSlot15 = 0;
                    int flagSlot16 = 0;
                    int flagSlot17 = 0;
                    int flagSlot18 = 0;
                    int flagSlot19 = 0;
                    int flagSlot20 = 0;
                    for (int i = 0; i < slots.size(); i++) {
                        /// Slot 1
                        if (slots.get(i).getCode() == 1)

                        {
                            sArray[0][1] =
                                slots.get(i).getCurrentCourse().getName() + "    " + slots.get(i).getCurrentCourse().getCode();
                            sArray[3][1] = slots.get(i).getCurrentLocation().getCode();
                        }

                        if (slots.get(i).getCode() == 1 && flagSlot1 != 0) {
                            sArray[2][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }

                        if (slots.get(i).getCode() == 1 && flagSlot1 == 0) {
                            sArray[1][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot1 = 1;
                        }


                        //                       ///Slot 2
                        if (slots.get(i).getCode() == 2) {
                            sArray[0][2] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[3][2] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 2 && flagSlot2 != 0) {
                            sArray[2][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }

                        if (slots.get(i).getCode() == 2 && flagSlot2 == 0) {
                            sArray[1][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot2 = 1;
                        }

                        //slot 3
                        if (slots.get(i).getCode() == 3)

                        {
                            sArray[0][3] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[3][3] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 3 && flagSlot3 != 0) {
                            sArray[2][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 3 && flagSlot3 == 0) {
                            sArray[1][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot3 = 1;
                        }

                        //slot 4
                        if (slots.get(i).getCode() == 4)

                        {
                            sArray[0][4] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[3][4] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 4 && flagSlot4 != 0) {
                            sArray[2][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 4 && flagSlot4 == 0) {
                            sArray[1][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot4 = 1;
                        }
                        //
                        // Slot 5
                        if (slots.get(i).getCode() == 5) {
                            sArray[5][1] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[8][1] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 5 && flagSlot5 != 0)

                        {
                            sArray[7][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 5 && flagSlot5 == 0) {
                            sArray[6][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot5 = 1;
                        }

                        //slot 6
                        if (slots.get(i).getCode() == 6) {
                            sArray[5][2] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[8][2] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 7 && flagSlot6 != 0) {
                            sArray[7][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }

                        if (slots.get(i).getCode() == 6 && flagSlot6 == 0) {
                            sArray[6][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot6 = 1;
                        }

                        //slot 7
                        if (slots.get(i).getCode() == 7) {
                            sArray[5][3] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[8][3] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 7 && flagSlot7 != 0) {
                            sArray[7][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 7 && flagSlot7 == 0) {
                            sArray[6][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot7 = 1;
                        }

                        //slot 8
                        if (slots.get(i).getCode() == 8) {
                            sArray[5][4] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[8][4] = slots.get(i).getCurrentLocation().getCode();

                        }
                        if (slots.get(i).getCode() == 8 && flagSlot8 != 0) {
                            sArray[7][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 8 && flagSlot8 == 0) {
                            sArray[6][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot8 = 1;
                        }

                        //slot9
                        if (slots.get(i).getCode() == 9) {
                            sArray[10][1] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[13][1] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 9 && flagSlot9 != 0) {
                            sArray[12][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 9 && flagSlot9 == 0) {
                            sArray[11][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot9 = 1;
                        }
                        //slot 10
                        if (slots.get(i).getCode() == 10) {
                            sArray[10][2] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[13][2] = slots.get(i).getCurrentLocation().getCode();

                        }
                        if (slots.get(i).getCode() == 10 && flagSlot10 != 0) {
                            sArray[12][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }

                        if (slots.get(i).getCode() == 10 && flagSlot10 == 0) {
                            sArray[11][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot10 = 1;
                        }
                        //slot 11
                        if (slots.get(i).getCode() == 11) {
                            sArray[10][3] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[13][3] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 11 && flagSlot11 != 0) {
                            sArray[12][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 11 && flagSlot11 == 0) {
                            sArray[11][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot11 = 1;
                        }

                        //slot 12
                        if (slots.get(i).getCode() == 12 && flagSlot12 == 0) {
                            sArray[10][4] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[13][4] = slots.get(i).getCurrentLocation().getCode();

                        }
                        if (slots.get(i).getCode() == 12 && flagSlot12 != 0) {
                            sArray[12][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 12 && flagSlot12 == 0) {
                            sArray[11][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot12 = 1;
                        }
                        //slot 13
                        if (slots.get(i).getCode() == 13) {
                            sArray[15][1] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[18][1] = slots.get(i).getCurrentLocation().getCode();

                        }
                        if (slots.get(i).getCode() == 13 && flagSlot13 != 0) {
                            sArray[17][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 13 && flagSlot13 == 0) {
                            sArray[16][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot13 = 1;
                        }

                        //slot 14
                        if (slots.get(i).getCode() == 14) {
                            sArray[15][2] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[18][2] = slots.get(i).getCurrentLocation().getCode();

                        }
                        if (slots.get(i).getCode() == 14 && flagSlot14 != 0) {
                            sArray[17][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }

                        if (slots.get(i).getCode() == 14 && flagSlot14 == 0) {
                            sArray[16][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot14 = 1;
                        }
                        //slot 15
                        if (slots.get(i).getCode() == 15) {
                            sArray[15][3] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[18][3] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 15 && flagSlot15 != 0) {
                            sArray[17][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 15 && flagSlot15 == 0) {
                            sArray[16][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot15 = 1;
                        }

                        //slot 16
                        if (slots.get(i).getCode() == 16) {
                            sArray[15][4] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[18][4] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 16 && flagSlot16 != 0) {
                            sArray[17][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 16 && flagSlot16 == 0) {
                            sArray[16][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot16 = 1;
                        }

                        //slot 17
                        if (slots.get(i).getCode() == 17) {
                            sArray[20][1] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[23][1] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 16 && flagSlot17 != 0) {
                            sArray[22][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 17 && flagSlot17 == 0) {
                            sArray[21][1] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot17 = 1;
                        }

                        //slot 18
                        if (slots.get(i).getCode() == 18) {
                            sArray[20][2] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[23][2] = slots.get(i).getCurrentLocation().getCode();

                        }
                        if (slots.get(i).getCode() == 18 && flagSlot18 != 0) {
                            sArray[22][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 18 && flagSlot18 == 0) {
                            sArray[21][2] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot18 = 1;
                        }

                        //                        //slot 19
                        if (slots.get(i).getCode() == 19) {
                            sArray[20][3] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[23][3] = slots.get(i).getCurrentLocation().getCode();

                        }
                        if (slots.get(i).getCode() == 19 && flagSlot19 != 0) {
                            sArray[22][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 19 && flagSlot19 == 0) {
                            sArray[21][3] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot19 = 1;
                        }
                        //                        //slot 20
                        if (slots.get(i).getCode() == 20) {
                            sArray[20][4] =
                                slots.get(i).getCurrentCourse().getName() + " " + slots.get(i).getCurrentCourse().getCode();
                            sArray[23][4] = slots.get(i).getCurrentLocation().getCode();
                        }
                        if (slots.get(i).getCode() == 20 && flagSlot20 != 0) {
                            sArray[22][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                        }
                        if (slots.get(i).getCode() == 20 && flagSlot20 == 0) {
                            sArray[21][4] =
                                slots.get(i).getCrrentStaffMemb().getCareerDgree() + " " +
                                slots.get(i).getCrrentStaffMemb().getFName() + " " +
                                slots.get(i).getCrrentStaffMemb().getSName();
                            flagSlot20 = 1;
                        }
                        //


                    }

                    table.setModel(new javax.swing.table.DefaultTableModel(sArray, new String[] {
                                                                           "Day", "Slot 1", "Slot 2", "Slot 3", "Slot 4"
                        }));
                } else
                    JOptionPane.showMessageDialog(null, "this table not assigend ");


            }
            
      
      
      
        
 //++++++++++++++++++++++++++++++++
     // method to export the schedual table to xls format 
    public static void export_XLX(JTable inputTable)
    {
        
                     JFileChooser fileChooser = new JFileChooser();
                     fileChooser.setDialogTitle("Specify a file to save");   
                     int returnVal =  fileChooser.showSaveDialog(null);     
                     if (returnVal == JFileChooser.APPROVE_OPTION)
                     {
                       String  filepath = fileChooser.getSelectedFile().getAbsolutePath();
                       File file = new File(filepath +".xls");
                          if (file.exists() == false) 
                          {
                                  
                               

                                     HSSFWorkbook wb = new HSSFWorkbook();
                                     CreationHelper createhelper = wb.getCreationHelper();
                                     Sheet sheet = wb.createSheet("new sheet");
                                     Row row = null;
                                     Cell cell = null;
                                     for (int i=0;i<inputTable.getRowCount();i++)
                                                 {
                                         row = sheet.createRow(i);
                                         for (int j=0;j<inputTable.getColumnCount();j++) {
                                              
                                             cell = row.createCell(j);
                                             cell.setCellValue((String) inputTable.getValueAt(i, j));
                                         }
                                     }
                         
                                 
                                         try (
                                            //Write the workbook in file 
                                             FileOutputStream out = new FileOutputStream(file)) 
                                         {
                                                     wb.write(out);
                                                       out.close();
                                             JOptionPane.showMessageDialog(null, "File Saved Successfully ");
                                                 }
                                  catch (IOException e){
                                      System.out.println("error");
                                        }
                              }
                         
                                   else { // Sheet already exists
                                        JOptionPane.showMessageDialog(null,"File already exist");}       
                                         
                               }
                               else { // Sheet already exists
                                 JOptionPane.showMessageDialog(null,"User cancelled  ");}    
     }
        
        
        
       
       
       
// this method to install setLookAndFeel
   public static void setLookAndFeel(int index) {
                   try {
                       Properties props = new Properties();
                       props.put("logoString", " "); // this only to make a light side in menu
                       MintLookAndFeel.setCurrentTheme(props);
                       switch(index)
                       {
                        case 0 :
                        UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel"); // the best theme
                        break ; 
                       
                        case 1 :
                           UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");  // mac theme
                        break ; 
                       
                        case 2 :
                            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel"); // night theme
                        break ; 
                       
                       case 3 :
                            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
                       break ;
                       
                       case 4 :
                            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
                       break ; 
                       
                       case 5 :
                       UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                       break ; 
                       
                       // UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
                       // UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
                       // UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                       //UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
                       //  UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
                       //  UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
                       //  UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
                       }
                        
                     //  Main_Core.mu = new MMenu();
                       Main_Core.mu.revalidate(); Main_Core.mu.repaint();
                       Main_Core.mu.switchtoPanel(new Setting());
                   
                   } catch (Exception ex) {
                       ex.printStackTrace();
                   }
               }

       
       
       
       
        }  

