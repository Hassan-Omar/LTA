
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

/**
 *
 * @author h.omar
 */
public class ScreenRoles extends javax.swing.JPanel {
    // creeate bussiness and dto objects
    RoleBao roleBaoObj = new BaoFactory().createRoleBao();
    ScreenBao screenBaoObj = new BaoFactory().createScreenBao();
    List<RoleDto> allRoles = new ArrayList();
    String permission1=" " , permission2=" ", permission3=" ", permission4=" "; // hold the values of permission on the module
    List<ScreenDto> selectedScreens = new ArrayList(); //hold the values of selected screens

    /** Creates new form ScreenRoles */
    public ScreenRoles() {
        initComponents();
        allRoles = roleBaoObj.getAll();
        setRolesCombo(allRoles);


        // roleID = 13
        // now one step we will create an object of ScreenBao to know the current permission
        String permissionType = new BaoFactory().createScreenBao().getCurrentPermission(13);
        Utilities.mandate(null, null, null, 13, permissionType);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        label3 = new java.awt.Label();
        mod1Checkbox = new javax.swing.JCheckBox();
        mod2Checkbox = new javax.swing.JCheckBox();
        mod3Checkbox = new javax.swing.JCheckBox();
        mod4Checkbox = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        viewCheckbox2 = new javax.swing.JCheckBox();
        insertCheckbox2 = new javax.swing.JCheckBox();
        deleteCheckbox2 = new javax.swing.JCheckBox();
        updateCheckbox2 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        viewCheckbox1 = new javax.swing.JCheckBox();
        insertCheckbox1 = new javax.swing.JCheckBox();
        deleteCheckbox1 = new javax.swing.JCheckBox();
        updateCheckbox1 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        viewCheckbox3 = new javax.swing.JCheckBox();
        insertCheckbox3 = new javax.swing.JCheckBox();
        deleteCheckbox3 = new javax.swing.JCheckBox();
        updateCheckbox3 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        viewCheckbox4 = new javax.swing.JCheckBox();
        insertCheckbox4 = new javax.swing.JCheckBox();
        deleteCheckbox4 = new javax.swing.JCheckBox();
        updateCheckbox4 = new javax.swing.JCheckBox();
        roleCombo = new javax.swing.JComboBox();
        label1 = new java.awt.Label();
        jPanel7 = new javax.swing.JPanel();
        doneBtn = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Screens", 0, 0, new java.awt.Font("Adobe Arabic", 1, 24))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        label3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        mod1Checkbox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mod1Checkbox.setText("Basic Data Management");
        mod1Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod1CheckboxActionPerformed(evt);
            }
        });

        mod2Checkbox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mod2Checkbox.setText("Locations Managnent");
        mod2Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod2CheckboxActionPerformed(evt);
            }
        });

        mod3Checkbox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mod3Checkbox.setText("Authentication and Authorization");
        mod3Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod3CheckboxActionPerformed(evt);
            }
        });

        mod4Checkbox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mod4Checkbox.setText("Tables Managment");
        mod4Checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod4CheckboxActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewCheckbox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewCheckbox2.setText("view");

        insertCheckbox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insertCheckbox2.setText("insert");

        deleteCheckbox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteCheckbox2.setText("delete");

        updateCheckbox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateCheckbox2.setText("update");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(viewCheckbox2)
                .addGap(77, 77, 77)
                .addComponent(insertCheckbox2)
                .addGap(76, 76, 76)
                .addComponent(deleteCheckbox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(updateCheckbox2)
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewCheckbox2)
                    .addComponent(insertCheckbox2)
                    .addComponent(deleteCheckbox2)
                    .addComponent(updateCheckbox2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewCheckbox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewCheckbox1.setText("view");

        insertCheckbox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insertCheckbox1.setText("insert");

        deleteCheckbox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteCheckbox1.setText("delete");

        updateCheckbox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateCheckbox1.setText("update");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(viewCheckbox1)
                .addGap(77, 77, 77)
                .addComponent(insertCheckbox1)
                .addGap(76, 76, 76)
                .addComponent(deleteCheckbox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(updateCheckbox1)
                .addGap(60, 60, 60))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewCheckbox1)
                    .addComponent(insertCheckbox1)
                    .addComponent(deleteCheckbox1)
                    .addComponent(updateCheckbox1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewCheckbox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewCheckbox3.setText("view");

        insertCheckbox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insertCheckbox3.setText("insert");

        deleteCheckbox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteCheckbox3.setText("delete");

        updateCheckbox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateCheckbox3.setText("update");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(viewCheckbox3)
                .addGap(77, 77, 77)
                .addComponent(insertCheckbox3)
                .addGap(76, 76, 76)
                .addComponent(deleteCheckbox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(updateCheckbox3)
                .addGap(60, 60, 60))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewCheckbox3)
                    .addComponent(insertCheckbox3)
                    .addComponent(deleteCheckbox3)
                    .addComponent(updateCheckbox3))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewCheckbox4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewCheckbox4.setText("view");

        insertCheckbox4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insertCheckbox4.setText("insert");

        deleteCheckbox4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteCheckbox4.setText("delete");

        updateCheckbox4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateCheckbox4.setText("update");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(viewCheckbox4)
                .addGap(77, 77, 77)
                .addComponent(insertCheckbox4)
                .addGap(76, 76, 76)
                .addComponent(deleteCheckbox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(updateCheckbox4)
                .addGap(60, 60, 60))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewCheckbox4)
                    .addComponent(insertCheckbox4)
                    .addComponent(deleteCheckbox4)
                    .addComponent(updateCheckbox4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mod2Checkbox)
                            .addComponent(mod3Checkbox)
                            .addComponent(mod4Checkbox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(mod1Checkbox)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(282, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(mod1Checkbox)
                        .addGap(18, 18, 18)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(mod2Checkbox))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(mod3Checkbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(mod4Checkbox)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(47, 47, 47)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(453, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        roleCombo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleComboActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setText("Role");

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
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 1270, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roleCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void doneBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneBtnMouseClicked
       
       
        // now we selectrole selected index is same as
        RoleDto role = allRoles.get(roleCombo.getSelectedIndex());

        if (mod1Checkbox.isSelected()) {
            selectedScreens.add(new ScreenDto(1));
            selectedScreens.add(new ScreenDto(2));
            selectedScreens.add(new ScreenDto(3));
            selectedScreens.add(new ScreenDto(4));
            selectedScreens.add(new ScreenDto(5));
            selectedScreens.add(new ScreenDto(6));
            selectedScreens.add(new ScreenDto(7));
        }

        if (mod2Checkbox.isSelected()) {
            selectedScreens.add(new ScreenDto(8));
            selectedScreens.add(new ScreenDto(9));
            selectedScreens.add(new ScreenDto(10));
        }

        if (mod3Checkbox.isSelected()) {
            selectedScreens.add(new ScreenDto(11));
            selectedScreens.add(new ScreenDto(12));
            selectedScreens.add(new ScreenDto(13));
        }

        if (mod4Checkbox.isSelected())
            selectedScreens.add(new ScreenDto(14));


        // permission on model 1
        if (updateCheckbox1.isSelected())
            permission1 += " update";
        if (viewCheckbox1.isSelected())
            permission1 += " view";
        if (deleteCheckbox1.isSelected())
            permission1 += " delete";
        if (insertCheckbox1.isSelected())
            permission1 += " insert";

        // permission on model 2
        if (updateCheckbox2.isSelected())
            permission2 += " update";
        if (viewCheckbox2.isSelected())
            permission2 += " view";
        if (deleteCheckbox2.isSelected())
            permission2 += " delete";
        if (insertCheckbox2.isSelected())
            permission2 += " insert";


        // permission on model 3
        if (updateCheckbox3.isSelected())
            permission3 += " update";
        if (viewCheckbox3.isSelected())
            permission3 += " view";
        if (deleteCheckbox3.isSelected())
            permission3 += " delete";
        if (insertCheckbox3.isSelected())
            permission3 += " insert";

        // permission on model 4
        if (updateCheckbox4.isSelected())
            permission4 += " update";
        if (viewCheckbox4.isSelected())
            permission4 += " view";
        if (deleteCheckbox4.isSelected())
            permission4 += " delete";
        if (insertCheckbox4.isSelected())
            permission4 += " insert";

        if (permission1 != null)
            role.setPermission1(permission1);
        if (permission2 != null)
            role.setPermission2(permission2);

        if (permission3 != null)
            role.setPermission3(permission3);

        if (permission4 != null)
            role.setPermission4(permission4);

        // calling bussiness to save

        if (selectedScreens != null) {
            try {
                if (screenBaoObj.saveScreenRoles(selectedScreens, role)) {
                    JOptionPane.showMessageDialog(this, "Saved successfully");
                } else
                    JOptionPane.showMessageDialog(this, "Can't Save");

            } catch (LTAException e) {
                JOptionPane.showMessageDialog(this, "Error in Data Base");

            }
        } else
            JOptionPane.showMessageDialog(this, "you should select a one screen at least ");  
       
    }//GEN-LAST:event_doneBtnMouseClicked

    private void roleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleComboActionPerformed
      
        clear();
        // list of screens based on choosen role from combo box
        List<ScreenDto> screens = screenBaoObj.list_Screens(allRoles.get(roleCombo.getSelectedIndex()).getRole_id());
        if (screens != null)
            selectScreens(screens); 
    }//GEN-LAST:event_roleComboActionPerformed

    private void mod1CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod1CheckboxActionPerformed
        if (!mod1Checkbox.isSelected()) {
            // loop to delete data
            for (int i = 1; i < 8; i++) {
                delete(i);
            }
        }
    }//GEN-LAST:event_mod1CheckboxActionPerformed

    private void mod2CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod2CheckboxActionPerformed
        if (!mod2Checkbox.isSelected()) {
            // loop to delete data
            for (int i = 8; i < 11; i++) {
                delete(i);
            }
        }
    }//GEN-LAST:event_mod2CheckboxActionPerformed

    private void mod3CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod3CheckboxActionPerformed
        if (!mod3Checkbox.isSelected()) {
            // loop to delete data
            for (int i = 11; i < 14; i++) {
                delete(i);
            }
        }
    }//GEN-LAST:event_mod3CheckboxActionPerformed

    private void mod4CheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod4CheckboxActionPerformed
        if (!mod4Checkbox.isSelected()) {
            delete(14);
        }
         
    }//GEN-LAST:event_mod4CheckboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox deleteCheckbox1;
    private javax.swing.JCheckBox deleteCheckbox2;
    private javax.swing.JCheckBox deleteCheckbox3;
    private javax.swing.JCheckBox deleteCheckbox4;
    private javax.swing.JButton doneBtn;
    private javax.swing.JCheckBox insertCheckbox1;
    private javax.swing.JCheckBox insertCheckbox2;
    private javax.swing.JCheckBox insertCheckbox3;
    private javax.swing.JCheckBox insertCheckbox4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private javax.swing.JCheckBox mod1Checkbox;
    private javax.swing.JCheckBox mod2Checkbox;
    private javax.swing.JCheckBox mod3Checkbox;
    private javax.swing.JCheckBox mod4Checkbox;
    private javax.swing.JComboBox roleCombo;
    private javax.swing.JCheckBox updateCheckbox1;
    private javax.swing.JCheckBox updateCheckbox2;
    private javax.swing.JCheckBox updateCheckbox3;
    private javax.swing.JCheckBox updateCheckbox4;
    private javax.swing.JCheckBox viewCheckbox1;
    private javax.swing.JCheckBox viewCheckbox2;
    private javax.swing.JCheckBox viewCheckbox3;
    private javax.swing.JCheckBox viewCheckbox4;
    // End of variables declaration//GEN-END:variables



    // this function just to list the role data in roleCombo
    void setRolesCombo(List<RoleDto> roles) {
        for (int i = 0; i < roles.size(); i++) {
            roleCombo.addItem(roles.get(i).getDescription()); // name not desc
        }

    }


    void clear() {
        mod1Checkbox.setSelected(false);
        mod2Checkbox.setSelected(false);
        mod3Checkbox.setSelected(false);
        mod4Checkbox.setSelected(false);
        viewCheckbox1.setSelected(false);
        insertCheckbox1.setSelected(false);
        updateCheckbox1.setSelected(false);
        deleteCheckbox1.setSelected(false);
        viewCheckbox2.setSelected(false);
        insertCheckbox2.setSelected(false);
        updateCheckbox2.setSelected(false);
        deleteCheckbox2.setSelected(false);
        viewCheckbox3.setSelected(false);
        insertCheckbox3.setSelected(false);
        updateCheckbox3.setSelected(false);
        deleteCheckbox3.setSelected(false);
        viewCheckbox4.setSelected(false);
        insertCheckbox4.setSelected(false);
        updateCheckbox4.setSelected(false);
        deleteCheckbox4.setSelected(false);

    }

    boolean delete(int sId) {
        int roleId = allRoles.get(roleCombo.getSelectedIndex()).getRole_id();
        return screenBaoObj.delete(sId, roleId);
    }


    void selectScreens(List<ScreenDto> screens) {
        String permission = null;
        for (int i = 0; i < screens.size(); i++) {
            int id = screens.get(i).getScreen_id();

            if (id < 8) {

                mod1Checkbox.setSelected(true);

                permission = screenBaoObj.getCurrentPermission(id);

                if (permission != null) {
                    if (permission.contains("view"))
                        viewCheckbox1.setSelected(true);
                    if (permission.contains("insert"))
                        insertCheckbox1.setSelected(true);
                    if (permission.contains("update"))
                        updateCheckbox1.setSelected(true);
                    if (permission.contains("delete"))
                        deleteCheckbox1.setSelected(true);
                }

            }

            if (id > 7 && id < 11) {

                mod2Checkbox.setSelected(true);

                permission = screenBaoObj.getCurrentPermission(id);

                if (permission != null) {
                    if (permission.contains("view"))
                        viewCheckbox2.setSelected(true);
                    if (permission.contains("insert"))
                        insertCheckbox2.setSelected(true);
                    if (permission.contains("update"))
                        updateCheckbox2.setSelected(true);
                    if (permission.contains("delete"))
                        deleteCheckbox2.setSelected(true);
                }
            }

            if (id > 10 && id < 14) {

                mod3Checkbox.setSelected(true);

                permission = screenBaoObj.getCurrentPermission(id);
                if (permission != null) {

                    if (permission.contains("view"))
                        viewCheckbox3.setSelected(true);
                    if (permission.contains("insert"))
                        insertCheckbox3.setSelected(true);
                    if (permission.contains("update"))
                        updateCheckbox3.setSelected(true);
                    if (permission.contains("delete"))
                        deleteCheckbox3.setSelected(true);
                }
            }
            if (id > 13) {

                mod4Checkbox.setSelected(true);

                permission = screenBaoObj.getCurrentPermission(id);
                if (permission != null) {

                    if (permission.contains("view"))
                        viewCheckbox4.setSelected(true);
                    if (permission.contains("insert"))
                        insertCheckbox4.setSelected(true);
                    if (permission.contains("update"))
                        updateCheckbox4.setSelected(true);
                    if (permission.contains("delete"))
                        deleteCheckbox4.setSelected(true);
                }
            }
        }
    }
}
