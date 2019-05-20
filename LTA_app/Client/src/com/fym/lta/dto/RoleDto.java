package com.fym.lta.dto;


import java.util.Date;
import java.util.List;

public class RoleDto {
    private int role_id;
    private String code, description, insertedBy, updatedBy;
    private List<ScreenDto> role_Screens;
    private Date inertion_Date, update_Date;
    private String permission1 ,permission2 , permission3 , permission4 ;

    public RoleDto(String code) {
        this.code = code;
    }

    public void setPermission1(String permission1) {
        this.permission1 = permission1;
    }

    public String getPermission1() {
        return permission1;
    }

    public void setPermission2(String permission2) {
        this.permission2 = permission2;
    }

    public String getPermission2() {
        return permission2;
    }

    public void setPermission3(String permission3) {
        this.permission3 = permission3;
    }

    public String getPermission3() {
        return permission3;
    }

    public void setPermission4(String permission4) {
        this.permission4 = permission4;
    }

    public String getPermission4() {
        return permission4;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }


    public int getRole_id() {
        return role_id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
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

    public void setRole_Screens(List<ScreenDto> role_Screens) {
        this.role_Screens = role_Screens;
    }

    public List<ScreenDto> getRole_Screens() {
        return role_Screens;
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

}
