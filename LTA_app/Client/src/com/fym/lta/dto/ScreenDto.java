package com.fym.lta.dto;

import java.util.List;

public class ScreenDto {
    private int Screen_id;
    private String Description;
    private List<RoleDto> Role_Screens;




    public void setScreen_id(int Screen_id) {
        this.Screen_id = Screen_id;
    }

    public int getScreen_id() {
        return Screen_id;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getDescription() {
        return Description;
    }

    public void setRole_Screens(List<RoleDto> Role_Screens) {
        this.Role_Screens = Role_Screens;
    }

    public List<RoleDto> getRole_Screens() {
        return Role_Screens;
    }
}
