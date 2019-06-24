
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.DepartmentBao;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.DepartmentDto;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;


public class DepartmentsScreen extends javax.swing.JPanel {
    boolean updateFlag = false;
    private DepartmentBao departmentBaoObj = new BaoFactory().createDepartmentBao();
    private List<DepartmentDto> searchReturnedDepartment;

    List<BuildingDto> allBuildings = new BaoFactory().createBuildingBao().listBuilding();

    /** Creates new form DepartmentSearch */
    public DepartmentsScreen() {
        initComponents();

        listComboBuildings(allBuildings);
        insertPanel.setVisible(false);
        if(departmentBaoObj.listDepartment()!=null)
        {
            departmentTableReset(departmentBaoObj.listDepartment());
        }
        
        int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(4);
        Utilities.mandate(departmrntUpdateBtn, departmrntInsertBtn, departmrntDeleteBtn, 4,  Utilities.convertTOBase2(permissionType));

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
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        departmentCode_TextField = new javax.swing.JTextField();
        departmrntDeleteBtn = new javax.swing.JButton();
        departmrntUpdateBtn = new javax.swing.JButton();
        departmrntInsertBtn = new javax.swing.JButton();
        insertPanel = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        code_TextField = new javax.swing.JTextField();
        name_TextField = new javax.swing.JTextField();
        homeBuilding_ComboBox = new javax.swing.JComboBox();
        dPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DepartmentTable = new javax.swing.JTable();

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
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Department Screen");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(458, 12, 206, 29));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearch.setText("Search ");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 80, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Search");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 35, 71, 20));

        departmentCode_TextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(departmentCode_TextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, 30));

        departmrntDeleteBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        departmrntDeleteBtn.setText("Delete ");
        departmrntDeleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmrntDeleteBtnMouseClicked(evt);
            }
        });
        departmrntDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmrntDeleteBtnActionPerformed(evt);
            }
        });
        add(departmrntDeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 80, 30));

        departmrntUpdateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        departmrntUpdateBtn.setText("Update");
        departmrntUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmrntUpdateBtnActionPerformed(evt);
            }
        });
        add(departmrntUpdateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 80, 30));

        departmrntInsertBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        departmrntInsertBtn.setText("Insert new");
        departmrntInsertBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmrntInsertBtnMouseClicked(evt);
            }
        });
        add(departmrntInsertBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        insertPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Code");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Home Building ");

        javax.swing.GroupLayout insertPanelLayout = new javax.swing.GroupLayout(insertPanel);
        insertPanel.setLayout(insertPanelLayout);
        insertPanelLayout.setHorizontalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(75, 75, 75)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_TextField)
                    .addComponent(homeBuilding_ComboBox, 0, 266, Short.MAX_VALUE)
                    .addGroup(insertPanelLayout.createSequentialGroup()
                        .addComponent(code_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        insertPanelLayout.setVerticalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(code_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(name_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(homeBuilding_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        add(insertPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, -1));

        dPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Departments", 0, 0, new java.awt.Font("Tekton Pro Cond", 1, 36))); // NOI18N

        DepartmentTable.setFont(new java.awt.Font("Tekton Pro Cond", 1, 12)); // NOI18N
        DepartmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        DepartmentTable.setRowHeight(30);
        jScrollPane1.setViewportView(DepartmentTable);
        DepartmentTable.getColumnModel().getColumn(0).setHeaderValue("Title 1");
        DepartmentTable.getColumnModel().getColumn(1).setHeaderValue("Title 2");
        DepartmentTable.getColumnModel().getColumn(2).setHeaderValue("Title 3");
        DepartmentTable.getColumnModel().getColumn(3).setHeaderValue("Title 4");

        javax.swing.GroupLayout dPanelLayout = new javax.swing.GroupLayout(dPanel);
        dPanel.setLayout(dPanelLayout);
        dPanelLayout.setHorizontalGroup(
            dPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        dPanelLayout.setVerticalGroup(
            dPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
        );

        add(dPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 202, 550, -1));
    }//GEN-END:initComponents
    
  
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
    
  

    }//GEN-LAST:event_btnSearchActionPerformed
     
     
    
    
    private void departmrntUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmrntUpdateBtnActionPerformed
        if (DepartmentTable.getSelectedRow() >= 0) {

            code_TextField.setText(DepartmentTable.getValueAt(DepartmentTable.getSelectedRow(), 0).toString());
            code_TextField.setEnabled(false);
           // name_TextField.setText(DepartmentTable.getValueAt(DepartmentTable.getSelectedRow(), 1).toString());
            insertPanel.setVisible(true);
            updateFlag = true;


        } else {
            JOptionPane.showMessageDialog(this, "select a department to delete ");
        }
    }//GEN-LAST:event_departmrntUpdateBtnActionPerformed

    private void departmrntDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmrntDeleteBtnActionPerformed
        // D.setDepartment_id(Integer.parseInt(id_TextField.getText()));
    }//GEN-LAST:event_departmrntDeleteBtnActionPerformed

    private void departmrntInsertBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmrntInsertBtnMouseClicked
      insertPanel.setVisible(true);
        code_TextField.setEnabled(true);
        updateFlag = false; 
    }//GEN-LAST:event_departmrntInsertBtnMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked

        if (departmentCode_TextField.getText() != null) {
            DepartmentDto D = new DepartmentDto();
            D.setCode(departmentCode_TextField.getText());
            if (departmentBaoObj.SearchDepartment(D) != null)
                departmentTableReset(departmentBaoObj.SearchDepartment(D));
            else
                JOptionPane.showMessageDialog(null, "not found");

        }

        else {
            // no input will return all Departments
            searchReturnedDepartment = departmentBaoObj.listDepartment();
        }
 
    
    }//GEN-LAST:event_btnSearchMouseClicked

    private void departmrntDeleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmrntDeleteBtnMouseClicked
