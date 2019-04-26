package com.fym.lta.ui;

import com.fym.lta.bao.BaoFactory;
import com.fym.lta.bao.CourseBao;
import com.fym.lta.bao.LocationTypeBao;
import com.fym.lta.dto.CourseDto;
import com.fym.lta.dto.LocationTypeDto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CourseInsert extends JPanel {
    LocationTypeBao locTypeBusiness = new BaoFactory().createLocationTypeBao();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JLabel jLabel7 = new JLabel();
    private JTextField id_TextField = new JTextField();
    private JTextField code_TextField = new JTextField();
    private JTextField name_TextField = new JTextField();
    private JTextField dep_TextField = new JTextField();
    private JButton jButton1 = new JButton();
    private JComboBox jComboBox1 = new JComboBox();
    private JComboBox jComboBox2 = new JComboBox();
    private JLabel jLabel8 = new JLabel();
    private JLabel jLabel9 = new JLabel();
    private JLabel jLabel10 = new JLabel();
    private JLabel jLabel11 = new JLabel();
    
    private int id;
    private String code;
    private String name ; 
    private String department ;


    public CourseInsert() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(679, 435));
        jLabel1.setText("Insert New Subject");
        jLabel1.setBounds(new Rectangle(185, 5, 220, 55));
        jLabel2.setText("ID");
        jLabel2.setBounds(new Rectangle(15, 70, 180, 45));
        jLabel3.setText("Code");
        jLabel3.setBounds(new Rectangle(15, 120, 180, 45));
        jLabel4.setText("Name");
        jLabel4.setBounds(new Rectangle(15, 165, 180, 45));
        jLabel5.setText("Lecture Time");
        jLabel5.setBounds(new Rectangle(10, 220, 180, 45));
        jLabel6.setText("Department");
        jLabel6.setBounds(new Rectangle(10, 275, 180, 45));
        jLabel7.setText("Preferred location type");
        jLabel7.setBounds(new Rectangle(10, 325, 180, 45));
        id_TextField.setBounds(new Rectangle(195, 75, 275, 40));
        id_TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                id_TextField_actionPerformed(e);
            }
        });
        code_TextField.setBounds(new Rectangle(195, 130, 275, 30));
        code_TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                code_TextField_actionPerformed(e);
            }
        });
        name_TextField.setBounds(new Rectangle(195, 175, 275, 30));
        name_TextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name_TextField_actionPerformed(e);
            }
        });
        dep_TextField.setBounds(new Rectangle(195, 280, 205, 30));
        dep_TextField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dep_TextField_actionPerformed(e);
                }
            });
        jButton1.setText("Save");
        jButton1.setBounds(new Rectangle(245, 400, 130, 30));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jComboBox1.setBounds(new Rectangle(195, 225, 280, 30));
        jComboBox1.addItem("One period");
        jComboBox1.addItem("Two period");
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jComboBox1_actionPerformed(e);
            }
        });
        jComboBox2.setBounds(new Rectangle(195, 330, 205, 30));
        jLabel8.setBounds(new Rectangle(420, 70, 110, 30));
        jLabel8.setFont(new Font("Tahoma", 2, 17));
        jLabel8.setForeground(Color.red);
        jLabel9.setBounds(new Rectangle(425, 115, 110, 30));
        jLabel9.setFont(new Font("Tahoma", 2, 17));
        jLabel9.setForeground(Color.red);
        jLabel10.setBounds(new Rectangle(425, 160, 110, 30));
        jLabel10.setFont(new Font("Tahoma", 2, 17));
        jLabel10.setForeground(Color.red);
        jLabel11.setBounds(new Rectangle(420, 240, 110, 30));
        jLabel11.setFont(new Font("Tahoma", 2, 17));
        jLabel11.setForeground(Color.red);
        jComboBox2.addItem("Labaratory");
        jComboBox2.addItem("Class Room");
        this.add(jLabel11, null);
        this.add(jLabel10, null);
        this.add(jLabel9, null);
        this.add(jLabel8, null);
        this.add(jComboBox2, null);
        this.add(jComboBox1, null);
        this.add(jButton1, null);
        this.add(dep_TextField, null);
        this.add(name_TextField, null);
        this.add(code_TextField, null);
        this.add(id_TextField, null);
        this.add(jLabel7, null);
        this.add(jLabel6, null);
        this.add(jLabel5, null);
        this.add(jLabel4, null);
        this.add(jLabel3, null);
        this.add(jLabel2, null);
        this.add(jLabel1, null);
    }

    private CourseBao business = new BaoFactory().createCourseBao();
     CourseDto S = new CourseDto();
     LocationTypeDto locType = new LocationTypeDto();
    private void jButton1_actionPerformed(ActionEvent e) {
        S.setCourse_id(Integer.parseInt(id_TextField.getText()));
        S.setCode(code_TextField.getText());
        S.setName(name_TextField.getText());
        List<LocationTypeDto> locTypeList =  locTypeBusiness.searchLocationType(locType);
        jComboBox2.addItem(locTypeList);// this can cause error 
        S.setEnteredNeededSlots(1+jComboBox1.getSelectedIndex());
        locType.setLocationType_id(jComboBox2.getSelectedIndex());
        locTypeList.add(locType);
        S.setNeededLocType(locTypeList );
        business.saveCourse(S);
    }

    private void lectTime_TextField_actionPerformed(ActionEvent e) {
    }

    private void dep_TextField_actionPerformed(ActionEvent e) {
        department = code_TextField.getText();
        if (code.equals(""))
        {
            jLabel10.setText("Invalid format");
        }
        else   {
                jLabel10.setText("  ");
               }     
    }

    private void jComboBox1_actionPerformed(ActionEvent e) {
        
        
    }

    private void id_TextField_actionPerformed(ActionEvent e) {
        try {
            id = Integer.parseInt(id_TextField.getText());
            jLabel8.setText("  ");
        } catch (NumberFormatException e1) {
            jLabel8.setText("Invalid format");
        }
       
    }

    private void code_TextField_actionPerformed(ActionEvent e) {
    code = code_TextField.getText();
    if (code.equals(""))
    {
        jLabel9.setText("Invalid format");
    }
    else   {
            jLabel9.setText("  ");
           }       
        
    }

    private void name_TextField_actionPerformed(ActionEvent e) {
        name = name_TextField.getText();
        if (name.equals(""))
        {
            jLabel10.setText("Invalid format");
        }
        else   {
                jLabel10.setText("  ");
               }       
            
        
    }
}
