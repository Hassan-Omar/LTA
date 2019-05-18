package com.fym.lta.dao;

import com.fym.lta.dto.EquipmentDto;
import com.fym.lta.dto.LocationDto;

import com.fym.lta.dto.LocationTypeDto;

import java.util.List;

public interface LocationDao {

    // this behavior to get all Location data

    public List<LocationDto> getAll_Locations();
    
    // this behavior to search for Location by code
    
    public List<LocationDto> searchLocations(String code);
    
    // this behavior to delete  Location data

    public boolean delete_Location(LocationDto Location);

    // this behavior to insert Location 

    public boolean insert_Location(LocationDto Location);

    // this behavior to update Location data
    public boolean Update_Location(LocationDto Location);

    // this to check location existance

    public boolean isExist(LocationDto Location);
    
    //this to filter location types 
   public List<LocationDto> filter(String LocationTypeCode,String BuildingCode);

    //this behavior to save list of Equipment in the location
    public boolean save_Equipment(List<EquipmentDto> equipment,LocationDto location);
}
