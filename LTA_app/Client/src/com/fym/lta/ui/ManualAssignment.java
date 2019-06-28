
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.LocationBao;
import com.fym.lta.bao.SchedualBao;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.DepartmentDto;
import com.fym.lta.dto.LocationDto;
import com.fym.lta.dto.LocationTypeDto;
import com.fym.lta.dto.SchedualDto;
import com.fym.lta.dto.SlotDto;

import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Nada
 */
public class ManualAssignment extends javax.swing.JPanel {
    
    //To create a refrence from LocationBao 
    private LocationBao Locationbusiness  = new BaoFactory().createLocationBao();
    private SchedualBao Schedulebuisness = new BaoFactory().createSchedualBao();
    LocationDto chosenRoom = new LocationDto();
    SchedualDto Chosenschedule = new SchedualDto();
    
    //To Get list of building , location type to set comboBox items 
    List<BuildingDto> Allbuildings = new BaoFactory().createBuildingBao().listBuilding();
    List<LocationTypeDto> AlllocationTypes = new BaoFactory().createLocationTypeBao().listLocationType(); 
    List<DepartmentDto> DepartmentsList = new BaoFactory().createDepartmentBao().listDepartment();
  
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
    
    void listComboDepartments(List<DepartmentDto> department) {
       for (int i = 0; i < department.size(); i++) {
           department_combo.addItem(department.get(i).getCode());
                 }
    }
    
