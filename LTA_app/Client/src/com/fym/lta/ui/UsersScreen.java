
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.bao.UserBao;
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
        // roleID = 9 
        // now one step we will create an object of ScreenBao to know the current permission 
        String permissionType = new BaoFactory().createScreenBao().getCurrentPermission(9);
        Utilities.mandate(ubdateUserBTN,insertUserBTN , deleteUserBTN ,9,permissionType);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
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
        userEmail = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        mailLabel = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        doneBTN = new javax.swing.JButton();
        userRoleCombo = new javax.swing.JComboBox();
        employeesCombo = new javax.swing.JComboBox();
        employeesLabel = new java.awt.Label();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Users\n", 0, 0, new java.awt.Font("Adobe Arabic", 1, 24))); // NOI18N

        usersTable.setFont(new java.awt.Font("Perpetua", 1, 18)); // NOI18N
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Login Username", "Role"
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
        jScrollPane1.setViewportView(usersTable);
        usersTable.getColumnModel().getColumn(0).setHeaderValue("Name");
        usersTable.getColumnModel().getColumn(1).setHeaderValue("Email");
        usersTable.getColumnModel().getColumn(2).setHeaderValue("Login Username");
        usersTable.getColumnModel().getColumn(3).setHeaderValue("Role");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ubdateUserBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ubdateUserBTN.setText("Update");
        ubdateUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubdateUserBTNMouseClicked(evt);
            }
        });

        deleteUserBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteUserBTN.setLabel("Delete");
        deleteUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUserBTNMouseClicked(evt);
            }
        });

        userEnteredName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Enter User Email");

        insertUserBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        insertUserBTN.setText("Insert  New User");
        insertUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertUserBTNMouseClicked(evt);
            }
        });

        searchUserBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchUserBTN.setText("Search");
        searchUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchUserBTNMouseClicked(evt);
            }
        });

        usernameBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usernameBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usernameBoxMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("User Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Passwor");

        userEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userEmailKeyTyped(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setText("Email");

        mailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mailLabel.setForeground(new java.awt.Color(255, 0, 0));

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setText("Role");

        doneBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        doneBTN.setText("Save");
        doneBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneBTNMouseClicked(evt);
            }
        });

        userRoleCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userRoleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userRoleComboActionPerformed(evt);
            }
        });

        employeesCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        employeesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeesComboActionPerformed(evt);
            }
        });

        employeesLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        employeesLabel.setText("Employees");

        javax.swing.GroupLayout insertPanelLayout = new javax.swing.GroupLayout(insertPanel);
        insertPanel.setLayout(insertPanelLayout);
        insertPanelLayout.setHorizontalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(insertPanelLayout.createSequentialGroup()
                                .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE))))
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(insertPanelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(employeesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(insertPanelLayout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(userRoleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(insertPanelLayout.createSequentialGroup()
                                .addGap(229, 229, 229)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(insertPanelLayout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(employeesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(doneBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        insertPanelLayout.setVerticalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addComponent(employeesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(employeesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userRoleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(doneBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userEnteredName, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(searchUserBTN))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ubdateUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(deleteUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(insertUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(insertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userEnteredName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 352, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ubdateUserBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(deleteUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(insertUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
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
        
        insertPanel.setVisible(false);
        if (usersTable.getSelectedRow() >= 0) {
            String selectedEmaill = usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString();
            // call business to delete
            // don't forget you need to update the users table and remove this record
            // and check the returned value to tell the user if the delete is done or not
            if (userBaoObj.deleteUser(selectedEmaill)) {
                JOptionPane.showMessageDialog(this, "Deleted successfully"); // tell the user that we done it
                // reset the table's content
                userTableReset(userBaoObj.listAll());

            } else {
                JOptionPane.showMessageDialog(this, "Can not delete may be deleted using another user ");
            }
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
            emailLabel.setVisible(false);
            userEmail.setVisible(false);
            // copy data from table to the insertPanel
            usernameBox.setText(usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString());
            updateFlage = true;
            insertPanel.setVisible(true);
        } else
            JOptionPane.showMessageDialog(this, "please select a user to update");
   
   
   
    }//GEN-LAST:event_ubdateUserBTNMouseClicked

    private void userEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userEmailKeyTyped

        String mail = userEmail.getText();
        if (!(mail.contains("@"))) {
            mailLabel.setText("mail format example@fayoum.edu.eg");
        } else
            mailLabel.setText("  ");
    }//GEN-LAST:event_userEmailKeyTyped

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

            if (userEmail.getText().length() < 45)
                user.setEmail(userEmail.getText());

            user.setUpdatedBy(LoginEngine.currentUser); // we need a method return this value and this only to test db connection
            user.setInsertedBy(LoginEngine.currentUser);
            user.setUpdate_Date(new Date(System.currentTimeMillis()));
            user.setInertion_Date(new Date(System.currentTimeMillis()));
        }

        else {

            if (userEmail.getText().length() < 45)
                user.setEmail(usersTable.getValueAt(usersTable.getSelectedRow(), 1).toString());

            user.setUpdate_Date(new Date(System.currentTimeMillis()));
            user.setUpdatedBy(LoginEngine.currentUser); // we need a method return this value and this only to test db connection

        }
        // call bao to save user
        if (usernameAvailabilty) {
            if (userBaoObj.saveUser(user)) {
                JOptionPane.showMessageDialog(this, "User Saved ");
                insertPanel.setVisible(false);
                userTableReset(userBaoObj.listAll());

            } else
                JOptionPane.showMessageDialog(this,
                                              "Can not insert or update Ther are a problem please check entered data ");


        } else
            JOptionPane.showMessageDialog(this, "please Change user name ");
        
    }//GEN-LAST:event_doneBTNMouseClicked

    private void usernameBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameBoxMouseExited
        if (userBaoObj.isUsernameExists(usernameBox.getText()) && !(updateFlage)) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteUserBTN;
    private javax.swing.JButton doneBTN;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JComboBox employeesCombo;
    private java.awt.Label employeesLabel;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JButton insertUserBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel mailLabel;
    private javax.swing.JButton searchUserBTN;
    private javax.swing.JButton ubdateUserBTN;
    private javax.swing.JTextField userEmail;
    private javax.swing.JTextField userEnteredName;
    private javax.swing.JPasswordField userPassword;
    private javax.swing.JComboBox userRoleCombo;
    private javax.swing.JTextField usernameBox;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
    
    public void userTableReset(List<UserDto> users) {
        int userRoleid;

        Object[][] usersArr = new Object[users.size()][4];

        for (int i = 0; i < users.size();
             i++) {
            // View the full name
            usersArr[i][0] =
                               users.get(i).getFName() + " " + users.get(i).getSName() + " " + users.get(i).getLName() +
                               " " + users.get(i).getFamilyName();

            usersArr[i][1] = users.get(i).getEmail();
            usersArr[i][2] = users.get(i).getUserName();
            usersArr[i][3] = users.get(i).getUserRole().getCode();
        }
        usersTable.setModel(new javax.swing.table.DefaultTableModel(usersArr, new String[] {
                                                                    "Name", "Email", "Login Username", "Role code "
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
        userEmail.setText(null);
        employeesCombo.setSelectedIndex(0);
        userRoleCombo.setSelectedIndex(0);

        // show hiden components again
        employeesCombo.setVisible(true);
        employeesLabel.setVisible(true);
        emailLabel.setVisible(true);
        userEmail.setVisible(true);
    }


}
