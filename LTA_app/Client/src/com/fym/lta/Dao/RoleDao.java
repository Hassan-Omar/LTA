package com.fym.lta.dao;


import com.fym.lta.common.LTAException;
import com.fym.lta.dto.RoleDto;

import java.util.List;

public interface RoleDao {

    // this behavior to get all Roles data
    public List<RoleDto> getAll_Roles();
    
    // this function to delete a role 
    public boolean delete_Role(String code);
    
    // this behavior to search for Role by id
    public boolean insert_Role(RoleDto role)throws LTAException;
    
    // this behavior to update Role data
    public boolean Update_Role(RoleDto role)throws LTAException;
    
    // this behavior to check Role existance
    public boolean isExist(String code);
    
    
    // this behavior to search for all Roles have the enterd letters
    public List<RoleDto> search_forRole(String code);
    
    // this return a number " id of the current user's role " 
    public int getCurrenRoleID (String username);

}
