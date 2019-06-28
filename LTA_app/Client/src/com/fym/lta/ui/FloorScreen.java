
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.FloorBao;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.FloorDto;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;


/**
 *
 * @author
 */
public class FloorScreen extends javax.swing.JPanel {
    FloorBao FloorListInDatabase = new BaoFactory().createFloorBao();
    boolean updateFlag;
    List<BuildingDto> allBuilding = new BaoFactory().createBuildingBao().listBuilding();

    /**table Structure  */
    private void setTableModel(List<FloorDto> Floor) {
        Object[][] Column = new Object[Floor.size()][3];
        for (int i = 0; i < Floor.size(); i++) {
            Column[i][0] = Floor.get(i).getCode();
            Column[i][1] = Floor.get(i).getDescription();
            Column[i][2] = Floor.get(i).getBuilding().getCode();


        }
        floorTable.setModel(new javax.swing.table.DefaultTableModel(Column, new String[] {
                                                                    " Code ", " Description ", "Building Code" }));
    }


    /** Creates new form FloorScreen */
    public FloorScreen() {
        initComponents();
        //get all Floors data from database...
        if (FloorListInDatabase.listFloor() != null)
            setTableModel(FloorListInDatabase.listFloor());

        insertPanel.setVisible(false);
        // screenID = 2
        // now one step we will create an object of ScreenBao to know the current permission
        int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(2);
        System.out.println(permissionType+"permissionType");
        Utilities.mandate(updateFloorBTN, insertFloorBTN, deleteFloorBTN, 2,  Utilities.convertTOBase2(permissionType));

        if (allBuilding != null)
            listCombo(allBuilding);
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
        fPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        floorTable = new javax.swing.JTable();
        FloorEnteredCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        searchFloorBTN = new javax.swing.JButton();
        insertPanel = new javax.swing.JPanel();
        code = new javax.swing.JTextField();
        codeLabel = new javax.swing.JLabel();
        desc = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        buildingComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        insertFloorBTN = new javax.swing.JButton();
        deleteFloorBTN = new javax.swing.JButton();
        updateFloorBTN = new javax.swing.JButton();

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

        fPanel.setBackground(new java.awt.Color(0, 0, 0));
        fPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Building Floors", 0, 0, new java.awt.Font("Tekton Pro Cond", 2, 24))); // NOI18N

        floorTable.setBackground(new java.awt.Color(51, 98, 114));
        floorTable.setFont(new java.awt.Font("Tekton Pro Cond", 0, 18)); // NOI18N
        floorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        floorTable.setRowHeight(30);
        floorTable.setSelectionBackground(new java.awt.Color(22, 224, 236));
        jScrollPane1.setViewportView(floorTable);
        floorTable.getColumnModel().getColumn(0).setHeaderValue("Code");
        floorTable.getColumnModel().getColumn(1).setHeaderValue("Description");

        javax.swing.GroupLayout fPanelLayout = new javax.swing.GroupLayout(fPanel);
        fPanel.setLayout(fPanelLayout);
        fPanelLayout.setHorizontalGroup(
            fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        fPanelLayout.setVerticalGroup(
            fPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))
        );

