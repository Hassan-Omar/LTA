package com.fym.lta.Dao;


import com.fym.lta.dto.RoleDto;

import java.util.List;

public interface RoleDao {

    // this behavior to get all Roles data

    public List<RoleDto> getAll_Roles();

    public boolean delete_Role(RoleDto Role);
    // this behavior to search for Role by id

    public boolean insert_Role(RoleDto Role);
    // this behavior to update Role data

    public boolean Update_Role(RoleDto Role);
    
    // this behavior to check Role existance

    public boolean isExist(RoleDto Role);

}
