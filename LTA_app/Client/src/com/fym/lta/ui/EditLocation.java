
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.LocationBao;
import com.fym.lta.dto.LocationDto;

import java.util.List;

/**
 *
 * @author Nada
 */
public class EditLocation extends javax.swing.JPanel {
    private LocationBao business;
    private void setTableModel(List<LocationDto> location){
        Object [][] locationArr = new Object [location.size()][4];
        for(int i =0;i<location.size();i++){
            locationArr[i][0] = location.get(i).getLocation_id();
            locationArr[i][1] = location.get(i).getCode();
            locationArr[i][2] = location.get(i).getDescription();
            locationArr[i][3] = location.get(i).getCapacity();
           
        }
        LocationTable.setModel(new javax.swing.table.DefaultTableModel(locationArr,
            new String [] {
                "Location Id", "Location Code" , "Description","capacity"
            }
        ));    
    }

    /** Creates new form EditLocation */
    public EditLocation() {
        try {
            business = new BaoFactory().createLocationBao();
            initComponents();
        
            setTableModel(business.ListAll());            
            
        } catch (Exception e) {
            // TODO: Add catch code
            e.printStackTrace();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new javax.swing.JScrollPane();
        LocationTable = new javax.swing.JTable();
        update = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Location"));

        LocationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Code", "Description", "Capacity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        LocationTable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                LocationTableComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(LocationTable);

        update.setText("Update ");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(update)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(update))
        );
    }//GEN-END:initComponents

    private void LocationTableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_LocationTableComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_LocationTableComponentAdded

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
  //  try{
  //  LocationDto L = new LocationDto();
   // L.setLocation_id(Integer.parseInt( locationArr[i][0].getText()));
  //  L.setCode(code.getText());
  //  L.setCapacity(Integer.parseInt(capacity.getText()));
   // L.setDescription(desc.getText()); 
     //   if( buisness. saveLocation(L)){
      //      JOptionPane.showMessageDialog(this, "Location Saved Successfully");
       //           }else
          // JOptionPane.showMessageDialog(this, "Error occured");
        
        //  }catch(Exception e){
       //        e.printStackTrace();
  //  }
    }//GEN-LAST:event_updateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable LocationTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}
