
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.BuildingBao;
import com.fym.lta.bao.FloorBao;
import com.fym.lta.bao.LocationBao;
import com.fym.lta.bao.LocationTypeBao;
import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.FloorDto;
import com.fym.lta.dto.LocationDto;

import com.fym.lta.dto.LocationTypeDto;

import java.awt.BorderLayout;

import java.util.List;

import javax.persistence.Table;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Nada
 */
public class LocationMasterScreen extends javax.swing.JPanel {
    private LocationBao Locationbusiness  = new BaoFactory().createLocationBao();
    private int Location_idUpdate ;

   // public int getLocation_idUpdate() {
   //  return Location_idUpdate;
    //}
    private String codeUpdate = " ";
    private String descUpdate = " ";
   // private int capacityUpdate = 0 ;
    
    
   // public void setLocationId(int Location_idUpdate) {
   //  this.Location_idUpdate = Location_idUpdate;
  //  }

    public void setLocationUpdateCode(String codeUpdate) {
     this.codeUpdate = codeUpdate ;  
     }
    public void setLocationUpdateDesc(String descUpdate) {
     this.descUpdate = descUpdate ;  
     }
  //  public void setLocationUpdateCap(int capacityUpdate) {
  //   this.capacityUpdate = capacityUpdate ;  
   //  }
      
    private void setTableModel(List<LocationDto> location  ){
        Object [][] locationArr = new Object [location.size()][4];
        
        for(int i =0;i<location.size();i++){
            locationArr[i][0] = location.get(i).getLocation_id();
            locationArr[i][1] = location.get(i).getCode();
            locationArr[i][2] = location.get(i).getDescription();
            locationArr[i][3] = location.get(i).getCapacity();
            locationArr[i][4] = location.get(i).getBuilding().getCode();
            locationArr[i][5] = location.get(i).getFloor().getCode();
            locationArr[i][6] = location.get(i).getType().getCode();
          
            
           
        }
        Table.setModel(new javax.swing.table.DefaultTableModel(locationArr,
            new String [] {
                "Location Id", "Location Code" , "Description", "capacity" ,"Building", "Floor","Location Type"
            }
        ));   }  
   
