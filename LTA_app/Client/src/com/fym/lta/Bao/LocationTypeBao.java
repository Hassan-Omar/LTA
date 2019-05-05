package com.fym.lta.bao;

import com.fym.lta.dto.BuildingDto;
import com.fym.lta.dto.LocationTypeDto;

import java.util.List;

public interface LocationTypeBao {
    /**
     * insert new LocationType if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean save(LocationTypeDto LocationType);
///////////////////////////////////////////////////////////////////////////
    /**
     * search for Location Type
     */

    public List<LocationTypeDto> SearchLocationType(String Code);
///////////////////////////////////////////////////////////////////////////
    /**
     * return all Location Type from db
     */

    public List<LocationTypeDto> listLocationType(); 

////////////////////////////////////////////////////////////////////////////
    /**
     * delete a LocationType 
     */
    public boolean deleteLocationType (LocationTypeDto LocationType);


    public List<LocationTypeDto> searchLocationType(LocationTypeDto locType);



}
