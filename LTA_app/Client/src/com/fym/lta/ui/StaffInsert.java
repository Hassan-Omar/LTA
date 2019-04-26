package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.EmployeeBao;
import com.fym.lta.dto.EmployeeDto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StaffInsert extends JPanel {
    public int getStaffUpdateId() {
        return staffUpdateId;
    }
    private int staffUpdateId = 0;

    public void setStaffUpdateId(int staffUpdateId) {
        this.staffUpdateId = staffUpdateId;
    }
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JTextField department_TextField = new JTextField();
    private JComboBox position_compBox = new JComboBox();
    private JButton btnInsertStaffM = new JButton();
    private JLabel jLabel6 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField fname_TextField = new JTextField();
    private JLabel jLabel7 = new JLabel();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JLabel jLabel10 = new JLabel();
    private JTextField sname_TextField = new JTextField();
    private JTextField thirdname_TextField = new JTextField();
    private JTextField familyname_TextField = new JTextField();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel11 = new JLabel();
    private JLabel jLabel12 = new JLabel();

    private int id;
    private String name;
    private String department;

    public StaffInsert() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout(null);
        this.setSize(new Dimension(690, 351));
        jLabel1.setText("Insert new Staff Member");
        jLabel1.setBounds(new Rectangle(215, 5, 225, 55));
        jLabel4.setText("Department");
        jLabel4.setBounds(new Rectangle(25, 180, 115, 35));
        jLabel5.setText("Position ");
        jLabel5.setBounds(new Rectangle(35, 240, 115, 35));
        department_TextField.setBounds(new Rectangle(115, 185, 172, 30));
        department_TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                department_TextField_actionPerformed(e);
            }
        });
        position_compBox.setBounds(new Rectangle(115, 240, 160, 25));
        position_compBox.addItem("Professor");
        position_compBox.addItem("Associate Professor");
        position_compBox.addItem("Assistant Professor");
        position_compBox.addItem("Assistant lecturer");
        position_compBox.addItem("Demonstrator");
        btnInsertStaffM.setText("Save");
        btnInsertStaffM.setBounds(new Rectangle(265, 290, 110, 30));
        btnInsertStaffM.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jButton1_actionPerformed(e);
            }
        });
        jLabel6.setText("Name");
        jLabel6.setBounds(new Rectangle(35, 120, 115, 35));
        fname_TextField.setBounds(new Rectangle(115, 125, 100, 30));
        fname_TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fname_TextField_actionPerformed(e);
            }
        });
        jLabel7.setText("First Name");
        jLabel7.setBounds(new Rectangle(115, 95, 115, 35));
        jLabel8.setText("Second Name");
        jLabel8.setBounds(new Rectangle(255, 95, 115, 35));
        jLabel9.setText("third Name");
        jLabel9.setBounds(new Rectangle(380, 95, 115, 35));
        jLabel10.setText("family Name");
        jLabel10.setBounds(new Rectangle(480, 95, 115, 35));
        sname_TextField.setBounds(new Rectangle(230, 125, 100, 30));
        sname_TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sname_TextField_actionPerformed(e);
            }
        });
        thirdname_TextField.setBounds(new Rectangle(350, 125, 100, 30));
        thirdname_TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                thirdname_TextField_actionPerformed(e);
            }
        });
        familyname_TextField.setBounds(new Rectangle(470, 125, 100, 30));
        familyname_TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                familyname_TextField_actionPerformed(e);
            }
        });
        jLabel3.setBounds(new Rectangle(325, 55, 100, 30));
        jLabel3.setFont(new Font("Tahoma", 2, 17));
        jLabel3.setForeground(Color.red);
        jLabel11.setBounds(new Rectangle(585, 125, 75, 30));
        jLabel11.setFont(new Font("Tahoma", 2, 17));
        jLabel11.setForeground(Color.red);
        jLabel12.setBounds(new Rectangle(330, 185, 100, 30));
        jLabel12.setFont(new Font("Tahoma", 2, 17));
        jLabel12.setForeground(Color.red);
        this.add(jLabel12, null);
        this.add(jLabel11, null);
        this.add(jLabel3, null);
        this.add(familyname_TextField, null);
        this.add(thirdname_TextField, null);
        this.add(sname_TextField, null);
        this.add(jLabel10, null);
        this.add(jLabel9, null);
        this.add(jLabel8, null);
        this.add(jLabel7, null);
        this.add(fname_TextField, null);
        this.add(jLabel6, null);
        this.add(btnInsertStaffM, null);
        this.add(position_compBox, null);
        this.add(department_TextField, null);
        this.add(jLabel5, null);
        this.add(jLabel4, null);
        this.add(jLabel1, null);
    }


    private EmployeeBao business = new BaoFactory().createemployeeBao();
    EmployeeDto S = new EmployeeDto();

    private void jButton1_actionPerformed(ActionEvent e) {
        int index = position_compBox.getSelectedIndex();
        if (index == 0)
            S.setCareerDgree("employee");
        else if (index == 1)
            S.setCareerDgree("doctro");


        S.setFName(fname_TextField.getText());
        S.setFamilyName(name = familyname_TextField.getText());
        S.setSName(sname_TextField.getText());
        S.setThName(thirdname_TextField.getText());
        //   S.setFamilyName(familyname_TextField.getText());
        //S.setEmail("hadele this");

boolean status = false ;
        if (staffUpdateId != 0) {
            S.setEmp_id(this.getStaffUpdateId());
           status =  business.updateEmployee(S);
        } else
         status =  business.insertEmployee(S);
        
        
        
        if (status)
            JOptionPane.showMessageDialog(null, "Done Successfully ") ;          
        else
        JOptionPane.showMessageDialog(null, "unSuccessfull ") ;      
    }


    private void fname_TextField_actionPerformed(ActionEvent e) {
        name = fname_TextField.getText();
        if (name.equals("")) {
            jLabel10.setText("Invalid format");
        } else {
            jLabel10.setText("  ");
        }
    }

    private void sname_TextField_actionPerformed(ActionEvent e) {
        name = sname_TextField.getText();
        if (name.equals("")) {
            jLabel10.setText("Invalid format");
        } else {
            jLabel10.setText("  ");
        }
    }

    private void thirdname_TextField_actionPerformed(ActionEvent e) {
        name = thirdname_TextField.getText();
        if (name.equals("")) {
            jLabel10.setText("Invalid format");
        } else {
            jLabel10.setText("  ");
        }
    }

    private void familyname_TextField_actionPerformed(ActionEvent e) {
        name = familyname_TextField.getText();
        if (name.equals("")) {
            jLabel10.setText("Invalid format");
        } else {
            jLabel10.setText("  ");
        }

    }

    private void department_TextField_actionPerformed(ActionEvent e) {
        department = department_TextField.getText();
        if (name.equals("")) {
            jLabel10.setText("Invalid format");
        } else {
            jLabel10.setText("  ");
        }

    }
}