    /** Creates new form MasterScreen */
    public LocationMasterScreen() {
        initComponents();
       
        define_location.setVisible(false);
        
      if(Locationbusiness.ListAll()!=null)
      setTableModel(Locationbusiness.ListAll());
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
        Table = new javax.swing.JTable();
        insert = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        define_location = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
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

        setBorder(javax.swing.BorderFactory.createTitledBorder("Location Master Screen"));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setLayout(new java.awt.GridBagLayout());

        master.setBorder(javax.swing.BorderFactory.createTitledBorder("Locations "));
        master.setPreferredSize(new java.awt.Dimension(400, 400));

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout masterLayout = new javax.swing.GroupLayout(master);
        master.setLayout(masterLayout);
        masterLayout.setHorizontalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );
        masterLayout.setVerticalGroup(
            masterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 926;
        gridBagConstraints.ipady = 275;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(46, 55, 57, 0);
        add(master, gridBagConstraints);

        insert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        insert.setText("Insert New Location ");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(85, 128, 0, 0);
        add(insert, gridBagConstraints);

        delete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delete.setText("Delete Location ");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 31;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(85, 148, 0, 0);
        add(delete, gridBagConstraints);

        update.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        update.setText("Update Location ");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.ipady = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(85, 85, 0, 0);
        add(update, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 385;
        gridBagConstraints.ipady = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(139, 171, 0, 0);
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
        gridBagConstraints.insets = new java.awt.Insets(132, 109, 0, 0);
        add(search, gridBagConstraints);

        define_location.setBorder(javax.swing.BorderFactory.createTitledBorder("Define Location"));
        define_location.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Location Contains:"));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setText("Air Condition");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox2.setText("Data Show");

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox3.setText("White Board");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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
        building_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Civil Building", "Electrical Building ", "Architecture Building", " " }));
        building_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                building_comboActionPerformed(evt);
            }
        });

        floor_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        floor_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1st Floor ", "2nd Floor ", "3rd Floor ", "4th Floor" }));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Choose Building ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Choose Floor ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Location Type ");

        type_combo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Class", "Hall", "Lab", "" }));
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, define_locationLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(floor_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );
        define_locationLayout.setVerticalGroup(
            define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(define_locationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(floor_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(building_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(define_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(define_locationLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(define_locationLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 72, 57, 101);
        add(define_location, gridBagConstraints);
    }//GEN-END:initComponents

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed

      define_location.setVisible(true); 

   // UsersScreen.createPopupMenu(new DefineLocation());    

    }//GEN-LAST:event_insertActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
    try {
       
        if (jTextField1.getText()!= null)
        setTableModel(Locationbusiness.searchLocation(jTextField1.getText()));
        else 
        setTableModel(Locationbusiness.ListAll()); 
        
    } catch (Exception e) {
        // TODO: Add catch code
        e.printStackTrace();
    }   
    }//GEN-LAST:event_searchActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
    try{
        int LocationIndex = Integer.parseInt(Table.getValueAt(Table.getSelectedRow(), 0).toString());
        LocationDto selected_Location = new LocationDto(); // selected Location, To delete.
        selected_Location.setLocation_id(LocationIndex); 
        if (Locationbusiness.deleteLocation(selected_Location)) {  //if returned true, location will be deleted
            JOptionPane.showMessageDialog(this, "Location is Deleted Successfully");
                setTableModel(Locationbusiness.ListAll()); 
                Table.repaint() ;
            }else
            JOptionPane.showMessageDialog(this, "Error occured");
            
            } //catch(java.lang.NumberFormatException e){
          //  JOptionPane.showMessageDialog(this, "Error occured, There is an Error in data Or Some Of Data is Missed !");  
         //   }
            catch(Exception e){
            e.printStackTrace();
            }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
   if (Table.getSelectedRow()>=0)
   {     try{
            //   Location_idUpdate = 1;
             id.setText(Table.getValueAt(Table.getSelectedRow(), 0).toString());
             code.setText(Table.getValueAt(Table.getSelectedRow(), 1).toString());
             desc.setText(Table.getValueAt(Table.getSelectedRow(), 2).toString());
             capacity.setText(Table.getValueAt(Table.getSelectedRow(), 3).toString());
             building_combo.setSelectedIndex(Integer.parseInt(Table.getValueAt(Table.getSelectedRow(),4).toString()));
             floor_combo.setSelectedIndex(Integer.parseInt(Table.getValueAt(Table.getSelectedRow(), 5).toString()));
             type_combo.setSelectedItem(Integer.parseInt(Table.getValueAt(Table.getSelectedRow(),6).toString()));
             define_location.setVisible(true);
               Location_idUpdate = 1;
             //  DefineLocation define_update  = new DefineLocation();
             //  define_update.setLocationId(Integer.parseInt(Table.getValueAt(Table.getSelectedRow(), 0).toString())); //Passa ID
            //   define_update.setLocationUpdateCode(Table.getValueAt(Table.getSelectedRow(), 1).toString()); // pass code
             //  define_update.setLocationUpdateDesc(Table.getValueAt(Table.getSelectedRow(), 2).toString()); // pass description
            //   define_update.setLocationUpdateCap(Integer.parseInt(Table.getValueAt(Table.getSelectedRow(), 3).toString())); // pass capacity
             //  UsersScreen.createPopupMenu(define_update);

              
               
     //   DefineLocation define_update  = new DefineLocation();
     //   createPopupMenu(define_update);
      //   setTableModel(Locationbusiness.ListAll());
       //  Table.repaint();
         
          
           }catch(Exception e){
               e.printStackTrace();
      }
     }
   else JOptionPane.showMessageDialog(this, " you should select a location ");
   
    }//GEN-LAST:event_updateActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try{ 
            //To get values from comboBox
            String floor =  floor_combo.getSelectedItem().toString();
            String type =  type_combo.getSelectedItem().toString();
            String building = building_combo.getSelectedItem().toString();
            //To insert location Data
            BuildingDto BuildingObject = new BuildingDto();
            FloorDto FloorObject = new FloorDto();
            LocationTypeDto LocationTypeObject = new LocationTypeDto();
            
            LocationDto LocationObject = new LocationDto();
            LocationObject.setLocation_id(Integer.parseInt(id.getText()));
            LocationObject.setCode(code.getText());
            LocationObject.setCapacity(Integer.parseInt(capacity.getText()));
            LocationObject.setDescription(desc.getText());
            LocationObject.setFloor(new FloorDto (floor_combo.getSelectedIndex()));
            LocationObject.setType(new LocationTypeDto(type_combo.getSelectedIndex()));
            LocationObject.setBuilding(new BuildingDto(building_combo.getSelectedIndex()));
             FloorObject.setCode(floor);
             LocationTypeObject.setCode(type);
            BuildingObject.setCode(building);
        
           
            
            if(Location_idUpdate!=0)
            {
                //   LocationObject.setLocation_id(this.getLocation_idUpdate());
                if(Locationbusiness.updateLocation(LocationObject)) {
                    JOptionPane.showMessageDialog(this, "Location Updated Successfully");
                    setTableModel(Locationbusiness.ListAll());
                    Table.repaint();  }
                else
                JOptionPane.showMessageDialog(this, "Error occured update");}
            else
            {    if( Locationbusiness.insertLocation(LocationObject)){
                JOptionPane.showMessageDialog(this, "Location Saved Successfully");
                setTableModel(Locationbusiness.ListAll());
                Table.repaint();
            }else
            JOptionPane.showMessageDialog(this, "Error occured");
        }

        } //catch(java.lang.NumberFormatException e){
           // JOptionPane.showMessageDialog(this, "Error occured, There is an Error in data Or Some Of Data is Missed !");
       // }
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JComboBox building_combo;
    private javax.swing.JTextField capacity;
    private javax.swing.JTextField code;
    private javax.swing.JPanel define_location;
    private javax.swing.JButton delete;
    private javax.swing.JTextField desc;
    private javax.swing.JComboBox floor_combo;
    private javax.swing.JTextField id;
    private javax.swing.JButton insert;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel master;
    private javax.swing.JButton save;
    private javax.swing.JButton search;
    private javax.swing.JComboBox type_combo;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}
