
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.EmployeeBao;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.dto.EmployeeDto;

import java.io.File;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author Mina
 */
public class MailScreen extends javax.swing.JPanel {
    
    private EmployeeBao empBaoObj = new BaoFactory().createemployeeBao();
    private List<EmployeeDto> searchReturnedUsers; 

    /** Creates new form MailScreen */
    public MailScreen() {
        initComponents();
        if(empBaoObj.listEmployee() != null )
        userTableReset(empBaoObj.listEmployee()) ;
        // now one step we will create an object of ScreenBao to know the current permission 
       // int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(15);
      //  Utilities.mandate(null,null , null ,15, Utilities.convertTOBase2(permissionType));
        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        email_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        emailTo_TextField = new javax.swing.JTextField();
        msgTopic = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        emailBody_TextField = new javax.swing.JTextArea();
        addAttach = new javax.swing.JButton();
        remotePass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        btnSend1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTable.setFont(new java.awt.Font("Tekton Pro Cond", 0, 18)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userTable.setRowHeight(25);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userTableMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 510, 370));
        add(email_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 228, 35));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Search");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 101, 35));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 80, 50));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Email to  ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 13, 103, 38));
        jPanel1.add(emailTo_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 19, 230, 30));

        msgTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msgTopicActionPerformed(evt);
            }
        });
        jPanel1.add(msgTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 70, 230, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Email topic ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 69, -1, 39));

        emailBody_TextField.setColumns(20);
        emailBody_TextField.setRows(5);
        jScrollPane2.setViewportView(emailBody_TextField);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 115, 320, 189));

        addAttach.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addAttach.setText("Attachement");
        addAttach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addAttachMouseClicked(evt);
            }
        });
        addAttach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAttachActionPerformed(evt);
            }
        });
        jPanel1.add(addAttach, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, -1, 34));

        remotePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remotePassActionPerformed(evt);
            }
        });
        jPanel1.add(remotePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 400, 190, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("password");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 400, 102, 51));

        btnSend1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSend1.setText("Send");
        btnSend1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSend1MouseClicked(evt);
            }
        });
        btnSend1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSend1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSend1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 390, 110, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 660, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Reports Screen ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 250, 30));
    }//GEN-END:initComponents
   
   
   /*we use flag To check whether the file was selected when the user clicked attachment button or cancelled
    so that we could determine whether we send just a message or a message and attachement*/
    boolean flag = false;
    String Filepath;
    String Filename;
    private void addAttachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addAttachMouseClicked
    //To choose an attachement 
    JFileChooser Chooser = new JFileChooser();
    int returnVal = Chooser.showOpenDialog(this);
    //To determine whether the user chose file or cancelled
    if(returnVal == JFileChooser.APPROVE_OPTION){  
    // To get the selected file & its name & path    
        File chosenFile = Chooser.getSelectedFile();
        Filepath = chosenFile.getAbsolutePath();
        Filename = chosenFile.getName();
        System.out.println(Filepath);
        flag = true; // user succeessfully selected a file
                     }
    else {
        System.out.println("File Choosing cancelled by user ");
        flag = false; //user cancelled the selection of file
                      }
               
    }//GEN-LAST:event_addAttachMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
    if (email_TextField.getText() != null) {
 
     EmployeeDto emp = new EmployeeDto() ; 
     emp.setFName(email_TextField.getText());
        searchReturnedUsers = empBaoObj.SearchEmployee(emp);
    }

    else {
        // no input will return all users
        searchReturnedUsers = empBaoObj.listEmployee();
    }

    if (searchReturnedUsers == null) {
        JOptionPane.showMessageDialog(this, "not found");
        userTableReset(empBaoObj.listEmployee());
    }

    else
        userTableReset(searchReturnedUsers);
    

    }//GEN-LAST:event_btnSearchMouseClicked

    private void msgTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msgTopicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msgTopicActionPerformed

    private void userTableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseExited

    if (userTable.getSelectedRow()>=0){
        emailTo_TextField.setText(userTable.getValueAt(userTable.getSelectedRow(), 1).toString());
        
    }
    

    }//GEN-LAST:event_userTableMouseExited

    private void remotePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remotePassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remotePassActionPerformed

    private void btnSend1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSend1MouseClicked
    
   // if (userTable.getSelectedRow()<0)
    //  JOptionPane.showMessageDialog(this, "There is no user have been selected/n please Select a user");
        // this will give you current user's mail 
        String currentUserEmail =  new BaoFactory().createUserBao().getCurrentUserEmail(LoginEngine.currentUser); 
    
        // this only to test and you need to delete in future 
       //String currentUserEmail = "nadaelrayse@gmail.com" ; 
    
    
       final String username = currentUserEmail ;
       final String password = new String (remotePass.getPassword());
       
       // start from here you need to detect the user's mail if "gmail" or "yahoo" 
       // you can use if statment with currentUserEmail.contains(".yahoo") , same for gmail 
       // then you will set prop based on the user's mail 
       
        Properties prop = new Properties();
    if(currentUserEmail.contains("yahoo")){
        prop.put("mail.smtp.host", "smtp.yahoo.com"); }
    else if(currentUserEmail.contains("gmail")){
        prop.put("mail.smtp.host",  "smtp.gmail.com"); }
    else if(currentUserEmail.contains("fayoum")){
        prop.put("mail.smtp.host", "smtp.gmail.com"); }
    else if(currentUserEmail.contains("hotmail")){
        prop.put("mail.smtp.host", "smtp.hotmail.com"); }
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.socketFactory.fallback", "false");
        // to pass through the proxy if it is exist
        prop.put("proxySet","true");
        prop.put("socksProxyHost","192.168.155.1");
        prop.put("socksProxyPort","1080");
        Session session = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            
            if(flag) {  //to send a message with an attachement
                
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress( currentUserEmail ));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(emailTo_TextField.getText())
                );
                message.setSubject("LTA  " +msgTopic.getText());
             // creating the message part
                BodyPart messageBodyPart1 = new MimeBodyPart();  
                messageBodyPart1.setContent(emailBody_TextField.getText(),"text/html; charset=utf-8"); 
                              
              // creating the attachement part 
                BodyPart messageBodyPart2 = new MimeBodyPart();  
                DataSource source = new FileDataSource(Filepath);   
                messageBodyPart2.setDataHandler(new DataHandler(source));   
                messageBodyPart2.setFileName(Filename);   
                              
            // creating MultiPart object and set the message & attachement
                Multipart multipartObject = new MimeMultipart();   
                multipartObject.addBodyPart(messageBodyPart1);   
                multipartObject.addBodyPart(messageBodyPart2); 
                      
           // set body of the email 
                message.setContent(multipartObject); 
                
          // Send email  
               Transport.send(message); 
            }
            
            else{  //to send a message withou attachement
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress( currentUserEmail ));
                message.setRecipients(
                        Message.RecipientType.TO,
                        InternetAddress.parse(emailTo_TextField.getText())
                );
                message.setSubject("LTA  " +msgTopic.getText());
                message.setContent(emailBody_TextField.getText(),"text/html; charset=utf-8");
                Transport.send(message);  }

            JOptionPane.showMessageDialog(this, "Email sent successfully");

     } 
        catch(javax.mail.SendFailedException ex){
            JOptionPane.showMessageDialog(this, "No user has been selected\n" +"   please select a user"); 
        }
        
        
        catch (MessagingException e) {
            JOptionPane.showMessageDialog(this, "Error"+e.getMessage());
        }
    

    
    }//GEN-LAST:event_btnSend1MouseClicked

    private void addAttachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAttachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAttachActionPerformed

    private void btnSend1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSend1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSend1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAttach;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSend1;
    private javax.swing.JTextArea emailBody_TextField;
    private javax.swing.JTextField emailTo_TextField;
    private javax.swing.JTextField email_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField msgTopic;
    private javax.swing.JPasswordField remotePass;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables


    public void userTableReset(List<EmployeeDto> emps) 
    { 
        Object[][] empsArr = new Object[emps.size()][2];

        for (int i = 0; i < emps.size();i++) {
            // View the full name
            empsArr[i][0] =
                               emps.get(i).getFName() + " " + emps.get(i).getSName() + " " + emps.get(i).getLName() +
                               " " + emps.get(i).getFamilyName();

            empsArr[i][1] = emps.get(i).getEmail();
         
        }
        userTable.setModel(new javax.swing.table.DefaultTableModel(empsArr, new String[] {
                                                                    "Name", "Email"
            }));
    }

}
