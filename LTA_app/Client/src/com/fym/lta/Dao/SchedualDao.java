package com.fym.lta.dao;

import com.fym.lta.dto.SchedualDto;

import com.fym.lta.dto.UserDto;

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
  
    public List<SchedualDto> SearchSchedual(String SCHEDULECODE);
    
    // this behavior to check Schedual existance

    public boolean isExist(String SCHEDULECODE ,String acadimcyear);
}
