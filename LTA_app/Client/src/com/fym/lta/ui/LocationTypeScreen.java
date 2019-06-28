
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.LocationTypeBao;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.dto.LocationTypeDto;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;


public class LocationTypeScreen extends javax.swing.JPanel {
    boolean updateFlag = false ;  
    LocationTypeBao LocationTypeListInDatabase = new BaoFactory().createLocationTypeBao();
   
    /**table Structure  */
    private void setTableModel(List<LocationTypeDto> LocationType)
    {
       Object [][] Column = new Object [LocationType.size()][6];
       for(int i =0;i<LocationType.size();i++){
           Column[i][0] = LocationType.get(i).getCode();
           Column[i][1] = LocationType.get(i).getDescription();
           Column[i][2] = LocationType.get(i).getInsertedBy();
           Column[i][3] = LocationType.get(i).getInertion_Date();
           Column[i][4] = LocationType.get(i).getUpdatedBy();
           Column[i][5] = LocationType.get(i).getUpdate_Date();

           
       }
       Table.setModel(new javax.swing.table.DefaultTableModel(Column,new String [] {" Location Type Code " , " Description","Inserted By",
 "  Insertion Date", "Updated By", "Update Date"}));  
    }
    /** Creates new form LocationTypeScreen */
    public LocationTypeScreen() {
        initComponents();
            insertPanel.setVisible(false);
            // screenID = 3
            // now one step we will create an object of ScreenBao to know the current permission
            int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(3);
            Utilities.mandate(updateLocationTypeBTN, insertLocationTypeBTN, deleteLocationTypeBTN, 3,  Utilities.convertTOBase2(permissionType));
            
        if (LocationTypeListInDatabase.listLocationType()!=null)
            setTableModel(LocationTypeListInDatabase.listLocationType());
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
        lPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        updateLocationTypeBTN = new javax.swing.JButton();
        deleteLocationTypeBTN = new javax.swing.JButton();
        LocationTypeEnteredCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        insertLocationTypeBTN = new javax.swing.JButton();
        insertPanel = new javax.swing.JPanel();
        save1 = new javax.swing.JButton();
        desc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        code1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        searchBuildingBTN = new javax.swing.JButton();

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

        lPanel.setBackground(new java.awt.Color(0, 0, 0));
        lPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 240, 240)), "Location Type", 0, 0, new java.awt.Font("Tekton Pro Cond", 2, 24), new java.awt.Color(204, 240, 240))); // NOI18N

        Table.setBackground(new java.awt.Color(51, 98, 114));
        Table.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location Type Code", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table.setRowHeight(30);
        Table.setSelectionBackground(new java.awt.Color(22, 224, 236));
        jScrollPane1.setViewportView(Table);
        Table.getColumnModel().getColumn(0).setHeaderValue("Location Type Code");
        Table.getColumnModel().getColumn(1).setHeaderValue("Description");

        javax.swing.GroupLayout lPanelLayout = new javax.swing.GroupLayout(lPanel);
        lPanel.setLayout(lPanelLayout);
        lPanelLayout.setHorizontalGroup(
            lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
        );
        lPanelLayout.setVerticalGroup(
            lPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );

        add(lPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 550, 370));

        updateLocationTypeBTN.setBackground(new java.awt.Color(0, 0, 0));
        updateLocationTypeBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateLocationTypeBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\update.png")); // NOI18N
        updateLocationTypeBTN.setBorderPainted(false);
        updateLocationTypeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateLocationTypeBTNActionPerformed(evt);
            }
        });
        add(updateLocationTypeBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 80, 30));

        deleteLocationTypeBTN.setBackground(new java.awt.Color(0, 0, 0));
        deleteLocationTypeBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteLocationTypeBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\delete.png")); // NOI18N
        deleteLocationTypeBTN.setBorderPainted(false);
        deleteLocationTypeBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteLocationTypeBTNMouseClicked(evt);
            }
        });
        add(deleteLocationTypeBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 80, 30));

        LocationTypeEnteredCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LocationTypeEnteredCode.setText(" ");
        LocationTypeEnteredCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(LocationTypeEnteredCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 230, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search2.png")); // NOI18N
        jLabel1.setText(" ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 123, 20));

        insertLocationTypeBTN.setBackground(new java.awt.Color(0, 0, 0));
        insertLocationTypeBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertLocationTypeBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\insert.png")); // NOI18N
        insertLocationTypeBTN.setBorderPainted(false);
        insertLocationTypeBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertLocationTypeBTNMouseClicked(evt);
            }
        });
        add(insertLocationTypeBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 120, 30));

        insertPanel.setBackground(new java.awt.Color(51, 98, 114));
        insertPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        insertPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        save1.setBackground(new java.awt.Color(51, 98, 114));
        save1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save1.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\save.png")); // NOI18N
        save1.setBorderPainted(false);
        save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ActionPerformed(evt);
            }
        });
        insertPanel.add(save1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 140, 60));

        desc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        desc.setBorder(null);
        desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descActionPerformed(evt);
            }
        });
        insertPanel.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 120, 265, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Description");
        insertPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 133, -1, 42));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Code");
        insertPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 41, 77, 54));

        code1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        code1.setBorder(null);
        insertPanel.add(code1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 51, 164, 36));

        add(insertPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 400, 400));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LocationTypes Screen ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 0, 280, 50));

        searchBuildingBTN.setBackground(new java.awt.Color(0, 0, 0));
        searchBuildingBTN.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchBuildingBTN.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\search.png")); // NOI18N
        searchBuildingBTN.setBorderPainted(false);
        searchBuildingBTN.setMaximumSize(new java.awt.Dimension(70, 30));
        searchBuildingBTN.setMinimumSize(new java.awt.Dimension(70, 30));
        searchBuildingBTN.setPreferredSize(new java.awt.Dimension(70, 30));
        searchBuildingBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBuildingBTNMouseClicked(evt);
            }
        });
        add(searchBuildingBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 80, 50));
    }//GEN-END:initComponents

    private void updateLocationTypeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateLocationTypeBTNActionPerformed
    if(Table.getSelectedRow()>=0)
    {
    updateFlag = true ;
    jLabel3.setVisible(false);
    code1.setVisible(false);
    }
    else JOptionPane.showMessageDialog(this, "select a Location Type to delete");     
    }//GEN-LAST:event_updateLocationTypeBTNActionPerformed

    private void deleteLocationTypeBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLocationTypeBTNMouseClicked
    insertPanel.setVisible(false);
   if(Table.getSelectedRow()>=0)
   {
        
        String Code = Table.getValueAt(Table.getSelectedRow(), 0).toString(); // get the LocationType code
        LocationTypeDto SelectedLocationType = new LocationTypeDto(); // selected LocationType you wanna delete
        SelectedLocationType.setCode(Code);
                 int msg=  JOptionPane.showConfirmDialog(this, "are you sure you need to delete ");
                                if (msg == JOptionPane.OK_OPTION)
                                { //the result would be "remove the selected row and check the returned value to tell the user if the delete is done or not"
               if(LocationTypeListInDatabase.deleteLocationType(SelectedLocationType)){
                 JOptionPane.showMessageDialog(this, "the selected LocationType is deleted Successfully  ");
                 //refresh the table data..
                     setTableModel(LocationTypeListInDatabase.listLocationType());
                     
                 } else
                     JOptionPane.showMessageDialog(this, " this LocationType can't be deleteted ");
                                }
    }
    else JOptionPane.showMessageDialog(this, "select a Location Type to delete");     
    }//GEN-LAST:event_deleteLocationTypeBTNMouseClicked

    private void insertLocationTypeBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertLocationTypeBTNMouseClicked
    updateFlag = false ;
    insertPanel.setVisible(true);
    code1.setText(null);
    desc.setText(null);
    jLabel3.setVisible(true);
    code1.setVisible(true);
    }//GEN-LAST:event_insertLocationTypeBTNMouseClicked

    private void save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ActionPerformed
     
        LocationTypeDto LocationType = new LocationTypeDto();
        LocationType.setDescription(desc.getText());

        if(updateFlag)
        {   LocationType.setUpdate_Date(new Date(System.currentTimeMillis()));
            LocationType.setUpdatedBy(LoginEngine.currentUser);
            LocationType.setCode( Table.getValueAt(Table.getSelectedRow(), 0).toString());
        }
        else{
            LocationType.setUpdatedBy(LoginEngine.currentUser);
            LocationType.setInsertedBy(LoginEngine.currentUser);
            LocationType.setUpdate_Date(new Date(System.currentTimeMillis()));
            LocationType.setInertion_Date(new Date(System.currentTimeMillis()));
            LocationType.setCode(code1.getText());
        }

        if (LocationTypeListInDatabase.save(LocationType))
        {JOptionPane.showMessageDialog(this , " saved ");
         setTableModel(LocationTypeListInDatabase.listLocationType()) ;
        }
        else JOptionPane.showMessageDialog(this , "error can't save ");
    }//GEN-LAST:event_save1ActionPerformed

    private void descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Utilities.printRecord(lPanel);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        Utilities.export_PDF(Table);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        Utilities.export_XLX(Table);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        if(evt.isPopupTrigger())
           {
           popup.show(this, evt.getX(), evt.getY());    
           }
    }//GEN-LAST:event_formMouseReleased

    private void searchBuildingBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBuildingBTNMouseClicked

    try{
    insertPanel.setVisible(true);
    String Code = null; // hold entered data
    if (LocationTypeEnteredCode.getText()!= null )
    
    setTableModel(LocationTypeListInDatabase.SearchLocationType(LocationTypeEnteredCode.getText())) ;
    else
    setTableModel(LocationTypeListInDatabase.listLocationType()) ;
    }catch (Exception e) {
    // TODO: Add catch code
    e.printStackTrace();
    }
    }//GEN-LAST:event_searchBuildingBTNMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        insertPanel.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LocationTypeEnteredCode;
    private javax.swing.JTable Table;
    private javax.swing.JTextField code1;
    private javax.swing.JButton deleteLocationTypeBTN;
    private javax.swing.JTextField desc;
    private javax.swing.JButton insertLocationTypeBTN;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lPanel;
    private javax.swing.JPopupMenu popup;
    private javax.swing.JButton save1;
    private javax.swing.JButton searchBuildingBTN;
    private javax.swing.JButton updateLocationTypeBTN;
    // End of variables declaration//GEN-END:variables

}
