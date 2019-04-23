package com.fym.lta.dto;

import java.util.Date;

public class UserDto {   
    private int user_Id;
    private String password, userName;
    private RoleDto userRole;
    private String fName, sName, lName, familyName, email, INSERTED_BY, UPDATED_BY;
    private Date INSERTION_DATE, UPDATE_DATE;

    public void setINSERTED_BY(String INSERTED_BY) {
        this.INSERTED_BY = INSERTED_BY;
    }

    public String getINSERTED_BY() {
        return INSERTED_BY;
    }

    public void setUPDATED_BY(String UPDATED_BY) {
        this.UPDATED_BY = UPDATED_BY;
    }

    public String getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setINSERTION_DATE(Date INSERTION_DATE) {
        this.INSERTION_DATE = INSERTION_DATE;
    }

    public Date getINSERTION_DATE() {
        return INSERTION_DATE;
    }

    public void setUPDATE_DATE(Date UPDATE_DATE) {
        this.UPDATE_DATE = UPDATE_DATE;
    }

    public Date getUPDATE_DATE() {
        return UPDATE_DATE;
    }
    

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSName() {
        return sName;
    }

    public void setLName(String thName) {
        this.lName = thName;
    }

    public String getLName() {
        return lName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setuser_Id(int User_id) {
        this.user_Id = User_id;
    }

    public int getuser_Id() {
        return user_Id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserRole(RoleDto UserRole) {
        this.userRole = UserRole;
    }

    public RoleDto getUserRole() {
        return userRole;
    }

}
