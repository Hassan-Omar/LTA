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
     * this method to give us the current permission on  a certain screen for the current user 
     */
    public int getCurrentPermission(int screenID ) ;
    
    /**
      * this method return the list of screen available screen 
    */
    public List<ScreenDto> list_Of_AavailableScreens () ; 
    /**
      * this method return the list of screen for a certain role
    */
    public List<ScreenDto> list_Screens (int id) ; 
    
    
    public boolean delete(int screenID , int roleID);
    /**
     * this method to give us the  permission type  on  a certain screen determined by roleID , sreenID 
     */
    public int getPermissionType(int screenID , int roleID ) ;
    
    
    public List<ScreenDto> getAll_Screen(String roleCode) ; 
    
}
