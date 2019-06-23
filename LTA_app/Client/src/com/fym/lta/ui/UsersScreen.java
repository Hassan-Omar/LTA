
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

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        users_TableaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Users\n", 0, 0, new java.awt.Font("Tekton Pro Cond", 1, 36))); // NOI18N

        usersTable.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
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
        jScrollPane1.setViewportView(usersTable);
        usersTable.getColumnModel().getColumn(0).setHeaderValue("Name");
        usersTable.getColumnModel().getColumn(1).setHeaderValue("null");
        usersTable.getColumnModel().getColumn(2).setHeaderValue("Login Username");
        usersTable.getColumnModel().getColumn(3).setHeaderValue("Role");

        javax.swing.GroupLayout users_TableaPanelLayout = new javax.swing.GroupLayout(users_TableaPanel);
        users_TableaPanel.setLayout(users_TableaPanelLayout);
        users_TableaPanelLayout.setHorizontalGroup(
            users_TableaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(users_TableaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        users_TableaPanelLayout.setVerticalGroup(
            users_TableaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, users_TableaPanelLayout.createSequentialGroup()
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

        userEnteredName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userEnteredName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Enter User Email");

        insertUserBTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        insertUserBTN.setText("Insert  New ");
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

        insertPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        usernameBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usernameBoxMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("User Name");

        userPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Passwor");

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
                .addGap(26, 26, 26)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addComponent(employeesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addComponent(employeesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(mailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE))
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userRoleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doneBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        insertPanelLayout.setVerticalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(mailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(userRoleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(doneBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Users Screen ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userEnteredName, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(106, 106, 106)
                            .addComponent(searchUserBTN))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(users_TableaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ubdateUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(133, 133, 133)
                            .addComponent(deleteUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(132, 132, 132)
                            .addComponent(insertUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userEnteredName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ubdateUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertUserBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(users_TableaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(insertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
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
                    insertPanel.setVisible(false);
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
