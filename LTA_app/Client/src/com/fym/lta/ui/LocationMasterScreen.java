
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.BuildingBao;
import com.fym.lta.bao.EquipmentBao;
import com.fym.lta.bao.FloorBao;
import com.fym.lta.bao.LocationBao;
import com.fym.lta.bao.LocationTypeBao;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.EquipmentDto;
import com.fym.lta.dto.FloorDto;
import com.fym.lta.dto.LocationDto;

import com.fym.lta.dto.LocationTypeDto;

import com.fym.lta.dto.RoleDto;

import com.fym.lta.dto.ScreenDto;

import java.awt.BorderLayout;

import java.awt.Checkbox;

import java.awt.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nada
 */
public class LocationMasterScreen extends javax.swing.JPanel {
    
    //To create a refrence from LocationBao , EquipmentBao 
    private LocationBao Locationbusiness  = new BaoFactory().createLocationBao();
    private EquipmentBao Equipmentbuisness = new BaoFactory().createEquipmentBao();
    
    // flag , if it equals 1 we update, if zero we insert  
    private int Location_idUpdate ;
   
    //To Get list of building , floor , location type to set comboBox items 
    List<BuildingDto> Allbuildings = new BaoFactory().createBuildingBao().listBuilding();
    List<FloorDto> Allfloors = new BaoFactory().createFloorBao().listFloor();
    List<LocationTypeDto> AlllocationTypes = new BaoFactory().createLocationTypeBao().listLocationType();
    List<EquipmentDto> AllEquipments = new BaoFactory().createEquipmentBao().ListAll();


        //To add comboBox items//
    // We get a list of saved items in Database//
     void listComboBuildings(List<BuildingDto> building) {
           for (int i = 0; i < building.size(); i++) {
               building_combo.addItem(building.get(i).getCode());
                     }
    }
     
    void listComboFloors(List<FloorDto> floor) {
          for (int i = 0; i < floor.size(); i++) {
             floor_combo.addItem(floor.get(i).getCode());
                    }
    }
    
    void listComboLocationTypes(List<LocationTypeDto> LocationType) {
          for (int i = 0; i < LocationType.size(); i++) {
             type_combo.addItem(LocationType.get(i).getCode());
                    }
    }
    
    void listEquipments(List<EquipmentDto> Equipment) {
        DefaultListModel list = new DefaultListModel();
          for (int i = 0; i < Equipment.size(); i++) {
                 list.addElement(Equipment.get(i).getCode());  
                    }
          EquipmentList.setModel(list);
    }
      
    // To Set the retrieved data from database into the locationTable//  
    private void setTableModel(List<LocationDto> location  ){
        Object [][] locationArr = new Object [location.size()][12];
        for(int i =0;i<location.size();i++){
            locationArr[i][0] = location.get(i).getLocation_id();
            locationArr[i][1] = location.get(i).getCode();
            locationArr[i][2] = location.get(i).getDescription();
            locationArr[i][3] = location.get(i).getCapacity();
            locationArr[i][4] = location.get(i).getStatus();
            locationArr[i][5] = location.get(i).getBuilding().getCode();
            locationArr[i][6] = location.get(i).getFloor().getCode();
            locationArr[i][7] = location.get(i).getType().getCode();
            locationArr[i][8] = location.get(i).getInsertedBy();
            locationArr[i][9] = location.get(i).getInertion_Date();
            locationArr[i][10] = location.get(i).getUpdatedBy();
            locationArr[i][11] = location.get(i).getUpdate_Date();  }    
        
        LocationTable.setModel(new javax.swing.table.DefaultTableModel(locationArr,
            new String [] {
                "Location Id", "Location Code" , "Description", "capacity" ,"Location Status","Building", "Floor","Location Type" , "Inserted By","Insertion Date","Updated By","Update Date"
            }
        ));   }  
    
    
   
