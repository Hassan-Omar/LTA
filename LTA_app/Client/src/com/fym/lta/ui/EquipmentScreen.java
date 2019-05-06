
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.EquipmentBao;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.EquipmentDto;
import com.fym.lta.dto.FloorDto;
import com.fym.lta.dto.LocationDto;

import java.util.Date;
import java.util.List;

import javax.persistence.Table;

import javax.swing.JOptionPane;

/**
 *
 * @author Nada
 */
public class EquipmentScreen extends javax.swing.JPanel {
    
    //To create a refrence from EquipmentBao 
    private EquipmentBao Equipmentbusiness  = new BaoFactory().createEquipmentBao();
    
    //To Get list of  locations  to set comboBox items 
    List<LocationDto> All_locations = new BaoFactory().createLocationBao().ListAll();
  
    // flag , if it equals 1 we update, if zero we insert 
    private int Equipment_idUpdate ;
    
    
    //To add comboBox items//
    // We get a list of saved items in Database//  
    void listComboLocations(List<LocationDto> location) {
    for (int i = 0; i < location.size(); i++) {
      location_combo.addItem(location.get(i).getCode()); }
    }
   
    // To Set the retrieved data from database into the locationTable// 
    private void setTableModel(List<EquipmentDto> equipment){
        Object [][] equipmentArr = new Object [equipment.size()][10];
        for(int i =0;i<equipment.size();i++){
            equipmentArr[i][0] = equipment.get(i).getEquipment_id();
            equipmentArr[i][1] = equipment.get(i).getCode();
            equipmentArr[i][2] = equipment.get(i).getType();
            equipmentArr[i][3] = equipment.get(i).getLifSpan();
            equipmentArr[i][4] = equipment.get(i).getStartingTime();
            equipmentArr[i][5] = equipment.get(i).getLocation_equipment().getCode();     
            equipmentArr[i][6] = equipment.get(i).getInsertedBy();
            equipmentArr[i][7] = equipment.get(i).getInertion_Date();
            equipmentArr[i][8] = equipment.get(i).getUpdatedBy();
            equipmentArr[i][9] = equipment.get(i).getUpdate_Date();      
        }
        EquipmentTable.setModel(new javax.swing.table.DefaultTableModel(equipmentArr,
            new String [] {
                "Equipment Id", "Equipment Code" , "Equipment Type", "Life Span" ,"Starting time","Location" ,"Inserted By" , "Insertion Date" , "Updated By","Update Date"
            }
        ));   }  
    
