package com.fym.lta.bao;

import com.fym.lta.dao.DaoFactory;
import com.fym.lta.dao.ScreenDao;
import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.util.List;

public class ScreenBaoImp implements ScreenBao {

    // create dao object
    ScreenDao screeenDaoObj = new DaoFactory().createScreenDao();

    public boolean saveScreenRoles(List<ScreenDto> screens, RoleDto role) {
        return screeenDaoObj.saveScreenRoles(screens, role);
    }
}