        add(fPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 560, 370));

        FloorEnteredCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FloorEnteredCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(FloorEnteredCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 39, 105, 30));

        searchFloorBTN.setBackground(new java.awt.Color(0, 0, 0));
        searchFloorBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchFloorBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search.png")); // NOI18N
        searchFloorBTN.setBorderPainted(false);
        searchFloorBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchFloorBTNMouseClicked(evt);
            }
        });
        add(searchFloorBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 80, 50));

        insertPanel.setBackground(new java.awt.Color(51, 98, 114));
        insertPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insertPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        code.setBorder(null);
        insertPanel.add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 23, 152, 34));

        codeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        codeLabel.setForeground(new java.awt.Color(255, 255, 255));
        codeLabel.setText("Code");
        insertPanel.add(codeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 13, 108, 54));

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc.setBorder(null);
        desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descActionPerformed(evt);
            }
        });
        insertPanel.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 85, 280, 75));

        save.setBackground(new java.awt.Color(0, 0, 0));
        save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\save.png")); // NOI18N
        save.setBorderPainted(false);
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        insertPanel.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 323, 140, 60));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Description:");
        insertPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 101, 206, 42));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Choose Building");
        insertPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 217, 211, 42));

        insertPanel.add(buildingComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(295, 225, 211, 29));

        add(insertPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 610, 410));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Floors Screen ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 0, 231, 54));

        insertFloorBTN.setBackground(new java.awt.Color(0, 0, 0));
        insertFloorBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertFloorBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\insert.png")); // NOI18N
        insertFloorBTN.setBorderPainted(false);
        insertFloorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertFloorBTNActionPerformed(evt);
            }
        });
        add(insertFloorBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        deleteFloorBTN.setBackground(new java.awt.Color(0, 0, 0));
        deleteFloorBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteFloorBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\delete.png")); // NOI18N
        deleteFloorBTN.setBorderPainted(false);
        deleteFloorBTN.setLabel("Delete");
        deleteFloorBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteFloorBTNMouseClicked(evt);
            }
        });
        add(deleteFloorBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 90, 30));

        updateFloorBTN.setBackground(new java.awt.Color(0, 0, 0));
        updateFloorBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateFloorBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\update.png")); // NOI18N
        updateFloorBTN.setText("\n");
        updateFloorBTN.setBorderPainted(false);
        updateFloorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateFloorBTNActionPerformed(evt);
            }
        });
        add(updateFloorBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 90, 30));
    }//GEN-END:initComponents




    private void updateFloorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateFloorBTNActionPerformed
   
        if (floorTable.getSelectedRow() >= 0) {
            codeLabel.setVisible(false);
            code.setVisible(false);

            try {

                insertPanel.setVisible(true);
                updateFlag = true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            JOptionPane.showMessageDialog(this, " you may forgot to select the floor you wanna update ");
    
    }//GEN-LAST:event_updateFloorBTNActionPerformed

    private void deleteFloorBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFloorBTNMouseClicked
 
        if (floorTable.getSelectedRow() >= 0) {
            String code = floorTable.getValueAt(floorTable.getSelectedRow(), 0).toString(); // get the building code
            FloorDto SelectedFloor = new FloorDto(); // selected building you wanna delete
            SelectedFloor.setCode(code);
            int msg = JOptionPane.showConfirmDialog(this, "are you sure you need to delete ");
            if (msg == JOptionPane.OK_OPTION) {
                //the result would be "remove the selected row and check the returned value to tell the user if the delete is done or not"
                if (FloorListInDatabase.deleteFloor(SelectedFloor)) {
                    JOptionPane.showMessageDialog(this, "deleted Successfully  ");
                    //refresh the table data..
                    setTableModel(FloorListInDatabase.listFloor());
                }
            } else
                JOptionPane.showMessageDialog(this, " this floor can't be deleteted ");
        } else
            JOptionPane.showMessageDialog(this, "Select a floor to delete");
       
        
    
    }//GEN-LAST:event_deleteFloorBTNMouseClicked

    private void insertFloorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertFloorBTNActionPerformed
        insertPanel.setVisible(true);
        updateFlag = false;
        codeLabel.setVisible(true);
        code.setVisible(true);
        code.setText(null);
        desc.setText(null);
    }//GEN-LAST:event_insertFloorBTNActionPerformed

    private void searchFloorBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchFloorBTNMouseClicked

        try {
            insertPanel.setVisible(false);
            String code = null; // hold entered data
            if (FloorEnteredCode.getText() != null)

                setTableModel(FloorListInDatabase.SearchFloor(FloorEnteredCode.getText()));
            else
                setTableModel(FloorListInDatabase.listFloor());
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }//GEN-LAST:event_searchFloorBTNMouseClicked

    private void descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        FloorDto floor = new FloorDto();

        floor.setDescription(desc.getText());

        if (updateFlag) {
            floor.setUpdate_Date(new Date(System.currentTimeMillis()));
            floor.setUpdatedBy(LoginEngine.currentUser);
            floor.setCode(floorTable.getValueAt(floorTable.getSelectedRow(), 0).toString());
        } else {
            floor.setUpdatedBy(LoginEngine.currentUser);
            floor.setInsertedBy(LoginEngine.currentUser);
            floor.setUpdate_Date(new Date(System.currentTimeMillis()));
            floor.setInertion_Date(new Date(System.currentTimeMillis()));
            floor.setCode(code.getText());
        }

        floor.setBuilding(allBuilding.get(buildingComboBox.getSelectedIndex()));

        if (FloorListInDatabase.save(floor)) {
            JOptionPane.showMessageDialog(this, " saved ");
            setTableModel(FloorListInDatabase.listFloor());
            insertPanel.setVisible(false);
        } else
            JOptionPane.showMessageDialog(this, "error can't save ");
    }//GEN-LAST:event_saveMouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Utilities.printRecord(fPanel);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        Utilities.export_PDF(floorTable);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        Utilities.export_XLX(floorTable);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

    if(evt.isPopupTrigger())
       {
       popup.show(this, evt.getX(), evt.getY());    
       }
    }//GEN-LAST:event_formMouseReleased

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        insertPanel.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FloorEnteredCode;
    private javax.swing.JComboBox buildingComboBox;
    private javax.swing.JTextField code;
    private javax.swing.JLabel codeLabel;
    private javax.swing.JButton deleteFloorBTN;
    private javax.swing.JTextField desc;
    private javax.swing.JPanel fPanel;
    private javax.swing.JTable floorTable;
    private javax.swing.JButton insertFloorBTN;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JButton save;
    private javax.swing.JButton searchFloorBTN;
    private javax.swing.JButton updateFloorBTN;
    // End of variables declaration//GEN-END:variables


    void listCombo(List<BuildingDto> buildings) {
        for (int i = 0; i < buildings.size(); i++) {
            buildingComboBox.addItem(buildings.get(i).getCode());
        }
    }
}

