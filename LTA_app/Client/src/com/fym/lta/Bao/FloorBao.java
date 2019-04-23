package com.fym.lta.Bao;

import com.fym.lta.dto.FloorDto;

import java.util.List;


public interface FloorBao {
    /**
     * insert new Floor if it doesn't exists
     * otherwise it updates the exis. once
     */
    public boolean saveFloor(FloorDto Floor);


    /**
     * search for Floor 
     */

    public List<FloorDto> SearchFloor(String floorNumber);


    /**
     * delete a Floor
     */
    public boolean deleteFloor(FloorDto floor);
}
