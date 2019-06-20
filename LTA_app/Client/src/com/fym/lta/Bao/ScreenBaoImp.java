package com.fym.lta.bao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.RoleDao;
import com.fym.lta.dao.ScreenDao;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.util.List;

public class ScreenBaoImp implements ScreenBao {

    // create dao object
    ScreenDao screeenDaoObj = new DaoFactory().createScreenDao();

    // create object of RoleDao
    RoleDao RoleDaoObj = new DaoFactory().createRoleDao();


    // delgate to screeenDaoObj methods

    @Override
    public boolean saveScreenRoles(List<ScreenDto> screens, RoleDto role) throws LTAException {
        return screeenDaoObj.insertScreenRoles(screens, role);
    }


    @Override
    public int getCurrentPermission(int screenID ) {
        // using the current username we can get it's role ID
        int roleID = RoleDaoObj.getCurrenRoleID(LoginEngine.currentUser);
        // delegate to dao method
        return screeenDaoObj.getCurrentPermission(roleID, screenID);
    }

    @Override
    public List<ScreenDto> list_Of_AavailableScreens() {

        // using the current username we can get it's role ID
        int roleID = RoleDaoObj.getCurrenRoleID(LoginEngine.currentUser);
        // delegate to dao method
        return screeenDaoObj.list_Of_AavailableScreens(roleID);
    }

    @Override
    public List<ScreenDto> list_Screens(int id) {
         return screeenDaoObj.list_Of_AavailableScreens(id);
    }

    @Override
    public boolean delete(int screenID, int roleID) {
         return screeenDaoObj.delete(screenID, roleID);
    }

    @Override
    public int getPermissionType(int screenID, int roleID) {
         return screeenDaoObj.getCurrentPermission(roleID, screenID);
    }

    @Override
    public List<ScreenDto> getAll_Screen(RoleDto role) {
         return screeenDaoObj.getAll_Screen(role);
    }
}
