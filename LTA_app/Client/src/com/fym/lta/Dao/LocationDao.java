package com.fym.lta.dao;

import com.fym.lta.dto.LocationDto;

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

    
   //this to return list of available Rooms at each department
    public List<LocationDto> getAvailableRoom(String depName);
    
    
    public boolean insertLocationSlot(LocationDto loc) ;
    
    public boolean updateLocationSlot(LocationDto loc) ;
    
    public boolean isSlotAssigned(LocationDto loc) ;
    
    
    
    
    
}
