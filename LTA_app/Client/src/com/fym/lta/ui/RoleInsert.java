
package com.fym.lta.ui;

import com.fym.lta.Bao.BaoFactory;
import com.fym.lta.Bao.RoleBao;

import com.fym.lta.dto.RoleDto;

import com.fym.lta.dto.UserDto;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RoleInsert extends JPanel {
    private JTextArea roleDescription = new JTextArea();
    private JTextField roleCode = new JTextField();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JButton doneBTN = new JButton();
    private JLabel jLabel5 = new JLabel();
    private int id;
    private RoleBao role = new BaoFactory().CreateRoleBao();
    private String permission;
    private JPanel jPanel1 = new JPanel();
    private JCheckBox viewCheckBox = new JCheckBox();
    private JCheckBox updateCheckBox = new JCheckBox();
    private JCheckBox deleteCheckBox = new JCheckBox();
    private JCheckBox insertCheckBox = new JCheckBox();

    public RoleInsert() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void jbInit() throws Exception {
        this.setLayout(null);
        this.setSize(new Dimension(808, 522));
        roleDescription.setBounds(new Rectangle(185, 155, 250, 185));
        roleCode.setBounds(new Rectangle(185, 95, 250, 35));
        jLabel3.setText("Description");
        jLabel3.setBounds(new Rectangle(20, 175, 135, 35));
        jLabel3.setFont(new Font("Tahoma", 1, 15));
        jLabel2.setText("Code");
        jLabel2.setBounds(new Rectangle(20, 95, 135, 35));
        jLabel2.setFont(new Font("Tahoma", 1, 15));
        doneBTN.setText("Done");
        doneBTN.setBounds(new Rectangle(610, 350, 95, 50));
        doneBTN.setFont(new Font("Tahoma", 1, 14));
        doneBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                doneBTN_actionPerformed(e);
            }
        });
        jLabel5.setText(" ");
        jLabel5.setBounds(new Rectangle(465, 25, 135, 35));
        jLabel5.setFont(new Font("Tahoma", 2, 15));
        jLabel5.setForeground(Color.red);
        jPanel1.setBounds(new Rectangle(500, 90, 205, 250));
        jPanel1.setLayout(null);
        jPanel1.setBorder(BorderFactory.createTitledBorder("Role"));
        viewCheckBox.setText("View");
        viewCheckBox.setBounds(new Rectangle(5, 35, 190, 40));
        viewCheckBox.setFont(new Font("Tahoma", 1, 15));
        updateCheckBox.setText("Update");
        updateCheckBox.setBounds(new Rectangle(5, 90, 195, 40));
        updateCheckBox.setFont(new Font("Tahoma", 1, 15));
        deleteCheckBox.setText("Delete");
        deleteCheckBox.setBounds(new Rectangle(5, 145, 185, 40));
        deleteCheckBox.setFont(new Font("Tahoma", 1, 15));
        insertCheckBox.setText("Insert");
        insertCheckBox.setBounds(new Rectangle(5, 200, 190, 40));
        insertCheckBox.setFont(new Font("Tahoma", 1, 15));
        jPanel1.add(insertCheckBox, null);
        jPanel1.add(deleteCheckBox, null);
        jPanel1.add(updateCheckBox, null);
        jPanel1.add(viewCheckBox, null);
        this.add(jPanel1, null);
        this.add(jLabel5, null);
        this.add(doneBTN, null);
        this.add(jLabel2, null);
        this.add(jLabel3, null);
        this.add(roleCode, null);
        this.add(roleDescription, null);


    }


    private void doneBTN_actionPerformed(ActionEvent e) {
        RoleDto myrole = new RoleDto("");
        myrole.setRole_id(id);
        myrole.setCode((roleCode.getText()));
        myrole.setDescription(roleDescription.getText());

        // take the permission type
        if (viewCheckBox.isSelected()) {
            permission += "view + ";
        }

        if (updateCheckBox.isSelected()) {
            permission += "update + ";
        }

        if (deleteCheckBox.isSelected()) {
            permission += "delete + ";
        }

        if (insertCheckBox.isSelected()) {
            permission += "insert + ";
        }
        myrole.setPermissontype(permission);

        boolean statuse = role.saveRole(myrole);
        if (statuse) {
            JOptionPane.showMessageDialog(this, " Done Successfully ");
        } else
            JOptionPane.showMessageDialog(this,
                                          "Can not insert or update Ther are a problem please check entered data ");

    }

}


