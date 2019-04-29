package com.fym.lta.bao;

import com.fym.lta.dto.RoleDto;
import com.fym.lta.dto.ScreenDto;

import java.util.List;

public interface ScreenBao {


    /**
     * insert a permission  to an exist role to accesss the screens
     */
    public boolean saveScreenRoles(List<ScreenDto> screens ,RoleDto role );




}