    /** Creates new form MasterScreen */
    public LocationMasterScreen() {
        initComponents();
      if(Locationbusiness.ListAll()!=null)
      setTableModel(Locationbusiness.ListAll());
        listComboBuildings(Allbuildings);
        listComboFloors(Allfloors);
        listComboLocationTypes(AlllocationTypes);
        listEquipments(AllEquipments);
        define_location.setVisible(false);
        
        // roleID = 12
        // now one step we will create an object of ScreenBao to know the current permission 
        String permissionType = new BaoFactory().createScreenBao().getCurrentPermission(12);
        Utilities.mandate(updateLocationBtn, insertLocationBtn , deleteLocationBtn ,12,permissionType);

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
        LocationTable = new javax.swing.JTable();
        insertLocationBtn = new javax.swing.JButton();
        deleteLocationBtn = new javax.swing.JButton();
        updateLocationBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        define_location = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        EquipmentList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        desc = new javax.swing.JTextField();
        capacity = new javax.swing.JTextField();
        building_combo = new javax.swing.JComboBox();
        floor_combo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        type_combo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Location Master Screen"));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setLayout(new java.awt.GridBagLayout());

        master.setBorder(javax.swing.BorderFactory.createTitledBorder("Locations "));
        master.setPreferredSize(new java.awt.Dimension(400, 400));

        LocationTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(LocationTable);

        javax.swing.GroupLayout masterLayout = new javax.swing.GroupLayout(master);
        master.setLayout(masterLayout);
        masterLayout.setHorizontalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
        );
        masterLayout.setVerticalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 1058;
        gridBagConstraints.ipady = 418;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 61, 28, 0);
        add(master, gridBagConstraints);

        insertLocationBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insertLocationBtn.setText("Insert New Location ");
        insertLocationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertLocationBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 160, 0, 0);
        add(insertLocationBtn, gridBagConstraints);

        deleteLocationBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteLocationBtn.setText("Delete Location ");
        deleteLocationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLocationBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 188, 0, 0);
        add(deleteLocationBtn, gridBagConstraints);

        updateLocationBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        updateLocationBtn.setText("Update Location ");
        updateLocationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateLocationBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 128, 0, 0);
        add(updateLocationBtn, gridBagConstraints);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 385;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(195, 6, 0, 0);
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
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 21;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(195, 123, 0, 0);
        add(search, gridBagConstraints);

        define_location.setBorder(javax.swing.BorderFactory.createTitledBorder("Define Location"));
        define_location.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Location Contains:"));

        EquipmentList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        EquipmentList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(EquipmentList);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Code");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Description");

        save.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Capacity");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        building_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        building_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                building_comboActionPerformed(evt);
            }
        });

        floor_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Choose Building ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Choose Floor ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Location Type ");

        type_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_comboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout define_locationLayout = new javax.swing.GroupLayout(define_location);
        define_location.setLayout(define_locationLayout);
        define_locationLayout.setHorizontalGroup(
            define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(define_locationLayout.createSequentialGroup()
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(define_locationLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(define_locationLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(building_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(define_locationLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(define_locationLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(floor_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(define_locationLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        define_locationLayout.setVerticalGroup(
            define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(define_locationLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floor_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(building_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(define_locationLayout.createSequentialGroup()
                        .addGap(465, 465, 465)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(define_locationLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(desc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(188, 81, 28, 69);
        add(define_location, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Enter Location Code");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(197, 129, 0, 0);
        add(jLabel8, gridBagConstraints);
    }//GEN-END:initComponents


   

    
    private void insertLocationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertLocationBtnActionPerformed
    clearData();
    Location_idUpdate = 0;
    define_location.setVisible(true);  
    }//GEN-LAST:event_insertLocationBtnActionPerformed


    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
    try {
        define_location.setVisible(false);
        if (jTextField1.getText()!= null){
        setTableModel(Locationbusiness.searchLocation(jTextField1.getText()));
        jTextField1.setText(null);}
        else 
        setTableModel(Locationbusiness.ListAll()); 
        
    } 
    catch(java.lang.NullPointerException e){
        JOptionPane.showMessageDialog(this, "This location isn't existed ");    
    }
    catch (Exception e) {
        // TODO: Add catch code
        e.printStackTrace();
    }  
    
    }//GEN-LAST:event_searchActionPerformed

    private void deleteLocationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLocationBtnActionPerformed
    if (LocationTable.getSelectedRow() >= 0) {
          try{ 
               define_location.setVisible(false);
               int LocationIndex = Integer.parseInt(LocationTable.getValueAt(LocationTable.getSelectedRow(), 0).toString());
               LocationDto selected_Location = new LocationDto(); // selected Location, To delete.
               selected_Location.setLocation_id(LocationIndex); 
               if (Locationbusiness.deleteLocation(selected_Location)) {  //if returned true, location will be deleted
                      JOptionPane.showMessageDialog(this, "Location is Deleted Successfully");
                      setTableModel(Locationbusiness.ListAll()); 
                      LocationTable.repaint() ; }
              else
              JOptionPane.showMessageDialog(this, "Can't delete this Location ! ");         
             } 
         catch(Exception e){
            e.printStackTrace();
            }
    }
    else { // if no location is selected on the table
            JOptionPane.showMessageDialog(this, "you should select a location to delete  ");
        }
    }//GEN-LAST:event_deleteLocationBtnActionPerformed

    private void updateLocationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateLocationBtnActionPerformed
     if (LocationTable.getSelectedRow()>=0) {
         // No need to update Id, so we hide it//
            id.setVisible(false); 
            jLabel1.setVisible(false);
           try{
             id.setText(LocationTable.getValueAt(LocationTable.getSelectedRow(), 0).toString());
             code.setText(LocationTable.getValueAt(LocationTable.getSelectedRow(), 1).toString());
             desc.setText(LocationTable.getValueAt(LocationTable.getSelectedRow(), 2).toString());
             capacity.setText(LocationTable.getValueAt(LocationTable.getSelectedRow(), 3).toString());
             define_location.setVisible(true);
               // flag , if it equals 1 we update, if zero we insert  
             Location_idUpdate = 1; 
           }catch(Exception e){
               e.printStackTrace();
      }
     }
   else JOptionPane.showMessageDialog(this, " you should select a location to update ");
   
    }//GEN-LAST:event_updateLocationBtnActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
     try{ 
            //Create Dto Objects to get data from UI and then pass it to Bao//
            BuildingDto BuildingObject = new BuildingDto();
            FloorDto FloorObject = new FloorDto();
            LocationTypeDto LocationTypeObject = new LocationTypeDto();
            LocationDto LocationObject = new LocationDto();
          
            //To get data from UI//
            LocationObject.setLocation_id(Integer.parseInt(id.getText()));
            LocationObject.setCode(code.getText());
            LocationObject.setCapacity(Integer.parseInt(capacity.getText()));
            LocationObject.setDescription(desc.getText());
            LocationObject.setStatus("Not assigned");
         
            LocationObject.setLocation_equipments(EquipmentList.getSelectedValuesList());
           
           
             //To set id for building ,floor , locationType//
            BuildingObject.setBuilding_id(Allbuildings.get(building_combo.getSelectedIndex()).getBuilding_id());
            LocationObject.setBuilding(BuildingObject);
            FloorObject.setFloor_id(Allfloors.get(floor_combo.getSelectedIndex()).getFloor_id());
            LocationObject.setFloor(FloorObject);
            LocationTypeObject.setLocationType_id(AlllocationTypes.get(type_combo.getSelectedIndex()).getLocationType_id());
            LocationObject.setType(LocationTypeObject);
         
             //To Check whether to insert or update data// 
            if(Location_idUpdate!=0)
            {     
                    LocationObject.setUpdatedBy(LoginEngine.currentUser);
                    LocationObject.setUpdate_Date(new Date(System.currentTimeMillis()));
                if(Locationbusiness.updateLocation(LocationObject)) {//&&Equipmentbuisness.saveEquipment(SelectedEquipments, LocationObject)
                    JOptionPane.showMessageDialog(this, "Location Updated Successfully");
                    setTableModel(Locationbusiness.ListAll());
                    LocationTable.repaint();  }
                else
                JOptionPane.showMessageDialog(this, "Error occured in update");}
            
            else
            {    
            LocationObject.setInsertedBy(LoginEngine.currentUser);
            LocationObject.setInertion_Date(new Date(System.currentTimeMillis()));
                if( Locationbusiness.insertLocation(LocationObject)){
                JOptionPane.showMessageDialog(this, "Location Saved Successfully");
                setTableModel(Locationbusiness.ListAll());
                LocationTable.repaint();
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

    private void type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_comboActionPerformed

    private void building_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_building_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_building_comboActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList EquipmentList;
    private javax.swing.JTable LocationTable;
    private javax.swing.JComboBox building_combo;
    private javax.swing.JTextField capacity;
    private javax.swing.JTextField code;
    private javax.swing.JPanel define_location;
    private javax.swing.JButton deleteLocationBtn;
    private javax.swing.JTextField desc;
    private javax.swing.JComboBox floor_combo;
    private javax.swing.JTextField id;
    private javax.swing.JButton insertLocationBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel master;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JComboBox type_combo;
    private javax.swing.JButton updateLocationBtn;
    // End of variables declaration//GEN-END:variables
    
    // this method just to clear text and reset the valus on the insert panel
    void clearData() { // clear prvious data
        id.setText(null);
        code.setText(null);
        desc.setText(null);
        capacity.setText(null);
        
        // show hidden components again
        id.setVisible(true);
        jLabel1.setVisible(true);
    }
    
    
   
}
