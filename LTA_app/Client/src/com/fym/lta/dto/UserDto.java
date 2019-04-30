package com.fym.lta.dto;

import java.util.Date;

public class UserDto {   
    private int user_Id;
    private String password, userName;
    private RoleDto userRole;
    private String fName, sName, lName, familyName, email, insertedBy, updatedBy;
    private Date inertion_Date, update_Date;

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setInsertedBy(String insertedBy) {
        this.insertedBy = insertedBy;
    }

    public String getInsertedBy() {
        return insertedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setInertion_Date(Date inertion_Date) {
        this.inertion_Date = inertion_Date;
    }

    public Date getInertion_Date() {
        return inertion_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        this.update_Date = update_Date;
    }

    public Date getUpdate_Date() {
        return update_Date;
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
