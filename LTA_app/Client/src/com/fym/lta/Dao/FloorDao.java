package com.fym.lta.dao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.FloorDto;

import java.util.List;

public interface FloorDao {

    // this behavior to get all Floors data
    public List<FloorDto> getAll_Floors();
    
    
  // this behavior to search for Floor by id
   public boolean insert_Floor(FloorDto Floor)throws LTAException;
           
           
           
       // this behavior to update Floor data
    public boolean Update_Floor(FloorDto Floor);


    // this behavior to delete Floor data
    public boolean delete_Floor (FloorDto Floor);


  
    // this behavior to check Floor existance
    public boolean isExist ( FloorDto code );


    // this behavior to check Floor existance    
    public List<FloorDto> searchFloor(String code);
    
    //this behavior is to list all floors that located inside a specific building
    public List<FloorDto> getFloorsOfBuilding(int building_id);
}
