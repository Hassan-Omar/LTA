package com.fym.lta.ui;

import com.fym.lta.Bao.BaoFactory;

import com.fym.lta.Bao.DepartmentBao;

import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.DepartmentDto;

import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DepartmentInsert extends JPanel {
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JButton btnSave = new JButton();
    private JTextField idTextField = new JTextField();
    private JTextField codeTextField = new JTextField();
    private JTextField nameTextField = new JTextField();
    private JTextField homeBuilding_TextF = new JTextField();

    public DepartmentInsert() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setSize(new Dimension(673, 391));
        jLabel1.setText("Insert New Department ");
        jLabel1.setBounds(new Rectangle(90, 25, 215, 30));
        jLabel2.setText("Add ID ");
        jLabel2.setBounds(new Rectangle(50, 90, 70, 30));
        jLabel3.setText("Add Code");
        jLabel3.setBounds(new Rectangle(50, 145, 70, 30));
        jLabel4.setText("Add Name");
        jLabel4.setBounds(new Rectangle(50, 195, 70, 30));
        jLabel5.setText("Add Home Building ");
        jLabel5.setBounds(new Rectangle(50, 260, 105, 30));
        btnSave.setText("Save");
        btnSave.setBounds(new Rectangle(260, 325, 120, 30));
        btnSave.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btnSave_actionPerformed(e);
                }
            });
        idTextField.setBounds(new Rectangle(200, 90, 185, 35));
        codeTextField.setBounds(new Rectangle(200, 140, 185, 40));
        nameTextField.setBounds(new Rectangle(200, 190, 185, 40));
        homeBuilding_TextF.setBounds(new Rectangle(200, 255, 185, 35));
        this.add(homeBuilding_TextF, null);
        this.add(nameTextField, null);
        this.add(codeTextField, null);
        this.add(idTextField, null);
        this.add(btnSave, null);
        this.add(jLabel5, null);
        this.add(jLabel4, null);
        this.add(jLabel3, null);
        this.add(jLabel2, null);
        this.add(jLabel1, null);
    }

    private DepartmentBao business = new BaoFactory().CreateDepartmentBao();
    DepartmentDto D = new  DepartmentDto();
    BuildingDto B= new BuildingDto();
    private void btnSave_actionPerformed(ActionEvent e) {
        
        D.setDepartment_id(Integer.parseInt(idTextField.getText()));
        D.setCode(codeTextField.getText());
        D.setName(nameTextField.getText());
        D.setHomebuilding(B);
        business.saveDepartment(D);
        
               }
}
