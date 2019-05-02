package com.fym.lta.dao;

import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.util.List;

public interface ScreenDao {
    // this method to assign a role permission to screens
    public boolean saveScreenRoles(List<ScreenDto> Screens, RoleDto role);
    
    // this will return a string "permissoin type " on current role , current screen  
    public String getCurrentPermission(int roleID ,int screenID);

    // this method return the list of screen available screen 
    public List<ScreenDto> list_Of_AavailableScreens (int roleID) ; 

}
