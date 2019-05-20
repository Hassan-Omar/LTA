package com.fym.lta.bao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.util.List;

public interface ScreenBao {


    /**
     * insert a permission  to an exist role to accesss the screens
     */
    public boolean saveScreenRoles(List<ScreenDto> screens ,RoleDto role )throws LTAException;


    /**
     * this method to give us the current permission on  a certain screen 
     */
    public String getCurrentPermission(int screenID) ;
    
    /**
      * this method return the list of screen available screen 
    */
    public List<ScreenDto> list_Of_AavailableScreens () ; 
}
