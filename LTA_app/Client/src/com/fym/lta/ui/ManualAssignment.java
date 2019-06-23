
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.LocationBao;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.LocationDto;
import com.fym.lta.dto.LocationTypeDto;

import com.fym.lta.dto.SlotDto;

import java.util.List;

import javax.swing.JOptionPane;

import org.w3.x2000.x09.xmldsig.ObjectType;

/**
 *
 * @author Nada
 */
public class ManualAssignment extends javax.swing.JPanel {
    
    //To create a refrence from LocationBao 
    private LocationBao Locationbusiness  = new BaoFactory().createLocationBao();
    
    //To Get list of building , location type to set comboBox items 
    List<BuildingDto> Allbuildings = new BaoFactory().createBuildingBao().listBuilding();
    List<LocationTypeDto> AlllocationTypes = new BaoFactory().createLocationTypeBao().listLocationType(); 
   
    //To add comboBox items//
    // We get a list of saved items in Database//
    void listComboBuildings(List<BuildingDto> building) {
       for (int i = 0; i < building.size(); i++) {
           building_combo.addItem(building.get(i).getCode());
                 }
    }
    
    void listComboLocationTypes(List<LocationTypeDto> LocationType) {
          for (int i = 0; i < LocationType.size(); i++) {
             type_combo.addItem(LocationType.get(i).getCode());
                    }
    }
    
    // To Set the retrieved data from database into the locationTable// 
    private void setTableModel(List<LocationDto> location  ){
        Object [][] locationArr = new Object [location.size()][6];
        for(int i =0;i<location.size();i++){
            locationArr[i][0] = location.get(i).getCode();
            locationArr[i][1] = location.get(i).getDescription();
            locationArr[i][2] = location.get(i).getCapacity();
            locationArr[i][3] = location.get(i).getFloor().getBuilding().getCode();
            locationArr[i][4] = location.get(i).getFloor().getCode();
            locationArr[i][5] = location.get(i).getType().getCode();
                                                             }    
        
        LocationTable.setModel(new javax.swing.table.DefaultTableModel(locationArr,
            new String [] {
                 "Location Code" , "Description", "capacity" ,"Building", "Floor","Location Type" 
            }
        ));   }

    /** Creates new form ManualAssignment */
    public ManualAssignment() {
        try {
            initComponents();
            if(Locationbusiness.ListAll()!=null)
            setTableModel(Locationbusiness.ListAll());
            listComboBuildings(Allbuildings); 
            listComboLocationTypes(AlllocationTypes);
            slotsPanel.setVisible(false);
          //  assign.setVisible(false);
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
        
        // now one step we will create an object of ScreenBao to know the current permission 
       // int permissionType = new BaoFactory().createScreenBao().getCurrentPermission(12);
       // Utilities.mandate(ubdateUserBTN,insertUserBTN , deleteUserBTN ,12, Utilities.convertTOBase2(permissionType));
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        type_combo = new javax.swing.JComboBox();
        building_combo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        master = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LocationTable = new javax.swing.JTable();
        done = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        assign = new javax.swing.JButton();
        slotsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SlotsTable = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Location Manual Assignment"));
        setLayout(new java.awt.GridBagLayout());

        type_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_comboActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 137;
        gridBagConstraints.ipady = 36;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 245, 0, 0);
        add(type_combo, gridBagConstraints);

        building_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        building_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                building_comboActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 133;
        gridBagConstraints.ipady = 36;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 266, 0, 0);
        add(building_combo, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Choose Location Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(135, 226, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Choose Building  ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(135, 248, 0, 0);
        add(jLabel2, gridBagConstraints);

        master.setBorder(javax.swing.BorderFactory.createTitledBorder("Locations "));
        master.setPreferredSize(new java.awt.Dimension(400, 400));

        LocationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(LocationTable);

        javax.swing.GroupLayout masterLayout = new javax.swing.GroupLayout(master);
        master.setLayout(masterLayout);
        masterLayout.setHorizontalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1102, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        masterLayout.setVerticalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipady = 506;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 139, 82, 0);
        add(master, gridBagConstraints);

        done.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        done.setText("Filter Locations");
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 139, 0, 0);
        add(done, gridBagConstraints);

        refresh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(157, 168, 0, 0);
        add(refresh, gridBagConstraints);

