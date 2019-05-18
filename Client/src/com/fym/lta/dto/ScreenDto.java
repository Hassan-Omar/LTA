package com.fym.lta.dto;


public class ScreenDto
{
    private int Screen_id;
    private String Description;
    
    private RoleDto Role_Screen;

    public void setRole_Screen(RoleDto Role_Screen) {
        this.Role_Screen = Role_Screen;
    }

    public RoleDto getRole_Screen() {
        return Role_Screen;
    }

    public ScreenDto(int i) {
        setScreen_id(i);
    }


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


}
