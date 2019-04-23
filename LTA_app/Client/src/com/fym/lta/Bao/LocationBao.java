package com.fym.lta.Bao;

import com.fym.lta.dto.LocationDto;

public interface LocationBao {
    /**
     * insert new Location if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean saveLocation(LocationDto Location);


    /**
     * search for Location 
     */

    public LocationDto SearchLocation(String code);


    /**
     * delete a Location 
     */
    public boolean deleteLocation(LocationDto Location);
}
