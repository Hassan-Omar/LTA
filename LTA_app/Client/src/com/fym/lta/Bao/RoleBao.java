package com.fym.lta.Bao;

import com.fym.lta.dto.RoleDto;

import java.util.List;

public interface RoleBao {


    /**
     * insert new Role if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean saveRole(RoleDto role);


    /**
     * search for Role 
     */

    public List<RoleDto> SearchRole(RoleDto role);


    /**
     * delete a Role 
     */

    public boolean deleteRole(RoleDto role);
}
