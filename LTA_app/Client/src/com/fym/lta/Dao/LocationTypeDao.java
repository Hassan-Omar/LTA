package com.fym.lta.dao;

import com.fym.lta.dto.LocationTypeDto;

import java.util.List;

public interface LocationTypeDao {

    // this behavior to get all LocationType data

    public List<LocationTypeDto> getAll_LocationTypes();


    // this behavior to delete  LocationType data

    public boolean delete_LocationType (LocationTypeDto LocationType);
    // this behavior to search for LocationType by id

    public boolean insert_Location(LocationTypeDto LocationType);

    // this behavior to update LocationType data

    public boolean Update_LocationType(LocationTypeDto LocationType);
    
    // this behavior to check LocationType existance
    
    public boolean isExist(LocationTypeDto LocationType);
    

}
