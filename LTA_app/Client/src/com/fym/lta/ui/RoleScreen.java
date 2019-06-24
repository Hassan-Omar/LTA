
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.bao.RoleBao;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.RoleDto;

import java.sql.Date;

import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author h.omar
 */
public class RoleScreen extends javax.swing.JPanel {
    // create role using bussiness factory
    RoleBao role = new BaoFactory().createRoleBao();
    boolean updateFlag = false;

    RoleDto roleUpdateObject = null;

    /** Creates new form RoleScreen */
    public RoleScreen() {
        initComponents();
        // hide the  insertUpdatePanel panel
        insertUpdatePanel.setVisible(false);
        // fill table data from DB
        if (role.getAll() != null)
            roleTableReset(role.getAll());


        // roleID = 12
        // now one step we will create an object of ScreenBao to know the current permission
        int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(9);
        Utilities.mandate(ubdateRoleBTN, insertRoleBTN, deleteRoleBTN, 9, Utilities.convertTOBase2(permissionType));
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
        roleEnteredCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchUserBTN = new javax.swing.JButton();
        insertUpdatePanel = new javax.swing.JPanel();
        enteredCodeBox = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        enteredDescription = new javax.swing.JTextArea();
        SaveBtn = new javax.swing.JButton();
        codeLabel = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jLabel4 = new javax.swing.JLabel();
        ubdateRoleBTN = new javax.swing.JButton();
        deleteRoleBTN = new javax.swing.JButton();
        insertRoleBTN = new javax.swing.JButton();
        roles_Panel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        rolesTable1 = new javax.swing.JTable();

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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roleEnteredCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roleEnteredCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(roleEnteredCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Search");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 110, 39));

        searchUserBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchUserBTN.setText("Search");
        searchUserBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchUserBTNMouseClicked(evt);
            }
        });
        add(searchUserBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 80, 50));

        insertUpdatePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        enteredCodeBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        enteredDescription.setColumns(20);
        enteredDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enteredDescription.setRows(5);
        jScrollPane2.setViewportView(enteredDescription);

        SaveBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SaveBtn.setText("Save");
        SaveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveBtnMouseClicked(evt);
            }
        });

        codeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codeLabel.setText("Code");

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setText("Description");

        javax.swing.GroupLayout insertUpdatePanelLayout = new javax.swing.GroupLayout(insertUpdatePanel);
        insertUpdatePanel.setLayout(insertUpdatePanelLayout);
        insertUpdatePanelLayout.setHorizontalGroup(
            insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertUpdatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(enteredCodeBox, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                    .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        insertUpdatePanelLayout.setVerticalGroup(
            insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertUpdatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enteredCodeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addGroup(insertUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        add(insertUpdatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, -1, 450));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Roles Screen ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 0, 231, 54));

        ubdateRoleBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ubdateRoleBTN.setText("Update");
        ubdateRoleBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubdateRoleBTNActionPerformed(evt);
            }
        });
        add(ubdateRoleBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 80, 30));

        deleteRoleBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteRoleBTN.setLabel("Delete");
        deleteRoleBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteRoleBTNMouseClicked(evt);
            }
        });
        add(deleteRoleBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 80, 30));

        insertRoleBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertRoleBTN.setText("Insert  New ");
        insertRoleBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertRoleBTNMouseClicked(evt);
            }
        });
        add(insertRoleBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        roles_Panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Roles", 0, 0, new java.awt.Font("Tekton Pro Cond", 1, 36))); // NOI18N

        rolesTable1.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        rolesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Decription"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        rolesTable1.setRowHeight(30);
        jScrollPane3.setViewportView(rolesTable1);
        rolesTable1.getColumnModel().getColumn(0).setHeaderValue("Code");
        rolesTable1.getColumnModel().getColumn(1).setHeaderValue("Decription");

        javax.swing.GroupLayout roles_Panel1Layout = new javax.swing.GroupLayout(roles_Panel1);
        roles_Panel1.setLayout(roles_Panel1Layout);
        roles_Panel1Layout.setHorizontalGroup(
            roles_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        roles_Panel1Layout.setVerticalGroup(
            roles_Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        add(roles_Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 550, 400));
    }//GEN-END:initComponents

    private void ubdateRoleBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubdateRoleBTNActionPerformed
        if (rolesTable.getSelectedRow() >= 0) {

            // copy data from table to entereddata textfiel
            roleUpdateObject = new RoleDto(rolesTable.getValueAt(rolesTable.getSelectedRow(), 0).toString());
            // copy text data from table enteredDescription
            roleUpdateObject.setDescription(rolesTable.getValueAt(rolesTable.getSelectedRow(), 1).toString());

            enteredCodeBox.setVisible(false);
            codeLabel.setVisible(false);
            enteredDescription.setText(rolesTable.getValueAt(rolesTable.getSelectedRow(), 1).toString());

            updateFlag = true;
            insertUpdatePanel.setVisible(true);
        } else
            JOptionPane.showMessageDialog(this, "Please select a role to update");
       
       
    }//GEN-LAST:event_ubdateRoleBTNActionPerformed

    private void deleteRoleBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteRoleBTNMouseClicked
        insertUpdatePanel.setVisible(false);
        if (rolesTable.getSelectedRow() >= 0) {
            String selectedRoleCode =
                rolesTable.getValueAt(rolesTable.getSelectedRow(), 0).toString(); // hold the code of role

                int msg=  JOptionPane.showConfirmDialog(this, "are you sure you need to delete ");
                               if (msg == JOptionPane.OK_OPTION)
                               { // call bussiness method
            if (role.deleteRole(selectedRoleCode)) {
                JOptionPane.showMessageDialog(this, "deleted Successfully  ");
                // reset table's content
                roleTableReset(role.getAll());
            } else
                JOptionPane.showMessageDialog(this, "can't delete ");}
        } else
            JOptionPane.showMessageDialog(this, "You should select a role to delete ");
    }//GEN-LAST:event_deleteRoleBTNMouseClicked

    private void insertRoleBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertRoleBTNMouseClicked
        insertUpdatePanel.setVisible(true);
        enteredCodeBox.setText(null);
        enteredCodeBox.setVisible(true);
        enteredDescription.setText(null);
        codeLabel.setVisible(true);
        updateFlag = false;
    }//GEN-LAST:event_insertRoleBTNMouseClicked

    private void searchUserBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchUserBTNMouseClicked
        insertUpdatePanel.setVisible(false);

        if (roleEnteredCode.getText() == null)
            roleTableReset(role.getAll());
        else

        {
            if (role.search_forRole(roleEnteredCode.getText().trim()) == null) {
                JOptionPane.showMessageDialog(this, "not found");
                roleTableReset(role.getAll());
            } else
                roleTableReset(role.search_forRole(roleEnteredCode.getText().trim()));
        }       

     
    }//GEN-LAST:event_searchUserBTNMouseClicked

    private void SaveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveBtnMouseClicked


        
     
        RoleDto myrole = new RoleDto(enteredCodeBox.getText());
        myrole.setDescription(enteredDescription.getText()); // passing entered  description
        // passing insertion time and insertion date
        if (updateFlag) {
            myrole.setUpdate_Date(new Date(System.currentTimeMillis()));
            myrole.setUpdatedBy(LoginEngine.currentUser);
            myrole.setCode(roleUpdateObject.getCode());
            updateFlag = false;
        } else {
            myrole.setUpdatedBy(LoginEngine.currentUser);
            myrole.setInsertedBy(LoginEngine.currentUser);
            myrole.setUpdate_Date(new Date(System.currentTimeMillis()));
            myrole.setInertion_Date(new Date(System.currentTimeMillis()));
        }

        boolean statuse = false;

        try {
            statuse = role.saveRole(myrole);

        } catch (LTAException ex) {
            JOptionPane.showMessageDialog(this, "Error in Data Base");
        }

        if (statuse) {
            JOptionPane.showMessageDialog(this, " Done Successfully ");
            // reset table content
            roleTableReset(role.getAll());
            insertUpdatePanel.setVisible(false);
        } else
            JOptionPane.showMessageDialog(this,
                                          "Can not insert or update Ther are a problem please check entered data ");

    
     
     
     
    }//GEN-LAST:event_SaveBtnMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Utilities.printRecord(roles_Panel);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        Utilities.export_PDF(rolesTable);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

    Utilities.export_XLX(rolesTable);
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveBtn;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JButton deleteRoleBTN;
    private javax.swing.JTextField enteredCodeBox;
    private javax.swing.JTextArea enteredDescription;
    private javax.swing.JButton insertRoleBTN;
    private javax.swing.JPanel insertUpdatePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JTextField roleEnteredCode;
    private javax.swing.JTable rolesTable;
    private javax.swing.JTable rolesTable1;
    private javax.swing.JPanel roles_Panel;
    private javax.swing.JPanel roles_Panel1;
    private javax.swing.JButton searchUserBTN;
    private javax.swing.JButton ubdateRoleBTN;
    // End of variables declaration//GEN-END:variables


    // this function put roles data in the table
    void roleTableReset(List<RoleDto> roles) {
        Object[][] rolesArr = new Object[roles.size()][6];

        for (int i = 0; i < roles.size(); i++) {
            rolesArr[i][0] = roles.get(i).getCode();
            rolesArr[i][1] = roles.get(i).getDescription();
            rolesArr[i][2] = roles.get(i).getInsertedBy();
            rolesArr[i][3] = roles.get(i).getInertion_Date();
            rolesArr[i][4] = roles.get(i).getUpdatedBy();
            rolesArr[i][5] = roles.get(i).getUpdate_Date();


        }
        rolesTable.setModel(new javax.swing.table.DefaultTableModel(rolesArr, new String[] { "Code", "Description" ,"Inserted By",
 "  Insertion Date", "Updated By", "Update Date"}));

    }


}
