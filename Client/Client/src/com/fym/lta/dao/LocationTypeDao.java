package com.fym.lta.dao;

import com.fym.lta.common.LTAException;
import com.fym.lta.dto.LocationTypeDto;

import java.util.List;

public interface LocationTypeDao {

    // this behavior to get all LocationType data.....
    public List<LocationTypeDto> getAll_LocationTypes();


    
     // this behavior to insert new Location Type......    
     public boolean insert_LocationType(LocationTypeDto LocationType)throws LTAException;
 
         
    //this behavior to update LocationType data........
    public boolean Update_LocationType(LocationTypeDto LocationType);


  
        
    // this behavior to delete  LocationType data.......
    public boolean delete_LocationType (LocationTypeDto LocationType);
    
    
    
    // this behavior to check LocationType existance...... 
    public boolean isExist(LocationTypeDto LocationType);    

  
    // this behavior to check Floor existance        
    public List<LocationTypeDto> SearchLocationType(String Code);
}
