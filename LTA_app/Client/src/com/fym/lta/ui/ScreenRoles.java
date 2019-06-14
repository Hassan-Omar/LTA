
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.RoleBao;
import com.fym.lta.bao.ScreenBao;
import com.fym.lta.common.LTAException;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author h.omar
 */
public class ScreenRoles extends javax.swing.JPanel {
    // creeate bussiness and dto objects
    RoleBao roleBaoObj = new BaoFactory().createRoleBao();
    ScreenBao screenBaoObj = new BaoFactory().createScreenBao();
    List<RoleDto> allRoles = new ArrayList();
    List<ScreenDto> selectedScreens = new ArrayList(); //hold the values of selected screens

    /** Creates new form ScreenRoles */
    public ScreenRoles() {
        initComponents();


        allRoles = roleBaoObj.getAll();
        setRolesCombo(allRoles);

        resetTableMod(screenBaoObj.getAll_Screen(allRoles.get(0).getCode()));
        // roleID = 13
        // now one step we will create an object of ScreenBao to know the current permission
        int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(13);
        Utilities.mandate(null, null, null, 13, Utilities.convertTOBase2(permissionType));
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
        roleCombo = new javax.swing.JComboBox();
        label1 = new java.awt.Label();
        jPanel7 = new javax.swing.JPanel();
        doneBtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        label2 = new java.awt.Label();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Screens", 0, 0, new java.awt.Font("Tekton Pro", 1, 36))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        usersTable.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Screen", "View", "Delete", "Insert", "Update"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                .addContainerGap())
        );

        roleCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleComboActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        label1.setText("Screen_Role Assignment Screen");

        doneBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        doneBtn.setText("Done");
        doneBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(290, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(667, 667, 667))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Employees Screen ");

        label2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label2.setText("Role");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1547, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(457, 457, 457)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(786, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addContainerGap(787, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1602, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(540, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addContainerGap(541, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(208, 208, 208)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(874, Short.MAX_VALUE)))
        );
    }//GEN-END:initComponents

    private void doneBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneBtnMouseClicked
        try {
            boolean status =
                screenBaoObj.saveScreenRoles(readTableData(usersTable), allRoles.get(roleCombo.getSelectedIndex()));
            if (status)
                JOptionPane.showMessageDialog(this, "Saved ");
            else
                JOptionPane.showMessageDialog(this, "not Saved ");

        } catch (LTAException e) {
            JOptionPane.showMessageDialog(this, "not Saved ");

        }
    }//GEN-LAST:event_doneBtnMouseClicked

    private void roleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleComboActionPerformed
      
    resetTableMod(screenBaoObj.getAll_Screen(allRoles.get(roleCombo.getSelectedIndex()).getCode()));
     
    }//GEN-LAST:event_roleComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JComboBox roleCombo;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables



    // this function just to list the role data in roleCombo
    void setRolesCombo(List<RoleDto> roles) {
        for (int i = 0; i < roles.size(); i++) {
            roleCombo.addItem(roles.get(i).getCode()); // name not desc
        }

    }

    public void resetTableMod(List<ScreenDto> screens) {
        Object[][] screenArr = new Object[screens.size()][6];

        for (int i = 0; i < screens.size(); i++) {
            // View the full name
            screenArr[i][0] = screens.get(i).getScreen_id();
            screenArr[i][1] = screens.get(i).getDescription();
            
            boolean [] permArray = null;
            // convert permission to array of boolean
            int perm_base10 = screens.get(i).getRole_Screen().getPermissionType();
            permArray = Utilities.convertTOBase2(perm_base10);
            
            // set values
            if (permArray[0])
                screenArr[i][2] = Boolean.TRUE;
            else
                screenArr[i][2] = Boolean.FALSE;

            if (permArray[1])
                screenArr[i][3] = Boolean.TRUE;
            else
                screenArr[i][3] = Boolean.FALSE;

            if (permArray[2])
                screenArr[i][4] = Boolean.TRUE;
            else
                screenArr[i][4] = Boolean.FALSE;

            if (permArray[3])
                screenArr[i][5] = Boolean.TRUE;
            else
                screenArr[i][5] = Boolean.FALSE;
           

        }

        usersTable.setModel(new javax.swing.table.DefaultTableModel(screenArr, new String[] {
                                                                    "ID", "Screen", "View", "Delete", "Insert", "Update"
            }) {
                Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class,
                    java.lang.Boolean.class, java.lang.Boolean.class
                };
                boolean[] canEdit = new boolean[] { false, false, true, true, true, true };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

    }

    List<ScreenDto> readTableData(JTable usersTable) {
        List<ScreenDto> screens = new ArrayList<>();

        for (int i = 0; i < usersTable.getRowCount(); i++) {
            boolean[] permission_i = { false, false, false, false };

            // view status
            if (usersTable.getValueAt(i, 2) != null)
                permission_i[0] = Boolean.valueOf(usersTable.getValueAt(i, 2).toString());
            // delete status
            if (usersTable.getValueAt(i, 3) != null)
                permission_i[1] = Boolean.valueOf(usersTable.getValueAt(i, 3).toString());
            // insert status
            if (usersTable.getValueAt(i, 4) != null)
                permission_i[2] = Boolean.valueOf(usersTable.getValueAt(i, 4).toString());
            // update status
            if (usersTable.getValueAt(i, 5) != null)
                permission_i[3] = Boolean.valueOf(usersTable.getValueAt(i, 5).toString());

            // get the selected role and set the current
            RoleDto role = new RoleDto(allRoles.get(roleCombo.getSelectedIndex()).getCode());
            role.setRole_id(allRoles.get(roleCombo.getSelectedIndex()).getRole_id());
            role.setPermissionType(Utilities.convertTOBase10(permission_i));
            // each row is a screen
            ScreenDto screen = new ScreenDto(Integer.parseInt(usersTable.getValueAt(i, 0).toString()));
            screen.setRole_Screen(role);
            screens.add(screen);

        }
        return screens;
    }
}
