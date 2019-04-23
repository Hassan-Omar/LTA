package com.fym.lta.Dao;

import com.fym.lta.dto.LocationDto;

import java.util.List;

public interface LocationDao {

    // this behavior to get all Location data

    public List<LocationDto> getAll_Locations();

    // this behavior to delete  Location data

    public boolean delete_Location (LocationDto Location);

    // this behavior to search for Location by id

    public boolean insert_Location(LocationDto Location);

    // this behavior to update Location data
    public boolean Update_Location(LocationDto Location);
    
    // this to check location existance 
    
    public boolean isExist(LocationDto Location);
}
