package com.fym.lta.Dao;

import com.fym.lta.dto.SchedualDto;

import java.util.List;

public interface SchedualDao {
    // this behavior to get all Scheduals data

    public List<SchedualDto> getAll_Scheduals();

    // this behavior to delete Schedual data

    public boolean delete_Schedual (SchedualDto Schedual);


    // this behavior to update Schedual data

    public boolean Update_Schedual(SchedualDto Schedual);
    
    // this behavior to check Schedual existance

    public boolean isExist(SchedualDto Schedual);
}
