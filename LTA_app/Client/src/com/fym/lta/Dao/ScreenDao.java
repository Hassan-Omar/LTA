package com.fym.lta.dao;

import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.util.List;

public interface ScreenDao {
    // this method to assign a role permission to screens
    public boolean saveScreenRoles(List<ScreenDto> Screens, RoleDto role);

}
