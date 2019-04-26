package com.fym.lta.dao;

import com.fym.lta.dto.FloorDto;

import java.util.List;

public interface FloorDao {

    // this behavior to get all Floors data

    public List<FloorDto> getAll_Floors();

    // this behavior to delete Floor data

    public boolean delete_Floor (FloorDto Floor);

    // this behavior to search for Floor by id

    public boolean insert_Floor(FloorDto Floor);

    // this behavior to update Floor data

    public boolean Update_Floor(FloorDto Floor);
    
    // this behavior to check Floor existance
    public boolean isExist (FloorDto Floor);
}