        assign.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assign.setText("Assign Location");
        assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 53, 0, 0);
        add(assign, gridBagConstraints);

        SlotsTable.setFont(new java.awt.Font("Tekton Pro Cond", 1, 24)); // NOI18N
        SlotsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Slot1", "slot2", "slot4", "slot4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SlotsTable.setRowHeight(40);
        jScrollPane2.setViewportView(SlotsTable);

        javax.swing.GroupLayout slotsPanelLayout = new javax.swing.GroupLayout(slotsPanel);
        slotsPanel.setLayout(slotsPanelLayout);
        slotsPanelLayout.setHorizontalGroup(
            slotsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, slotsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addContainerGap())
        );
        slotsPanelLayout.setVerticalGroup(
            slotsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, slotsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 468;
        gridBagConstraints.ipady = 503;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 116, 82, 71);
        add(slotsPanel, gridBagConstraints);
    }//GEN-END:initComponents

    private void type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_comboActionPerformed
  
    }//GEN-LAST:event_type_comboActionPerformed

    private void building_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_building_comboActionPerformed
  
    }//GEN-LAST:event_building_comboActionPerformed

    private void doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneActionPerformed
    try {
         //To check if the user selected an item or not 
        // if so, filtered list of location will be returned based on location type & building
    if(building_combo.getSelectedItem() != null && type_combo.getSelectedItem() != null)
        setTableModel(Locationbusiness.filterLocations(type_combo.getSelectedItem().toString(),building_combo.getSelectedItem().toString()));
       
    else {
         // if the user didn't select any thing , list of all locations will be returned   
        setTableModel(Locationbusiness.ListAll());}      
    } 
        
       catch(java.lang.NullPointerException e){
            JOptionPane.showMessageDialog(this, "This location isn't existed ");    
        }
        catch (Exception e) {
            // TODO: Add catch code
                e.printStackTrace();
            } 
       
    }//GEN-LAST:event_doneActionPerformed
   
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       setTableModel(Locationbusiness.ListAll());
        slotsPanel.setVisible(false);
    }//GEN-LAST:event_refreshActionPerformed

    private void assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignActionPerformed
     //To get the filtered location list
     List <LocationDto> RoomList = Locationbusiness.filterLocations(type_combo.getSelectedItem().toString(),building_combo.getSelectedItem().toString()); 
      
      //before assign, check if filtered list isn't empty& location was selected
      if(LocationTable.getSelectedRow()>=0 && RoomList != null){
          slotsPanel.setVisible(true);   
       //   if(SlotsTable.getSelectedRow()>=0){
      //  int row = SlotsTable.getSelectedRow();
     //   int column = SlotsTable.getSelectedColumn();
     //   SlotDto assignedSlot = (SlotDto)SlotsTable.getValueAt(row, column);
          LocationDto chosenRoom = new LocationDto();
          chosenRoom= RoomList.get(LocationTable.getSelectedRow());
    //    chosenRoom.setAssignedSlot(assignedSlot);
          System.out.println(chosenRoom.getLocation_id());
      //  Locationbusiness.saveLocationSlot(chosenRoom); }
    } 
      else {
         
          JOptionPane.showMessageDialog(this, "Please, filter locations first and select one\n"+"Then, Assign.");     
      }
    }//GEN-LAST:event_assignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LocationTable;
    private javax.swing.JTable SlotsTable;
    private javax.swing.JButton assign;
    private javax.swing.JComboBox building_combo;
    private javax.swing.JButton done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel master;
    private javax.swing.JButton refresh;
    private javax.swing.JPanel slotsPanel;
    private javax.swing.JComboBox type_combo;
    // End of variables declaration//GEN-END:variables



    public void Table2Reset(List<SlotDto> slots) 
    {  int index = 0 ;

        Object[][] sArray = new Object[5][5];
        //======
        sArray[0][0] = "Sunday";
        sArray[1][0] = "Monday";
        sArray[2][0] = "Tuesday";
        sArray[3][0] = "Wednesday";
        sArray[4][0] = "Thursday";
        //======
        
        
        for (int i = 0; i<5;i++)
        {  
           
          for(int k=1; k<6; k++)
          {  
               sArray[i][k] = slots.get(index).getSlot_id();
               index++;
           }
        }
        SlotsTable.setModel(new javax.swing.table.DefaultTableModel(sArray, new String[]
        {"Day" ,"Slot 1" ,"Slot 2" ,"Slot 3" ,"Slot 4" }));
    }
    
   
    
      
    
}