    /** Creates new form EquipmentScreen */
    public EquipmentScreen() {
        initComponents();
        if(Equipmentbusiness.ListAll()!=null)
        setTableModel(Equipmentbusiness.ListAll());
        listComboLocations(All_locations);
        DefineEquipment.setVisible(false);
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        master = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EquipmentTable = new javax.swing.JTable();
        insert = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        DefineEquipment = new javax.swing.JPanel();
        location_combo = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        years_number = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        master.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipments"));
        master.setPreferredSize(new java.awt.Dimension(400, 400));

        EquipmentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12"
            }
        ));
        jScrollPane1.setViewportView(EquipmentTable);

        javax.swing.GroupLayout masterLayout = new javax.swing.GroupLayout(master);
        master.setLayout(masterLayout);
        masterLayout.setHorizontalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
        );
        masterLayout.setVerticalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 1120;
        gridBagConstraints.ipady = 280;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 133, 49, 0);
        add(master, gridBagConstraints);

        insert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insert.setText("Insert New Equipment");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(67, 74, 0, 0);
        add(insert, gridBagConstraints);

        delete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delete.setText("Delete Equipment");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(67, 154, 0, 0);
        add(delete, gridBagConstraints);

        update.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        update.setText("Update Equipment");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(67, 182, 0, 0);
        add(update, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 385;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(62, 61, 0, 0);
        add(jTextField1, gridBagConstraints);

        search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(55, 131, 0, 0);
        add(search, gridBagConstraints);

        DefineEquipment.setBorder(javax.swing.BorderFactory.createTitledBorder("Define Equipment"));

        location_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        location_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                location_comboActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Location  ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Code");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Type");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Number of used years");

        save.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DefineEquipmentLayout = new javax.swing.GroupLayout(DefineEquipment);
        DefineEquipment.setLayout(DefineEquipmentLayout);
        DefineEquipmentLayout.setHorizontalGroup(
            DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DefineEquipmentLayout.createSequentialGroup()
                .addGroup(DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DefineEquipmentLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DefineEquipmentLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DefineEquipmentLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DefineEquipmentLayout.createSequentialGroup()
                        .addGroup(DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(years_number, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(119, Short.MAX_VALUE))
                    .addGroup(DefineEquipmentLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))))
            .addGroup(DefineEquipmentLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(location_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DefineEquipmentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178))
        );
        DefineEquipmentLayout.setVerticalGroup(
            DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DefineEquipmentLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(location_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(DefineEquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(years_number, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 107;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 42, 49, 22);
        add(DefineEquipment, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Enter Equipment Code");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 133, 0, 0);
        add(jLabel8, gridBagConstraints);
    }//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        clearData();
       Equipment_idUpdate = 0;
        DefineEquipment.setVisible(true);

        // UsersScreen.createPopupMenu(new DefineLocation());
    }//GEN-LAST:event_insertActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
    if (EquipmentTable.getSelectedRow() >= 0) {
        try{
             DefineEquipment.setVisible(false);
            int EquipmentIndex = Integer.parseInt(EquipmentTable.getValueAt(EquipmentTable.getSelectedRow(), 0).toString());
            EquipmentDto selected_Equipment = new EquipmentDto(); // selected Equipment, To delete.
            selected_Equipment.setEquipment_id(EquipmentIndex);
            if (Equipmentbusiness.deleteEquipment(selected_Equipment)) {  //if returned true, Equipment will be deleted
                JOptionPane.showMessageDialog(this, "Equipment is Deleted Successfully");
                setTableModel(Equipmentbusiness.ListAll());
                EquipmentTable.repaint() ;
            }else
            JOptionPane.showMessageDialog(this, "Can't delete this equipment ! ");
            }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    else {  // if no equipment is selected on the table
       JOptionPane.showMessageDialog(this, "you should select an Equipment to delete  ");
    }
        
       
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (EquipmentTable.getSelectedRow()>=0)
        {    // No need to update Id, so we hide it//
            id.setVisible(false); 
            jLabel1.setVisible(false);
            try{
            id.setText(EquipmentTable.getValueAt(EquipmentTable.getSelectedRow(), 0).toString());
            code.setText(EquipmentTable.getValueAt(EquipmentTable.getSelectedRow(), 1).toString());
            type.setText(EquipmentTable.getValueAt(EquipmentTable.getSelectedRow(), 2).toString());
            years_number.setText(EquipmentTable.getValueAt(EquipmentTable.getSelectedRow(), 3).toString());       
            DefineEquipment.setVisible(true);
                
            // flag , if it equals 1 we update, if zero we insert     
            Equipment_idUpdate = 1;    
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        else JOptionPane.showMessageDialog(this, " you should select an Equipment to update ");

    }//GEN-LAST:event_updateActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

          try {
            DefineEquipment.setVisible(false);
              if (jTextField1.getText()!= null){
                setTableModel(Equipmentbusiness.SearchEquipment(jTextField1.getText()));
                 jTextField1.setText(null);}
            else
            setTableModel(Equipmentbusiness.ListAll());

        } catch(java.lang.NullPointerException e){
        JOptionPane.showMessageDialog(this, "This Equipment isn't existed ");    
        }
          catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchActionPerformed

    private void location_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_location_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_location_comboActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try{
            //Create Dto Objects to get data from UI and then pass it to Bao//
           EquipmentDto EquipmentObject = new EquipmentDto();
           LocationDto LocationObject = new LocationDto();  
           
            //To get data from UI//
            EquipmentObject.setEquipment_id(Integer.parseInt(id.getText()));
            EquipmentObject.setCode(code.getText());
            EquipmentObject.setType(type.getText());
            EquipmentObject.setLifSpan(Integer.parseInt(years_number.getText()));
           
            //To set id for location//
            LocationObject.setLocation_id(All_locations.get(location_combo.getSelectedIndex()).getLocation_id());
            EquipmentObject.setLocation_equipment(LocationObject);
          
            //To Check whether to insert or update data// 
            if(Equipment_idUpdate !=0)
            {       
                    EquipmentObject.setUpdatedBy(LoginEngine.currentUser);
                    EquipmentObject.setUpdate_Date(new Date(System.currentTimeMillis()));
                if(Equipmentbusiness.updateEquipment(EquipmentObject)) {
                    JOptionPane.showMessageDialog(this, "Location Updated Successfully");
                    setTableModel(Equipmentbusiness.ListAll());
                    EquipmentTable.repaint();  }
                else
                JOptionPane.showMessageDialog(this, "Error occured in update");}
            else
            {
                EquipmentObject.setInsertedBy(LoginEngine.currentUser);
                EquipmentObject.setInertion_Date(new Date(System.currentTimeMillis()));
            EquipmentObject.setStartingTime(new Date(System.currentTimeMillis()));
                if( Equipmentbusiness.insertEquipment(EquipmentObject)){
                JOptionPane.showMessageDialog(this, "Location Saved Successfully");
                setTableModel(Equipmentbusiness.ListAll());
                EquipmentTable.repaint();
            }else
            JOptionPane.showMessageDialog(this, "Error occured in insertion");
        }

        } catch(java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Error occured, There is an Error in data Type Or Some Of Data is Missed !");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DefineEquipment;
    private javax.swing.JTable EquipmentTable;
    private javax.swing.JTextField code;
    private javax.swing.JButton delete;
    private javax.swing.JTextField id;
    private javax.swing.JButton insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox location_combo;
    private javax.swing.JPanel master;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JTextField type;
    private javax.swing.JButton update;
    private javax.swing.JTextField years_number;
    // End of variables declaration//GEN-END:variables
    
    // this method just to clear text and reset the valus on the insert panel
    void clearData() { // clear prvious data
        id.setText(null);
        code.setText(null);
        type.setText(null);
        years_number.setText(null);
        
        // show hiden components again
        id.setVisible(true);
        jLabel1.setVisible(true);      
    }
    
   
}