if(DepartmentTable.getSelectedRow() >= 0)
{        String code = DepartmentTable.getValueAt(DepartmentTable.getSelectedRow(), 0).toString();
        DepartmentDto selectedDepartment_Delete = new DepartmentDto(); // this department i want to delete
        selectedDepartment_Delete.setCode(code);
            int msg=  JOptionPane.showConfirmDialog(this, "are you sure you need to delete ");
                        if (msg == JOptionPane.OK_OPTION)
                        {
        if (departmentBaoObj.deleteDepartment(selectedDepartment_Delete)) {
            JOptionPane.showMessageDialog(this, "deleted");
            departmentTableReset(departmentBaoObj.listDepartment());

        } else {
            JOptionPane.showMessageDialog(this, "Can not delete may be deleted using another Employee ");
        } 
        }
        }
else JOptionPane.showMessageDialog(null,"select a Department to delete");
      
    }//GEN-LAST:event_departmrntDeleteBtnMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        DepartmentDto department = new DepartmentDto();
        BuildingDto building = new BuildingDto();
        building.setBuilding_id(allBuildings.get(homeBuilding_ComboBox.getSelectedIndex()).getBuilding_id());

        department.setName(name_TextField.getText());
        department.setCode(code_TextField.getText());
        department.setHomebuilding(building);
        if (updateFlag) { 
            department.setUpdate_Date(new Date(System.currentTimeMillis()));
            department.setUpdatedBy(LoginEngine.currentUser);
        } else {
            department.setUpdate_Date(new Date(System.currentTimeMillis()));
            department.setUpdatedBy(LoginEngine.currentUser);
            department.setInertion_Date(new Date(System.currentTimeMillis()));
            department.setInsertedBy(LoginEngine.currentUser);
          
        }

        if (departmentBaoObj.saveDepartment(department)) {
            JOptionPane.showMessageDialog(this, "saved ");
            departmentTableReset(departmentBaoObj.listDepartment());
            insertPanel.setVisible(false);
        } else
            JOptionPane.showMessageDialog(this, "can not save "); 
    }//GEN-LAST:event_btnSaveMouseClicked

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
  if(evt.isPopupTrigger())
       {
       popup.show(this, evt.getX(), evt.getY());    
       }
    }//GEN-LAST:event_formMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Utilities.printRecord(dPanel);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        Utilities.export_PDF(DepartmentTable);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        Utilities.export_XLX(DepartmentTable);
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DepartmentTable;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField code_TextField;
    private javax.swing.JPanel dPanel;
    private javax.swing.JTextField departmentCode_TextField;
    private javax.swing.JButton departmrntDeleteBtn;
    private javax.swing.JButton departmrntInsertBtn;
    private javax.swing.JButton departmrntUpdateBtn;
    private javax.swing.JComboBox homeBuilding_ComboBox;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_TextField;
    private javax.swing.JPopupMenu popup;
    // End of variables declaration//GEN-END:variables
    
    
    public void departmentTableReset(List<DepartmentDto> Department) {
        Object[][] DepartmentArr = new Object[Department.size()][7];

        for (int i = 0; i < Department.size(); i++) {
            DepartmentArr[i][0] = Department.get(i).getCode();
            DepartmentArr[i][1] = Department.get(i).getName();
            DepartmentArr[i][2] = Department.get(i).getHomebuilding().getCode();
            DepartmentArr[i][3] = Department.get(i).getInsertedBy();
            DepartmentArr[i][4] = Department.get(i).getInertion_Date();
            DepartmentArr[i][5] = Department.get(i).getUpdatedBy();
            DepartmentArr[i][6] = Department.get(i).getUpdate_Date();

        }
        DepartmentTable.setModel(new javax.swing.table.DefaultTableModel(DepartmentArr, new String[] {
                                                                         "Code", "Name","Code Of Home Building","Inserted By",
 "  Insertion Date", "Updated By", "Update Date" }));
    }

    void listComboBuildings(List<BuildingDto> Buildings) {
        for (int i = 0; i < Buildings.size(); i++) {
            homeBuilding_ComboBox.addItem(Buildings.get(i).getCode());
        }

    }
}