    void listComboSchedules(List<SchedualDto> schedule) {
      for (int i = 0; i < schedule.size(); i++) { 
         schedule_combo.addItem(schedule.get(i).getSCHEDULECODE());
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
            listComboDepartments(DepartmentsList);
            slotsPanel.setVisible(false);
         
            
        } catch (Exception e) {
           
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

        type_combo = new javax.swing.JComboBox();
        building_combo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        master = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LocationTable = new javax.swing.JTable();
        done = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        slotsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SlotsTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        schedule_combo = new javax.swing.JComboBox();
        department_combo = new javax.swing.JComboBox();
        view = new javax.swing.JButton();
        show = new javax.swing.JButton();
        assign = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        type_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_comboActionPerformed(evt);
            }
        });
        add(type_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 140, 30));

        building_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        building_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                building_comboActionPerformed(evt);
            }
        });
        add(building_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 156, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose Location Type");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choose Building  ");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 166, 30));

        master.setBackground(new java.awt.Color(0, 0, 0));
        master.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Locations ", 0, 0, new java.awt.Font("Tekton Pro", 1, 36))); // NOI18N
        master.setPreferredSize(new java.awt.Dimension(400, 400));

        LocationTable.setBackground(new java.awt.Color(51, 98, 114));
        LocationTable.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
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
        LocationTable.setSelectionBackground(new java.awt.Color(22, 224, 236));
        jScrollPane1.setViewportView(LocationTable);

        javax.swing.GroupLayout masterLayout = new javax.swing.GroupLayout(master);
        master.setLayout(masterLayout);
        masterLayout.setHorizontalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );
        masterLayout.setVerticalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );

        add(master, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 540, 480));

        done.setBackground(new java.awt.Color(0, 0, 0));
        done.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        done.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\filter.png")); // NOI18N
        done.setBorderPainted(false);
        done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneActionPerformed(evt);
            }
        });
        add(done, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 160, 50));

        refresh.setBackground(new java.awt.Color(0, 0, 0));
        refresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refresh.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\refershBTN.png")); // NOI18N
        refresh.setBorderPainted(false);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 40, 40));

        slotsPanel.setBackground(new java.awt.Color(51, 98, 114));
        slotsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SlotsTable.setBackground(new java.awt.Color(51, 98, 114));
        SlotsTable.setFont(new java.awt.Font("Tekton Pro Cond", 1, 18)); // NOI18N
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
        SlotsTable.setSelectionBackground(new java.awt.Color(22, 224, 236));
        jScrollPane2.setViewportView(SlotsTable);

        slotsPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 91, 710, 360));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Choose Schedule");
        slotsPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 123, 22));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Choose Department");
        slotsPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        schedule_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schedule_comboActionPerformed(evt);
            }
        });
        slotsPanel.add(schedule_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 117, 33));

        department_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                department_comboActionPerformed(evt);
            }
        });
        slotsPanel.add(department_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 104, 33));

        view.setBackground(new java.awt.Color(0, 0, 0));
        view.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\view.png")); // NOI18N
        view.setBorderPainted(false);
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        slotsPanel.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 130, 30));

        add(slotsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 730, 460));

        show.setBackground(new java.awt.Color(0, 0, 0));
        show.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        show.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\show.png")); // NOI18N
        show.setBorderPainted(false);
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 130, 40));

        assign.setBackground(new java.awt.Color(0, 0, 0));
        assign.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        assign.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\assign.png")); // NOI18N
        assign.setBorderPainted(false);
        assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignActionPerformed(evt);
            }
        });
        add(assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 640, 80, 40));
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
    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
     //To get the filtered location list
     List <LocationDto> RoomList = Locationbusiness.filterLocations(type_combo.getSelectedItem().toString(),building_combo.getSelectedItem().toString()); 
      //before assign, check if filtered list isn't empty& location was selected
      if(LocationTable.getSelectedRow()>=0 && RoomList != null){
                slotsPanel.setVisible(true);   
                chosenRoom= RoomList.get(LocationTable.getSelectedRow());
                System.out.println(chosenRoom.getLocation_id());}
      else {
          JOptionPane.showMessageDialog(this, "Please, filter locations first and select one\n"+"Then, Assign.");     
      }
    }//GEN-LAST:event_showActionPerformed

    private void schedule_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schedule_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schedule_comboActionPerformed

    private void department_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_department_comboActionPerformed
     schedule_combo.removeAllItems();
         DepartmentDto SelectedDepartment = new DepartmentDto();
         SelectedDepartment.setCode(DepartmentsList.get(department_combo.getSelectedIndex()).getCode());     
     List<SchedualDto> SchedulesList = Schedulebuisness.listSchedual_inDeparts(SelectedDepartment.getCode()); 
      if(SchedulesList != null){
         listComboSchedules(SchedulesList);}
 
    }//GEN-LAST:event_department_comboActionPerformed
    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
            if (department_combo.getSelectedItem() != null && schedule_combo.getSelectedItem() != null) {
              Chosenschedule = Schedulebuisness.getSlectedTable(schedule_combo.getSelectedItem().toString());
             Utilities.schResetModel(SlotsTable, Chosenschedule.getSchedual_Slots());  
         }
         else{
           JOptionPane.showMessageDialog(this, " select department and schedule to view"); }
        
    }//GEN-LAST:event_viewActionPerformed

    private void assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignActionPerformed
        try{      if(SlotsTable.getSelectedRow()>=0){
             int row = SlotsTable.getSelectedRow();
             int column = SlotsTable.getSelectedColumn();
             SlotDto assignedSlot = new SlotDto();
             SlotDto[][] SlotArray = new SlotDto[25][5];
             List<SlotDto> slots = Chosenschedule.getSchedual_Slots(); 
              int i ;
             for ( i = 0; i< slots.size();i++ ){
                 if (slots.get(i).getCode() == 1){
                          SlotArray[0][1]= slots.get(i);
                          SlotArray[1][1] = slots.get(i);
                          SlotArray[2][1] = slots.get(i); 
                          SlotArray[3][1] = slots.get(i);
                          SlotArray[4][1] = slots.get(i);}   
                 if (slots.get(i).getCode() ==2 ){
                          SlotArray[0][2]= slots.get(i);
                          SlotArray[1][2]= slots.get(i);
                          SlotArray[2][2]= slots.get(i);
                          SlotArray[3][2]= slots.get(i);
                          SlotArray[4][2] = slots.get(i);}
                 if (slots.get(i).getCode() == 3){
                          SlotArray[0][3]= slots.get(i);
                          SlotArray[1][3]= slots.get(i);
                          SlotArray[2][3]= slots.get(i);
                          SlotArray[3][3]= slots.get(i);
                          SlotArray[4][3] = slots.get(i);}
                 if (slots.get(i).getCode() == 4){
                          SlotArray[0][4]= slots.get(i);
                          SlotArray[1][4]= slots.get(i);
                          SlotArray[2][4]= slots.get(i);
                          SlotArray[3][4]= slots.get(i);
                          SlotArray[4][4] = slots.get(i);}
                 if (slots.get(i).getCode() == 5){
                          SlotArray[5][1]= slots.get(i);
                          SlotArray[6][1]= slots.get(i);
                          SlotArray[7][1]= slots.get(i);
                          SlotArray[8][1]= slots.get(i);
                          SlotArray[9][1] = slots.get(i);}
                 if (slots.get(i).getCode() == 6){
                          SlotArray[5][2]= slots.get(i);
                          SlotArray[6][2]= slots.get(i);
                          SlotArray[7][2]= slots.get(i);
                          SlotArray[8][2]= slots.get(i);
                          SlotArray[9][2] = slots.get(i);}
                 if (slots.get(i).getCode() == 7){
                          SlotArray[5][3]= slots.get(i);
                          SlotArray[6][3]= slots.get(i);
                          SlotArray[7][3]= slots.get(i);
                          SlotArray[8][3]= slots.get(i);
                          SlotArray[9][3] = slots.get(i);}
                 if (slots.get(i).getCode() == 8){
                          SlotArray[5][4]= slots.get(i);
                          SlotArray[6][4]= slots.get(i);
                          SlotArray[7][4]= slots.get(i);
                          SlotArray[8][4]= slots.get(i);
                          SlotArray[9][4] = slots.get(i);}
                     if (slots.get(i).getCode() == 9){
                     SlotArray[10][1]= slots.get(i);
                     SlotArray[11][1]= slots.get(i);
                     SlotArray[12][1]= slots.get(i);
                     SlotArray[13][1]= slots.get(i);
                     SlotArray[14][1]= slots.get(i);}
                 
                    if (slots.get(i).getCode() == 10){
                   SlotArray[10][2]= slots.get(i);
                   SlotArray[11][2]= slots.get(i);
                   SlotArray[12][2]= slots.get(i);
                   SlotArray[13][2]= slots.get(i);
                   SlotArray[14][2]= slots.get(i);}

                   if (slots.get(i).getCode() == 11){
                              SlotArray[10][3]= slots.get(i);
                              SlotArray[11][3]= slots.get(i);
                              SlotArray[12][3]= slots.get(i);
                              SlotArray[13][3]= slots.get(i);
                              SlotArray[14][3]= slots.get(i);}
                          
                   if (slots.get(i).getCode() == 12){
                     SlotArray[10][4]= slots.get(i);
                     SlotArray[11][4]= slots.get(i);
                     SlotArray[12][4]= slots.get(i);
                     SlotArray[13][4]= slots.get(i);
                     SlotArray[14][4]= slots.get(i);}
                 if (slots.get(i).getCode() == 13){
                   SlotArray[15][1]= slots.get(i);
                   SlotArray[16][1]= slots.get(i);
                   SlotArray[17][1]= slots.get(i);
                   SlotArray[18][1]= slots.get(i);
                   SlotArray[19][1]= slots.get(i);}
                 if (slots.get(i).getCode() == 14){
                   SlotArray[15][2]= slots.get(i);
                  SlotArray[16][2]= slots.get(i);
                   SlotArray[17][2]= slots.get(i);
                   SlotArray[18][2]= slots.get(i);
                   SlotArray[19][2]= slots.get(i);}
                 if (slots.get(i).getCode() == 15){
                   SlotArray[15][3]= slots.get(i);
                   SlotArray[16][3]= slots.get(i);
                   SlotArray[17][3]= slots.get(i);
                   SlotArray[18][3]= slots.get(i);
                   SlotArray[19][3]= slots.get(i);}
                 if (slots.get(i).getCode() == 16){
                   SlotArray[15][4]= slots.get(i);
                   SlotArray[16][4]= slots.get(i);
                   SlotArray[17][4]= slots.get(i);
                   SlotArray[18][4]= slots.get(i);
                   SlotArray[19][4]= slots.get(i);}
                 if (slots.get(i).getCode() == 17){
                   SlotArray[20][1]= slots.get(i);
                   SlotArray[21][1]= slots.get(i);
                   SlotArray[22][1]= slots.get(i);
                   SlotArray[23][1]= slots.get(i);
                   SlotArray[24][1]= slots.get(i);}
                 if (slots.get(i).getCode() == 18){
                   SlotArray[20][2]= slots.get(i);
                   SlotArray[21][2]= slots.get(i);
                   SlotArray[22][2]= slots.get(i);
                   SlotArray[23][2]= slots.get(i);
                   SlotArray[24][2]= slots.get(i);}
                 if (slots.get(i).getCode() == 19){
                   SlotArray[20][3]= slots.get(i);
                   SlotArray[21][3]= slots.get(i);
                   SlotArray[22][3]= slots.get(i);
                   SlotArray[23][3]= slots.get(i);
                   SlotArray[24][3]= slots.get(i);}
                 
                 if (slots.get(i).getCode() == 20){
                   SlotArray[20][4]= slots.get(i);
                   SlotArray[21][4]= slots.get(i);
                   SlotArray[22][4]= slots.get(i);
                   SlotArray[23][4]= slots.get(i);
                   SlotArray[24][4]= slots.get(i);}
             }  
               assignedSlot = SlotArray [row][column];    
               System.out.println(assignedSlot.getCode());
                if(assignedSlot != null){    
                   chosenRoom.setAssignedSlot(assignedSlot);
                   Locationbusiness.saveLocationSlot(chosenRoom); 
                  JOptionPane.showMessageDialog(this, "Location assigned Successfully");}
      }  
     else{
         JOptionPane.showMessageDialog(this,"please, select a slot first ");
     }}
        catch(java.lang.NullPointerException ex){
            JOptionPane.showMessageDialog(this,"please, select a specific slot, Not a Day! ");
        }
     
    }//GEN-LAST:event_assignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LocationTable;
    private javax.swing.JTable SlotsTable;
    private javax.swing.JButton assign;
    private javax.swing.JComboBox building_combo;
    private javax.swing.JComboBox department_combo;
    private javax.swing.JButton done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel master;
    private javax.swing.JButton refresh;
    private javax.swing.JComboBox schedule_combo;
    private javax.swing.JButton show;
    private javax.swing.JPanel slotsPanel;
    private javax.swing.JComboBox type_combo;
    private javax.swing.JButton view;
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
