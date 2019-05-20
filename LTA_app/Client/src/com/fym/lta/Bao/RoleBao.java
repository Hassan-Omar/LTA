package com.fym.lta.bao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.RoleDto;

import java.util.List;

public interface RoleBao {


    /**
     * insert new Role if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean saveRole(RoleDto role)throws LTAException;


    /**
     * search for a certain Role 
     */

    public List<RoleDto> search_forRole(String code);


    /**
     * return all Role stored in DB
     */

    public List<RoleDto> getAll();

    /**
     * delete a Role 
     */

    public boolean deleteRole(String code);
}
