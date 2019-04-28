package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.RoleDao;
import com.fym.lta.dto.RoleDto;

import java.util.List;

public class RoleBaoImp implements RoleBao {

    // create dao object to use it's method and delegate
    RoleDao roleDaoObj = new DaoFactory().createRoleDao();


    public boolean saveRole(RoleDto role) {
        boolean saveStatus = false;
        // if this data is exist in our data base only i will update it
        if (roleDaoObj.isExist(role.getCode())) { // if we are here this means we need to upgrade an existed role
            saveStatus = roleDaoObj.Update_Role(role);
        } else {
            saveStatus = roleDaoObj.insert_Role(role);
        }
        return saveStatus;
    }

    public List<RoleDto> search_forRole(String code) {
        // delegate search_forRole in dao
        if (code == null)
            return roleDaoObj.getAll_Roles();

        return roleDaoObj.search_forRole(code);
    }

    public boolean deleteRole(String code) {
        // delegate delete_Role in dao
        return roleDaoObj.delete_Role(code);
    }

    @Override
    public List<RoleDto> getAll() {
        // delegate getAll_Roles in dao
        return roleDaoObj.getAll_Roles();
    }
}
