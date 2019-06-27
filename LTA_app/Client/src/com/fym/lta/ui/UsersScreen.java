
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.bao.UserBao;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.EmployeeDto;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.UserDto;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author h.omar
 */
public class UsersScreen extends javax.swing.JPanel {
    
    // bussiness object to save or delete , search  methods
    private UserBao userBaoObj = new BaoFactory().createUserBao();
    // list  to hold the returned data from the search
    private List<UserDto> searchReturnedUsers;
    // this to hold the status of update if ture this means the selected user need to be updated
    private boolean updateFlage = false;
    // hold the emaial of the selected user
    static String emailToUpdate;
    // all current  roles stord in DB
    List<RoleDto> allRoles = new BaoFactory().createRoleBao().getAll();
    // all current employees stored in DB
    List<EmployeeDto> allEmployees = new BaoFactory().createemployeeBao().listEmployee();
    // hold the value of the status of availability of the entered usernsme true if it is available
    boolean usernameAvailabilty = true;

  


    /** Creates new form Users_search */
    public UsersScreen() {

        initComponents();
        // check if the the dao layer doesn't return null to reset the table model
        if (userBaoObj.listAll() != null)
            userTableReset(userBaoObj.listAll());
        // initialize our Combobox in the form
        listComboRoles(allRoles);
        listComboEmployee(allEmployees);

        insertPanel.setVisible(false);
        
        // now one step we will create an object of ScreenBao to know the current permission 
        int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(8);
        System.out.println(permissionType+"permissionType");
        Utilities.mandate(ubdateUserBTN,insertUserBTN , deleteUserBTN ,8, Utilities.convertTOBase2(permissionType));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        popup = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        users_TableaPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        ubdateUserBTN = new javax.swing.JButton();
        deleteUserBTN = new javax.swing.JButton();
        userEnteredName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        insertUserBTN = new javax.swing.JButton();
        searchUserBTN = new javax.swing.JButton();
        insertPanel = new javax.swing.JPanel();
        usernameBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        userPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        doneBTN = new javax.swing.JButton();
        userRoleCombo = new javax.swing.JComboBox();
        employeesCombo = new javax.swing.JComboBox();
        employeesLabel = new java.awt.Label();
        jLabel5 = new javax.swing.JLabel();

        jMenuItem1.setText("Print");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        popup.add(jMenuItem1);

        jMenuItem2.setText("Expor to PDF");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        popup.add(jMenuItem2);

        jMenuItem3.setText("Export to XLX");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        popup.add(jMenuItem3);

        jMenuItem4.setText("Hide Insertion Panel");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        popup.add(jMenuItem4);

        setBackground(new java.awt.Color(0, 0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users_TableaPanel.setBackground(new java.awt.Color(0, 0, 0));
        users_TableaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Users\n", 0, 0, new java.awt.Font("Tekton Pro Cond", 1, 36))); // NOI18N

        usersTable.setBackground(new java.awt.Color(51, 98, 114));
        usersTable.setFont(new java.awt.Font("Tekton Pro Cond", 0, 24)); // NOI18N
        usersTable.setForeground(new java.awt.Color(255, 255, 255));
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "null", "Login Username", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setRowHeight(30);
        usersTable.setSelectionBackground(new java.awt.Color(22, 224, 236));
        jScrollPane1.setViewportView(usersTable);
        usersTable.getColumnModel().getColumn(0).setHeaderValue("Name");
        usersTable.getColumnModel().getColumn(1).setHeaderValue("null");
        usersTable.getColumnModel().getColumn(2).setHeaderValue("Login Username");
        usersTable.getColumnModel().getColumn(3).setHeaderValue("Role");

        javax.swing.GroupLayout users_TableaPanelLayout = new javax.swing.GroupLayout(users_TableaPanel);
        users_TableaPanel.setLayout(users_TableaPanelLayout);
        users_TableaPanelLayout.setHorizontalGroup(
            users_TableaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        users_TableaPanelLayout.setVerticalGroup(
            users_TableaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, users_TableaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
        );

        add(users_TableaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 550, 410));

        ubdateUserBTN.setBackground(new java.awt.Color(0, 0, 0));
        ubdateUserBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ubdateUserBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\update.png")); // NOI18N
        ubdateUserBTN.setBorder(null);
        ubdateUserBTN.setBorderPainted(false);
        ubdateUserBTN.setIconTextGap(0);
        ubdateUserBTN.setMargin(new java.awt.Insets(0, 0, 1, 14));
        ubdateUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubdateUserBTNMouseClicked(evt);
            }
        });
        add(ubdateUserBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 80, 30));

        deleteUserBTN.setBackground(new java.awt.Color(0, 0, 0));
        deleteUserBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteUserBTN.setForeground(new java.awt.Color(255, 255, 255));
        deleteUserBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\delete.png")); // NOI18N
        deleteUserBTN.setBorder(null);
        deleteUserBTN.setBorderPainted(false);
        deleteUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUserBTNMouseClicked(evt);
            }
        });
        add(deleteUserBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 80, 30));

        userEnteredName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userEnteredName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(userEnteredName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search2.png")); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 49, 115, 20));

        insertUserBTN.setBackground(new java.awt.Color(0, 0, 0));
        insertUserBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertUserBTN.setForeground(new java.awt.Color(255, 255, 255));
        insertUserBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\insert.png")); // NOI18N
        insertUserBTN.setBorder(null);
        insertUserBTN.setBorderPainted(false);
        insertUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertUserBTNMouseClicked(evt);
            }
        });
        add(insertUserBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        searchUserBTN.setBackground(new java.awt.Color(0, 0, 0));
        searchUserBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchUserBTN.setForeground(new java.awt.Color(255, 255, 255));
        searchUserBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search.png")); // NOI18N
        searchUserBTN.setBorder(null);
        searchUserBTN.setBorderPainted(false);
        searchUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchUserBTNMouseClicked(evt);
            }
        });
        add(searchUserBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 80, 50));

        insertPanel.setBackground(new java.awt.Color(51, 98, 114));
        insertPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insertPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameBox.setBorder(null);
        usernameBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usernameBoxMouseExited(evt);
            }
        });
        insertPanel.add(usernameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 19, 373, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name");
        insertPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 13, 86, 42));

        userPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userPassword.setBorder(null);
        insertPanel.add(userPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 104, 373, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Passwor");
        insertPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 98, 86, 42));

        mailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mailLabel.setForeground(new java.awt.Color(255, 0, 0));
        insertPanel.add(mailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 192, 8, 42));

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Role");
        insertPanel.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 278, 42, 43));

        doneBTN.setBackground(new java.awt.Color(0, 0, 0));
        doneBTN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doneBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\save.png")); // NOI18N
        doneBTN.setBorder(null);
        doneBTN.setBorderPainted(false);
        doneBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneBTNMouseClicked(evt);
            }
        });
        insertPanel.add(doneBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 375, 140, 60));

        userRoleCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userRoleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userRoleComboActionPerformed(evt);
            }
        });
        insertPanel.add(userRoleCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 277, 192, 44));

        employeesCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        employeesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesComboActionPerformed(evt);
            }
        });
        insertPanel.add(employeesCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 172, 350, 44));

        employeesLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        employeesLabel.setForeground(new java.awt.Color(255, 255, 255));
        employeesLabel.setText("Employees");
        insertPanel.add(employeesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 174, 87, 43));

        add(insertPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 171, -1, 460));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\user_title.png")); // NOI18N
        jLabel5.setText("Users Screen ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 280, 70));
    }//GEN-END:initComponents

    private void searchUserBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchUserBTNMouseClicked
        insertPanel.setVisible(false);
        if (userEnteredName.getText() != null) {

            searchReturnedUsers = userBaoObj.seachForUsers(userEnteredName.getText());
        }

        else {
            // no input will return all users
            searchReturnedUsers = userBaoObj.listAll();
        }

        if (searchReturnedUsers == null) {
            JOptionPane.showMessageDialog(this, "not found");
            userTableReset(userBaoObj.listAll());
        }

        else
            userTableReset(searchReturnedUsers);
     

    }//GEN-LAST:event_searchUserBTNMouseClicked

    private void deleteUserBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserBTNMouseClicked
         
        if (usersTable.getSelectedRow() >= 0) {
            String selectedEmaill = usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString();
            // call business to delete
            // don't forget you need to update the users table and remove this record
            // and check the returned value to tell the user if the delete is done or not
            int msg=  JOptionPane.showConfirmDialog(this, "are you sure you need to delete ");
                           if (msg == JOptionPane.OK_OPTION)
                           {  if (userBaoObj.deleteUser(selectedEmaill)) {
                JOptionPane.showMessageDialog(this, "Deleted successfully"); // tell the user that we done it
                // reset the table's content
                userTableReset(userBaoObj.listAll());

            } else {
                JOptionPane.showMessageDialog(this, "Can not delete may be deleted using another user ");
            }}
        }


        else { // this means that the user no selection on table
            JOptionPane.showMessageDialog(this, "you should select a user first to delete  ");
        }
    }//GEN-LAST:event_deleteUserBTNMouseClicked

    private void insertUserBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertUserBTNMouseClicked
        clearData();
        updateFlage = false;
        insertPanel.setVisible(true);
        
    }//GEN-LAST:event_insertUserBTNMouseClicked

    private void ubdateUserBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubdateUserBTNMouseClicked
        if (usersTable.getSelectedRow() >= 0) {

            // hide fixed data component
            employeesCombo.setVisible(false);
            employeesLabel.setVisible(false);
           
            // copy data from table to the insertPanel
            usernameBox.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString());
            updateFlage = true;
            insertPanel.setVisible(true);
        } else
            JOptionPane.showMessageDialog(this, "please select a user to update");
   
   
   
    }//GEN-LAST:event_ubdateUserBTNMouseClicked

    private void doneBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneBTNMouseClicked
        boolean flag = true; // holding the value of the upate or insert the user , falg to control on

        UserDto user = new UserDto();


        if (userPassword.getPassword().toString().length() < 66)
            user.setPassword(Utilities.getMd5(new String(userPassword.getPassword())));
        else {
            flag = false;
            JOptionPane.showMessageDialog(this, "this password is very long the maxmum is 66 character  ");
        }

        if (usernameBox.getText().length() < 66)
            user.setUserName(usernameBox.getText());
        else {
            flag = false;
            JOptionPane.showMessageDialog(this, "this username is very long the maxmum is 66 character  ");
        }

        // now we need to create a role to give it to this user
        RoleDto role = new RoleDto(allRoles.get(userRoleCombo.getSelectedIndex()).getCode());
        role.setRole_id(allRoles.get(userRoleCombo.getSelectedIndex()).getRole_id());
        user.setUserRole(role);

        // now we will crate an employee to be connected with our user
        EmployeeDto employee = new EmployeeDto();
        employee.setEmp_id(allEmployees.get(employeesCombo.getSelectedIndex()).getEmp_id());
        user.setUser_Employee(employee);

        if (!updateFlage) {

             
            user.setUpdatedBy(LoginEngine.currentUser); // we need a method return this value and this only to test db connection
            user.setInsertedBy(LoginEngine.currentUser);
            user.setUpdate_Date(new Date(System.currentTimeMillis()));
            user.setInertion_Date(new Date(System.currentTimeMillis()));
        }

        else {
 
            user.setUpdate_Date(new Date(System.currentTimeMillis()));
            user.setUpdatedBy(LoginEngine.currentUser); // we need a method return this value and this only to test db connection

        }
        // call bao to save user
        if (usernameAvailabilty) { 
            try {
            
                if (userBaoObj.saveUser(user)) {
                    JOptionPane.showMessageDialog(this, "User Saved ");
                    userTableReset(userBaoObj.listAll());

                } else
                    JOptionPane.showMessageDialog(this,
                                                  "Can not insert or update Ther are a problem please check entered data ");


            } catch(LTAException ex)
            {JOptionPane.showMessageDialog(this, "Error in Data base");}
 
            
        } else
            JOptionPane.showMessageDialog(this, "please Change user name ");
        
    }//GEN-LAST:event_doneBTNMouseClicked

    private void usernameBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameBoxMouseExited
        if (userBaoObj.isExists(usernameBox.getText()) && !(updateFlage)) {
            JOptionPane.showMessageDialog(this, "This Username is already exist ");
            // assigne false to block the save method
            usernameAvailabilty = false;
        }

        else
            usernameAvailabilty = true;
    }//GEN-LAST:event_usernameBoxMouseExited

    private void employeesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeesComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeesComboActionPerformed

    private void userRoleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userRoleComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userRoleComboActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Utilities.printRecord(users_TableaPanel);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
 
        Utilities.export_PDF(usersTable);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
    if(evt.isPopupTrigger())
    {
    popup.show(this, evt.getX(), evt.getY());    
    }
    }//GEN-LAST:event_formMouseReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    Utilities.export_XLX(usersTable);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        insertPanel.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteUserBTN;
    private javax.swing.JButton doneBTN;
    private javax.swing.JComboBox employeesCombo;
    private java.awt.Label employeesLabel;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JButton insertUserBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JButton searchUserBTN;
    private javax.swing.JButton ubdateUserBTN;
    private javax.swing.JTextField userEnteredName;
    private javax.swing.JPasswordField userPassword;
    private javax.swing.JComboBox userRoleCombo;
    private javax.swing.JTextField usernameBox;
    private javax.swing.JTable usersTable;
    private javax.swing.JPanel users_TableaPanel;
    // End of variables declaration//GEN-END:variables
    
    public void userTableReset(List<UserDto> users) 
    {
        int userRoleid;

        Object[][] usersArr = new Object[users.size()][7];

        for (int i = 0; i < users.size();i++) {
            // View the full name
            usersArr[i][0] =
                               users.get(i).getFName() + " " + users.get(i).getSName() + " " + users.get(i).getLName() +
                               " " + users.get(i).getFamilyName();
 
            usersArr[i][1] = users.get(i).getUserName();
            usersArr[i][2] = users.get(i).getUserRole().getCode();
            usersArr[i][3] = users.get(i).getInsertedBy();
            usersArr[i][4] = users.get(i).getInertion_Date();
            usersArr[i][5] = users.get(i).getUpdatedBy();
            usersArr[i][6] = users.get(i).getUpdate_Date();

        }
        usersTable.setModel(new javax.swing.table.DefaultTableModel(usersArr, new String[] {
                                                                    "Name", "Login Username", "Role code " ,"Inserted By",
 "  Insertion Date", "Updated By", "Update Date"
            }));
    }


    void listComboRoles(List<RoleDto> roles) {
        for (int i = 0; i < roles.size(); i++) {
            userRoleCombo.addItem(roles.get(i).getCode());
        }

    }


    void listComboEmployee(List<EmployeeDto> emp) {
        for (int i = 0; i < emp.size(); i++) {
            employeesCombo.addItem(emp.get(i).getFName() + "  " + emp.get(i).getSName() + "  " + emp.get(i).getLName() +
                                   "  " + emp.get(i).getFamilyName());
        }

    }

    // this method just to clear text and reset the valus on the insrt panel
    void clearData() { // clear prvious data
        usernameBox.setText(null);
        userPassword.setText(null);
       
        employeesCombo.setSelectedIndex(0);
        userRoleCombo.setSelectedIndex(0);

        // show hiden components again
        employeesCombo.setVisible(true);
        employeesLabel.setVisible(true);
        
    }


}
