
package com.fym.lta.dao;

import com.fym.lta.dto.SchedualDto;

import java.sql.SQLException;

import java.util.List;

public interface SchedualDao
{
    // this behavior to get all Scheduals data

    public List<SchedualDto> getAll_Scheduals();

    // this behavior to delete Schedual data

    public boolean delete_Schedual (String SCHEDULECODE );
    
    public boolean insert_Schedual (SchedualDto Schedual)throws SQLException;


    // this behavior to update Schedual data
    public boolean update_Schedual (SchedualDto Schedual)throws SQLException;

    public List<SchedualDto> SearchSchedual(String SCHEDULECODE);
    
    // this behavior to check Schedual existance
    public boolean isExist(String code);
    
    public List<SchedualDto>  listSchedual_inDeparts(String name);

}
