
package com.fym.lta.ui;

import com.fym.lta.bao.AllocationAlgorthim;
import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.SchedualBao;
import com.fym.lta.dto.DepartmentDto;

import java.util.List;

/**
 *
 * @author H,Omar
 */
public class AutoAssignment extends javax.swing.JPanel implements Increamenter {
    
    // all departments stored in our db 
    List<DepartmentDto> allDepartments  = new BaoFactory().createDepartmentBao().listDepartment();

    SchedualBao SchedualBaoObj ;
  
   
    /** Creates new form AutoAssignment */
    public AutoAssignment() {
        initComponents();
        progressPanel.setVisible(true);
        errorsField.setVisible(true);
   
        assignBtn.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\assign.png")); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\progBar.png")); // NOI18N
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        assignBtn = new javax.swing.JButton();
        progressPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bar = new javax.swing.JProgressBar();
        reprot = new javax.swing.JLabel();
        percentage = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        errorsField = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 0, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assignBtn.setBackground(new java.awt.Color(0, 0, 0));
        assignBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        assignBtn.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\assign.png")); // NOI18N
        assignBtn.setBorderPainted(false);
        assignBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignBtnMouseClicked(evt);
            }
        });
        add(assignBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 120, 60));

        progressPanel.setBackground(new java.awt.Color(0, 0, 0));
        progressPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));
        progressPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tekton Pro Cond", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Oracle\\Middleware\\LTA\\icons\\progBar.png")); // NOI18N
        progressPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 640, 70));

        bar.setForeground(new java.awt.Color(51, 98, 114));
        progressPanel.add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 640, 30));

        reprot.setForeground(new java.awt.Color(255, 255, 255));
        progressPanel.add(reprot, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 530, 70));

        percentage.setForeground(new java.awt.Color(255, 255, 255));
        progressPanel.add(percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 30, 30));

        add(progressPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 720, 400));

        errorsField.setBackground(new java.awt.Color(0, 0, 0));
        errorsField.setColumns(20);
        errorsField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        errorsField.setForeground(new java.awt.Color(255, 0, 0));
        errorsField.setRows(20);
        errorsField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 240, 240)));
        errorsField.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(errorsField);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 720, 140));
    }//GEN-END:initComponents

    private void assignBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assi
   
     AllocationAlgorthim allocBusinees  =  new AllocationAlgorthim () ; 
     String errors =  allocBusinees.alloc_All(this) ;
     errorsField.setText(errors);
        
    }//GEN-LAST:event_assignBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn;
    private javax.swing.JProgressBar bar;
    private javax.swing.JTextArea errorsField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel percentage;
    private javax.swing.JPanel progressPanel;
    private javax.swing.JLabel reprot;
    // End of variables declaration//GEN-END:variables
    @Override
    public void increame(int num , String report ) {
        bar.setValue(num);
        bar.revalidate();
        bar.repaint();
        reprot.setText(report);
        percentage.setText( num + "%" );
        
    }
}
