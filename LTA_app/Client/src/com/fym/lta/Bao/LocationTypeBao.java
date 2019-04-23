package com.fym.lta.Bao;

import com.fym.lta.dto.LocationTypeDto;

import java.util.List;

public interface LocationTypeBao {
    /**
     * insert new LocationType if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean saveLocationType(LocationTypeDto LocationType);


   


    /**
     * search for LocationType  
     * i
     */
    public List<LocationTypeDto> searchLocationType(LocationTypeDto LocationType);


    /**
     * delete a LocationType 
     */
    public boolean deleteLocationType (LocationTypeDto LocationType);
}
