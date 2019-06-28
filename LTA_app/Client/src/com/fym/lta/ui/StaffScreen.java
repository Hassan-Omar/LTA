
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.EmployeeBao;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.EmployeeDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Mina
 */
public class StaffScreen extends javax.swing.JPanel {
    
    
    boolean updateFlag = false;
    
    private EmployeeBao EmployeeBaoObj = new BaoFactory().createemployeeBao();
    
    List <EmployeeDto> searchReturnedEmployee ;
    List<DepartmentDto> allDepartments = new BaoFactory().createDepartmentBao().listDepartment();
    /** Creates new form StaffScreen */
    public StaffScreen() {
        initComponents();
        
        //fill the department combobox
        listComboDepartment(allDepartments);
        // make the insert panel visible 
        insertPanel.setVisible(false);
        
        if (EmployeeBaoObj.listEmployee()!=null){
                employeeTableReset(EmployeeBaoObj.listEmployee());
               
            }
        // screenID = 5 
        // now one step we will create an object of ScreenBao to know the current permission 
        int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(5);
        Utilities.mandate(btnUpdate , btnInsert , btnDelete ,5, Utilities.convertTOBase2(permissionType));
        
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\employee.png")); // NOI18N

        btnInsert.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\insert.png")); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\update.png")); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search.png")); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\delete.png")); // NOI18N
        
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search2.png")); // NOI18N
        saveBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\save.png")); // NOI18N
        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        popup = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        name_TextField = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        insertPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pos_TextField = new javax.swing.JTextField();
        sname_TextField = new javax.swing.JTextField();
        lname_TextField = new javax.swing.JTextField();
        familyName_TextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        department_ComboBox = new javax.swing.JComboBox();
        saveBTN = new javax.swing.JButton();
        mail_TextField = new javax.swing.JTextField();
        fname_TextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffTable = new javax.swing.JTable();

        jMenuItem2.setText("Print");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        popup.add(jMenuItem2);

        jMenuItem3.setText("Expor to PDF");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        popup.add(jMenuItem3);

        jMenuItem4.setText("Export to XLX");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        popup.add(jMenuItem4);

        jMenuItem5.setText("Hide Insertion Panel");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        popup.add(jMenuItem5);

        setBackground(new java.awt.Color(0, 0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search2.png")); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 48, 66, 20));
        add(name_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, 30));

        btnSearch.setBackground(new java.awt.Color(0, 0, 0));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search.png")); // NOI18N
        btnSearch.setBorderPainted(false);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 80, 50));

        btnUpdate.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\update.png")); // NOI18N
        btnUpdate.setBorderPainted(false);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 90, 30));

        btnDelete.setBackground(new java.awt.Color(0, 0, 0));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\delete.png")); // NOI18N
        btnDelete.setBorderPainted(false);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 80, 30));

        btnInsert.setBackground(new java.awt.Color(0, 0, 0));
        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\insert.png")); // NOI18N
        btnInsert.setBorderPainted(false);
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMouseClicked(evt);
            }
        });
        add(btnInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        insertPanel.setBackground(new java.awt.Color(51, 98, 114));
        insertPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insertPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("First Name ");
        insertPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 27, -1, 26));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Second Name ");
        insertPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 27, -1, 26));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Last Name");
        insertPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 27, -1, 26));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Family Name");
        insertPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 30, 110, 26));

        pos_TextField.setBorder(null);
        insertPanel.add(pos_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 242, 210, 30));

        sname_TextField.setBorder(null);
        insertPanel.add(sname_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 60, 110, 30));

        lname_TextField.setBorder(null);
        insertPanel.add(lname_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 60, 110, 30));

        familyName_TextField.setBorder(null);
        insertPanel.add(familyName_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(432, 60, 110, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Department ");
        insertPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 169, 110, 26));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Email");
        insertPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 307, 95, 26));

        insertPanel.add(department_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 167, 204, 30));

        saveBTN.setBackground(new java.awt.Color(51, 98, 114));
        saveBTN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\save.png")); // NOI18N
        saveBTN.setBorderPainted(false);
        saveBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBTNMouseClicked(evt);
            }
        });
        insertPanel.add(saveBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 140, 60));

        mail_TextField.setBorder(null);
        insertPanel.add(mail_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 306, 272, 30));

        fname_TextField.setBorder(null);
        insertPanel.add(fname_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 60, 110, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Posistion ");
        insertPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 248, 95, 26));

        add(insertPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 552, 475));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\employee.png")); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 280, 50));

        sPanel.setBackground(new java.awt.Color(0, 0, 0));
        sPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 240, 240)), "Employees", 0, 0, new java.awt.Font("Tekton Pro", 2, 24), new java.awt.Color(204, 240, 240))); // NOI18N

        staffTable.setBackground(new java.awt.Color(51, 98, 114));
        staffTable.setFont(new java.awt.Font("Tekton Pro Cond", 0, 18)); // NOI18N
        staffTable.setForeground(new java.awt.Color(255, 255, 255));
        staffTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        staffTable.setRowHeight(25);
        staffTable.setSelectionBackground(new java.awt.Color(22, 224, 236));
        jScrollPane1.setViewportView(staffTable);

        javax.swing.GroupLayout sPanelLayout = new javax.swing.GroupLayout(sPanel);
        sPanel.setLayout(sPanelLayout);
        sPanelLayout.setHorizontalGroup(
            sPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        sPanelLayout.setVerticalGroup(
            sPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
        );

        add(sPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 550, 440));
    }//GEN-END:initComponents

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        insertPanel.setVisible(false);
        if (name_TextField.getText() != null) {
            EmployeeDto E = new EmployeeDto();
            E.setFName(name_TextField.getText());
            if (EmployeeBaoObj.SearchEmployee(E) != null)
                employeeTableReset(EmployeeBaoObj.SearchEmployee(E));
            else
                JOptionPane.showMessageDialog(null, "not found");

        }

        else {
            // no input will return all Employess
            searchReturnedEmployee = EmployeeBaoObj.listEmployee();
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        if (staffTable.getSelectedRow() >= 0) {

            mail_TextField.setText(staffTable.getValueAt(staffTable.getSelectedRow(), 0).toString());
            mail_TextField.setEnabled(false);
         
            insertPanel.setVisible(true);
            updateFlag = true;


        } else {
            JOptionPane.showMessageDialog(this, "select an Employee to update ");
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
    insertPanel.setVisible(false);
        if (staffTable.getSelectedRow() >= 0) {
        String selectedEmployee = staffTable.getValueAt(staffTable.getSelectedRow(), 0).toString();
           EmployeeDto selectedEmployee_Delete = new EmployeeDto(); // this user i want to delete
           selectedEmployee_Delete.setEmail(selectedEmployee);
               
               int msg=  JOptionPane.showConfirmDialog(this, "are you sure you need to delete ");
          if (msg == JOptionPane.OK_OPTION)
                            { 
           if (EmployeeBaoObj.deleteEmployee(selectedEmployee_Delete)) {
                  JOptionPane.showMessageDialog(null, "Deleted");
                  employeeTableReset(EmployeeBaoObj.listEmployee() );
               }
               else {
               JOptionPane.showMessageDialog(this, "Can not delete may be deleted using another Employee ");
                    } 
           } 
             }
        else {
                       JOptionPane.showMessageDialog(this, "Select an Employee to Delete");
                   } 
           
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseClicked
        insertPanel.setVisible(true);
        pos_TextField.setEnabled(true);
        updateFlag = false;
    }//GEN-LAST:event_btnInsertMouseClicked

    private void saveBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBTNMouseClicked
    EmployeeDto employee = new EmployeeDto();


    employee.setFName(fname_TextField.getText());
    employee.setSName(sname_TextField.getText());
    employee.setLName(lname_TextField.getText());
    employee.setFamilyName(familyName_TextField.getText());
    employee.setDepartment(allDepartments.get(department_ComboBox.getSelectedIndex()));
    employee.setCareerDgree(pos_TextField.getText());
    
    employee.setEmail(is_MailValid(mail_TextField.getText()));
  
    if (updateFlag) { 
        employee.setUpdate_Date(new Date(System.currentTimeMillis()));
        employee.setUpdatedBy(LoginEngine.currentUser);
    } else {
        employee.setUpdate_Date(new Date(System.currentTimeMillis()));
        employee.setUpdatedBy(LoginEngine.currentUser);
        employee.setInertion_Date(new Date(System.currentTimeMillis()));
        employee.setInsertedBy(LoginEngine.currentUser);
      
    }
          List<EmployeeDto> employees = new ArrayList<>(); 
          
          employees.add(employee);
          {
                  
                  
                  try {
                      
                     if (EmployeeBaoObj.saveEmployees(employees)) {
                          JOptionPane.showMessageDialog(this, "saved ");
                          employeeTableReset(EmployeeBaoObj.listEmployee());
                        
                      } else
                          JOptionPane.showMessageDialog(this, "can not save ");
                  } catch (LTAException ltae) {
                      JOptionPane.showMessageDialog(this, "can not save ");
                  } 
              
          }
          
          
    }//GEN-LAST:event_saveBTNMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Utilities.printRecord(sPanel);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        Utilities.export_PDF(staffTable);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        Utilities.export_XLX(staffTable);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
    if(evt.isPopupTrigger())
       {
       popup.show(this, evt.getX(), evt.getY());    
       }
    }//GEN-LAST:event_formMouseReleased

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        insertPanel.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox department_ComboBox;
    private javax.swing.JTextField familyName_TextField;
    private javax.swing.JTextField fname_TextField;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname_TextField;
    private javax.swing.JTextField mail_TextField;
    private javax.swing.JTextField name_TextField;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JTextField pos_TextField;
    private javax.swing.JPanel sPanel;
    private javax.swing.JButton saveBTN;
    private javax.swing.JTextField sname_TextField;
    private javax.swing.JTable staffTable;
    // End of variables declaration//GEN-END:variables
    
    
    public void employeeTableReset(List<EmployeeDto> employees) {
       
        Object[][] employeesArr = new Object[employees.size()][7];

        for (int i = 0; i < employees.size(); i++) {

            employeesArr[i][0] = employees.get(i).getEmail();
            employeesArr[i][1] = employees.get(i).getFName() +" " +employees.get(i).getSName() +" "
            +employees.get(i).getLName()+" "  +employees.get(i).getFamilyName();
            employeesArr[i][2] = employees.get(i).getDepartment().getName();
            employeesArr[i][3] = employees.get(i).getInsertedBy();
            employeesArr[i][4] = employees.get(i).getInertion_Date();
            employeesArr[i][5] = employees.get(i).getUpdatedBy();
            employeesArr[i][6] = employees.get(i).getUpdate_Date();



        }
        staffTable.setModel(new javax.swing.table.DefaultTableModel(employeesArr, new String[] {
                                                                    "Email", "Name","Department Name","Inserted By",
 "  Insertion Date", "Updated By", "Update Date" 
            }));
    }
    
    void listComboDepartment(List<DepartmentDto> Departments) {
        for (int i = 0; i < Departments.size(); i++) {
            if(Departments!=null)
            department_ComboBox.addItem(Departments.get(i).getName());
        }
}


    public static String is_MailValid(String input) {
        String resultMail = null;
        if (input.contains("@")) {
            String end_str = "@fayoum.edu.eg";
            boolean ends = input.endsWith(end_str);
            try {
                if (ends == false) {
                    JOptionPane.showMessageDialog(null, "Wrong Email Format\nFormat must ends with@fayoum.edu.eg");
                }
                else  resultMail = input ;

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            resultMail = input + "@fayoum.edu.eg";
        }

        return resultMail;
    }
}
