
package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.CourseBao;
import com.fym.lta.bao.LoginEngine;
import com.fym.lta.dto.CourseDto;
import com.fym.lta.dto.DepartmentDto;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author Mina
 */
public class CourseScreen extends javax.swing.JPanel
{

private CourseBao courseobjBao = new BaoFactory().createCourseBao();

    boolean updateFlag = false ;
    
    

    List<DepartmentDto> allDepartments = new BaoFactory().createDepartmentBao().listDepartment();
    
    // how to get location types in combo box 
  //  List<LocationTypeDto> allLocationType = new BaoFactory().createLocationTypeBao().


    
    /** Creates new form CourseSearch */
    public CourseScreen() 

{
        initComponents();
        if (courseobjBao.listCourses()!= null)
            courseTableReset(courseobjBao.listCourses());
        
        insertPanel.setVisible(false);
        String permissionType = new BaoFactory().createScreenBao().getCurrentPermission(6);
        Utilities.mandate(updateCourseBtn,insertCourseBtn , deleteCourseBtn ,6,permissionType); 
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        btnSearch = new javax.swing.JButton();
        search_textField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        updateCourseBtn = new javax.swing.JButton();
        deleteCourseBtn = new javax.swing.JButton();
        insertCourseBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        insertPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        codelapel = new javax.swing.JLabel();
        namelapel = new javax.swing.JLabel();
        Department_ComboBox = new javax.swing.JComboBox();
        Departmentlapel = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        code_textField = new javax.swing.JTextField();
        name_textField = new javax.swing.JTextField();
        prefered_ComboBox = new javax.swing.JComboBox();
        Departmentlapel1 = new javax.swing.JLabel();
        hours_perWeak = new javax.swing.JTextField();
        namelapel1 = new javax.swing.JLabel();

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setText("Search");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Course Screen ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Course Name");

        updateCourseBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        updateCourseBtn.setText("Update");
        updateCourseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateCourseBtnMouseClicked(evt);
            }
        });

        deleteCourseBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteCourseBtn.setText("Delete");
        deleteCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCourseBtnActionPerformed(evt);
            }
        });

        insertCourseBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        insertCourseBtn.setText("Insert New Course");
        insertCourseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertCourseBtnMouseClicked(evt);
            }
        });

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Code", "Lecture Time ", "Department", "preferred location type"
            }
        ));
        courseTable.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                courseTableAncestorResized(evt);
            }
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
        });
        jScrollPane1.setViewportView(courseTable);
        courseTable.getColumnModel().getColumn(0).setHeaderValue("Name");
        courseTable.getColumnModel().getColumn(1).setHeaderValue("Code");
        courseTable.getColumnModel().getColumn(2).setHeaderValue("Lecture Time ");
        courseTable.getColumnModel().getColumn(3).setHeaderValue("Department");
        courseTable.getColumnModel().getColumn(4).setHeaderValue("preferred location type");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(updateCourseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(deleteCourseBtn)
                .addGap(44, 44, 44)
                .addComponent(insertCourseBtn)
                .addGap(103, 103, 103))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateCourseBtn)
                    .addComponent(deleteCourseBtn)
                    .addComponent(insertCourseBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Course Insert");

        codelapel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        codelapel.setText("Code");

        namelapel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        namelapel.setText("Name");

        Department_ComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Department_ComboBox.addItem("One period");
        Department_ComboBox.addItem("Two period");

        Departmentlapel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Departmentlapel.setText("Department ");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        prefered_ComboBox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        prefered_ComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hall", "Lab", "Small Room" }));
        Department_ComboBox.addItem("One period");
        Department_ComboBox.addItem("Two period");

        Departmentlapel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Departmentlapel1.setText("pref_Space");

        namelapel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        namelapel1.setText("Hours per Week");

        javax.swing.GroupLayout insertPanelLayout = new javax.swing.GroupLayout(insertPanel);
        insertPanel.setLayout(insertPanelLayout);
        insertPanelLayout.setHorizontalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, insertPanelLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, insertPanelLayout.createSequentialGroup()
                        .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(insertPanelLayout.createSequentialGroup()
                                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codelapel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namelapel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namelapel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(code_textField)
                                    .addComponent(name_textField)
                                    .addComponent(hours_perWeak)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, insertPanelLayout.createSequentialGroup()
                                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Departmentlapel1)
                                    .addComponent(Departmentlapel))
                                .addGap(130, 130, 130)
                                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Department_ComboBox, 0, 187, Short.MAX_VALUE)
                                    .addComponent(prefered_ComboBox, 0, 187, Short.MAX_VALUE))))
                        .addContainerGap(24, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insertPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );
        insertPanelLayout.setVerticalGroup(
            insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codelapel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(code_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name_textField, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(namelapel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hours_perWeak, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namelapel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Departmentlapel)
                    .addComponent(Department_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(insertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prefered_ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Departmentlapel1))
                .addGap(79, 79, 79)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(search_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224)
                        .addComponent(btnSearch)))
                .addGap(18, 18, 18)
                .addComponent(insertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(insertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void courseTableAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_courseTableAncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_courseTableAncestorResized

     
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
     
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
    insertPanel.setVisible(false);
        
        code_textField.setEnabled(true);
        
    if (search_textField != null){
        
        CourseDto course = new CourseDto();
        course.setCode(search_textField.getText());
       if (courseobjBao.SearchCourse(course)==null)
           JOptionPane.showMessageDialog(this, "not found");
       else 
            courseTableReset(courseobjBao.SearchCourse(course));
        
        }
    else 
        courseTableReset(courseobjBao.listCourses());
    }//GEN-LAST:event_btnSearchMouseClicked

    private void insertCourseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertCourseBtnMouseClicked
        insertPanel.setVisible(true);
        updateFlag = false ;
        // clear data 
 
        
    }//GEN-LAST:event_insertCourseBtnMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
    CourseDto course = new CourseDto();
    course.setName(name_textField.getText());
    course.setHoursperWeak(Integer.parseInt(hours_perWeak.getText()));
    
   
    if(updateFlag)
    { course.setCode( courseTable.getValueAt(courseTable.getSelectedRow(), 1).toString() );
      course.setUpdate_Date(new Date(System.currentTimeMillis()) );
      course.setUpdatedBy(LoginEngine.currentUser);
     }
    else 
    { course.setUpdate_Date(new Date(System.currentTimeMillis()) );
      course.setUpdatedBy(LoginEngine.currentUser);
      course.setInertion_Date(new Date(System.currentTimeMillis()) );
      course.setInsertedBy(LoginEngine.currentUser);
      course.setCode(code_textField.getText());
     }
  
  
  
  
  
                 if (courseobjBao.saveCourse(course)) {
                          JOptionPane.showMessageDialog(this, "Course Saved ");
                          insertPanel.setVisible(false);
                          courseTableReset(courseobjBao.listCourses());

                }
                 else
                      JOptionPane.showMessageDialog(this,
                                   "Can not insert or update Ther are a problem please check entered data ");


    
    
    
    }//GEN-LAST:event_btnSaveMouseClicked

    private void deleteCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCourseBtnActionPerformed
         code_textField.setEnabled(true);
    
        // get the id value of the selected row 
        String selectedCourse=  courseTable.getValueAt(courseTable.getSelectedRow(), 1).toString() ;
       CourseDto selectedCourse_Delete = new CourseDto(); // this course i want to delete
       selectedCourse_Delete.setCode(selectedCourse);
       
       if (courseobjBao.deleteCourse(selectedCourse_Delete)) {
            JOptionPane.showMessageDialog(this , "deleted successfully");
            courseTableReset(courseobjBao.listCourses() );
        }
       
    else
           JOptionPane.showMessageDialog(this, "Can not delete may be deleted using another Course ");
      
    }//GEN-LAST:event_deleteCourseBtnActionPerformed

    private void updateCourseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateCourseBtnMouseClicked

    if (courseTable.getSelectedRow() >= 0) {


        code_textField.setText(courseTable.getValueAt(courseTable.getSelectedRow(), 1).toString());
       
        name_textField.setText(courseTable.getValueAt(courseTable.getSelectedRow(), 0).toString());
        updateFlag = true ;
        code_textField.setEnabled(false);
        insertPanel.setVisible(true);
        
        
    } else
        JOptionPane.showMessageDialog(this, "please select a course to update");
    
    
    }//GEN-LAST:event_updateCourseBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Department_ComboBox;
    private javax.swing.JLabel Departmentlapel;
    private javax.swing.JLabel Departmentlapel1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField code_textField;
    private javax.swing.JLabel codelapel;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton deleteCourseBtn;
    private javax.swing.JTextField hours_perWeak;
    private javax.swing.JButton insertCourseBtn;
    private javax.swing.JPanel insertPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_textField;
    private javax.swing.JLabel namelapel;
    private javax.swing.JLabel namelapel1;
    private javax.swing.JComboBox prefered_ComboBox;
    private javax.swing.JTextField search_textField;
    private javax.swing.JButton updateCourseBtn;
    // End of variables declaration//GEN-END:variables
    
    
    public void courseTableReset(List<CourseDto> courses) {
       
        Object[][] coursesArr = new Object[courses.size()][3];

        for (int i = 0; i < courses.size(); i++) {

            coursesArr[i][0] = courses.get(i).getName();
            coursesArr[i][1] = courses.get(i).getCode();
            coursesArr[i][2] = courses.get(i).getHoursperWeak();
           // coursesArr[i][3] = courses.get(i).getNeededLocType();

           

        }
      courseTable.setModel(new javax.swing.table.DefaultTableModel(coursesArr, new String[] {
                                                                     "Name", "code" ,
                                                                    "Hours per Weak "
            }
                                                                   ));
    }
    
    
    void listComboDepartment(List<DepartmentDto> dep) {
        for (int i = 0; i < dep.size(); i++) {
            Department_ComboBox.addItem(dep.get(i).getName());
           }
        }
}
