package com.fym.lta.dto;


import java.util.List;

public class RoleDto {
    private int Role_id;
    private String code, Description, permissontype;
    private List<ScreenDto> Role_Screens;


    public RoleDto(String permissontype) {
        super();
        this.permissontype = permissontype;
    }

    public RoleDto(int Role_id) {
        super();
        this.Role_id = Role_id;
    }

    public void setRole_id(int Role_id) {
        this.Role_id = Role_id;
    }

    public int getRole_id() {
        return Role_id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public void setRole_Screens(List<ScreenDto> Role_Screens) {
        this.Role_Screens = Role_Screens;
    }

    public List<ScreenDto> getRole_Screens() {
        return Role_Screens;
    }

    public void setPermissontype(String permissontype) {
        this.permissontype = permissontype;
    }

    public String getPermissontype() {
        return permissontype;
    }
}
